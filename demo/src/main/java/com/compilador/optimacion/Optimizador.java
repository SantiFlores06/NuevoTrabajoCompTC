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
        System.out.println(" INICIANDO FASE DE OPTIMIZACIÓN...");
        
        // La optimización se ejecuta en un bucle hasta que no haya más cambios.
        boolean cambios;
        int maxIteraciones = 10; // Límite para evitar bucles infinitos
        int iteracion = 0;
        do {
            iteracion++;
            System.out.println("\n   --- Iteración de Optimización #" + iteracion + " ---");
            cambios = propagarConstantes();
            cambios |= eliminarCodigoMuerto();
            cambios |= simplificarExpresiones();
        } while (cambios && iteracion < maxIteraciones);
        
        System.out.println("✅ FASE DE OPTIMIZACIÓN COMPLETADA en " + iteracion + " iteraciones.");
        return this.codigo;
    }

    /**
     * Propaga constantes mejorada: invalida cuando se reasigna y propaga en expresiones.
     * @return true si hubo cambios, false si no.
     */
    public boolean propagarConstantes() {
        Map<String, String> constantValues = new HashMap<>();
        List<String> codigoOptimizado = new ArrayList<>();
        boolean huboCambios = false;

        for (String linea : codigo) {
            if (linea.endsWith(":") || linea.startsWith("goto ") || linea.startsWith("if ") || linea.startsWith("call ")) {
                codigoOptimizado.add(linea);
                continue;
            }
            if (linea.contains(" = ")) {
                String[] partes = linea.split(" = ", 2);
                if (partes.length == 2) {
                    String destino = partes[0].trim();
                    String valor = partes[1].trim();
                    String valorOriginal = valor;
                    if (valor.matches("-?\\d+") || valor.matches("-?\\d+\\.\\d+") || (valor.startsWith("'") && valor.endsWith("'"))) {
                        constantValues.put(destino, valor);
                    } else {
                        for (Map.Entry<String, String> entry : constantValues.entrySet()) {
                            String regex = "\\b" + entry.getKey() + "\\b";
                            valor = valor.replaceAll(regex, entry.getValue());
                        }
                        if (valor.matches("-?\\d+") || valor.matches("-?\\d+\\.\\d+")) {
                            constantValues.put(destino, valor);
                        } else {
                            constantValues.remove(destino);
                        }
                    }
                    String lineaOptimizada = destino + " = " + valor;
                    if (!lineaOptimizada.equals(linea)) huboCambios = true;
                    codigoOptimizado.add(lineaOptimizada);
                    continue;
                }
            }
            String lineaOptimizada = linea;
            for (Map.Entry<String, String> entry : constantValues.entrySet()) {
                String regex = "\\b" + entry.getKey() + "\\b";
                lineaOptimizada = lineaOptimizada.replaceAll(regex, entry.getValue());
            }
            if (!lineaOptimizada.equals(linea)) huboCambios = true;
            codigoOptimizado.add(lineaOptimizada);
        }
        boolean cambioTamano = (codigoOptimizado.size() != codigo.size());
        codigo = codigoOptimizado;
        return huboCambios || cambioTamano;
    }

    /**
     * Eliminación de código muerto mejorada: considera llamadas a funciones.
     * @return true si hubo cambios, false si no.
     */
    public boolean eliminarCodigoMuerto() {
        Set<Integer> lineasAlcanzables = new HashSet<>();
        Map<String, Integer> etiquetas = new HashMap<>();
        for (int i = 0; i < codigo.size(); i++) {
            String linea = codigo.get(i);
            if (linea.endsWith(":")) {
                String etiqueta = linea.substring(0, linea.length() - 1);
                etiquetas.put(etiqueta, i);
            }
        }
        marcarLineasAlcanzables(0, lineasAlcanzables, etiquetas);
        if (etiquetas.containsKey("func_main")) {
            marcarLineasAlcanzables(etiquetas.get("func_main"), lineasAlcanzables, etiquetas);
        }
        for (int i = 0; i < codigo.size(); i++) {
            String linea = codigo.get(i);
            if (linea.startsWith("call ")) {
                String funcion = linea.substring(5).trim();
                if (etiquetas.containsKey(funcion)) {
                    marcarLineasAlcanzables(etiquetas.get(funcion), lineasAlcanzables, etiquetas);
                }
            }
        }
        List<String> codigoOptimizado = new ArrayList<>();
        for (int i = 0; i < codigo.size(); i++) {
            if (lineasAlcanzables.contains(i)) {
                codigoOptimizado.add(codigo.get(i));
            }
        }
        boolean huboCambios = (codigoOptimizado.size() != codigo.size());
        codigo = codigoOptimizado;
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

    /**
     * Marca recursivamente las líneas alcanzables desde una posición dada.
     */
    private void marcarLineasAlcanzables(int linea, Set<Integer> lineasAlcanzables, Map<String, Integer> etiquetas) {
        if (linea < 0 || linea >= codigo.size() || lineasAlcanzables.contains(linea)) {
            return;
        }
        lineasAlcanzables.add(linea);
        String instruccion = codigo.get(linea);
        if (instruccion.startsWith("goto ")) {
            String etiqueta = instruccion.substring(5).trim();
            if (etiquetas.containsKey(etiqueta)) {
                marcarLineasAlcanzables(etiquetas.get(etiqueta), lineasAlcanzables, etiquetas);
            }
            return;
        }
        if (instruccion.startsWith("if ")) {
            String[] partes = instruccion.split(" goto ");
            if (partes.length == 2) {
                String etiqueta = partes[1].trim();
                if (etiquetas.containsKey(etiqueta)) {
                    marcarLineasAlcanzables(etiquetas.get(etiqueta), lineasAlcanzables, etiquetas);
                }
            }
        }
        if (instruccion.equals("return") || instruccion.startsWith("return ")) {
            return;
        }
        marcarLineasAlcanzables(linea + 1, lineasAlcanzables, etiquetas);
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