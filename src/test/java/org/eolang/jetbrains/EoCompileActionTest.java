// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for EoCompileAction helper methods.
 * Test class @EoCompileActionTest.
 * @since 0.0.1
 */
public final class EoCompileActionTest {

    @SuppressWarnings("PMD.ProhibitPlainJunitAssertionsRule")
    @Test
    public void buildGoalsAllPhases() {
        final List<String> goals = EoCompileAction.buildGoals("0.56.0");
        final String[] expected = {
            "org.eolang:eo-maven-plugin:0.56.0:register",
            "org.eolang:eo-maven-plugin:0.56.0:transpile",
            "org.eolang:eo-maven-plugin:0.56.0:assemble",
        };
        Assert.assertArrayEquals(
            "Goals should match expected sequence",
            expected,
            goals.toArray(new String[0])
        );
    }
}
