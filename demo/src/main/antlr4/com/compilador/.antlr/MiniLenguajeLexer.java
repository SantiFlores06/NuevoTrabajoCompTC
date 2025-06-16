// Generated from d:/Users/Usuario/Desktop/Facultad/5to/1er Cuatrimestre/Tecnicas de Compilacion/NuevoTrabajoCompTC/demo/src/main/antlr4/com/compilador/MiniLenguaje.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniLenguajeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

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
		"\u0004\u0000\u0010\u00a8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0005\u0000$\b\u0000"+
		"\n\u0000\f\u0000\'\t\u0000\u0001\u0001\u0004\u0001*\b\u0001\u000b\u0001"+
		"\f\u0001+\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u00025\b\u0002\n\u0002\f\u00028\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"E\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004h\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005y\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0004\r\u008a"+
		"\b\r\u000b\r\f\r\u008b\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u0094\b\u000e\n\u000e\f\u000e\u0097\t\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u009f\b\u000f\n\u000f\f\u000f\u00a2\t\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u00a0\u0000\u0010\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010\u0001\u0000\b\u0002\u0000AZaz\u0004\u000009AZ__az\u0001\u0000"+
		"09\u0003\u0000\n\n\r\r\"\"\u0005\u0000%%*+--//==\u0002\u0000<<>>\u0003"+
		"\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u00be\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003)\u0001"+
		"\u0000\u0000\u0000\u0005-\u0001\u0000\u0000\u0000\u0007D\u0001\u0000\u0000"+
		"\u0000\tg\u0001\u0000\u0000\u0000\u000bx\u0001\u0000\u0000\u0000\rz\u0001"+
		"\u0000\u0000\u0000\u000f|\u0001\u0000\u0000\u0000\u0011~\u0001\u0000\u0000"+
		"\u0000\u0013\u0080\u0001\u0000\u0000\u0000\u0015\u0082\u0001\u0000\u0000"+
		"\u0000\u0017\u0084\u0001\u0000\u0000\u0000\u0019\u0086\u0001\u0000\u0000"+
		"\u0000\u001b\u0089\u0001\u0000\u0000\u0000\u001d\u008f\u0001\u0000\u0000"+
		"\u0000\u001f\u009a\u0001\u0000\u0000\u0000!%\u0007\u0000\u0000\u0000\""+
		"$\u0007\u0001\u0000\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000"+
		"\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\u0002\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(*\u0007\u0002\u0000\u0000"+
		")(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000"+
		"\u0000+,\u0001\u0000\u0000\u0000,\u0004\u0001\u0000\u0000\u0000-6\u0005"+
		"\"\u0000\u0000.5\b\u0003\u0000\u0000/0\u0005\\\u0000\u000001\u0005\\\u0000"+
		"\u000015\u0005\"\u0000\u000023\u0005\\\u0000\u000035\u0005\"\u0000\u0000"+
		"4.\u0001\u0000\u0000\u00004/\u0001\u0000\u0000\u000042\u0001\u0000\u0000"+
		"\u000058\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000079\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u00009:\u0005"+
		"\"\u0000\u0000:\u0006\u0001\u0000\u0000\u0000;<\u0005t\u0000\u0000<=\u0005"+
		"r\u0000\u0000=>\u0005u\u0000\u0000>E\u0005e\u0000\u0000?@\u0005f\u0000"+
		"\u0000@A\u0005a\u0000\u0000AB\u0005l\u0000\u0000BC\u0005s\u0000\u0000"+
		"CE\u0005e\u0000\u0000D;\u0001\u0000\u0000\u0000D?\u0001\u0000\u0000\u0000"+
		"E\b\u0001\u0000\u0000\u0000FG\u0005v\u0000\u0000GH\u0005a\u0000\u0000"+
		"Hh\u0005r\u0000\u0000IJ\u0005i\u0000\u0000Jh\u0005f\u0000\u0000KL\u0005"+
		"e\u0000\u0000LM\u0005l\u0000\u0000MN\u0005s\u0000\u0000Nh\u0005e\u0000"+
		"\u0000OP\u0005p\u0000\u0000PQ\u0005r\u0000\u0000QR\u0005i\u0000\u0000"+
		"RS\u0005n\u0000\u0000Sh\u0005t\u0000\u0000TU\u0005w\u0000\u0000UV\u0005"+
		"h\u0000\u0000VW\u0005i\u0000\u0000WX\u0005l\u0000\u0000Xh\u0005e\u0000"+
		"\u0000YZ\u0005f\u0000\u0000Z[\u0005u\u0000\u0000[\\\u0005n\u0000\u0000"+
		"\\]\u0005c\u0000\u0000]^\u0005t\u0000\u0000^_\u0005i\u0000\u0000_`\u0005"+
		"o\u0000\u0000`h\u0005n\u0000\u0000ab\u0005r\u0000\u0000bc\u0005e\u0000"+
		"\u0000cd\u0005t\u0000\u0000de\u0005u\u0000\u0000ef\u0005r\u0000\u0000"+
		"fh\u0005n\u0000\u0000gF\u0001\u0000\u0000\u0000gI\u0001\u0000\u0000\u0000"+
		"gK\u0001\u0000\u0000\u0000gO\u0001\u0000\u0000\u0000gT\u0001\u0000\u0000"+
		"\u0000gY\u0001\u0000\u0000\u0000ga\u0001\u0000\u0000\u0000h\n\u0001\u0000"+
		"\u0000\u0000iy\u0007\u0004\u0000\u0000jk\u0005=\u0000\u0000ky\u0005=\u0000"+
		"\u0000lm\u0005!\u0000\u0000my\u0005=\u0000\u0000ny\u0007\u0005\u0000\u0000"+
		"op\u0005<\u0000\u0000py\u0005=\u0000\u0000qr\u0005>\u0000\u0000ry\u0005"+
		"=\u0000\u0000st\u0005&\u0000\u0000ty\u0005&\u0000\u0000uv\u0005|\u0000"+
		"\u0000vy\u0005|\u0000\u0000wy\u0005!\u0000\u0000xi\u0001\u0000\u0000\u0000"+
		"xj\u0001\u0000\u0000\u0000xl\u0001\u0000\u0000\u0000xn\u0001\u0000\u0000"+
		"\u0000xo\u0001\u0000\u0000\u0000xq\u0001\u0000\u0000\u0000xs\u0001\u0000"+
		"\u0000\u0000xu\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y\f\u0001"+
		"\u0000\u0000\u0000z{\u0005(\u0000\u0000{\u000e\u0001\u0000\u0000\u0000"+
		"|}\u0005)\u0000\u0000}\u0010\u0001\u0000\u0000\u0000~\u007f\u0005{\u0000"+
		"\u0000\u007f\u0012\u0001\u0000\u0000\u0000\u0080\u0081\u0005}\u0000\u0000"+
		"\u0081\u0014\u0001\u0000\u0000\u0000\u0082\u0083\u0005;\u0000\u0000\u0083"+
		"\u0016\u0001\u0000\u0000\u0000\u0084\u0085\u0005.\u0000\u0000\u0085\u0018"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0005,\u0000\u0000\u0087\u001a\u0001"+
		"\u0000\u0000\u0000\u0088\u008a\u0007\u0006\u0000\u0000\u0089\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0006\r\u0000\u0000\u008e\u001c\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0005/\u0000\u0000\u0090\u0091\u0005/\u0000\u0000"+
		"\u0091\u0095\u0001\u0000\u0000\u0000\u0092\u0094\b\u0007\u0000\u0000\u0093"+
		"\u0092\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095"+
		"\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096"+
		"\u0098\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0006\u000e\u0000\u0000\u0099\u001e\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005/\u0000\u0000\u009b\u009c\u0005*\u0000\u0000\u009c\u00a0\u0001"+
		"\u0000\u0000\u0000\u009d\u009f\t\u0000\u0000\u0000\u009e\u009d\u0001\u0000"+
		"\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005*\u0000"+
		"\u0000\u00a4\u00a5\u0005/\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0006\u000f\u0000\u0000\u00a7 \u0001\u0000\u0000\u0000\u000b"+
		"\u0000%+46Dgx\u008b\u0095\u00a0\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}