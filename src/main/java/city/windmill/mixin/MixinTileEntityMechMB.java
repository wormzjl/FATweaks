package city.windmill.mixin;

import malte0811.industrialwires.blocks.converter.TileEntityMechMB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = TileEntityMechMB.class, remap = false)
class MixinTileEntityMechMB {
    @Redirect(
            method = "setMechanical",
            at = @At(
                    value = "INVOKE_ASSIGN",
                    target = "Ljava/lang/Math;pow(DD)D",
                    remap = false
            ))
    private double changeDecay(double decayBase, double deviceLength){
        return decayBase;
    }
}
