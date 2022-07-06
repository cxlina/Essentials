package de.celinadev.essentialsfabric.mixin;

import de.celinadev.essentialsfabric.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ProtectionEnchantment.class)
public abstract class MixinProtectionEnchantment extends Enchantment {

    protected MixinProtectionEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    /**
     * This only works Clientside, so when you're on a Server, you can't do this no matter if it's enabled or not.
     */
    @Inject(method = "canAccept", at = @At("RETURN"), cancellable = true)
    public void essentials$acceptAllProtectionTypes(Enchantment other, CallbackInfoReturnable<Boolean> cir) {
        if (!Main.getInstance().getOptions().enableGodArmorEnchantments) return;
        boolean flag = other instanceof ProtectionEnchantment && MinecraftClient.getInstance().currentScreen instanceof AnvilScreen;
        cir.setReturnValue(flag);
    }
}
