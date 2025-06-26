grammar MiniLenguaje;

//  Reglas del parser
programa : declaracion* EOF ;

declaracion : declaracionVariable 
           | declaracionConstante
           | declaracionFuncion 
           | sentenciaGlobal 
           | importacion ;

importacion : IMPORT STRING PYC ;

declaracionVariable : tipo ID (ASIGNACION expresion)? PYC ;

declaracionConstante : CONST tipo ID ASIGNACION expresion PYC ;

declaracionFuncion : tipo ID PA parametros? PC LA sentencia* LC ;

parametros : parametro (COMA parametro)* ;

parametro : tipo ID ;

// Sentencias que pueden estar en el ámbito global
sentenciaGlobal : sentenciaPrint
                | sentenciaReturn
                | sentenciaIf
                | sentenciaWhile
                | sentenciaFor
                | bloque 
                ;

// Sentencias que solo pueden estar dentro de funciones
sentencia : sentenciaAsignacion
         | sentenciaIf
         | sentenciaFor
         | sentenciaWhile
         | sentenciaPrint
         | sentenciaReturn
         | sentenciaBreak
         | sentenciaContinue
         | bloque 
         ;

sentenciaAsignacion : ID ASIGNACION expresion PYC ;

sentenciaIf : IF PA expresion PC sentencia (ELSE sentencia)? ;

sentenciaFor : FOR PA (declaracionVariable | sentenciaAsignacion | PYC) expresion? PYC expresion? PC sentencia ;

sentenciaWhile : WHILE PA expresion PC sentencia ;

sentenciaPrint : PRINT expresion PYC ;

sentenciaReturn : RETURN expresion? PYC ;

sentenciaBreak : BREAK PYC ;

sentenciaContinue : CONTINUE PYC ;

bloque : LA sentencia* LC ;

expresion : expresionLogica ;

expresionLogica : expresionComparacion ((AND | OR) expresionComparacion)* ;

expresionComparacion : expresionAritmetica ((IGUAL | DIFERENTE | MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL) expresionAritmetica)* ;

expresionAritmetica : termino ((MAS | MENOS) termino)* ;

termino : factor ((MULTIPLICACION | DIVISION | MODULO) factor)* ;

factor : PA expresion PC
       | ID
       | INTEGER
       | FLOAT
       | DOUBLE
       | STRING
       | CHAR
       | TRUE
       | FALSE
       | llamadaFuncion
       | (NOT | MENOS) factor ;

llamadaFuncion : ID PA argumentos? PC ;

argumentos : expresion (COMA expresion)* ;

//  Tipos de datos
tipo : INT | FLOAT_TYPE | DOUBLE_TYPE | STRING_TYPE | CHAR_TYPE | BOOLEAN_TYPE | VOID ;

//  Reglas léxicas (ORDEN IMPORTANTE: específicos antes que generales)

//  Palabras clave (DEBEN IR ANTES QUE ID)
IMPORT      : 'import' ;
CONST       : 'const' ;
INT         : 'int' ;
FLOAT_TYPE  : 'float' ;
DOUBLE_TYPE : 'double' ;
STRING_TYPE : 'string' ;
CHAR_TYPE   : 'char' ;
BOOLEAN_TYPE: 'boolean' ;
VOID        : 'void' ;
IF          : 'if' ;
ELSE        : 'else' ;
PRINT       : 'print' ;
WHILE       : 'while' ;
FOR         : 'for' ;
RETURN      : 'return' ;
BREAK       : 'break' ;
CONTINUE    : 'continue' ;
TRUE        : 'true' ;
FALSE       : 'false' ;

//  Operadores
ASIGNACION    : '=' ;
IGUAL         : '==' ;
DIFERENTE     : '!=' ;
MENOR         : '<' ;
MAYOR         : '>' ;
MENOR_IGUAL   : '<=' ;
MAYOR_IGUAL   : '>=' ;
AND           : '&&' ;
OR            : '||' ;
NOT           : '!' ;
MAS           : '+' ;
MENOS         : '-' ;
MULTIPLICACION: '*' ;
DIVISION      : '/' ;
MODULO        : '%' ;

// Separadores
PA : '(';
PC : ')';
PRA : '[';
PRC : ']';
LA : '{';
LC : '}';
PYC : ';';
PUNTO : '.';
COMA : ',';

//  Literales
INTEGER     : [0-9]+ ;
FLOAT       : [0-9]+ '.' [0-9]+ ;
DOUBLE      : [0-9]+ '.' [0-9]+([eE][+-]?[0-9]+)? ;
STRING      : '"' (~["\r\n] | '\\\\"' | '\\"')* '"' ;
CHAR        : '\'' . '\'' ;
BOOLEAN     : TRUE | FALSE ;

//  Identificadores (DEBE IR AL FINAL)
ID          : [a-zA-Z][a-zA-Z0-9_]* ;

//  Ignorar espacios en blanco y comentarios
WS          : [ \t\r\n]+ -> skip ;
COMMENT     : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;