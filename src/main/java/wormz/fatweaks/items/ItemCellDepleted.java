package wormz.fatweaks.items;

import ic2.api.reactor.IReactor;
import ic2.api.reactor.IReactorComponent;
import ic2.core.IC2Potion;
import ic2.core.item.armor.ItemArmorHazmat;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wormz.fatweaks.fatweaks;

public class ItemCellDepleted extends Item implements IReactorComponent {
    public final boolean rad;

    public ItemCellDepleted(String name, boolean rad)
    {
        setRegistryName(fatweaks.MODID,name);
        setTranslationKey(getRegistryName().toString());
        this.rad = rad;
    }

    @SideOnly(Side.CLIENT)
    public void initModel()
    {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int slotIndex, boolean isCurrentItem)
    {
        if (this.rad && (entity instanceof EntityLivingBase))
        {
            EntityLivingBase entityLiving = (EntityLivingBase)entity;
            if (!ItemArmorHazmat.hasCompleteHazmat(entityLiving)) {
                IC2Potion.radiation.applyTo(entityLiving, 200, 100);
            }
        }
    }

    public boolean canBePlacedIn(ItemStack stack, IReactor reactor)
    {
        return false;
    }

    public void processChamber(ItemStack stack, IReactor reactor, int x, int y, boolean heatrun) {}

    public boolean acceptUraniumPulse(ItemStack stack, IReactor reactor, ItemStack pulsingStack, int youX, int youY, int pulseX, int pulseY, boolean heatrun)
    {
        return false;
    }

    public boolean canStoreHeat(ItemStack stack, IReactor reactor, int x, int y)
    {
        return false;
    }

    public int getMaxHeat(ItemStack stack, IReactor reactor, int x, int y)
    {
        return 0;
    }

    public int getCurrentHeat(ItemStack stack, IReactor reactor, int x, int y)
    {
        return 0;
    }

    public int alterHeat(ItemStack stack, IReactor reactor, int x, int y, int heat)
    {
        return 0;
    }

    public float influenceExplosion(ItemStack stack, IReactor reactor)
    {
        return 0.0F;
    }
}
