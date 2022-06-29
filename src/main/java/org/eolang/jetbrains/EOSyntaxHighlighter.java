package org.eolang.jetbrains;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.eolang.jetbrains.parser.EOLexer;
import org.jetbrains.annotations.NotNull;

public class EOSyntaxHighlighter extends SyntaxHighlighterBase {
  public static final TextAttributesKey INT =
      createTextAttributesKey("EO_INT", DefaultLanguageHighlighterColors.CONSTANT);
  public static final TextAttributesKey COMMENT =
      createTextAttributesKey("EO_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey BOOL =
      createTextAttributesKey("EO_BOOL", DefaultLanguageHighlighterColors.CONSTANT);
  public static final TextAttributesKey META =
      createTextAttributesKey("EO_META", DefaultLanguageHighlighterColors.METADATA);
  public static final TextAttributesKey STAR =
      createTextAttributesKey("EO_STAR", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey DOTS =
      createTextAttributesKey("EO_DOTS", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey CONST =
      createTextAttributesKey("EO_CONST", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey SLASH =
      createTextAttributesKey("EO_SLASH", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey COLON =
      createTextAttributesKey("EO_COLON", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey COPY =
      createTextAttributesKey("EO_COPY", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey ARROW =
      createTextAttributesKey("EO_ARROW", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey VERTEX =
      createTextAttributesKey("EO_VERTEX", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey SIGMA =
      createTextAttributesKey("EO_SIGMA", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey XI =
      createTextAttributesKey("EO_XI", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey PLUS =
      createTextAttributesKey("EO_PLUS", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey MINUS =
      createTextAttributesKey("EO_MINUS", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey QUESTION =
      createTextAttributesKey("EO_QUESTION", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey SPACE =
      createTextAttributesKey("EO_SPACE", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);
  public static final TextAttributesKey DOT =
      createTextAttributesKey("EO_DOT", DefaultLanguageHighlighterColors.DOT);
  public static final TextAttributesKey LSQ =
      createTextAttributesKey("EO_LSQ", DefaultLanguageHighlighterColors.BRACES);
  public static final TextAttributesKey RSQ =
      createTextAttributesKey("EO_RSQ", DefaultLanguageHighlighterColors.BRACES);
  public static final TextAttributesKey LB =
      createTextAttributesKey("EO_RB", DefaultLanguageHighlighterColors.BRACES);
  public static final TextAttributesKey RB =
      createTextAttributesKey("EO_RB", DefaultLanguageHighlighterColors.BRACES);
  public static final TextAttributesKey AT =
      createTextAttributesKey("EO_AT", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey RHO =
      createTextAttributesKey("EO_RHO", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey HASH =
      createTextAttributesKey("EO_HASH", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey EOL =
      createTextAttributesKey("EO_EOL", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);
  public static final TextAttributesKey BYTES =
      createTextAttributesKey("EO_BYTES", DefaultLanguageHighlighterColors.CONSTANT);
  public static final TextAttributesKey STRING =
      createTextAttributesKey("EO_STRING", DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey FLOAT =
      createTextAttributesKey("EO_FLOAT", DefaultLanguageHighlighterColors.CONSTANT);
  public static final TextAttributesKey HEX =
      createTextAttributesKey("EO_HEX", DefaultLanguageHighlighterColors.CONSTANT);
  public static final TextAttributesKey NAME =
      createTextAttributesKey("EO_NAME", DefaultLanguageHighlighterColors.IDENTIFIER);
  public static final TextAttributesKey TEXT =
      createTextAttributesKey("EO_TEXT", DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey BAD_CHARACTER =
      createTextAttributesKey("EO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

  private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

  @NotNull
  @Override
  public Lexer getHighlightingLexer() {
    EOLexer lexer = new EOLexer(null);
    return new ANTLRLexerAdaptor(EOLanguage.INSTANCE, lexer);
  }

  @Override
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
    if (!(tokenType instanceof TokenIElementType)) return EMPTY_KEYS;
    TokenIElementType myType = (TokenIElementType) tokenType;
    int ttype = myType.getANTLRTokenType();
    TextAttributesKey attrKey;
    switch (ttype) {
      case EOLexer.BOOL:
        attrKey = BOOL;
        break;
      case EOLexer.COMMENT:
        attrKey = COMMENT;
        break;
      case EOLexer.INT:
        attrKey = INT;
        break;
      case EOLexer.STAR:
        attrKey = STAR;
        break;
      case EOLexer.DOTS:
        attrKey = DOTS;
        break;
      case EOLexer.CONST:
        attrKey = CONST;
        break;
      case EOLexer.SLASH:
        attrKey = SLASH;
        break;
      case EOLexer.COLON:
        attrKey = COLON;
        break;
      case EOLexer.COPY:
        attrKey = COPY;
        break;
      case EOLexer.ARROW:
        attrKey = ARROW;
        break;
      case EOLexer.VERTEX:
        attrKey = VERTEX;
        break;
      case EOLexer.SIGMA:
        attrKey = SIGMA;
        break;
      case EOLexer.XI:
        attrKey = XI;
        break;
      case EOLexer.PLUS:
        attrKey = PLUS;
        break;
      case EOLexer.MINUS:
        attrKey = MINUS;
        break;
      case EOLexer.QUESTION:
        attrKey = QUESTION;
        break;
      case EOLexer.SPACE:
        attrKey = SPACE;
        break;
      case EOLexer.DOT:
        attrKey = DOT;
        break;
      case EOLexer.LSQ:
        attrKey = LSQ;
        break;
      case EOLexer.RSQ:
        attrKey = RSQ;
        break;
      case EOLexer.LB:
        attrKey = LB;
        break;
      case EOLexer.RB:
        attrKey = RB;
        break;
      case EOLexer.AT:
        attrKey = AT;
        break;
      case EOLexer.RHO:
        attrKey = RHO;
        break;
      case EOLexer.HASH:
        attrKey = HASH;
        break;
      case EOLexer.EOL:
        attrKey = EOL;
        break;
      case EOLexer.BYTES:
        attrKey = BYTES;
        break;
      case EOLexer.STRING:
        attrKey = STRING;
        break;
      case EOLexer.FLOAT:
        attrKey = FLOAT;
        break;
      case EOLexer.HEX:
        attrKey = HEX;
        break;
      case EOLexer.NAME:
        attrKey = NAME;
        break;
      case EOLexer.TEXT:
        attrKey = TEXT;
        break;
      case EOLexer.META:
        attrKey = META;
        break;
      default:
        return EMPTY_KEYS;
    }
    return new TextAttributesKey[] {attrKey};
  }
}
