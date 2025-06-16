grammar MiniLenguaje;

// 📌 Reglas del parser
program : token* EOF ;
token   : ID | INTEGER | STRING | KEYWORD | OPERATOR | 
          PA | PC | LA | LC | PYC | PUNTO | COMA ;

// 📌 Reglas léxicas

// 🆔 Identificadores
ID          : [a-zA-Z][a-zA-Z0-9_]* ;

// 🔢 Literales
INTEGER     : [0-9]+ ;
STRING      : '"' (~["\r\n] | '\\\\"' | '\\"')* '"' ;
BOOLEAN     : 'true' | 'false' ;

// 🏷️ Palabras clave
KEYWORD     : 'var' | 'if' | 'else' | 'print' | 'while' | 'function' | 'return' ;

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