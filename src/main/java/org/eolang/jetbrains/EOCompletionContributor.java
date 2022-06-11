// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed
// by the Apache 2.0 license that can be found in the LICENSE file.

package org.eolang.jetbrains;

import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class EOCompletionContributor extends CompletionContributor {
  public EOCompletionContributor() {
    extend(
        CompletionType.BASIC,
        PlatformPatterns.psiElement(),
        new CompletionProvider<CompletionParameters>() {
          @Override
          public void addCompletions(
              @NotNull CompletionParameters parameters,
              @NotNull ProcessingContext context,
              @NotNull CompletionResultSet resultSet) {
            System.out.println(context.getSharedContext());
          }
        });
  }
}
