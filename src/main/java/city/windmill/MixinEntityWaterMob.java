package city.windmill;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityWaterMob.class)
public class MixinEntityWaterMob extends EntityLiving {

    public MixinEntityWaterMob(World worldIn) {
        super(worldIn);
    }

    /**
     * @author Windmill_City
     */
    @Overwrite
    public boolean isNotColliding()
    {
        return this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() &&
                this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
    }
}
