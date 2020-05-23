package city.windmill;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.Name("SmallFixCore")
@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.SortingIndex(1200)
public class SmallFixCore implements IFMLLoadingPlugin {
    public static Logger LOGGER = LogManager.getLogger("SmallFixCore");
    public static boolean isDeobf = false;

    public SmallFixCore() {
        LOGGER.info("setting up mixin environment");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixin.json");
    }
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                IntegratedServerTrans.class.getName()
        };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        isDeobf = !(boolean) data.get("runtimeDeobfuscationEnabled");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
