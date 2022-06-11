package org.eolang.jetbrains;

import com.intellij.lang.Language;

public class EOLanguage extends Language {
  public static final EOLanguage INSTANCE = new EOLanguage();

  private EOLanguage() {
    super("EO");
  }
}
