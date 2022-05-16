package org.antlr.jetbrains.eo.structview;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class EOStructureViewRootElement extends EOStructureViewElement {
	public EOStructureViewRootElement(PsiFile element) {
		super(element);
	}

	@NotNull
	@Override
	public ItemPresentation getPresentation() {
		return new EORootPresentation((PsiFile)element);
	}
}
