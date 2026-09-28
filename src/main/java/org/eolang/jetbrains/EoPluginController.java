/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Start class of project.
 * Contains instructions what to do after opening project etc
 *
 * @since 0.0.0
 * @checkstyle LocalFinalVariableNameCheck (200 lines)
 */
public class EoPluginController implements ProjectComponent {

    /**
     * Log prefix.
     */
    public static final Logger LOG = Logger.getInstance("EOPluginController");

    /**
     * Project instance.
     */
    private final Project project;

    /**
     * Constructor.
     *
     * @param project Opened project
     */
    public EoPluginController(final Project project) {
        this.project = project;
    }

    @Override
    public final void projectOpened() {
        if (EoPluginController.LOG.isDebugEnabled()) {
            EoPluginController.LOG.debug("Project opened");
        }
    }

    @Override
    public final void projectClosed() {
        if (EoPluginController.LOG.isDebugEnabled()) {
            EoPluginController.LOG.debug("Project closed ".concat(this.project.getName()));
        }
    }

    // public final void disposeComponent() { }

    @NotNull
    @Override
    public final String getComponentName() {
        return "eo.ProjectComponent";
    }

    @Override
    public final void initComponent() {
        final FileTypeManager fileTypeManager = FileTypeManager.getInstance();
        WriteCommandAction.runWriteCommandAction(
            this.getProject(),
            () -> fileTypeManager.removeAssociatedExtension(FileTypes.PLAIN_TEXT, "eo")
        );
        WriteCommandAction.runWriteCommandAction(
            this.getProject(),
            () -> fileTypeManager.associateExtension(EoFileType.INSTANCE, "eo")
        );
    }

    /**
     * Accessor.
     *
     * @return Project opened project
     */
    final Project getProject() {
        return this.project;
    }
}
