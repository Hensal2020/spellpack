package hensal.spellpackblood.spell;

import net.minecraft.util.DamageSource;
import hensal.spellpackblood.MySpellPack;
import electroblob.wizardry.spell.SpellArrow;
import electroblob.wizardry.util.SpellModifiers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import hensal.spellpackblood.entity.projectile.EntityBloodShard;

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
