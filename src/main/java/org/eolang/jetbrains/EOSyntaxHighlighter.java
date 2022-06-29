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
  public static final TextAttributesKey NUMBERS =
      createTextAttributesKey("EO_INT", DefaultLanguageHighlighterColors.CONSTANT);
  public static final TextAttributesKey COMMENT =
      createTextAttributesKey("EO_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey META =
      createTextAttributesKey("EO_META", DefaultLanguageHighlighterColors.METADATA);
  public static final TextAttributesKey KEYWORD =
      createTextAttributesKey("EO_STAR", DefaultLanguageHighlighterColors.KEYWORD);
  public static final TextAttributesKey SPACE =
      createTextAttributesKey("EO_SPACE", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);
  public static final TextAttributesKey DOT =
      createTextAttributesKey("EO_DOT", DefaultLanguageHighlighterColors.DOT);
  public static final TextAttributesKey BRACES =
      createTextAttributesKey("EO_LSQ", DefaultLanguageHighlighterColors.BRACES);
  public static final TextAttributesKey HASH =
      createTextAttributesKey("EO_HASH", DefaultLanguageHighlighterColors.LINE_COMMENT);
  public static final TextAttributesKey EOL =
      createTextAttributesKey("EO_EOL", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);
  public static final TextAttributesKey STRING =
      createTextAttributesKey("EO_STRING", DefaultLanguageHighlighterColors.STRING);
  public static final TextAttributesKey NAME =
      createTextAttributesKey("EO_NAME", DefaultLanguageHighlighterColors.IDENTIFIER);
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
      case EOLexer.SLASH:
      case EOLexer.CONST:
      case EOLexer.DOTS:
      case EOLexer.COLON:
      case EOLexer.COPY:
      case EOLexer.ARROW:
      case EOLexer.VERTEX:
      case EOLexer.SIGMA:
      case EOLexer.XI:
      case EOLexer.PLUS:
      case EOLexer.MINUS:
      case EOLexer.QUESTION:
      case EOLexer.STAR:
        attrKey = KEYWORD;
        break;
      case EOLexer.BOOL:
      case EOLexer.INT:
      case EOLexer.FLOAT:
      case EOLexer.HEX:
      case EOLexer.BYTES:
        attrKey = NUMBERS;
        break;
      case EOLexer.LSQ:
      case EOLexer.RSQ:
      case EOLexer.LB:
      case EOLexer.RB:
        attrKey = BRACES;
        break;
      case EOLexer.STRING:
      case EOLexer.TEXT:
        attrKey = STRING;
        break;
      case EOLexer.SPACE:
        attrKey = SPACE;
        break;
      case EOLexer.DOT:
        attrKey = DOT;
        break;
      case EOLexer.COMMENT:
        attrKey = COMMENT;
        break;
      case EOLexer.HASH:
        attrKey = HASH;
        break;
      case EOLexer.EOL:
        attrKey = EOL;
        break;
      case EOLexer.NAME:
        attrKey = NAME;
        break;
      case EOLexer.META:
        attrKey = META;
        break;
      case EOLexer.BAD_CHARACTER:
        attrKey = BAD_CHARACTER;
        break;
      default:
        return EMPTY_KEYS;
    }
    return new TextAttributesKey[] {attrKey};
  }
}
