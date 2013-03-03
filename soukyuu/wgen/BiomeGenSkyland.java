package soukyuu.wgen;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenSkyland extends BiomeGenBase
{
	public static BiomeGenSkyland me = null;
    public BiomeGenSkyland()
    {
        super(30);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();   
        this.theBiomeDecorator = new BiomeSkylandDecorator(this);
        this.minHeight = 0.5F;
        this.maxHeight = 1.3F;
        me = this;
    }
    @Override
    public int getSkyColorByTemp(float f)
    {
        return 0xc0c0ff;
    }

   
}
