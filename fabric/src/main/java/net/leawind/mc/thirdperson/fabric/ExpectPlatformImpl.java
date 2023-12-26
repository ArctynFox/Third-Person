package net.leawind.mc.thirdperson.fabric;


import net.fabricmc.loader.api.FabricLoader;
import net.leawind.mc.thirdperson.ExpectPlatform;

import java.nio.file.Path;

public class ExpectPlatformImpl {
	/**
	 * This is our actual method to {@link ExpectPlatform#getConfigDirectory()}.
	 */
	public static Path getConfigDirectory () {
		return FabricLoader.getInstance().getConfigDir();
	}
}
