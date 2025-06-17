// Generated from d:/Users/Usuario/Desktop/Facultad/5to/1er Cuatrimestre/Tecnicas de Compilacion/newCompTC/NuevoTrabajoCompTC/demo/src/main/antlr4/com/compilador/MiniLenguaje.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniLenguajeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IMPORT=1, CONST=2, INT=3, FLOAT_TYPE=4, STRING_TYPE=5, CHAR_TYPE=6, BOOLEAN_TYPE=7, 
		VOID=8, IF=9, ELSE=10, PRINT=11, WHILE=12, FOR=13, RETURN=14, BREAK=15, 
		CONTINUE=16, TRUE=17, FALSE=18, ASIGNACION=19, IGUAL=20, DIFERENTE=21, 
		MENOR=22, MAYOR=23, MENOR_IGUAL=24, MAYOR_IGUAL=25, AND=26, OR=27, NOT=28, 
		MAS=29, MENOS=30, MULTIPLICACION=31, DIVISION=32, MODULO=33, PA=34, PC=35, 
		LA=36, LC=37, PYC=38, PUNTO=39, COMA=40, INTEGER=41, FLOAT=42, STRING=43, 
		CHAR=44, BOOLEAN=45, ID=46, WS=47, COMMENT=48, BLOCK_COMMENT=49;
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
			null, "'import'", "'const'", "'int'", "'float'", "'string'", "'char'", 
			"'boolean'", "'void'", "'if'", "'else'", "'print'", "'while'", "'for'", 
			"'return'", "'break'", "'continue'", "'true'", "'false'", "'='", "'=='", 
			"'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", "'!'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'('", "')'", "'{'", "'}'", "';'", "'.'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IMPORT", "CONST", "INT", "FLOAT_TYPE", "STRING_TYPE", "CHAR_TYPE", 
			"BOOLEAN_TYPE", "VOID", "IF", "ELSE", "PRINT", "WHILE", "FOR", "RETURN", 
			"BREAK", "CONTINUE", "TRUE", "FALSE", "ASIGNACION", "IGUAL", "DIFERENTE", 
			"MENOR", "MAYOR", "MENOR_IGUAL", "MAYOR_IGUAL", "AND", "OR", "NOT", "MAS", 
			"MENOS", "MULTIPLICACION", "DIVISION", "MODULO", "PA", "PC", "LA", "LC", 
			"PYC", "PUNTO", "COMA", "INTEGER", "FLOAT", "STRING", "CHAR", "BOOLEAN", 
			"ID", "WS", "COMMENT", "BLOCK_COMMENT"
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

	@SuppressWarnings("CheckReturnValue")
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68719495678L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImportacionContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(MiniLenguajeParser.IMPORT, 0); }
		public TerminalNode STRING() { return getToken(MiniLenguajeParser.STRING, 0); }
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public ImportacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importacion; }
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 504L) != 0)) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 70437463783936L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniLenguajeParser.ID, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
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

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaGlobalContext extends ParserRuleContext {
		public SentenciaPrintContext sentenciaPrint() {
			return getRuleContext(SentenciaPrintContext.class,0);
		}
		public SentenciaReturnContext sentenciaReturn() {
			return getRuleContext(SentenciaReturnContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public SentenciaGlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaGlobal; }
	}

	public final SentenciaGlobalContext sentenciaGlobal() throws RecognitionException {
		SentenciaGlobalContext _localctx = new SentenciaGlobalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sentenciaGlobal);
		try {
			setState(120);
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
			case LA:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sentencia);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				sentenciaAsignacion();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				sentenciaIf();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				sentenciaFor();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				sentenciaWhile();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				sentenciaPrint();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(127);
				sentenciaReturn();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 7);
				{
				setState(128);
				sentenciaBreak();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(129);
				sentenciaContinue();
				}
				break;
			case LA:
				enterOuterAlt(_localctx, 9);
				{
				setState(130);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final SentenciaAsignacionContext sentenciaAsignacion() throws RecognitionException {
		SentenciaAsignacionContext _localctx = new SentenciaAsignacionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sentenciaAsignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(ID);
			setState(134);
			match(ASIGNACION);
			setState(135);
			expresion();
			setState(136);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final SentenciaIfContext sentenciaIf() throws RecognitionException {
		SentenciaIfContext _localctx = new SentenciaIfContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sentenciaIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(IF);
			setState(139);
			match(PA);
			setState(140);
			expresion();
			setState(141);
			match(PC);
			setState(142);
			sentencia();
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(143);
				match(ELSE);
				setState(144);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final SentenciaForContext sentenciaFor() throws RecognitionException {
		SentenciaForContext _localctx = new SentenciaForContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentenciaFor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(FOR);
			setState(148);
			match(PA);
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT_TYPE:
			case STRING_TYPE:
			case CHAR_TYPE:
			case BOOLEAN_TYPE:
			case VOID:
				{
				setState(149);
				declaracionVariable();
				}
				break;
			case ID:
				{
				setState(150);
				sentenciaAsignacion();
				}
				break;
			case PYC:
				{
				setState(151);
				match(PYC);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103372615450624L) != 0)) {
				{
				setState(154);
				expresion();
				}
			}

			setState(157);
			match(PYC);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103372615450624L) != 0)) {
				{
				setState(158);
				expresion();
				}
			}

			setState(161);
			match(PC);
			setState(162);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final SentenciaWhileContext sentenciaWhile() throws RecognitionException {
		SentenciaWhileContext _localctx = new SentenciaWhileContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sentenciaWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(WHILE);
			setState(165);
			match(PA);
			setState(166);
			expresion();
			setState(167);
			match(PC);
			setState(168);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final SentenciaPrintContext sentenciaPrint() throws RecognitionException {
		SentenciaPrintContext _localctx = new SentenciaPrintContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sentenciaPrint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(PRINT);
			setState(171);
			expresion();
			setState(172);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final SentenciaReturnContext sentenciaReturn() throws RecognitionException {
		SentenciaReturnContext _localctx = new SentenciaReturnContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sentenciaReturn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(RETURN);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103372615450624L) != 0)) {
				{
				setState(175);
				expresion();
				}
			}

			setState(178);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaBreakContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(MiniLenguajeParser.BREAK, 0); }
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public SentenciaBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaBreak; }
	}

	public final SentenciaBreakContext sentenciaBreak() throws RecognitionException {
		SentenciaBreakContext _localctx = new SentenciaBreakContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sentenciaBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(BREAK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaContinueContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(MiniLenguajeParser.CONTINUE, 0); }
		public TerminalNode PYC() { return getToken(MiniLenguajeParser.PYC, 0); }
		public SentenciaContinueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenciaContinue; }
	}

	public final SentenciaContinueContext sentenciaContinue() throws RecognitionException {
		SentenciaContinueContext _localctx = new SentenciaContinueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sentenciaContinue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(CONTINUE);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(LA);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 70437463783936L) != 0)) {
				{
				{
				setState(187);
				sentencia();
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionLogicaContext expresionLogica() {
			return getRuleContext(ExpresionLogicaContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final ExpresionLogicaContext expresionLogica() throws RecognitionException {
		ExpresionLogicaContext _localctx = new ExpresionLogicaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_expresionLogica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			expresionComparacion();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(198);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(199);
				expresionComparacion();
				}
				}
				setState(204);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final ExpresionComparacionContext expresionComparacion() throws RecognitionException {
		ExpresionComparacionContext _localctx = new ExpresionComparacionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expresionComparacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			expresionAritmetica();
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 66060288L) != 0)) {
				{
				{
				setState(206);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 66060288L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(207);
				expresionAritmetica();
				}
				}
				setState(212);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final ExpresionAritmeticaContext expresionAritmetica() throws RecognitionException {
		ExpresionAritmeticaContext _localctx = new ExpresionAritmeticaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expresionAritmetica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			termino();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MAS || _la==MENOS) {
				{
				{
				setState(214);
				_la = _input.LA(1);
				if ( !(_la==MAS || _la==MENOS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
				termino();
				}
				}
				setState(220);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_termino);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			factor();
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15032385536L) != 0)) {
				{
				{
				setState(222);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15032385536L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(223);
				factor();
				}
				}
				setState(228);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(MiniLenguajeParser.PA, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PC() { return getToken(MiniLenguajeParser.PC, 0); }
		public TerminalNode ID() { return getToken(MiniLenguajeParser.ID, 0); }
		public TerminalNode INTEGER() { return getToken(MiniLenguajeParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(MiniLenguajeParser.FLOAT, 0); }
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
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_factor);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(PA);
				setState(230);
				expresion();
				setState(231);
				match(PC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				match(INTEGER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				match(FLOAT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(236);
				match(STRING);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(237);
				match(CHAR);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(238);
				match(TRUE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(239);
				match(FALSE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(240);
				llamadaFuncion();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(241);
				_la = _input.LA(1);
				if ( !(_la==NOT || _la==MENOS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(242);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final LlamadaFuncionContext llamadaFuncion() throws RecognitionException {
		LlamadaFuncionContext _localctx = new LlamadaFuncionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_llamadaFuncion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(ID);
			setState(246);
			match(PA);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 103372615450624L) != 0)) {
				{
				setState(247);
				argumentos();
				}
			}

			setState(250);
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

	@SuppressWarnings("CheckReturnValue")
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
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			expresion();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(253);
				match(COMA);
				setState(254);
				expresion();
				}
				}
				setState(259);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniLenguajeParser.INT, 0); }
		public TerminalNode FLOAT_TYPE() { return getToken(MiniLenguajeParser.FLOAT_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(MiniLenguajeParser.STRING_TYPE, 0); }
		public TerminalNode CHAR_TYPE() { return getToken(MiniLenguajeParser.CHAR_TYPE, 0); }
		public TerminalNode BOOLEAN_TYPE() { return getToken(MiniLenguajeParser.BOOLEAN_TYPE, 0); }
		public TerminalNode VOID() { return getToken(MiniLenguajeParser.VOID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 504L) != 0)) ) {
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
		"\u0004\u00011\u0107\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0005\u0000:\b\u0000\n\u0000\f\u0000=\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001F\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003P\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005_\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005d\b\u0005\n\u0005\f\u0005g\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006n\b\u0006\n\u0006\f\u0006"+
		"q\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0003\by\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0003\t\u0084\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0092\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0003\f\u0099\b\f\u0001\f\u0003\f\u009c\b\f\u0001\f\u0001\f\u0003"+
		"\f\u00a0\b\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00b1\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u00bd\b\u0012\n\u0012\f\u0012\u00c0\t\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u00c9\b\u0014\n\u0014\f\u0014\u00cc\t\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u00d1\b\u0015\n\u0015\f\u0015\u00d4"+
		"\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u00d9\b\u0016"+
		"\n\u0016\f\u0016\u00dc\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u00e1\b\u0017\n\u0017\f\u0017\u00e4\t\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u00f4\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u00f9\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0005\u001a\u0100\b\u001a\n\u001a\f\u001a\u0103\t\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0000\u0000\u001c\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0246\u0000\u0006"+
		"\u0001\u0000\u001a\u001b\u0001\u0000\u0014\u0019\u0001\u0000\u001d\u001e"+
		"\u0001\u0000\u001f!\u0002\u0000\u001c\u001c\u001e\u001e\u0001\u0000\u0003"+
		"\b\u0113\u0000;\u0001\u0000\u0000\u0000\u0002E\u0001\u0000\u0000\u0000"+
		"\u0004G\u0001\u0000\u0000\u0000\u0006K\u0001\u0000\u0000\u0000\bS\u0001"+
		"\u0000\u0000\u0000\nZ\u0001\u0000\u0000\u0000\fj\u0001\u0000\u0000\u0000"+
		"\u000er\u0001\u0000\u0000\u0000\u0010x\u0001\u0000\u0000\u0000\u0012\u0083"+
		"\u0001\u0000\u0000\u0000\u0014\u0085\u0001\u0000\u0000\u0000\u0016\u008a"+
		"\u0001\u0000\u0000\u0000\u0018\u0093\u0001\u0000\u0000\u0000\u001a\u00a4"+
		"\u0001\u0000\u0000\u0000\u001c\u00aa\u0001\u0000\u0000\u0000\u001e\u00ae"+
		"\u0001\u0000\u0000\u0000 \u00b4\u0001\u0000\u0000\u0000\"\u00b7\u0001"+
		"\u0000\u0000\u0000$\u00ba\u0001\u0000\u0000\u0000&\u00c3\u0001\u0000\u0000"+
		"\u0000(\u00c5\u0001\u0000\u0000\u0000*\u00cd\u0001\u0000\u0000\u0000,"+
		"\u00d5\u0001\u0000\u0000\u0000.\u00dd\u0001\u0000\u0000\u00000\u00f3\u0001"+
		"\u0000\u0000\u00002\u00f5\u0001\u0000\u0000\u00004\u00fc\u0001\u0000\u0000"+
		"\u00006\u0104\u0001\u0000\u0000\u00008:\u0003\u0002\u0001\u000098\u0001"+
		"\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000>?\u0005\u0000\u0000\u0001?\u0001\u0001\u0000\u0000\u0000@F\u0003"+
		"\u0006\u0003\u0000AF\u0003\b\u0004\u0000BF\u0003\n\u0005\u0000CF\u0003"+
		"\u0010\b\u0000DF\u0003\u0004\u0002\u0000E@\u0001\u0000\u0000\u0000EA\u0001"+
		"\u0000\u0000\u0000EB\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"ED\u0001\u0000\u0000\u0000F\u0003\u0001\u0000\u0000\u0000GH\u0005\u0001"+
		"\u0000\u0000HI\u0005+\u0000\u0000IJ\u0005&\u0000\u0000J\u0005\u0001\u0000"+
		"\u0000\u0000KL\u00036\u001b\u0000LO\u0005.\u0000\u0000MN\u0005\u0013\u0000"+
		"\u0000NP\u0003&\u0013\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000PQ\u0001\u0000\u0000\u0000QR\u0005&\u0000\u0000R\u0007\u0001\u0000"+
		"\u0000\u0000ST\u0005\u0002\u0000\u0000TU\u00036\u001b\u0000UV\u0005.\u0000"+
		"\u0000VW\u0005\u0013\u0000\u0000WX\u0003&\u0013\u0000XY\u0005&\u0000\u0000"+
		"Y\t\u0001\u0000\u0000\u0000Z[\u00036\u001b\u0000[\\\u0005.\u0000\u0000"+
		"\\^\u0005\"\u0000\u0000]_\u0003\f\u0006\u0000^]\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0005#\u0000\u0000"+
		"ae\u0005$\u0000\u0000bd\u0003\u0012\t\u0000cb\u0001\u0000\u0000\u0000"+
		"dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000"+
		"\u0000fh\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000hi\u0005%\u0000"+
		"\u0000i\u000b\u0001\u0000\u0000\u0000jo\u0003\u000e\u0007\u0000kl\u0005"+
		"(\u0000\u0000ln\u0003\u000e\u0007\u0000mk\u0001\u0000\u0000\u0000nq\u0001"+
		"\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000"+
		"p\r\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rs\u00036\u001b\u0000"+
		"st\u0005.\u0000\u0000t\u000f\u0001\u0000\u0000\u0000uy\u0003\u001c\u000e"+
		"\u0000vy\u0003\u001e\u000f\u0000wy\u0003$\u0012\u0000xu\u0001\u0000\u0000"+
		"\u0000xv\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y\u0011\u0001"+
		"\u0000\u0000\u0000z\u0084\u0003\u0014\n\u0000{\u0084\u0003\u0016\u000b"+
		"\u0000|\u0084\u0003\u0018\f\u0000}\u0084\u0003\u001a\r\u0000~\u0084\u0003"+
		"\u001c\u000e\u0000\u007f\u0084\u0003\u001e\u000f\u0000\u0080\u0084\u0003"+
		" \u0010\u0000\u0081\u0084\u0003\"\u0011\u0000\u0082\u0084\u0003$\u0012"+
		"\u0000\u0083z\u0001\u0000\u0000\u0000\u0083{\u0001\u0000\u0000\u0000\u0083"+
		"|\u0001\u0000\u0000\u0000\u0083}\u0001\u0000\u0000\u0000\u0083~\u0001"+
		"\u0000\u0000\u0000\u0083\u007f\u0001\u0000\u0000\u0000\u0083\u0080\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0082\u0001"+
		"\u0000\u0000\u0000\u0084\u0013\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		".\u0000\u0000\u0086\u0087\u0005\u0013\u0000\u0000\u0087\u0088\u0003&\u0013"+
		"\u0000\u0088\u0089\u0005&\u0000\u0000\u0089\u0015\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0005\t\u0000\u0000\u008b\u008c\u0005\"\u0000\u0000\u008c"+
		"\u008d\u0003&\u0013\u0000\u008d\u008e\u0005#\u0000\u0000\u008e\u0091\u0003"+
		"\u0012\t\u0000\u008f\u0090\u0005\n\u0000\u0000\u0090\u0092\u0003\u0012"+
		"\t\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0017\u0001\u0000\u0000\u0000\u0093\u0094\u0005\r\u0000\u0000"+
		"\u0094\u0098\u0005\"\u0000\u0000\u0095\u0099\u0003\u0006\u0003\u0000\u0096"+
		"\u0099\u0003\u0014\n\u0000\u0097\u0099\u0005&\u0000\u0000\u0098\u0095"+
		"\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u009c"+
		"\u0003&\u0013\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009f\u0005"+
		"&\u0000\u0000\u009e\u00a0\u0003&\u0013\u0000\u009f\u009e\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0005#\u0000\u0000\u00a2\u00a3\u0003\u0012\t\u0000"+
		"\u00a3\u0019\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005\f\u0000\u0000\u00a5"+
		"\u00a6\u0005\"\u0000\u0000\u00a6\u00a7\u0003&\u0013\u0000\u00a7\u00a8"+
		"\u0005#\u0000\u0000\u00a8\u00a9\u0003\u0012\t\u0000\u00a9\u001b\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0005\u000b\u0000\u0000\u00ab\u00ac\u0003"+
		"&\u0013\u0000\u00ac\u00ad\u0005&\u0000\u0000\u00ad\u001d\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b0\u0005\u000e\u0000\u0000\u00af\u00b1\u0003&\u0013\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005&\u0000\u0000\u00b3"+
		"\u001f\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\u000f\u0000\u0000\u00b5"+
		"\u00b6\u0005&\u0000\u0000\u00b6!\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005"+
		"\u0010\u0000\u0000\u00b8\u00b9\u0005&\u0000\u0000\u00b9#\u0001\u0000\u0000"+
		"\u0000\u00ba\u00be\u0005$\u0000\u0000\u00bb\u00bd\u0003\u0012\t\u0000"+
		"\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000\u0000\u0000"+
		"\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c2\u0005%\u0000\u0000\u00c2%\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0003(\u0014\u0000\u00c4\'\u0001\u0000\u0000\u0000\u00c5\u00ca\u0003"+
		"*\u0015\u0000\u00c6\u00c7\u0007\u0000\u0000\u0000\u00c7\u00c9\u0003*\u0015"+
		"\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cb)\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000"+
		"\u00cd\u00d2\u0003,\u0016\u0000\u00ce\u00cf\u0007\u0001\u0000\u0000\u00cf"+
		"\u00d1\u0003,\u0016\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d3+\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d5\u00da\u0003.\u0017\u0000\u00d6\u00d7\u0007\u0002"+
		"\u0000\u0000\u00d7\u00d9\u0003.\u0017\u0000\u00d8\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db-\u0001\u0000\u0000\u0000"+
		"\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\u00e2\u00030\u0018\u0000\u00de"+
		"\u00df\u0007\u0003\u0000\u0000\u00df\u00e1\u00030\u0018\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3/\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005"+
		"\"\u0000\u0000\u00e6\u00e7\u0003&\u0013\u0000\u00e7\u00e8\u0005#\u0000"+
		"\u0000\u00e8\u00f4\u0001\u0000\u0000\u0000\u00e9\u00f4\u0005.\u0000\u0000"+
		"\u00ea\u00f4\u0005)\u0000\u0000\u00eb\u00f4\u0005*\u0000\u0000\u00ec\u00f4"+
		"\u0005+\u0000\u0000\u00ed\u00f4\u0005,\u0000\u0000\u00ee\u00f4\u0005\u0011"+
		"\u0000\u0000\u00ef\u00f4\u0005\u0012\u0000\u0000\u00f0\u00f4\u00032\u0019"+
		"\u0000\u00f1\u00f2\u0007\u0004\u0000\u0000\u00f2\u00f4\u00030\u0018\u0000"+
		"\u00f3\u00e5\u0001\u0000\u0000\u0000\u00f3\u00e9\u0001\u0000\u0000\u0000"+
		"\u00f3\u00ea\u0001\u0000\u0000\u0000\u00f3\u00eb\u0001\u0000\u0000\u0000"+
		"\u00f3\u00ec\u0001\u0000\u0000\u0000\u00f3\u00ed\u0001\u0000\u0000\u0000"+
		"\u00f3\u00ee\u0001\u0000\u0000\u0000\u00f3\u00ef\u0001\u0000\u0000\u0000"+
		"\u00f3\u00f0\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000"+
		"\u00f41\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005.\u0000\u0000\u00f6\u00f8"+
		"\u0005\"\u0000\u0000\u00f7\u00f9\u00034\u001a\u0000\u00f8\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u0005#\u0000\u0000\u00fb3\u0001\u0000\u0000"+
		"\u0000\u00fc\u0101\u0003&\u0013\u0000\u00fd\u00fe\u0005(\u0000\u0000\u00fe"+
		"\u0100\u0003&\u0013\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u0103"+
		"\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\u0001\u0000\u0000\u0000\u01025\u0001\u0000\u0000\u0000\u0103\u0101\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0007\u0005\u0000\u0000\u01057\u0001\u0000"+
		"\u0000\u0000\u0015;EO^eox\u0083\u0091\u0098\u009b\u009f\u00b0\u00be\u00ca"+
		"\u00d2\u00da\u00e2\u00f3\u00f8\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}