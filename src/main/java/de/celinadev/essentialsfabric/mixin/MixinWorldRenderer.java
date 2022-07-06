package de.celinadev.essentialsfabric.mixin;

import de.celinadev.essentialsfabric.Main;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer {

    @ModifyArg(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/BackgroundRenderer;applyFog(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/BackgroundRenderer$FogType;FZF)V"), index = 3)
    private boolean essentials$cancelFog(boolean thickFog) {
        if (!Main.getInstance().getOptions().fixNetherFog)
            return thickFog;
        return false;
    }
}