package org.eolang.jetbrains.structview;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import org.eolang.jetbrains.psi.EOPSIFileRoot;
import org.jetbrains.annotations.NotNull;

public class EOStructureViewModel extends StructureViewModelBase
    implements StructureViewModel.ElementInfoProvider {
  public EOStructureViewModel(EOPSIFileRoot root) {
    super(root, new EOStructureViewRootElement(root));
  }

  @NotNull
  public Sorter[] getSorters() {
    return new Sorter[] {Sorter.ALPHA_SORTER};
  }

  @Override
  public boolean isAlwaysLeaf(StructureViewTreeElement element) {
    return !isAlwaysShowsPlus(element);
  }

  @Override
  public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
    Object value = element.getValue();
    return value instanceof EOPSIFileRoot;
  }
}
