package com.compilador;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;

public class SimbolosListener extends MiniLenguajeBaseListener {
    private TablaSimbolos tablaSimbolos;
    private List<String> errores;
    private TablaSimbolos scopeActual;

    public SimbolosListener() {
        this.tablaSimbolos = new TablaSimbolos();
        this.scopeActual = tablaSimbolos;
        this.errores = new ArrayList<>();
    }

    @Override
    public void enterDeclaracionVariable(MiniLenguajeParser.DeclaracionVariableContext ctx) {
        try {
            String nombre = ctx.ID().getText();
            String tipo = inferirTipo(ctx.expresion());
            String valor = ctx.expresion().getText();
            
            scopeActual.insertar(nombre, tipo, valor);
            System.out.println("✅ Variable declarada: " + nombre + " (" + tipo + ") = " + valor);
        } catch (Exception e) {
            errores.add("Error en declaración de variable: " + e.getMessage());
        }
    }

    @Override
    public void enterDeclaracionFuncion(MiniLenguajeParser.DeclaracionFuncionContext ctx) {
        try {
            String nombre = ctx.ID().getText();
            
            // Crear nuevo scope para la función
            TablaSimbolos scopeFuncion = new TablaSimbolos(scopeActual, "función:" + nombre);
            scopeActual = scopeFuncion;
            
            // Registrar parámetros
            if (ctx.parametros() != null) {
                for (org.antlr.v4.runtime.tree.TerminalNode param : ctx.parametros().ID()) {
                    scopeActual.insertar(param.getText(), "parámetro", "undefined");
                }
            }
            
            System.out.println("✅ Función declarada: " + nombre);
        } catch (Exception e) {
            errores.add("Error en declaración de función: " + e.getMessage());
        }
    }

    @Override
    public void exitDeclaracionFuncion(MiniLenguajeParser.DeclaracionFuncionContext ctx) {
        // Volver al scope padre
        if (scopeActual.getPadre() != null) {
            scopeActual = scopeActual.getPadre();
        }
    }

    @Override
    public void enterSentenciaAsignacion(MiniLenguajeParser.SentenciaAsignacionContext ctx) {
        try {
            String nombre = ctx.ID().getText();
            
            if (!scopeActual.existe(nombre)) {
                errores.add("Variable '" + nombre + "' no declarada en línea " + ctx.getStart().getLine());
                return;
            }
            
            String tipo = inferirTipo(ctx.expresion());
            String valor = ctx.expresion().getText();
            
            scopeActual.actualizar(nombre, valor);
            System.out.println("✅ Asignación: " + nombre + " = " + valor);
        } catch (Exception e) {
            errores.add("Error en asignación: " + e.getMessage());
        }
    }

    @Override
    public void enterSentenciaPrint(MiniLenguajeParser.SentenciaPrintContext ctx) {
        try {
            String expresion = ctx.expresion().getText();
            String tipo = inferirTipo(ctx.expresion());
            
            // Verificar que la expresión sea válida - buscar IDs en la expresión
            verificarVariablesEnExpresion(ctx.expresion());
            
            System.out.println("✅ Print: " + expresion + " (" + tipo + ")");
        } catch (Exception e) {
            errores.add("Error en sentencia print: " + e.getMessage());
        }
    }

    @Override
    public void enterBloque(MiniLenguajeParser.BloqueContext ctx) {
        // Crear nuevo scope para el bloque
        TablaSimbolos scopeBloque = new TablaSimbolos(scopeActual, "bloque");
        scopeActual = scopeBloque;
    }

    @Override
    public void exitBloque(MiniLenguajeParser.BloqueContext ctx) {
        // Volver al scope padre
        if (scopeActual.getPadre() != null) {
            scopeActual = scopeActual.getPadre();
        }
    }

    private String inferirTipo(MiniLenguajeParser.ExpresionContext ctx) {
        // Navegar por el árbol de expresiones para encontrar el tipo
        return inferirTipoRecursivo(ctx);
    }
    
    private String inferirTipoRecursivo(org.antlr.v4.runtime.tree.ParseTree node) {
        if (node instanceof MiniLenguajeParser.FactorContext) {
            MiniLenguajeParser.FactorContext factor = (MiniLenguajeParser.FactorContext) node;
            
            if (factor.INTEGER() != null) {
                return "int";
            } else if (factor.STRING() != null) {
                return "string";
            } else if (factor.BOOLEAN() != null) {
                return "boolean";
            } else if (factor.ID() != null) {
                // Buscar el tipo de la variable
                TablaSimbolos.Simbolo simbolo = scopeActual.buscar(factor.ID().getText());
                if (simbolo != null) {
                    return simbolo.getTipo();
                }
                return "unknown";
            } else if (factor.llamadaFuncion() != null) {
                return "function_call";
            }
        }
        
        // Recursivamente buscar en los hijos
        for (int i = 0; i < node.getChildCount(); i++) {
            String tipo = inferirTipoRecursivo(node.getChild(i));
            if (tipo != null && !tipo.equals("unknown")) {
                return tipo;
            }
        }
        
        return "expression";
    }

    private void verificarVariablesEnExpresion(MiniLenguajeParser.ExpresionContext ctx) {
        verificarVariablesRecursivo(ctx);
    }
    
    private void verificarVariablesRecursivo(org.antlr.v4.runtime.tree.ParseTree node) {
        if (node instanceof MiniLenguajeParser.FactorContext) {
            MiniLenguajeParser.FactorContext factor = (MiniLenguajeParser.FactorContext) node;
            if (factor.ID() != null) {
                String nombre = factor.ID().getText();
                if (!scopeActual.existe(nombre)) {
                    errores.add("Variable '" + nombre + "' no declarada en línea " + factor.getStart().getLine());
                }
            }
        }
        
        // Recursivamente verificar en los hijos
        for (int i = 0; i < node.getChildCount(); i++) {
            verificarVariablesRecursivo(node.getChild(i));
        }
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public List<String> getErrores() {
        return errores;
    }
} 