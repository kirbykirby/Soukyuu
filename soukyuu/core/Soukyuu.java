package soukyuu.core;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.DimensionManager;
import soukyuu.block.InitBlock;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarted;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name="Soukyuu", version="Indev5", useMetadata = false, modid = "Soukyuu")
@NetworkMod(channels = {"Soukyuu"}, clientSideRequired = true, serverSideRequired = false)
public class Soukyuu {
	@SidedProxy(clientSide = "soukyuu.core.ClientProxy",
				serverSide = "soukyuu.core.CommonProxy")
	
	public static CommonProxy proxy;
	
	public static int Dimid = DimensionManager.getNextFreeDimId();
	
	public static final CreativeTabs Tab = new CreativeTabSoukyuu(CreativeTabs.getNextID(), "Soukyuu");


	@Instance("Soukyuu")
	public static Soukyuu instance;

	@Init
	public void load(FMLInitializationEvent evt)
	{
		new InitBlock();
		
		proxy.loadTex();

		
		DimensionManager.registerProviderType(Dimid,
				WorldProviderSoukyuu.class, true);
		DimensionManager.registerDimension(Dimid, Dimid);


		
		
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		new ConfigManager(new File(event.getModConfigurationDirectory(), "Soukyuu/SoukyuuMod.conf"));
		
		
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
	    
		
		
	}
	
	@ServerStarted
	public void serverInit(FMLServerStartedEvent event)
	{
		
	}
}
