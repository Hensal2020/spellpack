package yourauthorname.myspellpack.registry;

import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import yourauthorname.myspellpack.MySpellPack;
import yourauthorname.myspellpack.potion.*;

import javax.annotation.Nonnull;

@ObjectHolder(MySpellPack.MODID)
@Mod.EventBusSubscriber

public final class MySpellPackPotions {

    private MySpellPackPotions() {
    }

    @Nonnull
    @SuppressWarnings("ConstantConditions")

    private static <T> T placeholder() {
        return null;
    }

    public static final Potion bmarked = placeholder();
    public static final Potion bbound = placeholder();

    public static void registerPotion(IForgeRegistry<Potion> registry, String name, Potion potion) {
        potion.setRegistryName(MySpellPack.MODID, name);
        // For some reason, Potion#getName() doesn't prepend "potion." itself, so it has to be done here.
        potion.setPotionName("potion." + potion.getRegistryName().toString());
        registry.register(potion);
    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Potion> event){

        IForgeRegistry<Potion> registry = event.getRegistry();

        registerPotion(registry, "bmarked", new bMarked(false, 0).setBeneficial());
        registerPotion(registry, "bbound", new bBound(false,0,null,null).setBeneficial());

    }
}