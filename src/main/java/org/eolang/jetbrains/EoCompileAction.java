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

import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import java.util.Collections;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.idea.maven.execution.MavenRunConfigurationType;
import org.jetbrains.idea.maven.execution.MavenRunnerParameters;
import org.jetbrains.idea.maven.model.MavenExplicitProfiles;
import org.jetbrains.idea.maven.model.MavenPlugin;
import org.jetbrains.idea.maven.project.MavenProject;
import org.jetbrains.idea.maven.project.MavenProjectsManager;
import org.jetbrains.idea.maven.utils.actions.MavenActionUtil;

/**
 * Compile EO sources.
 * @since 1.0
 * @todo #20:30min Make compile action complete adding remaining compile actions
 *  (assemble, transpile etc.)
 * @todo #20:30min Create tests for the action
 * @checkstyle LineLengthCheck (30 lines)
 */
public final class EoCompileAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull final AnActionEvent action) {
        try {
            EoCompileAction.performUnsafe(action);
        } catch (final IllegalStateException exception) {
            EoCompileAction.notifyCannotCompile(exception.getMessage());
        }
    }

    /**
     * Perform execution throwing exceptions.
     * @param action Action to perform
     */
    private static void performUnsafe(final AnActionEvent action) {
        final DataContext context = action.getDataContext();
        final Project project = MavenActionUtil.getProject(context);
        if (project == null) {
            throw new IllegalStateException("Select Idea project");
        }
        final MavenProject maven = MavenActionUtil.getMavenProject(context);
        if (maven == null) {
            throw new IllegalStateException(
                String.format("Set up Maven project for %s", project.getName())
            );
        }
        final MavenPlugin plugin = maven.findPlugin("org.eolang", "eo-maven-plugin");
        if (plugin == null) {
            throw new IllegalStateException(
                "eo-maven-plugin is not configured in your pom.xml, see https://github.com/objectionary/eo/tree/master/eo-maven-plugin"
            );
        }
        final MavenProjectsManager manager = MavenActionUtil.getProjectsManager(context);
        if (manager != null) {
            final MavenExplicitProfiles profiles = manager.getExplicitProfiles();
            MavenRunConfigurationType.runConfiguration(
                project,
                new MavenRunnerParameters(
                    true,
                    maven.getDirectory(),
                    maven.getFile().getName(),
                    Collections.singletonList(
                        String.format("org.eolang:eo-maven-plugin:%s:register", plugin.getVersion())
                    ),
                    profiles.getEnabledProfiles(),
                    profiles.getDisabledProfiles()
                ),
                null
            );
        }
    }

    /**
     * Send compilation notification.
     * @param reason Reason
     */
    private static void notifyCannotCompile(final String reason) {
        NotificationGroupManager.getInstance()
            .getNotificationGroup("System Messages")
            .createNotification("Cannot compile EO", reason, NotificationType.WARNING)
            .notifyAll();
    }
}
