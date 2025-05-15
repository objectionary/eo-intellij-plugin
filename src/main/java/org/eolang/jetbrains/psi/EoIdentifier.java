// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * PSI element for EO identifier tokens.
 * Represents any name token in EO code.
 * @since 1.0
 */
public class EoIdentifier extends ASTWrapperPsiElement {

    /**
     * EoIdentifier method.
     * @param node AST node for identifier
     */
    public EoIdentifier(@NotNull final ASTNode node) {
        super(node);
    }
}
