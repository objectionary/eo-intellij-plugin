// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains.psi;

// @checkstyle ImportOrderCheck (10 lines)

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
@SuppressWarnings("PMD.ProhibitPublicStaticMethods")
public final class EoPsiElementFactory {

    private EoPsiElementFactory() {
        // utility class
    }

    /**
     * Creates a new EO identifier PSI element with the given name.
     * @param project The current IntelliJ project
     * @param name The identifier name
     * @return A PSI element representing the identifier
     */
    // @checkstyle ReturnCountCheck (19 lines)
    @SuppressWarnings("PMD.OnlyOneReturn")
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
