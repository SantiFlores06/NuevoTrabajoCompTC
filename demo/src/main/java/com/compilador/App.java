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
import com.compilador.optimacion.Optimizador;

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

        // Obtener nombre base del archivo fuente (sin extensión)
        String baseName = inputFilePath;
        int lastSlash = baseName.lastIndexOf("/");
        if (lastSlash == -1) lastSlash = baseName.lastIndexOf("\\");
        if (lastSlash != -1) baseName = baseName.substring(lastSlash + 1);
        int lastDot = baseName.lastIndexOf('.');
        if (lastDot != -1) baseName = baseName.substring(0, lastDot);
        String archivoIntermedio = baseName + ".intermedio.txt";
        String archivoOptimizado = baseName + ".optimizado.txt";

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
            System.out.println(GREEN + "✓ Análisis léxico completado sin errores." + RESET + "\n");

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
                System.out.println(RED + "✗ ERRORES SINTÁCTICOS:" + RESET);
                erroresSintacticos.forEach(error -> System.out.println(RED + "   " + error + RESET));
            } else {
                System.out.println(GREEN + "✓ Análisis sintáctico completado sin errores." + RESET + "\n");
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
                System.out.println(RED + "\n✗ ERRORES SEMÁNTICOS:" + RESET);
                erroresSemanticos.forEach(error -> System.out.println(RED + "   " + error + RESET));
            }

            if (!warningsSemanticos.isEmpty()) {
                System.out.println(YELLOW + "\n⚠ ADVERTENCIAS SEMÁNTICAS:" + RESET);
                warningsSemanticos.forEach(warning -> System.out.println(YELLOW + "   " + warning + RESET));
            }

            if (erroresSemanticos.isEmpty() && warningsSemanticos.isEmpty()) {
                System.out.println(GREEN + "✓ Análisis semántico completado sin errores." + RESET + "\n");
            }

            // Mostrar resumen de errores
            if (!erroresSintacticos.isEmpty() || !erroresSemanticos.isEmpty()) {
                System.out.println(RED + "=== RESUMEN DE ERRORES ===" + RESET);
                System.out.println(RED + "Errores sintácticos: " + erroresSintacticos.size() + RESET);
                System.out.println(RED + "Errores semánticos: " + erroresSemanticos.size() + RESET);
                System.out.println(YELLOW + "Advertencias: " + warningsSemanticos.size() + RESET);
            }

            // === CÓDIGO INTERMEDIO ===
            System.out.println("=== GENERACIÓN DE CÓDIGO INTERMEDIO ===");
            CodigoVisitor visitor = new CodigoVisitor(listener.getTablaSimbolos());
            visitor.visit(tree);
            
            // Imprimir el código generado
            visitor.getGenerador().imprimirCodigo();
            visitor.getGenerador().imprimirEstadisticas();
            
            // Guardar el código intermedio en un archivo de texto
            List<String> codigoIntermedio = visitor.getGenerador().getCodigo();
            try (PrintWriter out = new PrintWriter(new FileWriter(archivoIntermedio))) {
                codigoIntermedio.forEach(out::println);
                System.out.println(GREEN + "\n✔ Código intermedio guardado en '" + archivoIntermedio + "'" + RESET);
            } catch (Exception e) {
                System.err.println("Error al guardar el código intermedio: " + e.getMessage());
            }

            // === OPTIMIZACIÓN DE CÓDIGO ===
            System.out.println("\n=== OPTIMIZACIÓN DE CÓDIGO ===");
            Optimizador optimizador = new Optimizador(codigoIntermedio);
            List<String> codigoOptimizado = optimizador.optimizar();

            // Imprimir el código optimizado
            System.out.println("\n📝 === CÓDIGO OPTIMIZADO ===");
            for (int i = 0; i < codigoOptimizado.size(); i++) {
                String instruccion = codigoOptimizado.get(i);
                if (instruccion.endsWith(":")) {
                    System.out.println("     " + instruccion);
                } else {
                    System.out.printf("%3d: %s\n", i, instruccion);
                }
            }
             System.out.println("Total instrucciones optimizadas: " + codigoOptimizado.size());

            // Guardar el código optimizado en un archivo de texto
            try (PrintWriter out = new PrintWriter(new FileWriter(archivoOptimizado))) {
                codigoOptimizado.forEach(out::println);
                System.out.println(GREEN + "✔ Código optimizado guardado en '" + archivoOptimizado + "'" + RESET);
            } catch (Exception e) {
                System.err.println("Error al guardar el código optimizado: " + e.getMessage());
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
        imprimirScopeRecursivo(tabla, prototipos, "global");
    }

    // Recorre recursivamente todos los scopes
    private static void imprimirScopeRecursivo(TablaSimbolos tabla, Map<String, String> prototipos, String ambito) {
        // Imprimir todas las variables y parámetros del scope actual
        for (TablaSimbolos.Simbolo simbolo : tabla.getSimbolos()) {
            String categoria = "variable";
            String parametros = "";
            
            if (simbolo.getTipo().equals("parametro")) {
                categoria = "parametro";
            } else if (simbolo.getTipo().equals("funcion")) {
                categoria = "funcion";
                String nombreFuncion = simbolo.getNombre();
                String prototipo = prototipos.get(nombreFuncion);
                if (prototipo != null && prototipo.contains("(")) {
                    parametros = prototipo.substring(prototipo.indexOf('(') + 1, prototipo.indexOf(')'));
                }
            }
            
            System.out.printf("%-15s %-10s %-15s %-10s %-10s %-15s %-20s\n",
                simbolo.getNombre(),
                simbolo.getTipo(),
                categoria,
                "-", "-", ambito, "[" + parametros + "]");
        }
        
        // Recorrer hijos (scopes de funciones) y mostrar sus contenidos
        for (TablaSimbolos hijo : tabla.getHijos()) {
            String ambitoHijo = hijo.getNombreScope();
            imprimirScopeRecursivo(hijo, prototipos, ambitoHijo);
        }
    }
}