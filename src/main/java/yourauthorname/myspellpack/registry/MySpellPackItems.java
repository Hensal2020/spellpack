package yourauthorname.myspellpack.registry;

import com.windanesz.wizardryutils.registry.ItemRegistry;
import electroblob.wizardry.item.ItemArtefact;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import yourauthorname.myspellpack.MySpellPack;

import javax.annotation.Nonnull;

@ObjectHolder(MySpellPack.MODID)
@Mod.EventBusSubscriber
public final class MySpellPackItems {

	private MySpellPackItems() {} // No instances!

	@Nonnull
	@SuppressWarnings("ConstantConditions")
	private static <T> T placeholder() {return null;}

	public static final Item amulet_test = placeholder();
	public static final Item blood_maiden_collar = placeholder();

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {

		IForgeRegistry<Item> registry = event.getRegistry();

		ItemRegistry.registerItemArtefact(registry, "amulet_test", MySpellPack.MODID, new ItemArtefact(EnumRarity.UNCOMMON, ItemArtefact.Type.AMULET));
		ItemRegistry.registerItemArtefact(registry,"blood_maiden_collar", MySpellPack.MODID, new ItemArtefact(EnumRarity.EPIC, ItemArtefact.Type.AMULET));

	}

}