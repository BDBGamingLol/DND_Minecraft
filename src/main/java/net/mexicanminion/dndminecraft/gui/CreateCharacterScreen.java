package net.mexicanminion.dndminecraft.gui;

import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.base.BaseUIModelScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class CreateCharacterScreen extends BaseUIModelScreen<FlowLayout> {


	public CreateCharacterScreen() {
		super(FlowLayout.class, DataSource.file("create-character-screen.xml"));
		//super(FlowLayout.class, DataSource.asset(new Identifier("dndminecraft", "create-character-screen.xml")));
	}

	@Override
	protected void build(FlowLayout rootComponent) {
		/*rootComponent.surface(Surface.VANILLA_TRANSLUCENT)
				.horizontalAlignment(HorizontalAlignment.CENTER)
				.verticalAlignment(VerticalAlignment.CENTER);

		rootComponent.child(
				Containers.verticalFlow(Sizing.content(), Sizing.content())
						.child(Components.button(Text.literal("A Button"), (ButtonComponent button) -> {System.out.println("click"); }))
						.margins(Insets.of(10))
						.padding(Insets.of(10))
						.surface(Surface.DARK_PANEL)
						.verticalAlignment(VerticalAlignment.TOP)
						.horizontalAlignment(HorizontalAlignment.CENTER)
		);

		 */

	}
}


