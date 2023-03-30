package net.mexicanminion.dndminecraft.util;

import net.mexicanminion.dndminecraft.command.*;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;

public class ScreenRegistries {

	public static void registerScreens() {
		registerCommands();
	}

	private static void registerCommands(){

		CommandRegistrationCallback.EVENT.register(OpenCCS::register);

	}
}
