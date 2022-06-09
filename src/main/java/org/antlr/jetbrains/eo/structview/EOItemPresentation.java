package org.antlr.jetbrains.eo.structview;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import javax.swing.*;
import org.antlr.jetbrains.eo.Icons;
import org.jetbrains.annotations.Nullable;

public class EOItemPresentation implements ItemPresentation {
  protected final PsiElement element;

  protected EOItemPresentation(PsiElement element) {
    this.element = element;
  }

  @Nullable
  @Override
  public Icon getIcon(boolean unused) {
    return Icons.EO_ICON;
  }

  @Nullable
  @Override
  public String getPresentableText() {
    ASTNode node = element.getNode();
    return node.getText();
  }

  @Nullable
  @Override
  public String getLocationString() {
    return null;
  }
}
