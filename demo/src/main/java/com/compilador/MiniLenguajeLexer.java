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
		CHAR_TYPE=7, BOOLEAN_TYPE=8, BOOL_TYPE=9, VOID=10, IF=11, ELSE=12, PRINT=13, 
		WHILE=14, FOR=15, RETURN=16, BREAK=17, CONTINUE=18, TRUE=19, FALSE=20, 
		ASIGNACION=21, IGUAL=22, DIFERENTE=23, MENOR=24, MAYOR=25, MENOR_IGUAL=26, 
		MAYOR_IGUAL=27, AND=28, OR=29, NOT=30, MAS=31, MENOS=32, MULTIPLICACION=33, 
		DIVISION=34, MODULO=35, PA=36, PC=37, PRA=38, PRC=39, LA=40, LC=41, PYC=42, 
		PUNTO=43, COMA=44, INTEGER=45, FLOAT=46, DOUBLE=47, STRING=48, CHAR=49, 
		BOOLEAN=50, ID=51, WS=52, COMMENT=53, BLOCK_COMMENT=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IMPORT", "CONST", "INT", "FLOAT_TYPE", "DOUBLE_TYPE", "STRING_TYPE", 
			"CHAR_TYPE", "BOOLEAN_TYPE", "BOOL_TYPE", "VOID", "IF", "ELSE", "PRINT", 
			"WHILE", "FOR", "RETURN", "BREAK", "CONTINUE", "TRUE", "FALSE", "ASIGNACION", 
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
			"'char'", "'boolean'", "'bool'", "'void'", "'if'", "'else'", "'print'", 
			"'while'", "'for'", "'return'", "'break'", "'continue'", "'true'", "'false'", 
			"'='", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", 
			"'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "';'", "'.'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IMPORT", "CONST", "INT", "FLOAT_TYPE", "DOUBLE_TYPE", "STRING_TYPE", 
			"CHAR_TYPE", "BOOLEAN_TYPE", "BOOL_TYPE", "VOID", "IF", "ELSE", "PRINT", 
			"WHILE", "FOR", "RETURN", "BREAK", "CONTINUE", "TRUE", "FALSE", "ASIGNACION", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u017d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3"+
		",\3-\3-\3.\6.\u011c\n.\r.\16.\u011d\3/\6/\u0121\n/\r/\16/\u0122\3/\3/"+
		"\6/\u0127\n/\r/\16/\u0128\3\60\6\60\u012c\n\60\r\60\16\60\u012d\3\60\3"+
		"\60\6\60\u0132\n\60\r\60\16\60\u0133\3\60\3\60\5\60\u0138\n\60\3\60\6"+
		"\60\u013b\n\60\r\60\16\60\u013c\5\60\u013f\n\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\61\3\61\7\61\u0148\n\61\f\61\16\61\u014b\13\61\3\61\3\61\3\62\3"+
		"\62\3\62\3\62\3\63\3\63\5\63\u0155\n\63\3\64\3\64\7\64\u0159\n\64\f\64"+
		"\16\64\u015c\13\64\3\65\6\65\u015f\n\65\r\65\16\65\u0160\3\65\3\65\3\66"+
		"\3\66\3\66\3\66\7\66\u0169\n\66\f\66\16\66\u016c\13\66\3\66\3\66\3\67"+
		"\3\67\3\67\3\67\7\67\u0174\n\67\f\67\16\67\u0177\13\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\u0175\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
		"e\64g\65i\66k\67m8\3\2\n\3\2\62;\4\2GGgg\4\2--//\5\2\f\f\17\17$$\4\2C"+
		"\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u018c\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o\3\2\2"+
		"\2\5v\3\2\2\2\7|\3\2\2\2\t\u0080\3\2\2\2\13\u0086\3\2\2\2\r\u008d\3\2"+
		"\2\2\17\u0094\3\2\2\2\21\u0099\3\2\2\2\23\u00a1\3\2\2\2\25\u00a6\3\2\2"+
		"\2\27\u00ab\3\2\2\2\31\u00ae\3\2\2\2\33\u00b3\3\2\2\2\35\u00b9\3\2\2\2"+
		"\37\u00bf\3\2\2\2!\u00c3\3\2\2\2#\u00ca\3\2\2\2%\u00d0\3\2\2\2\'\u00d9"+
		"\3\2\2\2)\u00de\3\2\2\2+\u00e4\3\2\2\2-\u00e6\3\2\2\2/\u00e9\3\2\2\2\61"+
		"\u00ec\3\2\2\2\63\u00ee\3\2\2\2\65\u00f0\3\2\2\2\67\u00f3\3\2\2\29\u00f6"+
		"\3\2\2\2;\u00f9\3\2\2\2=\u00fc\3\2\2\2?\u00fe\3\2\2\2A\u0100\3\2\2\2C"+
		"\u0102\3\2\2\2E\u0104\3\2\2\2G\u0106\3\2\2\2I\u0108\3\2\2\2K\u010a\3\2"+
		"\2\2M\u010c\3\2\2\2O\u010e\3\2\2\2Q\u0110\3\2\2\2S\u0112\3\2\2\2U\u0114"+
		"\3\2\2\2W\u0116\3\2\2\2Y\u0118\3\2\2\2[\u011b\3\2\2\2]\u0120\3\2\2\2_"+
		"\u012b\3\2\2\2a\u0140\3\2\2\2c\u014e\3\2\2\2e\u0154\3\2\2\2g\u0156\3\2"+
		"\2\2i\u015e\3\2\2\2k\u0164\3\2\2\2m\u016f\3\2\2\2op\7k\2\2pq\7o\2\2qr"+
		"\7r\2\2rs\7q\2\2st\7t\2\2tu\7v\2\2u\4\3\2\2\2vw\7e\2\2wx\7q\2\2xy\7p\2"+
		"\2yz\7u\2\2z{\7v\2\2{\6\3\2\2\2|}\7k\2\2}~\7p\2\2~\177\7v\2\2\177\b\3"+
		"\2\2\2\u0080\u0081\7h\2\2\u0081\u0082\7n\2\2\u0082\u0083\7q\2\2\u0083"+
		"\u0084\7c\2\2\u0084\u0085\7v\2\2\u0085\n\3\2\2\2\u0086\u0087\7f\2\2\u0087"+
		"\u0088\7q\2\2\u0088\u0089\7w\2\2\u0089\u008a\7d\2\2\u008a\u008b\7n\2\2"+
		"\u008b\u008c\7g\2\2\u008c\f\3\2\2\2\u008d\u008e\7u\2\2\u008e\u008f\7v"+
		"\2\2\u008f\u0090\7t\2\2\u0090\u0091\7k\2\2\u0091\u0092\7p\2\2\u0092\u0093"+
		"\7i\2\2\u0093\16\3\2\2\2\u0094\u0095\7e\2\2\u0095\u0096\7j\2\2\u0096\u0097"+
		"\7c\2\2\u0097\u0098\7t\2\2\u0098\20\3\2\2\2\u0099\u009a\7d\2\2\u009a\u009b"+
		"\7q\2\2\u009b\u009c\7q\2\2\u009c\u009d\7n\2\2\u009d\u009e\7g\2\2\u009e"+
		"\u009f\7c\2\2\u009f\u00a0\7p\2\2\u00a0\22\3\2\2\2\u00a1\u00a2\7d\2\2\u00a2"+
		"\u00a3\7q\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7n\2\2\u00a5\24\3\2\2\2\u00a6"+
		"\u00a7\7x\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7f\2\2"+
		"\u00aa\26\3\2\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7h\2\2\u00ad\30\3\2\2"+
		"\2\u00ae\u00af\7g\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7u\2\2\u00b1\u00b2"+
		"\7g\2\2\u00b2\32\3\2\2\2\u00b3\u00b4\7r\2\2\u00b4\u00b5\7t\2\2\u00b5\u00b6"+
		"\7k\2\2\u00b6\u00b7\7p\2\2\u00b7\u00b8\7v\2\2\u00b8\34\3\2\2\2\u00b9\u00ba"+
		"\7y\2\2\u00ba\u00bb\7j\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7n\2\2\u00bd"+
		"\u00be\7g\2\2\u00be\36\3\2\2\2\u00bf\u00c0\7h\2\2\u00c0\u00c1\7q\2\2\u00c1"+
		"\u00c2\7t\2\2\u00c2 \3\2\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7g\2\2\u00c5"+
		"\u00c6\7v\2\2\u00c6\u00c7\7w\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7p\2\2"+
		"\u00c9\"\3\2\2\2\u00ca\u00cb\7d\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7g"+
		"\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7m\2\2\u00cf$\3\2\2\2\u00d0\u00d1"+
		"\7e\2\2\u00d1\u00d2\7q\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7v\2\2\u00d4"+
		"\u00d5\7k\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7w\2\2\u00d7\u00d8\7g\2\2"+
		"\u00d8&\3\2\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7t\2\2\u00db\u00dc\7w\2"+
		"\2\u00dc\u00dd\7g\2\2\u00dd(\3\2\2\2\u00de\u00df\7h\2\2\u00df\u00e0\7"+
		"c\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7g\2\2\u00e3*"+
		"\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5,\3\2\2\2\u00e6\u00e7\7?\2\2\u00e7\u00e8"+
		"\7?\2\2\u00e8.\3\2\2\2\u00e9\u00ea\7#\2\2\u00ea\u00eb\7?\2\2\u00eb\60"+
		"\3\2\2\2\u00ec\u00ed\7>\2\2\u00ed\62\3\2\2\2\u00ee\u00ef\7@\2\2\u00ef"+
		"\64\3\2\2\2\u00f0\u00f1\7>\2\2\u00f1\u00f2\7?\2\2\u00f2\66\3\2\2\2\u00f3"+
		"\u00f4\7@\2\2\u00f4\u00f5\7?\2\2\u00f58\3\2\2\2\u00f6\u00f7\7(\2\2\u00f7"+
		"\u00f8\7(\2\2\u00f8:\3\2\2\2\u00f9\u00fa\7~\2\2\u00fa\u00fb\7~\2\2\u00fb"+
		"<\3\2\2\2\u00fc\u00fd\7#\2\2\u00fd>\3\2\2\2\u00fe\u00ff\7-\2\2\u00ff@"+
		"\3\2\2\2\u0100\u0101\7/\2\2\u0101B\3\2\2\2\u0102\u0103\7,\2\2\u0103D\3"+
		"\2\2\2\u0104\u0105\7\61\2\2\u0105F\3\2\2\2\u0106\u0107\7\'\2\2\u0107H"+
		"\3\2\2\2\u0108\u0109\7*\2\2\u0109J\3\2\2\2\u010a\u010b\7+\2\2\u010bL\3"+
		"\2\2\2\u010c\u010d\7]\2\2\u010dN\3\2\2\2\u010e\u010f\7_\2\2\u010fP\3\2"+
		"\2\2\u0110\u0111\7}\2\2\u0111R\3\2\2\2\u0112\u0113\7\177\2\2\u0113T\3"+
		"\2\2\2\u0114\u0115\7=\2\2\u0115V\3\2\2\2\u0116\u0117\7\60\2\2\u0117X\3"+
		"\2\2\2\u0118\u0119\7.\2\2\u0119Z\3\2\2\2\u011a\u011c\t\2\2\2\u011b\u011a"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\\\3\2\2\2\u011f\u0121\t\2\2\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2"+
		"\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126"+
		"\7\60\2\2\u0125\u0127\t\2\2\2\u0126\u0125\3\2\2\2\u0127\u0128\3\2\2\2"+
		"\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129^\3\2\2\2\u012a\u012c\t"+
		"\2\2\2\u012b\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012b\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0131\7\60\2\2\u0130\u0132\t"+
		"\2\2\2\u0131\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u013e\3\2\2\2\u0135\u0137\t\3\2\2\u0136\u0138\t\4"+
		"\2\2\u0137\u0136\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139"+
		"\u013b\t\2\2\2\u013a\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2"+
		"\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u0135\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f`\3\2\2\2\u0140\u0149\7$\2\2\u0141\u0148\n\5\2\2\u0142"+
		"\u0143\7^\2\2\u0143\u0144\7^\2\2\u0144\u0148\7$\2\2\u0145\u0146\7^\2\2"+
		"\u0146\u0148\7$\2\2\u0147\u0141\3\2\2\2\u0147\u0142\3\2\2\2\u0147\u0145"+
		"\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\7$\2\2\u014db\3\2\2\2\u014e"+
		"\u014f\7)\2\2\u014f\u0150\13\2\2\2\u0150\u0151\7)\2\2\u0151d\3\2\2\2\u0152"+
		"\u0155\5\'\24\2\u0153\u0155\5)\25\2\u0154\u0152\3\2\2\2\u0154\u0153\3"+
		"\2\2\2\u0155f\3\2\2\2\u0156\u015a\t\6\2\2\u0157\u0159\t\7\2\2\u0158\u0157"+
		"\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"h\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015f\t\b\2\2\u015e\u015d\3\2\2\2"+
		"\u015f\u0160\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0162"+
		"\3\2\2\2\u0162\u0163\b\65\2\2\u0163j\3\2\2\2\u0164\u0165\7\61\2\2\u0165"+
		"\u0166\7\61\2\2\u0166\u016a\3\2\2\2\u0167\u0169\n\t\2\2\u0168\u0167\3"+
		"\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016e\b\66\2\2\u016el\3\2\2\2"+
		"\u016f\u0170\7\61\2\2\u0170\u0171\7,\2\2\u0171\u0175\3\2\2\2\u0172\u0174"+
		"\13\2\2\2\u0173\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0176\3\2\2\2"+
		"\u0175\u0173\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179"+
		"\7,\2\2\u0179\u017a\7\61\2\2\u017a\u017b\3\2\2\2\u017b\u017c\b\67\2\2"+
		"\u017cn\3\2\2\2\22\2\u011d\u0122\u0128\u012d\u0133\u0137\u013c\u013e\u0147"+
		"\u0149\u0154\u015a\u0160\u016a\u0175\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}