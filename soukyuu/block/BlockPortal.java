package soukyuu.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import soukyuu.core.Soukyuu;
import soukyuu.core.TelepoterSoukyuu;
import soukyuu.entity.EntitySkyPortalFX;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPortal extends BlockBreakable {
	public BlockPortal(int par1, int par2) {
		super(par1, par2, Material.portal, false);
		this.setTickRandomly(true);
		this.setCreativeTab(Soukyuu.Tab);
		this.setHardness(-1.0F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setBlockName("portal");
		this.setLightValue(2.0F);
	
	}


	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.provider.isSurfaceWorld() && par5Random.nextInt(2000) < par1World.difficultySetting) {
			int var6;

			for (var6 = par3; !par1World.doesBlockHaveSolidTopSurface(par2, var6, par4) && var6 > 0; --var6) {
				;
			}

			if (var6 > 0 && !par1World.isBlockNormalCube(par2, var6 + 1, par4)) {
				Entity var7 = ItemMonsterPlacer.spawnCreature(par1World, 57, (double) par2 + 0.5D, (double) var6 + 1.1D, (double) par4 + 0.5D);
			}
			
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return null;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		float var5;
		float var6;

		if (par1IBlockAccess.getBlockId(par2 - 1, par3, par4) != this.blockID && par1IBlockAccess.getBlockId(par2 + 1, par3, par4) != this.blockID) {
			var5 = 0.125F;
			var6 = 0.5F;
			this.setBlockBounds(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
		} else {
			var5 = 0.5F;
			var6 = 0.125F;
			this.setBlockBounds(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
		}
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	public static boolean tryToCreatePortal(World par1World, int par2, int par3, int par4) {
		byte var5 = 0;
		byte var6 = 0;

		if (par1World.getBlockId(par2 - 1, par3, par4) == Block.obsidian.blockID || par1World.getBlockId(par2 + 1, par3, par4) == Block.obsidian.blockID) {
			var5 = 1;
		}

		if (par1World.getBlockId(par2, par3, par4 - 1) == Block.obsidian.blockID || par1World.getBlockId(par2, par3, par4 + 1) == Block.obsidian.blockID) {
			var6 = 1;
		}

		if (var5 == var6) {
			return false;
		} else {
			if (par1World.getBlockId(par2 - var5, par3, par4 - var6) == 0) {
				par2 -= var5;
				par4 -= var6;
			}

			int var7;
			int var8;

			for (var7 = -1; var7 <= 2; ++var7) {
				for (var8 = -1; var8 <= 3; ++var8) {
					boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;

					if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3) {
						int var10 = par1World.getBlockId(par2 + var5 * var7, par3 + var8, par4 + var6 * var7);

						if (var9) {
							if (var10 != Block.obsidian.blockID) {
								return false;
							}
						} else if (var10 != 0 && var10 != InitBlock.portalTrigger.blockID) {
							return false;
						}
					}
				}
			}

			par1World.editingBlocks = true;

			for (var7 = 0; var7 < 2; ++var7) {
				for (var8 = 0; var8 < 3; ++var8) {
					par1World.setBlockWithNotify(par2 + var5 * var7, par3 + var8, par4 + var6 * var7, InitBlock.portal.blockID);
				}
			}

			par1World.editingBlocks = false;
			return true;
		}
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		byte var6 = 0;
		byte var7 = 1;

		if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID) {
			var6 = 1;
			var7 = 0;
		}

		int var8;

		for (var8 = par3; par1World.getBlockId(par2, var8 - 1, par4) == this.blockID; --var8) {
			;
		}

		if (par1World.getBlockId(par2, var8 - 1, par4) != Block.obsidian.blockID) {
			par1World.setBlockWithNotify(par2, par3, par4, 0);
		} else {
			int var9;

			for (var9 = 1; var9 < 4 && par1World.getBlockId(par2, var8 + var9, par4) == this.blockID; ++var9) {
				;
			}

			if (var9 == 3
					&& par1World.getBlockId(par2, var8 + var9, par4) == Block.obsidian.blockID) {
				boolean var10 = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
				boolean var11 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

				if (var10 && var11) {
					par1World.setBlockWithNotify(par2, par3, par4, 0);
				} else {
					if ((par1World.getBlockId(par2 + var6, par3, par4 + var7) != Block.obsidian.blockID || par1World.getBlockId(par2 - var6, par3, par4 - var7) != this.blockID) && (par1World.getBlockId(par2 - var6, par3, par4 - var7) != Block.obsidian.blockID || par1World.getBlockId(par2 + var6, par3, par4 + var7) != this.blockID)) {
						par1World.setBlockWithNotify(par2, par3, par4, 0);
					}
				}
			} else {
				par1World.setBlockWithNotify(par2, par3, par4, 0);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		if (par1IBlockAccess.getBlockId(par2, par3, par4) == this.blockID) {
			return false;
		} else {
			boolean var6 = par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == this.blockID && par1IBlockAccess.getBlockId(par2 - 2, par3, par4) != this.blockID;
			boolean var7 = par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == this.blockID && par1IBlockAccess.getBlockId(par2 + 2, par3, par4) != this.blockID;
			boolean var8 = par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == this.blockID && par1IBlockAccess.getBlockId(par2, par3, par4 - 2) != this.blockID;
			boolean var9 = par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == this.blockID && par1IBlockAccess.getBlockId(par2, par3, par4 + 2) != this.blockID;
			boolean var10 = var6 || var7;
			boolean var11 = var8 || var9;
			return var10 && par5 == 4 ? true : (var10 && par5 == 5 ? true : (var11 && par5 == 2 ? true : var11 && par5 == 3));
		}
	}

	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}
	public int timeUntilPortal;
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		
        
		if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null && par5Entity instanceof EntityPlayerMP) {
			if (par5Entity instanceof EntityPlayerMP) {
				EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
				if (par5Entity.dimension != Soukyuu.Dimid) {
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Soukyuu.Dimid, new TelepoterSoukyuu(thePlayer.mcServer.worldServerForDimension(Soukyuu.Dimid)));
				} else {
					if (par5Entity.dimension == Soukyuu.Dimid) {
						thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TelepoterSoukyuu(thePlayer.mcServer.worldServerForDimension(0)));
					}
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        if(random.nextInt(100) == 0)
        {
            world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "portal.portal", 1.0F, random.nextFloat() * 0.4F + 0.8F);
        }
        for(int l = 0; l < 4; l++)
        {
            double d = (float)i + random.nextFloat();
            double d1 = (float)j + random.nextFloat();
            double d2 = (float)k + random.nextFloat();
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = random.nextInt(2) * 2 - 1;
            d3 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)random.nextFloat() - 0.5D) * 0.5D;
            if(world.getBlockId(i - 1, j, k) == blockID || world.getBlockId(i + 1, j, k) == blockID)
            {
                d2 = (double)k + 0.5D + 0.25D * (double)i1;
                d5 = random.nextFloat() * 2.0F * (float)i1;
            } else
            {
                d = (double)i + 0.5D + 0.25D * (double)i1;
                d3 = random.nextFloat() * 2.0F * (float)i1;
            }
            EntitySkyPortalFX entityportalfx = new EntitySkyPortalFX(world, d, d1, d2, d3, d4, d5);
            ModLoader.getMinecraftInstance().effectRenderer.addEffect(entityportalfx);
        }

    }
	

	@Override
	@SideOnly(Side.CLIENT)
	public int idPicked(World par1World, int par2, int par3, int par4) {
		return 0;
	}
	@Override
    public String getTextureFile(){
    	return "/SkylandBlock.png";
    }
	
	
}