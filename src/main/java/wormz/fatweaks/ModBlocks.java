package wormz.fatweaks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wormz.fatweaks.blocks.blocktest;

public class ModBlocks {

    @GameRegistry.ObjectHolder("fatweaks:blocktest")
    public static blocktest blocktest;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blocktest.initModel();
    }

}
