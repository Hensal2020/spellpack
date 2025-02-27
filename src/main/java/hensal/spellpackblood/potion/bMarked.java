package hensal.spellpackblood.potion;

import electroblob.wizardry.potion.PotionMagicEffect;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.util.ResourceLocation;
import hensal.spellpackblood.MySpellPack;


@Mod.EventBusSubscriber
public class bMarked extends PotionMagicEffect
{
    public bMarked(boolean isBadEffect, int liquidColour)
    {
        super(isBadEffect, liquidColour, new ResourceLocation(MySpellPack.MODID, "textures/potion_icon/bmarked.png"));
        this.setPotionName("potion." + MySpellPack.MODID + ":bmarked");
    }

    @Override
    public boolean isReady(int duration, int amplifier)
    {
        return true;
    }
}
