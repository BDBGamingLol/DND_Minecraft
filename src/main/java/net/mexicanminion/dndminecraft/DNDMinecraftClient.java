package net.mexicanminion.dndminecraft;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.mexicanminion.dndminecraft.gui.CreateCharacterScreen;
import net.mexicanminion.dndminecraft.util.ScreenRegistries;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import net.minecraft.client.option.KeyBind;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;



public class DNDMinecraftClient implements ClientModInitializer{

	private static final KeyBind BEGIN = new KeyBind("key.owo-ui-academy.begin", GLFW.GLFW_KEY_H, "key.categories.misc");

	@Override
	public void onInitializeClient(ModContainer mod) {
		// TODO Auto-generated method stub
		DNDMinecraft.LOGGER.info("Javier M", mod.metadata().name());
		ScreenRegistries.registerScreens();

		KeyBindingHelper.registerKeyBinding(BEGIN);
		ClientTickEvents.END.register(client -> {
			while (BEGIN.wasPressed()) {
				client.setScreen(new CreateCharacterScreen());
			}
		});

	}
}
