// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.lang.Language;

/**
 * Language Definition.
 * @since 0.0.0
 */
public final class EoLanguage extends Language {
    /**
     * Creating instance.
     */
    public static final EoLanguage INSTANCE = new EoLanguage();

    /**
     * Constructor.
     */
    private EoLanguage() {
        super("EO");
    }
}
