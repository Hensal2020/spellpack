package hensal.spellpackblood.client.particle;

import electroblob.wizardry.client.particle.ParticleWizardry;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import hensal.spellpackblood.MySpellPack;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ParticleBlood extends ParticleWizardry
{

    private static final ResourceLocation[] TEXTURES = generateTextures(MySpellPack.MODID, "blood", 8);

    public ParticleBlood(World world, double x, double y, double z)
    {

        super(world, x, y, z, TEXTURES[world.rand.nextInt(TEXTURES.length)]);

        this.canCollide = true;

        // Defaults
        this.setRBGColorF(1, 1, 1);
        this.particleScale *= 0.75f;
        this.setGravity(true);
        this.shaded = false;
    }

    @SubscribeEvent
    public static void onTextureStitchEvent(TextureStitchEvent.Pre event)
    {
        for (ResourceLocation texture : TEXTURES)
        {
            event.getMap().registerSprite(texture);
        }
    }

}
