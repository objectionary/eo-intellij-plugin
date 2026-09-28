/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.openapi.util.IconLoader;
import javax.swing.Icon;

/**
 * Class for getting icons.
 *
 * @since 0.0.0
 */
public final class Icons {

    /**
     * Icon.
     */
    public static final Icon EO_ICON = IconLoader.getIcon("/org/eolang/jetbrains/cactus-16svg.svg");

    /**
     * Ctor.
     */
    private Icons() {
    }
}
