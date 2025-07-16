
// Variables globales
int variableGlobal;
int variableGlobal; // ERROR: Variable duplicada en el mismo ámbito
double valorGlobal;
char caracterGlobal;

// error for fuera de ambito
int cont = 0;
    for (int i = 0; i < 10; i++) {
        cont = cont + i; // OK
        
        // ERROR: variable no declarada en for
        indefinida = i;
    }
// Función con múltiples errores
int miFuncion(int parametro1, double parametro2) {
    int variableLocal;
    int variableLocal; // ERROR: Variable duplicada en función
    
    // Variables nunca utilizadas (WARNING)
    int variableNoUsada1;
    string variableNoUsada2;
    double variableNoUsada3;
    
    parametro1 = 100; // OK: asignación a parámetro
    variableLocal = parametro1 + 5; // OK: uso de variable
    
    // ERROR: Asignación a variable no declarada
    variableFantasma = 42;
    
    // ERROR: Asignación a una función (no es variable)
    miFuncion = 10;
    
    // OK: usar variable global
    valorGlobal = 3.14;
    
    return variableLocal;
}

void funcionVoid() {
    int x;
    int y;
    int z; // WARNING: declarada pero no usada
    
    x = 10; // OK
    y = x + 5; // OK: uso de variables
    
    // ERROR: variable no declarada
    w = x + y;
}

void funcionConArrays() {
    int array[10];
    int variableNormal;
    
    double valorNoUsado;
}

void funcionGlobal() {
    // ERROR: Variable no declarada
    variableNoDeclarada = 100;
    
    // Variables declaradas pero no usadas (WARNING)
    int temporal1;
    double temporal2;
    bool temporal3;
    char temporal4;
    
    // OK: usar variables globales
    valorGlobal = 3.14;
    caracterGlobal = 'X';
}

// Función con diferentes tipos de datos
void funcionTipos() {
    // Declaraciones correctas
    int entero;
    double decimal;
    char caracter;
    bool booleano;
    float flotante;
    
    // Usos correctos
    entero = 42;
    decimal = 3.14159;
    caracter = 'Z';
    booleano = true;
    flotante = 2.5;
    
    // ERROR: Variables no declaradas
    variableX = entero;
    variableY = decimal;
    variableZ = caracter;
    
    // Variables declaradas pero no usadas (WARNING)
    int sinUso1;
    double sinUso2;
    char sinUso3;
    bool sinUso4;
}

// Función que usa otras funciones
void funcionQueLlama() {
    int resultado;
    
    resultado = miFuncion(10, 2.5); // OK: llamada a función
    
    // ERROR: llamada a función no declarada
    resultado = funcionInexistente(5);
    
    // OK: usar el resultado
    valorGlobal = resultado;
}


// Función con estructuras de control
void funcionControl() {
    int contador;
    bool condicion;
    
    contador = 0;
    condicion = true;
    
    // Dentro de if
    if (condicion) {
        int variableIf;
        variableIf = contador + 1;
        contador = variableIf; // OK: uso dentro del bloque
        
        // ERROR: variable no declarada
        otraVariable = 5;
    }
    
    // Dentro de for
    for (int i = 0; i < 10; i++) {
        contador = contador + i; // OK
        
        // ERROR: variable no declarada en for
        indefinida = i;
    }
    
    // Dentro de while
    while (contador > 0) {
        contador = contador - 1; // OK
        
        // Variables locales en while
        int temp;
        temp = contador; // OK: uso de temp
        
        // WARNING: variable declarada pero no usada
        int noUsadaEnWhile;
    }
}

// Función con errores de alcance
void funcionAlcance() {
    int variable1;
    
    variable1 = 10; // OK
    
    if (true) {
        int variable2;
        variable2 = variable1; // OK: acceso a variable del ámbito superior
        
        // ERROR: redeclaración en el mismo ámbito
        int variable2;
    }
    
    // ERROR: variable2 no existe en este ámbito
    variable2 = 20;
}

// Función main para completar el programa
int main() {
    int resultado;
    int valor;
    
    resultado = miFuncion(5, 3.14); // OK: uso de función
    valor = resultado + 10;         // OK: uso de variables
    
    // Llamar otras funciones
    funcionVoid();
    funcionTipos();
    funcionControl();
    
    // ERROR: variable no declarada
    variableFinal = valor;
    
    // OK: usar variable global
    variableGlobal = valor;
    
    return resultado;
}