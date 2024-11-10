package yourauthorname.myspellpack.potion;

import electroblob.wizardry.potion.PotionMagicEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import yourauthorname.myspellpack.MySpellPack;

@Mod.EventBusSubscriber
public class bBound extends Pact{

    public bBound (boolean isBadEffect, int liquidColour, EntityPlayer donator, EntityPlayer acceptor){
        super (isBadEffect, liquidColour , new ResourceLocation(MySpellPack.MODID, "textures/potion_icon/bbound.png"));
        this.setPotionName("potion." + MySpellPack.MODID + ":bmarked");

    }



    @Override
    public boolean isReady(int duration, int amplifier){
        return true;
    }
}
