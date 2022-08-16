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

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
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
 */
public final class EoCompileAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull final AnActionEvent action) {
        final DataContext context = action.getDataContext();
        final Project project = MavenActionUtil.getProject(context);
        MavenProject maven = null;
        String name = "";
        if (project != null) {
            maven = MavenActionUtil.getMavenProject(context);
            name = project.getName();
        }
        if (maven == null) {
            Notifications.Bus.notify(
                new Notification(
                    Notifications.SYSTEM_MESSAGES_GROUP_ID,
                    "Cannot compile EO",
                    String.format("Not a maven project: %s", name),
                    NotificationType.WARNING
                )
            );
            return;
        }
        final MavenPlugin plugin = EoCompileAction.eoPlugin(maven);
        final MavenProjectsManager manager = MavenActionUtil.getProjectsManager(context);
        if (manager != null && plugin != null) {
            final String version = plugin.getVersion();
            final MavenExplicitProfiles profiles = manager.getExplicitProfiles();
            final MavenRunnerParameters params = new MavenRunnerParameters(
                true,
                maven.getDirectory(),
                maven.getFile().getName(),
                Collections.singletonList(
                    String.format("org.eolang:eo-maven-plugin:%s:register", version)
                ),
                profiles.getEnabledProfiles(),
                profiles.getDisabledProfiles()
            );
            MavenRunConfigurationType.runConfiguration(project, params, null);
        }
    }

    /**
     * Try to find EO Maven plugin.
     * @param maven Maven project
     * @return Found plugin or null
     */
    private static MavenPlugin eoPlugin(final MavenProject maven) {
        final MavenPlugin plugin = maven.findPlugin("org.eolang", "eo-maven-plugin");
        if (plugin == null) {
            Notifications.Bus.notify(
                new Notification(
                    Notifications.SYSTEM_MESSAGES_GROUP_ID,
                    "Cannot compile EO",
                    "Eo-maven plugin is not configured",
                    NotificationType.WARNING
                )
            );
        }
        return plugin;
    }
}
