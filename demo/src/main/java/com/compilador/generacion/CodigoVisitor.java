package com.compilador.generacion;

import com.compilador.MiniLenguajeBaseVisitor;
import com.compilador.MiniLenguajeParser;
import com.compilador.TablaSimbolos;
import java.util.ArrayList;
import java.util.List;

/**
 * Visitor para generar código de tres direcciones - Versión educativa
 * Responsable de recorrer el AST y coordinar la generación de código
 */
public class CodigoVisitor extends MiniLenguajeBaseVisitor<String> {
    
    private GeneradorCodigo generador;
    private TablaSimbolos tabla;
    private int nivelAnidamiento;
    private String funcionActual;
    private List<String> errores = new ArrayList<>();
    
    public CodigoVisitor(TablaSimbolos tabla) {
        this.generador = new GeneradorCodigo();
        this.tabla = tabla;
        this.nivelAnidamiento = 0;
        this.funcionActual = "global";
        System.out.println("🎯 VISITOR: Iniciado con tabla de símbolos");
    }
    
    public CodigoVisitor() {
        this.generador = new GeneradorCodigo();
        this.tabla = null;
        this.nivelAnidamiento = 0;
        this.funcionActual = "global";
        System.out.println("🎯 VISITOR: Iniciado sin tabla de símbolos");
    }
    
    /**
     * Obtiene el generador de código
     */
    public GeneradorCodigo getGenerador() {
        return generador;
    }
    
    @Override
    public String visitPrograma(MiniLenguajeParser.ProgramaContext ctx) {
        System.out.println("🎯 VISITOR: Iniciando recorrido del programa");
        
        if (ctx == null) return null;
        
        // Procesar todas las declaraciones
        for (MiniLenguajeParser.DeclaracionContext declaracion : ctx.declaracion()) {
            if (declaracion != null) {
                System.out.println("🎯 VISITOR: Procesando declaración...");
                visit(declaracion);
            }
        }
        
        System.out.println("🎯 VISITOR: Programa completado");
        return null;
    }
    
    @Override
    public String visitDeclaracionVariable(MiniLenguajeParser.DeclaracionVariableContext ctx) {
        if (ctx == null) return null;
        
        String nombre = ctx.ID().getText();
        String tipo = visit(ctx.tipo());
        System.out.println("🎯 VISITOR: Declaración de variable " + tipo + " " + nombre + " en función: " + funcionActual);
        
        // Si la variable tiene una expresión de inicialización
        if (ctx.expresion() != null) {
            System.out.println("🎯 VISITOR: Variable con inicialización");
            String valor = visit(ctx.expresion());
            if (valor != null) {
                generador.genAsignacion(nombre, valor);
            } else {
                System.out.println("🎯 VISITOR: Error: valor de inicialización es null");
                String valorPorDefecto = obtenerValorPorDefecto(tipo);
                generador.genAsignacion(nombre, valorPorDefecto);
            }
        } else {
            System.out.println("🎯 VISITOR: Variable sin inicialización");
            String valorPorDefecto = obtenerValorPorDefecto(tipo);
            generador.genAsignacion(nombre, valorPorDefecto);
        }
        return nombre;
    }
    
    @Override
    public String visitDeclaracionConstante(MiniLenguajeParser.DeclaracionConstanteContext ctx) {
        if (ctx == null) return null;
        
        String nombre = ctx.ID().getText();
        String tipo = visit(ctx.tipo());
        System.out.println("🎯 VISITOR: Declaración de constante " + tipo + " " + nombre + " en función: " + funcionActual);
        
        String valor = visit(ctx.expresion());
        if (valor != null) {
            generador.agregarInstruccion("// Constante: " + tipo + " " + nombre + " = " + valor);
            generador.genAsignacion(nombre, valor);
        } else {
            generador.agregarInstruccion("// Error: valor de constante es null");
            String valorPorDefecto = obtenerValorPorDefecto(tipo);
            generador.genAsignacion(nombre, valorPorDefecto);
        }
        return nombre;
    }
    
    @Override
    public String visitDeclaracionFuncion(MiniLenguajeParser.DeclaracionFuncionContext ctx) {
        String nombreFuncion = ctx.ID().getText();
        System.out.println("🎯 VISITOR: Encontré función -> " + nombreFuncion);
        
        // Cambiar al scope de la función
        String funcionAnterior = funcionActual;
        funcionActual = nombreFuncion;
        
        // Generar etiqueta para la función
        generador.genLabel("func_" + nombreFuncion);
        generador.agregarInstruccion("// Inicio de función: " + nombreFuncion);
        
        // Procesar parámetros
        if (ctx.parametros() != null) {
            System.out.println("🎯 VISITOR: Procesando parámetros de la función");
            visit(ctx.parametros());
        }
        
        // Procesar cuerpo de la función
        if (ctx.sentencia() != null) {
            System.out.println("🎯 VISITOR: Procesando cuerpo de la función...");
            for (MiniLenguajeParser.SentenciaContext sentencia : ctx.sentencia()) {
                visit(sentencia);
            }
        }
        
        // Generar return implícito si no hay uno explícito
        generador.agregarInstruccion("// Fin de función: " + nombreFuncion);
        generador.genReturn("0");
        
        // Restaurar scope anterior
        funcionActual = funcionAnterior;
        
        System.out.println("🎯 VISITOR: Función " + nombreFuncion + " completada");
        return null;
    }
    
    @Override
    public String visitParametros(MiniLenguajeParser.ParametrosContext ctx) {
        for (MiniLenguajeParser.ParametroContext param : ctx.parametro()) {
            String nombre = param.ID().getText();
            String tipo = visit(param.tipo());
            System.out.println("🎯 VISITOR: Procesando parámetro -> " + tipo + " " + nombre);
            generador.agregarInstruccion("param " + tipo + " " + nombre);
        }
        return null;
    }
    
    @Override
    public String visitSentenciaAsignacion(MiniLenguajeParser.SentenciaAsignacionContext ctx) {
        if (ctx == null) return null;
        try {
            // Asignación a variable o a arreglo
            if (ctx.PRA() != null) {
                // Asignación a una posición de array: ID PRA expresion PRC ASIGNACION expresion PYC
                if (ctx.ID() == null) {
                    errores.add("Error: identificador nulo en asignación de arreglo");
                    generador.agregarInstruccion("// Error: identificador nulo en asignación de arreglo");
                    return null;
                }
                String nombre = ctx.ID().getText();
                String indice = visit(ctx.expresion(0));
                String valor = visit(ctx.expresion(1));
                if (nombre == null || indice == null || valor == null) {
                    errores.add("Error: asignación de arreglo con valores nulos (nombre, índice o valor)");
                    generador.agregarInstruccion("// Error: asignación de arreglo con valores nulos");
                    return null;
                }
                generador.agregarInstruccion(nombre + "[" + indice + "] = " + valor);
            } else {
                // Asignación a variable simple: ID ASIGNACION expresion PYC
                if (ctx.ID() == null) {
                    errores.add("Error: identificador nulo en asignación simple");
                    generador.agregarInstruccion("// Error: identificador nulo en asignación simple");
                    return null;
                }
                String nombre = ctx.ID().getText();
                String valor = visit(ctx.expresion(0));
                if (nombre == null || valor == null) {
                    errores.add("Error: asignación simple con valores nulos (nombre o valor)");
                    generador.agregarInstruccion("// Error: asignación simple con valores nulos");
                    return null;
                }
                generador.genAsignacion(nombre, valor);
            }
        } catch (Exception e) {
            errores.add("Excepción en visitSentenciaAsignacion: " + e.getMessage());
            generador.agregarInstruccion("// Excepción en asignación: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public String visitSentenciaIf(MiniLenguajeParser.SentenciaIfContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Encontré sentencia IF en función: " + funcionActual);
        
        // Evaluar la condición
        System.out.println("🎯 VISITOR: Evaluando condición del IF...");
        String condicion = visit(ctx.expresion());
        if (condicion == null) {
            generador.agregarInstruccion("// Error: condición del IF es null");
            return null;
        }
        
        // Crear etiquetas
        String labelElse = generador.newLabel();
        String labelFin = generador.newLabel();
        
        // Generar salto condicional
        System.out.println("🎯 VISITOR: Si condición es falsa, saltar a " + labelElse);
        generador.genIfFalse(condicion, labelElse);
        
        // Procesar bloque IF
        System.out.println("🎯 VISITOR: Procesando bloque IF...");
        if (ctx.sentencia(0) != null) {
            visit(ctx.sentencia(0));
        }
        
        // Si hay ELSE
        if (ctx.ELSE() != null) {
            System.out.println("🎯 VISITOR: Hay ELSE, saltando al final...");
            generador.genGoto(labelFin);
            generador.genLabel(labelElse);
            
            System.out.println("🎯 VISITOR: Procesando bloque ELSE...");
            if (ctx.sentencia(1) != null) {
                visit(ctx.sentencia(1));
            }
            
            generador.genLabel(labelFin);
        } else {
            generador.genLabel(labelElse);
        }
        
        System.out.println("🎯 VISITOR: IF completado");
        return null;
    }
    
    @Override
    public String visitSentenciaWhile(MiniLenguajeParser.SentenciaWhileContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Encontré sentencia WHILE en función: " + funcionActual);
        
        String labelInicio = generador.newLabel();
        String labelFin = generador.newLabel();
        
        generador.genLabel(labelInicio);
        
        String condicion = visit(ctx.expresion());
        if (condicion == null) {
            generador.agregarInstruccion("// Error: condición del WHILE es null");
            return null;
        }
        
        generador.genIfFalse(condicion, labelFin);
        
        if (ctx.sentencia() != null) {
            visit(ctx.sentencia());
        }
        
        generador.genGoto(labelInicio);
        generador.genLabel(labelFin);
        
        return null;
    }
    
    @Override
    public String visitSentenciaFor(MiniLenguajeParser.SentenciaForContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Encontré sentencia FOR en función: " + funcionActual);
        
        nivelAnidamiento++;
        String labelInicio = generador.newLabel();
        String labelFin = generador.newLabel();

        // Inicialización
        if (ctx.declaracionVariable() != null) {
            visit(ctx.declaracionVariable());
        } else if (ctx.sentenciaAsignacion() != null) {
            visit(ctx.sentenciaAsignacion());
        }

        generador.genLabel(labelInicio);

        // Condición
        if (ctx.expresion(0) != null) {
            String condicion = visit(ctx.expresion(0));
            if (condicion != null) {
                generador.genIfFalse(condicion, labelFin);
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

        generador.genGoto(labelInicio);
        generador.genLabel(labelFin);
        nivelAnidamiento--;
        
        return null;
    }
    
    @Override
    public String visitSentenciaPrint(MiniLenguajeParser.SentenciaPrintContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Encontré sentencia PRINT en función: " + funcionActual);
        
        String valor = visit(ctx.expresion());
        if (valor != null) {
            generador.genPrint(valor);
        } else {
            generador.agregarInstruccion("// Error: valor de print es null");
            generador.genPrint("null");
        }
        return null;
    }
    
    @Override
    public String visitSentenciaReturn(MiniLenguajeParser.SentenciaReturnContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Encontré sentencia RETURN en función: " + funcionActual);
        
        if (ctx.expresion() != null) {
            String valor = visit(ctx.expresion());
            if (valor != null) {
                generador.genReturn(valor);
            } else {
                generador.agregarInstruccion("// Error: valor de return es null");
                generador.genReturn("0");
            }
        } else {
            generador.genReturn("0");
        }
        return null;
    }
    
    @Override
    public String visitExpresion(MiniLenguajeParser.ExpresionContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Procesando expresión");
        String resultado = visit(ctx.expresionLogica());
        System.out.println("🎯 VISITOR: Resultado de expresión: " + resultado);
        return resultado;
    }
    
    @Override
    public String visitExpresionAritmetica(MiniLenguajeParser.ExpresionAritmeticaContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Procesando expresión aritmética con " + ctx.termino().size() + " términos");
        
        if (ctx.termino().size() == 1) {
            String resultado = visit(ctx.termino(0));
            System.out.println("🎯 VISITOR: Expresión aritmética simple: " + resultado);
            return resultado;
        }

        String resultado = visit(ctx.termino(0));
        if (resultado == null) {
            generador.agregarInstruccion("// Error: primer operando de expresión aritmética es null");
            return "0";
        }

        // Procesar operadores con asociatividad izquierda: +, -
        for (int i = 1; i < ctx.termino().size(); i++) {
            String operador = ctx.getChild(2 * i - 1).getText();
            String operando = visit(ctx.termino(i));
            if (operando == null) {
                generador.agregarInstruccion("// Error: operando " + i + " de expresión aritmética es null");
                operando = "0";
            }
            
            System.out.println("🎯 VISITOR: Generando operación " + resultado + " " + operador + " " + operando);
            resultado = generador.genOperacionBinaria(operador, resultado, operando);
        }
        return resultado;
    }
    
    @Override
    public String visitTermino(MiniLenguajeParser.TerminoContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Procesando término con " + ctx.factor().size() + " factores");
        
        if (ctx.factor().size() == 1) {
            String resultado = visit(ctx.factor(0));
            System.out.println("🎯 VISITOR: Término simple: " + resultado);
            return resultado;
        }

        String resultado = visit(ctx.factor(0));
        if (resultado == null) {
            generador.agregarInstruccion("// Error: primer factor de término es null");
            return "0";
        }

        // Procesar operadores con asociatividad izquierda: *, /, %
        for (int i = 1; i < ctx.factor().size(); i++) {
            String operador = ctx.getChild(2 * i - 1).getText();
            String operando = visit(ctx.factor(i));
            if (operando == null) {
                generador.agregarInstruccion("// Error: factor " + i + " de término es null");
                operando = "0";
            }
            
            System.out.println("🎯 VISITOR: Generando operación " + resultado + " " + operador + " " + operando);
            resultado = generador.genOperacionBinaria(operador, resultado, operando);
        }
        return resultado;
    }
    
    @Override
    public String visitFactor(MiniLenguajeParser.FactorContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Procesando factor");
        
        if (ctx.INTEGER() != null) {
            String numero = ctx.INTEGER().getText();
            System.out.println("🎯 VISITOR: Encontré número -> " + numero);
            return numero;
        }
        if (ctx.FLOAT() != null) {
            String numero = ctx.FLOAT().getText();
            System.out.println("🎯 VISITOR: Encontré float -> " + numero);
            return numero;
        }
        if (ctx.ID() != null) {
            String variable = ctx.ID().getText();
            System.out.println("🎯 VISITOR: Encontré variable -> " + variable);
            return variable;
        }
        if (ctx.STRING() != null) {
            String string = ctx.STRING().getText();
            System.out.println("🎯 VISITOR: Encontré string -> " + string);
            return string;
        }
        if (ctx.CHAR() != null) {
            String char_val = ctx.CHAR().getText();
            System.out.println("🎯 VISITOR: Encontré char -> " + char_val);
            return char_val;
        }
        if (ctx.expresion() != null) {
            System.out.println("🎯 VISITOR: Encontré expresión entre paréntesis");
            return visit(ctx.expresion());
        }
        if (ctx.llamadaFuncion() != null) {
            return visit(ctx.llamadaFuncion());
        }
        if (ctx.TRUE() != null) {
            System.out.println("🎯 VISITOR: Encontré true");
            return "true";
        }
        if (ctx.FALSE() != null) {
            System.out.println("🎯 VISITOR: Encontré false");
            return "false";
        }
        if (ctx.NOT() != null || ctx.MENOS() != null) {
            String operador = ctx.NOT() != null ? "!" : "-";
            System.out.println("🎯 VISITOR: Encontré operador unario " + operador);
            String factor = visit(ctx.factor());
            if (factor != null) {
                return generador.genOperacionUnaria(operador, factor);
            }
        }
        
        System.out.println("🎯 VISITOR: Factor no reconocido");
        generador.agregarInstruccion("// Error: factor no reconocido");
        return "0";
    }
    
    @Override
    public String visitLlamadaFuncion(MiniLenguajeParser.LlamadaFuncionContext ctx) {
        if (ctx == null) return null;
        
        String nombreFuncion = ctx.ID().getText();
        System.out.println("🎯 VISITOR: Encontré llamada a función -> " + nombreFuncion + " desde función: " + funcionActual);
        
        List<String> argumentos = new ArrayList<>();
        
        if (ctx.argumentos() != null) {
            for (int i = 0; i < ctx.argumentos().expresion().size(); i++) {
                String valor = visit(ctx.argumentos().expresion(i));
                if (valor != null) {
                    argumentos.add(valor);
                }
            }
        }
        
        return generador.genLlamadaFuncion(nombreFuncion, argumentos);
    }
    
    @Override
    public String visitExpresionComparacion(MiniLenguajeParser.ExpresionComparacionContext ctx) {
        if (ctx == null) return null;
        
        // Si solo hay una expresión aritmética, retornarla directamente
        if (ctx.expresionAritmetica().size() == 1) {
            String resultado = visit(ctx.expresionAritmetica(0));
            System.out.println("🎯 VISITOR: Expresión de comparación simple: " + resultado);
            return resultado;
        }
        
        // Si hay dos o más, hacer la comparación
        if (ctx.expresionAritmetica().size() >= 2) {
            String op1 = visit(ctx.expresionAritmetica(0));
            String op2 = visit(ctx.expresionAritmetica(1));
            
            if (op1 == null || op2 == null) return null;
            
            String operador = ctx.getChild(1).getText();
            System.out.println("🎯 VISITOR: Generando comparación " + op1 + " " + operador + " " + op2);
            return generador.genComparacion(operador, op1, op2);
        }
        
        return null;
    }
    
    @Override
    public String visitExpresionLogica(MiniLenguajeParser.ExpresionLogicaContext ctx) {
        if (ctx == null) return null;
        
        // Si solo hay una expresión de comparación, retornarla directamente
        if (ctx.expresionComparacion().size() == 1) {
            String resultado = visit(ctx.expresionComparacion(0));
            System.out.println("🎯 VISITOR: Expresión lógica simple: " + resultado);
            return resultado;
        }

        // Si hay dos o más, hacer la operación lógica
        if (ctx.expresionComparacion().size() >= 2) {
            String resultado = visit(ctx.expresionComparacion(0));
            if (resultado == null) return null;

            for (int i = 1; i < ctx.expresionComparacion().size(); i++) {
                String operador = ctx.getChild(2 * i - 1).getText();
                String operando = visit(ctx.expresionComparacion(i));
                if (operando == null) return null;
                resultado = generador.genOperacionBinaria(operador, resultado, operando);
            }
            return resultado;
        }
        
        return null;
    }
    
    @Override
    public String visitSentenciaBreak(MiniLenguajeParser.SentenciaBreakContext ctx) {
        if (ctx == null) return null;
        
        if (nivelAnidamiento > 0) {
            generador.agregarInstruccion("break");
        }
        return null;
    }
    
    @Override
    public String visitSentenciaContinue(MiniLenguajeParser.SentenciaContinueContext ctx) {
        if (ctx == null) return null;
        
        if (nivelAnidamiento > 0) {
            generador.agregarInstruccion("continue");
        }
        return null;
    }
    
    @Override
    public String visitBloque(MiniLenguajeParser.BloqueContext ctx) {
        if (ctx == null) return null;
        
        System.out.println("🎯 VISITOR: Procesando bloque con " + ctx.sentencia().size() + " sentencias en función: " + funcionActual);
        
        for (MiniLenguajeParser.SentenciaContext sentencia : ctx.sentencia()) {
            visit(sentencia);
        }
        
        return null;
    }
    
    @Override
    public String visitSentenciaGlobal(MiniLenguajeParser.SentenciaGlobalContext ctx) {
        if (ctx == null) return null;
        System.out.println("🎯 VISITOR: Procesando sentencia global");

        if (ctx.sentenciaPrint() != null) {
            visit(ctx.sentenciaPrint());
        } else if (ctx.sentenciaReturn() != null) {
            visit(ctx.sentenciaReturn());
        } else if (ctx.sentenciaIf() != null) {
            visit(ctx.sentenciaIf());
        } else if (ctx.sentenciaWhile() != null) {
            visit(ctx.sentenciaWhile());
        } else if (ctx.sentenciaFor() != null) {
            visit(ctx.sentenciaFor());
        } else if (ctx.bloque() != null) {
            visit(ctx.bloque());
        }
        return null;
    }
    
    @Override
    public String visitImportacion(MiniLenguajeParser.ImportacionContext ctx) {
        if (ctx == null) return null;
        
        String libreria = ctx.STRING().getText();
        System.out.println("🎯 VISITOR: Encontré importación -> " + libreria);
        generador.agregarInstruccion("// Import: " + libreria);
        
        return null;
    }
    
    @Override
    public String visitTipo(MiniLenguajeParser.TipoContext ctx) {
        if (ctx == null) return null;
        
        if (ctx.INT() != null) {
            return "int";
        }
        if (ctx.FLOAT_TYPE() != null) {
            return "float";
        }
        if (ctx.STRING_TYPE() != null) {
            return "string";
        }
        if (ctx.CHAR_TYPE() != null) {
            return "char";
        }
        if (ctx.BOOLEAN_TYPE() != null) {
            return "boolean";
        }
        if (ctx.VOID() != null) {
            return "void";
        }
        return null;
    }
    
    // Método auxiliar para obtener valores por defecto según el tipo
    private String obtenerValorPorDefecto(String tipo) {
        if (tipo == null) return "0";
        switch (tipo.toLowerCase()) {
            case "int":
                return "0";
            case "float":
                return "0.0";
            case "string":
                return "\"\"";
            case "char":
                return "'\\0'";
            case "boolean":
                return "false";
            default:
                return "0";
        }
    }

    public List<String> getErrores() {
        return errores;
    }
} 