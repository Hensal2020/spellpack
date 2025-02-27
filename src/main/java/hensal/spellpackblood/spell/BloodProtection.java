package hensal.spellpackblood.spell;

import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.spell.SpellBuff;
import electroblob.wizardry.util.SpellModifiers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import hensal.spellpackblood.MySpellPack;
import hensal.spellpackblood.registry.MySpellPackSpells;

public class BloodProtection extends SpellBuff
{

    public BloodProtection()
    {
        super(MySpellPack.MODID, "blood_protection", 1, 0, 0);
        this.soundValues(0.7f, 1.2f, 0.4f);
        this.addProperties(EFFECT_DURATION);
    }

    @Override
    public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers)
    {
        if (caster.getHealth() > 4F && !caster.isPotionActive(MobEffects.ABSORPTION))
        {
            caster.attackEntityFrom(DamageSource.MAGIC, 4);
            if (!this.applyEffects(caster, modifiers) && !world.isRemote) return false;
            if (world.isRemote) this.spawnParticles(world, caster, modifiers);
            this.playSound(world, caster, ticksInUse, -1, modifiers);
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    protected boolean applyEffects(EntityLivingBase caster, SpellModifiers modifiers)
    {
        caster.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, MySpellPackSpells.blood_protection.getProperty(Spell.EFFECT_DURATION).intValue(), 1));
        return true;
    }
}
// To do: Es erhöht die Leben nur um 4, was statisch, vielleicht mit "Effect_Strength" arbeiten