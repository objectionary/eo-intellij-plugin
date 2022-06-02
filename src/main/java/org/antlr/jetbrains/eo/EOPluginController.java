package org.antlr.jetbrains.eo;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EOPluginController implements ProjectComponent {
	public static final String PLUGIN_ID = "org.antlr.jetbrains.eo";
	public static final Logger LOG = Logger.getInstance("EOPluginController");

	public Project project;
	public boolean projectIsClosed = false;

	public EOPluginController(Project project) {
		this.project = project;
	}

	@Override
	public void projectClosed() {
		LOG.info("projectClosed " + project.getName());
		//synchronized ( shutdownLock ) { // They should be called from EDT only so no lock
		projectIsClosed = true;
		project = null;
	}

	@Override
	public void projectOpened() {
		IdeaPluginDescriptor plugin = PluginManager.getPlugin(PluginId.getId(PLUGIN_ID));
		String version = "unknown";
		if ( plugin!=null ) {
			version = plugin.getVersion();
		}
		LOG.info("EO 0.0.1 Plugin version "+version+", Java version "+ SystemInfo.JAVA_VERSION);
	}


	@Override
	public void initComponent() {
		// System.out.println("init component\n\n");
		/*try {
			System.out.println("\ntry\n");
			URL url = new URL("https://github.com/yasamprom/EO-intellij-plugin/blob/main/src/main/resources/org/antlr/jetbrains/eo/small_cactus2.png");
			System.out.println(url.getPort());
			Image image = ImageIO.read(url);
			if (image == null) {
				return;
			}
			System.out.println(image);
			Icons.EO_ICON = new ImageIcon(image);
		}
		catch (java.io.IOException e){
			System.out.println("\nfailed\n");
		}*/
	}

	@Override
	public void disposeComponent() { }

	@NotNull
	@Override
	public String getComponentName() {
		return "eo.ProjectComponent";
	}
}
