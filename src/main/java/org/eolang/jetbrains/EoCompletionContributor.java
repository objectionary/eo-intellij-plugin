// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains;

import java.util.HashSet;
import java.util.Set;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 * Provides intelligent code completion in EO files
 * based on the official EO syntax and standard library.
 * <p>
 * Offers:
 * <ul>
 *   <li>EO keywords: <code>[args]</code>, <code>@</code></li>
 *   <li>Built-in abstract objects from the standard library:
 *       <code>QQ.io.stdout</code>, <code>QQ.txt.sprintf</code>,
 *       <code>malloc.for</code>, <code>seq</code>, <code>while</code>, <code>*</code>
 *   </li>
 *   <li>All top-level named elements declared directly in the .eo file</li>
 * </ul>
 * @since 1.0
 */
public final class EoCompletionContributor extends CompletionContributor {

    // @checkstyle AnonInnerLengthCheck (39 lines)
    public EoCompletionContributor() {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement()
                .inFile(PlatformPatterns.psiFile().withLanguage(EoLanguage.INSTANCE)),
            new CompletionProvider<CompletionParameters>() {
                @Override
                protected void addCompletions(
                    @NotNull CompletionParameters params,
                    @NotNull ProcessingContext ctx,
                    @NotNull CompletionResultSet result
                ) {
                    PsiFile file = params.getOriginalFile();
                    if (!file.getLanguage().isKindOf(EoLanguage.INSTANCE)) {
                        return;
                    }

                    result.addElement(LookupElementBuilder.create("[args]").withTypeText("keyword"));
                    result.addElement(LookupElementBuilder.create("@").withTypeText("keyword"));
                    result.addElement(LookupElementBuilder.create("QQ.io.stdout").withTypeText("builtin"));
                    result.addElement(LookupElementBuilder.create("QQ.txt.sprintf").withTypeText("builtin"));
                    result.addElement(LookupElementBuilder.create("malloc.for").withTypeText("builtin"));
                    result.addElement(LookupElementBuilder.create("seq").withTypeText("builtin"));
                    result.addElement(LookupElementBuilder.create("while").withTypeText("builtin"));
                    result.addElement(LookupElementBuilder.create("*").withTypeText("builtin"));
                    Set<String> seen = new HashSet<>();
                    for (PsiElement child : file.getChildren()) {
                        if (child instanceof PsiNamedElement) {
                            String name = ((PsiNamedElement) child).getName();
                            if (name != null && !name.isEmpty() && seen.add(name)) {
                                result.addElement(
                                    LookupElementBuilder.create(name)
                                        .withTypeText("object")
                                );
                            }
                        }
                    }
                }
            }
        );
    }
}
