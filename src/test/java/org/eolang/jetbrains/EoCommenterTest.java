// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains;

import com.intellij.codeInsight.generation.actions.CommentByLineCommentAction;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.junit.Test;

/**
 * Tests for {@link org.eolang.jetbrains.EoCommenter}.
 * @since 0.0.5
 */
@SuppressWarnings("PMD.JUnit5TestShouldBePackagePrivate")
public final class EoCommenterTest extends BasePlatformTestCase {
    /**
     * Test addition and deletion of single-line comment.
     */
    @Test
    public void testLineCommenter() {
        myFixture.configureByText(EoFileType.INSTANCE, "<caret>[] > main");
        final CommentByLineCommentAction action = new CommentByLineCommentAction();
        action.actionPerformedImpl(getProject(), myFixture.getEditor());
        myFixture.checkResult("#[] > main");
        action.actionPerformedImpl(getProject(), myFixture.getEditor());
        myFixture.checkResult("[] > main");
    }

    /**
     * Checks for the addition and removal of a single-line indented comment.
     */
    @Test
    public void testLineWithIndentCommenter() {
        myFixture.configureByText(EoFileType.INSTANCE, "  <caret>[] > main");
        final CommentByLineCommentAction action = new CommentByLineCommentAction();
        action.actionPerformedImpl(getProject(), myFixture.getEditor());
        myFixture.checkResult("#  [] > main");
        action.actionPerformedImpl(getProject(), myFixture.getEditor());
        myFixture.checkResult("  [] > main");
    }
}
