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

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eolang.jetbrains.parser.EoLexer;
import org.eolang.jetbrains.parser.EoParser;
import org.eolang.jetbrains.psi.EoPsiFileRoot;
import org.jetbrains.annotations.NotNull;

/**
 * Let's define a parser for EO language.
 * @since 0.0.0
 * @checkstyle MultilineJavadocTagsCheck (200 lines)
 * @checkstyle VisibilityModifierCheck (200 lines)
 */
public class EoParserDefinition implements ParserDefinition {
    /**
     * Instance of EO language.
     */
    public static final IFileElementType FILE = new IFileElementType(EoLanguage.INSTANCE);
    /**
     * ID of token element type.
     */

    static {
        PSIElementTypeFactory.defineLanguageIElementTypes(
            EoLanguage.INSTANCE, EoParser.tokenNames, EoParser.ruleNames
        );
    }

    @NotNull
    @Override
    public final Lexer createLexer(final Project project) {
        final EoLexer lexer = new EoLexer(null);
        return new ANTLRLexerAdaptor(EoLanguage.INSTANCE, lexer);
    }

    @NotNull
    @Override
    public final PsiParser createParser(final Project project) {
        final EoParser parser = new EoParser(null);
        return new ANTLRParserAdaptor(EoLanguage.INSTANCE, parser) {
            @Override
            protected ParseTree parse(final Parser parser, final IElementType root) {
                return ((EoParser) parser).program();
            }
        };
    }

    // Tokens of those types are automatically skipped by PsiBuilder.
    @NotNull
    @Override
    public final TokenSet getWhitespaceTokens() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public final TokenSet getCommentTokens() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public final TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public final IFileElementType getFileNodeType() {
        return EoParserDefinition.FILE;
    }

    /*
     * Create the root of your PSI tree (a PsiFile).
     *
     * <p>From IntelliJ IDEA Architectural Overview: "A PSI (Program Structure Interface)
     * file is the root of a structure representing the contents of a file as a hierarchy
     *  of elements in a particular programming language."
     *
     * <p>PsiFile is to be distinguished from a FileASTNode, which is a parse tree node that
     * eventually becomes a PsiFile. From PsiFile, we can get it back via: {@link PsiFile#getNode}.
     */
    @Override
    public final PsiFile createFile(final FileViewProvider viewprovider) {
        return new EoPsiFileRoot(viewprovider);
    }

    /*
     * Convert from *NON-LEAF* parse node (AST they call it) to PSI node. Leaves are
     * created in the AST factory. Rename re-factoring can cause this to be called
     * on a TokenIElementType since we want to rename ID nodes. In that case, this
     * method is called to create the root node but with ID type. Kind of strange,
     * but we can simply create a ASTWrapperPsiElement to make everything
     * work correctly.
     *
     * <p>RuleIElementType. Ah! It's that ID is the root IElementType requested to parse,
     * which means that the root node returned from parsetree->PSI conversion. But, it
     * must be a CompositeElement! The adaptor calls rootMarker.done(root) to finish off
     * the PSI conversion.
     *
     * <p>If you don't care to distinguish PSI nodes by type, it is sufficient to create a {@link
     * ANTLRPsiNode} around the parse tree node
     */
    @NotNull
    @Override
    public final PsiElement createElement(final ASTNode node) {
        return new ANTLRPsiNode(node);
    }
}
