package net.mexicanminion.dndminecraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mexicanminion.dndminecraft.managers.GameTrackerManager;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;


public class NextTurn {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandBuildContext commandBuildContext, CommandManager.RegistrationEnvironment registrationEnvironment) {
		dispatcher.register(CommandManager.literal("nextturn")
				.executes(context -> run(context)));
	}

	private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {

		GameTrackerManager.nextTurn();
		context.getSource().sendFeedback(Text.literal("Turn: " + GameTrackerManager.getCurrTurn()), true);

		return 1;
	}
}
