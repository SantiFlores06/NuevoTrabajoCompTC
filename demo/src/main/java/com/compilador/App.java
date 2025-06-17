package com.compilador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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
            System.out.println("=== CÓDIGO FUENTE ===\n" + codigoFuente + "\n");

            // Análisis léxico
            System.out.println("=== ANÁLISIS LÉXICO ===");
            MiniLenguajeLexer lexer = new MiniLenguajeLexer(CharStreams.fromString(codigoFuente));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // Mostrar tokens
            System.out.println("TIPO                 LEXEMA                         LÍNEA      COLUMNA   ");
            System.out.println("--------------------------------------------------------------------");
            tokens.getTokens().forEach(token -> {
                if (token.getType() != MiniLenguajeLexer.EOF) {
                    System.out.printf("%-20s %-30s %-10d %-10d%n",
                        lexer.getVocabulary().getSymbolicName(token.getType()),
                        token.getText(),
                        token.getLine(),
                        token.getCharPositionInLine());
                }
            });
            System.out.println();

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

            // Mostrar errores sintácticos si los hay
            if (!erroresSintacticos.isEmpty()) {
                System.out.println("\n? ERRORES SINTÁCTICOS:");
                erroresSintacticos.forEach(error -> System.out.println("   " + error));
            } else {
                System.out.println("\n? Análisis sintáctico completado sin errores.");
            }

            // Análisis semántico
            System.out.println("\n=== ANÁLISIS SEMÁNTICO ===");
            SimbolosListener listener = new SimbolosListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);

            // Mostrar tabla de símbolos
            System.out.println("\n=== TABLA DE SÍMBOLOS ===");
            TablaSimbolos tabla = listener.getTablaSimbolos();
            tabla.imprimir();

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
                System.out.println("\n? Análisis semántico completado sin errores ni advertencias.");
            }

            // Mostrar resumen de errores
            if (!erroresSintacticos.isEmpty() || !erroresSemanticos.isEmpty()) {
                System.out.println("\n=== RESUMEN DE ERRORES ===");
                System.out.println("Errores sintácticos: " + erroresSintacticos.size());
                System.out.println("Errores semánticos: " + erroresSemanticos.size());
                System.out.println("Advertencias: " + warningsSemanticos.size());
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}