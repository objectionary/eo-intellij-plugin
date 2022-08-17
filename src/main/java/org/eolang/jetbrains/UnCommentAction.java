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

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;

/**
 * Commenting action.
 * @since 0.0.5
 */
public class UnCommentAction extends AnAction {
    @Override
    public final void actionPerformed(final AnActionEvent event) {
        final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        final String text = editor.getSelectionModel().getSelectedText();
        if (text == null) {
            return;
        }
        final Project project = event.getRequiredData(CommonDataKeys.PROJECT);
        final Document document = editor.getDocument();
        final StringBuilder replacement = new StringBuilder();
        final String[] strings = text.split("\n");
        for (final String line : strings) {
            if (line.charAt(0) == '#') {
                replacement.append(line.substring(1)).append('\n');
            } else {
                replacement.append(line).append('\n');
            }
        }
        final Caret caret = editor.getCaretModel().getPrimaryCaret();
        final int start = caret.getSelectionStart();
        final int end = caret.getSelectionEnd();
        WriteCommandAction.runWriteCommandAction(
            project,
            () -> document.replaceString(start, end, replacement)
        );
        caret.removeSelection();
    }

    @Override
    public final boolean isDumbAware() {
        return false;
    }
}
