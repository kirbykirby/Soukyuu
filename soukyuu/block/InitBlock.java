package soukyuu.block;

import net.minecraft.block.Block;
import soukyuu.core.ConfigManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class InitBlock {
	public static Block skyStone;
	public static Block skyGrass;
	public static Block skyDirt;
	public static Block skyFlower;
	public static Block present;
	public static Block skyWood;
	public static Block portalTrigger;
	public static Block portal;
	
	public InitBlock() {
	portal = new BlockPortal(ConfigManager.idPortal, 4);
		portalTrigger = new BlockPortalTrigger(ConfigManager.idTrigger, 2);
		skyStone = new BlockSkyStone(ConfigManager.idStone, 1).setHardness(1.7F).setResistance(11.0f).setStepSound(Block.soundStoneFootstep);
		skyGrass = new BlockSkyGrass(ConfigManager.idGrass).setHardness(0.6F).setResistance(3.0f).setStepSound(Block.soundGrassFootstep);
		skyDirt = new BlockSkyDirt(ConfigManager.idDirt, 2).setHardness(0.5F).setResistance(2.0f).setStepSound(Block.soundGravelFootstep);
		skyFlower = new BlockSkyFlower(ConfigManager.idFlower, 5).setHardness(0.0F).setStepSound(Block.soundGrassFootstep);
		present = new BlockPresent(ConfigManager.idPresent).setHardness(0.4F);
		skyWood = new BlockSkyWood(ConfigManager.idWood).setHardness(0.7F);

		
		registerBlocks();
		

}
	
	public void registerBlocks(){
		GameRegistry.registerBlock(portal,"portal");
		GameRegistry.registerBlock(portalTrigger,"portalTrigger");
		GameRegistry.registerBlock(skyStone,"skyStone");
		GameRegistry.registerBlock(skyGrass,"skyGrass");
		GameRegistry.registerBlock(skyDirt,"skyDirt");
		GameRegistry.registerBlock(skyFlower,"skyFlower");
		GameRegistry.registerBlock(present,"present");
		GameRegistry.registerBlock(skyWood,"skyWood");

	}
}
