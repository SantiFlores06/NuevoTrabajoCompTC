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

### Cambios recientes
- Se agregaron ejemplos de prueba cortos y válidos en la carpeta `demo/` (por ejemplo: `ejemplo_asignacion.txt`, `ejemplo_if.txt`, `ejemplo_operaciones.txt`).
- Ahora la visualización gráfica del árbol sintáctico se muestra en una ventana con barras de desplazamiento (scroll), permitiendo navegar árboles grandes cómodamente.
- Para ver el árbol sintáctico gráficamente, se utiliza `TreeViewer` de ANTLR dentro de un `JScrollPane` en un `JFrame`.
- **Análisis léxico:** Ahora se muestran correctamente todos los tokens del archivo fuente, ya que se fuerza el consumo de todos los tokens antes de imprimirlos.
- **Árbol sintáctico gráfico:** Se agregó una ventana gráfica (con scroll) que muestra el árbol sintáctico generado para el archivo de entrada.
- **Código intermedio:** El código intermedio generado se muestra por consola y también se guarda automáticamente en un archivo de texto llamado `codigo_intermedio.txt` en la carpeta de ejecución.

## Funcionamiento del Compilador

El compilador implementado sigue una arquitectura clásica de varias fases, cada una con responsabilidades bien definidas:

### 1. Análisis Léxico
- **Responsable:** `MiniLenguajeLexer.g4` (ANTLR)
- **Función:** Lee el código fuente y lo divide en tokens (palabras clave, identificadores, literales, operadores, etc.).
- **Salida:** Secuencia de tokens que se muestran por consola, con tipo, lexema, línea y columna.

### 2. Análisis Sintáctico
- **Responsable:** `MiniLenguajeParser.g4` (ANTLR)
- **Función:** Toma la secuencia de tokens y verifica que la estructura del programa cumpla la gramática del lenguaje. Construye el árbol sintáctico (AST).
- **Salida:** Árbol sintáctico textual y gráfico (ventana con scroll). Si hay errores, se reportan con línea y columna.

### 3. Análisis Semántico y Tabla de Símbolos
- **Responsable:** `SimbolosListener.java` y `TablaSimbolos.java`
- **Función:** Recorre el árbol sintáctico para:
  - Detectar errores semánticos (variables no declaradas, tipos incompatibles, constantes modificadas, etc.).
  - Detectar advertencias (variables no usadas, parámetros no utilizados, librerías no usadas, etc.).
  - Construir la tabla de símbolos, que almacena información de variables, funciones, parámetros y sus ámbitos (scopes).
- **Salida:** Tabla de símbolos detallada, errores y advertencias por consola (con colores: rojo para errores, amarillo para warnings, verde para éxito).

### 4. Generación de Código Intermedio
- **Responsable:** `CodigoVisitor.java` y `GeneradorCodigo.java`
- **Función:** Recorre el árbol sintáctico y genera código de tres direcciones (similar a ensamblador simple), usando temporales y etiquetas para operaciones y control de flujo.
- **Salida:** Código intermedio mostrado por consola y guardado en `codigo_intermedio.txt`.

### 5. Optimizador de Código
- **Responsable:** `Optimizador.java` (paquete `com.compilador.optimacion`)
- **Función:** Toma el código intermedio y aplica varias técnicas de optimización para mejorar la eficiencia y reducir el tamaño del código.
- **Técnicas implementadas:**
  - **Propagación y Plegado de Constantes:** Sustituye variables por sus valores constantes conocidos y resuelve operaciones constantes en tiempo de compilación. El optimizador respeta los ámbitos (scopes): las constantes globales solo se propagan en el ámbito global, y las locales solo dentro de cada función.
  - **Eliminación de Código Muerto:** Elimina asignaciones a variables temporales que nunca se usan posteriormente, reduciendo el código innecesario.
  - **Simplificación de Expresiones:** Aplica identidades algebraicas simples (por ejemplo, `x + 0` se convierte en `x`, `x * 1` en `x`, `x * 0` en `0`, etc.).
- **Funcionamiento:**
  - El optimizador ejecuta estas técnicas de forma iterativa hasta que el código ya no puede mejorarse más.
  - El resultado se muestra por consola y se guarda en `codigo_optimizado.txt`.

## Ejemplo de Flujo Completo

1. **Entrada:** Un archivo fuente en MiniLenguaje (por ejemplo, `ejemplo_completo.txt`).
2. **Análisis léxico y sintáctico:** Se muestran los tokens y el árbol sintáctico.
3. **Análisis semántico:** Se imprime la tabla de símbolos y se reportan errores/advertencias.
4. **Generación de código intermedio:** Se muestra y guarda el código de tres direcciones.
5. **Optimización:** Se muestra y guarda el código optimizado, con mensajes sobre las optimizaciones aplicadas.

## ¿Cómo ejecutar el compilador?

1. Compila el proyecto con Maven:
   ```sh
   mvn clean package
   ```
2. Ejecuta el compilador sobre un archivo fuente:
   ```sh
   java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo_completo.txt
   ```
3. Revisa los archivos `codigo_intermedio.txt` y `codigo_optimizado.txt` para ver el resultado de las optimizaciones.

Para cualquier duda sobre el funcionamiento interno de cada módulo, consulta los comentarios en el código fuente o pregunta directamente.

---

## Archivos de Prueba Disponibles

En la carpeta `demo/` encontrarás varios archivos de ejemplo para probar diferentes aspectos del compilador:

### Archivos Básicos
- `ejemplo.txt` - Ejemplo simple con variables y operaciones básicas
- `ejemplo_asignacion.txt` - Prueba de asignaciones de variables
- `ejemplo_operaciones.txt` - Operaciones aritméticas y lógicas
- `ejemplo_if.txt` - Estructuras de control condicionales

### Archivos Complejos
- `ejemplo_completo.txt` - Programa completo con funciones, constantes, variables y errores (para probar el sistema de reportes)
- `test_codigo_intermedio.txt` - Prueba específica para generación de código intermedio
- `test_funciones_locales.txt` - Funciones con parámetros y scopes locales

### Archivos de Prueba de Optimización
- `prueba.txt` - Archivo simple para verificar optimizaciones
- `ejemplo_asignacion_intermedio.txt` - Prueba de asignaciones para optimización

### Cómo Probar

1. **Prueba básica:**
   ```sh
   java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo.txt
   ```

2. **Prueba completa con errores y optimizaciones:**
   ```sh
   java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo_completo.txt
   ```

3. **Prueba de optimizaciones:**
   ```sh
   java -jar target/demo-1.0-jar-with-dependencies.jar ejemplo_operaciones.txt
   ```

### Salidas Generadas

Por cada archivo procesado, se generarán automáticamente:
- `[nombre_archivo].intermedio.txt` - Código de tres direcciones original
- `[nombre_archivo].optimizado.txt` - Código optimizado con las técnicas implementadas

### Funcionalidades Implementadas

✅ **Punto 5 - Optimización de Código:**
- Propagación y plegado de constantes (con manejo de ámbitos)
- Eliminación de código muerto (variables temporales no utilizadas)
- Simplificación de expresiones algebraicas

✅ **Punto 6 - Salidas del Compilador:**
- Archivos de salida dinámicos (sin sobrescritura)
- Sistema de reportes con colores (verde=éxito, rojo=errores, amarillo=advertencias)
- Generación automática de código intermedio y optimizado

---
