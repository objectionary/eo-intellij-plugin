// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.testFramework.ParsingTestCase;
import org.junit.Test;

/**
 * Test class @ParsingTestCase.
 * @since 0.0.0
 */
@SuppressWarnings("PMD.JUnit5TestShouldBePackagePrivate")
public final class EoParsingTest extends ParsingTestCase {

    /**
     * Parser initialization.
     */
    public EoParsingTest() {
        super("", "eo", new EoParserDefinition());
    }

    // @checkstyle NonStaticMethodCheck (6 lines)
    /**
     * Setting checking result.
     *
     * @todo #30:30min Enable the tests. Since new grammar was added to eolang
     *  need to update antlr4 grammar, remake and refactor parsing tests. Don't
     *  forget to get codecov coverage level up before resolving this task.
      */
    @Test
    public void testParsingTestData() {
        doTest(false);
    }

    // @checkstyle ProtectedMethodInFinalClassCheck (12 lines)
    @Override
    protected String getTestDataPath() {
        return "src/test/testData_1";
    }

    // @checkstyle DesignForExtensionCheck (5 lines)
    @Override
    protected boolean skipSpaces() {
        return false;
    }

    // @checkstyle DesignForExtensionCheck (5 lines)
    // @checkstyle ProtectedMethodInFinalClassCheck (5 lines)
    @Override
    protected boolean includeRanges() {
        return true;
    }
}
