package soukyuu.block;

import soukyuu.core.Soukyuu;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockSkyStone extends Block{
	public BlockSkyStone(int par1, int par2) {
		super(par1, par2, Material.rock);
		this.setCreativeTab(Soukyuu.Tab);
		this.setStepSound(Block.soundStoneFootstep);
		this.setBlockName(" ");
	}
@Override
public String getTextureFile(){
	return "/SkylandBlock.png";
}
}