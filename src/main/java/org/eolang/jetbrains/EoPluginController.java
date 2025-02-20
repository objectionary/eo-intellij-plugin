/*
 * The MIT License (MIT)
 *
 *
 *
 * Copyright (c) 2021-2022 Stepan Strunkov
 *
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 *
 * of this software and associated documentation files (the "Software"), to deal
 *
 * in the Software without restriction, including without limitation the rights
 *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *
 * copies of the Software, and to permit persons to whom the Software is
 *
 * furnished to do so, subject to the following conditions:
 *
 *
 *
 * The above copyright notice and this permission notice shall be included
 *
 * in all copies or substantial portions of the Software.
 *
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *
 * SOFTWARE.
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
 * @since 0.0.0
 * @checkstyle MultilineJavadocTagsCheck (200 lines)
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
     * @param project Opened project
     */
    public EoPluginController(final Project project) {
        this.project = project;
    }

    @Override
    public final void projectOpened() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Project opened");
        }
    }

    @Override
    public final void projectClosed() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Project closed ".concat(this.project.getName()));
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
        final Runnable runnableRemove = () -> fileTypeManager.removeAssociatedExtension(
            FileTypes.PLAIN_TEXT, "eo"
        );
        final Runnable runnableAssociate = () -> fileTypeManager.associateExtension(
            EoFileType.INSTANCE, "eo"
        );
        WriteCommandAction.runWriteCommandAction(this.getProject(), runnableRemove);
        WriteCommandAction.runWriteCommandAction(this.getProject(), runnableAssociate);
    }

    /**
     * Accessor.
     * @return Project opened project
     */
    final Project getProject() {
        return this.project;
    }
}
