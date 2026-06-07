/*
 * @checkstyle MultiLineCommentCheck (54 lines)
 * @checkstyle MultilineJavadocTagsCheck (8 lines)
 */
// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */
// @checkstyle PackageNameCheck (1 line)
package org.eolang.jetbrains;

import com.intellij.testFramework.ParsingTestCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test class @ParsingTestCase.
 * @since 0.0.0
 */
@SuppressWarnings("PMD.JUnit5TestShouldBePackagePrivate")
public final class EoParsingCommentsTest extends ParsingTestCase {

    /**
     * Parser initialization.
     */
    public EoParsingCommentsTest() {
        super("", "eo", new EoParserDefinition());
    }

    /**
     * Setting checking result.
     */
    @Disabled
    @Test
    public void testParsingTestData() {
        this.doTest(true);
    }

    /*
     * @checkstyle ProtectedMethodInFinalClassCheck (17 lines)
     * @checkstyle StringLiteralsConcatenationCheck (10 lines)
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData_2/";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}
