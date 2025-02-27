package hensal.spellpackblood.client;

import electroblob.wizardry.client.particle.ParticleWizardry;
import electroblob.wizardry.client.renderer.entity.RenderMagicArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import hensal.spellpackblood.CommonProxy;
import hensal.spellpackblood.MySpellPack;
import hensal.spellpackblood.client.particle.ParticleBlood;
import hensal.spellpackblood.client.renderer.entity.RenderBloodWolf;
import hensal.spellpackblood.entity.living.EntityBloodWolf;
import hensal.spellpackblood.entity.projectile.EntityBloodShard;
import hensal.spellpackblood.util.MySpellPackParticle;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{

    @Override
    public void registerRenderers()
    {

        RenderingRegistry.registerEntityRenderingHandler(EntityBloodShard.class, manager -> new RenderMagicArrow(manager,
                new ResourceLocation(MySpellPack.MODID, "textures/entity/blood_shard.png"), false, 8.0, 2.0, 16, 5, false));

        //Entity
        RenderingRegistry.registerEntityRenderingHandler(EntityBloodWolf.class, RenderBloodWolf::new);
    }

    @Override
    public void registerParticles()
    {
        ParticleWizardry.registerParticle(MySpellPackParticle.BLOOD, ParticleBlood::new);
    }


}

