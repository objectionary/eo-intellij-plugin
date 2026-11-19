/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains;

import com.intellij.testFramework.TestActionEvent;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.Test;

/**
 * Tests for {@link org.eolang.jetbrains.EoCompileAction}.
 *
 * @since 1.0
 * @checkstyle ProhibitTestMethodNameCheck (50 lines)
 */
@SuppressWarnings("PMD.WrongTestAnnotation")
public final class EoCompileActionTest extends BasePlatformTestCase {

    /**
     * Missing Maven project must show a notification, not throw.
     */
    @Test
    public void testNotifiesWhenMavenProjectIsMissing() {
        final EoCompileAction action = new EoCompileAction();
        action.actionPerformed(TestActionEvent.createTestEvent(action));
    }
}
