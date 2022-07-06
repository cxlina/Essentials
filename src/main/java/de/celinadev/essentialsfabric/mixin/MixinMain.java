package de.celinadev.essentialsfabric.mixin;

import de.celinadev.essentialsfabric.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.main.Main.class)
public class MixinMain {

    @Inject(method = "main", at = @At("HEAD"))
    private static void essentials$preInit(String[] args, CallbackInfo ci) {
        //This is only initialized that early, because some fixes need to be applied that early as well. For this, the Configuration needs to be initialized before that.
        Main.getInstance().preInit();
    }
}
