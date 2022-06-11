package org.eolang.jetbrains.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import javax.swing.*;
import org.antlr.intellij.adaptor.SymtabUtils;
import org.antlr.intellij.adaptor.psi.ScopeNode;
import org.eolang.jetbrains.EOFileType;
import org.eolang.jetbrains.EOLanguage;
import org.eolang.jetbrains.Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EOPSIFileRoot extends PsiFileBase implements ScopeNode {
  public EOPSIFileRoot(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, EOLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return EOFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "EO Language file";
  }

  @Override
  public Icon getIcon(int flags) {
    return Icons.EO_ICON;
  }

  /** Return null since a file scope has no enclosing scope. It is not itself in a scope. */
  @Override
  public ScopeNode getContext() {
    return null;
  }

  @Nullable
  @Override
  public PsiElement resolve(PsiNamedElement element) {
    return SymtabUtils.resolve(this, EOLanguage.INSTANCE, element, "/script/vardef/ID");
  }
}