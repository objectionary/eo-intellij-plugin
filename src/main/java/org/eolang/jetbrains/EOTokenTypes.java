package org.eolang.jetbrains;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.List;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.intellij.adaptor.lexer.RuleIElementType;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.eolang.jetbrains.parser.EOLexer;
import org.eolang.jetbrains.parser.EOParser;
import org.intellij.lang.annotations.MagicConstant;

public class EOTokenTypes {
  public static IElementType BAD_TOKEN_TYPE = new IElementType("BAD_TOKEN", EOLanguage.INSTANCE);
  public static final List<TokenIElementType> TOKEN_ELEMENT_TYPES =
      PSIElementTypeFactory.getTokenIElementTypes(EOLanguage.INSTANCE);
  public static final List<RuleIElementType> RULE_ELEMENT_TYPES =
      PSIElementTypeFactory.getRuleIElementTypes(EOLanguage.INSTANCE);

  public static final TokenSet COMMENTS =
      PSIElementTypeFactory.createTokenSet(EOLanguage.INSTANCE, EOLexer.COMMENT);

  public static final TokenSet WHITESPACES =
      PSIElementTypeFactory.createTokenSet(EOLanguage.INSTANCE, EOLexer.SPACE);

  public static final TokenSet KEYWORDS =
      PSIElementTypeFactory.createTokenSet(EOLanguage.INSTANCE, EOLexer.NAME);
  public static final TokenSet NAMES =
      PSIElementTypeFactory.createTokenSet(EOLanguage.INSTANCE, EOLexer.NAME);

  public static RuleIElementType getRuleElementType(
      @MagicConstant(valuesFromClass = EOParser.class) int ruleIndex) {
    return RULE_ELEMENT_TYPES.get(ruleIndex);
  }

  public static TokenIElementType getTokenElementType(
      @MagicConstant(valuesFromClass = EOLexer.class) int ruleIndex) {
    return TOKEN_ELEMENT_TYPES.get(ruleIndex);
  }
}
