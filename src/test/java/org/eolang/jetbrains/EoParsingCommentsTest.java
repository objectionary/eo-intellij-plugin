// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */
// @checkstyle PackageNameCheck (1 line)
package org.eolang.jetbrains;

import com.intellij.testFramework.ParsingTestCase;
import org.junit.Test;

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
    @Test
    public void testParsingTestData() {
        this.doTest(false);
    }

    /*
     * @checkstyle ProtectedMethodInFinalClassCheck (12 lines)
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData_2";
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
