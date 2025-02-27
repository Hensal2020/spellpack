package hensal.spellpackblood.potion;

import net.minecraft.entity.player.EntityPlayer;

public class bond
{

    public EntityPlayer don = null;
    public EntityPlayer acc = null;

    public bond(EntityPlayer donator, EntityPlayer acceptor)
    {
        EntityPlayer don = donator;
        EntityPlayer acc = acceptor;
    }
}
