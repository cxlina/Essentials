package de.celinadev.essentialsfabric.mixin;

import de.celinadev.essentialsfabric.Main;
import de.celinadev.essentialsfabric.ui.UpdateAvailableScreen;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen extends Screen {

    private String latest = FabricLoader.getInstance().getModContainer("essentials").get().getMetadata().getVersion().getFriendlyString();

    protected MixinTitleScreen(Text title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    public void essentials$notifyUpdate(CallbackInfo ci) {
        if (!Main.getInstance().getOptions().ignoreUpdate) {
            try {
                URL url = new URL("https://raw.githubusercontent.com/cxlina/HTTP/main/essentials_version.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader((InputStream) url.openConnection().getContent()));
                latest = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
            if (!this.latest.equals(FabricLoader.getInstance().getModContainer("essentials").get().getMetadata().getVersion().getFriendlyString())) {
                MinecraftClient.getInstance().setScreen(new UpdateAvailableScreen(Text.of("Update Available!"), (TitleScreen) (Object) this));
            }
        }
    }
}
