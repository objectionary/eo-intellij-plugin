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
import org.junit.jupiter.api.Test;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;

/**
 * Unit tests for EoCompletionContributor using JUnit 5.
 * Verifies built-in and file-level completions.
 * @since 1.0
 */
@SuppressWarnings({"PMD.JUnit5TestShouldBePackagePrivate","PMD.JUnitTestContainsTooManyAsserts","PMD.ProhibitPlainJunitAssertionsRule"})
public final class EoCompletionContributorTest extends LightPlatformCodeInsightFixtureTestCase {

    /**
     * Sets up the IntelliJ fixture before each test.
     * @throws Exception on failure
     * @since 1.0
     */
    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Tears down the IntelliJ fixture after each test.
     * @throws Exception on failure
     * @since 1.0
     */
    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Ensures EO keywords and built-in objects are suggested.
     * @since 1.0
     */
    @Test
    public void suggestsKeywordsAndBuiltins() {
        myFixture.configureByText("test.eo", "<caret>");
        final LookupElement[] suggestions = myFixture.completeBasic();
        final List<String> names = extractNames(suggestions);
        assertContainsElements(
                names,
                "[args]", "@",
                "QQ.io.stdout", "QQ.txt.sprintf",
                "malloc.for", "seq", "while", "*"
        );
    }

    /**
     * Ensures top-level declarations in the file are suggested.
     * @since 1.0
     */
    @Test
    public void suggestsFileLevelDeclarations() {
        final String content = "[args] > foo \n" +
        "[args] > bar \n" +
        "<caret>";
        myFixture.configureByText("decl.eo", content);
        final LookupElement[] suggestions = myFixture.completeBasic();
        final List<String> names = extractNames(suggestions);
        assertContainsElements(names, "foo", "bar");
    }

    /**
     * Extracts lookup strings from completion items.
     * @param elements completion items
     * @return list of lookup strings
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
