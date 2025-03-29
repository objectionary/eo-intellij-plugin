// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import java.util.Collections;
import java.util.Map;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Class for drawing settings page in IDE.
 * @since 0.0.0
 */
public class EoColorSettingsPage implements ColorSettingsPage {
    /**
     * Here we describe tokens for display them in settings page.
     */
    private static final AttributesDescriptor[] DESCRIPTORS = {
        new AttributesDescriptor("Keywords", EoSyntaxHighlighter.KEYWORD),
        new AttributesDescriptor("Comments", EoSyntaxHighlighter.COMMENT),
        new AttributesDescriptor("Identifiers", EoSyntaxHighlighter.NAME),
        new AttributesDescriptor("Strings", EoSyntaxHighlighter.STRING),
        new AttributesDescriptor("Metas", EoSyntaxHighlighter.META),
        new AttributesDescriptor("Constants", EoSyntaxHighlighter.NUMBERS),
        new AttributesDescriptor("Braces", EoSyntaxHighlighter.BRACES),
    };

    @Nullable
    @Override
    public final Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return Collections.<String, TextAttributesKey>emptyMap();
    }

    @Override
    public final Icon getIcon() {
        return Icons.EO_ICON;
    }

    @NotNull
    @Override
    public final SyntaxHighlighter getHighlighter() {
        return new EoSyntaxHighlighter();
    }

    @NotNull
    @Override
    public final String getDemoText() {
        return "+alias org.eolang.io.stdout\n"
            .concat("+alias org.eolang.txt.sprintf\n\n")
            .concat("# is year leap?\n\n")
            .concat("[args...] > main\n")
            .concat("  [y] > leap\n")
            .concat("    or. > @\n")
            .concat("      and.\n")
            .concat("        eq. (mod. y 4) 0\n")
            .concat("        not. (eq. (mod. y 100) 0)\n")
            .concat("      eq. (mod. y 400) 0\n")
            .concat("  stdout > @\n")
            .concat("    sprintf\n")
            .concat("    \"%d is %sa leap year!\"\n")
            .concat("    (args.get 0).as-int > year!\n")
            .concat("  if. (leap year:y) \"")
            .concat("\" \"not \"\\n\"");
    }

    @NotNull
    @Override
    public final AttributesDescriptor[] getAttributeDescriptors() {
        return EoColorSettingsPage.DESCRIPTORS;
    }

    @NotNull
    @Override
    public final ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public final String getDisplayName() {
        return "EO";
    }
}
