/*
 * @checkstyle MultiLineCommentCheck (95 lines)
 * @checkstyle MultilineJavadocTagsCheck (8 lines)
 */
// SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 George Osenchakov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains;

// @checkstyle ImportOrderCheck (14 lines)

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;

/**
 * @checkstyle MultiLineCommentCheck(85 lines)
 * Unit tests for EoCompletionContributor using JUnit 5.
 * Verifies built-in and file-level completions.
 * @since 1.0
 */
@SuppressWarnings({"PMD.JUnit5TestShouldBePackagePrivate",
    "PMD.JUnitTestContainsTooManyAsserts",
    "PMD.ProhibitPlainJunitAssertionsRule"})
@Disabled("Skipping heavy UI fixture tests for completion contributor")
public final class EoCompletionContributorTest extends LightPlatformCodeInsightFixtureTestCase {

    // @checkstyle ProtectedMethodInFinalClassCheck (12 lines)
    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Ensures top-level declarations in the file are suggested.
     * @since 1.0
     */
    // @checkstyle StringLiteralsConcatenationCheck (10 lines)
    // @checkstyle MethodsOrderCheck (27 lines)
    @Test
    public void suggestsFileLevelDeclarations() {
        final String content = "[args] > foo \n"
            + "[args] > bar \n"
            + "<caret>";
        myFixture.configureByText("decl.eo", content);
        final LookupElement[] suggestions = myFixture.completeBasic();
        final List<String> names = this.extractNames(suggestions);
        assertContainsElements(names, "foo", "bar");
    }

    /**
     * Ensures EO keywords and built-in objects are suggested.
     * @since 1.0
     */
    @Test
    public void suggestsKeywordsAndBuiltins() {
        myFixture.configureByText("test.eo", "<caret>");
        final LookupElement[] suggestions = myFixture.completeBasic();
        final List<String> names = this.extractNames(suggestions);
        assertContainsElements(
            names,
            "[args]", "@",
            "QQ.io.stdout", "QQ.txt.sprintf",
            "malloc.for", "seq", "while", "*"
        );
    }

    /**
     * Extracts lookup strings from completion items.
     * @param elements Completion items
     * @return List of lookup strings
     * @since 1.0
     */
    private List<String> extractNames(@NotNull final LookupElement... elements) {
        final List<String> result = new ArrayList<>(elements.length);
        for (@NotNull final LookupElement item : elements) {
            result.add(item.getLookupString());
        }
        return result;
    }
}
