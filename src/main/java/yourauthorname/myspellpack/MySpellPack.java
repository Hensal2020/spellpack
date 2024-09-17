package yourauthorname.myspellpack;

import com.windanesz.wizardryutils.registry.ItemModelRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import yourauthorname.myspellpack.registry.BookshelfItems;
import yourauthorname.myspellpack.registry.MySpellPackLoot;

import java.util.Random;

@Mod(modid = MySpellPack.MODID, name = MySpellPack.NAME, version = MySpellPack.VERSION, acceptedMinecraftVersions = MySpellPack.MC_VERSION, dependencies = "required-after:ebwizardry@[@WIZARDRY_VERSION@,4.4);required-after:wizardryutils@[@WIZARDRY_UTILS_VERSION@,)")
public class MySpellPack {

	public static final String MODID = "myspellpack";
	public static final String NAME = "MySpellPack by ME";
	public static final String VERSION = "@VERSION@";
	public static final String MC_VERSION = "[1.12.2]";

	public static final Random rand = new Random();

	public static Settings settings = new Settings();

	public static Logger logger;

	// The instance of wizardry that Forge uses.
	@Mod.Instance(MySpellPack.MODID)
	public static MySpellPack instance;

	// Location of the proxy code, used by Forge.
	@SidedProxy(clientSide = "yourauthorname.myspellpack.client.ClientProxy", serverSide = "yourauthorname.myspellpack.CommonProxy")
	public static CommonProxy proxy;
	/**
	 * Static instance of the {@link electroblob.wizardry.Settings} object for Wizardry.
	 */


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		settings = new Settings();
		MySpellPackLoot.preInit();
		proxy.registerRenderers();

		// With this, WizardryUtils will take care of the model registry of regular items
		ItemModelRegistry.registerModForAutoItemModelRegistry(MODID);
		BookshelfItems.PreInitRegisterBookShelfModelTextures();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		MinecraftForge.EVENT_BUS.register(instance); // Since there's already an instance we might as well use it
		BookshelfItems.InitBookshelfItems();
		proxy.registerParticles();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}

}
