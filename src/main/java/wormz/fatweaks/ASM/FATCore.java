package wormz.fatweaks.ASM;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.mixin.Mixins;
import zone.rong.mixinbooter.MixinLoader;

import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions({"wormz.fatweaks"})
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class FATCore implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                IC2Transformer.class.getName(),
                RHTransformer.class.getName(),
                IPTransformer.class.getName()
        };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
