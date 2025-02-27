package hensal.spellpackblood.registry;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class MySpellPackLoot
{

    private MySpellPackLoot()
    {
    }

    /**
     * Called from the preInit method in the main mod class to register the custom dungeon loot.
     */
    public static void preInit()
    {
        // subsets
        //  TODO: These are only needed if you want to add custom loot into dungeon chests
        // LootTableList.register(new ResourceLocation(MySpellPack.MODID, "chests/dungeon_additions"));
    }

    //  TODO: These are only needed if you want to add custom loot into dungeon chests
//	@SubscribeEvent
//	public static void onLootTableLoadEvent(LootTableLoadEvent event) {
//		if (Arrays.asList(MySpellPack.settings.lootInjectLocations).contains(event.getName())) {
//			event.getTable().addPool(getAdditive(MySpellPack.MODID + ":chests/dungeon_additions", MySpellPack.MODID + "_myspellpack_dungeon_additions"));
//		}
//	}
//
//	private static LootPool getAdditive(String entryName, String poolName) {
//		return new LootPool(new LootEntry[] {getAdditiveEntry(entryName, 1)}, new LootCondition[0],
//				new RandomValueRange(1), new RandomValueRange(0, 1), MySpellPack.MODID + "_" + poolName);
//	}
//
//	private static LootEntryTable getAdditiveEntry(String name, int weight) {
//		return new LootEntryTable(new ResourceLocation(name), weight, 0, new LootCondition[0],
//				MySpellPack.MODID + "_additive_entry");
//	}

}
