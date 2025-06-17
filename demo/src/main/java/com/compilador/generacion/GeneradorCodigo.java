package com.compilador.generacion;

import java.util.ArrayList;
import java.util.List;

public class GeneradorCodigo {
    private List<String> codigo;
    private int contadorTemporales;
    private int contadorEtiquetas;

    public GeneradorCodigo() {
        this.codigo = new ArrayList<>();
        this.contadorTemporales = 0;
        this.contadorEtiquetas = 0;
    }

    public String nuevaTemporal() {
        return "t" + (contadorTemporales++);
    }

    public String nuevaEtiqueta() {
        return "L" + (contadorEtiquetas++);
    }

    public void agregarInstruccion(String instruccion) {
        codigo.add(instruccion);
    }

    public void agregarInstruccion(String formato, Object... args) {
        codigo.add(String.format(formato, args));
    }

    public List<String> obtenerCodigo() {
        return new ArrayList<>(codigo);
    }

    public void limpiar() {
        codigo.clear();
        contadorTemporales = 0;
        contadorEtiquetas = 0;
    }

    // Métodos específicos para generar código de tres direcciones
    public String generarAsignacion(String destino, String valor) {
        String instruccion = destino + " = " + valor;
        agregarInstruccion(instruccion);
        return destino;
    }

    public String generarOperacion(String operador, String op1, String op2) {
        // Optimización: Si ambos operandos son constantes, evaluar en tiempo de compilación
        if (esNumero(op1) && esNumero(op2)) {
            try {
                double resultado = evaluarOperacion(operador, Double.parseDouble(op1), Double.parseDouble(op2));
                return String.valueOf(resultado);
            } catch (NumberFormatException e) {
                // Si hay error en la conversión, continuar con la generación normal
            }
        }
        
        String temp = nuevaTemporal();
        String instruccion = temp + " = " + op1 + " " + operador + " " + op2;
        agregarInstruccion(instruccion);
        return temp;
    }

    public String generarComparacion(String operador, String op1, String op2) {
        // Optimización: Si ambos operandos son constantes, evaluar en tiempo de compilación
        if (esNumero(op1) && esNumero(op2)) {
            try {
                boolean resultado = evaluarComparacion(operador, Double.parseDouble(op1), Double.parseDouble(op2));
                return String.valueOf(resultado);
            } catch (NumberFormatException e) {
                // Si hay error en la conversión, continuar con la generación normal
            }
        }

        String temp = nuevaTemporal();
        String instruccion = temp + " = " + op1 + " " + operador + " " + op2;
        agregarInstruccion(instruccion);
        return temp;
    }

    public String generarSalto(String etiqueta) {
        String instruccion = "goto " + etiqueta;
        agregarInstruccion(instruccion);
        return etiqueta;
    }

    public String generarSaltoCondicional(String condicion, String etiqueta) {
        String instruccion = "if " + condicion + " goto " + etiqueta;
        agregarInstruccion(instruccion);
        return etiqueta;
    }

    public String generarEtiqueta(String etiqueta) {
        agregarInstruccion(etiqueta + ":");
        return etiqueta;
    }

    // Métodos de utilidad para optimizaciones
    private boolean esNumero(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private double evaluarOperacion(String operador, double op1, double op2) {
        switch (operador) {
            case "+": return op1 + op2;
            case "-": return op1 - op2;
            case "*": return op1 * op2;
            case "/": 
                if (op2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return op1 / op2;
            case "%": 
                if (op2 == 0) {
                    throw new ArithmeticException("Módulo por cero");
                }
                return op1 % op2;
            default:
                throw new IllegalArgumentException("Operador no soportado: " + operador);
        }
    }

    private boolean evaluarComparacion(String operador, double op1, double op2) {
        switch (operador) {
            case "==": return op1 == op2;
            case "!=": return op1 != op2;
            case "<": return op1 < op2;
            case ">": return op1 > op2;
            case "<=": return op1 <= op2;
            case ">=": return op1 >= op2;
            default:
                throw new IllegalArgumentException("Operador de comparación no soportado: " + operador);
        }
    }

    // Métodos adicionales para operaciones especiales
    public String generarLlamadaFuncion(String nombreFuncion, List<String> argumentos) {
        StringBuilder args = new StringBuilder();
        for (int i = 0; i < argumentos.size(); i++) {
            if (i > 0) args.append(", ");
            args.append(argumentos.get(i));
        }
        String temp = nuevaTemporal();
        String instruccion = temp + " = call " + nombreFuncion + "(" + args.toString() + ")";
        agregarInstruccion(instruccion);
        return temp;
    }

    public void generarRetorno(String valor) {
        agregarInstruccion("return " + valor);
    }

    public void generarPrint(String valor) {
        agregarInstruccion("print " + valor);
    }
} 