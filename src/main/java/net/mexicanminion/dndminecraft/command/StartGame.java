package net.mexicanminion.dndminecraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mexicanminion.dndminecraft.managers.GameTrackerManager;
import net.mexicanminion.dndminecraft.util.DiceSystem;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.server.command.CommandManager.argument;

public class StartGame {

	static int amount;
	static DiceSystem diceSystem = new DiceSystem();

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandBuildContext commandBuildContext, CommandManager.RegistrationEnvironment registrationEnvironment) {
		dispatcher.register(CommandManager.literal("startgame")
				.executes(context -> run(context, context.getSource())));
	}

	private static int run(CommandContext<ServerCommandSource> contextScreen, ServerCommandSource context) throws CommandSyntaxException {

		GameTrackerManager.gameStarted = true;
		GameTrackerManager.setmainPlayerpos(context.getPlayer());
		contextScreen.getSource().sendFeedback(Text.literal("Game Start "), true);

		return 1;
	}
}
