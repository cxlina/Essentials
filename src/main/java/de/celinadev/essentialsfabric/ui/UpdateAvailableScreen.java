package de.celinadev.essentialsfabric.ui;

import de.celinadev.essentialsfabric.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Util;

import java.net.MalformedURLException;
import java.net.URL;

public class UpdateAvailableScreen extends Screen {

    private Screen prevScreen;

    public UpdateAvailableScreen(Text title, Screen prevScreen) {
        super(title);
        this.prevScreen = prevScreen;
    }

    @Override
    protected void init() {
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 154, this.height - 40, 100, 20, Text.of("Open Download-Page"), button -> {
            try {
                Util.getOperatingSystem().open(new URL("https://modrinth.com/mod/essentials/versions"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }));
        this.addDrawableChild(new ButtonWidget(this.width / 2 + 54, this.height - 40, 100, 20, Text.of("Ignore (§cNot Recommended§r)"), button -> {
            Main.getInstance().getOptions().ignoreUpdate = true;
            MinecraftClient.getInstance().setScreen(new TitleScreen(true));
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        super.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, "There's a new update available for the Mod \"Essentials\".", this.width / 2, 50, 0x00FF00);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 0xFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
