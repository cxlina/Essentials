package de.celinadev.essentialsfabric.mixin;

import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(SharedConstants.class)
public class MixinSharedConstants {

    /**
     * @author Cxlina
     * @reason fix
     */
    @Overwrite
    public static void method_43250() {
    }
}
