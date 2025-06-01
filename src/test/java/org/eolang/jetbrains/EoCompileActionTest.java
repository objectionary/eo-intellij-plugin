// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.Presentation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

/**
 * Unit tests for EoCompileAction helper methods.
 * Test class @EoCompileActionTest.
 * @since 0.0.1
 */
@SuppressWarnings({"PMD.JUnit5TestShouldBePackagePrivate", "PMD.AvoidAccessibilityAlteration"})
public final class EoCompileActionTest {

    @SuppressWarnings("PMD.ProhibitPlainJunitAssertionsRule")
    @Test
    void buildGoals() {
        final EoCompileAction action = new EoCompileAction();
        final List<String> goals = action.buildGoals("0.56.0");
        final String[] expected = {
            "org.eolang:eo-maven-plugin:0.56.0:register",
            "org.eolang:eo-maven-plugin:0.56.0:transpile",
            "org.eolang:eo-maven-plugin:0.56.0:assemble",
        };
        Assert.assertArrayEquals(
            "Goals should match expected sequence",
            expected,
            goals.toArray(new String[0])
        );
    }

    @Test
    void performUnsafeThrowsIfNoProject() throws Exception {
        final DataContext emptyctx = dataId -> null;
        final Presentation presentation = new Presentation();
        final ActionManager actionman = Mockito.mock(ActionManager.class);
        final String place = "UnitTest";
        final AnActionEvent event = new AnActionEvent(
            null,
            emptyctx,
            place,
            presentation,
            actionman,
            0
        );
        final Method perform = EoCompileAction.class.getDeclaredMethod(
            "performUnsafe",
            AnActionEvent.class
        );
        perform.setAccessible(true);
        final Exception exception = Assertions.assertThrows(
            Exception.class,
            () -> perform.invoke(
                null,
                event
            )
        );
        Throwable cause = exception;
        if (exception.getCause() != null) {
            cause = exception.getCause();
        }
        Assertions.assertInstanceOf(
            IllegalStateException.class,
            cause
        );
        Assertions.assertEquals(
            "Select IDEA project",
            cause.getMessage()
        );
    }

    @Test
    void runBuildThrowsIfNoProject() throws Exception {
        final DataContext emptyctx = dataId -> null;
        final Presentation presentation = new Presentation();
        final ActionManager actionman = Mockito.mock(ActionManager.class);
        final String place = "UnitTest";
        final AnActionEvent event = new AnActionEvent(
            null,
            emptyctx,
            place,
            presentation,
            actionman,
            0
        );
        final Method runbuild = EoCompileAction.class.getDeclaredMethod(
            "runBuild",
            AnActionEvent.class
        );
        runbuild.setAccessible(
            true
        );
        final Exception exception = Assertions.assertThrows(
            Exception.class,
            () -> runbuild.invoke(
                null,
                event
            )
        );
        Throwable cause = exception;
        if (exception.getCause() != null) {
            cause = exception.getCause();
        }
        Assertions.assertTrue(cause instanceof IllegalStateException);
        Assertions.assertEquals(
            "No IDEA project selected",
            cause.getMessage()
        );
    }

    @Test
    void notifyCannotCompileDoesNotThrow() throws Exception {
        final Method notify = EoCompileAction.class.getDeclaredMethod(
            "notifyCannotCompile",
            String.class
        );
        notify.setAccessible(
            true
        );
        final InvocationTargetException exception = Assertions.assertThrows(
            InvocationTargetException.class,
            () -> notify.invoke(
                null,
                "some error"
            ),
            "Expecting NPE, because in default unit-env NotificationGroupManager.getInstance() throws null"
        );
        Assertions.assertTrue(
            exception.getCause() instanceof NullPointerException,
            "Expecting, that getCause() in InvocationTargetException will be NullPointerException"
        );
    }

    @Test
    void notifyCannotCompileInvokesNotificationCorrectly() throws Exception {
        final Notification mocknotify = Mockito.mock(
            Notification.class
        );
        final NotificationGroup mockgroup = Mockito.mock(
            NotificationGroup.class
        );
        Mockito.when(
            mockgroup.createNotification(
                Mockito.eq(
                    "Cannot compile EO"
                ),
                Mockito.eq(
                    "Test-reason"
                ),
                Mockito.eq(
                    NotificationType.WARNING
                )
            )
        ).thenReturn(
            mocknotify
        );
        final NotificationGroupManager mockmanag = Mockito.mock(
            NotificationGroupManager.class
        );
        Mockito.when(
            mockmanag.getNotificationGroup(
                "System Messages"
            )
        ).thenReturn(
            mockgroup
        );
        try (MockedStatic<NotificationGroupManager> mockedStatic = Mockito.mockStatic(
            NotificationGroupManager.class
        )
        ) {
            mockedStatic.when(
                NotificationGroupManager::getInstance
            ).thenReturn(
                mockmanag
            );
            final Method notifymeth = EoCompileAction.class.getDeclaredMethod(
                "notifyCannotCompile",
                String.class
            );
            notifymeth.setAccessible(
                true
            );
            final InvocationTargetException thrown = Assertions.assertThrows(
                InvocationTargetException.class,
                () -> notifymeth.invoke(
                    null,
                    "Test-reason"
                ),
                "Expect that notification.notifyAll() will throw IllegalMonitorStateException"
            );
            Assertions.assertTrue(
                thrown.getCause() instanceof IllegalMonitorStateException,
                "Expect getCause() to be equal IllegalMonitorStateException"
            );
            Mockito.verify(
                mockmanag, Mockito.times(
                    1
                )
            ).getNotificationGroup(
                "System Messages"
            );
            Mockito.verify(
                mockgroup, Mockito.times(
                    1
                )
            ).createNotification(
                "Cannot compile EO",
                "Test-reason",
                NotificationType.WARNING
            );
        }
    }
}
