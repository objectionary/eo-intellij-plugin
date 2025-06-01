// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains.structview;

// @checkstyle ImportOrderCheck (15 lines)

import org.jetbrains.annotations.NotNull;
import com.intellij.ide.structureView.StructureView;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewFactory;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtilBase;
import org.eolang.jetbrains.psi.EoPsiFileRoot;

/**
 * Factory for EO Structure View (Outline).
 * Provides a tree-based model for EO files.
 * @since 1.0
 */
public class EoStructureViewFactory extends StructureViewFactory {

    // @checkstyle NonStaticMethodCheck (6 lines)
    // @checkstyle DesignForExtensionCheck (6 lines)
    // @checkstyle ParameterNameCheck (10 lines)
    public @NotNull StructureViewBuilder getStructureViewBuilder(
        @NotNull final PsiFile psiFile
    ) {
        return new TreeBasedStructureViewBuilder() {
            @Override
            public @NotNull StructureViewModel createStructureViewModel(
                final Editor editor
            ) {
                return new EoStructureViewModel((EoPsiFileRoot) psiFile, editor);
            }
        };
    }

    // @checkstyle DesignForExtensionCheck (8 lines)
    // @checkstyle ParameterNameCheck (7 lines)
    // @checkstyle RequireThisCheck (6 lines)
    @Override
    public @NotNull StructureView createStructureView(
        @NotNull final FileEditor fileEditor,
        @NotNull final StructureViewModel model,
        @NotNull final Project project
    ) {
        return this.createStructureView(fileEditor, model, project, true);
    }

    // @checkstyle DesignForExtensionCheck (8 lines)
    // @checkstyle ParameterNameCheck (10 lines)
    // @checkstyle RequireThisCheck (6 lines)
    // @checkstyle StringLiteralsConcatenationCheck (10 lines)
    @Override
    public @NotNull StructureView createStructureView(
        @NotNull final FileEditor fileEditor,
        @NotNull final StructureViewModel model,
        @NotNull final Project project,
        final boolean showRoot
    ) {
        if (!(fileEditor instanceof TextEditor)) {
            throw new IllegalArgumentException(
                "Unsupported editor type: " + fileEditor.getClass()
            );
        }
        final Editor editor = ((TextEditor) fileEditor).getEditor();
        final PsiFile psi = PsiUtilBase.getPsiFileInEditor(editor, project);
        assert psi != null;
        final StructureViewBuilder builder = this.getStructureViewBuilder(psi);
        return builder.createStructureView(fileEditor, project);
    }
}
