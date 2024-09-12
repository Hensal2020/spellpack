package yourauthorname.myspellpack.registry;

import electroblob.wizardry.entity.projectile.EntityIceShard;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.spell.SpellArrow;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import yourauthorname.myspellpack.MySpellPack;
import yourauthorname.myspellpack.entity.projectile.EntityBloodShard;
import yourauthorname.myspellpack.spell.BloodStep;
import yourauthorname.myspellpack.spell.ExplodeMyself;
import yourauthorname.myspellpack.spell.MarkThyself;

import javax.annotation.Nonnull;



@ObjectHolder(MySpellPack.MODID)
@EventBusSubscriber
public final class MySpellPackSpells {

	private MySpellPackSpells() {} // no instances


	public static final Spell explode_myself = placeholder();
	public static final Spell mark_thyself = placeholder();
	public static final Spell blood_step = placeholder();
	public static final Spell blood_shard = placeholder();

	@Nonnull
	@SuppressWarnings("ConstantConditions")
	private static <T> T placeholder() {return null;}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Spell> event) {

		IForgeRegistry<Spell> registry = event.getRegistry();

		// 1.0.0 Spells
		registry.register(new ExplodeMyself());
		registry.register(new MarkThyself());
		registry.register(new BloodStep());
		registry.register(new SpellArrow<>("blood_shard", EntityBloodShard::new).addProperties(Spell.DAMAGE,Spell.EFFECT_DURATION,Spell.EFFECT_STRENGTH));

	}
}
