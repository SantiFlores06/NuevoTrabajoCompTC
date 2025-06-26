// Generated from com\compilador\MiniLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniLenguajeLexer extends Lexer {
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
		MODULO=34, PA=35, PC=36, PRA=37, PRC=38, LA=39, LC=40, PYC=41, PUNTO=42, 
		COMA=43, INTEGER=44, FLOAT=45, DOUBLE=46, STRING=47, CHAR=48, BOOLEAN=49, 
		ID=50, WS=51, COMMENT=52, BLOCK_COMMENT=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IMPORT", "CONST", "INT", "FLOAT_TYPE", "DOUBLE_TYPE", "STRING_TYPE", 
			"CHAR_TYPE", "BOOLEAN_TYPE", "VOID", "IF", "ELSE", "PRINT", "WHILE", 
			"FOR", "RETURN", "BREAK", "CONTINUE", "TRUE", "FALSE", "ASIGNACION", 
			"IGUAL", "DIFERENTE", "MENOR", "MAYOR", "MENOR_IGUAL", "MAYOR_IGUAL", 
			"AND", "OR", "NOT", "MAS", "MENOS", "MULTIPLICACION", "DIVISION", "MODULO", 
			"PA", "PC", "PRA", "PRC", "LA", "LC", "PYC", "PUNTO", "COMA", "INTEGER", 
			"FLOAT", "DOUBLE", "STRING", "CHAR", "BOOLEAN", "ID", "WS", "COMMENT", 
			"BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'const'", "'int'", "'float'", "'double'", "'string'", 
			"'char'", "'boolean'", "'void'", "'if'", "'else'", "'print'", "'while'", 
			"'for'", "'return'", "'break'", "'continue'", "'true'", "'false'", "'='", 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", "'!'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "';'", "'.'", "','"
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
			"PA", "PC", "PRA", "PRC", "LA", "LC", "PYC", "PUNTO", "COMA", "INTEGER", 
			"FLOAT", "DOUBLE", "STRING", "CHAR", "BOOLEAN", "ID", "WS", "COMMENT", 
			"BLOCK_COMMENT"
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


	public MiniLenguajeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniLenguaje.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u0176\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\6-\u0115\n-\r-\16-\u0116"+
		"\3.\6.\u011a\n.\r.\16.\u011b\3.\3.\6.\u0120\n.\r.\16.\u0121\3/\6/\u0125"+
		"\n/\r/\16/\u0126\3/\3/\6/\u012b\n/\r/\16/\u012c\3/\3/\5/\u0131\n/\3/\6"+
		"/\u0134\n/\r/\16/\u0135\5/\u0138\n/\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\7\60\u0141\n\60\f\60\16\60\u0144\13\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\3\62\3\62\5\62\u014e\n\62\3\63\3\63\7\63\u0152\n\63\f\63\16\63\u0155"+
		"\13\63\3\64\6\64\u0158\n\64\r\64\16\64\u0159\3\64\3\64\3\65\3\65\3\65"+
		"\3\65\7\65\u0162\n\65\f\65\16\65\u0165\13\65\3\65\3\65\3\66\3\66\3\66"+
		"\3\66\7\66\u016d\n\66\f\66\16\66\u0170\13\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\u016e\2\67\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g"+
		"\65i\66k\67\3\2\n\3\2\62;\4\2GGgg\4\2--//\5\2\f\f\17\17$$\4\2C\\c|\6\2"+
		"\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0185\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\3m\3\2\2\2\5t\3\2\2\2\7z\3"+
		"\2\2\2\t~\3\2\2\2\13\u0084\3\2\2\2\r\u008b\3\2\2\2\17\u0092\3\2\2\2\21"+
		"\u0097\3\2\2\2\23\u009f\3\2\2\2\25\u00a4\3\2\2\2\27\u00a7\3\2\2\2\31\u00ac"+
		"\3\2\2\2\33\u00b2\3\2\2\2\35\u00b8\3\2\2\2\37\u00bc\3\2\2\2!\u00c3\3\2"+
		"\2\2#\u00c9\3\2\2\2%\u00d2\3\2\2\2\'\u00d7\3\2\2\2)\u00dd\3\2\2\2+\u00df"+
		"\3\2\2\2-\u00e2\3\2\2\2/\u00e5\3\2\2\2\61\u00e7\3\2\2\2\63\u00e9\3\2\2"+
		"\2\65\u00ec\3\2\2\2\67\u00ef\3\2\2\29\u00f2\3\2\2\2;\u00f5\3\2\2\2=\u00f7"+
		"\3\2\2\2?\u00f9\3\2\2\2A\u00fb\3\2\2\2C\u00fd\3\2\2\2E\u00ff\3\2\2\2G"+
		"\u0101\3\2\2\2I\u0103\3\2\2\2K\u0105\3\2\2\2M\u0107\3\2\2\2O\u0109\3\2"+
		"\2\2Q\u010b\3\2\2\2S\u010d\3\2\2\2U\u010f\3\2\2\2W\u0111\3\2\2\2Y\u0114"+
		"\3\2\2\2[\u0119\3\2\2\2]\u0124\3\2\2\2_\u0139\3\2\2\2a\u0147\3\2\2\2c"+
		"\u014d\3\2\2\2e\u014f\3\2\2\2g\u0157\3\2\2\2i\u015d\3\2\2\2k\u0168\3\2"+
		"\2\2mn\7k\2\2no\7o\2\2op\7r\2\2pq\7q\2\2qr\7t\2\2rs\7v\2\2s\4\3\2\2\2"+
		"tu\7e\2\2uv\7q\2\2vw\7p\2\2wx\7u\2\2xy\7v\2\2y\6\3\2\2\2z{\7k\2\2{|\7"+
		"p\2\2|}\7v\2\2}\b\3\2\2\2~\177\7h\2\2\177\u0080\7n\2\2\u0080\u0081\7q"+
		"\2\2\u0081\u0082\7c\2\2\u0082\u0083\7v\2\2\u0083\n\3\2\2\2\u0084\u0085"+
		"\7f\2\2\u0085\u0086\7q\2\2\u0086\u0087\7w\2\2\u0087\u0088\7d\2\2\u0088"+
		"\u0089\7n\2\2\u0089\u008a\7g\2\2\u008a\f\3\2\2\2\u008b\u008c\7u\2\2\u008c"+
		"\u008d\7v\2\2\u008d\u008e\7t\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2"+
		"\u0090\u0091\7i\2\2\u0091\16\3\2\2\2\u0092\u0093\7e\2\2\u0093\u0094\7"+
		"j\2\2\u0094\u0095\7c\2\2\u0095\u0096\7t\2\2\u0096\20\3\2\2\2\u0097\u0098"+
		"\7d\2\2\u0098\u0099\7q\2\2\u0099\u009a\7q\2\2\u009a\u009b\7n\2\2\u009b"+
		"\u009c\7g\2\2\u009c\u009d\7c\2\2\u009d\u009e\7p\2\2\u009e\22\3\2\2\2\u009f"+
		"\u00a0\7x\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7f\2\2"+
		"\u00a3\24\3\2\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7h\2\2\u00a6\26\3\2\2"+
		"\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab"+
		"\7g\2\2\u00ab\30\3\2\2\2\u00ac\u00ad\7r\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af"+
		"\7k\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7v\2\2\u00b1\32\3\2\2\2\u00b2\u00b3"+
		"\7y\2\2\u00b3\u00b4\7j\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7n\2\2\u00b6"+
		"\u00b7\7g\2\2\u00b7\34\3\2\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba\7q\2\2\u00ba"+
		"\u00bb\7t\2\2\u00bb\36\3\2\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7g\2\2\u00be"+
		"\u00bf\7v\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7p\2\2"+
		"\u00c2 \3\2\2\2\u00c3\u00c4\7d\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7g\2"+
		"\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7m\2\2\u00c8\"\3\2\2\2\u00c9\u00ca\7"+
		"e\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce"+
		"\7k\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7w\2\2\u00d0\u00d1\7g\2\2\u00d1"+
		"$\3\2\2\2\u00d2\u00d3\7v\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7w\2\2\u00d5"+
		"\u00d6\7g\2\2\u00d6&\3\2\2\2\u00d7\u00d8\7h\2\2\u00d8\u00d9\7c\2\2\u00d9"+
		"\u00da\7n\2\2\u00da\u00db\7u\2\2\u00db\u00dc\7g\2\2\u00dc(\3\2\2\2\u00dd"+
		"\u00de\7?\2\2\u00de*\3\2\2\2\u00df\u00e0\7?\2\2\u00e0\u00e1\7?\2\2\u00e1"+
		",\3\2\2\2\u00e2\u00e3\7#\2\2\u00e3\u00e4\7?\2\2\u00e4.\3\2\2\2\u00e5\u00e6"+
		"\7>\2\2\u00e6\60\3\2\2\2\u00e7\u00e8\7@\2\2\u00e8\62\3\2\2\2\u00e9\u00ea"+
		"\7>\2\2\u00ea\u00eb\7?\2\2\u00eb\64\3\2\2\2\u00ec\u00ed\7@\2\2\u00ed\u00ee"+
		"\7?\2\2\u00ee\66\3\2\2\2\u00ef\u00f0\7(\2\2\u00f0\u00f1\7(\2\2\u00f18"+
		"\3\2\2\2\u00f2\u00f3\7~\2\2\u00f3\u00f4\7~\2\2\u00f4:\3\2\2\2\u00f5\u00f6"+
		"\7#\2\2\u00f6<\3\2\2\2\u00f7\u00f8\7-\2\2\u00f8>\3\2\2\2\u00f9\u00fa\7"+
		"/\2\2\u00fa@\3\2\2\2\u00fb\u00fc\7,\2\2\u00fcB\3\2\2\2\u00fd\u00fe\7\61"+
		"\2\2\u00feD\3\2\2\2\u00ff\u0100\7\'\2\2\u0100F\3\2\2\2\u0101\u0102\7*"+
		"\2\2\u0102H\3\2\2\2\u0103\u0104\7+\2\2\u0104J\3\2\2\2\u0105\u0106\7]\2"+
		"\2\u0106L\3\2\2\2\u0107\u0108\7_\2\2\u0108N\3\2\2\2\u0109\u010a\7}\2\2"+
		"\u010aP\3\2\2\2\u010b\u010c\7\177\2\2\u010cR\3\2\2\2\u010d\u010e\7=\2"+
		"\2\u010eT\3\2\2\2\u010f\u0110\7\60\2\2\u0110V\3\2\2\2\u0111\u0112\7.\2"+
		"\2\u0112X\3\2\2\2\u0113\u0115\t\2\2\2\u0114\u0113\3\2\2\2\u0115\u0116"+
		"\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117Z\3\2\2\2\u0118"+
		"\u011a\t\2\2\2\u0119\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f\7\60\2\2\u011e"+
		"\u0120\t\2\2\2\u011f\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2"+
		"\2\2\u0121\u0122\3\2\2\2\u0122\\\3\2\2\2\u0123\u0125\t\2\2\2\u0124\u0123"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u012a\7\60\2\2\u0129\u012b\t\2\2\2\u012a\u0129\3"+
		"\2\2\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u0137\3\2\2\2\u012e\u0130\t\3\2\2\u012f\u0131\t\4\2\2\u0130\u012f\3\2"+
		"\2\2\u0130\u0131\3\2\2\2\u0131\u0133\3\2\2\2\u0132\u0134\t\2\2\2\u0133"+
		"\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136\u0138\3\2\2\2\u0137\u012e\3\2\2\2\u0137\u0138\3\2\2\2\u0138"+
		"^\3\2\2\2\u0139\u0142\7$\2\2\u013a\u0141\n\5\2\2\u013b\u013c\7^\2\2\u013c"+
		"\u013d\7^\2\2\u013d\u0141\7$\2\2\u013e\u013f\7^\2\2\u013f\u0141\7$\2\2"+
		"\u0140\u013a\3\2\2\2\u0140\u013b\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0144"+
		"\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0145\u0146\7$\2\2\u0146`\3\2\2\2\u0147\u0148\7)\2\2\u0148"+
		"\u0149\13\2\2\2\u0149\u014a\7)\2\2\u014ab\3\2\2\2\u014b\u014e\5%\23\2"+
		"\u014c\u014e\5\'\24\2\u014d\u014b\3\2\2\2\u014d\u014c\3\2\2\2\u014ed\3"+
		"\2\2\2\u014f\u0153\t\6\2\2\u0150\u0152\t\7\2\2\u0151\u0150\3\2\2\2\u0152"+
		"\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154f\3\2\2\2"+
		"\u0155\u0153\3\2\2\2\u0156\u0158\t\b\2\2\u0157\u0156\3\2\2\2\u0158\u0159"+
		"\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"\u015c\b\64\2\2\u015ch\3\2\2\2\u015d\u015e\7\61\2\2\u015e\u015f\7\61\2"+
		"\2\u015f\u0163\3\2\2\2\u0160\u0162\n\t\2\2\u0161\u0160\3\2\2\2\u0162\u0165"+
		"\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0166\u0167\b\65\2\2\u0167j\3\2\2\2\u0168\u0169\7\61\2"+
		"\2\u0169\u016a\7,\2\2\u016a\u016e\3\2\2\2\u016b\u016d\13\2\2\2\u016c\u016b"+
		"\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f"+
		"\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0172\7,\2\2\u0172\u0173\7\61"+
		"\2\2\u0173\u0174\3\2\2\2\u0174\u0175\b\66\2\2\u0175l\3\2\2\2\22\2\u0116"+
		"\u011b\u0121\u0126\u012c\u0130\u0135\u0137\u0140\u0142\u014d\u0153\u0159"+
		"\u0163\u016e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}