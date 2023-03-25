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
	static int currTurn = 1;
	static int playerCount = 0;
	public static boolean gameStarted = false;

	public static void updatePlayersMovement(MinecraftServer server){
		if (!gameStarted) {
			return;
		}
		for (ServerPlayerEntity player : playersTurn.keySet()) {
			if(getPlayerTurn(player) == currTurn) {
				getPlayerMovementSpeed(player).checkMovement();
			}else {
				getPlayerMovementSpeed(player).resetMovement();
			}
		}
	}

	public static void startGame(MinecraftServer server) {
		if (playerCount == 0) {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				player.sendMessage(Text.literal("No players in game, could not start"), false);
			}
			return;
		}
		gameStarted = true;
		setmainPlayerPosServerWide(server);
	}

	public static void addPlayerToGame(ServerPlayerEntity player, int turn, int speed) {
		playersTurn.put(player, turn);
		playerMove.put(player, new MovementSpeed(speed, player));
	}

	public static void addPlayerToGame(ServerPlayerEntity player,int speed) {
		if(!playersTurn.containsKey(player)) {
			playerCount++;
			addPlayerToGame(player, playerCount, speed);
			player.sendMessage(Text.literal("You have been added to the game"), false);
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
		playerMove.remove(player);
		playerCount--;
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
		playerMove.get(player).setMain(player.getBlockPos());
	}

	public static void setmainPlayerPosServerWide(MinecraftServer server) {
		for (ServerPlayerEntity player : PlayerLookup.all(server)) {
			setmainPlayerpos(player);
			getPlayerMovementSpeed(player).resetMovement();
		}
	}

	public static void nextTurn() {
		currTurn++;
		if (currTurn > playerCount) {
			currTurn = 1;
		}
	}

	public static int getCurrTurn() {
		return currTurn;
	}

	public static void endGame(MinecraftServer server) {
		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
			player.sendMessage(Text.literal("Game has ended"), false);
		}
		gameStarted = false;
	}

}
