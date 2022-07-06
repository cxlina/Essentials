package de.celinadev.essentialsfabric.mixin;

import de.celinadev.essentialsfabric.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.CompletableFuture;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Shadow
    @Final
    public GameOptions options;

    @Inject(method = "reloadResources(Z)Ljava/util/concurrent/CompletableFuture;", at = @At("TAIL"))
    public void essentials$unpressButtons(boolean force, CallbackInfoReturnable<CompletableFuture<Void>> cir) {
        if (!Main.getInstance().getOptions().fixResourceReloadExploit) return;
        for (KeyBinding keyBinding : this.options.allKeys) {
            if (keyBinding.isPressed()) {
                keyBinding.setPressed(false);
            }
        }
    }
}
