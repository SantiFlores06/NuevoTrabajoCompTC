package com.compilador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.gui.TreeViewer;
import javax.swing.*;
import java.util.Arrays;

import com.compilador.generacion.CodigoVisitor;

public class App {
    // Códigos ANSI para colores
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, proporciona la ruta del archivo a analizar.");
            return;
        }

        String inputFilePath = args[0];
        System.out.println("Analizando archivo: " + inputFilePath + "\n");

        try {
            // Leer el archivo de entrada
            String codigoFuente = new String(Files.readAllBytes(Paths.get(inputFilePath)));

            // Análisis léxico
            System.out.println("=== ANÁLISIS LÉXICO ===");
            MiniLenguajeLexer lexer = new MiniLenguajeLexer(CharStreams.fromString(codigoFuente));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            System.out.println("TIPO                 LEXEMA                         LÍNEA      COLUMNA   ");
            System.out.println("-------------------------------------------------------------------");
            tokens.fill(); // Forzar consumo de todos los tokens
            tokens.getTokens().forEach(token -> {
                // Imprime todos los tokens, incluso WS y comentarios, para depuración
                System.out.printf("%-20s %-30s %-10d %-10d%n",
                    lexer.getVocabulary().getSymbolicName(token.getType()),
                    token.getText(),
                    token.getLine(),
                    token.getCharPositionInLine());
            });
            System.out.println();
            System.out.println("? Análisis léxico completado sin errores.\n");

            // Análisis sintáctico
            System.out.println("=== ANÁLISIS SINTÁCTICO ===");
            MiniLenguajeParser parser = new MiniLenguajeParser(tokens);
            parser.removeErrorListeners();
            List<String> erroresSintacticos = new ArrayList<>();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                        int line, int charPositionInLine, String msg, RecognitionException e) {
                    erroresSintacticos.add(String.format("Error sintáctico en línea %d, posición %d: %s",
                        line, charPositionInLine, msg));
                }
            });

            // Generar el árbol sintáctico
            ParseTree tree = parser.programa();

            // Mostrar árbol sintáctico
            System.out.println("Representación textual del árbol sintáctico:");
            System.out.println(tree.toStringTree(parser));
            System.out.println();

            // Mostrar ventana gráfica del árbol sintáctico
            SwingUtilities.invokeLater(() -> {
                TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
                JFrame frame = new JFrame("Árbol Sintáctico");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JScrollPane scrollPane = new JScrollPane(viewer);
                frame.add(scrollPane);
                frame.setSize(1000, 700);
                frame.setVisible(true);
            });

            // Mostrar errores sintácticos si los hay
            if (!erroresSintacticos.isEmpty()) {
                System.out.println("? ERRORES SINTÁCTICOS:");
                erroresSintacticos.forEach(error -> System.out.println("   " + error));
            } else {
                System.out.println("? Análisis sintáctico completado sin errores.\n");
            }

            // Análisis semántico
            System.out.println("=== TABLA DE SÍMBOLOS ===");
            SimbolosListener listener = new SimbolosListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);
            // Imprimir tabla de símbolos con formato personalizado
            imprimirTablaSimbolos(listener);

            // Mostrar errores y advertencias semánticas
            List<String> erroresSemanticos = listener.getErroresCriticos();
            List<String> warningsSemanticos = listener.getAdvertencias();

            if (!erroresSemanticos.isEmpty()) {
                System.out.println("\n? ERRORES SEMÁNTICOS:");
                erroresSemanticos.forEach(error -> System.out.println("   " + error));
            }

            if (!warningsSemanticos.isEmpty()) {
                System.out.println("\n? ADVERTENCIAS SEMÁNTICAS:");
                warningsSemanticos.forEach(warning -> System.out.println("   " + warning));
            }

            if (erroresSemanticos.isEmpty() && warningsSemanticos.isEmpty()) {
                System.out.println("? Análisis semántico completado sin errores.\n");
            }

            // Mostrar resumen de errores
            if (!erroresSintacticos.isEmpty() || !erroresSemanticos.isEmpty()) {
                System.out.println("=== RESUMEN DE ERRORES ===");
                System.out.println("Errores sintácticos: " + erroresSintacticos.size());
                System.out.println("Errores semánticos: " + erroresSemanticos.size());
                System.out.println("Advertencias: " + warningsSemanticos.size());
            }

            // === CÓDIGO INTERMEDIO ===
            CodigoVisitor generador = new CodigoVisitor();
            generador.visit(tree);
            System.out.println("=== CÓDIGO INTERMEDIO ===");
            generador.obtenerCodigo().forEach(System.out::println);
            // Guardar el código intermedio en un archivo de texto
            try (PrintWriter out = new PrintWriter(new FileWriter("codigo_intermedio.txt"))) {
                generador.obtenerCodigo().forEach(out::println);
            } catch (Exception e) {
                System.err.println("Error al guardar el código intermedio: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Imprime la tabla de símbolos con el formato solicitado
    private static void imprimirTablaSimbolos(SimbolosListener listener) {
        // Encabezado
        System.out.printf("%-15s %-10s %-15s %-10s %-10s %-15s %-20s\n", 
            "NOMBRE", "TIPO", "CATEGORÍA", "LÍNEA", "COLUMNA", "ÁMBITO", "PARÁMETROS");
        System.out.println("--------------------------------------------------------------------------------------------");
        // Obtener la tabla de símbolos global
        TablaSimbolos tabla = listener.getTablaSimbolos();
        Map<String, String> prototipos = listener.getPrototiposFunciones();
        // Recorrer símbolos globales (funciones y variables globales)
        for (TablaSimbolos.Simbolo simbolo : tabla.getSimbolos()) {
            // Si es función, mostrar sus parámetros
            if (simbolo.getTipo().equals("funcion")) {
                // Extraer parámetros de la función desde el prototipo
                String parametros = prototipos.get(simbolo.getNombre());
                String paramsStr = "";
                if (parametros != null && parametros.contains("(")) {
                    paramsStr = parametros.substring(parametros.indexOf('(') + 1, parametros.indexOf(')'));
                }
                System.out.printf("%-15s %-10s %-15s %-10s %-10s %-15s %-20s\n",
                    simbolo.getNombre(),
                    simbolo.getValor(), // tipo de retorno
                    "funcion",
                    "-", "-", "global", "[" + paramsStr + "]");
                // Buscar parámetros en el scope de la función
                TablaSimbolos scopeFuncion = buscarScopeFuncion(tabla, simbolo.getNombre());
                if (scopeFuncion != null) {
                    for (TablaSimbolos.Simbolo param : scopeFuncion.getSimbolos()) {
                        if (param.getValor().equals("parametro")) {
                            System.out.printf("%-15s %-10s %-15s %-10s %-10s %-15s %-20s\n",
                                param.getNombre(),
                                param.getTipo(),
                                "parametro",
                                "-", "-", simbolo.getNombre(), "");
                        }
                    }
                }
            } else {
                // Variable global
                System.out.printf("%-15s %-10s %-15s %-10s %-10s %-15s %-20s\n",
                    simbolo.getNombre(),
                    simbolo.getTipo(),
                    "variable",
                    "-", "-", "global", "");
            }
        }
    }

    // Busca el scope de una función por nombre
    private static TablaSimbolos buscarScopeFuncion(TablaSimbolos tabla, String nombreFuncion) {
        if (tabla == null) return null;
        if (tabla.getNombreScope().equals("funcion:" + nombreFuncion)) return tabla;
        if (tabla.getPadre() != null) return buscarScopeFuncion(tabla.getPadre(), nombreFuncion);
        return null;
    }
}