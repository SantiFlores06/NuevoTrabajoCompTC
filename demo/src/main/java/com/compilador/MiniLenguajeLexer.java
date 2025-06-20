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
		IMPORT=1, CONST=2, INT=3, FLOAT_TYPE=4, STRING_TYPE=5, CHAR_TYPE=6, BOOLEAN_TYPE=7, 
		VOID=8, IF=9, ELSE=10, PRINT=11, WHILE=12, FOR=13, RETURN=14, BREAK=15, 
		CONTINUE=16, TRUE=17, FALSE=18, ASIGNACION=19, IGUAL=20, DIFERENTE=21, 
		MENOR=22, MAYOR=23, MENOR_IGUAL=24, MAYOR_IGUAL=25, AND=26, OR=27, NOT=28, 
		MAS=29, MENOS=30, MULTIPLICACION=31, DIVISION=32, MODULO=33, PA=34, PC=35, 
		LA=36, LC=37, PYC=38, PUNTO=39, COMA=40, INTEGER=41, FLOAT=42, STRING=43, 
		CHAR=44, BOOLEAN=45, ID=46, WS=47, COMMENT=48, BLOCK_COMMENT=49;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IMPORT", "CONST", "INT", "FLOAT_TYPE", "STRING_TYPE", "CHAR_TYPE", "BOOLEAN_TYPE", 
			"VOID", "IF", "ELSE", "PRINT", "WHILE", "FOR", "RETURN", "BREAK", "CONTINUE", 
			"TRUE", "FALSE", "ASIGNACION", "IGUAL", "DIFERENTE", "MENOR", "MAYOR", 
			"MENOR_IGUAL", "MAYOR_IGUAL", "AND", "OR", "NOT", "MAS", "MENOS", "MULTIPLICACION", 
			"DIVISION", "MODULO", "PA", "PC", "LA", "LC", "PYC", "PUNTO", "COMA", 
			"INTEGER", "FLOAT", "STRING", "CHAR", "BOOLEAN", "ID", "WS", "COMMENT", 
			"BLOCK_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u014d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\6*\u0102\n*\r*\16*\u0103\3+\6+\u0107"+
		"\n+\r+\16+\u0108\3+\3+\6+\u010d\n+\r+\16+\u010e\3,\3,\3,\3,\3,\3,\3,\7"+
		",\u0118\n,\f,\16,\u011b\13,\3,\3,\3-\3-\3-\3-\3.\3.\5.\u0125\n.\3/\3/"+
		"\7/\u0129\n/\f/\16/\u012c\13/\3\60\6\60\u012f\n\60\r\60\16\60\u0130\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\7\61\u0139\n\61\f\61\16\61\u013c\13\61\3"+
		"\61\3\61\3\62\3\62\3\62\3\62\7\62\u0144\n\62\f\62\16\62\u0147\13\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\u0145\2\63\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63\3\2\b\3\2\62;\5\2\f\f\17\17$$\4\2C\\c|\6\2\62;C\\aa"+
		"c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0157\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2"+
		"\2\5l\3\2\2\2\7r\3\2\2\2\tv\3\2\2\2\13|\3\2\2\2\r\u0083\3\2\2\2\17\u0088"+
		"\3\2\2\2\21\u0090\3\2\2\2\23\u0095\3\2\2\2\25\u0098\3\2\2\2\27\u009d\3"+
		"\2\2\2\31\u00a3\3\2\2\2\33\u00a9\3\2\2\2\35\u00ad\3\2\2\2\37\u00b4\3\2"+
		"\2\2!\u00ba\3\2\2\2#\u00c3\3\2\2\2%\u00c8\3\2\2\2\'\u00ce\3\2\2\2)\u00d0"+
		"\3\2\2\2+\u00d3\3\2\2\2-\u00d6\3\2\2\2/\u00d8\3\2\2\2\61\u00da\3\2\2\2"+
		"\63\u00dd\3\2\2\2\65\u00e0\3\2\2\2\67\u00e3\3\2\2\29\u00e6\3\2\2\2;\u00e8"+
		"\3\2\2\2=\u00ea\3\2\2\2?\u00ec\3\2\2\2A\u00ee\3\2\2\2C\u00f0\3\2\2\2E"+
		"\u00f2\3\2\2\2G\u00f4\3\2\2\2I\u00f6\3\2\2\2K\u00f8\3\2\2\2M\u00fa\3\2"+
		"\2\2O\u00fc\3\2\2\2Q\u00fe\3\2\2\2S\u0101\3\2\2\2U\u0106\3\2\2\2W\u0110"+
		"\3\2\2\2Y\u011e\3\2\2\2[\u0124\3\2\2\2]\u0126\3\2\2\2_\u012e\3\2\2\2a"+
		"\u0134\3\2\2\2c\u013f\3\2\2\2ef\7k\2\2fg\7o\2\2gh\7r\2\2hi\7q\2\2ij\7"+
		"t\2\2jk\7v\2\2k\4\3\2\2\2lm\7e\2\2mn\7q\2\2no\7p\2\2op\7u\2\2pq\7v\2\2"+
		"q\6\3\2\2\2rs\7k\2\2st\7p\2\2tu\7v\2\2u\b\3\2\2\2vw\7h\2\2wx\7n\2\2xy"+
		"\7q\2\2yz\7c\2\2z{\7v\2\2{\n\3\2\2\2|}\7u\2\2}~\7v\2\2~\177\7t\2\2\177"+
		"\u0080\7k\2\2\u0080\u0081\7p\2\2\u0081\u0082\7i\2\2\u0082\f\3\2\2\2\u0083"+
		"\u0084\7e\2\2\u0084\u0085\7j\2\2\u0085\u0086\7c\2\2\u0086\u0087\7t\2\2"+
		"\u0087\16\3\2\2\2\u0088\u0089\7d\2\2\u0089\u008a\7q\2\2\u008a\u008b\7"+
		"q\2\2\u008b\u008c\7n\2\2\u008c\u008d\7g\2\2\u008d\u008e\7c\2\2\u008e\u008f"+
		"\7p\2\2\u008f\20\3\2\2\2\u0090\u0091\7x\2\2\u0091\u0092\7q\2\2\u0092\u0093"+
		"\7k\2\2\u0093\u0094\7f\2\2\u0094\22\3\2\2\2\u0095\u0096\7k\2\2\u0096\u0097"+
		"\7h\2\2\u0097\24\3\2\2\2\u0098\u0099\7g\2\2\u0099\u009a\7n\2\2\u009a\u009b"+
		"\7u\2\2\u009b\u009c\7g\2\2\u009c\26\3\2\2\2\u009d\u009e\7r\2\2\u009e\u009f"+
		"\7t\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7v\2\2\u00a2"+
		"\30\3\2\2\2\u00a3\u00a4\7y\2\2\u00a4\u00a5\7j\2\2\u00a5\u00a6\7k\2\2\u00a6"+
		"\u00a7\7n\2\2\u00a7\u00a8\7g\2\2\u00a8\32\3\2\2\2\u00a9\u00aa\7h\2\2\u00aa"+
		"\u00ab\7q\2\2\u00ab\u00ac\7t\2\2\u00ac\34\3\2\2\2\u00ad\u00ae\7t\2\2\u00ae"+
		"\u00af\7g\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7w\2\2\u00b1\u00b2\7t\2\2"+
		"\u00b2\u00b3\7p\2\2\u00b3\36\3\2\2\2\u00b4\u00b5\7d\2\2\u00b5\u00b6\7"+
		"t\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7c\2\2\u00b8\u00b9\7m\2\2\u00b9 "+
		"\3\2\2\2\u00ba\u00bb\7e\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7p\2\2\u00bd"+
		"\u00be\7v\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7w\2\2"+
		"\u00c1\u00c2\7g\2\2\u00c2\"\3\2\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7t"+
		"\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7g\2\2\u00c7$\3\2\2\2\u00c8\u00c9"+
		"\7h\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7u\2\2\u00cc"+
		"\u00cd\7g\2\2\u00cd&\3\2\2\2\u00ce\u00cf\7?\2\2\u00cf(\3\2\2\2\u00d0\u00d1"+
		"\7?\2\2\u00d1\u00d2\7?\2\2\u00d2*\3\2\2\2\u00d3\u00d4\7#\2\2\u00d4\u00d5"+
		"\7?\2\2\u00d5,\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7.\3\2\2\2\u00d8\u00d9\7"+
		"@\2\2\u00d9\60\3\2\2\2\u00da\u00db\7>\2\2\u00db\u00dc\7?\2\2\u00dc\62"+
		"\3\2\2\2\u00dd\u00de\7@\2\2\u00de\u00df\7?\2\2\u00df\64\3\2\2\2\u00e0"+
		"\u00e1\7(\2\2\u00e1\u00e2\7(\2\2\u00e2\66\3\2\2\2\u00e3\u00e4\7~\2\2\u00e4"+
		"\u00e5\7~\2\2\u00e58\3\2\2\2\u00e6\u00e7\7#\2\2\u00e7:\3\2\2\2\u00e8\u00e9"+
		"\7-\2\2\u00e9<\3\2\2\2\u00ea\u00eb\7/\2\2\u00eb>\3\2\2\2\u00ec\u00ed\7"+
		",\2\2\u00ed@\3\2\2\2\u00ee\u00ef\7\61\2\2\u00efB\3\2\2\2\u00f0\u00f1\7"+
		"\'\2\2\u00f1D\3\2\2\2\u00f2\u00f3\7*\2\2\u00f3F\3\2\2\2\u00f4\u00f5\7"+
		"+\2\2\u00f5H\3\2\2\2\u00f6\u00f7\7}\2\2\u00f7J\3\2\2\2\u00f8\u00f9\7\177"+
		"\2\2\u00f9L\3\2\2\2\u00fa\u00fb\7=\2\2\u00fbN\3\2\2\2\u00fc\u00fd\7\60"+
		"\2\2\u00fdP\3\2\2\2\u00fe\u00ff\7.\2\2\u00ffR\3\2\2\2\u0100\u0102\t\2"+
		"\2\2\u0101\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103"+
		"\u0104\3\2\2\2\u0104T\3\2\2\2\u0105\u0107\t\2\2\2\u0106\u0105\3\2\2\2"+
		"\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u010c\7\60\2\2\u010b\u010d\t\2\2\2\u010c\u010b\3\2\2\2"+
		"\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010fV\3"+
		"\2\2\2\u0110\u0119\7$\2\2\u0111\u0118\n\3\2\2\u0112\u0113\7^\2\2\u0113"+
		"\u0114\7^\2\2\u0114\u0118\7$\2\2\u0115\u0116\7^\2\2\u0116\u0118\7$\2\2"+
		"\u0117\u0111\3\2\2\2\u0117\u0112\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011b"+
		"\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011c\u011d\7$\2\2\u011dX\3\2\2\2\u011e\u011f\7)\2\2\u011f"+
		"\u0120\13\2\2\2\u0120\u0121\7)\2\2\u0121Z\3\2\2\2\u0122\u0125\5#\22\2"+
		"\u0123\u0125\5%\23\2\u0124\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125\\\3"+
		"\2\2\2\u0126\u012a\t\4\2\2\u0127\u0129\t\5\2\2\u0128\u0127\3\2\2\2\u0129"+
		"\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b^\3\2\2\2"+
		"\u012c\u012a\3\2\2\2\u012d\u012f\t\6\2\2\u012e\u012d\3\2\2\2\u012f\u0130"+
		"\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0133\b\60\2\2\u0133`\3\2\2\2\u0134\u0135\7\61\2\2\u0135\u0136\7\61\2"+
		"\2\u0136\u013a\3\2\2\2\u0137\u0139\n\7\2\2\u0138\u0137\3\2\2\2\u0139\u013c"+
		"\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013d\u013e\b\61\2\2\u013eb\3\2\2\2\u013f\u0140\7\61\2"+
		"\2\u0140\u0141\7,\2\2\u0141\u0145\3\2\2\2\u0142\u0144\13\2\2\2\u0143\u0142"+
		"\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0146\3\2\2\2\u0145\u0143\3\2\2\2\u0146"+
		"\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\7,\2\2\u0149\u014a\7\61"+
		"\2\2\u014a\u014b\3\2\2\2\u014b\u014c\b\62\2\2\u014cd\3\2\2\2\r\2\u0103"+
		"\u0108\u010e\u0117\u0119\u0124\u012a\u0130\u013a\u0145\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}