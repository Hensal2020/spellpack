package yourauthorname.myspellpack.registry;

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
import yourauthorname.myspellpack.spell.*;

import javax.annotation.Nonnull;


@ObjectHolder(MySpellPack.MODID)
@EventBusSubscriber
public final class MySpellPackSpells
{

    private MySpellPackSpells()
    {
    } // no instances


    public static final Spell explode_myself = placeholder();
    public static final Spell mark_thyself = placeholder();
    public static final Spell blood_step = placeholder();
    public static final Spell blood_shard = placeholder();
    public static final Spell blood_burst = placeholder();
    public static final Spell summon_blood_wolf = placeholder();
    public static final Spell blood_protection = placeholder();

    @Nonnull
    @SuppressWarnings("ConstantConditions")
    private static <T> T placeholder()
    {
        return null;
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Spell> event)
    {

        IForgeRegistry<Spell> registry = event.getRegistry();

        // 1.0.0 Spells
        registry.register(new ExplodeMyself());
        registry.register(new MarkThyself());
        registry.register(new BloodStep());
        registry.register(new BloodProtection());
        //registry.register(new SpellArrow<>(MySpellPack.MODID, "blood_shard",EntityBloodShard::new).addProperties(Spell.DAMAGE, Spell.EFFECT_DURATION, Spell.EFFECT_STRENGTH).soundValues(1, 1.6f, 0.4f));
        registry.register(new BloodShard());
        registry.register(new BloodBurst());
        registry.register(new SummonBloodWolf());
    }
}
