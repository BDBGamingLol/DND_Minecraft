package net.mexicanminion.dndminecraft;

import net.mexicanminion.dndminecraft.gui.CreateCharacterScreen;
import net.minecraft.client.MinecraftClient;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class DNDMinecraftClient implements ClientModInitializer{

	@Override
	public void onInitializeClient(ModContainer mod) {
		// TODO Auto-generated method stub
		DNDMinecraft.LOGGER.info("Javier M", mod.metadata().name());
		MinecraftClient.getInstance().setScreen(new CreateCharacterScreen());

	}
}
