// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains.structview;

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

    @Override
    public @NotNull StructureView createStructureView(
            @NotNull final FileEditor fileEditor,
            @NotNull final StructureViewModel model,
            @NotNull final Project project
    ) {
        return createStructureView(fileEditor, model, project, true);
    }

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
        final StructureViewBuilder builder = getStructureViewBuilder(psi);
        return builder.createStructureView(fileEditor, project);
    }
}
