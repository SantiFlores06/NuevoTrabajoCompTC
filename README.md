# Trabajo Integrador de Técnicas de Compilación

Creamos un compilador para un lenguaje, utilizando Maven y ANTLR4

## Trabajo Compilador Nuevo

Luego de haber empezado un primer trabajo, debido a errores a los cuales no les pude encontrar solución, decidí empezar un proyecto de 0 nuevo.

Link Repositorio GitHub proyecto viejo: https://github.com/SantiFlores06/TrabajoFinalTC

## Descripción de Commits

### Estructura Inicial
- **Configuración del proyecto Maven** con ANTLR4 y dependencias necesarias
- **Creación de la gramática básica** MiniLenguaje.g4 con reglas para variables, funciones y expresiones
- **Implementación de TablaSimbolos** para manejo de scopes y símbolos
- **Desarrollo del SimbolosListener** para análisis semántico

### Análisis Léxico y Sintáctico
- **Análisis léxico completo** con reconocimiento de tokens (ID, INTEGER, FLOAT, STRING, CHAR, BOOLEAN)
- **Análisis sintáctico** con árbol de análisis y visualización
- **Reglas gramaticales** para declaraciones, sentencias y expresiones
- **Soporte para operaciones aritméticas** (+, -, *, /, %) y lógicas (&&, ||, !)

### Análisis Semántico
- **Detección de errores críticos**: tipos incorrectos, variables no definidas, modificación de constantes
- **Detección de advertencias**: variables no usadas, funciones no usadas, parámetros no utilizados
- **Verificación de tipos** y compatibilidad entre tipos de datos
- **Control de scopes** y ámbito de variables

### Características del Lenguaje
- **Tipos de datos**: int, float, string, char, boolean, void
- **Declaraciones**: variables, constantes, funciones
- **Estructuras de control**: if, while, for (dentro de funciones)
- **Operadores**: aritméticos, comparación, lógicos
- **Importaciones** de librerías

### Funcionalidades del Compilador
- **Visualización del árbol sintáctico**
- **Tabla de símbolos** con información detallada
- **Reporte de errores críticos** y advertencias
- **Análisis de uso** de variables, funciones y librerías
- **Verificación de bucles infinitos** potenciales

### Mejoras y Correcciones
- **Corrección de gramática** para eliminar comillas simples en reglas del parser
- **Soporte completo para tipo char** con literales de carácter
- **Reorganización de tokens léxicos** para correcto reconocimiento
- **Optimización del análisis semántico** y detección de errores
