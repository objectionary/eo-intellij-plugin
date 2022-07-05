/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2022 Strunkov Stepan
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

// @checkstyle JavadocPackageCheck (1 lines)
package org.eolang.jetbrains.test;

import com.intellij.testFramework.ParsingTestCase;
import org.eolang.jetbrains.EoParserDefinition;
import org.junit.Test;

/**
 * Test class @ParsingTestCase.
 * @since 0.0.0
 */
public class EoParsingTest1 extends ParsingTestCase {

    /**
     * Parser initialization.
     */
    public EoParsingTest1() {
        super("", "eo", new EoParserDefinition());
    }

    // @checkstyle NonStaticMethodCheck (6 lines)
    /**
     * Setting checking result.
     */
    @Test
    public void testParsingTestData() {
        doTest(true);
    }

    @Override
    protected final String getTestDataPath() {
        return "src/test/testData_1";
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    @Override
    protected boolean skipSpaces() {
        return false;
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    @Override
    protected boolean includeRanges() {
        return true;
    }
}
