package com.compilador.generacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Generador de código de tres direcciones - Versión educativa
 * Responsable de crear instrucciones simples y manejar temporales/etiquetas
 */
public class GeneradorCodigo {
    
    private List<String> codigo;
    private int tempCounter;
    private int labelCounter;
    
    public GeneradorCodigo() {
        this.codigo = new ArrayList<>();
        this.tempCounter = 0;
        this.labelCounter = 0;
        System.out.println("🔧 GENERADOR: Iniciado y listo para trabajar");
    }
    
    /**
     * Genera un nuevo nombre de variable temporal
     */
    public String newTemp() {
        String temp = "t" + (tempCounter++);
        System.out.println("🔧 GENERADOR: Creé temporal -> " + temp);
        return temp;
    }
    
    /**
     * Genera una nueva etiqueta
     */
    public String newLabel() {
        String label = "L" + (labelCounter++);
        System.out.println("🔧 GENERADOR: Creé etiqueta -> " + label);
        return label;
    }
    
    /**
     * Agrega una instrucción al código
     */
    public void agregarInstruccion(String instruccion) {
        System.out.println("🔧 GENERADOR: Agregando instrucción -> " + instruccion);
        codigo.add(instruccion);
    }
    
    /**
     * Genera código para una asignación: x = valor
     */
    public void genAsignacion(String variable, String valor) {
        System.out.println("🔧 GENERADOR: Generando asignación " + variable + " = " + valor);
        
        String instruccion = variable + " = " + valor;
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
    }
    
    /**
     * Genera código para una operación binaria: t0 = a + b
     */
    public String genOperacionBinaria(String operador, String op1, String op2) {
        System.out.println("🔧 GENERADOR: Generando operación " + op1 + " " + operador + " " + op2);
        
        // Validación de división por cero
        if ((operador.equals("/") || operador.equals("%")) && esNumero(op2) && Double.parseDouble(op2) == 0) {
            System.out.println("🔧 GENERADOR: ⚠️ División por cero detectada!");
            agregarInstruccion("// Error: División por cero - " + op1 + " " + operador + " " + op2);
            return "ERROR_DIVISION_POR_CERO";
        }
        
        String temp = newTemp();
        String instruccion = temp + " = " + op1 + " " + operador + " " + op2;
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
        return temp;
    }
    
    /**
     * Genera código para una operación unaria: t0 = !a o t0 = -a
     */
    public String genOperacionUnaria(String operador, String operando) {
        System.out.println("🔧 GENERADOR: Generando operación unaria " + operador + " " + operando);
        
        String temp = newTemp();
        String instruccion = temp + " = " + operador + " " + operando;
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
        return temp;
    }
    
    /**
     * Genera código para una comparación: t0 = a > b
     */
    public String genComparacion(String operador, String op1, String op2) {
        System.out.println("🔧 GENERADOR: Generando comparación " + op1 + " " + operador + " " + op2);
        
        String temp = newTemp();
        String instruccion = temp + " = " + op1 + " " + operador + " " + op2;
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
        return temp;
    }
    
    /**
     * Genera una etiqueta: L0:
     */
    public void genLabel(String label) {
        System.out.println("🔧 GENERADOR: Colocando etiqueta " + label);
        
        String instruccion = label + ":";
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
    }
    
    /**
     * Genera un salto condicional: if !condicion goto L0
     */
    public void genIfFalse(String condicion, String label) {
        System.out.println("🔧 GENERADOR: Generando salto condicional si " + condicion + " es falso");
        
        String instruccion = "if !" + condicion + " goto " + label;
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
    }
    
    /**
     * Genera un salto incondicional: goto L0
     */
    public void genGoto(String label) {
        System.out.println("🔧 GENERADOR: Generando salto incondicional a " + label);
        
        String instruccion = "goto " + label;
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
    }
    
    /**
     * Genera código para print: print valor
     */
    public void genPrint(String valor) {
        System.out.println("🔧 GENERADOR: Generando print de " + valor);
        
        String instruccion = "print " + valor;
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
    }
    
    /**
     * Genera código para return: return valor
     */
    public void genReturn(String valor) {
        System.out.println("🔧 GENERADOR: Generando return " + valor);
        
        String instruccion = "return " + valor;
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
    }
    
    /**
     * Genera código para llamada de función: t0 = call funcion(args)
     */
    public String genLlamadaFuncion(String nombreFuncion, List<String> argumentos) {
        System.out.println("🔧 GENERADOR: Generando llamada a función " + nombreFuncion);
        
        StringBuilder args = new StringBuilder();
        for (int i = 0; i < argumentos.size(); i++) {
            if (i > 0) args.append(", ");
            args.append(argumentos.get(i));
        }
        
        String temp = newTemp();
        String instruccion = temp + " = call " + nombreFuncion + "(" + args.toString() + ")";
        codigo.add(instruccion);
        
        System.out.println("🔧 GENERADOR: Generé -> " + instruccion);
        return temp;
    }
    
    /**
     * Obtiene el código generado
     */
    public List<String> getCodigo() {
        return new ArrayList<>(codigo);
    }
    
    /**
     * Imprime el código generado
     */
    public void imprimirCodigo() {
        System.out.println("\n📝 === CÓDIGO DE TRES DIRECCIONES ===");
        for (int i = 0; i < codigo.size(); i++) {
            String instruccion = codigo.get(i);
            // Si es una etiqueta (termina en :), no agregar número de línea
            if (instruccion.endsWith(":")) {
                System.out.println("     " + instruccion);
            } else {
                System.out.printf("%3d: %s\n", i, instruccion);
            }
        }
        System.out.println("Total instrucciones: " + codigo.size());
    }
    
    /**
     * Imprime estadísticas del código generado
     */
    public void imprimirEstadisticas() {
        System.out.println("\n📊 ESTADÍSTICAS:");
        System.out.println("   - Temporales creados: " + tempCounter);
        System.out.println("   - Etiquetas creadas: " + labelCounter);
        System.out.println("   - Instrucciones totales: " + codigo.size());
    }
    
    /**
     * Verifica si una cadena es un número
     */
    private boolean esNumero(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
} 