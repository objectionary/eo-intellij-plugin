/*
 * @checkstyle MultiLineCommentCheck (95 lines)
 * @checkstyle MultilineJavadocTagsCheck (20 lines)
 */

// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.ProcessingContext;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

/**
 * Unit tests for {@link EoCompletionContributor}.
 * @since 0.0.0
 */
@SuppressWarnings("PMD.AvoidAccessibilityAlteration")
final class EoCompletionContributorTest {

    @Test
    void constructorDoesNotThrow() {
        Assertions.assertDoesNotThrow(
            EoCompletionContributor::new
        );
    }

    @Test
    void addCompletionsDoesNothingIfNotEoFile() throws Exception {
        final PsiFile mockfile = Mockito.mock(
            PsiFile.class
        );
        Mockito.when(
            mockfile.getLanguage()
        ).thenReturn(
            Mockito.mock(
                com.intellij.lang.Language.class
            )
        );
        final CompletionParameters params = Mockito.mock(
            CompletionParameters.class
        );
        Mockito.when(
            params.getOriginalFile()
        ).thenReturn(
            mockfile
        );
        final CompletionResultSet resultset = Mockito.mock(
            CompletionResultSet.class
        );
        final Field provfield = EoCompletionContributor.class.getDeclaredField(
            "PROVIDER"
        );
        provfield.setAccessible(
            true
        );
        @SuppressWarnings(
            "unchecked"
        )
        final CompletionProvider<CompletionParameters> provider =
            (
                CompletionProvider<CompletionParameters>
            ) provfield.get(
                null
            );
        provider.addCompletionVariants(
            params,
            new ProcessingContext(),
            resultset
        );
        Mockito.verify(
            resultset,
            Mockito.never()
        ).addElement(
            Mockito.any(
                LookupElement.class
            )
        );
    }

    @Test
    void addCompletionsAddsKeywordsBuiltinsAndNamedChildren() throws Exception {
        final PsiFile mockfile = Mockito.mock(
            PsiFile.class
        );
        Mockito.when(
            mockfile.getLanguage()
        ).thenReturn(
            EoLanguage.INSTANCE
        );
        final PsiNamedElement namedchild = Mockito.mock(
            PsiNamedElement.class
        );
        Mockito.when(
            namedchild.getName()
        ).thenReturn(
            "myCustom"
        );
        final PsiElement unnamed = Mockito.mock(
            PsiElement.class
        );
        final PsiElement[] children = {
            namedchild,
            unnamed,
            namedchild,
        };
        Mockito.when(
            mockfile.getChildren()
        ).thenReturn(
            children
        );
        final CompletionParameters params = Mockito.mock(
            CompletionParameters.class
        );
        Mockito.when(
            params.getOriginalFile()
        ).thenReturn(
            mockfile
        );
        final CompletionResultSet resultset = Mockito.mock(
            CompletionResultSet.class
        );
        final ArgumentCaptor<LookupElement> captor = ArgumentCaptor.forClass(
            LookupElement.class
        );
        final Field providerfld = EoCompletionContributor.class.getDeclaredField(
            "PROVIDER"
        );
        providerfld.setAccessible(
            true
        );
        @SuppressWarnings("unchecked")
        final CompletionProvider<CompletionParameters> provider =
            (
                CompletionProvider<CompletionParameters>
            ) providerfld.get(
                null
            );
        provider.addCompletionVariants(
            params,
            new ProcessingContext(),
            resultset
        );
        Mockito.verify(
            resultset,
            Mockito.atLeastOnce()
        ).addElement(
            captor.capture()
        );
        final int totaladd = captor.getAllValues().size();
        Assertions.assertEquals(
            9,
            totaladd,
            "Must be 9 unique endings."
        );
        final Set<String> addedstr = new HashSet<>();
        for (
            final LookupElement lookel
                :
            captor.getAllValues()
        ) {
            addedstr.add(
                lookel.getLookupString()
            );
        }
        Assertions.assertTrue(addedstr.contains("[args]"), "\"[args]\" must be in suggestion");
        Assertions.assertTrue(addedstr.contains("@"), "\"@\" must be in suggestion");
        Assertions.assertTrue(addedstr.contains("myCustom"), "\"myCustom\" must be in suggestion");
    }
}
