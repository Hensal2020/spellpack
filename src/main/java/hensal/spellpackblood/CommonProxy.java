package hensal.spellpackblood;

import net.minecraft.util.text.Style;

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
