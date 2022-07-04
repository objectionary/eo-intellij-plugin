/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021-2022 Stepan Strunkov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

/**
 * Class drawing settings page in IDE
 * @since 0.0.0
 * @see <a href="https://plugins.jetbrains.com/docs/intellij/syntax-highlighter-and-color-settings-page.html">
 * documentation</a>
 */
public class EOColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS =
        new AttributesDescriptor[] {
            new AttributesDescriptor("Keywords", EOSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Comments", EOSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Identifiers", EOSyntaxHighlighter.NAME),
            new AttributesDescriptor("Strings", EOSyntaxHighlighter.STRING),
            new AttributesDescriptor("Metas", EOSyntaxHighlighter.META),
            new AttributesDescriptor("Constants", EOSyntaxHighlighter.NUMBERS),
            new AttributesDescriptor("Braces", EOSyntaxHighlighter.BRACES),
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
                + "+alias org.eolang.txt.sprintf\n\n"
                + "# is year leap?\n\n"
                + "[args...] > main\n"
                + "  [y] > leap\n"
                + "    or. > @\n"
                + "      and.\n"
                + "        eq. (mod. y 4) 0\n"
                + "        not. (eq. (mod. y 100) 0)\n"
                + "      eq. (mod. y 400) 0\n"
                + "  stdout > @\n"
                + "    sprintf\n"
                + "    \"%d is %sa leap year!\"\n"
                + "    (args.get 0).as-int > year!\n"
                + "  if. (leap year:y) \"\" \"not \"\n";
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return EOColorSettingsPage.DESCRIPTORS;
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
