package org.antlr.jetbrains.adaptor.test;

import com.intellij.testFramework.ParsingTestCase;
import org.antlr.jetbrains.eo.EOParserDefinition;

public class EOParsingTest extends ParsingTestCase {

    public EOParsingTest() {
        super("", "eo", new EOParserDefinition());
    }

    public void testParsingTestData() {
        doTest(true);
    }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
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