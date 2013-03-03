package soukyuu.wgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import soukyuu.block.BlockSkyFlower;



public class SkyGenFlowers extends WorldGenerator
{

    private int plantBlockId;

    public SkyGenFlowers(int i)
    {
        plantBlockId = i;
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	
        for(int l = 0; l < 64; l++)
        {
            int i1 = (i + random.nextInt(8)) - random.nextInt(8);
            int j1 = (j + random.nextInt(4)) - random.nextInt(4);
            int k1 = (k + random.nextInt(8)) - random.nextInt(8);
            if(world.isAirBlock(i1, j1, k1) && ((BlockSkyFlower)Block.blocksList[plantBlockId]).canBlockStay(world, i1, j1, k1))
            {
                world.setBlock(i1, j1, k1, plantBlockId);
            }
        }
    
        return true;
    }
}