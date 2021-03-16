package city.windmill.mixin;

import CustomOreGen.Server.WorldConfig;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.world.gen.IChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = WorldConfig.class, remap = false)
class MixinWorldConfig {
    @Redirect(method = "populateWorldProperties",
            at = @At(
                    value = "INVOKE_ASSIGN",
                    target = "Lnet/minecraft/world/WorldProvider;createChunkGenerator()Lnet/minecraft/world/gen/IChunkGenerator;",
                    remap = false
            ))
    private static IChunkGenerator getWorldGenerator(WorldProvider worldProvider, World world) {
        return world.getChunkProvider() instanceof ChunkProviderServer ?
                ((ChunkProviderServer) world.getChunkProvider()).chunkGenerator
                : worldProvider.createChunkGenerator();
    }
}
