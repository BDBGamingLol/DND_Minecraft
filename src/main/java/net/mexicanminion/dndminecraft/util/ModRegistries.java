package net.mexicanminion.dndminecraft.util;

import net.mexicanminion.dndminecraft.command.RollDiceCommand;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;

import static net.minecraft.server.command.CommandManager.*;

public class ModRegistries {

	public static void registerModStuff() {
		registerCommands();
	}

	private static void registerCommands(){

		CommandRegistrationCallback.EVENT.register(RollDiceCommand::register);

	}
}
