package de.celinadev.essentialsfabric.mixin;

import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.client.render.BackgroundRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SliderWidget.class)
public class MixinSliderWidget {

    private boolean active = false;

    @Inject(method = "onRelease", at = @At("HEAD"), cancellable = true)
    private void essentials$setInactive(double mouseX, double mouseY, CallbackInfo ci) {
        boolean b = this.active;
        this.active = false;
        if (!b) ci.cancel();
    }

    @Inject(method = "onClick", at = @At("HEAD"))
    private void essentials$setActive(double mouseX, double mouseY, CallbackInfo ci) {
        this.active = true;
    }
}
