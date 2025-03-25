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
// @checkstyle AvoidStaticImportCheck (15 lines)
package org.eolang.jetbrains;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.eolang.jetbrains.parser.EoLexer;
import org.jetbrains.annotations.NotNull;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

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
        final EoLexer lexer = new EoLexer(null);
        return new ANTLRLexerAdaptor(EoLanguage.INSTANCE, lexer);
    }

    // @checkstyle CyclomaticComplexity (100 lines)
    // @checkstyle JavaNCSSCheck (100 lines)
    // @checkstyle ReturnCountCheck (100 lines)
    @Override
    @SuppressWarnings({"PMD.OnlyOneReturn", "PMD.CyclomaticComplexity", "PMD.NcssCount"})
    public final TextAttributesKey[] getTokenHighlights(final IElementType tokentype) {
        if (!(tokentype instanceof TokenIElementType)) {
            return EoSyntaxHighlighter.EMPTY_KEYS;
        }
        final TokenIElementType mytype = (TokenIElementType) tokentype;
        final int ttype = mytype.getANTLRTokenType();
        final TextAttributesKey key;
        switch (ttype) {
            case EoLexer.LSQ:
            case EoLexer.RSQ:
            case EoLexer.CONST:
            case EoLexer.COLON:
            case EoLexer.ARROW:
            case EoLexer.XI:
            case EoLexer.RHO:
            case EoLexer.PLUS:
            case EoLexer.MINUS:
            case EoLexer.QUESTION:
            case EoLexer.STAR:
                key = EoSyntaxHighlighter.KEYWORD;
                break;
            case EoLexer.INT:
            case EoLexer.FLOAT:
            case EoLexer.HEX:
            case EoLexer.BYTES:
                key = EoSyntaxHighlighter.NUMBERS;
                break;
            case EoLexer.LB:
            case EoLexer.RB:
                key = EoSyntaxHighlighter.BRACES;
                break;
            case EoLexer.STRING:
            case EoLexer.TEXT:
                key = EoSyntaxHighlighter.STRING;
                break;
            case EoLexer.SPACE:
                key = EoSyntaxHighlighter.SPACE;
                break;
            case EoLexer.DOT:
                key = EoSyntaxHighlighter.DOT;
                break;
            case EoLexer.HASH:
                key = EoSyntaxHighlighter.HASH;
                break;
            case EoLexer.NAME:
                key = EoSyntaxHighlighter.NAME;
                break;
            case EoLexer.META:
                key = EoSyntaxHighlighter.META;
                break;
            case EoLexer.BAD_CHARACTER:
                key = EoSyntaxHighlighter.BAD_CHARACTER;
                break;
            default:
                return EoSyntaxHighlighter.EMPTY_KEYS;
        }
        return new TextAttributesKey[] {key};
    }
}
