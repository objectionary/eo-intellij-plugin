/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021-2022 Stepan Strunkov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
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
 */
public class EOPluginController implements ProjectComponent {
    public static final String PLUGIN_ID = "org.eolang.jetbrains";
    public static final Logger LOG = Logger.getInstance("EOPluginController");

    public Project project;
    // public boolean projectIsClosed = false;

    /**
     * Constructor
     * @param project opened project
     */
    public EOPluginController(final Project project) {
        this.project = project;
    }

    @Override
    public void projectClosed() {
        LOG.info("projectClosed " + project.getName());
    }

    @Override
    public void projectOpened() {
        LOG.info("Project opened");
    }

    @Override
    public void initComponent() {
        final FileTypeManager fileTypeManager = FileTypeManager.getInstance();
        final Runnable r1 = ()->fileTypeManager.removeAssociatedExtension(FileTypes.PLAIN_TEXT, "eo");
        final Runnable r2 = ()->fileTypeManager.associateExtension(EOFileType.INSTANCE, "eo");
        WriteCommandAction.runWriteCommandAction(project, r1);
        WriteCommandAction.runWriteCommandAction(project, r2);
    }

    @Override
    public void disposeComponent() {}

    @NotNull
    @Override
    public String getComponentName() {
        return "eo.ProjectComponent";
    }
}
