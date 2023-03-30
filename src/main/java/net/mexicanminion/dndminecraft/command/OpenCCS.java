package net.mexicanminion.dndminecraft.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.mexicanminion.dndminecraft.gui.CreateCharacterScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandBuildContext;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;



public class OpenCCS {


	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandBuildContext commandBuildContext, CommandManager.RegistrationEnvironment registrationEnvironment) {
		dispatcher.register(CommandManager.literal("createcharacter")
				.executes(context -> run(context)));
	}

	private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {

		MinecraftClient.getInstance().setScreen(new CreateCharacterScreen());

		return 1;
	}
}
