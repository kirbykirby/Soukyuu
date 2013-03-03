package soukyuu.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import soukyuu.core.Soukyuu;

public class BlockPortalTrigger extends Block {
	public BlockPortalTrigger(int par1, int par2) {
		super(par1, par2, Material.rock);
		this.setTickRandomly(true);
		this.setCreativeTab(Soukyuu.Tab);
		this.setHardness(1.2F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setBlockName(" ");
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		if (par1World.getBlockId(par2, par3 - 1, par4) != Block.obsidian.blockID || !BlockPortal.tryToCreatePortal(par1World, par2, par3, par4)) {
			if (par3 - 1 != Block.obsidian.blockID) {
			} else {
				par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate() + par1World.rand.nextInt(10));
			}
		}
	}

	
}