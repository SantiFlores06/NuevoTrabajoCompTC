package com.compilador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -jar demo-1.0-jar-with-dependencies.jar <archivo.txt>");
            System.exit(1);
        }

        try {
            // Cargar el archivo de entrada
            CharStream input = CharStreams.fromFileName(args[0]);
            System.out.println("Analizando archivo: " + args[0]);
            
            // Crear el lexer con manejo de errores personalizado
            MiniLenguajeLexer lexer = new MiniLenguajeLexer(input);
            
            // Configurar manejo de errores personalizado
            List<String> errores = new ArrayList<>();
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, 
                                      int line, int charPositionInLine, String msg, RecognitionException e) {
                    String errorMsg = "ERROR LÉXICO en línea " + line + ":" + charPositionInLine + 
                                     " - " + msg;
                    errores.add(errorMsg);
                    throw new ParseCancellationException(errorMsg);
                }
            });
            
            try {
                // Obtener todos los tokens
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                tokens.fill();
                
                // Mostrar los tokens
                System.out.println("\n=== ANÁLISIS LÉXICO ===");
                System.out.printf("%-20s %-30s %-10s %-10s\n", "TIPO", "LEXEMA", "LÍNEA", "COLUMNA");
                System.out.println("-------------------------------------------------------------------");
                
                for (Token token : tokens.getTokens()) {
                    if (token.getType() != Token.EOF) {
                        String tokenName = MiniLenguajeLexer.VOCABULARY.getSymbolicName(token.getType());
                        System.out.printf("%-20s %-30s %-10d %-10d\n", 
                                         tokenName, token.getText(), token.getLine(), 
                                         token.getCharPositionInLine());
                    }
                }
                
                System.out.println("\n✅ Análisis léxico completado sin errores.");
                
            } catch (ParseCancellationException e) {
                System.out.println("\n❌ " + e.getMessage());
                
                // Mostrar contexto del error (opcional)
                String[] lineas = input.toString().split("\n");
                if (e.getMessage().contains("línea")) {
                    try {
                        int lineaError = Integer.parseInt(e.getMessage().split("línea ")[1].split(":")[0]);
                        int lineaInicio = Math.max(0, lineaError - 2);
                        int lineaFin = Math.min(lineas.length, lineaError + 1);
                        
                        System.out.println("\nContexto del error:");
                        for (int i = lineaInicio; i < lineaFin; i++) {
                            if (i + 1 == lineaError) {
                                System.out.println("→ " + (i + 1) + ": " + lineas[i]);
                            } else {
                                System.out.println("  " + (i + 1) + ": " + lineas[i]);
                            }
                        }
                    } catch (Exception ex) {
                        // Si hay algún problema mostrando el contexto, simplemente lo omitimos
                    }
                }
            }
            
        } catch (IOException e) {
            System.err.println("❌ Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}