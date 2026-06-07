// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains.structview;

// @checkstyle ImportOrderCheck (11 lines)

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.eolang.jetbrains.psi.EoPsiFileRoot;
import org.eolang.jetbrains.psi.EoObjectDeclaration;

/**
 * Structure view element for EO file root.
 * Uses PSI tree search instead of custom getters.
 * @since 1.0
 */
public final class EoStructureViewElement
    extends PsiTreeElementBase<EoPsiFileRoot> {

    /**
     * EoStructureViewElement method.
     * @param file EO file root
     */
    public EoStructureViewElement(@NotNull final EoPsiFileRoot file) {
        super(file);
    }

    @Override
    public @NotNull Collection<StructureViewTreeElement> getChildrenBase() {
        final EoPsiFileRoot file = getElement();
        final List<StructureViewTreeElement> children = new ArrayList<>(0);
        final List<EoObjectDeclaration> objects =
            PsiTreeUtil.getChildrenOfTypeAsList(file, EoObjectDeclaration.class);
        for (final EoObjectDeclaration obj : objects) {
            children.add(new EoObjectStructureViewElement(obj));
        }
        return children;
    }

    @Override
    public @NotNull String getPresentableText() {
        return "";
    }
}
