// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains;

// @checkstyle ImportOrderCheck (14 lines)

import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.ProcessingContext;

// @checkstyle MultilineJavadocTagsCheck (76 lines)
/**
 * Provides intelligent code completion in EO files
 * based on official EO syntax and standard library.
 * Offers keywords, built-in objects, and file-level declarations.
 * @since 1.0
 */
@SuppressWarnings({"PMD.ConstructorOnlyInitializesOrCallOtherConstructors",
    "PMD.AvoidDirectAccessToStaticFields"})
public final class EoCompletionContributor extends CompletionContributor {
    // @checkstyle JavadocVariableCheck (10 lines)

    private static final String KEYWORD = "keyword";

    private static final String BUILTIN = "builtin";

    private static final String OBJECT = "object";

    // @checkstyle AnonInnerLengthCheck (52 lines)
    private static final CompletionProvider<CompletionParameters> PROVIDER =
        new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(
                @NotNull final CompletionParameters params,
                @NotNull final ProcessingContext ctx,
                @NotNull final CompletionResultSet result
            ) {
                final PsiFile file = params.getOriginalFile();
                if (!file.getLanguage().isKindOf(EoLanguage.INSTANCE)) {
                    return;
                }
                result.addElement(
                    LookupElementBuilder.create("[args]").withTypeText(KEYWORD)
                );
                result.addElement(
                    LookupElementBuilder.create("@").withTypeText(KEYWORD)
                );
                result.addElement(
                    LookupElementBuilder.create("QQ.io.stdout").withTypeText(BUILTIN)
                );
                result.addElement(
                    LookupElementBuilder.create("QQ.txt.sprintf").withTypeText(BUILTIN)
                );
                result.addElement(
                    LookupElementBuilder.create("malloc.for").withTypeText(BUILTIN)
                );
                result.addElement(
                    LookupElementBuilder.create("seq").withTypeText(BUILTIN)
                );
                result.addElement(
                    LookupElementBuilder.create("while").withTypeText(BUILTIN)
                );
                result.addElement(
                    LookupElementBuilder.create("*").withTypeText(BUILTIN)
                );
                final Set<String> seen = new HashSet<>();
                for (final PsiElement child : file.getChildren()) {
                    if (child instanceof PsiNamedElement) {
                        final String name = ((PsiNamedElement) child).getName();
                        if (name != null && !name.isEmpty() && seen.add(name)) {
                            result.addElement(
                                LookupElementBuilder.create(name)
                                .withTypeText(OBJECT)
                            );
                        }
                    }
                }
            }
        };

    /**
     * Constructs the EO completion provider.
     */
    public EoCompletionContributor() {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement()
                .inFile(PlatformPatterns.psiFile().withLanguage(EoLanguage.INSTANCE)),
            PROVIDER
        );
    }
}
