package org.eolang.jetbrains;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.fileTypes.FileNameMatcher;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import java.awt.*;
import javax.swing.*;

import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EOPluginController implements ProjectComponent {
  public static final String PLUGIN_ID = "org.eolang.jetbrains";
  public static final Logger LOG = Logger.getInstance("EOPluginController");

  public Project project;
  public boolean projectIsClosed = false;

  public EOPluginController(Project project) {
    this.project = project;
  }

  @Override
  public void projectClosed() {
    LOG.info("projectClosed " + project.getName());
    // synchronized ( shutdownLock ) { // They should be called from EDT only so no lock
    projectIsClosed = true;
    project = null;
  }

  @Override
  public void projectOpened() {
    LOG.info("Project opened");
  }

  @Override
  public void initComponent() {
    FileTypeManager fileTypeManager = FileTypeManager.getInstance();
    Runnable r1 = ()->fileTypeManager.removeAssociatedExtension(FileTypes.PLAIN_TEXT, "eo");
    Runnable r2 = ()->fileTypeManager.associateExtension(EOFileType.INSTANCE, "eo");
    WriteCommandAction.runWriteCommandAction(project, r1);
    WriteCommandAction.runWriteCommandAction(project, r2);
  }

  @Override
  public void disposeComponent() {}

  @NotNull
  @Override
  public String getComponentName() {
    return "eo.ProjectComponent";
  }
}
