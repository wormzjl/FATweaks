package wormz.fatweaks.ASM;

import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import wormz.fatweaks.fatweaks;

import java.util.Arrays;

public class FATCoreContainer extends DummyModContainer {

    public FATCoreContainer()
    {
        super(new ModMetadata());

        ModMetadata meta = getMetadata();

        meta.modId = "fattweakscore";
        meta.name = "FATTweaks Core";
        meta.version = "1";
        meta.credits = "Created by wormz";
        meta.authorList = Arrays.asList("wormz");
        meta.description = "FATTweaks ASM";
        meta.url = "";
        meta.screenshots = new String[0];
        meta.logoFile = "";
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
        bus.register(this);
        return true;
    }
}
