

package soukyuu.block;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import soukyuu.core.Soukyuu;


public class BlockSkyFlower extends BlockFlower

{

    public BlockSkyFlower(int i, int j)
    {
        super(i, j, Material.plants);
        float f = 0.2F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3F, 0.5F + f);
        setCreativeTab(Soukyuu.Tab);
       
    }

    public String getTextureFile()
    {
        return "/SkylandBlock.png";
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == InitBlock.skyGrass.blockID || i == InitBlock.skyDirt.blockID;
    }
}