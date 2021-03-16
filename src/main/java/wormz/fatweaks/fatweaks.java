package wormz.fatweaks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import wormz.fatweaks.proxy.CommonProxy;

@Mod(modid = fatweaks.MODID, name = fatweaks.MODNAME, version = fatweaks.MODVERSION, dependencies = "required-after:forge@[14.23.5.2796,)", useMetadata = true)
public class fatweaks {

    public static final String MODID = "fatweaks";
    public static final String MODNAME = "FATweaks";
    public static final String MODVERSION= "1.2";

    @SidedProxy(clientSide = "wormz.fatweaks.proxy.ClientProxy", serverSide = "wormz.fatweaks.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static fatweaks instance;

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
}
