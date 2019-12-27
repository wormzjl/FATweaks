package wormz.fatweaks.ASM;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;

import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions({"wormz.fatweaks"})
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class FATCore implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{IC2Transformer.class.getName(),IETransformer.class.getName(),RHTransformer.class.getName()};
    }

    @Override
    public String getModContainerClass() {
        return FATCoreContainer.class.getName();
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
