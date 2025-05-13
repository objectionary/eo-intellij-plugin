// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains.structview;

import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;
import org.eolang.jetbrains.psi.EoPsiFileRoot;
import org.eolang.jetbrains.psi.EoAttributeDeclaration;

/**
 * Structure view model for EO files:
 * - файл ─ корень,
 * - объекты ─ ветки,
 * - атрибуты ─ листья.
 * @since 1.0
 */
public final class EoStructureViewModel
        extends StructureViewModelBase
        implements StructureViewModel.ElementInfoProvider {

    /**
     * @param file   корневой PSI-файл EO
     * @param editor редактор, в котором открыт файл
     */
    public EoStructureViewModel(
            @NotNull final EoPsiFileRoot file,
            @NotNull final Editor editor
    ) {
        super(file, editor, new EoStructureViewElement(file));
        // мы показываем только EoPsiFileRoot и их атрибуты
        withSuitableClasses(EoPsiFileRoot.class, EoAttributeDeclaration.class);
    }

    @Override
    public boolean isAlwaysShowsPlus(
            @NotNull final StructureViewTreeElement element
    ) {
        // «+» показываем только на корневом узле (сам файл)
        return element.getValue() instanceof EoPsiFileRoot;
    }

    @Override
    public boolean isAlwaysLeaf(
            @NotNull final StructureViewTreeElement element
    ) {
        // атрибуты – листья, у них нет «+»
        return element.getValue() instanceof EoAttributeDeclaration;
    }
}
