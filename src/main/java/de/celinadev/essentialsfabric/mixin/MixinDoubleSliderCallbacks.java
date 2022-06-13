package de.celinadev.essentialsfabric.mixin;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(SimpleOption.DoubleSliderCallbacks.class)
public class MixinDoubleSliderCallbacks {

    @Inject(method = "validate(Ljava/lang/Double;)Ljava/util/Optional;", at = @At("RETURN"), cancellable = true)
    public void essentials$validate(Double double_, CallbackInfoReturnable<Optional<Double>> cir) {
        cir.setReturnValue(double_ >= Double.MIN_VALUE && double_ <= Double.MAX_VALUE ? Optional.of(double_) : Optional.empty());
    }

    @Inject(method = "codec", at = @At("RETURN"), cancellable = true)
    public void essentials$codec(CallbackInfoReturnable<Codec<Double>> cir) {
        cir.setReturnValue(Codec.either(Codec.doubleRange(Double.MIN_VALUE, Double.MAX_VALUE), Codec.BOOL).xmap(either -> either.map(value -> value, value -> value ? Double.MAX_VALUE : Double.MIN_VALUE), Either::left));
    }
}
