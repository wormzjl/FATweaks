package wormz.fatweaks.proxy;

import ic2.core.IHasGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import wormz.fatweaks.blocks.ContainerLiquidHeatExchanger2;
import wormz.fatweaks.blocks.GuiLiquidHeatExchanger2;
import wormz.fatweaks.blocks.TileEntityLiquidHeatExchanger2;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof IHasGui) {
            return new ContainerLiquidHeatExchanger2(player, (TileEntityLiquidHeatExchanger2) te);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof IHasGui) {
            return new GuiLiquidHeatExchanger2(new ContainerLiquidHeatExchanger2(player, (TileEntityLiquidHeatExchanger2) te));
        }
        return null;
    }
}
