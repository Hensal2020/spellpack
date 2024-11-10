package yourauthorname.myspellpack.client.renderer.entity;

import electroblob.wizardry.entity.living.EntitySpiritWolf;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import yourauthorname.myspellpack.MySpellPack;
import yourauthorname.myspellpack.entity.living.EntityBloodWolf;

public class RenderBloodWolf extends RenderWolf {
    private static final ResourceLocation texture = new ResourceLocation(MySpellPack.MODID,
            "textures/entity/blood_wolf.png");

    public RenderBloodWolf(RenderManager renderManager){
        super(renderManager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWolf entity){
        return texture;
    }

    @Override
    protected void preRenderCallback(EntityWolf entity, float partialTickTime) {
        super.preRenderCallback(entity, partialTickTime);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        if (entity instanceof EntityBloodWolf) { // Always true
            GlStateManager.color(1, 1, 1, ((EntityBloodWolf) entity).getOpacity());
        }

    }
    @Override
    public void doRender(EntityWolf entity, double x, double y, double z, float entityYaw, float partialTicks) {

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
