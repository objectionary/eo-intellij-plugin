/*
 * The MIT License (MIT)
 *
 *
 *
 * Copyright (c) 2021-2022 Stepan Strunkov
 *
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 *
 * of this software and associated documentation files (the "Software"), to deal
 *
 * in the Software without restriction, including without limitation the rights
 *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *
 * copies of the Software, and to permit persons to whom the Software is
 *
 * furnished to do so, subject to the following conditions:
 *
 *
 *
 * The above copyright notice and this permission notice shall be included
 *
 * in all copies or substantial portions of the Software.
 *
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *
 * SOFTWARE.
 */

package org.eolang.jetbrains.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import javax.swing.Icon;
import org.antlr.intellij.adaptor.SymtabUtils;
import org.antlr.intellij.adaptor.psi.ScopeNode;
import org.eolang.jetbrains.EoFileType;
import org.eolang.jetbrains.EoLanguage;
import org.eolang.jetbrains.Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Describing PSIFileRoot.
 * @since 0.0.0
 */
public class EoPsiFileRoot extends PsiFileBase implements ScopeNode {
    /**
     * Definition of PsiFileRoot.
     * @param viewprovider FileViewProvider
     */
    public EoPsiFileRoot(@NotNull final FileViewProvider viewprovider) {
        super(viewprovider, EoLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public final FileType getFileType() {
        return EoFileType.INSTANCE;
    }

    @Override
    public final String toString() {
        return "EO Language file";
    }

    @Override
    public final Icon getIcon(final int flags) {
        return Icons.EO_ICON;
    }

    // Return null since a file scope has no enclosing scope. It is not itself in a scope.
    @Override
    public final ScopeNode getContext() {
        return null;
    }

    @Nullable
    @Override
    public final PsiElement resolve(final PsiNamedElement element) {
        return SymtabUtils.resolve(this, EoLanguage.INSTANCE, element, "/script/vardef/ID");
    }
}
