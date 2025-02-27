package hensal.spellpackblood.spell;

import electroblob.wizardry.item.ItemArtefact;
import electroblob.wizardry.item.SpellActions;
import electroblob.wizardry.spell.Spell;
import electroblob.wizardry.util.SpellModifiers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import hensal.spellpackblood.MySpellPack;
import hensal.spellpackblood.registry.MySpellPackItems;
import hensal.spellpackblood.registry.MySpellPackPotions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BloodStep extends Spell
{

    public BloodStep()
    {
        super(MySpellPack.MODID, "blood_step", SpellActions.POINT_UP, false);
    }

    @Override
    public boolean cast(World world, EntityPlayer caster, EnumHand hand, int ticksInUse, SpellModifiers modifiers)
    {
        if (world.playerEntities.size() == 1)
        {
            return false;
        }
        if (world.playerEntities.size() == 2)
        {
            for (EntityPlayer player : world.playerEntities)
            {
                if (ItemArtefact.isArtefactActive(player, MySpellPackItems.blood_maiden_collar) && !(player == caster) && !world.isRemote)
                {
                    caster.setPositionAndUpdate(player.posX, player.posY, player.posZ);
                    return true;
                }
                if (player.isPotionActive(MySpellPackPotions.bmarked) && !(player == caster) && !world.isRemote)
                {
                    caster.setPositionAndUpdate(player.posX, player.posY, player.posZ);
                    return true;
                }
            }
            return false;
        }
        List<EntityPlayer> cPlayer = new ArrayList<>(); //Collar Player
        List<EntityPlayer> bPlayer = new ArrayList<>(); //Blood Marked Players
        for (EntityPlayer player : world.playerEntities)
        {
            if (ItemArtefact.isArtefactActive(player, MySpellPackItems.blood_maiden_collar) && !(player == caster))
            {
                cPlayer.add(player);
            }
            if (player.isPotionActive(MySpellPackPotions.bmarked) && !(player == caster))
            {
                bPlayer.add(player);
            }
        }
        Random rand = new Random();
        if (!cPlayer.isEmpty())
        {
            EntityPlayer sPlayer = cPlayer.get(rand.nextInt(cPlayer.size())); //selected Player
            if (!world.isRemote)
            {
                caster.setPositionAndUpdate(sPlayer.posX, sPlayer.posY, sPlayer.posZ);
                return true;
            }
        }
        if (!bPlayer.isEmpty())
        {
            EntityPlayer sPlayer = bPlayer.get(rand.nextInt(bPlayer.size())); //selected Player
            if (!world.isRemote)
            {
                caster.setPositionAndUpdate(sPlayer.posX, sPlayer.posY, sPlayer.posZ);
                return true;
            }
        }
        return false;
    }
}

// Argument bei einer Funktion vergessen