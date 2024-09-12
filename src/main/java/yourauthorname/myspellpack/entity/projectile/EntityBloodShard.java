package yourauthorname.myspellpack.entity.projectile;

import electroblob.wizardry.entity.projectile.EntityMagicArrow;
import electroblob.wizardry.registry.Spells;
import electroblob.wizardry.registry.WizardryPotions;
import electroblob.wizardry.registry.WizardrySounds;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.MagicDamage;
import electroblob.wizardry.util.MagicDamage.DamageType;
import electroblob.wizardry.util.ParticleBuilder;
import electroblob.wizardry.util.ParticleBuilder.Type;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import yourauthorname.myspellpack.registry.MySpellPackPotions;
import yourauthorname.myspellpack.registry.MySpellPackSpells;

public class EntityBloodShard extends EntityMagicArrow {

    public EntityBloodShard (World world){
        super(world);
    }

    @Override public double getDamage(){ return MySpellPackSpells.blood_shard.getProperty(Spell.DAMAGE).floatValue(); }
    @Override public int getLifetime(){ return -1; }
    @Override public DamageType getDamageType(){ return DamageType.MAGIC; }
    @Override public boolean doGravity(){ return true; }
    @Override public boolean doDeceleration(){ return true; }
    @Override public boolean canRenderOnFire(){ return false; }

    @Override
    public void onEntityHit(EntityLivingBase entityHit){
        entityHit.addPotionEffect(new PotionEffect(MySpellPackPotions.bmarked,
                MySpellPackSpells.blood_shard.getProperty(Spell.EFFECT_DURATION).intValue(),
                MySpellPackSpells.blood_shard.getProperty(Spell.EFFECT_STRENGTH).intValue()));
    }

    @Override
    protected void entityInit(){}
}

// Nicht vergessen: Entity Registry
