// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.eolang.jetbrains.EoFileType;

/**
 * Factory class for creating EO PSI elements programmatically.
 * @since 1.0
 */
public final class EoPsiElementFactory {

    private EoPsiElementFactory() {
        // utility class
    }

    /**
     * Creates a new EO identifier PSI element with the given name.
     * @param project the current IntelliJ project
     * @param name the identifier name
     * @return a PSI element representing the identifier
     */
    @NotNull
    public static PsiElement createIdentifier(
            @NotNull final Project project,
            @NotNull final String name
    ) {
        final String text = String.format("[args] > %s", name);
        final PsiFile file = PsiFileFactory
                .getInstance(project)
                .createFileFromText("_dummy_.eo", EoFileType.INSTANCE, text);
        final EoObjectDeclaration decl = PsiTreeUtil
                .findChildOfType(file, EoObjectDeclaration.class);
        if (decl != null) {
            final PsiElement id = decl.getNameIdentifier();
            if (id != null) {
                return id;
            }
        }
        return file;
    }
}
