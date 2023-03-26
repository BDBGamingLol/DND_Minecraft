package net.mexicanminion.dndminecraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mexicanminion.dndminecraft.managers.GameTrackerManager;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;


public class StartGame {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandBuildContext commandBuildContext, CommandManager.RegistrationEnvironment registrationEnvironment) {
		dispatcher.register(CommandManager.literal("startgame")
				.executes(context -> run(context, context.getSource())));
	}

	private static int run(CommandContext<ServerCommandSource> contextScreen, ServerCommandSource context) throws CommandSyntaxException {

		GameTrackerManager.startGame(context.getServer());

		return 1;
	}
}
