package org.antlr.jetbrains.eo;

import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EOFindUsagesProvider implements FindUsagesProvider {
  /** Is "find usages" meaningful for a kind of definition subtree? */
  @Override
  public boolean canFindUsagesFor(PsiElement psiElement) {
    return false;
  }

  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return null; // null implies use SimpleWordScanner default
  }

  @Nullable
  @Override
  public String getHelpId(PsiElement psiElement) {
    return null;
  }

  /** What kind of thing is the ID node? Can group by in "Find Usages" dialog */
  @NotNull
  @Override
  public String getType(PsiElement element) {
    return "";
  }

  @NotNull
  @Override
  public String getDescriptiveName(PsiElement element) {
    return element.getText();
  }

  @NotNull
  @Override
  public String getNodeText(PsiElement element, boolean useFullName) {
    return element.getText();
  }
}
