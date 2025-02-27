package yourauthorname.myspellpack;

import electroblob.wizardry.Wizardry;
import electroblob.wizardry.client.renderer.entity.RenderMagicArrow;
import electroblob.wizardry.entity.projectile.EntityIceShard;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.Style;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import yourauthorname.myspellpack.entity.projectile.EntityBloodShard;

public class CommonProxy
{

    /**
     * Called from preInit() in the main mod class to initialise the renderers.
     */

    public void registerParticles()
    {
    }

    public void registerRenderers()
    {

    }

    public String translate(String key, Object... args)
    {
        return translate(key, new Style(), args);
    }

}
