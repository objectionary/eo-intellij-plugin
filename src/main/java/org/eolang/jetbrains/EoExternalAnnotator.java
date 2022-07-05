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

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.ExternalAnnotator;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * An external annotator is an object that analyzes code in a document and annotates the PSI
 * elements with errors or warnings. Because such analysis can be expensive, we don't want it in the
 * GUI event loop. Jetbrains provides this external annotator mechanism to run these analyzers out
 * of band.
 * @since 0.0.0
 */
public class EoExternalAnnotator
    extends ExternalAnnotator<PsiFile, List<EoExternalAnnotator.Issue>> {
    // NOTE: can't use instance vars as only 1 instance

    /**
     * Issue report.
     * @since 0.0.0
     */
    public static class Issue {

        /**
         * Message.
         */
        private final String msg;

        /**
         * Node.
         */
        private final PsiElement offendingNode;

        /**
         * Issue init.
         * @param msg String
         * @param node PsiElement
         */
        public Issue(final String msg, final PsiElement node) {
            this.msg = msg;
            this.offendingNode = node;
        }
        /**
         * Accessor.
         * @return String message
         */
        final String getMsg() {
            return this.msg;
        }

        /**
         * Accessor.
         * @return Offending node
         */
        final PsiElement getOffendingNode() {
            return this.offendingNode;
        }
    }

    // Called first; in our case, just return file and do nothing.
    @Override
    @Nullable
    public final PsiFile collectInformation(@NotNull final PsiFile file) {
        return file;
    }

    /*
     * Called 2nd; look for trouble in file and return list of issues.
     *
     * <p>For most custom languages, you would not reimplement your semantic analyzer using PSI trees.
     * Instead, here is where you would call out to your custom languages compiler or interpreter to
     * get error messages or other bits of information you'd like to annotate the document with.
     */

    @Override
    public final List<Issue> doAnnotate(final PsiFile file) {
        return new ArrayList<>();
    }

    // Called 3rd to actually annotate the editor window.
    @Override
    public final void apply(@NotNull final PsiFile file, final List<Issue> issues,
        @NotNull final AnnotationHolder holder) {
        for (final Issue issue : issues) {
            final TextRange range = issue.getOffendingNode().getTextRange();
            holder.createErrorAnnotation(range, issue.getMsg());
        }
    }
}
