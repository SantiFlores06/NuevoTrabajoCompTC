// Generated from com\compilador\MiniLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniLenguajeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniLenguajeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(MiniLenguajeParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(MiniLenguajeParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#importacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportacion(MiniLenguajeParser.ImportacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#declaracionVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionVariable(MiniLenguajeParser.DeclaracionVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#declaracionConstante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionConstante(MiniLenguajeParser.DeclaracionConstanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionFuncion(MiniLenguajeParser.DeclaracionFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(MiniLenguajeParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(MiniLenguajeParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia(MiniLenguajeParser.SentenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#sentenciaAsignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaAsignacion(MiniLenguajeParser.SentenciaAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#sentenciaIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaIf(MiniLenguajeParser.SentenciaIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#sentenciaFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaFor(MiniLenguajeParser.SentenciaForContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#sentenciaWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaWhile(MiniLenguajeParser.SentenciaWhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#sentenciaPrint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaPrint(MiniLenguajeParser.SentenciaPrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#sentenciaReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaReturn(MiniLenguajeParser.SentenciaReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#sentenciaBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaBreak(MiniLenguajeParser.SentenciaBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#sentenciaContinue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaContinue(MiniLenguajeParser.SentenciaContinueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(MiniLenguajeParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(MiniLenguajeParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#expresionLogica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionLogica(MiniLenguajeParser.ExpresionLogicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#expresionComparacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionComparacion(MiniLenguajeParser.ExpresionComparacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#expresionAritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresionAritmetica(MiniLenguajeParser.ExpresionAritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#termino}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermino(MiniLenguajeParser.TerminoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(MiniLenguajeParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLlamadaFuncion(MiniLenguajeParser.LlamadaFuncionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(MiniLenguajeParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLenguajeParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(MiniLenguajeParser.TipoContext ctx);
}