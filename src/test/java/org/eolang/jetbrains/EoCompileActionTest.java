// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.Presentation;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Unit tests for EoCompileAction helper methods.
 * Test class @EoCompileActionTest.
 * @since 0.0.1
 */
@SuppressWarnings("PMD.JUnit5TestShouldBePackagePrivate")
public final class EoCompileActionTest {

    @SuppressWarnings("PMD.ProhibitPlainJunitAssertionsRule")
    @Test
    void buildGoals() {
        final List<String> goals = EoCompileAction.buildGoals("0.56.0");
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

    @SuppressWarnings("PMD.AvoidAccessibilityAlteration")
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
}
