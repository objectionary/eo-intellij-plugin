/*
 * @checkstyle MultiLineCommentCheck (95 lines)
 * @checkstyle MultilineJavadocTagsCheck (20 lines)
 * @checkstyle AvoidStarImportCheck (30 lines)
 * @checkstyle AvoidStaticImportCheck (30 lines)
 * @checkstyle ImportOrderCheck (30 lines)
 */

// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Pure-JUnit-5 tests for {@link EoCommenter}.
 * The EO language has one kind of comment:
 * • line comment prefix  -> "#"
 * It has NO block-comment syntax, so all block-comment related
 * methods are expected to return <code>null</code> and the
 * “requires full line selection” flag must be <code>false</code>.
 * @since 0.0.0
 */
@SuppressWarnings({"PMD.JUnit5TestShouldBePackagePrivate", "PMD.ProhibitPlainJunitAssertionsRule"})
public final class EoCommenterTest {

    /** System-under-test. Re-used in every test. */
    private final EoCommenter commenter = new EoCommenter();

    @Test
    void getLineCommentPrefixes() {
        assertEquals(
            "#",
            this.commenter.getLineCommentPrefix(),
            "EO must use '#' as its single line-comment prefix"
        );
    }

    @Test
    void blockCommentRequiresFullLineSelection() {
        assertFalse(
            this.commenter.blockCommentRequiresFullLineSelection(),
            "No block-comment => should not require full line selection"
        );
    }

    @Test
    void getLineCommentPrefix() {
        assertEquals(
            "#",
            this.commenter.getLineCommentPrefix(),
            "Line-comment prefix must be '#'"
        );
    }

    @Test
    void getBlockCommentPrefix() {
        assertEquals(
            "",
            this.commenter.getBlockCommentPrefix(),
            "EO defines no block-comment prefix"
        );
    }

    @Test
    void getBlockCommentSuffix() {
        assertNull(
            this.commenter.getBlockCommentSuffix(),
            "EO defines no block-comment suffix"
        );
    }

    @Test
    void getCommentedBlockCommentPrefix() {
        assertEquals(
            "",
            this.commenter.getCommentedBlockCommentPrefix(),
            "EO defines no *commented-block* prefix"
        );
    }

    @Test
    void getCommentedBlockCommentSuffix() {
        assertNull(
            this.commenter.getCommentedBlockCommentSuffix(),
            "EO defines no *commented-block* suffix"
        );
    }
}
