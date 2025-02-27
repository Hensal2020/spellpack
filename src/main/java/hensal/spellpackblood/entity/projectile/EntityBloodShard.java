package hensal.spellpackblood.entity.projectile;

import electroblob.wizardry.entity.projectile.EntityMagicArrow;
import electroblob.wizardry.registry.WizardrySounds;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.MagicDamage.DamageType;
import electroblob.wizardry.util.ParticleBuilder;
import electroblob.wizardry.util.ParticleBuilder.Type;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import hensal.spellpackblood.registry.MySpellPackPotions;
import hensal.spellpackblood.registry.MySpellPackSpells;
import hensal.spellpackblood.util.MySpellPackParticle;

public class EntityBloodShard extends EntityMagicArrow
{

    public EntityBloodShard(World world)
    {
        super(world);
    }

    @Override
    public double getDamage()
    {
        return MySpellPackSpells.blood_shard.getProperty(Spell.DAMAGE).floatValue();
    }

    @Override
    public int getLifetime()
    {
        return -1;
    }

    @Override
    public DamageType getDamageType()
    {
        return DamageType.MAGIC;
    }

    @Override
    public boolean doGravity()
    {
        return true;
    }

    @Override
    public boolean doDeceleration()
    {
        return true;
    }

    @Override
    public boolean canRenderOnFire()
    {
        return false;
    }

    @Override
    public void onEntityHit(EntityLivingBase entityHit)
    {

        if (entityHit.isPotionActive(MySpellPackPotions.bmarked))
        {
            entityHit.addPotionEffect(new PotionEffect(MySpellPackPotions.bmarked,
                    MySpellPackSpells.blood_shard.getProperty(Spell.EFFECT_DURATION).intValue(),
                    entityHit.getActivePotionEffect(MySpellPackPotions.bmarked).getAmplifier() + 1));
        } else
        {
            entityHit.addPotionEffect(new PotionEffect(MySpellPackPotions.bmarked,
                    MySpellPackSpells.blood_shard.getProperty(Spell.EFFECT_DURATION).intValue(),
                    MySpellPackSpells.blood_shard.getProperty(Spell.EFFECT_STRENGTH).intValue()));
        }
    }

    @Override
    public void onBlockHit(RayTraceResult hit)
    {

        // Adds a particle effect when the blood shard hits a block.
        if (this.world.isRemote)
        {
            // Gets a position slightly away from the block hit so the particle doesn't get cut in half by the block face
            Vec3d vec = hit.hitVec.add(new Vec3d(hit.sideHit.getDirectionVec()).scale(0.15));
            ParticleBuilder.create(Type.FLASH).pos(vec).clr(0.75f, 1, 1).spawn(world);

            for (int j = 0; j < 10; j++)
            {
                ParticleBuilder.create(MySpellPackParticle.BLOOD, this.rand, this.posX, this.posY, this.posZ, 0.5, true)
                        .time(20 + rand.nextInt(10)).gravity(true).spawn(world);
            }
        }
        // Parameters for sound: sound event name, volume, pitch.
        this.playSound(WizardrySounds.ENTITY_ICE_SHARD_SMASH, 1.0F, rand.nextFloat() * 0.4F + 1.2F);

    }

    @Override
    protected void entityInit()
    {
    }
}

// Nicht vergessen: Entity Registry
