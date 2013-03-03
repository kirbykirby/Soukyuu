package soukyuu.core;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class ConfigManager {
	public static boolean load;

	static Configuration configuration;

	
	

	//Blocks
	public static int idStone;
	public static int idGrass;
	public static int idDirt;
	public static int idFlower;
	public static int idStar;
	public static int idPresent;
	public static int idWood;
	public static int idTNT;
	public static int idPortal;
	public static int idTrigger;
	
	public ConfigManager(File file)
	{
		if (!ConfigManager.load)
		{
			ConfigManager.configuration = new Configuration(file);
			this.setDefaultValues();
		}
	}
	private void setDefaultValues()
    {
		try
		{
			ConfigManager.configuration.load();
			
		  	ConfigManager.idStone   = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idStone",3350).getInt(3350);
	        ConfigManager.idGrass   = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idGrass", 3351).getInt(3351);
	        ConfigManager.idDirt    = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idDirt",3352).getInt(3352);
	        ConfigManager.idFlower  = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idFlower",3353).getInt(3353);
	        ConfigManager.idStar    = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idStar",3354).getInt(3354);
	        ConfigManager.idWood    = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idWood",3355).getInt(3355);
	        ConfigManager.idTNT     = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idTNT",3356).getInt(3356);
	        ConfigManager.idPortal  = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idPortal",3357).getInt(3357);
	        ConfigManager.idTrigger = ConfigManager.configuration.get(Configuration.CATEGORY_BLOCK, "idTrigger",3358).getInt(3358);
		}
		catch (final Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Soukyuu has a problem loading it's conf");
		}
		finally
		{
			ConfigManager.configuration.save();
			ConfigManager.load = true;
		}
    }
}
