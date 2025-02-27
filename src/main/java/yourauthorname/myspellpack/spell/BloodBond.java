package yourauthorname.myspellpack.spell;

import electroblob.wizardry.item.SpellActions;
import electroblob.wizardry.spell.SpellRay;
import electroblob.wizardry.util.EntityUtils;
import electroblob.wizardry.util.SpellModifiers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import yourauthorname.myspellpack.MySpellPack;
import yourauthorname.myspellpack.registry.MySpellPackPotions;

public class BloodBond extends SpellRay
{

    public BloodBond()
    {
        super(MySpellPack.MODID, "blood_bond", SpellActions.POINT, false);
        this.soundValues(0.7f, 1, 0.4f);
        addProperties(EFFECT_DURATION);
    }

    @Override
    protected boolean onEntityHit(World world, Entity target, Vec3d hit, EntityLivingBase caster, Vec3d origin, int ticksInUse, SpellModifiers modifiers)
    {

        if (EntityUtils.isLiving(target))
        {
            if (!world.isRemote)
            {
                if (target instanceof EntityPlayer)
                {
                    if (((EntityPlayer) target).getActivePotionEffect(MySpellPackPotions.bmarked).getAmplifier() >= 5)
                    {
                        caster.addPotionEffect(new PotionEffect(MySpellPackPotions.bbound, 200, 5));
                        ((EntityPlayer) target).addPotionEffect(new PotionEffect(MySpellPackPotions.bbounded, 200, 5));
                    }
                }
            }
        }

        return false;
    }

    @Override
    protected boolean onBlockHit(World world, BlockPos pos, EnumFacing side, Vec3d hit, EntityLivingBase caster, Vec3d origin, int ticksInUse, SpellModifiers modifiers)
    {
        return false;
    }

    @Override
    protected boolean onMiss(World world, EntityLivingBase caster, Vec3d origin, Vec3d direction, int ticksInUse, SpellModifiers modifiers)
    {
        return false;


    }


}
