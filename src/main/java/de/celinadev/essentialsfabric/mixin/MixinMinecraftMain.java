package de.celinadev.essentialsfabric.mixin;

import de.celinadev.essentialsfabric.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.main.Main.class)
public class MixinMinecraftMain {

    @Inject(method = "main", at = @At(value = "HEAD"))
    private static void essentials$preInit(CallbackInfo ci) {
        Main.getInstance().preInit();
    }
}
