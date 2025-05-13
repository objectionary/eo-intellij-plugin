// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains.structview;

import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import org.eolang.jetbrains.psi.EoAttributeDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * Structure view element for EO attribute declarations (leaf nodes).
 * @since 1.0
 */
public final class EoAttributeStructureViewElement
        extends PsiTreeElementBase<EoAttributeDeclaration> {

    /**
     * @param attribute the EO attribute PSI element
     */
    public EoAttributeStructureViewElement(
            @NotNull final EoAttributeDeclaration attribute
    ) {
        super(attribute);
    }

    @Override
    public @NotNull Collection<StructureViewTreeElement> getChildrenBase() {
        // Leaf nodes: no children
        return Collections.emptyList();
    }

    @Override
    public @Nullable String getPresentableText() {
        return Objects.requireNonNull(getElement()).getName();
    }
}
