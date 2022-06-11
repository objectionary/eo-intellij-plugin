package org.eolang.jetbrains.parser;// Generated from /Users/stepan/huawei/EO-intellij-plugin/src/main/antlr/org/jetbrains/eolang/parser/EO.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class EOParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, META=2, REGEX=3, ROOT=4, HOME=5, STAR=6, DOTS=7, CONST=8, SLASH=9, 
		COLON=10, COPY=11, ARROW=12, VERTEX=13, SIGMA=14, XI=15, PLUS=16, MINUS=17, 
		QUESTION=18, SPACE=19, DOT=20, LSQ=21, RSQ=22, LB=23, RB=24, AT=25, RHO=26, 
		HASH=27, EOL=28, BYTES=29, BOOL=30, STRING=31, INT=32, FLOAT=33, HEX=34, 
		NAME=35, TEXT=36, BAD_CHARACTER=37, TAB=38, UNTAB=39;
	public static final int
		RULE_program = 0, RULE_license = 1, RULE_metas = 2, RULE_objects = 3, 
		RULE_object = 4, RULE_abstraction = 5, RULE_attributes = 6, RULE_attribute = 7, 
		RULE_label = 8, RULE_tail = 9, RULE_suffix = 10, RULE_method = 11, RULE_application = 12, 
		RULE_htail = 13, RULE_head = 14, RULE_has = 15, RULE_data = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "license", "metas", "objects", "object", "abstraction", "attributes", 
			"attribute", "label", "tail", "suffix", "method", "application", "htail", 
			"head", "has", "data"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'Q'", "'QQ'", "'*'", "'...'", "'!'", "'/'", 
			"':'", "'''", "'>'", "'<'", "'&'", "'$'", "'+'", "'-'", "'?'", "' '", 
			"'.'", "'['", "']'", "'('", "')'", "'@'", "'^'", "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "META", "REGEX", "ROOT", "HOME", "STAR", "DOTS", "CONST", 
			"SLASH", "COLON", "COPY", "ARROW", "VERTEX", "SIGMA", "XI", "PLUS", "MINUS", 
			"QUESTION", "SPACE", "DOT", "LSQ", "RSQ", "LB", "RB", "AT", "RHO", "HASH", 
			"EOL", "BYTES", "BOOL", "STRING", "INT", "FLOAT", "HEX", "NAME", "TEXT", 
			"BAD_CHARACTER", "TAB", "UNTAB"
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
	public String getGrammarFileName() { return "EO.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EOParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ObjectsContext objects() {
			return getRuleContext(ObjectsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(EOParser.EOF, 0); }
		public LicenseContext license() {
			return getRuleContext(LicenseContext.class,0);
		}
		public MetasContext metas() {
			return getRuleContext(MetasContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(34);
				license();
				}
				break;
			}
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==META) {
				{
				setState(37);
				metas();
				}
			}

			setState(40);
			objects();
			setState(41);
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

	public static class LicenseContext extends ParserRuleContext {
		public List<TerminalNode> COMMENT() { return getTokens(EOParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(EOParser.COMMENT, i);
		}
		public List<TerminalNode> EOL() { return getTokens(EOParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(EOParser.EOL, i);
		}
		public LicenseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_license; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterLicense(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitLicense(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitLicense(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LicenseContext license() throws RecognitionException {
		LicenseContext _localctx = new LicenseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_license);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(43);
					match(COMMENT);
					setState(44);
					match(EOL);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(47); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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

	public static class MetasContext extends ParserRuleContext {
		public List<TerminalNode> META() { return getTokens(EOParser.META); }
		public TerminalNode META(int i) {
			return getToken(EOParser.META, i);
		}
		public List<TerminalNode> EOL() { return getTokens(EOParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(EOParser.EOL, i);
		}
		public MetasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterMetas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitMetas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitMetas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetasContext metas() throws RecognitionException {
		MetasContext _localctx = new MetasContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_metas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49);
				match(META);
				setState(50);
				match(EOL);
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==META );
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

	public static class ObjectsContext extends ParserRuleContext {
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<TerminalNode> EOL() { return getTokens(EOParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(EOParser.EOL, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(EOParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(EOParser.COMMENT, i);
		}
		public ObjectsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objects; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterObjects(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitObjects(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitObjects(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectsContext objects() throws RecognitionException {
		ObjectsContext _localctx = new ObjectsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_objects);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(55);
						match(COMMENT);
						setState(56);
						match(EOL);
						}
						} 
					}
					setState(61);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(62);
				object();
				setState(63);
				match(EOL);
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << REGEX) | (1L << ROOT) | (1L << HOME) | (1L << STAR) | (1L << DOTS) | (1L << SIGMA) | (1L << XI) | (1L << LSQ) | (1L << LB) | (1L << AT) | (1L << RHO) | (1L << BYTES) | (1L << BOOL) | (1L << STRING) | (1L << INT) | (1L << FLOAT) | (1L << HEX) | (1L << NAME) | (1L << TEXT))) != 0) );
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

	public static class ObjectContext extends ParserRuleContext {
		public AbstractionContext abstraction() {
			return getRuleContext(AbstractionContext.class,0);
		}
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public List<TerminalNode> COMMENT() { return getTokens(EOParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(EOParser.COMMENT, i);
		}
		public List<TerminalNode> EOL() { return getTokens(EOParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(EOParser.EOL, i);
		}
		public List<TailContext> tail() {
			return getRuleContexts(TailContext.class);
		}
		public TailContext tail(int i) {
			return getRuleContext(TailContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<HtailContext> htail() {
			return getRuleContexts(HtailContext.class);
		}
		public HtailContext htail(int i) {
			return getRuleContext(HtailContext.class,i);
		}
		public List<SuffixContext> suffix() {
			return getRuleContexts(SuffixContext.class);
		}
		public SuffixContext suffix(int i) {
			return getRuleContext(SuffixContext.class,i);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_object);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(69);
				match(COMMENT);
				setState(70);
				match(EOL);
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(76);
				abstraction();
				}
				break;
			case 2:
				{
				setState(77);
				application(0);
				}
				break;
			}
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(80);
				tail();
				}
				break;
			}
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(83);
					match(EOL);
					setState(84);
					method();
					setState(86);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						setState(85);
						htail();
						}
						break;
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SPACE) {
						{
						setState(88);
						suffix();
						}
					}

					setState(92);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						setState(91);
						tail();
						}
						break;
					}
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class AbstractionContext extends ParserRuleContext {
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public HtailContext htail() {
			return getRuleContext(HtailContext.class,0);
		}
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(EOParser.SPACE, 0); }
		public TerminalNode SLASH() { return getToken(EOParser.SLASH, 0); }
		public TerminalNode NAME() { return getToken(EOParser.NAME, 0); }
		public TerminalNode QUESTION() { return getToken(EOParser.QUESTION, 0); }
		public AbstractionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstraction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterAbstraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitAbstraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitAbstraction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbstractionContext abstraction() throws RecognitionException {
		AbstractionContext _localctx = new AbstractionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_abstraction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			attributes();
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				{
				setState(100);
				suffix();
				setState(104);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(101);
					match(SPACE);
					setState(102);
					match(SLASH);
					setState(103);
					_la = _input.LA(1);
					if ( !(_la==QUESTION || _la==NAME) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				setState(106);
				htail();
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

	public static class AttributesContext extends ParserRuleContext {
		public TerminalNode LSQ() { return getToken(EOParser.LSQ, 0); }
		public TerminalNode RSQ() { return getToken(EOParser.RSQ, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> SPACE() { return getTokens(EOParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(EOParser.SPACE, i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(LSQ);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT || _la==NAME) {
				{
				setState(110);
				attribute();
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(111);
					match(SPACE);
					setState(112);
					attribute();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(120);
			match(RSQ);
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

	public static class AttributeContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			label();
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

	public static class LabelContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(EOParser.AT, 0); }
		public TerminalNode NAME() { return getToken(EOParser.NAME, 0); }
		public TerminalNode DOTS() { return getToken(EOParser.DOTS, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitLabel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_label);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(AT);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(NAME);
				setState(127);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(126);
					match(DOTS);
					}
					break;
				}
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

	public static class TailContext extends ParserRuleContext {
		public List<TerminalNode> EOL() { return getTokens(EOParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(EOParser.EOL, i);
		}
		public TerminalNode TAB() { return getToken(EOParser.TAB, 0); }
		public TerminalNode UNTAB() { return getToken(EOParser.UNTAB, 0); }
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public TailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TailContext tail() throws RecognitionException {
		TailContext _localctx = new TailContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(EOL);
			setState(132);
			match(TAB);
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				object();
				setState(134);
				match(EOL);
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << REGEX) | (1L << ROOT) | (1L << HOME) | (1L << STAR) | (1L << DOTS) | (1L << SIGMA) | (1L << XI) | (1L << LSQ) | (1L << LB) | (1L << AT) | (1L << RHO) | (1L << BYTES) | (1L << BOOL) | (1L << STRING) | (1L << INT) | (1L << FLOAT) | (1L << HEX) | (1L << NAME) | (1L << TEXT))) != 0) );
			setState(140);
			match(UNTAB);
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

	public static class SuffixContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(EOParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(EOParser.SPACE, i);
		}
		public TerminalNode ARROW() { return getToken(EOParser.ARROW, 0); }
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public TerminalNode CONST() { return getToken(EOParser.CONST, 0); }
		public SuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitSuffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuffixContext suffix() throws RecognitionException {
		SuffixContext _localctx = new SuffixContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_suffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(SPACE);
			setState(143);
			match(ARROW);
			setState(144);
			match(SPACE);
			setState(145);
			label();
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(146);
				match(CONST);
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

	public static class MethodContext extends ParserRuleContext {
		public Token mtd;
		public TerminalNode DOT() { return getToken(EOParser.DOT, 0); }
		public TerminalNode NAME() { return getToken(EOParser.NAME, 0); }
		public TerminalNode RHO() { return getToken(EOParser.RHO, 0); }
		public TerminalNode AT() { return getToken(EOParser.AT, 0); }
		public TerminalNode VERTEX() { return getToken(EOParser.VERTEX, 0); }
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(DOT);
			setState(150);
			((MethodContext)_localctx).mtd = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VERTEX) | (1L << AT) | (1L << RHO) | (1L << NAME))) != 0)) ) {
				((MethodContext)_localctx).mtd = (Token)_errHandler.recoverInline(this);
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

	public static class ApplicationContext extends ParserRuleContext {
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public HtailContext htail() {
			return getRuleContext(HtailContext.class,0);
		}
		public TerminalNode LB() { return getToken(EOParser.LB, 0); }
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public TerminalNode RB() { return getToken(EOParser.RB, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public HasContext has() {
			return getRuleContext(HasContext.class,0);
		}
		public SuffixContext suffix() {
			return getRuleContext(SuffixContext.class,0);
		}
		public ApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_application; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitApplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationContext application() throws RecognitionException {
		return application(0);
	}

	private ApplicationContext application(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ApplicationContext _localctx = new ApplicationContext(_ctx, _parentState);
		ApplicationContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_application, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REGEX:
			case ROOT:
			case HOME:
			case STAR:
			case DOTS:
			case SIGMA:
			case XI:
			case LSQ:
			case AT:
			case RHO:
			case BYTES:
			case BOOL:
			case STRING:
			case INT:
			case FLOAT:
			case HEX:
			case NAME:
			case TEXT:
				{
				setState(153);
				head();
				setState(155);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(154);
					htail();
					}
					break;
				}
				}
				break;
			case LB:
				{
				setState(157);
				match(LB);
				setState(158);
				application(0);
				setState(159);
				match(RB);
				setState(161);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(160);
					htail();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(180);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new ApplicationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_application);
						setState(165);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(166);
						method();
						setState(168);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
						case 1:
							{
							setState(167);
							htail();
							}
							break;
						}
						}
						break;
					case 2:
						{
						_localctx = new ApplicationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_application);
						setState(170);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(171);
						has();
						setState(173);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
						case 1:
							{
							setState(172);
							htail();
							}
							break;
						}
						}
						break;
					case 3:
						{
						_localctx = new ApplicationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_application);
						setState(175);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(176);
						suffix();
						setState(178);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
						case 1:
							{
							setState(177);
							htail();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class HtailContext extends ParserRuleContext {
		public List<TerminalNode> SPACE() { return getTokens(EOParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(EOParser.SPACE, i);
		}
		public List<HeadContext> head() {
			return getRuleContexts(HeadContext.class);
		}
		public HeadContext head(int i) {
			return getRuleContext(HeadContext.class,i);
		}
		public List<ApplicationContext> application() {
			return getRuleContexts(ApplicationContext.class);
		}
		public ApplicationContext application(int i) {
			return getRuleContext(ApplicationContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<TerminalNode> LB() { return getTokens(EOParser.LB); }
		public TerminalNode LB(int i) {
			return getToken(EOParser.LB, i);
		}
		public List<TerminalNode> RB() { return getTokens(EOParser.RB); }
		public TerminalNode RB(int i) {
			return getToken(EOParser.RB, i);
		}
		public List<HasContext> has() {
			return getRuleContexts(HasContext.class);
		}
		public HasContext has(int i) {
			return getRuleContext(HasContext.class,i);
		}
		public List<SuffixContext> suffix() {
			return getRuleContexts(SuffixContext.class);
		}
		public SuffixContext suffix(int i) {
			return getRuleContext(SuffixContext.class,i);
		}
		public List<AbstractionContext> abstraction() {
			return getRuleContexts(AbstractionContext.class);
		}
		public AbstractionContext abstraction(int i) {
			return getRuleContext(AbstractionContext.class,i);
		}
		public HtailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterHtail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitHtail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitHtail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtailContext htail() throws RecognitionException {
		HtailContext _localctx = new HtailContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_htail);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(206);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						setState(185);
						match(SPACE);
						setState(186);
						head();
						}
						break;
					case 2:
						{
						setState(187);
						match(SPACE);
						setState(188);
						application(0);
						setState(189);
						method();
						}
						break;
					case 3:
						{
						setState(191);
						match(SPACE);
						setState(192);
						match(LB);
						setState(193);
						application(0);
						setState(194);
						match(RB);
						}
						break;
					case 4:
						{
						setState(196);
						match(SPACE);
						setState(197);
						application(0);
						setState(198);
						has();
						}
						break;
					case 5:
						{
						setState(200);
						match(SPACE);
						setState(201);
						application(0);
						setState(202);
						suffix();
						}
						break;
					case 6:
						{
						setState(204);
						match(SPACE);
						setState(205);
						abstraction();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(208); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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

	public static class HeadContext extends ParserRuleContext {
		public TerminalNode ROOT() { return getToken(EOParser.ROOT, 0); }
		public TerminalNode HOME() { return getToken(EOParser.HOME, 0); }
		public TerminalNode AT() { return getToken(EOParser.AT, 0); }
		public TerminalNode RHO() { return getToken(EOParser.RHO, 0); }
		public TerminalNode XI() { return getToken(EOParser.XI, 0); }
		public TerminalNode SIGMA() { return getToken(EOParser.SIGMA, 0); }
		public TerminalNode STAR() { return getToken(EOParser.STAR, 0); }
		public TerminalNode NAME() { return getToken(EOParser.NAME, 0); }
		public TerminalNode DOT() { return getToken(EOParser.DOT, 0); }
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public AbstractionContext abstraction() {
			return getRuleContext(AbstractionContext.class,0);
		}
		public TerminalNode DOTS() { return getToken(EOParser.DOTS, 0); }
		public TerminalNode COPY() { return getToken(EOParser.COPY, 0); }
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOTS) {
				{
				setState(210);
				match(DOTS);
				}
			}

			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(213);
				match(ROOT);
				}
				break;
			case 2:
				{
				setState(214);
				match(HOME);
				}
				break;
			case 3:
				{
				setState(215);
				match(AT);
				}
				break;
			case 4:
				{
				setState(216);
				match(RHO);
				}
				break;
			case 5:
				{
				setState(217);
				match(XI);
				}
				break;
			case 6:
				{
				setState(218);
				match(SIGMA);
				}
				break;
			case 7:
				{
				setState(219);
				match(STAR);
				}
				break;
			case 8:
				{
				setState(220);
				match(NAME);
				setState(222);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(221);
					match(COPY);
					}
					break;
				}
				}
				break;
			case 9:
				{
				setState(224);
				match(NAME);
				setState(225);
				match(DOT);
				}
				break;
			case 10:
				{
				setState(226);
				data();
				}
				break;
			case 11:
				{
				setState(227);
				abstraction();
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

	public static class HasContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(EOParser.COLON, 0); }
		public TerminalNode NAME() { return getToken(EOParser.NAME, 0); }
		public HasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_has; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterHas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitHas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitHas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HasContext has() throws RecognitionException {
		HasContext _localctx = new HasContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_has);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(COLON);
			setState(231);
			match(NAME);
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

	public static class DataContext extends ParserRuleContext {
		public TerminalNode BYTES() { return getToken(EOParser.BYTES, 0); }
		public TerminalNode BOOL() { return getToken(EOParser.BOOL, 0); }
		public TerminalNode TEXT() { return getToken(EOParser.TEXT, 0); }
		public TerminalNode STRING() { return getToken(EOParser.STRING, 0); }
		public TerminalNode INT() { return getToken(EOParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(EOParser.FLOAT, 0); }
		public TerminalNode HEX() { return getToken(EOParser.HEX, 0); }
		public TerminalNode REGEX() { return getToken(EOParser.REGEX, 0); }
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EOListener) ((EOListener)listener).exitData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EOVisitor) return ((EOVisitor<? extends T>)visitor).visitData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << REGEX) | (1L << BYTES) | (1L << BOOL) | (1L << STRING) | (1L << INT) | (1L << FLOAT) | (1L << HEX) | (1L << TEXT))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return application_sempred((ApplicationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean application_sempred(ApplicationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\'\u00ec\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0003\u0000$\b\u0000\u0001\u0000"+
		"\u0003\u0000\'\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0004\u0001.\b\u0001\u000b\u0001\f\u0001/\u0001\u0002\u0001"+
		"\u0002\u0004\u00024\b\u0002\u000b\u0002\f\u00025\u0001\u0003\u0001\u0003"+
		"\u0005\u0003:\b\u0003\n\u0003\f\u0003=\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0004\u0003B\b\u0003\u000b\u0003\f\u0003C\u0001\u0004\u0001"+
		"\u0004\u0005\u0004H\b\u0004\n\u0004\f\u0004K\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004O\b\u0004\u0001\u0004\u0003\u0004R\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004W\b\u0004\u0001\u0004\u0003\u0004"+
		"Z\b\u0004\u0001\u0004\u0003\u0004]\b\u0004\u0005\u0004_\b\u0004\n\u0004"+
		"\f\u0004b\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005i\b\u0005\u0001\u0005\u0003\u0005l\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006r\b\u0006\n\u0006\f\u0006"+
		"u\t\u0006\u0003\u0006w\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u0080\b\b\u0003\b\u0082\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u0089\b\t\u000b\t\f\t\u008a"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0094"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u009c\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00a2\b\f\u0003\f"+
		"\u00a4\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u00a9\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00ae\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u00b3\b\f\u0005\f"+
		"\u00b5\b\f\n\f\f\f\u00b8\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u00cf\b\r\u000b"+
		"\r\f\r\u00d0\u0001\u000e\u0003\u000e\u00d4\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00df\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00e5\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0001\u0018\u0011\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \u0000\u0003\u0002\u0000\u0012\u0012##\u0003\u0000\r\r\u0019\u001a##"+
		"\u0003\u0000\u0003\u0003\u001d\"$$\u010b\u0000#\u0001\u0000\u0000\u0000"+
		"\u0002-\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u0006A"+
		"\u0001\u0000\u0000\u0000\bI\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000"+
		"\u0000\fm\u0001\u0000\u0000\u0000\u000ez\u0001\u0000\u0000\u0000\u0010"+
		"\u0081\u0001\u0000\u0000\u0000\u0012\u0083\u0001\u0000\u0000\u0000\u0014"+
		"\u008e\u0001\u0000\u0000\u0000\u0016\u0095\u0001\u0000\u0000\u0000\u0018"+
		"\u00a3\u0001\u0000\u0000\u0000\u001a\u00ce\u0001\u0000\u0000\u0000\u001c"+
		"\u00d3\u0001\u0000\u0000\u0000\u001e\u00e6\u0001\u0000\u0000\u0000 \u00e9"+
		"\u0001\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000\u0000%\'\u0003\u0004"+
		"\u0002\u0000&%\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000()\u0003\u0006\u0003\u0000)*\u0005\u0000\u0000\u0001"+
		"*\u0001\u0001\u0000\u0000\u0000+,\u0005\u0001\u0000\u0000,.\u0005\u001c"+
		"\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/-\u0001"+
		"\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000\u0003\u0001\u0000\u0000"+
		"\u000012\u0005\u0002\u0000\u000024\u0005\u001c\u0000\u000031\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u00006\u0005\u0001\u0000\u0000\u000078\u0005\u0001\u0000"+
		"\u00008:\u0005\u001c\u0000\u000097\u0001\u0000\u0000\u0000:=\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0003\b\u0004\u0000?@\u0005"+
		"\u001c\u0000\u0000@B\u0001\u0000\u0000\u0000A;\u0001\u0000\u0000\u0000"+
		"BC\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000D\u0007\u0001\u0000\u0000\u0000EF\u0005\u0001\u0000\u0000FH\u0005"+
		"\u001c\u0000\u0000GE\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JN\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000LO\u0003\n\u0005\u0000MO\u0003\u0018\f"+
		"\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000OQ\u0001\u0000"+
		"\u0000\u0000PR\u0003\u0012\t\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000R`\u0001\u0000\u0000\u0000ST\u0005\u001c\u0000\u0000TV\u0003"+
		"\u0016\u000b\u0000UW\u0003\u001a\r\u0000VU\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000WY\u0001\u0000\u0000\u0000XZ\u0003\u0014\n\u0000YX\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000"+
		"[]\u0003\u0012\t\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000"+
		"\u0000]_\u0001\u0000\u0000\u0000^S\u0001\u0000\u0000\u0000_b\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\t\u0001"+
		"\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000ck\u0003\f\u0006\u0000dh\u0003"+
		"\u0014\n\u0000ef\u0005\u0013\u0000\u0000fg\u0005\t\u0000\u0000gi\u0007"+
		"\u0000\u0000\u0000he\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000"+
		"il\u0001\u0000\u0000\u0000jl\u0003\u001a\r\u0000kd\u0001\u0000\u0000\u0000"+
		"kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000l\u000b\u0001\u0000"+
		"\u0000\u0000mv\u0005\u0015\u0000\u0000ns\u0003\u000e\u0007\u0000op\u0005"+
		"\u0013\u0000\u0000pr\u0003\u000e\u0007\u0000qo\u0001\u0000\u0000\u0000"+
		"ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vn\u0001\u0000"+
		"\u0000\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0005"+
		"\u0016\u0000\u0000y\r\u0001\u0000\u0000\u0000z{\u0003\u0010\b\u0000{\u000f"+
		"\u0001\u0000\u0000\u0000|\u0082\u0005\u0019\u0000\u0000}\u007f\u0005#"+
		"\u0000\u0000~\u0080\u0005\u0007\u0000\u0000\u007f~\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000"+
		"\u0081|\u0001\u0000\u0000\u0000\u0081}\u0001\u0000\u0000\u0000\u0082\u0011"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u001c\u0000\u0000\u0084\u0088"+
		"\u0005&\u0000\u0000\u0085\u0086\u0003\b\u0004\u0000\u0086\u0087\u0005"+
		"\u001c\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0085\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0005\'\u0000\u0000\u008d\u0013\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0005\u0013\u0000\u0000\u008f\u0090\u0005\f\u0000"+
		"\u0000\u0090\u0091\u0005\u0013\u0000\u0000\u0091\u0093\u0003\u0010\b\u0000"+
		"\u0092\u0094\u0005\b\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0001\u0000\u0000\u0000\u0094\u0015\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0005\u0014\u0000\u0000\u0096\u0097\u0007\u0001\u0000\u0000\u0097"+
		"\u0017\u0001\u0000\u0000\u0000\u0098\u0099\u0006\f\uffff\uffff\u0000\u0099"+
		"\u009b\u0003\u001c\u000e\u0000\u009a\u009c\u0003\u001a\r\u0000\u009b\u009a"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u00a4"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u0017\u0000\u0000\u009e\u009f"+
		"\u0003\u0018\f\u0000\u009f\u00a1\u0005\u0018\u0000\u0000\u00a0\u00a2\u0003"+
		"\u001a\r\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u0098\u0001\u0000"+
		"\u0000\u0000\u00a3\u009d\u0001\u0000\u0000\u0000\u00a4\u00b6\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\n\u0004\u0000\u0000\u00a6\u00a8\u0003\u0016\u000b"+
		"\u0000\u00a7\u00a9\u0003\u001a\r\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00b5\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\n\u0002\u0000\u0000\u00ab\u00ad\u0003\u001e\u000f\u0000\u00ac"+
		"\u00ae\u0003\u001a\r\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b5\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\n\u0001\u0000\u0000\u00b0\u00b2\u0003\u0014\n\u0000\u00b1\u00b3\u0003"+
		"\u001a\r\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4\u00a5\u0001\u0000"+
		"\u0000\u0000\u00b4\u00aa\u0001\u0000\u0000\u0000\u00b4\u00af\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u0019\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u0013"+
		"\u0000\u0000\u00ba\u00cf\u0003\u001c\u000e\u0000\u00bb\u00bc\u0005\u0013"+
		"\u0000\u0000\u00bc\u00bd\u0003\u0018\f\u0000\u00bd\u00be\u0003\u0016\u000b"+
		"\u0000\u00be\u00cf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u0013\u0000"+
		"\u0000\u00c0\u00c1\u0005\u0017\u0000\u0000\u00c1\u00c2\u0003\u0018\f\u0000"+
		"\u00c2\u00c3\u0005\u0018\u0000\u0000\u00c3\u00cf\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0005\u0013\u0000\u0000\u00c5\u00c6\u0003\u0018\f\u0000\u00c6"+
		"\u00c7\u0003\u001e\u000f\u0000\u00c7\u00cf\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0005\u0013\u0000\u0000\u00c9\u00ca\u0003\u0018\f\u0000\u00ca\u00cb"+
		"\u0003\u0014\n\u0000\u00cb\u00cf\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005"+
		"\u0013\u0000\u0000\u00cd\u00cf\u0003\n\u0005\u0000\u00ce\u00b9\u0001\u0000"+
		"\u0000\u0000\u00ce\u00bb\u0001\u0000\u0000\u0000\u00ce\u00bf\u0001\u0000"+
		"\u0000\u0000\u00ce\u00c4\u0001\u0000\u0000\u0000\u00ce\u00c8\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d1\u001b\u0001\u0000\u0000\u0000\u00d2\u00d4\u0005\u0007"+
		"\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d4\u00e4\u0001\u0000\u0000\u0000\u00d5\u00e5\u0005\u0004"+
		"\u0000\u0000\u00d6\u00e5\u0005\u0005\u0000\u0000\u00d7\u00e5\u0005\u0019"+
		"\u0000\u0000\u00d8\u00e5\u0005\u001a\u0000\u0000\u00d9\u00e5\u0005\u000f"+
		"\u0000\u0000\u00da\u00e5\u0005\u000e\u0000\u0000\u00db\u00e5\u0005\u0006"+
		"\u0000\u0000\u00dc\u00de\u0005#\u0000\u0000\u00dd\u00df\u0005\u000b\u0000"+
		"\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000"+
		"\u0000\u00df\u00e5\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005#\u0000\u0000"+
		"\u00e1\u00e5\u0005\u0014\u0000\u0000\u00e2\u00e5\u0003 \u0010\u0000\u00e3"+
		"\u00e5\u0003\n\u0005\u0000\u00e4\u00d5\u0001\u0000\u0000\u0000\u00e4\u00d6"+
		"\u0001\u0000\u0000\u0000\u00e4\u00d7\u0001\u0000\u0000\u0000\u00e4\u00d8"+
		"\u0001\u0000\u0000\u0000\u00e4\u00d9\u0001\u0000\u0000\u0000\u00e4\u00da"+
		"\u0001\u0000\u0000\u0000\u00e4\u00db\u0001\u0000\u0000\u0000\u00e4\u00dc"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e0\u0001\u0000\u0000\u0000\u00e4\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5\u001d"+
		"\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\n\u0000\u0000\u00e7\u00e8\u0005"+
		"#\u0000\u0000\u00e8\u001f\u0001\u0000\u0000\u0000\u00e9\u00ea\u0007\u0002"+
		"\u0000\u0000\u00ea!\u0001\u0000\u0000\u0000\"#&/5;CINQVY\\`hksv\u007f"+
		"\u0081\u008a\u0093\u009b\u00a1\u00a3\u00a8\u00ad\u00b2\u00b4\u00b6\u00ce"+
		"\u00d0\u00d3\u00de\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}