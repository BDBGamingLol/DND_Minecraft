package net.mexicanminion.dndminecraft.managers;

import net.mexicanminion.dndminecraft.movement.MovementSpeed;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.quiltmc.qsl.networking.api.PlayerLookup;

import java.util.HashMap;


public class GameTrackerManager {

	public static HashMap<ServerPlayerEntity, Integer> playersTurn = new HashMap<ServerPlayerEntity, Integer>();
	public static HashMap<ServerPlayerEntity, MovementSpeed> playerMove = new HashMap<ServerPlayerEntity, MovementSpeed>();
	static int currTurn = 0;
	public static boolean gameStarted = false;

	public static void addPlayerToGame(ServerPlayerEntity player) {
		playersTurn.put(player, 0);
		playerMove.put(player, new MovementSpeed(10, player));
	}

	public static void setPlayersTurn(MinecraftServer server) {
		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
			if(!playersTurn.containsKey(player)) {
				addPlayerToGame(player);
				player.sendMessage(Text.literal("You have been added to the game"), false);
			}
		}
	}

	/*public static void setPlayersInGame(PlayerLookup playerLookup, MinecraftServer server) {
		for (ServerPlayerEntity player : playerLookup.all(server)) {
			addPlayerToGame(player);
		}
	}*/

	public static void updatePlayersMovement(MinecraftServer minecraftServer){
		if (!gameStarted) {
			setPlayersTurn(minecraftServer);
			return;
		}
		for (ServerPlayerEntity player : playersTurn.keySet()) {
			if(getPlayerTurn(player) == currTurn) {
				getPlayerMovementSpeed(player).checkMovement();
			}
		}
	}

	public static void setPlayerSpeed(ServerPlayerEntity player, int speed) {
		playerMove.get(player).setSpeed(speed);
	}

	public static int getPlayerTurn(ServerPlayerEntity player) {
		return playersTurn.get(player);
	}

	public static void setPlayerTurn(ServerPlayerEntity player, int turn) {
		playersTurn.put(player, turn);
	}

	public static void removePlayerFromGame(ServerPlayerEntity player) {
		playersTurn.remove(player);
	}

	public static boolean isPlayerInGame(ServerPlayerEntity player) {
		return playersTurn.containsKey(player);
	}

	public static MovementSpeed getPlayerMovementSpeed(ServerPlayerEntity player) {
		return playerMove.get(player);
	}

	public static void setPlayerMovementSpeed(ServerPlayerEntity player, MovementSpeed movementSpeed) {
		playerMove.put(player, movementSpeed);
	}

	public static void setmainPlayerpos(ServerPlayerEntity player) {
		playerMove.get(player).setMain(player.getPos());
	}

	public static void nextTurn() {
		currTurn++;
	}

}
