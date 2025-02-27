package yourauthorname.myspellpack.client;

import electroblob.wizardry.client.particle.ParticleWizardry;
import electroblob.wizardry.client.renderer.entity.RenderMagicArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import yourauthorname.myspellpack.CommonProxy;
import yourauthorname.myspellpack.MySpellPack;
import yourauthorname.myspellpack.client.particle.ParticleBlood;
import yourauthorname.myspellpack.client.renderer.entity.RenderBloodWolf;
import yourauthorname.myspellpack.entity.living.EntityBloodWolf;
import yourauthorname.myspellpack.entity.projectile.EntityBloodShard;
import yourauthorname.myspellpack.util.MySpellPackParticle;

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

