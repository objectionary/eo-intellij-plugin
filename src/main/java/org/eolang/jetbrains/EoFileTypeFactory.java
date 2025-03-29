// SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
// SPDX-License-Identifier: MIT

/*
 * SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
 * SPDX-License-Identifier: MIT
 */
package org.eolang.jetbrains;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * Class for definition of FileType.
 * @since 0.0.0
 * @checkstyle ParameterNameCheck (100 lines)
 */
public class EoFileTypeFactory extends FileTypeFactory {
    @Override
    public final void createFileTypes(@NotNull final FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(EoFileType.INSTANCE, EoFileType.FILE_EXTENSION);
    }
}
