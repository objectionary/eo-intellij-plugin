package org.eolang.jetbrains;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.List;
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.intellij.adaptor.lexer.TokenIElementType;
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eolang.jetbrains.parser.EOLexer;
import org.eolang.jetbrains.parser.EOParser;
import org.eolang.jetbrains.psi.*;
import org.eolang.jetbrains.psi.EOPSIFileRoot;
import org.jetbrains.annotations.NotNull;

public class EOParserDefinition implements ParserDefinition {
  public static final IFileElementType FILE = new IFileElementType(EOLanguage.INSTANCE);

  public static TokenIElementType ID;

  static {
    PSIElementTypeFactory.defineLanguageIElementTypes(
        EOLanguage.INSTANCE, EOParser.tokenNames, EOParser.ruleNames);
    List<TokenIElementType> tokenIElementTypes =
        PSIElementTypeFactory.getTokenIElementTypes(EOLanguage.INSTANCE);
    ID = tokenIElementTypes.get(EOLexer.AT);
  }

  public static final TokenSet COMMENTS =
      PSIElementTypeFactory.createTokenSet(EOLanguage.INSTANCE, EOLexer.COMMENT);

  public static final TokenSet WHITESPACE =
      PSIElementTypeFactory.createTokenSet(EOLanguage.INSTANCE, EOLexer.SPACE);

  public static final TokenSet STRING =
      PSIElementTypeFactory.createTokenSet(EOLanguage.INSTANCE, EOLexer.STRING, EOLexer.INT);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    EOLexer lexer = new EOLexer(null);
    return new ANTLRLexerAdaptor(EOLanguage.INSTANCE, lexer);
  }

  @NotNull
  public PsiParser createParser(final Project project) {
    final EOParser parser = new EOParser(null);
    return new ANTLRParserAdaptor(EOLanguage.INSTANCE, parser) {
      @Override
      protected ParseTree parse(Parser parser, IElementType root) {
        // start rule depends on root passed in; sometimes we want to create an ID node etc...

        // let's hope it's an ID as needed by "rename function"
        return ((EOParser) parser).program();
      }
    };
  }

  /** "Tokens of those types are automatically skipped by PsiBuilder." */
  @NotNull
  public TokenSet getWhitespaceTokens() {
    return TokenSet.EMPTY;
  }

  @NotNull
  public TokenSet getCommentTokens() {
    return TokenSet.EMPTY;
    // return COMMENTS;
  }

  @NotNull
  public TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
    // return STRING;
  }
  /*public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
  	return SpaceRequirements.MAY;
  }*/

  /**
   * What is the IFileElementType of the root parse tree node? It is called from {@link
   * #createFile(FileViewProvider)} at least.
   */
  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  /**
   * Create the root of your PSI tree (a PsiFile).
   *
   * <p>From IntelliJ IDEA Architectural Overview: "A PSI (Program Structure Interface) file is the
   * root of a structure representing the contents of a file as a hierarchy of elements in a
   * particular programming language."
   *
   * <p>PsiFile is to be distinguished from a FileASTNode, which is a parse tree node that
   * eventually becomes a PsiFile. From PsiFile, we can get it back via: {@link PsiFile#getNode}.
   */
  @Override
  public PsiFile createFile(FileViewProvider viewProvider) {
    return new EOPSIFileRoot(viewProvider);
  }

  /**
   * Convert from *NON-LEAF* parse node (AST they call it) to PSI node. Leaves are created in the
   * AST factory. Rename re-factoring can cause this to be called on a TokenIElementType since we
   * want to rename ID nodes. In that case, this method is called to create the root node but with
   * ID type. Kind of strange, but we can simply create a ASTWrapperPsiElement to make everything
   * work correctly.
   *
   * <p>RuleIElementType. Ah! It's that ID is the root IElementType requested to parse, which means
   * that the root node returned from parsetree->PSI conversion. But, it must be a CompositeElement!
   * The adaptor calls rootMarker.done(root) to finish off the PSI conversion. See {@link
   * ANTLRParserAdaptor#parse(IElementType root, PsiBuilder)}
   *
   * <p>If you don't care to distinguish PSI nodes by type, it is sufficient to create a {@link
   * ANTLRPsiNode} around the parse tree node
   */
  @NotNull
  public PsiElement createElement(ASTNode node) {
    return new ANTLRPsiNode(node);
  }
}
