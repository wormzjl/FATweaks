package wormz.fatweaks.ASM;

import city.windmill.IntegratedServerTrans;
import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraftforge.fml.relauncher.CoreModManager;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import java.io.File;
import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions({"wormz.fatweaks"})
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class FATCore implements IFMLLoadingPlugin {
    public static Logger LOGGER = LogManager.getLogger("FATCore");
    public static boolean isDeobf = false;

    public FATCore() {
        try {
            loadModJar(new File("./mods/".concat("Advanced Machines-61.0.1.jar")));
            loadModJar(new File("./mods/".concat("CustomOreGen-1.12-1.8.1.jar")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("setting up mixin environment");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixin.json");
    }

    private void loadModJar(File jar) throws Exception {
        ((LaunchClassLoader) this.getClass().getClassLoader()).addURL(jar.toURI().toURL());
        CoreModManager.getReparseableCoremods().add(jar.getName());
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{
                IC2Transformer.class.getName(),
                RHTransformer.class.getName(),
                IntegratedServerTrans.class.getName()
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
        isDeobf = !(boolean) data.get("runtimeDeobfuscationEnabled");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
