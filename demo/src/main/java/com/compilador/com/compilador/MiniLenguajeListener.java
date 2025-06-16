// Generated from com\compilador\MiniLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniLenguajeParser}.
 */
public interface MiniLenguajeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniLenguajeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniLenguajeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLenguajeParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(MiniLenguajeParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLenguajeParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(MiniLenguajeParser.TokenContext ctx);
}