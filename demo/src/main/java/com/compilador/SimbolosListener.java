package com.compilador;

import java.util.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.Token;

public class SimbolosListener extends MiniLenguajeBaseListener {
    private TablaSimbolos tablaSimbolos;
    private List<String> erroresCriticos;
    private List<String> advertencias;
    private TablaSimbolos scopeActual;
    private Map<String, String> prototiposFunciones;
    private Map<String, Boolean> variablesUsadas;
    private Map<String, Boolean> funcionesUsadas;
    private Map<String, Boolean> libreriasUsadas;
    private Map<String, Boolean> variablesInicializadas;
    private Map<String, String> tiposVariables;
    private Map<String, Boolean> constantes;
    private Set<String> parametrosNoUsados;
    private boolean enFuncion;
    private String funcionActual;
    private String tipoRetornoActual;
    private boolean enBucle;
    private boolean tieneBreakContinue;

    public SimbolosListener() {
        this.tablaSimbolos = new TablaSimbolos();
        this.scopeActual = tablaSimbolos;
        this.erroresCriticos = new ArrayList<>();
        this.advertencias = new ArrayList<>();
        this.prototiposFunciones = new HashMap<>();
        this.variablesUsadas = new HashMap<>();
        this.funcionesUsadas = new HashMap<>();
        this.libreriasUsadas = new HashMap<>();
        this.variablesInicializadas = new HashMap<>();
        this.tiposVariables = new HashMap<>();
        this.constantes = new HashMap<>();
        this.parametrosNoUsados = new HashSet<>();
        this.enFuncion = false;
        this.funcionActual = null;
        this.tipoRetornoActual = null;
        this.enBucle = false;
        this.tieneBreakContinue = false;
    }

    @Override
    public void enterDeclaracionVariable(MiniLenguajeParser.DeclaracionVariableContext ctx) {
        if (ctx == null || ctx.ID() == null || ctx.tipo() == null) {
            advertencias.add("Advertencia: No se pudo analizar una declaración de variable por errores de sintaxis.");
            return;
        }
        String nombre = ctx.ID().getText();
        String tipoDeclarado = ctx.tipo().getText();
        
        if (scopeActual.existe(nombre)) {
            String tipoAnterior = tiposVariables.get(nombre);
            if (!tipoAnterior.equals(tipoDeclarado)) {
                erroresCriticos.add("Error critico: Variable '" + nombre + "' redefinida con tipo distinto (" + 
                    tipoAnterior + " -> " + tipoDeclarado + ") en linea " + ctx.getStart().getLine());
            }
        }
        
        tiposVariables.put(nombre, tipoDeclarado);
        variablesInicializadas.put(nombre, ctx.expresion() != null);
        
        if (ctx.expresion() != null) {
            String tipoInferido = inferirTipo(ctx.expresion());
            if (!tiposCompatibles(tipoDeclarado, tipoInferido)) {
                erroresCriticos.add("Error critico: Asignacion de tipo incorrecto para '" + nombre + 
                    "' (declarado: " + tipoDeclarado + ", asignado: " + tipoInferido + ") en linea " + ctx.getStart().getLine());
            }
        }
        
        String valor = ctx.expresion() != null ? ctx.expresion().getText() : "undefined";
        int linea = ctx.getStart().getLine();
        int columna = ctx.getStart().getCharPositionInLine();
        scopeActual.insertar(nombre, tipoDeclarado, valor, "variable", linea, columna);
        
        String ambito = enFuncion ? "funcion:" + funcionActual : "global";
        System.out.println("Variable declarada: " + nombre + " (" + tipoDeclarado + ") en " + ambito);
    }

    @Override
    public void enterDeclaracionConstante(MiniLenguajeParser.DeclaracionConstanteContext ctx) {
        if (ctx == null || ctx.ID() == null || ctx.tipo() == null || ctx.expresion() == null) {
            advertencias.add("Advertencia: No se pudo analizar una declaración de constante por errores de sintaxis.");
            return;
        }
        String nombre = ctx.ID().getText();
        String tipoDeclarado = ctx.tipo().getText();
        String tipoInferido = inferirTipo(ctx.expresion());
        
        if (!tiposCompatibles(tipoDeclarado, tipoInferido)) {
            erroresCriticos.add("Error critico: Asignacion de tipo incorrecto para constante '" + nombre + 
                "' (declarado: " + tipoDeclarado + ", asignado: " + tipoInferido + ") en linea " + ctx.getStart().getLine());
        }
        
        constantes.put(nombre, true);
        tiposVariables.put(nombre, tipoDeclarado);
        variablesInicializadas.put(nombre, true);
        scopeActual.insertar(nombre, tipoDeclarado, ctx.expresion().getText(), "constante");
        System.out.println("Constante declarada: " + nombre + " (" + tipoDeclarado + ")");
    }

    @Override
    public void enterDeclaracionFuncion(MiniLenguajeParser.DeclaracionFuncionContext ctx) {
        String nombre = ctx.ID().getText();
        String tipoRetorno = ctx.tipo().getText();
        
        if (prototiposFunciones.containsKey(nombre)) {
            erroresCriticos.add("Error critico: Funcion '" + nombre + "' ya definida en linea " + ctx.getStart().getLine());
        }
        
        StringBuilder prototipo = new StringBuilder(tipoRetorno + " " + nombre + "(");
        if (ctx.parametros() != null) {
            for (int i = 0; i < ctx.parametros().parametro().size(); i++) {
                if (i > 0) prototipo.append(", ");
                prototipo.append(ctx.parametros().parametro(i).tipo().getText());
            }
        }
        prototipo.append(")");
        prototiposFunciones.put(nombre, prototipo.toString());
        
        // Insertar la función en el scope global
        int linea = ctx.getStart().getLine();
        int columna = ctx.getStart().getCharPositionInLine();
        scopeActual.insertar(nombre, tipoRetorno, "funcion", "funcion", linea, columna);
        
        // Crear scope hijo para la función
        TablaSimbolos scopeFuncion = new TablaSimbolos(scopeActual, "funcion:" + nombre);
        scopeActual.agregarHijo(scopeFuncion);
        
        // Cambiar al scope de la función
        scopeActual = scopeFuncion;
        enFuncion = true;
        funcionActual = nombre;
        tipoRetornoActual = tipoRetorno;
        parametrosNoUsados.clear();
        
        // Insertar parámetros en el scope de la función
        if (ctx.parametros() != null) {
            for (MiniLenguajeParser.ParametroContext param : ctx.parametros().parametro()) {
                String paramNombre = param.ID().getText();
                String paramTipo = param.tipo().getText();
                scopeActual.insertar(paramNombre, paramTipo, "parametro", "parametro");
                parametrosNoUsados.add(paramNombre);
                tiposVariables.put(paramNombre, paramTipo);
                System.out.println("Parametro declarado: " + paramNombre + " (" + paramTipo + ") en funcion: " + nombre);
            }
        }
        
        System.out.println("Funcion declarada: " + nombre + " -> " + tipoRetorno);
    }

    @Override
    public void exitDeclaracionFuncion(MiniLenguajeParser.DeclaracionFuncionContext ctx) {
        if (!"void".equals(tipoRetornoActual) && !tieneBreakContinue) {
            advertencias.add("Advertencia: Funcion '" + funcionActual + "' de tipo '" + tipoRetornoActual + 
                "' podria no retornar valor en linea " + ctx.getStart().getLine());
        }
        
        if (scopeActual.getPadre() != null) {
            scopeActual = scopeActual.getPadre();
        }
        enFuncion = false;
        funcionActual = null;
        tipoRetornoActual = null;
        tieneBreakContinue = false;
    }

    @Override
    public void enterSentenciaAsignacion(MiniLenguajeParser.SentenciaAsignacionContext ctx) {
        if (ctx == null || ctx.ID() == null || ctx.expresion().isEmpty()) {
            advertencias.add("Advertencia: No se pudo analizar una asignación por errores de sintaxis.");
            return;
        }
        String nombre = ctx.ID().getText();
        
        if (!scopeActual.existe(nombre)) {
            erroresCriticos.add("Error critico: Variable '" + nombre + "' no definida en linea " + ctx.getStart().getLine());
            return;
        }
        
        if (constantes.containsKey(nombre)) {
            erroresCriticos.add("Error critico: Intento de modificar constante '" + nombre + "' en linea " + ctx.getStart().getLine());
            return;
        }
        
        String tipoVariable = tiposVariables.get(nombre);
        String tipoAsignacion = inferirTipo(ctx.expresion(0));
        
        if (tipoVariable != null && !tiposCompatibles(tipoVariable, tipoAsignacion)) {
            erroresCriticos.add("Error critico: Asignacion de tipo incorrecto para '" + nombre + 
                "' (declarado: " + tipoVariable + ", asignado: " + tipoAsignacion + ") en linea " + ctx.getStart().getLine());
        }
        
        variablesUsadas.put(nombre, true);
        variablesInicializadas.put(nombre, true);
        scopeActual.actualizar(nombre, ctx.expresion(0).getText());
        System.out.println("Asignacion: " + nombre + " = " + ctx.expresion(0).getText());
    }

    @Override
    public void enterLlamadaFuncion(MiniLenguajeParser.LlamadaFuncionContext ctx) {
        String nombre = ctx.ID().getText();
        
        if (!prototiposFunciones.containsKey(nombre)) {
            erroresCriticos.add("Error critico: Llamada a funcion '" + nombre + "' sin prototipo en linea " + ctx.getStart().getLine());
            return;
        }
        
        String prototipo = prototiposFunciones.get(nombre);
        int parametrosEsperados = contarParametros(prototipo);
        int parametrosProporcionados = ctx.argumentos() != null ? ctx.argumentos().expresion().size() : 0;
        
        if (parametrosEsperados != parametrosProporcionados) {
            erroresCriticos.add("Error critico: Numero incorrecto de parametros para funcion '" + nombre + 
                "' (esperados: " + parametrosEsperados + ", proporcionados: " + parametrosProporcionados + ") en linea " + ctx.getStart().getLine());
        }
        
        funcionesUsadas.put(nombre, true);
        System.out.println("Llamada a funcion: " + nombre);
    }

    @Override
    public void enterSentenciaReturn(MiniLenguajeParser.SentenciaReturnContext ctx) {
        if (!enFuncion) {
            erroresCriticos.add("Error critico: 'return' fuera de funcion en linea " + ctx.getStart().getLine());
            return;
        }
        
        if (ctx.expresion() != null) {
            String tipoRetorno = inferirTipo(ctx.expresion());
            if (!tiposCompatibles(tipoRetornoActual, tipoRetorno)) {
                erroresCriticos.add("Error critico: Tipo de retorno incorrecto para funcion '" + funcionActual + 
                    "' (esperado: " + tipoRetornoActual + ", retornado: " + tipoRetorno + ") en linea " + ctx.getStart().getLine());
            }
        } else if (!"void".equals(tipoRetornoActual)) {
            erroresCriticos.add("Error critico: Funcion '" + funcionActual + "' debe retornar valor de tipo '" + 
                tipoRetornoActual + "' en linea " + ctx.getStart().getLine());
        }
        
        tieneBreakContinue = true;
    }

    @Override
    public void enterSentenciaIf(MiniLenguajeParser.SentenciaIfContext ctx) {
        if (ctx == null || ctx.expresion() == null) {
            advertencias.add("Advertencia: No se pudo analizar una condición de if por errores de sintaxis.");
            return;
        }
        if (!enFuncion) {
            erroresCriticos.add("Error critico: Estructura de control 'if' fuera de funcion en linea " + ctx.getStart().getLine());
        }
        
        String tipoCondicion = inferirTipo(ctx.expresion());
        if (!"boolean".equals(tipoCondicion)) {
            erroresCriticos.add("Error critico: Condicion de 'if' debe ser boolean, encontrado: " + tipoCondicion + 
                " en linea " + ctx.getStart().getLine());
        }
    }

    @Override
    public void enterSentenciaWhile(MiniLenguajeParser.SentenciaWhileContext ctx) {
        if (ctx == null || ctx.expresion() == null) {
            advertencias.add("Advertencia: No se pudo analizar una condición de while por errores de sintaxis.");
            return;
        }
        if (!enFuncion) {
            erroresCriticos.add("Error critico: Estructura de control 'while' fuera de funcion en linea " + ctx.getStart().getLine());
        }
        
        String tipoCondicion = inferirTipo(ctx.expresion());
        if (!"boolean".equals(tipoCondicion)) {
            erroresCriticos.add("Error critico: Condicion de 'while' debe ser boolean, encontrado: " + tipoCondicion + 
                " en linea " + ctx.getStart().getLine());
        }
        
        enBucle = true;
    }

    @Override
    public void exitSentenciaWhile(MiniLenguajeParser.SentenciaWhileContext ctx) {
        enBucle = false;
    }

    @Override
    public void enterSentenciaFor(MiniLenguajeParser.SentenciaForContext ctx) {
        if (ctx == null || ctx.expresion(0) == null) {
            advertencias.add("Advertencia: No se pudo analizar una condición de for por errores de sintaxis.");
            return;
        }
        if (!enFuncion) {
            erroresCriticos.add("Error critico: Estructura de control 'for' fuera de funcion en linea " + ctx.getStart().getLine());
        }
        
        if (ctx.expresion(0) != null) {
            String tipoCondicion = inferirTipo(ctx.expresion(0));
            if (!"boolean".equals(tipoCondicion)) {
                erroresCriticos.add("Error critico: Condicion de 'for' debe ser boolean, encontrado: " + tipoCondicion + 
                    " en linea " + ctx.getStart().getLine());
            }
        }
        
        enBucle = true;
    }

    @Override
    public void exitSentenciaFor(MiniLenguajeParser.SentenciaForContext ctx) {
        enBucle = false;
    }

    @Override
    public void enterSentenciaBreak(MiniLenguajeParser.SentenciaBreakContext ctx) {
        if (!enBucle) {
            erroresCriticos.add("Error critico: 'break' fuera de bucle en linea " + ctx.getStart().getLine());
        }
        tieneBreakContinue = true;
    }

    @Override
    public void enterSentenciaContinue(MiniLenguajeParser.SentenciaContinueContext ctx) {
        if (!enBucle) {
            erroresCriticos.add("Error critico: 'continue' fuera de bucle en linea " + ctx.getStart().getLine());
        }
        tieneBreakContinue = true;
    }

    @Override
    public void enterImportacion(MiniLenguajeParser.ImportacionContext ctx) {
        String libreria = ctx.STRING().getText();
        libreriasUsadas.put(libreria, false);
        System.out.println("Importacion: " + libreria);
    }

    @Override
    public void enterSentenciaPrint(MiniLenguajeParser.SentenciaPrintContext ctx) {
        if (ctx == null || ctx.expresion() == null) {
            advertencias.add("Advertencia: No se pudo analizar una expresión en print por errores de sintaxis.");
            return;
        }
        verificarVariablesEnExpresion(ctx.expresion());
        System.out.println("Print: " + ctx.expresion().getText());
    }

    @Override
    public void enterBloque(MiniLenguajeParser.BloqueContext ctx) {
        TablaSimbolos scopeBloque = new TablaSimbolos(scopeActual, "bloque");
        scopeActual = scopeBloque;
    }

    @Override
    public void exitBloque(MiniLenguajeParser.BloqueContext ctx) {
        if (scopeActual.getPadre() != null) {
            scopeActual = scopeActual.getPadre();
        }
    }

    @Override
    public void exitPrograma(MiniLenguajeParser.ProgramaContext ctx) {
        for (Map.Entry<String, Boolean> entry : variablesUsadas.entrySet()) {
            if (!entry.getValue()) {
                advertencias.add("⚠️ Warning: Variable '" + entry.getKey() + "' declarada pero nunca utilizada en el ámbito '" + (enFuncion ? funcionActual : "global") + "'");
            }
        }
        
        for (Map.Entry<String, Boolean> entry : funcionesUsadas.entrySet()) {
            if (!entry.getValue()) {
                advertencias.add("⚠️ Warning: Funcion '" + entry.getKey() + "' definida pero no usada en el ámbito '" + (enFuncion ? funcionActual : "global") + "'");
            }
        }
        
        for (Map.Entry<String, Boolean> entry : libreriasUsadas.entrySet()) {
            if (!entry.getValue()) {
                advertencias.add("⚠️ Warning: Libreria " + entry.getKey() + " importada pero no usada en el ámbito '" + (enFuncion ? funcionActual : "global") + "'");
            }
        }
        
        for (Map.Entry<String, Boolean> entry : variablesInicializadas.entrySet()) {
            if (!entry.getValue()) {
                advertencias.add("⚠️ Warning: Variable '" + entry.getKey() + "' declarada pero no inicializada en el ámbito '" + (enFuncion ? funcionActual : "global") + "'");
            }
        }
        
        for (String param : parametrosNoUsados) {
            advertencias.add("⚠️ Warning: Parametro '" + param + "' no usado en funcion '" + funcionActual + "' en el ámbito '" + (enFuncion ? funcionActual : "global") + "'");
        }
        
        if (enBucle && !tieneBreakContinue) {
            advertencias.add("⚠️ Warning: Bucle potencialmente infinito detectado en el ámbito '" + (enFuncion ? funcionActual : "global") + "'");
        }
    }

    private String inferirTipo(MiniLenguajeParser.ExpresionContext ctx) {
        if (ctx == null) return "desconocido";
        return inferirTipoRecursivo(ctx);
    }
    
    private String inferirTipoRecursivo(ParseTree node) {
        if (node == null) return "desconocido";
        if (node instanceof MiniLenguajeParser.FactorContext) {
            MiniLenguajeParser.FactorContext factor = (MiniLenguajeParser.FactorContext) node;
            
            if (factor.INTEGER() != null) {
                return "int";
            } else if (factor.FLOAT() != null) {
                return "float";
            } else if (factor.STRING() != null) {
                return "string";
            } else if (factor.CHAR() != null) {
                return "char";
            } else if (factor.TRUE() != null || factor.FALSE() != null) {
                return "boolean";
            } else if (factor.ID() != null) {
                String nombre = factor.ID().getText();
                if (tiposVariables.containsKey(nombre)) {
                    return tiposVariables.get(nombre);
                }
                return "unknown";
            } else if (factor.llamadaFuncion() != null) {
                String nombre = factor.llamadaFuncion().ID().getText();
                if (prototiposFunciones.containsKey(nombre)) {
                    String prototipo = prototiposFunciones.get(nombre);
                    return prototipo.split(" ")[0];
                }
                return "unknown";
            }
        }
        
        for (int i = 0; i < node.getChildCount(); i++) {
            String tipo = inferirTipoRecursivo(node.getChild(i));
            if (tipo != null && !"unknown".equals(tipo)) {
                return tipo;
            }
        }
        
        return "unknown";
    }

    private boolean tiposCompatibles(String tipo1, String tipo2) {
        if (tipo1.equals(tipo2)) return true;
        if ("float".equals(tipo1) && "int".equals(tipo2)) return true;
        if ("int".equals(tipo1) && "float".equals(tipo2)) return true;
        return false;
    }

    private int contarParametros(String prototipo) {
        String parametros = prototipo.substring(prototipo.indexOf("(") + 1, prototipo.indexOf(")"));
        if (parametros.trim().isEmpty()) return 0;
        return parametros.split(",").length;
    }

    private void verificarVariablesEnExpresion(MiniLenguajeParser.ExpresionContext ctx) {
        verificarVariablesRecursivo(ctx);
    }
    
    private void verificarVariablesRecursivo(ParseTree node) {
        if (node instanceof MiniLenguajeParser.FactorContext) {
            MiniLenguajeParser.FactorContext factor = (MiniLenguajeParser.FactorContext) node;
            if (factor.ID() != null) {
                String nombre = factor.ID().getText();
                if (!scopeActual.existe(nombre)) {
                    erroresCriticos.add("❌ Error: Variable '" + nombre + "' no declarada en el ámbito '" + (enFuncion ? funcionActual : "global") + "' (línea " + factor.getStart().getLine() + ", columna " + factor.getStart().getCharPositionInLine() + ")");
                } else {
                    variablesUsadas.put(nombre, true);
                    if (parametrosNoUsados.contains(nombre)) {
                        parametrosNoUsados.remove(nombre);
                    }
                }
            }
        }
        
        for (int i = 0; i < node.getChildCount(); i++) {
            verificarVariablesRecursivo(node.getChild(i));
        }
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public List<String> getErroresCriticos() {
        return erroresCriticos;
    }

    public List<String> getAdvertencias() {
        return advertencias;
    }

    public boolean tieneErrores() {
        return !erroresCriticos.isEmpty();
    }

    public boolean tieneAdvertencias() {
        return !advertencias.isEmpty();
    }

    public Map<String, String> getPrototiposFunciones() {
        return prototiposFunciones;
    }
} 