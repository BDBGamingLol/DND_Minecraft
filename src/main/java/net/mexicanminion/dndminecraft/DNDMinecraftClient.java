package net.mexicanminion.dndminecraft;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class DNDMinecraftClient implements ClientModInitializer{

	@Override
	public void onInitializeClient(ModContainer mod) {
		// TODO Auto-generated method stub
		DNDMinecraft.LOGGER.info("Javier M", mod.metadata().name());
	}
}
