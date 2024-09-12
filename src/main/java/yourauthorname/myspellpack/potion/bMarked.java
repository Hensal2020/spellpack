package yourauthorname.myspellpack.potion;

import electroblob.wizardry.potion.PotionMagicEffect;
import electroblob.wizardry.registry.WizardryPotions;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.util.ResourceLocation;
import yourauthorname.myspellpack.MySpellPack;


@Mod.EventBusSubscriber
public class bMarked extends PotionMagicEffect {
    public bMarked(boolean isBadEffect, int liquidColour){
        super(isBadEffect, liquidColour , new ResourceLocation(MySpellPack.MODID, "textures/potion_icon/bmarked.png"));
        this.setPotionName("potion." + MySpellPack.MODID + ":bmarked");
    }



    @Override
    public boolean isReady(int duration, int amplifier){
        return true;
    }
}
