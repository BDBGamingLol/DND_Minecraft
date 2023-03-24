package net.mexicanminion.dndminecraft.util;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.mexicanminion.dndminecraft.command.RollDiceCommand;
import net.mexicanminion.dndminecraft.command.StartGame;
import net.mexicanminion.dndminecraft.managers.GameTrackerManager;
import net.minecraft.util.ActionResult;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;
import org.quiltmc.qsl.lifecycle.api.event.ServerTickEvents;

import static net.minecraft.server.command.CommandManager.*;

public class ModRegistries {

	public static void registerModStuff() {
		registerCommands();
		registerEvents();
	}

	private static void registerCommands(){

		CommandRegistrationCallback.EVENT.register(RollDiceCommand::register);
		CommandRegistrationCallback.EVENT.register(StartGame::register);

	}

	private static void registerEvents(){
		ServerTickEvents.END.register(GameTrackerManager::updatePlayersMovement);
	}
}
