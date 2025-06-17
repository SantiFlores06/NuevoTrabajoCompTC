package com.compilador.generacion;

import com.compilador.MiniLenguajeBaseVisitor;
import com.compilador.MiniLenguajeParser;
import java.util.ArrayList;
import java.util.List;

public class CodigoVisitor extends MiniLenguajeBaseVisitor<String> {
    private GeneradorCodigo generador;
    private int nivelAnidamiento;

    public CodigoVisitor() {
        this.generador = new GeneradorCodigo();
        this.nivelAnidamiento = 0;
    }

    public List<String> obtenerCodigo() {
        return generador.obtenerCodigo();
    }

    @Override
    public String visitPrograma(MiniLenguajeParser.ProgramaContext ctx) {
        if (ctx == null) return null;
        // Generar código para las declaraciones globales
        for (MiniLenguajeParser.DeclaracionContext declaracion : ctx.declaracion()) {
            if (declaracion != null) {
                visit(declaracion);
            }
        }
        return "";
    }

    @Override
    public String visitDeclaracionVariable(MiniLenguajeParser.DeclaracionVariableContext ctx) {
        if (ctx == null) return null;
        String nombre = ctx.ID().getText();
        if (ctx.expresion() != null) {
            String valor = visit(ctx.expresion());
            if (valor != null) {
                generador.generarAsignacion(nombre, valor);
            }
        }
        return "";
    }

    @Override
    public String visitDeclaracionFuncion(MiniLenguajeParser.DeclaracionFuncionContext ctx) {
        String nombreFuncion = ctx.ID().getText();
        generador.agregarInstruccion("function " + nombreFuncion + ":");
        
        // Procesar parámetros
        if (ctx.parametros() != null) {
            visit(ctx.parametros());
        }
        
        // Procesar cuerpo de la función
        if (ctx.sentencia() != null) {
            for (MiniLenguajeParser.SentenciaContext sentencia : ctx.sentencia()) {
                visit(sentencia);
            }
        }
        
        return null;
    }

    @Override
    public String visitParametros(MiniLenguajeParser.ParametrosContext ctx) {
        for (MiniLenguajeParser.ParametroContext param : ctx.parametro()) {
            String nombre = param.ID().getText();
            generador.agregarInstruccion("param " + nombre);
        }
        return null;
    }

    @Override
    public String visitSentenciaAsignacion(MiniLenguajeParser.SentenciaAsignacionContext ctx) {
        String nombre = ctx.ID().getText();
        String valor = visit(ctx.expresion());
        return generador.generarAsignacion(nombre, valor);
    }

    @Override
    public String visitExpresionAritmetica(MiniLenguajeParser.ExpresionAritmeticaContext ctx) {
        if (ctx == null) return null;
        
        if (ctx.termino().size() == 1) {
            return visit(ctx.termino(0));
        }

        String resultado = visit(ctx.termino(0));
        if (resultado == null) return null;

        for (int i = 1; i < ctx.termino().size(); i++) {
            String operador = ctx.getChild(2 * i - 1).getText();
            String operando = visit(ctx.termino(i));
            if (operando == null) return null;
            resultado = generador.generarOperacion(operador, resultado, operando);
        }
        return resultado;
    }

    @Override
    public String visitTermino(MiniLenguajeParser.TerminoContext ctx) {
        if (ctx == null) return null;
        
        if (ctx.factor().size() == 1) {
            return visit(ctx.factor(0));
        }

        String resultado = visit(ctx.factor(0));
        if (resultado == null) return null;

        for (int i = 1; i < ctx.factor().size(); i++) {
            String operador = ctx.getChild(2 * i - 1).getText();
            String operando = visit(ctx.factor(i));
            if (operando == null) return null;
            resultado = generador.generarOperacion(operador, resultado, operando);
        }
        return resultado;
    }

    @Override
    public String visitFactor(MiniLenguajeParser.FactorContext ctx) {
        if (ctx == null) return null;
        
        if (ctx.INTEGER() != null) {
            return ctx.INTEGER().getText();
        }
        if (ctx.FLOAT() != null) {
            return ctx.FLOAT().getText();
        }
        if (ctx.ID() != null) {
            return ctx.ID().getText();
        }
        if (ctx.expresion() != null) {
            return visit(ctx.expresion());
        }
        if (ctx.llamadaFuncion() != null) {
            return visit(ctx.llamadaFuncion());
        }
        if (ctx.TRUE() != null) {
            return "true";
        }
        if (ctx.FALSE() != null) {
            return "false";
        }
        return null;
    }

    @Override
    public String visitLlamadaFuncion(MiniLenguajeParser.LlamadaFuncionContext ctx) {
        if (ctx == null) return null;
        
        String nombreFuncion = ctx.ID().getText();
        List<String> argumentos = new ArrayList<>();
        
        if (ctx.argumentos() != null) {
            for (int i = 0; i < ctx.argumentos().expresion().size(); i++) {
                String valor = visit(ctx.argumentos().expresion(i));
                if (valor != null) {
                    argumentos.add(valor);
                }
            }
        }
        
        return generador.generarLlamadaFuncion(nombreFuncion, argumentos);
    }

    @Override
    public String visitSentenciaIf(MiniLenguajeParser.SentenciaIfContext ctx) {
        if (ctx == null) return null;
        
        String condicion = visit(ctx.expresion());
        if (condicion == null) return null;
        
        String etiquetaElse = generador.nuevaEtiqueta();
        String etiquetaFin = generador.nuevaEtiqueta();
        
        generador.generarSaltoCondicional("!" + condicion, etiquetaElse);
        
        if (ctx.sentencia(0) != null) {
            visit(ctx.sentencia(0));
        }
        
        if (ctx.ELSE() != null) {
            generador.generarSalto(etiquetaFin);
            generador.generarEtiqueta(etiquetaElse);
            if (ctx.sentencia(1) != null) {
                visit(ctx.sentencia(1));
            }
            generador.generarEtiqueta(etiquetaFin);
        } else {
            generador.generarEtiqueta(etiquetaElse);
        }
        
        return "";
    }

    @Override
    public String visitSentenciaWhile(MiniLenguajeParser.SentenciaWhileContext ctx) {
        if (ctx == null) return null;
        
        String etiquetaInicio = generador.nuevaEtiqueta();
        String etiquetaFin = generador.nuevaEtiqueta();
        
        generador.generarEtiqueta(etiquetaInicio);
        
        String condicion = visit(ctx.expresion());
        if (condicion == null) return null;
        
        generador.generarSaltoCondicional("!" + condicion, etiquetaFin);
        
        if (ctx.sentencia() != null) {
            visit(ctx.sentencia());
        }
        
        generador.generarSalto(etiquetaInicio);
        generador.generarEtiqueta(etiquetaFin);
        
        return "";
    }

    @Override
    public String visitSentenciaFor(MiniLenguajeParser.SentenciaForContext ctx) {
        if (ctx == null) return null;
        
        nivelAnidamiento++;
        String etiquetaInicio = generador.nuevaEtiqueta();
        String etiquetaFin = generador.nuevaEtiqueta();

        // Inicialización
        if (ctx.declaracionVariable() != null) {
            visit(ctx.declaracionVariable());
        } else if (ctx.sentenciaAsignacion() != null) {
            visit(ctx.sentenciaAsignacion());
        }

        generador.generarEtiqueta(etiquetaInicio);

        // Condición
        if (ctx.expresion(0) != null) {
            String condicion = visit(ctx.expresion(0));
            if (condicion != null) {
                generador.generarSaltoCondicional("!" + condicion, etiquetaFin);
            }
        }

        // Bloque
        if (ctx.sentencia() != null) {
            visit(ctx.sentencia());
        }

        // Incremento
        if (ctx.expresion(1) != null) {
            visit(ctx.expresion(1));
        }

        generador.generarSalto(etiquetaInicio);
        generador.generarEtiqueta(etiquetaFin);
        nivelAnidamiento--;
        
        return "";
    }

    @Override
    public String visitSentenciaPrint(MiniLenguajeParser.SentenciaPrintContext ctx) {
        if (ctx == null) return null;
        
        String valor = visit(ctx.expresion());
        if (valor != null) {
            generador.generarPrint(valor);
        }
        return "";
    }

    @Override
    public String visitSentenciaReturn(MiniLenguajeParser.SentenciaReturnContext ctx) {
        if (ctx == null) return null;
        
        if (ctx.expresion() != null) {
            String valor = visit(ctx.expresion());
            if (valor != null) {
                generador.generarRetorno(valor);
            }
        } else {
            generador.generarRetorno("");
        }
        return "";
    }

    @Override
    public String visitExpresionComparacion(MiniLenguajeParser.ExpresionComparacionContext ctx) {
        if (ctx == null || ctx.expresionAritmetica().size() < 2) return null;
        
        String op1 = visit(ctx.expresionAritmetica(0));
        String op2 = visit(ctx.expresionAritmetica(1));
        
        if (op1 == null || op2 == null) return null;
        
        String operador = ctx.getChild(1).getText();
        return generador.generarComparacion(operador, op1, op2);
    }

    @Override
    public String visitExpresionLogica(MiniLenguajeParser.ExpresionLogicaContext ctx) {
        if (ctx == null) return null;
        
        if (ctx.expresionComparacion().size() == 1) {
            return visit(ctx.expresionComparacion(0));
        }

        String resultado = visit(ctx.expresionComparacion(0));
        if (resultado == null) return null;

        for (int i = 1; i < ctx.expresionComparacion().size(); i++) {
            String operador = ctx.getChild(2 * i - 1).getText();
            String operando = visit(ctx.expresionComparacion(i));
            if (operando == null) return null;
            resultado = generador.generarOperacion(operador, resultado, operando);
        }
        return resultado;
    }

    @Override
    public String visitSentenciaBreak(MiniLenguajeParser.SentenciaBreakContext ctx) {
        if (ctx == null) return null;
        
        if (nivelAnidamiento > 0) {
            generador.agregarInstruccion("break");
        }
        return "";
    }

    @Override
    public String visitSentenciaContinue(MiniLenguajeParser.SentenciaContinueContext ctx) {
        if (ctx == null) return null;
        
        if (nivelAnidamiento > 0) {
            generador.agregarInstruccion("continue");
        }
        return "";
    }
} 