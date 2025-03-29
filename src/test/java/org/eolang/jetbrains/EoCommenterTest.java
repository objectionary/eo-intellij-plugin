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
