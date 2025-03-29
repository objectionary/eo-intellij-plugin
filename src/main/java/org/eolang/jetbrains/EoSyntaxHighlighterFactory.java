// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * Definition of SyntaxHighlighter.
 * @since 0.0.0
 */
public class EoSyntaxHighlighterFactory extends SyntaxHighlighterFactory {
    @NotNull
    @Override
    public final SyntaxHighlighter getSyntaxHighlighter(
        final Project project,
        final VirtualFile virtualfile) {
        return new EoSyntaxHighlighter();
    }
}
