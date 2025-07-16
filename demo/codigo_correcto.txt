// Archivo de prueba SIN errores - SÚPER SIMPLE
// Compatible con la gramática básica

// Variables globales
int contadorGlobal;
double valorPi;
char inicial;
bool activo;

// Función simple que retorna valor
int sumar(int a, int b) {
    int resultado;
    resultado = a + b;
    contadorGlobal = contadorGlobal + 1;
    return resultado;
}

// Función main
int main() {
    int estado;
    int temp;
    int numeros[3];
    
    // Inicializar variables globales
    contadorGlobal = 0;
    valorPi = 3.14;
    inicial = 'M';
    
    // Usar arrays
    numeros[0] = 10;
    numeros[1] = 20;
    numeros[2] = 30;
    
    // Operaciones básicas
    temp = numeros[0] + numeros[1];
    temp = temp * 2;
    temp = temp / 3;
    temp = temp % 5;
    
    // Usar función que retorna valor
    estado = sumar(temp, 5);
    
    // Usar variables globales
    contadorGlobal = estado;
    valorPi = temp;
    inicial = 'X';
    
    // Estructuras de control básicas
    if (estado > 0) {
        int auxiliar;
        auxiliar = estado + 10;
        estado = auxiliar;
    }
    
    return estado;
}