package org.eolang.jetbrains.structview;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiFile;
import javax.swing.*;
import org.eolang.jetbrains.Icons;
import org.jetbrains.annotations.Nullable;

public class EORootPresentation implements ItemPresentation {
  protected final PsiFile element;

  protected EORootPresentation(PsiFile element) {
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
    return element.getVirtualFile().getNameWithoutExtension();
  }

  @Nullable
  @Override
  public String getLocationString() {
    return null;
  }
}
