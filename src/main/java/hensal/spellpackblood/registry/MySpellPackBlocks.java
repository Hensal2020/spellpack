package hensal.spellpackblood.registry;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import hensal.spellpackblood.MySpellPack;

import javax.annotation.Nonnull;

@GameRegistry.ObjectHolder(MySpellPack.MODID)
@Mod.EventBusSubscriber
public class MySpellPackBlocks
{

    private MySpellPackBlocks()
    {
    } // no instances

    // public static final Block someblock = placeholder();

    @Nonnull
    @SuppressWarnings("ConstantConditions")
    private static <T> T placeholder()
    {
        return null;
    }

    public static void registerBlock(IForgeRegistry<Block> registry, String name, Block block)
    {
        block.setRegistryName(MySpellPack.MODID, name);
        block.setTranslationKey(block.getRegistryName().toString());
        registry.register(block);
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Block> event)
    {

        IForgeRegistry<Block> registry = event.getRegistry();
        //registerBlock(registry, "bla bla",  new BlockBla());
    }
}
