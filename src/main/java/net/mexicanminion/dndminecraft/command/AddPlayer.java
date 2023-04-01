package net.mexicanminion.dndminecraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mexicanminion.dndminecraft.managers.GameTrackerManager;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static net.minecraft.server.command.CommandManager.argument;

public class AddPlayer {

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandBuildContext commandBuildContext, CommandManager.RegistrationEnvironment registrationEnvironment) {
		dispatcher.register(CommandManager.literal("addplayer")
				.then(argument("speed", integer())
						.executes(context -> run(context, getInteger(context, "speed")))));
	}

	private static int run(CommandContext<ServerCommandSource> context, int speed) throws CommandSyntaxException {

		GameTrackerManager.addPlayerToGame(context.getSource().getPlayer(), speed);
		context.getSource().sendFeedback(Text.literal("You have been added "), true);

		return 1;
	}

}
