// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
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
