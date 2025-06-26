package com.compilador.optimacion;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase encargada de aplicar optimizaciones al código intermedio.
 */
public class Optimizador {

    private List<String> codigo;

    public Optimizador(List<String> codigo) {
        this.codigo = new ArrayList<>(codigo);
    }

    /**
     * Aplica todas las optimizaciones en secuencia.
     * @return El código intermedio optimizado.
     */
    public List<String> optimizar() {
        System.out.println("🚀 INICIANDO FASE DE OPTIMIZACIÓN...");
        
        // La optimización se ejecuta en un bucle hasta que no haya más cambios.
        boolean cambios;
        int maxIteraciones = 10; // Límite para evitar bucles infinitos
        int iteracion = 0;
        do {
            iteracion++;
            System.out.println("\n   --- Iteración de Optimización #" + iteracion + " ---");
            cambios = realizarPropagacionConstantes();
            cambios |= eliminarCodigoMuerto();
            cambios |= simplificarExpresiones();
        } while (cambios && iteracion < maxIteraciones);
        
        System.out.println("✅ FASE DE OPTIMIZACIÓN COMPLETADA en " + iteracion + " iteraciones.");
        return this.codigo;
    }

    /**
     * Realiza la propagación de constantes y el plegado de constantes.
     * Esta optimización reemplaza variables por sus valores constantes conocidos
     * y evalúa expresiones constantes en tiempo de compilación.
     */
    private boolean realizarPropagacionConstantes() {
        System.out.println("   -> Aplicando Propagación y Plegado de Constantes (con scopes)...");
        boolean huboCambios = false;
        
        Map<String, String> constantesGlobales = new HashMap<>();
        Map<String, String> constantesLocales = new HashMap<>();
        boolean enFuncion = false;

        List<String> codigoNuevo = new ArrayList<>();

        for (String instruccionActual : this.codigo) {
            String instruccionOriginal = instruccionActual;
            String instruccionModificada = instruccionActual;

            // Detección de límites de función
            if (instruccionActual.startsWith("func_")) {
                enFuncion = true;
                constantesLocales.clear(); // Limpiar constantes locales al entrar en una nueva función
            } else if (enFuncion && (instruccionActual.startsWith("return") || instruccionActual.startsWith("// Fin de función"))) {
                 if(instruccionActual.contains("main")){ // Heurística simple para detectar fin de scope global
                    enFuncion = false;
                 }
            }

            // Propagar constantes: locales tienen prioridad sobre globales
            Map<String, String> constantesActivas = new HashMap<>(constantesGlobales);
            constantesActivas.putAll(constantesLocales);

            for (Map.Entry<String, String> entry : constantesActivas.entrySet()) {
                instruccionModificada = instruccionModificada.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
            }

            // Patrones
            Pattern asignacion = Pattern.compile("^(\\w+)\\s*=\\s*(.*)$");
            Matcher matcherAsignacion = asignacion.matcher(instruccionModificada);
            
            Pattern operacionBinaria = Pattern.compile("^(\\w+)\\s*=\\s*(\\S+)\\s*([+\\-*/%])\\s*(\\S+)$");
            Matcher matcherOperacion = operacionBinaria.matcher(instruccionModificada);

            if (matcherOperacion.matches()) {
                String res = matcherOperacion.group(1);
                String op1 = matcherOperacion.group(2);
                String op = matcherOperacion.group(3);
                String op2 = matcherOperacion.group(4);
                
                try {
                    if (esNumero(op1) && esNumero(op2)) {
                        // Plegado de constantes
                        double val1 = Double.parseDouble(op1);
                        double val2 = Double.parseDouble(op2);
                        double resultado = 0;
                        switch (op) {
                            case "+": resultado = val1 + val2; break;
                            case "-": resultado = val1 - val2; break;
                            case "*": resultado = val1 * val2; break;
                            case "/": if (val2 == 0) throw new ArithmeticException("División por cero"); resultado = val1 / val2; break;
                            case "%": if (val2 == 0) throw new ArithmeticException("División por cero"); resultado = val1 % val2; break;
                        }
                        String valorFinal = (resultado == (int) resultado) ? String.valueOf((int) resultado) : String.valueOf(resultado);
                        instruccionModificada = res + " = " + valorFinal;
                        
                        // Almacenar en el mapa correcto
                        if(enFuncion) constantesLocales.put(res, valorFinal);
                        else constantesGlobales.put(res, valorFinal);

                        System.out.println("      [*] Plegado: " + instruccionOriginal + " -> " + instruccionModificada);
                    } else {
                        if(enFuncion) constantesLocales.remove(res);
                        else constantesGlobales.remove(res);
                    }
                } catch (Exception e) {
                    if(enFuncion) constantesLocales.remove(res);
                    else constantesGlobales.remove(res);
                }

            } else if (matcherAsignacion.matches()) {
                String var = matcherAsignacion.group(1);
                String val = matcherAsignacion.group(2);

                if (esConstante(val)) {
                    if (enFuncion) {
                        constantesLocales.put(var, val);
                    } else {
                        constantesGlobales.put(var, val);
                    }
                    System.out.println("      [+] Constante encontrada (" + (enFuncion ? "local" : "global") + "): " + var + " = " + val);
                } else {
                    if (enFuncion) constantesLocales.remove(var);
                    else constantesGlobales.remove(var);
                }
            }
            
            if (!instruccionModificada.equals(instruccionOriginal)) {
                huboCambios = true;
            }
            codigoNuevo.add(instruccionModificada);
        }

        boolean listasDiferentes = !this.codigo.equals(codigoNuevo);
        this.codigo = codigoNuevo;
        return listasDiferentes;
    }

    /**
     * Realiza la eliminación de código muerto, específicamente asignaciones
     * a variables temporales que nunca se utilizan.
     */
    private boolean eliminarCodigoMuerto() {
        System.out.println("   -> Aplicando Eliminación de Código Muerto...");
        boolean huboCambios = false;
        
        // Paso 1: Encontrar todas las variables usadas
        Set<String> variablesUsadas = new HashSet<>();
        Pattern varPattern = Pattern.compile("\\b([a-zA-Z_]\\w*)\\b");

        for (String instruccion : this.codigo) {
            // Analizar el lado derecho de asignaciones
            if (instruccion.contains("=")) {
                String rhs = instruccion.substring(instruccion.indexOf('=') + 1);
                Matcher matcher = varPattern.matcher(rhs);
                while (matcher.find()) {
                    variablesUsadas.add(matcher.group(1));
                }
            }
            // Analizar otras instrucciones que usan variables
            if (instruccion.startsWith("print") || instruccion.startsWith("return") || instruccion.startsWith("if")) {
                 Matcher matcher = varPattern.matcher(instruccion);
                 while (matcher.find()) {
                    // Ignorar la palabra clave de la instrucción en sí
                    if (!matcher.group(1).equals("print") && !matcher.group(1).equals("return") && !matcher.group(1).equals("if")) {
                        variablesUsadas.add(matcher.group(1));
                    }
                }
            }
        }
        System.out.println("      [i] Variables usadas: " + variablesUsadas);

        // Paso 2: Eliminar asignaciones a variables temporales no usadas
        List<String> codigoNuevo = new ArrayList<>();
        Pattern asignacionTemp = Pattern.compile("^(t\\d+)\\s*=\\s*.*$");

        for (String instruccion : this.codigo) {
            Matcher matcher = asignacionTemp.matcher(instruccion);
            if (matcher.matches()) {
                String tempVar = matcher.group(1);
                if (variablesUsadas.contains(tempVar)) {
                    codigoNuevo.add(instruccion); // La variable se usa, se mantiene
                } else {
                    System.out.println("      [-] Código muerto eliminado: " + instruccion);
                    huboCambios = true; // Se eliminó una instrucción
                }
            } else {
                codigoNuevo.add(instruccion); // No es una asignación a temporal, se mantiene
            }
        }

        this.codigo = codigoNuevo;
        return huboCambios;
    }

    /**
     * Simplifica expresiones algebraicas (ej. x + 0 = x, x * 1 = x).
     */
    private boolean simplificarExpresiones() {
        System.out.println("   -> Aplicando Simplificación de Expresiones...");
        boolean huboCambios = false;
        List<String> codigoNuevo = new ArrayList<>();
        Pattern operacion = Pattern.compile("^(\\w+)\\s*=\\s*(\\S+)\\s*([+\\-*/])\\s*(\\S+)$");

        for (String instruccion : this.codigo) {
            String instruccionOriginal = instruccion;
            Matcher matcher = operacion.matcher(instruccion);

            if (matcher.matches()) {
                String res = matcher.group(1);
                String op1 = matcher.group(2);
                String op = matcher.group(3);
                String op2 = matcher.group(4);

                // Simplificaciones para + y -
                if (op.equals("+") && op2.equals("0")) { // x + 0 = x
                    instruccion = res + " = " + op1;
                } else if (op.equals("+") && op1.equals("0")) { // 0 + x = x
                    instruccion = res + " = " + op2;
                } else if (op.equals("-") && op2.equals("0")) { // x - 0 = x
                    instruccion = res + " = " + op1;
                } 
                // Simplificaciones para * y /
                else if (op.equals("*")) {
                    if (op2.equals("1")) { // x * 1 = x
                        instruccion = res + " = " + op1;
                    } else if (op1.equals("1")) { // 1 * x = x
                        instruccion = res + " = " + op2;
                    } else if (op2.equals("0") || op1.equals("0")) { // x * 0 = 0
                        instruccion = res + " = 0";
                    }
                } else if (op.equals("/") && op2.equals("1")) { // x / 1 = x
                    instruccion = res + " = " + op1;
                }
            }
            
            if (!instruccion.equals(instruccionOriginal)) {
                System.out.println("      [*] Simplificación: " + instruccionOriginal + " -> " + instruccion);
                huboCambios = true;
            }
            codigoNuevo.add(instruccion);
        }
        
        this.codigo = codigoNuevo;
        return huboCambios;
    }

    private boolean esNumero(String str) {
        if (str == null) return false;
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean esConstante(String str) {
        if (str == null) return false;
        // Es un número, un string entre comillas, o un booleano
        return esNumero(str) || str.matches("\"[^\"]*\"") || str.equals("true") || str.equals("false");
    }
} 