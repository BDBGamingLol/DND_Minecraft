package net.mexicanminion.dndminecraft.command;

import static net.minecraft.server.command.CommandManager.*;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mexicanminion.dndminecraft.util.DiceSystem;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.argument;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;
import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;


public class RollDiceCommand{

	static DiceSystem diceSystem = new DiceSystem();

	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandBuildContext commandBuildContext, RegistrationEnvironment registrationEnvironment) {
		dispatcher.register(CommandManager.literal("rolldice")
				.then(argument("amount", integer(1, 100))
						.then(argument("dice", integer(4, 100))
								.executes(context -> run(context, context.getSource(), getInteger(context, "amount"), getInteger(context, "dice"))))));
	}

	private static int run(CommandContext<ServerCommandSource> contextScreen, ServerCommandSource context, int amount, int dice) throws CommandSyntaxException {

		int temp = diceSystem.rollDice(amount, dice);

		contextScreen.getSource().sendFeedback(Text.literal("You rolled " + amount + " D" + dice + "'s that totaled "+ temp), true);

		return 1;
	}
}
