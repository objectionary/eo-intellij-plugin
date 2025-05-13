// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains;

import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.cacheBuilder.SimpleWordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import org.eolang.jetbrains.psi.EoAttributeDeclaration;
import org.eolang.jetbrains.psi.EoObjectDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Provides "Find Usages" support for EO objects and attributes.
 * @since 1.0
 */
public class EoFindUsagesProvider implements FindUsagesProvider {
    @Override
    public boolean canFindUsagesFor(@NotNull final PsiElement element) {
        return element instanceof EoObjectDeclaration
                || element instanceof EoAttributeDeclaration;
    }

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new SimpleWordsScanner();
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull final PsiElement element) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull final PsiElement element) {
        if (element instanceof EoObjectDeclaration) {
            return "EO object";
        }
        if (element instanceof EoAttributeDeclaration) {
            return "EO attribute";
        }
        return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull final PsiElement element) {
        if (element instanceof EoObjectDeclaration) {
            final EoObjectDeclaration obj = (EoObjectDeclaration) element;
            return obj.getName() != null ? obj.getName() : obj.getText();
        }
        if (element instanceof EoAttributeDeclaration) {
            final EoAttributeDeclaration attr = (EoAttributeDeclaration) element;
            return attr.getName() != null ? attr.getName() : attr.getText();
        }
        return element.getText();
    }

    @NotNull
    @Override
    public String getNodeText(
            @NotNull final PsiElement element,
            final boolean useFullName
    ) {
        return getDescriptiveName(element);
    }
}
