package org.eolang.jetbrains;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import java.util.Map;
import javax.swing.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EOColorSettingsPage implements ColorSettingsPage {
  private static final AttributesDescriptor[] DESCRIPTORS =
    new AttributesDescriptor[] {
      new AttributesDescriptor("Keywords", EOSyntaxHighlighter.KEYWORD),
      new AttributesDescriptor("Comments", EOSyntaxHighlighter.COMMENT),
      new AttributesDescriptor("Identifiers", EOSyntaxHighlighter.NAME),
      new AttributesDescriptor("Strings", EOSyntaxHighlighter.STRING),
      new AttributesDescriptor("Metas", EOSyntaxHighlighter.META),
      new AttributesDescriptor("Constants", EOSyntaxHighlighter.NUMBERS),
      new AttributesDescriptor("Braces", EOSyntaxHighlighter.BRACES)
    };

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return null;
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return Icons.EO_ICON;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    return new EOSyntaxHighlighter();
  }

  @NotNull
  @Override
  public String getDemoText() {
    return "+alias org.eolang.io.stdout\n" +
            "+alias org.eolang.txt.sprintf\n\n" +
            "# is year leap?\n\n" +
            "[args...] > main\n" +
            "  [y] > leap\n" +
            "    or. > @\n" +
            "      and.\n" +
            "        eq. (mod. y 4) 0\n" +
            "        not. (eq. (mod. y 100) 0)\n" +
            "      eq. (mod. y 400) 0\n" +
            "  stdout > @\n" +
            "    sprintf\n" +
            "    \"%d is %sa leap year!\"\n" +
            "    (args.get 0).as-int > year!\n" +
            "  if. (leap year:y) \"\" \"not \"\n";
  }

  @NotNull
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return DESCRIPTORS;
  }

  @NotNull
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "EO";
  }
}
