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
      new AttributesDescriptor("CONSTANTS", EOSyntaxHighlighter.CONST),
      new AttributesDescriptor("COMMENTS", EOSyntaxHighlighter.COMMENT),
      new AttributesDescriptor("NAMES", EOSyntaxHighlighter.NAME),
      new AttributesDescriptor("STRING", EOSyntaxHighlighter.STRING),
      new AttributesDescriptor("METAS", EOSyntaxHighlighter.META)
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
    return "+alias org.eolang.io.stdout\n"
        + "# comment\n"
        + "\n"
        + "[] > app\n"
        + "  stdout > @\n"
        + "    \"Hello, world!\"\n"
        + "123  #constant";
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
