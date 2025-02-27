package hensal.spellpackblood.potion;


import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import hensal.spellpackblood.MySpellPack;

@Mod.EventBusSubscriber
public class bBound extends Pact{

    public bBound (boolean isBadEffect, int liquidColour){
        super (isBadEffect, liquidColour , new ResourceLocation(MySpellPack.MODID, "textures/potion_icon/bbound.png"));
        this.setPotionName("potion." + MySpellPack.MODID + ":bbound");

    }


    @Override
    public boolean isReady(int duration, int amplifier){
        return true;
    }
}
