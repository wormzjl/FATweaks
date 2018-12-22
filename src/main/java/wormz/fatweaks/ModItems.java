package wormz.fatweaks;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import wormz.fatweaks.items.ItemBreederUranium;
import wormz.fatweaks.items.ItemCellDepleted;


public class ModItems {

    public static ItemBreederUranium breeder_uranium = new ItemBreederUranium("breeder_uranium", 1, 40000);
    public static ItemBreederUranium breeder_uranium_dual = new ItemBreederUranium("breeder_uranium_dual", 2, 80000);
    public static ItemBreederUranium breeder_uranium_quad = new ItemBreederUranium("breeder_uranium_quad", 4, 120000);

    public static ItemCellDepleted breeder_uranium_depleted = new ItemCellDepleted("breeder_uranium_depleted", true);
    public static ItemCellDepleted breeder_uranium_dual_depleted = new ItemCellDepleted("breeder_uranium_dual_depleted", true);
    public static ItemCellDepleted breeder_uranium_quad_depleted = new ItemCellDepleted("breeder_uranium_quad_depleted", true);

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        breeder_uranium.initModel();
        breeder_uranium_dual.initModel();
        breeder_uranium_quad.initModel();
        breeder_uranium_depleted.initModel();
        breeder_uranium_dual_depleted.initModel();
        breeder_uranium_quad_depleted.initModel();
    }
    public static void register(IForgeRegistry<Item> registry) {
        registry.register(breeder_uranium);
        registry.register(breeder_uranium_dual);
        registry.register(breeder_uranium_quad);
        registry.register(breeder_uranium_depleted);
        registry.register(breeder_uranium_dual_depleted);
        registry.register(breeder_uranium_quad_depleted);
    }

}
