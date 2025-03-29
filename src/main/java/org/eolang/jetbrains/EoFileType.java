// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */

package org.eolang.jetbrains;

import com.intellij.openapi.fileTypes.LanguageFileType;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;

/**
 * Description of EO language files.
 * @since 0.0.0
 */
public class EoFileType extends LanguageFileType {
    /**
     * Define EO language file extension.
     */
    public static final String FILE_EXTENSION = "eo";

    /**
     * Creating instance of class.
     */
    public static final EoFileType INSTANCE = new EoFileType();

    /**
     * Call constructor of super class.
     */
    protected EoFileType() {
        super(EoLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public final String getName() {
        return "EO";
    }

    @NotNull
    @Override
    public final String getDescription() {
        return "EO";
    }

    @NotNull
    @Override
    public final String getDefaultExtension() {
        return EoFileType.FILE_EXTENSION;
    }

    @Override
    public final Icon getIcon() {
        return Icons.EO_ICON;
    }
}
