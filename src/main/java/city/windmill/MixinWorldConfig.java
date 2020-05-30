package city.windmill;

import CustomOreGen.Server.WorldConfig;
import net.minecraft.world.World;
import net.minecraft.world.gen.*;
import net.minecraft.world.storage.WorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

@Pseudo
@Mixin(WorldConfig.class)
public class MixinWorldConfig {
    public MixinWorldConfig() throws IOException, ParserConfigurationException, SAXException {
    }

    private static void populateWorldProperties(Map<String,Object> properties, World world, WorldInfo worldInfo)
    {
        properties.put("world", worldInfo == null ? "" : worldInfo.getWorldName());
        properties.put("world.seed", worldInfo == null ? 0L : worldInfo.getSeed());
        properties.put("world.version", worldInfo == null ? 0 : worldInfo.getSaveVersion());
        properties.put("world.isHardcore", worldInfo == null ? false : worldInfo.isHardcoreModeEnabled());
        properties.put("world.hasFeatures", worldInfo == null ? false : worldInfo.isMapFeaturesEnabled());
        properties.put("world.hasCheats", worldInfo == null ? false : worldInfo.areCommandsAllowed());
        properties.put("world.gameMode", worldInfo == null ? "" : worldInfo.getGameType().getName());
        properties.put("world.gameMode.id", worldInfo == null ? 0 : worldInfo.getGameType().getID());
        properties.put("world.type", worldInfo == null ? "" : worldInfo.getTerrainType().getName());
        properties.put("world.type.version", worldInfo == null ? 0 : worldInfo.getTerrainType().getVersion());
        String genName = "RandomLevelSource";
        String genClass = "ChunkProviderOverworld";

        if (world != null)
        {
            IChunkGenerator chunkGenerator = world.getChunkProvider() instanceof ChunkProviderServer ?
                    ((ChunkProviderServer)world.getChunkProvider()).chunkGenerator
                    : world.provider.createChunkGenerator();
            genName = chunkGenerator.toString();
            genClass = chunkGenerator.getClass().getSimpleName();

            if (chunkGenerator instanceof ChunkGeneratorOverworld)
            {
                genClass = "ChunkProviderOverworld";
            }
            else if (chunkGenerator instanceof ChunkGeneratorFlat)
            {
                genClass = "ChunkProviderFlat";
            }
            else if (chunkGenerator instanceof ChunkGeneratorHell)
            {
                genClass = "ChunkProviderHell";
            }
            else if (chunkGenerator instanceof ChunkGeneratorEnd)
            {
                genName = "EndRandomLevelSource";
                genClass = "ChunkProviderEnd";
            }
        }

        properties.put("dimension.generator", genName);
        properties.put("dimension.generator.class", genClass);
        properties.put("dimension", world == null ? "" : world.provider.getDimensionType().getName());
        properties.put("dimension.id", world == null ? 0 : world.provider.getDimension());
        properties.put("dimension.isSurface", world == null ? false : world.provider.isSurfaceWorld());
        properties.put("dimension.hasNoSky", world == null ? false : world.provider.hasSkyLight());
        properties.put("dimension.groundLevel", world == null ? 0 : world.provider.getAverageGroundLevel());
        properties.put("dimension.actualHeight", world == null ? 0 : world.getActualHeight());
        properties.put("dimension.height", world == null ? 0 : world.getHeight());
        properties.put("age", false);
    }
}
