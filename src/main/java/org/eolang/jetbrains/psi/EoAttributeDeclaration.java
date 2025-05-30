// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
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
 * PSI element representing an EO attribute declaration (e.g. "> @foo").
 * @since 1.0
 */
public class EoAttributeDeclaration extends ASTWrapperPsiElement
    implements PsiNameIdentifierOwner {

    public EoAttributeDeclaration(@NotNull final ASTNode node) {
        super(node);
    }

    // @checkstyle DesignForExtensionCheck (18 lines)
    @Override
    public @Nullable PsiElement getNameIdentifier() {
        return findChildByClass(EoIdentifier.class);
    }

    // @checkstyle AvoidInlineConditionalsCheck (6 lines)
    @Override
    public @Nullable String getName() {
        final PsiElement id = this.getNameIdentifier();
        return id != null ? id.getText() : null;
    }

    // @checkstyle LocalFinalVariableNameCheck (12 lines)
    // @checkstyle ParameterNameCheck (12 lines)
    @Override
    public PsiElement setName(@NotNull final String newName)
        throws IncorrectOperationException {
        final PsiElement id = this.getNameIdentifier();
        if (id != null) {
            final PsiElement newId = EoPsiElementFactory.createIdentifier(
                getProject(), newName
            );
            id.replace(newId);
        }
        return this;
    }
}
