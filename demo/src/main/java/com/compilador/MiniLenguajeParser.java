// Generated from com\compilador\MiniLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniLenguajeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IMPORT=1, CONST=2, INT=3, FLOAT_TYPE=4, DOUBLE_TYPE=5, STRING_TYPE=6, 
		CHAR_TYPE=7, BOOLEAN_TYPE=8, VOID=9, IF=10, ELSE=11, PRINT=12, WHILE=13, 
		FOR=14, RETURN=15, BREAK=16, CONTINUE=17, TRUE=18, FALSE=19, ASIGNACION=20, 
		IGUAL=21, DIFERENTE=22, MENOR=23, MAYOR=24, MENOR_IGUAL=25, MAYOR_IGUAL=26, 
		AND=27, OR=28, NOT=29, MAS=30, MENOS=31, MULTIPLICACION=32, DIVISION=33, 
		MODULO=34, PA=35, PC=36, LA=37, LC=38, PYC=39, PUNTO=40, COMA=41, INTEGER=42, 
		FLOAT=43, DOUBLE=44, STRING=45, CHAR=46, BOOLEAN=47, ID=48, WS=49, COMMENT=50, 
		BLOCK_COMMENT=51;
	public static final int
		RULE_programa = 0, RULE_declaracion = 1, RULE_importacion = 2, RULE_declaracionVariable = 3, 
		RULE_declaracionConstante = 4, RULE_declaracionFuncion = 5, RULE_parametros = 6, 
		RULE_parametro = 7, RULE_sentenciaGlobal = 8, RULE_sentencia = 9, RULE_sentenciaAsignacion = 10, 
		RULE_sentenciaIf = 11, RULE_sentenciaFor = 12, RULE_sentenciaWhile = 13, 
		RULE_sentenciaPrint = 14, RULE_sentenciaReturn = 15, RULE_sentenciaBreak = 16, 
		RULE_sentenciaContinue = 17, RULE_bloque = 18, RULE_expresion = 19, RULE_expresionLogica = 20, 
		RULE_expresionComparacion = 21, RULE_expresionAritmetica = 22, RULE_termino = 23, 
		RULE_factor = 24, RULE_llamadaFuncion = 25, RULE_argumentos = 26, RULE_tipo = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracion", "importacion", "declaracionVariable", "declaracionConstante", 
			"declaracionFuncion", "parametros", "parametro", "sentenciaGlobal", "sentencia", 
			"sentenciaAsignacion", "sentenciaIf", "sentenciaFor", "sentenciaWhile", 
			"sentenciaPrint", "sentenciaReturn", "sentenciaBreak", "sentenciaContinue", 
			"bloque", "expresion", "expresionLogica", "expresionComparacion", "expresionAritmetica", 
			"termino", "factor", "llamadaFuncion", "argumentos", "tipo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'const'", "'int'", "'float'", "'double'", "'string'", 
			"'char'", "'boolean'", "'void'", "'if'", "'else'", "'print'", "'while'", 
			"'for'", "'return'", "'break'", "'continue'", "'true'", "'false'", "'='", 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", "'!'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')'", "'{'", "'}'", "';'", 
			"'.'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IMPORT", "CONST", "INT", "FLOAT_TYPE", "DOUBLE_TYPE", "STRING_TYPE", 
			"CHAR_TYPE", "BOOLEAN_TYPE", "VOID", "IF", "ELSE", "PRINT", "WHILE", 
			"FOR", "RETURN", "BREAK", "CONTINUE", "TRUE", "FALSE", "ASIGNACION", 
			"IGUAL", "DIFERENTE", "MENOR", "MAYOR", "MENOR_IGUAL", "MAYOR_IGUAL", 
			"AND", "OR", "NOT", "MAS", "MENOS", "MULTIPLICACION", "DIVISION", "MODULO", 
			"PA", "PC", "LA", "LC", "PYC", "PUNTO", "COMA", "INTEGER", "FLOAT", "DOUBLE", 
			"STRING", "CHAR", "BOOLEAN", "ID", "WS", "COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniLenguajeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniLenguajeParser.EOF, 0); }
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << CONST) | (1L << INT) | (1L << FLOAT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << CHAR_TYPE) | (1L << BOOLEAN_TYPE) | (1L << VOID) | (1L << IF) | (1L << PRINT) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << LA))) != 0)) {
				{
				{
				setState(56);
				declaracion();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionVariableContext declaracionVariable() {
			return getRuleContext(DeclaracionVariableContext.class,0);
		}
		public DeclaracionConstanteContext declaracionConstante() {
			return getRuleContext(DeclaracionConstanteContext.class,0);
		}
		public DeclaracionFuncionContext declaracionFuncion() {
			return getRuleContext(DeclaracionFuncionContext.class,0);
		}
		public SentenciaGlobalContext sentenciaGlobal() {
			return getRuleContext(SentenciaGlobalContext.class,0);
		}
		public ImportacionContext importacion() {
			return getRuleContext(ImportacionContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitDeclaracion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitDeclaracion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracion);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				declaracionVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				declaracionConstante();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				declaracionFuncion();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(67);
				sentenciaGlobal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				importacion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportacionContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(MiniLenguajeParser.IMPORT, 0); }
		public TerminalNode STRING() { return getToken(MiniLenguajeParser.STRING, 0); }
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public ImportacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterImportacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitImportacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitImportacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportacionContext importacion() throws RecognitionException {
		ImportacionContext _localctx = new ImportacionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(IMPORT);
			setState(72);
			match(STRING);
			setState(73);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionVariableContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniLenguajeParser.ID, 0); }
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public TerminalNode ASIGNACION() { return getToken(MiniLenguajeParser.ASIGNACION, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterDeclaracionVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitDeclaracionVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitDeclaracionVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionVariableContext declaracionVariable() throws RecognitionException {
		DeclaracionVariableContext _localctx = new DeclaracionVariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracionVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			tipo();
			setState(76);
			match(ID);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASIGNACION) {
				{
				setState(77);
				match(ASIGNACION);
				setState(78);
				expresion();
				}
			}

			setState(81);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionConstanteContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(MiniLenguajeParser.CONST, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniLenguajeParser.ID, 0); }
		public TerminalNode ASIGNACION() { return getToken(MiniLenguajeParser.ASIGNACION, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public DeclaracionConstanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionConstante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterDeclaracionConstante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitDeclaracionConstante(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitDeclaracionConstante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionConstanteContext declaracionConstante() throws RecognitionException {
		DeclaracionConstanteContext _localctx = new DeclaracionConstanteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracionConstante);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(CONST);
			setState(84);
			tipo();
			setState(85);
			match(ID);
			setState(86);
			match(ASIGNACION);
			setState(87);
			expresion();
			setState(88);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionFuncionContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiniLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiniLenguajeParser.PC, 0); }
		public TerminalNode LA() { return getToken(MiniLenguajeParser.LA, 0); }
		public TerminalNode LC() { return getToken(MiniLenguajeParser.LC, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public DeclaracionFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterDeclaracionFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitDeclaracionFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitDeclaracionFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionFuncionContext declaracionFuncion() throws RecognitionException {
		DeclaracionFuncionContext _localctx = new DeclaracionFuncionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracionFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			tipo();
			setState(91);
			match(ID);
			setState(92);
			match(PA);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << CHAR_TYPE) | (1L << BOOLEAN_TYPE) | (1L << VOID))) != 0)) {
				{
				setState(93);
				parametros();
				}
			}

			setState(96);
			match(PC);
			setState(97);
			match(LA);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << LA) | (1L << ID))) != 0)) {
				{
				{
				setState(98);
				sentencia();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			match(LC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiniLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiniLenguajeParser.COMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			parametro();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(107);
				match(COMA);
				setState(108);
				parametro();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniLenguajeParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			tipo();
			setState(115);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaGlobalContext extends ParserRuleContext {
		public SentenciaPrintContext sentenciaPrint() {
			return getRuleContext(SentenciaPrintContext.class,0);
		}
		public SentenciaReturnContext sentenciaReturn() {
			return getRuleContext(SentenciaReturnContext.class,0);
		}
		public SentenciaIfContext sentenciaIf() {
			return getRuleContext(SentenciaIfContext.class,0);
		}
		public SentenciaWhileContext sentenciaWhile() {
			return getRuleContext(SentenciaWhileContext.class,0);
		}
		public SentenciaForContext sentenciaFor() {
			return getRuleContext(SentenciaForContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SentenciaGlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaGlobal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentenciaGlobal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentenciaGlobal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentenciaGlobal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaGlobalContext sentenciaGlobal() throws RecognitionException {
		SentenciaGlobalContext _localctx = new SentenciaGlobalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sentenciaGlobal);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				sentenciaPrint();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				sentenciaReturn();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				sentenciaIf();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				sentenciaWhile();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				sentenciaFor();
				}
				break;
			case LA:
				enterOuterAlt(_localctx, 6);
				{
				setState(122);
				bloque();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContext extends ParserRuleContext {
		public SentenciaAsignacionContext sentenciaAsignacion() {
			return getRuleContext(SentenciaAsignacionContext.class,0);
		}
		public SentenciaIfContext sentenciaIf() {
			return getRuleContext(SentenciaIfContext.class,0);
		}
		public SentenciaForContext sentenciaFor() {
			return getRuleContext(SentenciaForContext.class,0);
		}
		public SentenciaWhileContext sentenciaWhile() {
			return getRuleContext(SentenciaWhileContext.class,0);
		}
		public SentenciaPrintContext sentenciaPrint() {
			return getRuleContext(SentenciaPrintContext.class,0);
		}
		public SentenciaReturnContext sentenciaReturn() {
			return getRuleContext(SentenciaReturnContext.class,0);
		}
		public SentenciaBreakContext sentenciaBreak() {
			return getRuleContext(SentenciaBreakContext.class,0);
		}
		public SentenciaContinueContext sentenciaContinue() {
			return getRuleContext(SentenciaContinueContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentencia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentencia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sentencia);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				sentenciaAsignacion();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				sentenciaIf();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				sentenciaFor();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				sentenciaWhile();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				sentenciaPrint();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(130);
				sentenciaReturn();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 7);
				{
				setState(131);
				sentenciaBreak();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(132);
				sentenciaContinue();
				}
				break;
			case LA:
				enterOuterAlt(_localctx, 9);
				{
				setState(133);
				bloque();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaAsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniLenguajeParser.ID, 0); }
		public TerminalNode ASIGNACION() { return getToken(MiniLenguajeParser.ASIGNACION, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public SentenciaAsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaAsignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentenciaAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentenciaAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentenciaAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaAsignacionContext sentenciaAsignacion() throws RecognitionException {
		SentenciaAsignacionContext _localctx = new SentenciaAsignacionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentenciaAsignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(ID);
			setState(137);
			match(ASIGNACION);
			setState(138);
			expresion();
			setState(139);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaIfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniLenguajeParser.IF, 0); }
		public TerminalNode PA() { return getToken(MiniLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiniLenguajeParser.PC, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniLenguajeParser.ELSE, 0); }
		public SentenciaIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentenciaIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentenciaIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentenciaIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaIfContext sentenciaIf() throws RecognitionException {
		SentenciaIfContext _localctx = new SentenciaIfContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentenciaIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(IF);
			setState(142);
			match(PA);
			setState(143);
			expresion();
			setState(144);
			match(PC);
			setState(145);
			sentencia();
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(146);
				match(ELSE);
				setState(147);
				sentencia();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniLenguajeParser.FOR, 0); }
		public TerminalNode PA() { return getToken(MiniLenguajeParser.PA, 0); }
		public List<TerminalNode> PYC() { return getTokens(MiniLenguajeParser.PYC); }
		public TerminalNode PYC(int i) {
			return getToken(MiniLenguajeParser.PYC, i);
		}
		public TerminalNode PC() { return getToken(MiniLenguajeParser.PC, 0); }
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public DeclaracionVariableContext declaracionVariable() {
			return getRuleContext(DeclaracionVariableContext.class,0);
		}
		public SentenciaAsignacionContext sentenciaAsignacion() {
			return getRuleContext(SentenciaAsignacionContext.class,0);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public SentenciaForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentenciaFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentenciaFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentenciaFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaForContext sentenciaFor() throws RecognitionException {
		SentenciaForContext _localctx = new SentenciaForContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentenciaFor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(FOR);
			setState(151);
			match(PA);
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT_TYPE:
			case DOUBLE_TYPE:
			case STRING_TYPE:
			case CHAR_TYPE:
			case BOOLEAN_TYPE:
			case VOID:
				{
				setState(152);
				declaracionVariable();
				}
				break;
			case ID:
				{
				setState(153);
				sentenciaAsignacion();
				}
				break;
			case PYC:
				{
				setState(154);
				match(PYC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << MENOS) | (1L << PA) | (1L << INTEGER) | (1L << FLOAT) | (1L << DOUBLE) | (1L << STRING) | (1L << CHAR) | (1L << ID))) != 0)) {
				{
				setState(157);
				expresion();
				}
			}

			setState(160);
			match(PYC);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << MENOS) | (1L << PA) | (1L << INTEGER) | (1L << FLOAT) | (1L << DOUBLE) | (1L << STRING) | (1L << CHAR) | (1L << ID))) != 0)) {
				{
				setState(161);
				expresion();
				}
			}

			setState(164);
			match(PC);
			setState(165);
			sentencia();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniLenguajeParser.WHILE, 0); }
		public TerminalNode PA() { return getToken(MiniLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiniLenguajeParser.PC, 0); }
		public SentenciaContext sentencia() {
			return getRuleContext(SentenciaContext.class,0);
		}
		public SentenciaWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentenciaWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentenciaWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentenciaWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaWhileContext sentenciaWhile() throws RecognitionException {
		SentenciaWhileContext _localctx = new SentenciaWhileContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sentenciaWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(WHILE);
			setState(168);
			match(PA);
			setState(169);
			expresion();
			setState(170);
			match(PC);
			setState(171);
			sentencia();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaPrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(MiniLenguajeParser.PRINT, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public SentenciaPrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaPrint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentenciaPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentenciaPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentenciaPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaPrintContext sentenciaPrint() throws RecognitionException {
		SentenciaPrintContext _localctx = new SentenciaPrintContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sentenciaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(PRINT);
			setState(174);
			expresion();
			setState(175);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniLenguajeParser.RETURN, 0); }
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SentenciaReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentenciaReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentenciaReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentenciaReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaReturnContext sentenciaReturn() throws RecognitionException {
		SentenciaReturnContext _localctx = new SentenciaReturnContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sentenciaReturn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(RETURN);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << MENOS) | (1L << PA) | (1L << INTEGER) | (1L << FLOAT) | (1L << DOUBLE) | (1L << STRING) | (1L << CHAR) | (1L << ID))) != 0)) {
				{
				setState(178);
				expresion();
				}
			}

			setState(181);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaBreakContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MiniLenguajeParser.BREAK, 0); }
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public SentenciaBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaBreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentenciaBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentenciaBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentenciaBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaBreakContext sentenciaBreak() throws RecognitionException {
		SentenciaBreakContext _localctx = new SentenciaBreakContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sentenciaBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(BREAK);
			setState(184);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContinueContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MiniLenguajeParser.CONTINUE, 0); }
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public SentenciaContinueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaContinue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterSentenciaContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitSentenciaContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitSentenciaContinue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenciaContinueContext sentenciaContinue() throws RecognitionException {
		SentenciaContinueContext _localctx = new SentenciaContinueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sentenciaContinue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(CONTINUE);
			setState(187);
			match(PYC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LA() { return getToken(MiniLenguajeParser.LA, 0); }
		public TerminalNode LC() { return getToken(MiniLenguajeParser.LC, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitBloque(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitBloque(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(LA);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << PRINT) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << BREAK) | (1L << CONTINUE) | (1L << LA) | (1L << ID))) != 0)) {
				{
				{
				setState(190);
				sentencia();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(LC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionLogicaContext expresionLogica() {
			return getRuleContext(ExpresionLogicaContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitExpresion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitExpresion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			expresionLogica();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionLogicaContext extends ParserRuleContext {
		public List<ExpresionComparacionContext> expresionComparacion() {
			return getRuleContexts(ExpresionComparacionContext.class);
		}
		public ExpresionComparacionContext expresionComparacion(int i) {
			return getRuleContext(ExpresionComparacionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(MiniLenguajeParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MiniLenguajeParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(MiniLenguajeParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MiniLenguajeParser.OR, i);
		}
		public ExpresionLogicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresionLogica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterExpresionLogica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitExpresionLogica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitExpresionLogica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionLogicaContext expresionLogica() throws RecognitionException {
		ExpresionLogicaContext _localctx = new ExpresionLogicaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expresionLogica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			expresionComparacion();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(201);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(202);
				expresionComparacion();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionComparacionContext extends ParserRuleContext {
		public List<ExpresionAritmeticaContext> expresionAritmetica() {
			return getRuleContexts(ExpresionAritmeticaContext.class);
		}
		public ExpresionAritmeticaContext expresionAritmetica(int i) {
			return getRuleContext(ExpresionAritmeticaContext.class,i);
		}
		public List<TerminalNode> IGUAL() { return getTokens(MiniLenguajeParser.IGUAL); }
		public TerminalNode IGUAL(int i) {
			return getToken(MiniLenguajeParser.IGUAL, i);
		}
		public List<TerminalNode> DIFERENTE() { return getTokens(MiniLenguajeParser.DIFERENTE); }
		public TerminalNode DIFERENTE(int i) {
			return getToken(MiniLenguajeParser.DIFERENTE, i);
		}
		public List<TerminalNode> MENOR() { return getTokens(MiniLenguajeParser.MENOR); }
		public TerminalNode MENOR(int i) {
			return getToken(MiniLenguajeParser.MENOR, i);
		}
		public List<TerminalNode> MAYOR() { return getTokens(MiniLenguajeParser.MAYOR); }
		public TerminalNode MAYOR(int i) {
			return getToken(MiniLenguajeParser.MAYOR, i);
		}
		public List<TerminalNode> MENOR_IGUAL() { return getTokens(MiniLenguajeParser.MENOR_IGUAL); }
		public TerminalNode MENOR_IGUAL(int i) {
			return getToken(MiniLenguajeParser.MENOR_IGUAL, i);
		}
		public List<TerminalNode> MAYOR_IGUAL() { return getTokens(MiniLenguajeParser.MAYOR_IGUAL); }
		public TerminalNode MAYOR_IGUAL(int i) {
			return getToken(MiniLenguajeParser.MAYOR_IGUAL, i);
		}
		public ExpresionComparacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresionComparacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterExpresionComparacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitExpresionComparacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitExpresionComparacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionComparacionContext expresionComparacion() throws RecognitionException {
		ExpresionComparacionContext _localctx = new ExpresionComparacionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expresionComparacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			expresionAritmetica();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IGUAL) | (1L << DIFERENTE) | (1L << MENOR) | (1L << MAYOR) | (1L << MENOR_IGUAL) | (1L << MAYOR_IGUAL))) != 0)) {
				{
				{
				setState(209);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IGUAL) | (1L << DIFERENTE) | (1L << MENOR) | (1L << MAYOR) | (1L << MENOR_IGUAL) | (1L << MAYOR_IGUAL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(210);
				expresionAritmetica();
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionAritmeticaContext extends ParserRuleContext {
		public List<TerminoContext> termino() {
			return getRuleContexts(TerminoContext.class);
		}
		public TerminoContext termino(int i) {
			return getRuleContext(TerminoContext.class,i);
		}
		public List<TerminalNode> MAS() { return getTokens(MiniLenguajeParser.MAS); }
		public TerminalNode MAS(int i) {
			return getToken(MiniLenguajeParser.MAS, i);
		}
		public List<TerminalNode> MENOS() { return getTokens(MiniLenguajeParser.MENOS); }
		public TerminalNode MENOS(int i) {
			return getToken(MiniLenguajeParser.MENOS, i);
		}
		public ExpresionAritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresionAritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterExpresionAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitExpresionAritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitExpresionAritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionAritmeticaContext expresionAritmetica() throws RecognitionException {
		ExpresionAritmeticaContext _localctx = new ExpresionAritmeticaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expresionAritmetica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			termino();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MAS || _la==MENOS) {
				{
				{
				setState(217);
				_la = _input.LA(1);
				if ( !(_la==MAS || _la==MENOS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(218);
				termino();
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TerminoContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULTIPLICACION() { return getTokens(MiniLenguajeParser.MULTIPLICACION); }
		public TerminalNode MULTIPLICACION(int i) {
			return getToken(MiniLenguajeParser.MULTIPLICACION, i);
		}
		public List<TerminalNode> DIVISION() { return getTokens(MiniLenguajeParser.DIVISION); }
		public TerminalNode DIVISION(int i) {
			return getToken(MiniLenguajeParser.DIVISION, i);
		}
		public List<TerminalNode> MODULO() { return getTokens(MiniLenguajeParser.MODULO); }
		public TerminalNode MODULO(int i) {
			return getToken(MiniLenguajeParser.MODULO, i);
		}
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterTermino(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitTermino(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitTermino(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_termino);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			factor();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLICACION) | (1L << DIVISION) | (1L << MODULO))) != 0)) {
				{
				{
				setState(225);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLICACION) | (1L << DIVISION) | (1L << MODULO))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(226);
				factor();
				}
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(MiniLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiniLenguajeParser.PC, 0); }
		public TerminalNode ID() { return getToken(MiniLenguajeParser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(MiniLenguajeParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(MiniLenguajeParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(MiniLenguajeParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(MiniLenguajeParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(MiniLenguajeParser.CHAR, 0); }
		public TerminalNode TRUE() { return getToken(MiniLenguajeParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MiniLenguajeParser.FALSE, 0); }
		public LlamadaFuncionContext llamadaFuncion() {
			return getRuleContext(LlamadaFuncionContext.class,0);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode NOT() { return getToken(MiniLenguajeParser.NOT, 0); }
		public TerminalNode MENOS() { return getToken(MiniLenguajeParser.MENOS, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_factor);
		int _la;
		try {
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(PA);
				setState(233);
				expresion();
				setState(234);
				match(PC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				match(INTEGER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
				match(FLOAT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(239);
				match(DOUBLE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(240);
				match(STRING);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(241);
				match(CHAR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(242);
				match(TRUE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(243);
				match(FALSE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(244);
				llamadaFuncion();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(245);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MENOS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(246);
				factor();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LlamadaFuncionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniLenguajeParser.ID, 0); }
		public TerminalNode PA() { return getToken(MiniLenguajeParser.PA, 0); }
		public TerminalNode PC() { return getToken(MiniLenguajeParser.PC, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public LlamadaFuncionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_llamadaFuncion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterLlamadaFuncion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitLlamadaFuncion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitLlamadaFuncion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LlamadaFuncionContext llamadaFuncion() throws RecognitionException {
		LlamadaFuncionContext _localctx = new LlamadaFuncionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_llamadaFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(ID);
			setState(250);
			match(PA);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << MENOS) | (1L << PA) | (1L << INTEGER) | (1L << FLOAT) | (1L << DOUBLE) | (1L << STRING) | (1L << CHAR) | (1L << ID))) != 0)) {
				{
				setState(251);
				argumentos();
				}
			}

			setState(254);
			match(PC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(MiniLenguajeParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(MiniLenguajeParser.COMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitArgumentos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitArgumentos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			expresion();
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(257);
				match(COMA);
				setState(258);
				expresion();
				}
				}
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniLenguajeParser.INT, 0); }
		public TerminalNode FLOAT_TYPE() { return getToken(MiniLenguajeParser.FLOAT_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(MiniLenguajeParser.DOUBLE_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(MiniLenguajeParser.STRING_TYPE, 0); }
		public TerminalNode CHAR_TYPE() { return getToken(MiniLenguajeParser.CHAR_TYPE, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(MiniLenguajeParser.BOOLEAN_TYPE, 0); }
		public TerminalNode VOID() { return getToken(MiniLenguajeParser.VOID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLenguajeListener ) ((MiniLenguajeListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLenguajeVisitor ) return ((MiniLenguajeVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT_TYPE) | (1L << DOUBLE_TYPE) | (1L << STRING_TYPE) | (1L << CHAR_TYPE) | (1L << BOOLEAN_TYPE) | (1L << VOID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u010d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3H\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5"+
		"\5R\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7a\n\7\3"+
		"\7\3\7\3\7\7\7f\n\7\f\7\16\7i\13\7\3\7\3\7\3\b\3\b\3\b\7\bp\n\b\f\b\16"+
		"\bs\13\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n~\n\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u0089\n\13\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u0097\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u009e"+
		"\n\16\3\16\5\16\u00a1\n\16\3\16\3\16\5\16\u00a5\n\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u00b6"+
		"\n\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\7\24\u00c2\n\24"+
		"\f\24\16\24\u00c5\13\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\7\26\u00ce"+
		"\n\26\f\26\16\26\u00d1\13\26\3\27\3\27\3\27\7\27\u00d6\n\27\f\27\16\27"+
		"\u00d9\13\27\3\30\3\30\3\30\7\30\u00de\n\30\f\30\16\30\u00e1\13\30\3\31"+
		"\3\31\3\31\7\31\u00e6\n\31\f\31\16\31\u00e9\13\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00fa\n\32"+
		"\3\33\3\33\3\33\5\33\u00ff\n\33\3\33\3\33\3\34\3\34\3\34\7\34\u0106\n"+
		"\34\f\34\16\34\u0109\13\34\3\35\3\35\3\35\2\2\36\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\b\3\2\35\36\3\2\27\34\3\2 "+
		"!\3\2\"$\4\2\37\37!!\3\2\5\13\2\u011d\2=\3\2\2\2\4G\3\2\2\2\6I\3\2\2\2"+
		"\bM\3\2\2\2\nU\3\2\2\2\f\\\3\2\2\2\16l\3\2\2\2\20t\3\2\2\2\22}\3\2\2\2"+
		"\24\u0088\3\2\2\2\26\u008a\3\2\2\2\30\u008f\3\2\2\2\32\u0098\3\2\2\2\34"+
		"\u00a9\3\2\2\2\36\u00af\3\2\2\2 \u00b3\3\2\2\2\"\u00b9\3\2\2\2$\u00bc"+
		"\3\2\2\2&\u00bf\3\2\2\2(\u00c8\3\2\2\2*\u00ca\3\2\2\2,\u00d2\3\2\2\2."+
		"\u00da\3\2\2\2\60\u00e2\3\2\2\2\62\u00f9\3\2\2\2\64\u00fb\3\2\2\2\66\u0102"+
		"\3\2\2\28\u010a\3\2\2\2:<\5\4\3\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2"+
		"\2\2>@\3\2\2\2?=\3\2\2\2@A\7\2\2\3A\3\3\2\2\2BH\5\b\5\2CH\5\n\6\2DH\5"+
		"\f\7\2EH\5\22\n\2FH\5\6\4\2GB\3\2\2\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF"+
		"\3\2\2\2H\5\3\2\2\2IJ\7\3\2\2JK\7/\2\2KL\7)\2\2L\7\3\2\2\2MN\58\35\2N"+
		"Q\7\62\2\2OP\7\26\2\2PR\5(\25\2QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7)\2\2"+
		"T\t\3\2\2\2UV\7\4\2\2VW\58\35\2WX\7\62\2\2XY\7\26\2\2YZ\5(\25\2Z[\7)\2"+
		"\2[\13\3\2\2\2\\]\58\35\2]^\7\62\2\2^`\7%\2\2_a\5\16\b\2`_\3\2\2\2`a\3"+
		"\2\2\2ab\3\2\2\2bc\7&\2\2cg\7\'\2\2df\5\24\13\2ed\3\2\2\2fi\3\2\2\2ge"+
		"\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7(\2\2k\r\3\2\2\2lq\5\20\t\2"+
		"mn\7+\2\2np\5\20\t\2om\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\17\3\2\2"+
		"\2sq\3\2\2\2tu\58\35\2uv\7\62\2\2v\21\3\2\2\2w~\5\36\20\2x~\5 \21\2y~"+
		"\5\30\r\2z~\5\34\17\2{~\5\32\16\2|~\5&\24\2}w\3\2\2\2}x\3\2\2\2}y\3\2"+
		"\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\23\3\2\2\2\177\u0089\5\26\f\2\u0080"+
		"\u0089\5\30\r\2\u0081\u0089\5\32\16\2\u0082\u0089\5\34\17\2\u0083\u0089"+
		"\5\36\20\2\u0084\u0089\5 \21\2\u0085\u0089\5\"\22\2\u0086\u0089\5$\23"+
		"\2\u0087\u0089\5&\24\2\u0088\177\3\2\2\2\u0088\u0080\3\2\2\2\u0088\u0081"+
		"\3\2\2\2\u0088\u0082\3\2\2\2\u0088\u0083\3\2\2\2\u0088\u0084\3\2\2\2\u0088"+
		"\u0085\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\25\3\2\2"+
		"\2\u008a\u008b\7\62\2\2\u008b\u008c\7\26\2\2\u008c\u008d\5(\25\2\u008d"+
		"\u008e\7)\2\2\u008e\27\3\2\2\2\u008f\u0090\7\f\2\2\u0090\u0091\7%\2\2"+
		"\u0091\u0092\5(\25\2\u0092\u0093\7&\2\2\u0093\u0096\5\24\13\2\u0094\u0095"+
		"\7\r\2\2\u0095\u0097\5\24\13\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2"+
		"\u0097\31\3\2\2\2\u0098\u0099\7\20\2\2\u0099\u009d\7%\2\2\u009a\u009e"+
		"\5\b\5\2\u009b\u009e\5\26\f\2\u009c\u009e\7)\2\2\u009d\u009a\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u00a1\5("+
		"\25\2\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a4\7)\2\2\u00a3\u00a5\5(\25\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7&\2\2\u00a7\u00a8\5\24\13\2\u00a8"+
		"\33\3\2\2\2\u00a9\u00aa\7\17\2\2\u00aa\u00ab\7%\2\2\u00ab\u00ac\5(\25"+
		"\2\u00ac\u00ad\7&\2\2\u00ad\u00ae\5\24\13\2\u00ae\35\3\2\2\2\u00af\u00b0"+
		"\7\16\2\2\u00b0\u00b1\5(\25\2\u00b1\u00b2\7)\2\2\u00b2\37\3\2\2\2\u00b3"+
		"\u00b5\7\21\2\2\u00b4\u00b6\5(\25\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3"+
		"\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7)\2\2\u00b8!\3\2\2\2\u00b9\u00ba"+
		"\7\22\2\2\u00ba\u00bb\7)\2\2\u00bb#\3\2\2\2\u00bc\u00bd\7\23\2\2\u00bd"+
		"\u00be\7)\2\2\u00be%\3\2\2\2\u00bf\u00c3\7\'\2\2\u00c0\u00c2\5\24\13\2"+
		"\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7(\2\2\u00c7"+
		"\'\3\2\2\2\u00c8\u00c9\5*\26\2\u00c9)\3\2\2\2\u00ca\u00cf\5,\27\2\u00cb"+
		"\u00cc\t\2\2\2\u00cc\u00ce\5,\27\2\u00cd\u00cb\3\2\2\2\u00ce\u00d1\3\2"+
		"\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0+\3\2\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d2\u00d7\5.\30\2\u00d3\u00d4\t\3\2\2\u00d4\u00d6\5.\30\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8-\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00df\5\60\31\2\u00db\u00dc"+
		"\t\4\2\2\u00dc\u00de\5\60\31\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2"+
		"\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0/\3\2\2\2\u00e1\u00df\3"+
		"\2\2\2\u00e2\u00e7\5\62\32\2\u00e3\u00e4\t\5\2\2\u00e4\u00e6\5\62\32\2"+
		"\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8\61\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\7%\2\2\u00eb"+
		"\u00ec\5(\25\2\u00ec\u00ed\7&\2\2\u00ed\u00fa\3\2\2\2\u00ee\u00fa\7\62"+
		"\2\2\u00ef\u00fa\7,\2\2\u00f0\u00fa\7-\2\2\u00f1\u00fa\7.\2\2\u00f2\u00fa"+
		"\7/\2\2\u00f3\u00fa\7\60\2\2\u00f4\u00fa\7\24\2\2\u00f5\u00fa\7\25\2\2"+
		"\u00f6\u00fa\5\64\33\2\u00f7\u00f8\t\6\2\2\u00f8\u00fa\5\62\32\2\u00f9"+
		"\u00ea\3\2\2\2\u00f9\u00ee\3\2\2\2\u00f9\u00ef\3\2\2\2\u00f9\u00f0\3\2"+
		"\2\2\u00f9\u00f1\3\2\2\2\u00f9\u00f2\3\2\2\2\u00f9\u00f3\3\2\2\2\u00f9"+
		"\u00f4\3\2\2\2\u00f9\u00f5\3\2\2\2\u00f9\u00f6\3\2\2\2\u00f9\u00f7\3\2"+
		"\2\2\u00fa\63\3\2\2\2\u00fb\u00fc\7\62\2\2\u00fc\u00fe\7%\2\2\u00fd\u00ff"+
		"\5\66\34\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2"+
		"\u0100\u0101\7&\2\2\u0101\65\3\2\2\2\u0102\u0107\5(\25\2\u0103\u0104\7"+
		"+\2\2\u0104\u0106\5(\25\2\u0105\u0103\3\2\2\2\u0106\u0109\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\67\3\2\2\2\u0109\u0107\3\2\2"+
		"\2\u010a\u010b\t\7\2\2\u010b9\3\2\2\2\27=GQ`gq}\u0088\u0096\u009d\u00a0"+
		"\u00a4\u00b5\u00c3\u00cf\u00d7\u00df\u00e7\u00f9\u00fe\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}