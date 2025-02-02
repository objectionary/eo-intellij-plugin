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
import org.eolang.jetbrains.EoFileType;
import org.junit.Test;

/**
 * Тесты для {@link org.eolang.jetbrains.EoCommenter}.
 * @since 0.0.5
 */
@SuppressWarnings("PMD.JUnit5TestShouldBePackagePrivate")
public final class EoCommenterTest extends BasePlatformTestCase {

    /**
     * Проверяет добавление и удаление однострочного комментария.
     */
    @Test
    public void testLineCommenter() {
        // Настройка текста с курсором в начале строки
        myFixture.configureByText(EoFileType.INSTANCE, "<caret>[] > main");

        // Создаем экземпляр действия для добавления/удаления комментариев
        final CommentByLineCommentAction action = new CommentByLineCommentAction();

        // Добавляем комментарий
        action.actionPerformedImpl(getProject(), myFixture.getEditor());
        myFixture.checkResult("#[] > main");

        // Удаляем комментарий
        action.actionPerformedImpl(getProject(), myFixture.getEditor());
        myFixture.checkResult("[] > main");
    }

    /**
     * Проверяет добавление и удаление однострочного комментария с отступом.
     */
    @Test
    public void testLineWithIndentCommenter() {
        // Настройка текста с отступом и курсором в начале строки
        myFixture.configureByText(EoFileType.INSTANCE, "  <caret>[] > main");

        // Создаем экземпляр действия для добавления/удаления комментариев
        final CommentByLineCommentAction action = new CommentByLineCommentAction();

        // Добавляем комментарий
        action.actionPerformedImpl(getProject(), myFixture.getEditor());
        myFixture.checkResult("#  [] > main");

        // Удаляем комментарий
        action.actionPerformedImpl(getProject(), myFixture.getEditor());
        myFixture.checkResult("  [] > main");
    }
}