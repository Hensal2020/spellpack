package yourauthorname.myspellpack.spell;

import electroblob.wizardry.item.SpellActions;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.SpellModifiers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import yourauthorname.myspellpack.MySpellPack;

import yourauthorname.myspellpack.registry.MySpellPackPotions;

public class MarkThyself extends Spell{

    public MarkThyself(){
        super(MySpellPack.MODID, "mark_thyself", SpellActions.POINT_UP,false);
        //addproperties
    }

    @Override
    public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers){
        caster.attackEntityFrom(DamageSource.MAGIC, 1);
        caster.addPotionEffect(new PotionEffect(MySpellPackPotions.bmarked,200,5));
        caster.addPotionEffect(new PotionEffect(MySpellPackPotions.bbound,200,5));
        caster.addPotionEffect(new PotionEffect(MySpellPackPotions.bbounded, 200, 5));
        return true;
    }
}
