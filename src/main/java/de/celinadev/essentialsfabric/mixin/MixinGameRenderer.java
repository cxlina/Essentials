package de.celinadev.essentialsfabric.mixin;

import de.celinadev.essentialsfabric.util.CapeUtils;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {

    @Inject(method = "render", at = @At("HEAD"))
    public void frameStart(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        CapeUtils.frameStart();
    }
}
