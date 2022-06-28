package org.eolang.jetbrains.test;

import com.intellij.testFramework.ParsingTestCase;
import org.eolang.jetbrains.EOParserDefinition;

public class EOParsingTestComments extends ParsingTestCase {

  public EOParsingTestComments() {
    super("", "eo", new EOParserDefinition());
  }

  public void testParsingTestData() {
    doTest(true);
  }

  /** @return path to test data file directory relative to root of this module. */
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