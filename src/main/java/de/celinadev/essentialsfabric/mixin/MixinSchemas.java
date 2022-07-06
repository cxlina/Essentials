package de.celinadev.essentialsfabric.mixin;

import com.mojang.datafixers.DataFixerBuilder;
import de.celinadev.essentialsfabric.Main;
import de.celinadev.essentialsfabric.util.FastDataFixerBuilder;
import net.minecraft.SharedConstants;
import net.minecraft.datafixer.Schemas;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Schemas.class)
public class MixinSchemas {

    @Redirect(method = "create", at = @At(value = "NEW", target = "com/mojang/datafixers/DataFixerBuilder"))
    private static DataFixerBuilder essentials$create(int i) {
        if (Main.getInstance().getOptions().fixDataFixer)
            return new FastDataFixerBuilder(i);
        return new DataFixerBuilder(SharedConstants.getGameVersion().getWorldVersion());

    }
}