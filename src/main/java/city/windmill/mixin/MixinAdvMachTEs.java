package city.windmill.mixin;

import com.chocohead.AdvMachines.te.TileEntityHeatingMachine;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.IRecipeInput;
import ic2.core.block.TileEntityInventory;
import ic2.core.block.invslot.InvSlotOutput;
import ic2.core.block.invslot.InvSlotProcessableGeneric;
import ic2.core.block.invslot.InvSlotUpgrade;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Collection;

@Pseudo
@Mixin(targets = "com/chocohead/AdvMachines/te/TileEntityHeatingMachine", remap = false)
public class MixinAdvMachTEs {
    @Redirect(method = "<init>(BBLic2/api/recipe/IMachineRecipeManager;II)V", at = @At(value = "NEW", target = "Lic2/core/block/invslot/InvSlotProcessableGeneric;"))
    public InvSlotProcessableGeneric ctorProxy(
            TileEntityInventory instance,
            String name,
            int count,
            IMachineRecipeManager<IRecipeInput, Collection<ItemStack>, ItemStack> recipeSet
    ){
        return new InvSlotProcessableGeneric(instance,name,count,recipeSet);
    }
    @Redirect(method = "<init>(BBLic2/api/recipe/IMachineRecipeManager;II)V", at = @At(value = "NEW", target = "Lic2/core/block/invslot/InvSlotOutput;"))
    public InvSlotOutput ctorProxy2(
            TileEntityInventory instance,
            String name,
            int count
    ){
        return new InvSlotOutput(instance,name,count);
    }
    @Redirect(method = "<init>(BBLic2/api/recipe/IMachineRecipeManager;II)V", at = @At(value = "NEW", target = "Lic2/core/block/invslot/InvSlotUpgrade;"))
    public InvSlotUpgrade ctorProxy3(
            TileEntityInventory instance,
            String name,
            int count
    ){
        return new InvSlotUpgrade((TileEntityHeatingMachine)instance,name,count);
    }
}
