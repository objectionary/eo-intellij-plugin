// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains.structview;

// @checkstyle ImportOrderCheck (9 lines)

import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;
import org.eolang.jetbrains.psi.EoPsiFileRoot;
import org.eolang.jetbrains.psi.EoAttributeDeclaration;

/**
 * Structure view model for EO files:
 * - File ─ root,
 * - Objects ─ branches,
 * - Attributes ─ Leafs.
 * @since 1.0
 */
// @checkstyle CascadeIndentationCheck (4 lines)
public final class EoStructureViewModel
    extends StructureViewModelBase
    implements StructureViewModel.ElementInfoProvider {

    /**
     * EoStructureViewModel method.
     * @param file Root PSI-file EO
     * @param editor Editor with opened file
     */
    @SuppressWarnings("PMD.ConstructorOnlyInitializesOrCallOtherConstructors")
    public EoStructureViewModel(
        @NotNull final EoPsiFileRoot file,
        @NotNull final Editor editor
    ) {
        super(file, editor, new EoStructureViewElement(file));
        withSuitableClasses(EoPsiFileRoot.class, EoAttributeDeclaration.class);
    }

    @Override
    public boolean isAlwaysShowsPlus(
        @NotNull final StructureViewTreeElement element
    ) {
        return element.getValue() instanceof EoPsiFileRoot;
    }

    @Override
    public boolean isAlwaysLeaf(
        @NotNull final StructureViewTreeElement element
    ) {
        return element.getValue() instanceof EoAttributeDeclaration;
    }
}
