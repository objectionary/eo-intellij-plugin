/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.psi.PsiElement;

/**
 * Issue report.
 *
 * @since 0.0.0
 */
public class Issue {

    /**
     * Message.
     */
    private final String msg;

    /**
     * Node.
     */
    private final PsiElement offendnode;

    /**
     * Issue init.
     *
     * @param msg String
     * @param node PsiElement
     */
    public Issue(final String msg, final PsiElement node) {
        this.msg = msg;
        this.offendnode = node;
    }

    /**
     * Accessor.
     *
     * @return String message
     */
    final String getMsg() {
        return this.msg;
    }

    /**
     * Accessor.
     *
     * @return Offending node
     */
    final PsiElement getOffendnode() {
        return this.offendnode;
    }
}
