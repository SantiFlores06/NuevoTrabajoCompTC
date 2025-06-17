// Generated from com\compilador\MiniLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniLenguajeParser}.
 */
public interface MiniLenguajeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(MiniLenguajeParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(MiniLenguajeParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(MiniLenguajeParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(MiniLenguajeParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#importacion}.
	 * @param ctx the parse tree
	 */
	void enterImportacion(MiniLenguajeParser.ImportacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#importacion}.
	 * @param ctx the parse tree
	 */
	void exitImportacion(MiniLenguajeParser.ImportacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionVariable(MiniLenguajeParser.DeclaracionVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionVariable(MiniLenguajeParser.DeclaracionVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#declaracionConstante}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionConstante(MiniLenguajeParser.DeclaracionConstanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#declaracionConstante}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionConstante(MiniLenguajeParser.DeclaracionConstanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionFuncion(MiniLenguajeParser.DeclaracionFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionFuncion(MiniLenguajeParser.DeclaracionFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(MiniLenguajeParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(MiniLenguajeParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(MiniLenguajeParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(MiniLenguajeParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentenciaGlobal}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaGlobal(MiniLenguajeParser.SentenciaGlobalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentenciaGlobal}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaGlobal(MiniLenguajeParser.SentenciaGlobalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(MiniLenguajeParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(MiniLenguajeParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentenciaAsignacion}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaAsignacion(MiniLenguajeParser.SentenciaAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentenciaAsignacion}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaAsignacion(MiniLenguajeParser.SentenciaAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentenciaIf}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaIf(MiniLenguajeParser.SentenciaIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentenciaIf}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaIf(MiniLenguajeParser.SentenciaIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentenciaFor}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaFor(MiniLenguajeParser.SentenciaForContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentenciaFor}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaFor(MiniLenguajeParser.SentenciaForContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentenciaWhile}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaWhile(MiniLenguajeParser.SentenciaWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentenciaWhile}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaWhile(MiniLenguajeParser.SentenciaWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentenciaPrint}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaPrint(MiniLenguajeParser.SentenciaPrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentenciaPrint}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaPrint(MiniLenguajeParser.SentenciaPrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentenciaReturn}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaReturn(MiniLenguajeParser.SentenciaReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentenciaReturn}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaReturn(MiniLenguajeParser.SentenciaReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentenciaBreak}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaBreak(MiniLenguajeParser.SentenciaBreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentenciaBreak}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaBreak(MiniLenguajeParser.SentenciaBreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#sentenciaContinue}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaContinue(MiniLenguajeParser.SentenciaContinueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#sentenciaContinue}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaContinue(MiniLenguajeParser.SentenciaContinueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(MiniLenguajeParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(MiniLenguajeParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(MiniLenguajeParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(MiniLenguajeParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#expresionLogica}.
	 * @param ctx the parse tree
	 */
	void enterExpresionLogica(MiniLenguajeParser.ExpresionLogicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#expresionLogica}.
	 * @param ctx the parse tree
	 */
	void exitExpresionLogica(MiniLenguajeParser.ExpresionLogicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#expresionComparacion}.
	 * @param ctx the parse tree
	 */
	void enterExpresionComparacion(MiniLenguajeParser.ExpresionComparacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#expresionComparacion}.
	 * @param ctx the parse tree
	 */
	void exitExpresionComparacion(MiniLenguajeParser.ExpresionComparacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#expresionAritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExpresionAritmetica(MiniLenguajeParser.ExpresionAritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#expresionAritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExpresionAritmetica(MiniLenguajeParser.ExpresionAritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#termino}.
	 * @param ctx the parse tree
	 */
	void enterTermino(MiniLenguajeParser.TerminoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#termino}.
	 * @param ctx the parse tree
	 */
	void exitTermino(MiniLenguajeParser.TerminoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(MiniLenguajeParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(MiniLenguajeParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void enterLlamadaFuncion(MiniLenguajeParser.LlamadaFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#llamadaFuncion}.
	 * @param ctx the parse tree
	 */
	void exitLlamadaFuncion(MiniLenguajeParser.LlamadaFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(MiniLenguajeParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(MiniLenguajeParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(MiniLenguajeParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(MiniLenguajeParser.TipoContext ctx);
}