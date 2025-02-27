package hensal.spellpackblood.potion;

import electroblob.wizardry.Wizardry;
import electroblob.wizardry.client.DrawingUtils;
import electroblob.wizardry.potion.PotionMagicEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import hensal.spellpackblood.MySpellPack;

import java.util.Iterator;
import java.util.List;

public class Pact extends PotionMagicEffect
{

    //public EntityPlayer player = SPBPotionEffect.getDonator();
    private static final ResourceLocation BACKGROUND = new ResourceLocation(MySpellPack.MODID, "textures/gui/pact_background.png");

    public Pact(boolean isBadEffect, int liquidColour, ResourceLocation texture)
    {
        super(isBadEffect, liquidColour, texture);
    }

    public boolean shouldRenderInvText(PotionEffect effect)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc)
    {
        mc.renderEngine.bindTexture(BACKGROUND);
        DrawingUtils.drawTexturedRect(x, y, 0, 0, 140, 32, 256, 256);
        super.renderInventoryEffect(x, y, effect, mc);
        String name = Wizardry.proxy.translate(this.getName(), new Object[0]);


        List<String> lines = mc.fontRenderer.listFormattedStringToWidth(name, 100);
        int i = 0;

        for (Iterator var8 = lines.iterator(); var8.hasNext(); ++i)
        {
            String line = (String) var8.next();
            int h = lines.size() == 1 ? 5 : i * (mc.fontRenderer.FONT_HEIGHT + 1);
            mc.fontRenderer.drawStringWithShadow(line, (float) (x + 10 + 18), (float) (y + 6 + h), 12517614);
        }

    }

    @SideOnly(Side.CLIENT)
    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(BACKGROUND);
        DrawingUtils.drawTexturedRect(x, y, 141, 0, 24, 24, 256, 256);
        super.renderHUDEffect(x, y, effect, mc, alpha);
    }
}
