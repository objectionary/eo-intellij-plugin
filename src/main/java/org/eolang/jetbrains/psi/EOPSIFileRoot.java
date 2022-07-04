/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eolang.jetbrains.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import javax.swing.*;
import org.antlr.intellij.adaptor.SymtabUtils;
import org.antlr.intellij.adaptor.psi.ScopeNode;
import org.eolang.jetbrains.EOFileType;
import org.eolang.jetbrains.EOLanguage;
import org.eolang.jetbrains.Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describing PSIFileRoot
 * @since 0.0.0
 */
public class EOPSIFileRoot extends PsiFileBase implements ScopeNode {
    public EOPSIFileRoot(@NotNull final FileViewProvider viewProvider) {
        super(viewProvider, EOLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return EOFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "EO Language file";
    }

    @Override
    public Icon getIcon(final int flags) {
        return Icons.EO_ICON;
    }

    /** Return null since a file scope has no enclosing scope. It is not itself in a scope. */
    @Override
    public ScopeNode getContext() {
        return null;
    }

    @Nullable
    @Override
    public PsiElement resolve(final PsiNamedElement element) {
        return SymtabUtils.resolve(this, EOLanguage.INSTANCE, element, "/script/vardef/ID");
    }
}
