package city.windmill;

import org.spongepowered.asm.mixin.Mixins;
import zone.rong.mixinbooter.MixinLoader;

@MixinLoader
class FATweaksMixinLoader {
    {
        Mixins.addConfiguration("mixin.fatweaks.json");
    }
}
