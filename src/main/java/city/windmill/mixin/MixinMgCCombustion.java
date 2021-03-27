package city.windmill.mixin;

import com.cout970.magneticraft.systems.tilemodules.ModuleCombustionChamber;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ModuleCombustionChamber.class, remap = false)
class MixinMgCCombustion {
    @ModifyConstant(method = "update", constant = { @Constant(doubleValue = 10.0) })
    private double incresepower(final double original) {
        return 40.0;
    }
}
