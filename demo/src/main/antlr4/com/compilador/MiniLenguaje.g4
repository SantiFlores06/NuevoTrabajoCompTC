grammar MiniLenguaje;

// 📌 Reglas del parser
programa : declaracion* EOF ;

declaracion : declaracionVariable 
           | declaracionConstante
           | declaracionFuncion 
           | sentencia 
           | importacion ;

importacion : 'import' STRING PYC ;

declaracionVariable : tipo ID '=' expresion PYC ;

declaracionConstante : 'const' tipo ID '=' expresion PYC ;

declaracionFuncion : tipo ID PA parametros? PC LA sentencia* LC ;

parametros : parametro (COMA parametro)* ;

parametro : tipo ID ;

sentencia : sentenciaAsignacion
         | sentenciaIf
         | sentenciaFor
         | sentenciaWhile
         | sentenciaPrint
         | sentenciaReturn
         | sentenciaBreak
         | sentenciaContinue
         | bloque ;

sentenciaAsignacion : ID '=' expresion PYC ;

sentenciaIf : 'if' PA expresion PC sentencia ('else' sentencia)? ;

sentenciaFor : 'for' PA (declaracionVariable | sentenciaAsignacion | PYC) expresion? PYC expresion? PC sentencia ;

sentenciaWhile : 'while' PA expresion PC sentencia ;

sentenciaPrint : 'print' expresion PYC ;

sentenciaReturn : 'return' expresion? PYC ;

sentenciaBreak : 'break' PYC ;

sentenciaContinue : 'continue' PYC ;

bloque : LA sentencia* LC ;

expresion : expresionLogica ;

expresionLogica : expresionComparacion (('&&' | '||') expresionComparacion)* ;

expresionComparacion : expresionAritmetica (('==' | '!=' | '<' | '>' | '<=' | '>=') expresionAritmetica)* ;

expresionAritmetica : termino (('+' | '-') termino)* ;

termino : factor (('*' | '/' | '%') factor)* ;

factor : PA expresion PC
       | ID
       | INTEGER
       | FLOAT
       | STRING
       | BOOLEAN
       | llamadaFuncion
       | ('!' | '-') factor ;

llamadaFuncion : ID PA argumentos? PC ;

argumentos : expresion (COMA expresion)* ;

// 📌 Tipos de datos
tipo : 'int' | 'float' | 'string' | 'boolean' | 'void' ;

// 📌 Reglas léxicas

// 🆔 Identificadores
ID          : [a-zA-Z][a-zA-Z0-9_]* ;

// 🔢 Literales
INTEGER     : [0-9]+ ;
FLOAT       : [0-9]+ '.' [0-9]+ ;
STRING      : '"' (~["\r\n] | '\\\\"' | '\\"')* '"' ;
BOOLEAN     : 'true' | 'false' ;

// 🏷️ Palabras clave
KEYWORD     : 'var' | 'if' | 'else' | 'print' | 'while' | 'for' | 'function' | 'return' | 'break' | 'continue' | 'const' | 'import' ;

// 🔣 Operadores
OPERATOR    : '+' | '-' | '*' | '/' | '%' | '=' | '==' | '!=' | '<' | '>' | '<=' | '>=' | '&&' | '||' | '!' ;

// ✨ Separadores
PA : '(';
PC : ')';
LA : '{';
LC : '}';
PYC : ';';
PUNTO : '.';
COMA : ',';

// 🧹 Ignorar espacios en blanco y comentarios
WS          : [ \t\r\n]+ -> skip ;
COMMENT     : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;