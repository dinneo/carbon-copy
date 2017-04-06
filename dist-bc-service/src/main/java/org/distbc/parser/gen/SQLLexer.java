// Generated from /Users/mhelmich/playground/projects/dist-bc/dist-bc-service/src/main/resources/SQLLexer.g4 by ANTLR 4.6

package org.distbc.parser.gen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, FROM=2, WHERE=3, AND=4, OR=5, XOR=6, IS=7, NULL=8, LIKE=9, IN=10, 
		EXISTS=11, ALL=12, ANY=13, TRUE=14, FALSE=15, DIVIDE=16, MOD=17, BETWEEN=18, 
		REGEXP=19, PLUS=20, MINUS=21, NEGATION=22, VERTBAR=23, BITAND=24, POWER_OP=25, 
		BINARY=26, SHIFT_LEFT=27, SHIFT_RIGHT=28, ESCAPE=29, ASTERISK=30, RPAREN=31, 
		LPAREN=32, RBRACK=33, LBRACK=34, COLON=35, ALL_FIELDS=36, EQ=37, LTH=38, 
		GTH=39, NOT_EQ=40, NOT=41, LET=42, GET=43, SEMI=44, COMMA=45, DOT=46, 
		COLLATE=47, INNER=48, OUTER=49, JOIN=50, CROSS=51, USING=52, INDEX=53, 
		KEY=54, ORDER=55, GROUP=56, BY=57, FOR=58, USE=59, IGNORE=60, PARTITION=61, 
		STRAIGHT_JOIN=62, NATURAL=63, LEFT=64, RIGHT=65, OJ=66, ON=67, ID=68, 
		QUOTED_LITERAL=69, INT=70, NEWLINE=71, WS=72, USER_VAR=73;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "FROM", "WHERE", "AND", "OR", "XOR", "IS", "NULL", "LIKE", "IN", 
		"EXISTS", "ALL", "ANY", "TRUE", "FALSE", "DIVIDE", "MOD", "BETWEEN", "REGEXP", 
		"PLUS", "MINUS", "NEGATION", "VERTBAR", "BITAND", "POWER_OP", "BINARY", 
		"SHIFT_LEFT", "SHIFT_RIGHT", "ESCAPE", "ASTERISK", "RPAREN", "LPAREN", 
		"RBRACK", "LBRACK", "COLON", "ALL_FIELDS", "EQ", "LTH", "GTH", "NOT_EQ", 
		"NOT", "LET", "GET", "SEMI", "COMMA", "DOT", "COLLATE", "INNER", "OUTER", 
		"JOIN", "CROSS", "USING", "INDEX", "KEY", "ORDER", "GROUP", "BY", "FOR", 
		"USE", "IGNORE", "PARTITION", "STRAIGHT_JOIN", "NATURAL", "LEFT", "RIGHT", 
		"OJ", "ON", "ID", "QUOTED_LITERAL", "INT", "NEWLINE", "WS", "USER_VAR", 
		"USER_VAR_SUBFIX1", "USER_VAR_SUBFIX2", "USER_VAR_SUBFIX3", "USER_VAR_SUBFIX4"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'from'", "'where'", null, null, "'xor'", "'is'", "'null'", 
		"'like'", "'in'", "'exists'", "'all'", "'any'", "'true'", "'false'", null, 
		null, "'between'", "'regexp'", "'+'", "'-'", "'~'", "'|'", "'&'", "'^'", 
		"'binary'", "'<<'", "'>>'", "'escape'", "'*'", "')'", "'('", "']'", "'['", 
		"':'", "'.*'", "'='", "'<'", "'>'", "'!='", "'not'", "'<='", "'>='", "';'", 
		"','", "'.'", "'collate'", "'inner'", "'outer'", "'join'", "'cross'", 
		"'using'", "'index'", "'key'", "'order'", "'group'", "'by'", "'for'", 
		"'use'", "'ignore'", "'partition'", "'straight_join'", "'natural'", "'left'", 
		"'right'", "'oj'", "'on'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "FROM", "WHERE", "AND", "OR", "XOR", "IS", "NULL", "LIKE", 
		"IN", "EXISTS", "ALL", "ANY", "TRUE", "FALSE", "DIVIDE", "MOD", "BETWEEN", 
		"REGEXP", "PLUS", "MINUS", "NEGATION", "VERTBAR", "BITAND", "POWER_OP", 
		"BINARY", "SHIFT_LEFT", "SHIFT_RIGHT", "ESCAPE", "ASTERISK", "RPAREN", 
		"LPAREN", "RBRACK", "LBRACK", "COLON", "ALL_FIELDS", "EQ", "LTH", "GTH", 
		"NOT_EQ", "NOT", "LET", "GET", "SEMI", "COMMA", "DOT", "COLLATE", "INNER", 
		"OUTER", "JOIN", "CROSS", "USING", "INDEX", "KEY", "ORDER", "GROUP", "BY", 
		"FOR", "USE", "IGNORE", "PARTITION", "STRAIGHT_JOIN", "NATURAL", "LEFT", 
		"RIGHT", "OJ", "ON", "ID", "QUOTED_LITERAL", "INT", "NEWLINE", "WS", "USER_VAR"
	};
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


	public SQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SQLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2K\u0229\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5\u00b5\n\5"+
		"\3\6\3\6\3\6\3\6\5\6\u00bb\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00ef\n\21\3\22\3\22"+
		"\3\22\3\22\5\22\u00f5\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3"+
		"*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\3"+
		"8\38\38\38\38\39\39\39\39\39\39\3:\3:\3:\3;\3;\3;\3;\3<\3<\3<\3<\3=\3"+
		"=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3"+
		"?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3"+
		"B\3B\3B\3C\3C\3C\3D\3D\3D\3E\3E\3E\7E\u01cf\nE\fE\16E\u01d2\13E\3F\3F"+
		"\3F\3F\3F\3F\3F\3F\7F\u01dc\nF\fF\16F\u01df\13F\3F\3F\3F\3F\3F\3F\3F\3"+
		"F\3F\7F\u01ea\nF\fF\16F\u01ed\13F\3F\5F\u01f0\nF\3G\6G\u01f3\nG\rG\16"+
		"G\u01f4\3H\5H\u01f8\nH\3H\3H\3H\3H\3I\6I\u01ff\nI\rI\16I\u0200\3I\3I\3"+
		"J\3J\3J\3J\3J\5J\u020a\nJ\3K\3K\6K\u020e\nK\rK\16K\u020f\3K\3K\3L\3L\6"+
		"L\u0216\nL\rL\16L\u0217\3L\3L\3M\3M\6M\u021e\nM\rM\16M\u021f\3M\3M\3N"+
		"\3N\6N\u0226\nN\rN\16N\u0227\2\2O\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085"+
		"D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095\2\u0097\2\u0099"+
		"\2\u009b\2\3\2\b\5\2C\\aac|\3\2))\3\2$$\5\2\13\f\17\17\"\"\3\2bb\7\2&"+
		"&\62;C\\aac|\u023e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2"+
		"\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\3\u009d\3\2\2\2\5\u00a4\3\2\2\2\7\u00a9\3\2\2\2\t\u00b4\3\2\2\2\13"+
		"\u00ba\3\2\2\2\r\u00bc\3\2\2\2\17\u00c0\3\2\2\2\21\u00c3\3\2\2\2\23\u00c8"+
		"\3\2\2\2\25\u00cd\3\2\2\2\27\u00d0\3\2\2\2\31\u00d7\3\2\2\2\33\u00db\3"+
		"\2\2\2\35\u00df\3\2\2\2\37\u00e4\3\2\2\2!\u00ee\3\2\2\2#\u00f4\3\2\2\2"+
		"%\u00f6\3\2\2\2\'\u00fe\3\2\2\2)\u0105\3\2\2\2+\u0107\3\2\2\2-\u0109\3"+
		"\2\2\2/\u010b\3\2\2\2\61\u010d\3\2\2\2\63\u010f\3\2\2\2\65\u0111\3\2\2"+
		"\2\67\u0118\3\2\2\29\u011b\3\2\2\2;\u011e\3\2\2\2=\u0125\3\2\2\2?\u0127"+
		"\3\2\2\2A\u0129\3\2\2\2C\u012b\3\2\2\2E\u012d\3\2\2\2G\u012f\3\2\2\2I"+
		"\u0131\3\2\2\2K\u0134\3\2\2\2M\u0136\3\2\2\2O\u0138\3\2\2\2Q\u013a\3\2"+
		"\2\2S\u013d\3\2\2\2U\u0141\3\2\2\2W\u0144\3\2\2\2Y\u0147\3\2\2\2[\u0149"+
		"\3\2\2\2]\u014b\3\2\2\2_\u014d\3\2\2\2a\u0155\3\2\2\2c\u015b\3\2\2\2e"+
		"\u0161\3\2\2\2g\u0166\3\2\2\2i\u016c\3\2\2\2k\u0172\3\2\2\2m\u0178\3\2"+
		"\2\2o\u017c\3\2\2\2q\u0182\3\2\2\2s\u0188\3\2\2\2u\u018b\3\2\2\2w\u018f"+
		"\3\2\2\2y\u0193\3\2\2\2{\u019a\3\2\2\2}\u01a4\3\2\2\2\177\u01b2\3\2\2"+
		"\2\u0081\u01ba\3\2\2\2\u0083\u01bf\3\2\2\2\u0085\u01c5\3\2\2\2\u0087\u01c8"+
		"\3\2\2\2\u0089\u01cb\3\2\2\2\u008b\u01ef\3\2\2\2\u008d\u01f2\3\2\2\2\u008f"+
		"\u01f7\3\2\2\2\u0091\u01fe\3\2\2\2\u0093\u0204\3\2\2\2\u0095\u020b\3\2"+
		"\2\2\u0097\u0213\3\2\2\2\u0099\u021b\3\2\2\2\u009b\u0225\3\2\2\2\u009d"+
		"\u009e\7u\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7g\2\2"+
		"\u00a1\u00a2\7e\2\2\u00a2\u00a3\7v\2\2\u00a3\4\3\2\2\2\u00a4\u00a5\7h"+
		"\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7o\2\2\u00a8\6"+
		"\3\2\2\2\u00a9\u00aa\7y\2\2\u00aa\u00ab\7j\2\2\u00ab\u00ac\7g\2\2\u00ac"+
		"\u00ad\7t\2\2\u00ad\u00ae\7g\2\2\u00ae\b\3\2\2\2\u00af\u00b0\7c\2\2\u00b0"+
		"\u00b1\7p\2\2\u00b1\u00b5\7f\2\2\u00b2\u00b3\7(\2\2\u00b3\u00b5\7(\2\2"+
		"\u00b4\u00af\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\n\3\2\2\2\u00b6\u00b7\7"+
		"q\2\2\u00b7\u00bb\7t\2\2\u00b8\u00b9\7~\2\2\u00b9\u00bb\7~\2\2\u00ba\u00b6"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\f\3\2\2\2\u00bc\u00bd\7z\2\2\u00bd"+
		"\u00be\7q\2\2\u00be\u00bf\7t\2\2\u00bf\16\3\2\2\2\u00c0\u00c1\7k\2\2\u00c1"+
		"\u00c2\7u\2\2\u00c2\20\3\2\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5\7w\2\2\u00c5"+
		"\u00c6\7n\2\2\u00c6\u00c7\7n\2\2\u00c7\22\3\2\2\2\u00c8\u00c9\7n\2\2\u00c9"+
		"\u00ca\7k\2\2\u00ca\u00cb\7m\2\2\u00cb\u00cc\7g\2\2\u00cc\24\3\2\2\2\u00cd"+
		"\u00ce\7k\2\2\u00ce\u00cf\7p\2\2\u00cf\26\3\2\2\2\u00d0\u00d1\7g\2\2\u00d1"+
		"\u00d2\7z\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5\7v\2\2"+
		"\u00d5\u00d6\7u\2\2\u00d6\30\3\2\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9\7"+
		"n\2\2\u00d9\u00da\7n\2\2\u00da\32\3\2\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd"+
		"\7p\2\2\u00dd\u00de\7{\2\2\u00de\34\3\2\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1"+
		"\7t\2\2\u00e1\u00e2\7w\2\2\u00e2\u00e3\7g\2\2\u00e3\36\3\2\2\2\u00e4\u00e5"+
		"\7h\2\2\u00e5\u00e6\7c\2\2\u00e6\u00e7\7n\2\2\u00e7\u00e8\7u\2\2\u00e8"+
		"\u00e9\7g\2\2\u00e9 \3\2\2\2\u00ea\u00eb\7f\2\2\u00eb\u00ec\7k\2\2\u00ec"+
		"\u00ef\7x\2\2\u00ed\u00ef\7\61\2\2\u00ee\u00ea\3\2\2\2\u00ee\u00ed\3\2"+
		"\2\2\u00ef\"\3\2\2\2\u00f0\u00f1\7o\2\2\u00f1\u00f2\7q\2\2\u00f2\u00f5"+
		"\7f\2\2\u00f3\u00f5\7\'\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5"+
		"$\3\2\2\2\u00f6\u00f7\7d\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7v\2\2\u00f9"+
		"\u00fa\7y\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7g\2\2\u00fc\u00fd\7p\2\2"+
		"\u00fd&\3\2\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7g\2\2\u0100\u0101\7i\2"+
		"\2\u0101\u0102\7g\2\2\u0102\u0103\7z\2\2\u0103\u0104\7r\2\2\u0104(\3\2"+
		"\2\2\u0105\u0106\7-\2\2\u0106*\3\2\2\2\u0107\u0108\7/\2\2\u0108,\3\2\2"+
		"\2\u0109\u010a\7\u0080\2\2\u010a.\3\2\2\2\u010b\u010c\7~\2\2\u010c\60"+
		"\3\2\2\2\u010d\u010e\7(\2\2\u010e\62\3\2\2\2\u010f\u0110\7`\2\2\u0110"+
		"\64\3\2\2\2\u0111\u0112\7d\2\2\u0112\u0113\7k\2\2\u0113\u0114\7p\2\2\u0114"+
		"\u0115\7c\2\2\u0115\u0116\7t\2\2\u0116\u0117\7{\2\2\u0117\66\3\2\2\2\u0118"+
		"\u0119\7>\2\2\u0119\u011a\7>\2\2\u011a8\3\2\2\2\u011b\u011c\7@\2\2\u011c"+
		"\u011d\7@\2\2\u011d:\3\2\2\2\u011e\u011f\7g\2\2\u011f\u0120\7u\2\2\u0120"+
		"\u0121\7e\2\2\u0121\u0122\7c\2\2\u0122\u0123\7r\2\2\u0123\u0124\7g\2\2"+
		"\u0124<\3\2\2\2\u0125\u0126\7,\2\2\u0126>\3\2\2\2\u0127\u0128\7+\2\2\u0128"+
		"@\3\2\2\2\u0129\u012a\7*\2\2\u012aB\3\2\2\2\u012b\u012c\7_\2\2\u012cD"+
		"\3\2\2\2\u012d\u012e\7]\2\2\u012eF\3\2\2\2\u012f\u0130\7<\2\2\u0130H\3"+
		"\2\2\2\u0131\u0132\7\60\2\2\u0132\u0133\7,\2\2\u0133J\3\2\2\2\u0134\u0135"+
		"\7?\2\2\u0135L\3\2\2\2\u0136\u0137\7>\2\2\u0137N\3\2\2\2\u0138\u0139\7"+
		"@\2\2\u0139P\3\2\2\2\u013a\u013b\7#\2\2\u013b\u013c\7?\2\2\u013cR\3\2"+
		"\2\2\u013d\u013e\7p\2\2\u013e\u013f\7q\2\2\u013f\u0140\7v\2\2\u0140T\3"+
		"\2\2\2\u0141\u0142\7>\2\2\u0142\u0143\7?\2\2\u0143V\3\2\2\2\u0144\u0145"+
		"\7@\2\2\u0145\u0146\7?\2\2\u0146X\3\2\2\2\u0147\u0148\7=\2\2\u0148Z\3"+
		"\2\2\2\u0149\u014a\7.\2\2\u014a\\\3\2\2\2\u014b\u014c\7\60\2\2\u014c^"+
		"\3\2\2\2\u014d\u014e\7e\2\2\u014e\u014f\7q\2\2\u014f\u0150\7n\2\2\u0150"+
		"\u0151\7n\2\2\u0151\u0152\7c\2\2\u0152\u0153\7v\2\2\u0153\u0154\7g\2\2"+
		"\u0154`\3\2\2\2\u0155\u0156\7k\2\2\u0156\u0157\7p\2\2\u0157\u0158\7p\2"+
		"\2\u0158\u0159\7g\2\2\u0159\u015a\7t\2\2\u015ab\3\2\2\2\u015b\u015c\7"+
		"q\2\2\u015c\u015d\7w\2\2\u015d\u015e\7v\2\2\u015e\u015f\7g\2\2\u015f\u0160"+
		"\7t\2\2\u0160d\3\2\2\2\u0161\u0162\7l\2\2\u0162\u0163\7q\2\2\u0163\u0164"+
		"\7k\2\2\u0164\u0165\7p\2\2\u0165f\3\2\2\2\u0166\u0167\7e\2\2\u0167\u0168"+
		"\7t\2\2\u0168\u0169\7q\2\2\u0169\u016a\7u\2\2\u016a\u016b\7u\2\2\u016b"+
		"h\3\2\2\2\u016c\u016d\7w\2\2\u016d\u016e\7u\2\2\u016e\u016f\7k\2\2\u016f"+
		"\u0170\7p\2\2\u0170\u0171\7i\2\2\u0171j\3\2\2\2\u0172\u0173\7k\2\2\u0173"+
		"\u0174\7p\2\2\u0174\u0175\7f\2\2\u0175\u0176\7g\2\2\u0176\u0177\7z\2\2"+
		"\u0177l\3\2\2\2\u0178\u0179\7m\2\2\u0179\u017a\7g\2\2\u017a\u017b\7{\2"+
		"\2\u017bn\3\2\2\2\u017c\u017d\7q\2\2\u017d\u017e\7t\2\2\u017e\u017f\7"+
		"f\2\2\u017f\u0180\7g\2\2\u0180\u0181\7t\2\2\u0181p\3\2\2\2\u0182\u0183"+
		"\7i\2\2\u0183\u0184\7t\2\2\u0184\u0185\7q\2\2\u0185\u0186\7w\2\2\u0186"+
		"\u0187\7r\2\2\u0187r\3\2\2\2\u0188\u0189\7d\2\2\u0189\u018a\7{\2\2\u018a"+
		"t\3\2\2\2\u018b\u018c\7h\2\2\u018c\u018d\7q\2\2\u018d\u018e\7t\2\2\u018e"+
		"v\3\2\2\2\u018f\u0190\7w\2\2\u0190\u0191\7u\2\2\u0191\u0192\7g\2\2\u0192"+
		"x\3\2\2\2\u0193\u0194\7k\2\2\u0194\u0195\7i\2\2\u0195\u0196\7p\2\2\u0196"+
		"\u0197\7q\2\2\u0197\u0198\7t\2\2\u0198\u0199\7g\2\2\u0199z\3\2\2\2\u019a"+
		"\u019b\7r\2\2\u019b\u019c\7c\2\2\u019c\u019d\7t\2\2\u019d\u019e\7v\2\2"+
		"\u019e\u019f\7k\2\2\u019f\u01a0\7v\2\2\u01a0\u01a1\7k\2\2\u01a1\u01a2"+
		"\7q\2\2\u01a2\u01a3\7p\2\2\u01a3|\3\2\2\2\u01a4\u01a5\7u\2\2\u01a5\u01a6"+
		"\7v\2\2\u01a6\u01a7\7t\2\2\u01a7\u01a8\7c\2\2\u01a8\u01a9\7k\2\2\u01a9"+
		"\u01aa\7i\2\2\u01aa\u01ab\7j\2\2\u01ab\u01ac\7v\2\2\u01ac\u01ad\7a\2\2"+
		"\u01ad\u01ae\7l\2\2\u01ae\u01af\7q\2\2\u01af\u01b0\7k\2\2\u01b0\u01b1"+
		"\7p\2\2\u01b1~\3\2\2\2\u01b2\u01b3\7p\2\2\u01b3\u01b4\7c\2\2\u01b4\u01b5"+
		"\7v\2\2\u01b5\u01b6\7w\2\2\u01b6\u01b7\7t\2\2\u01b7\u01b8\7c\2\2\u01b8"+
		"\u01b9\7n\2\2\u01b9\u0080\3\2\2\2\u01ba\u01bb\7n\2\2\u01bb\u01bc\7g\2"+
		"\2\u01bc\u01bd\7h\2\2\u01bd\u01be\7v\2\2\u01be\u0082\3\2\2\2\u01bf\u01c0"+
		"\7t\2\2\u01c0\u01c1\7k\2\2\u01c1\u01c2\7i\2\2\u01c2\u01c3\7j\2\2\u01c3"+
		"\u01c4\7v\2\2\u01c4\u0084\3\2\2\2\u01c5\u01c6\7q\2\2\u01c6\u01c7\7l\2"+
		"\2\u01c7\u0086\3\2\2\2\u01c8\u01c9\7q\2\2\u01c9\u01ca\7p\2\2\u01ca\u0088"+
		"\3\2\2\2\u01cb\u01d0\t\2\2\2\u01cc\u01cf\t\2\2\2\u01cd\u01cf\5\u008dG"+
		"\2\u01ce\u01cc\3\2\2\2\u01ce\u01cd\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce"+
		"\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u008a\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3"+
		"\u01dd\7)\2\2\u01d4\u01d5\7^\2\2\u01d5\u01dc\7^\2\2\u01d6\u01d7\7)\2\2"+
		"\u01d7\u01dc\7)\2\2\u01d8\u01d9\7^\2\2\u01d9\u01dc\7)\2\2\u01da\u01dc"+
		"\n\3\2\2\u01db\u01d4\3\2\2\2\u01db\u01d6\3\2\2\2\u01db\u01d8\3\2\2\2\u01db"+
		"\u01da\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd\u01db\3\2\2\2\u01dd\u01de\3\2"+
		"\2\2\u01de\u01e0\3\2\2\2\u01df\u01dd\3\2\2\2\u01e0\u01f0\7)\2\2\u01e1"+
		"\u01eb\7$\2\2\u01e2\u01e3\7^\2\2\u01e3\u01ea\7^\2\2\u01e4\u01e5\7$\2\2"+
		"\u01e5\u01ea\7$\2\2\u01e6\u01e7\7^\2\2\u01e7\u01ea\7$\2\2\u01e8\u01ea"+
		"\n\4\2\2\u01e9\u01e2\3\2\2\2\u01e9\u01e4\3\2\2\2\u01e9\u01e6\3\2\2\2\u01e9"+
		"\u01e8\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb\u01ec\3\2"+
		"\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01f0\7$\2\2\u01ef"+
		"\u01d3\3\2\2\2\u01ef\u01e1\3\2\2\2\u01f0\u008c\3\2\2\2\u01f1\u01f3\4\62"+
		";\2\u01f2\u01f1\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4"+
		"\u01f5\3\2\2\2\u01f5\u008e\3\2\2\2\u01f6\u01f8\7\17\2\2\u01f7\u01f6\3"+
		"\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fa\7\f\2\2\u01fa"+
		"\u01fb\3\2\2\2\u01fb\u01fc\bH\2\2\u01fc\u0090\3\2\2\2\u01fd\u01ff\t\5"+
		"\2\2\u01fe\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u01fe\3\2\2\2\u0200"+
		"\u0201\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0203\bI\2\2\u0203\u0092\3\2"+
		"\2\2\u0204\u0209\7B\2\2\u0205\u020a\5\u0095K\2\u0206\u020a\5\u0097L\2"+
		"\u0207\u020a\5\u0099M\2\u0208\u020a\5\u009bN\2\u0209\u0205\3\2\2\2\u0209"+
		"\u0206\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u0208\3\2\2\2\u020a\u0094\3\2"+
		"\2\2\u020b\u020d\7b\2\2\u020c\u020e\n\6\2\2\u020d\u020c\3\2\2\2\u020e"+
		"\u020f\3\2\2\2\u020f\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0211\3\2"+
		"\2\2\u0211\u0212\7b\2\2\u0212\u0096\3\2\2\2\u0213\u0215\7)\2\2\u0214\u0216"+
		"\n\3\2\2\u0215\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0215\3\2\2\2\u0217"+
		"\u0218\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021a\7)\2\2\u021a\u0098\3\2"+
		"\2\2\u021b\u021d\7$\2\2\u021c\u021e\n\4\2\2\u021d\u021c\3\2\2\2\u021e"+
		"\u021f\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0221\3\2"+
		"\2\2\u0221\u0222\7$\2\2\u0222\u009a\3\2\2\2\u0223\u0226\t\7\2\2\u0224"+
		"\u0226\5]/\2\u0225\u0223\3\2\2\2\u0225\u0224\3\2\2\2\u0226\u0227\3\2\2"+
		"\2\u0227\u0225\3\2\2\2\u0227\u0228\3\2\2\2\u0228\u009c\3\2\2\2\27\2\u00b4"+
		"\u00ba\u00ee\u00f4\u01ce\u01d0\u01db\u01dd\u01e9\u01eb\u01ef\u01f4\u01f7"+
		"\u0200\u0209\u020f\u0217\u021f\u0225\u0227\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}