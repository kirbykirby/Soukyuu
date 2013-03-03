package soukyuu.block;

import java.util.Random;

import soukyuu.core.Soukyuu;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPresent extends Block
{
    public BlockPresent(int par1)
    {
        super(par1, Material.cloth);
        this.setCreativeTab(Soukyuu.Tab);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par1 == 1 ? 7 : (par1 == 0 ? 7 : 8);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par5 == 1)
        {
            return 7;
        }
        else if (par5 == 0)
        {
            return 7;
        }
        else
        {
            Material var6 = par1IBlockAccess.getBlockMaterial(par2, par3 + 1, par4);
            return var6 != Material.snow && var6 != Material.craftedSnow ? 8 : 68;
        }
    }
    @Override
    public String getTextureFile(){
    	return "/SkylandBlock.png";
    }
    @Override
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
    	 world.playSoundAtEntity(entityplayer, "Collection", 0.5F, 0.4F);
    	Minecraft minecraft = ModLoader.getMinecraftInstance();
        EntityPlayerSP entityplayersp = minecraft.thePlayer;
        Random random = new Random();
        int i1 = 6;
        int j1 = 9;
        long l1 = ((long)j1 - (long)i1) + 1L;
        long l2 = (long)((double)l1 * random.nextDouble());
        int k1 = (int)(l2 + (long)i1);
        int i2 = random.nextInt(4);
        if(i2 == 0)
        {
            for(int j2 = 1; j2 <= k1; j2++)
            {
                world.spawnEntityInWorld(new EntityXPOrb(world, i, j, k, 10));
            }

        } else
        if(i2 == 1)
        {
            if(random.nextInt(9) == 0)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.appleRed, 1));
            } 
            if(random.nextInt(9) == 1)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.appleGold, 1));
            }
            if(random.nextInt(9) == 2)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.axeGold, 1));
            }
            if(random.nextInt(9) == 3)
            {
            	
            }
            else
            {
                for(int k2 = 1; k2 <= k1; k2++)
                {
                	EntityItem entityitem = new EntityItem(world, (double)i, (double)j, (double)k, new ItemStack(Item.cookie, 1));
        			entityitem.delayBeforeCanPickup = 10;
        			world.spawnEntityInWorld(entityitem);
                }

            }
        } else
        {
            EntityTNTPrimed entitytnt = new EntityTNTPrimed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
            world.spawnEntityInWorld(entitytnt);
            world.playSoundAtEntity(entitytnt, "random.fuse", 1.0F, 1.0F);
            
        }
    }
    @Override
public int idDropped(int par1, Random par2Random, int par3){
	return 0;
	
}

    
   
}
