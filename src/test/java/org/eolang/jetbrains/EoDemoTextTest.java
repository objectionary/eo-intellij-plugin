/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.testFramework.ParsingTestCase;
import java.util.Collection;
import org.junit.Test;

/**
 * Test that the demo text of the color settings page is valid EO.
 *
 * @since 0.0.0
 * @checkstyle ProhibitTestMethodNameCheck (50 lines)
 */
@SuppressWarnings({"PMD.WrongTestAnnotation", "PMD.UnitTestShouldIncludeAssert"})
public final class EoDemoTextTest extends ParsingTestCase {

    /**
     * Parser initialization.
     */
    public EoDemoTextTest() {
        super("", "eo", new EoParserDefinition());
    }

    /**
     * The demo text must parse without errors.
     */
    @Test
    public void testDemoTextHasNoSyntaxErrors() {
        final PsiFile file = this.createPsiFile(
            "demo", new EoColorSettingsPage().getDemoText()
        );
        final Collection<PsiErrorElement> errors = PsiTreeUtil.collectElementsOfType(
            file, PsiErrorElement.class
        );
        assertTrue(
            String.format("Demo text has syntax errors: %s", errors),
            errors.isEmpty()
        );
    }

    // @checkstyle ProtectedMethodInFinalClassCheck (5 lines)
    @Override
    protected String getTestDataPath() {
        return "src/test/testData_1";
    }
}
