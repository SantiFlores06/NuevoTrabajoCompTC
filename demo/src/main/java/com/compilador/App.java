package com.compilador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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
            
            // 1. ANÁLISIS LÉXICO
            MiniLenguajeLexer lexer = new MiniLenguajeLexer(input);
            
            // Configurar manejo de errores personalizado
            List<String> erroresLexicos = new ArrayList<>();
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, 
                                      int line, int charPositionInLine, String msg, RecognitionException e) {
                    String errorMsg = "ERROR LÉXICO en línea " + line + ":" + charPositionInLine + 
                                     " - " + msg;
                    erroresLexicos.add(errorMsg);
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
                
                // 2. ANÁLISIS SINTÁCTICO
                MiniLenguajeParser parser = new MiniLenguajeParser(tokens);
                List<String> erroresSintacticos = new ArrayList<>();
                parser.removeErrorListeners();
                parser.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, 
                                            int line, int charPositionInLine, String msg, RecognitionException e) {
                        erroresSintacticos.add("ERROR SINTÁCTICO en línea " + line + ":" + charPositionInLine + " - " + msg);
                    }
                });

                System.out.println("\n=== ANÁLISIS SINTÁCTICO ===");
                ParseTree tree = parser.programa();
                if (!erroresSintacticos.isEmpty()) {
                    erroresSintacticos.forEach(System.out::println);
                    return;
                } else {
                    System.out.println("✅ Análisis sintáctico completado sin errores.");
                    System.out.println("Representación textual del árbol sintáctico:");
                    System.out.println(tree.toStringTree(parser));
                }

                // 3. VISUALIZACIÓN DEL ÁRBOL SINTÁCTICO
                generarImagenArbolSintactico(tree, parser);

                // 4. ANÁLISIS SEMÁNTICO
                SimbolosListener listener = new SimbolosListener();
                ParseTreeWalker walker = new ParseTreeWalker();
                walker.walk(listener, tree);

                TablaSimbolos tabla = listener.getTablaSimbolos();
                tabla.imprimir();

                List<String> erroresSemanticos = listener.getErrores();
                if (!erroresSemanticos.isEmpty()) {
                    System.out.println("\n=== ERRORES SEMÁNTICOS ===");
                    erroresSemanticos.forEach(System.out::println);
                } else {
                    System.out.println("\n✅ Análisis semántico completado sin errores.");
                }
                
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
        } catch (ParseCancellationException e) {
            System.err.println("❌ Error de análisis: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado:");
            e.printStackTrace();
        }
    }

    private static void generarImagenArbolSintactico(ParseTree tree, Parser parser) {
        try {
            JFrame frame = new JFrame("Árbol Sintáctico");
            JPanel panel = new JPanel();

            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(1.5); // Zoom

            panel.add(viewer);

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            frame.add(scrollPane);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            //frame.setVisible(true);
            viewer.open();  // Esto lanza una ventana gráfica con el árbol de análisis

        } catch (Exception e) {
            System.err.println("❌ Error al mostrar árbol sintáctico: " + e.getMessage());
        }
    }
}