/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021-2022 Stepan Strunkov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.eolang.jetbrains;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.eolang.jetbrains.parser.EOLexer;
import org.jetbrains.annotations.NotNull;

/**
 * Class for declaration groups of tokens and highlighting colors.
 * We will highlight all tokens with one of colors below. One group - one color.
 * @since 0.0.0
 * @checkstyle LocalFinalVariableNameCheck (100 lines), CyclomaticComplexity (150 lines)
 * @checkstyle CyclomaticComplexity (150 lines)
 * @checkstyle NcssCount (150 lines)
 */
public class EoSyntaxHighlighter extends SyntaxHighlighterBase {
    /**
     * Code below is description of token groups.
     */
    public static final TextAttributesKey NUMBERS =
        createTextAttributesKey("EO_INT", DefaultLanguageHighlighterColors.CONSTANT);

    /**
     * Define comments.
     */
    public static final TextAttributesKey COMMENT =
        createTextAttributesKey("EO_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    /**
     * Define metas.
     */
    public static final TextAttributesKey META =
        createTextAttributesKey("EO_META", DefaultLanguageHighlighterColors.METADATA);

    /**
     * Define keyword.
     */
    public static final TextAttributesKey KEYWORD =
        createTextAttributesKey("EO_STAR", DefaultLanguageHighlighterColors.KEYWORD);

    /**
     * Define space.
     */
    public static final TextAttributesKey SPACE =
        createTextAttributesKey(
            "EO_SPACE",
            DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR
        );

    /**
     * Define dot.
     */
    public static final TextAttributesKey DOT =
        createTextAttributesKey("EO_DOT", DefaultLanguageHighlighterColors.DOT);

    /**
     * Define braces.
     */
    public static final TextAttributesKey BRACES =
        createTextAttributesKey("EO_LSQ", DefaultLanguageHighlighterColors.BRACES);

    /**
     * Define hash.
     */
    public static final TextAttributesKey HASH =
        createTextAttributesKey("EO_HASH", DefaultLanguageHighlighterColors.LINE_COMMENT);

    /**
     * Define EOL.
     */
    public static final TextAttributesKey EOL =
        createTextAttributesKey("EO_EOL", DefaultLanguageHighlighterColors.TEMPLATE_LANGUAGE_COLOR);

    /**
     * Define string.
     */
    public static final TextAttributesKey STRING =
        createTextAttributesKey("EO_STRING", DefaultLanguageHighlighterColors.STRING);

    /**
     * Define name.
     */
    public static final TextAttributesKey NAME =
        createTextAttributesKey("EO_NAME", DefaultLanguageHighlighterColors.IDENTIFIER);

    /**
     * Define bad symbol.
     */
    public static final TextAttributesKey BAD_CHARACTER =
        createTextAttributesKey("EO_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    /**
     * Define empty key.
     */
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public final Lexer getHighlightingLexer() {
        final EOLexer lexer = new EOLexer(null);
        return new ANTLRLexerAdaptor(EoLanguage.INSTANCE, lexer);
    }

    // @checkstyle CyclomaticComplexity (100 lines)
    @Override
    public final TextAttributesKey[] getTokenHighlights(final IElementType tokentype) {
        if (!(tokentype instanceof TokenIElementType)) {
            return EoSyntaxHighlighter.EMPTY_KEYS;
        }
        final TokenIElementType myType = (TokenIElementType) tokentype;
        final int ttype = myType.getANTLRTokenType();
        final TextAttributesKey attrKey;
        switch (ttype) {
            case EOLexer.LSQ:
            case EOLexer.RSQ:
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
                attrKey = EoSyntaxHighlighter.KEYWORD;
                break;
            case EOLexer.BOOL:
            case EOLexer.INT:
            case EOLexer.FLOAT:
            case EOLexer.HEX:
            case EOLexer.BYTES:
                attrKey = EoSyntaxHighlighter.NUMBERS;
                break;
            case EOLexer.LB:
            case EOLexer.RB:
                attrKey = EoSyntaxHighlighter.BRACES;
                break;
            case EOLexer.STRING:
            case EOLexer.TEXT:
                attrKey = EoSyntaxHighlighter.STRING;
                break;
            case EOLexer.SPACE:
                attrKey = EoSyntaxHighlighter.SPACE;
                break;
            case EOLexer.DOT:
                attrKey = EoSyntaxHighlighter.DOT;
                break;
            case EOLexer.COMMENT:
                attrKey = EoSyntaxHighlighter.COMMENT;
                break;
            case EOLexer.HASH:
                attrKey = EoSyntaxHighlighter.HASH;
                break;
            case EOLexer.EOL:
                attrKey = EoSyntaxHighlighter.EOL;
                break;
            case EOLexer.NAME:
                attrKey = EoSyntaxHighlighter.NAME;
                break;
            case EOLexer.META:
                attrKey = EoSyntaxHighlighter.META;
                break;
            case EOLexer.BAD_CHARACTER:
                attrKey = EoSyntaxHighlighter.BAD_CHARACTER;
                break;
            default:
                return EoSyntaxHighlighter.EMPTY_KEYS;
        }
        return new TextAttributesKey[] {attrKey};
    }
}
