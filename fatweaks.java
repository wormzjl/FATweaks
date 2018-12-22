package wormz.fatweaks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.Logger;


@Mod(modid = FATweaks.MODID, name = FATweaks.MODNAME, version = FATweaks.MODVERSION, dependencies = "required-after:forge@[14.23.5.2796,)", useMetadata = true)
public class FATweaks {

    public static final String MODID = "fatweaks";
    public static final String MODNAME = "FATweaks";
    public static final String MODVERSION= "0.1";

    @SidedProxy(clientSide = "wormz.fatweaks.proxy.ClientProxy", serverSide = "wormz.fatweaks.proxy.CommonProxy")
    public static CommonProxy proxy;

    public FATweaks() {
        // This has to be done VERY early
        //FluidRegistry.enableUniversalBucket();
    }

    @Mod.Instance
    public static FATweaks instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent event) {

    }

    @Mod.EventHandler
    public void serverStopped(FMLServerStoppedEvent event) {

    }


}
