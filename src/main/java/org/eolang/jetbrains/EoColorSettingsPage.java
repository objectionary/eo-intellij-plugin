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
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.ResourceUtil;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Class for drawing settings page in IDE.
 *
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

    /**
     * Ctor.
     */
    public EoColorSettingsPage() {
        // IntelliJ instantiates this extension with no arguments
    }

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
        try {
            return StringUtil.convertLineSeparators(
                ResourceUtil.loadText(EoColorSettingsPage.class.getResourceAsStream("demo.eo"))
            );
        } catch (final IOException ex) {
            throw new IllegalStateException(
                "Cannot load the demo text of the EO color settings page", ex
            );
        }
    }

    @NotNull
    @Override
    public final AttributesDescriptor[] getAttributeDescriptors() {
        return EoColorSettingsPage.DESCRIPTORS.clone();
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
