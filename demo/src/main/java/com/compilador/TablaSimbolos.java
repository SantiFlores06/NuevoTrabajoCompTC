package com.compilador;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class TablaSimbolos {
    private Map<String, Simbolo> simbolos;
    private TablaSimbolos padre; // Para manejar scopes anidados
    private String nombreScope;
    private List<TablaSimbolos> hijos = new ArrayList<>();

    public TablaSimbolos() {
        this.simbolos = new HashMap<>();
        this.padre = null;
        this.nombreScope = "global";
    }

    public TablaSimbolos(TablaSimbolos padre, String nombreScope) {
        this.simbolos = new HashMap<>();
        this.padre = padre;
        this.nombreScope = nombreScope;
    }

    public void insertar(String nombre, String tipo, String valor, String categoria) {
        if (simbolos.containsKey(nombre)) {
            throw new RuntimeException("Variable '" + nombre + "' ya declarada en el scope " + nombreScope);
        }
        simbolos.put(nombre, new Simbolo(nombre, tipo, valor, categoria));
    }

    // Método sobrecargado para mantener compatibilidad
    public void insertar(String nombre, String tipo, String valor) {
        insertar(nombre, tipo, valor, "variable");
    }

    public Simbolo buscar(String nombre) {
        Simbolo simbolo = simbolos.get(nombre);
        if (simbolo != null) {
            return simbolo;
        }
        if (padre != null) {
            return padre.buscar(nombre);
        }
        return null;
    }

    public boolean existe(String nombre) {
        return buscar(nombre) != null;
    }

    public void actualizar(String nombre, String valor) {
        Simbolo simbolo = buscar(nombre);
        if (simbolo != null) {
            simbolo.setValor(valor);
        } else {
            throw new RuntimeException("Variable '" + nombre + "' no declarada");
        }
    }

    public void imprimir() {
        System.out.println("\n=== TABLA DE SÍMBOLOS (" + nombreScope + ") ===");
        System.out.printf("%-20s %-15s %-20s %-15s\n", "NOMBRE", "TIPO", "VALOR", "CATEGORIA");
        System.out.println("------------------------------------------------------------");
        
        for (Simbolo simbolo : simbolos.values()) {
            System.out.printf("%-20s %-15s %-20s %-15s\n", 
                             simbolo.getNombre(), 
                             simbolo.getTipo(), 
                             simbolo.getValor(),
                             simbolo.getCategoria());
        }
        
        if (padre != null) {
            System.out.println("\n--- Scope padre ---");
            padre.imprimir();
        }
    }

    public TablaSimbolos getPadre() {
        return padre;
    }

    public String getNombreScope() {
        return nombreScope;
    }

    public java.util.Collection<Simbolo> getSimbolos() {
        return simbolos.values();
    }

    public void agregarHijo(TablaSimbolos hijo) {
        hijos.add(hijo);
    }

    public List<TablaSimbolos> getHijos() {
        return hijos;
    }

    public static class Simbolo {
        private String nombre;
        private String tipo;
        private String valor;
        private String categoria;

        public Simbolo(String nombre, String tipo, String valor, String categoria) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.valor = valor;
            this.categoria = categoria;
        }

        public String getNombre() { return nombre; }
        public String getTipo() { return tipo; }
        public String getValor() { return valor; }
        public String getCategoria() { return categoria; }
        public void setValor(String valor) { this.valor = valor; }
    }
} 