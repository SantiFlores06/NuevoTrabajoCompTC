package com.compilador;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.compilador.generacion.CodigoVisitor;
import com.compilador.generacion.GeneradorCodigo;

public class App {
    // Códigos ANSI para colores
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(RED + "Error: Debe proporcionar un archivo de entrada." + RESET);
            System.out.println("Uso: java -jar demo.jar <archivo_entrada>");
            return;
        }

        String archivoEntrada = args[0];
        try {
            System.out.println("Analizando archivo: " + archivoEntrada + "\n");

            // Leer el archivo de entrada
            String codigoFuente = new String(Files.readAllBytes(Paths.get(archivoEntrada)));

            // Crear el lexer y el parser
            CharStream input = CharStreams.fromString(codigoFuente);
            MiniLenguajeLexer lexer = new MiniLenguajeLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MiniLenguajeParser parser = new MiniLenguajeParser(tokens);

            // Configurar el manejo de errores
            lexer.removeErrorListeners();
            parser.removeErrorListeners();
            List<String> erroresLexicos = new ArrayList<>();
            List<String> erroresSintacticos = new ArrayList<>();

            // Análisis Léxico
            System.out.println("=== ANÁLISIS LÉXICO ===");
            tokens.fill();
            List<Token> tokenList = tokens.getTokens();
            
            // Imprimir encabezado de la tabla
            System.out.printf("%-20s %-30s %-10s %-10s%n", "TIPO", "LEXEMA", "LÍNEA", "COLUMNA");
            System.out.println("--------------------------------------------------------------------");
            
            // Imprimir tokens
            for (Token token : tokenList) {
                if (token.getType() != Token.EOF) {
                    String tokenName = lexer.getVocabulary().getSymbolicName(token.getType());
                    System.out.printf("%-20s %-30s %-10d %-10d%n",
                        tokenName != null ? tokenName : "DESCONOCIDO",
                        token.getText(),
                        token.getLine(),
                        token.getCharPositionInLine());
                }
            }

            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                        int line, int charPositionInLine, String msg, RecognitionException e) {
                    erroresLexicos.add(String.format("Error léxico en línea %d, posición %d: %s", line, charPositionInLine, msg));
                }
            });

            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                        int line, int charPositionInLine, String msg, RecognitionException e) {
                    erroresSintacticos.add(String.format("Error sintáctico en línea %d, posición %d: %s", line, charPositionInLine, msg));
                }
            });

            // Verificar errores léxicos
            if (!erroresLexicos.isEmpty()) {
                System.out.println(RED + "\n❌ ERRORES LÉXICOS:" + RESET);
                for (String error : erroresLexicos) {
                    System.out.println(RED + "   " + error + RESET);
                }
                return;
            }
            System.out.println("\n✓ Análisis léxico completado sin errores.\n");

            // Realizar el análisis sintáctico
            System.out.println("=== ANÁLISIS SINTÁCTICO ===");
            ParseTree tree = null;
            try {
                tree = parser.programa();
            } catch (Exception e) {
                System.out.println(RED + "❌ Error al generar el árbol sintáctico: " + e.getMessage() + RESET);
                return;
            }

            // Verificar que el árbol sintáctico sea válido
            if (tree == null) {
                System.out.println(RED + "❌ No se pudo generar el árbol sintáctico." + RESET);
                return;
            }

            // Verificar errores sintácticos
            if (!erroresSintacticos.isEmpty()) {
                System.out.println(RED + "\n❌ ERRORES SINTÁCTICOS:" + RESET);
                for (String error : erroresSintacticos) {
                    System.out.println(RED + "   " + error + RESET);
                }
                return;
            }

            System.out.println("✓ Análisis sintáctico completado sin errores.");
            System.out.println("Representación textual del árbol sintáctico:");
            System.out.println(tree.toStringTree(parser) + "\n");

            // Mostrar el árbol sintáctico en una ventana
            try {
                JFrame frame = new JFrame("Árbol Sintáctico");
                JPanel panel = new JPanel();
                TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
                viewer.setScale(1.5);
                panel.add(viewer);
                frame.add(panel);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setVisible(true);
            } catch (Exception e) {
                System.out.println(YELLOW + "⚠️ No se pudo mostrar el árbol sintáctico en ventana: " + e.getMessage() + RESET);
            }

            // Realizar el análisis semántico
            System.out.println("=== TABLA DE SÍMBOLOS ===");
            SimbolosListener listener = new SimbolosListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);

            // Mostrar la tabla de símbolos
            TablaSimbolos tabla = listener.getTablaSimbolos();
            tabla.imprimir();

            // Verificar errores semánticos
            List<String> erroresSemanticos = listener.getErroresCriticos();
            List<String> warningsSemanticos = listener.getAdvertencias();

            if (!erroresSemanticos.isEmpty()) {
                System.out.println(RED + "\n❌ ERRORES CRÍTICOS:" + RESET);
                for (String error : erroresSemanticos) {
                    System.out.println(RED + "   " + error + RESET);
                }
                System.out.println(RED + "\n❌ La compilación no puede continuar debido a errores críticos." + RESET);
                return;
            }

            if (!warningsSemanticos.isEmpty()) {
                System.out.println(YELLOW + "\n⚠️ ADVERTENCIAS:" + RESET);
                for (String warning : warningsSemanticos) {
                    System.out.println(YELLOW + "   " + warning + RESET);
                }
                System.out.println(YELLOW + "\n⚠️ El código tiene advertencias, pero se puede continuar." + RESET);
            }

            System.out.println("\n✓ Análisis semántico completado sin errores.\n");

            // Generar código intermedio
            System.out.println("=== GENERACIÓN DE CÓDIGO INTERMEDIO ===");
            try {
                if (tree != null) {
                    CodigoVisitor visitor = new CodigoVisitor();
                    String resultado = visitor.visit(tree);
                    if (resultado == null) {
                        System.out.println(RED + "❌ Error: El visitante no pudo procesar el árbol sintáctico correctamente." + RESET);
                        return;
                    }
                    List<String> codigoIntermedio = visitor.obtenerCodigo();

                    // Mostrar el código intermedio
                    for (String instruccion : codigoIntermedio) {
                        System.out.println(instruccion);
                    }

                    // Guardar el código intermedio en un archivo
                    String nombreArchivoSalida = archivoEntrada.substring(0, archivoEntrada.lastIndexOf('.')) + "_intermedio.txt";
                    Files.write(Paths.get(nombreArchivoSalida), codigoIntermedio);
                    System.out.println(GREEN + "\n✓ Código intermedio guardado en: " + nombreArchivoSalida + RESET);
                } else {
                    System.out.println(RED + "❌ No se puede generar el código intermedio porque el árbol sintáctico es nulo." + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "❌ Error al generar el código intermedio: " + e.getMessage() + RESET);
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.out.println(RED + "❌ Error al leer el archivo: " + e.getMessage() + RESET);
        } catch (ParseCancellationException e) {
            System.out.println(RED + "❌ Error de análisis: " + e.getMessage() + RESET);
        } catch (Exception e) {
            System.out.println(RED + "❌ Error inesperado: " + e.getMessage() + RESET);
            e.printStackTrace();
        }
    }
}