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
		ID=1, INTEGER=2, STRING=3, BOOLEAN=4, KEYWORD=5, OPERATOR=6, PA=7, PC=8, 
		LA=9, LC=10, PYC=11, PUNTO=12, COMA=13, WS=14, COMMENT=15, BLOCK_COMMENT=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "INTEGER", "STRING", "BOOLEAN", "KEYWORD", "OPERATOR", "PA", "PC", 
			"LA", "LC", "PYC", "PUNTO", "COMA", "WS", "COMMENT", "BLOCK_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'('", "')'", "'{'", "'}'", 
			"';'", "'.'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "INTEGER", "STRING", "BOOLEAN", "KEYWORD", "OPERATOR", "PA", 
			"PC", "LA", "LC", "PYC", "PUNTO", "COMA", "WS", "COMMENT", "BLOCK_COMMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u00aa\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3"+
		"\2\7\2&\n\2\f\2\16\2)\13\2\3\3\6\3,\n\3\r\3\16\3-\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5G\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6j\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7{\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\17\6\17\u008c\n\17\r\17\16\17\u008d\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\7\20\u0096\n\20\f\20\16\20\u0099\13\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\7\21\u00a1\n\21\f\21\16\21\u00a4\13\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\u00a2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22\3\2\n\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\5\2\f"+
		"\f\17\17$$\7\2\'\',-//\61\61??\4\2>>@@\5\2\13\f\17\17\"\"\4\2\f\f\17\17"+
		"\2\u00c0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\3#\3\2\2\2\5+\3\2\2\2\7/\3\2\2\2\tF\3\2\2\2\13i\3\2\2\2\rz\3\2\2\2"+
		"\17|\3\2\2\2\21~\3\2\2\2\23\u0080\3\2\2\2\25\u0082\3\2\2\2\27\u0084\3"+
		"\2\2\2\31\u0086\3\2\2\2\33\u0088\3\2\2\2\35\u008b\3\2\2\2\37\u0091\3\2"+
		"\2\2!\u009c\3\2\2\2#\'\t\2\2\2$&\t\3\2\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2"+
		"\2\'(\3\2\2\2(\4\3\2\2\2)\'\3\2\2\2*,\t\4\2\2+*\3\2\2\2,-\3\2\2\2-+\3"+
		"\2\2\2-.\3\2\2\2.\6\3\2\2\2/8\7$\2\2\60\67\n\5\2\2\61\62\7^\2\2\62\63"+
		"\7^\2\2\63\67\7$\2\2\64\65\7^\2\2\65\67\7$\2\2\66\60\3\2\2\2\66\61\3\2"+
		"\2\2\66\64\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2"+
		"\2;<\7$\2\2<\b\3\2\2\2=>\7v\2\2>?\7t\2\2?@\7w\2\2@G\7g\2\2AB\7h\2\2BC"+
		"\7c\2\2CD\7n\2\2DE\7u\2\2EG\7g\2\2F=\3\2\2\2FA\3\2\2\2G\n\3\2\2\2HI\7"+
		"x\2\2IJ\7c\2\2Jj\7t\2\2KL\7k\2\2Lj\7h\2\2MN\7g\2\2NO\7n\2\2OP\7u\2\2P"+
		"j\7g\2\2QR\7r\2\2RS\7t\2\2ST\7k\2\2TU\7p\2\2Uj\7v\2\2VW\7y\2\2WX\7j\2"+
		"\2XY\7k\2\2YZ\7n\2\2Zj\7g\2\2[\\\7h\2\2\\]\7w\2\2]^\7p\2\2^_\7e\2\2_`"+
		"\7v\2\2`a\7k\2\2ab\7q\2\2bj\7p\2\2cd\7t\2\2de\7g\2\2ef\7v\2\2fg\7w\2\2"+
		"gh\7t\2\2hj\7p\2\2iH\3\2\2\2iK\3\2\2\2iM\3\2\2\2iQ\3\2\2\2iV\3\2\2\2i"+
		"[\3\2\2\2ic\3\2\2\2j\f\3\2\2\2k{\t\6\2\2lm\7?\2\2m{\7?\2\2no\7#\2\2o{"+
		"\7?\2\2p{\t\7\2\2qr\7>\2\2r{\7?\2\2st\7@\2\2t{\7?\2\2uv\7(\2\2v{\7(\2"+
		"\2wx\7~\2\2x{\7~\2\2y{\7#\2\2zk\3\2\2\2zl\3\2\2\2zn\3\2\2\2zp\3\2\2\2"+
		"zq\3\2\2\2zs\3\2\2\2zu\3\2\2\2zw\3\2\2\2zy\3\2\2\2{\16\3\2\2\2|}\7*\2"+
		"\2}\20\3\2\2\2~\177\7+\2\2\177\22\3\2\2\2\u0080\u0081\7}\2\2\u0081\24"+
		"\3\2\2\2\u0082\u0083\7\177\2\2\u0083\26\3\2\2\2\u0084\u0085\7=\2\2\u0085"+
		"\30\3\2\2\2\u0086\u0087\7\60\2\2\u0087\32\3\2\2\2\u0088\u0089\7.\2\2\u0089"+
		"\34\3\2\2\2\u008a\u008c\t\b\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2"+
		"\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090"+
		"\b\17\2\2\u0090\36\3\2\2\2\u0091\u0092\7\61\2\2\u0092\u0093\7\61\2\2\u0093"+
		"\u0097\3\2\2\2\u0094\u0096\n\t\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2"+
		"\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u009a\u009b\b\20\2\2\u009b \3\2\2\2\u009c\u009d\7\61\2"+
		"\2\u009d\u009e\7,\2\2\u009e\u00a2\3\2\2\2\u009f\u00a1\13\2\2\2\u00a0\u009f"+
		"\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\7,\2\2\u00a6\u00a7\7\61"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\21\2\2\u00a9\"\3\2\2\2\r\2\'-\66"+
		"8Fiz\u008d\u0097\u00a2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}