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
	portal = (BlockPortal) (new BlockPortal(ConfigManager.idPortal, 4));
		portalTrigger = (BlockPortalTrigger) (new BlockPortalTrigger(
				ConfigManager.idTrigger, 2));
		skyStone = (BlockSkyStone) (new BlockSkyStone(ConfigManager.idStone, 1).setHardness(
				1.7F).setResistance(11.0f)
				.setStepSound(Block.soundStoneFootstep));
		skyGrass = (BlockSkyGrass) (new BlockSkyGrass(ConfigManager.idGrass)
				.setHardness(0.6F).setResistance(3.0f)
				.setStepSound(Block.soundGrassFootstep));
		skyDirt = (BlockSkyDirt) (new BlockSkyDirt(ConfigManager.idDirt, 2).setHardness(0.5F)
				.setResistance(2.0f).setStepSound(Block.soundGravelFootstep));
		skyFlower = (BlockSkyFlower) (new BlockSkyFlower(ConfigManager.idFlower, 5)
				.setHardness(0.0F).setStepSound(Block.soundGrassFootstep));
		present = (BlockPresent) (new BlockPresent(ConfigManager.idPresent).setHardness(0.4F));
		skyWood = (BlockSkyWood) (new BlockSkyWood(ConfigManager.idWood).setHardness(0.7F));

		
		registerBlocks();
		

}
	@SuppressWarnings("deprecation")
	public void registerBlocks(){
		GameRegistry.registerBlock(portal);
		GameRegistry.registerBlock(portalTrigger);
		GameRegistry.registerBlock(skyStone);
		GameRegistry.registerBlock(skyGrass);
		GameRegistry.registerBlock(skyDirt);
		GameRegistry.registerBlock(skyFlower);
		GameRegistry.registerBlock(present);
		GameRegistry.registerBlock(skyWood);

	}
}
