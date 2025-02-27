package yourauthorname.myspellpack.spell;

import net.minecraft.util.DamageSource;
import yourauthorname.myspellpack.MySpellPack;
import electroblob.wizardry.spell.SpellArrow;
import electroblob.wizardry.util.SpellModifiers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import yourauthorname.myspellpack.entity.projectile.EntityBloodShard;
import yourauthorname.myspellpack.registry.MySpellPackSpells;

public class BloodShard extends SpellArrow<EntityBloodShard>
{

    public BloodShard()
    {
        super(MySpellPack.MODID, "blood_shard", EntityBloodShard::new);
        this.addProperties(DAMAGE, EFFECT_DURATION, EFFECT_STRENGTH);
    }

    @Override
    public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers)
    {
        super.cast(world, caster, hand, ticksInUse, modifiers);
        caster.attackEntityFrom(DamageSource.MAGIC, 1);
        return true;
    }

}
