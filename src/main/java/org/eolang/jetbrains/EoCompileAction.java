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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
 *
 * @since 1.0
 * @checkstyle CascadeIndentationCheck (200 lines)
 * @checkstyle LineLengthCheck (200 lines)
 * @checkstyle OperatorWrapCheck (200 lines)
 * @checkstyle RegexpSinglelineCheck (200 lines)
 * @checkstyle StringLiteralsConcatenationCheck (200 lines)
 * @checkstyle MethodsOrderCheck (200 lines)
 * @checkstyle AvoidInlineConditionalsCheck (200 lines)
 */
@SuppressWarnings("PMD")
public final class EoCompileAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull final AnActionEvent action) {
        try {
            performUnsafe(action);
        } catch (final IllegalStateException exception) {
            notifyCannotCompile(exception.getMessage());
        }
    }

    /**
     * Constructs the list of EO Maven plugin goals.
     *
     * @param version   The plugin version
     * @return List of Maven goals
     * @since 1.0
     * @checkstyle ParameterNameCheck (20 lines)
     */
    static List<String> buildGoals(final String version) {
        final int capacity = 3;
        final List<String> goals = new ArrayList<>(capacity);
        final String prefix = "org.eolang:eo-maven-plugin:" + version + ":";
        goals.add(prefix + "register");
        goals.add(prefix + "transpile");
        goals.add(prefix + "assemble");
        return goals;
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    // @checkstyle LocalFinalVariableNameCheck (40 lines)
    private static void runBuild(final AnActionEvent action) {
        final DataContext context = action.getDataContext();
        final Project project = MavenActionUtil.getProject(context);
        if (project == null) {
            throw new IllegalStateException("No IDEA project selected");
        }
        final MavenProject mavenProject = MavenActionUtil.getMavenProject(context);
        if (mavenProject == null) {
            throw new IllegalStateException(
                String.format(
                    "No Maven project for %s",
                    project.getName()
                )
            );
        }
        final MavenPlugin plugin = mavenProject.findPlugin("org.eolang", "eo-maven-plugin");
        if (plugin == null) {
            throw new IllegalStateException(
                "EO Maven plugin is not configured. See: https://github.com/objectionary/eo/tree/master/eo-maven-plugin"
            );
        }
        final MavenProjectsManager manager = MavenProjectsManager.getInstance(project);
        final MavenExplicitProfiles profiles = manager.getExplicitProfiles();
        final List<String> goals = buildGoals(plugin.getVersion());
        final MavenRunnerParameters params = new MavenRunnerParameters(
            true,
            mavenProject.getDirectory(),
            mavenProject.getFile().getName(),
            goals,
            profiles.getEnabledProfiles(),
            profiles.getDisabledProfiles()
        );
        MavenRunConfigurationType.runConfiguration(
            project,
            params,
            null
        );
    }

    /**
     * Perform execution throwing exceptions.
     *
     * @param action Action to perform
     */
    private static void performUnsafe(final AnActionEvent action) {
        final DataContext context = action.getDataContext();
        final Project project = MavenActionUtil.getProject(context);
        if (project == null) {
            throw new IllegalStateException("Select IDEA project");
        }
        final MavenProject maven = MavenActionUtil.getMavenProject(context);
        if (maven == null) {
            throw new IllegalStateException(
                String.format("Set up Maven project for %s", project.getName())
            );
        }
        final MavenPlugin plugin = maven.findPlugin(
            "org.eolang", "eo-maven-plugin"
        );
        if (plugin == null) {
            throw new IllegalStateException(
                "eo-maven-plugin is not configured in your pom.xml, see https://github.com/objectionary/eo/tree/master/eo-maven-plugin"
            );
        }
        final MavenProjectsManager manager = MavenActionUtil.getProjectsManager(context);
        if (manager != null) {
            final MavenExplicitProfiles profiles = manager.getExplicitProfiles();
            final MavenRunnerParameters params = new MavenRunnerParameters(
                true,
                maven.getDirectory(),
                maven.getFile().getName(),
                Collections.singletonList(
                    String.format("org.eolang:eo-maven-plugin:%s:register", plugin.getVersion())
                ),
                profiles.getEnabledProfiles(),
                profiles.getDisabledProfiles()
            );
            MavenRunConfigurationType.runConfiguration(
                project,
                params,
                null
            );
        }
    }

    /**
     * Send compilation notification.
     *
     * @param reason Reason
     */
    private static void notifyCannotCompile(final String reason) {
        NotificationGroupManager.getInstance()
            .getNotificationGroup("System Messages")
            .createNotification("Cannot compile EO", reason, NotificationType.WARNING)
            .notifyAll();
    }
}
