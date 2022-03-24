package com.fredcom.camera.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fredcom.camera.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);


		config.width = 800;
		config.height = 600;
		config.resizable = false;
		config.title = "LES CAMERAS !!";
		config.vSyncEnabled = true;
	}
}
