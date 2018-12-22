package wormz.fatweaks.items;

import ic2.api.reactor.IReactor;
import ic2.core.item.reactor.ItemReactorUranium;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wormz.fatweaks.ModItems;
import wormz.fatweaks.fatweaks;

public class ItemBreederUranium extends ItemReactorUranium {
    public ItemBreederUranium(String name, int cells, int duration) {
        super(null, cells, duration);
        setRegistryName(fatweaks.MODID,name);
        setTranslationKey(getRegistryName().toString());
    }

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public String getTranslationKey()
    {
        return "item." + getRegistryName().toString() + ".name";
    }

    public double getDurabilityForDisplay(ItemStack stack)
    {
        return 1.0D - super.getDurabilityForDisplay(stack);
    }

    public void processChamber(ItemStack arg0, IReactor arg1, int arg2, int arg3, boolean arg4) {}

    public boolean acceptUraniumPulse(ItemStack stack, IReactor reactor, ItemStack pulsingStack, int youX, int youY, int pulseX, int pulseY, boolean heatrun)
    {
        if (!heatrun)
        {
            int myLevel = getCustomDamage(stack) + (reactor.getHeat() > reactor.getMaxHeat() / 2 ? 2 : 1);
            if (myLevel >= getMaxCustomDamage(stack)) {
                reactor.setItemAt(youX, youY, getDepletedStack(stack, reactor));
            } else {
                setCustomDamage(stack, myLevel);
            }
        }
        return true;
    }

    protected ItemStack getDepletedStack(ItemStack stack, IReactor reactor)
    {
        switch (this.numberOfCells)
        {
            case 1:
                return new ItemStack(ModItems.breeder_uranium_depleted);
            case 2:
                return new ItemStack(ModItems.breeder_uranium_dual_depleted);
            case 4:
                return new ItemStack(ModItems.breeder_uranium_quad_depleted);
        }
        throw new RuntimeException("invalid cell count: " + this.numberOfCells);
    }
}
