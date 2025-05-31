/*
 * @checkstyle MultiLineCommentCheck (95 lines)
 * @checkstyle MultilineJavadocTagsCheck (50 lines)
 */

// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import javax.swing.Icon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 test for {@link Icons}.
 * @since 0.0.0
 */
final class IconsTest {
    @Test
    void eoIconShouldBeLoaded() {
        final Icons icons = new Icons();
        final Icon icon = icons.EO_ICON;
        Assertions.assertNotNull(icon, "EO_ICON must be loaded and not be null");
    }
}
