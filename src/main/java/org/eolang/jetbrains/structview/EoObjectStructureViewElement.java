// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains.structview;

import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.eolang.jetbrains.psi.EoObjectDeclaration;
import org.eolang.jetbrains.psi.EoAttributeDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Structure view element for EO object declarations:
 * object -> attribute declarations.
 * @since 1.0
 */
public final class EoObjectStructureViewElement
        extends PsiTreeElementBase<EoObjectDeclaration> {

    /**
     * @param obj the EO object declaration
     */
    public EoObjectStructureViewElement(@NotNull final EoObjectDeclaration obj) {
        super(obj);
    }

    @Override
    public @NotNull Collection<StructureViewTreeElement> getChildrenBase() {
        final List<EoAttributeDeclaration> attrs = PsiTreeUtil
                .getChildrenOfTypeAsList(getElement(), EoAttributeDeclaration.class);
        final List<StructureViewTreeElement> children = new ArrayList<>(attrs.size());
        for (final EoAttributeDeclaration attr : attrs) {
            children.add(new EoAttributeStructureViewElement(attr));
        }
        return children;
    }

    @Override
    public @Nullable String getPresentableText() {
        return Objects.requireNonNull(getElement()).getName();
    }
}
