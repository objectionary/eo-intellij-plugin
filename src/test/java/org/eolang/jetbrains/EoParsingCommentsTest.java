/*
 * The MIT License (MIT)
 *
 *
 *
 * Copyright (c) 2021-2022 Stepan Strunkov
 *
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 *
 * of this software and associated documentation files (the "Software"), to deal
 *
 * in the Software without restriction, including without limitation the rights
 *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *
 * copies of the Software, and to permit persons to whom the Software is
 *
 * furnished to do so, subject to the following conditions:
 *
 *
 *
 * The above copyright notice and this permission notice shall be included
 *
 * in all copies or substantial portions of the Software.
 *
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *
 * SOFTWARE.
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

    @Override
    protected String getTestDataPath() {
        return "src/integrationTest/testData_2";
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
