package net.mexicanminion.dndminecraft.util;


import net.mexicanminion.dndminecraft.command.AddPlayer;
import net.mexicanminion.dndminecraft.command.NextTurn;
import net.mexicanminion.dndminecraft.command.RollDiceCommand;
import net.mexicanminion.dndminecraft.command.StartGame;
import net.mexicanminion.dndminecraft.gui.CreateCharacterScreen;
import net.mexicanminion.dndminecraft.managers.GameTrackerManager;
import net.minecraft.client.MinecraftClient;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;
import org.quiltmc.qsl.lifecycle.api.event.ServerTickEvents;


public class ModRegistries {

	public static void registerModStuff() {
		registerCommands();
		registerEvents();
		//MinecraftClient.getInstance().setScreen(new CreateCharacterScreen());
	}

	private static void registerCommands(){

		CommandRegistrationCallback.EVENT.register(RollDiceCommand::register);
		CommandRegistrationCallback.EVENT.register(StartGame::register);
		CommandRegistrationCallback.EVENT.register(AddPlayer::register);
		CommandRegistrationCallback.EVENT.register(NextTurn::register);

	}

	private static void registerEvents(){
		ServerTickEvents.END.register(GameTrackerManager::updatePlayersMovement);
	}
}
