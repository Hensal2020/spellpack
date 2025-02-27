package yourauthorname.myspellpack.spell;

import electroblob.wizardry.item.SpellActions;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.SpellModifiers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import yourauthorname.myspellpack.MySpellPack;

public class ExplodeMyself extends Spell
{

    public static final String EXPLOSION_STRENGTH = "explosion_strength";

    public ExplodeMyself()
    {
        super(MySpellPack.MODID, "explode_myself", SpellActions.SUMMON, false);
        addProperties(EXPLOSION_STRENGTH);
    }

    @Override
    public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers)
    {
        if (!world.isRemote)
        {
            world.createExplosion(null, caster.posX, caster.posY, caster.posZ, getProperty(EXPLOSION_STRENGTH).floatValue(), true);
        }
        return true;
    }
}
