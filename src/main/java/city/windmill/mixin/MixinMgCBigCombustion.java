package city.windmill.mixin;

import com.cout970.magneticraft.systems.tilemodules.ModuleBigCombustionChamber;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = ModuleBigCombustionChamber.class, remap = false)
class MixinMgCBigCombustion {
    @ModifyConstant(method = "<init>", constant = { @Constant(doubleValue = 10.0) })
    private double incresepower(final double original) {
        return 40.0;
    }
    @ModifyConstant(method = "burnSolidFuel", constant = { @Constant(doubleValue = 10.0) })
    private double incresepower2(final double original) {
        return 40.0;
    }
}
