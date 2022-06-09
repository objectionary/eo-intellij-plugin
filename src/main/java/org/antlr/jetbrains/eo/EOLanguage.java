package org.antlr.jetbrains.eo;

import com.intellij.lang.Language;

public class EOLanguage extends Language {
  public static final EOLanguage INSTANCE = new EOLanguage();

  private EOLanguage() {
    super("EO");
  }
}
