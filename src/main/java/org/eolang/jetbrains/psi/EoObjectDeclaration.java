// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * PSI element representing an EO object declaration (e.g. "[args] > name").
 * @since 1.0
 */
public class EoObjectDeclaration extends ASTWrapperPsiElement
        implements PsiNameIdentifierOwner {

    public EoObjectDeclaration(@NotNull final ASTNode node) {
        super(node);
    }

    @Override
    public @Nullable PsiElement getNameIdentifier() {
        return findChildByClass(EoIdentifier.class);
    }

    @Override
    public @Nullable String getName() {
        final PsiElement id = getNameIdentifier();
        return id != null ? id.getText() : null;
    }

    @Override
    public PsiElement setName(@NotNull final String newName)
            throws IncorrectOperationException {
        final PsiElement id = getNameIdentifier();
        if (id != null) {
            final PsiElement newId = EoPsiElementFactory.createIdentifier(
                    getProject(), newName
            );
            id.replace(newId);
        }
        return this;
    }
}
