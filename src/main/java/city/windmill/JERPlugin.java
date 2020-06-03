package city.windmill;

import jeresources.api.IJERAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTable;

public class JERPlugin {
    @jeresources.api.JERPlugin
    public static IJERAPI jerapi;

    public static void regChest(){
        jerapi.getDungeonRegistry().registerCategory("lostcities:chests/lostcitychest", "dungeon.lostcitychest");
        jerapi.getDungeonRegistry().registerCategory("lostcities:chests/raildungeonchest", "dungeon.raildungeonchest");
        jerapi.getDungeonRegistry().registerChest("lostcities:chests/lostcitychest", new ResourceLocation("lostcities:chests/lostcitychest"));
        jerapi.getDungeonRegistry().registerChest("lostcities:chests/raildungeonchest", new ResourceLocation("lostcities:chests/raildungeonchest"));
    }
}
