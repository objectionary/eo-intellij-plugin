// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains.structview;

// @checkstyle ImportOrderCheck (9 lines)

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.eolang.jetbrains.psi.EoAttributeDeclaration;

/**
 * Structure view element for EO attribute declarations (leaf nodes).
 * @since 1.0
 */
// @checkstyle CascadeIndentationCheck (5 lines)
public final class EoAttributeStructureViewElement
    extends PsiTreeElementBase<EoAttributeDeclaration> {

    /**
     * EoAttributeStructureViewElement method.
     * @param attribute The EO attribute PSI element
     */
    public EoAttributeStructureViewElement(
        @NotNull final EoAttributeDeclaration attribute
    ) {
        super(attribute);
    }

    @Override
    public @NotNull Collection<StructureViewTreeElement> getChildrenBase() {
        return Collections.emptyList();
    }

    @Override
    public @Nullable String getPresentableText() {
        return Objects.requireNonNull(getElement()).getName();
    }
}
