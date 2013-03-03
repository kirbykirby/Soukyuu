package soukyuu.block;


import java.util.Random;

import soukyuu.core.Soukyuu;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;



public class BlockSkyWood extends Block
   
{

    public static int Top = 12;
    public static int Side = 10;

 
    public BlockSkyWood(int i)
    {
        super(i, Top, Material.wood);
        this.setCreativeTab(Soukyuu.Tab);
    }

    public String getTextureFile()
    {
        return "/SkylandBlock.png";
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i <= 1 && j <= 3)
        {
            return Side;
        }
        else
        {
            return Top;
        } 
       
    }

    public int quantityDropped(Random random)
    {
        return this.blockID;
    }

    

}