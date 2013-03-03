package soukyuu.wgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeSkylandDecorator extends BiomeDecorator {
	public BiomeSkylandDecorator(BiomeGenBase par1BiomeGenBase) {
		super(par1BiomeGenBase);
		mcTallGrassPerChunk = 2;
		this.sandPerChunk = 20;
		this.sandPerChunk2 =3;
		this.clayPerChunk = 5;
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		if (this.currentWorld != null) {
			if (this.currentWorld != null);
		} else {
			this.currentWorld = par1World;
			this.randomGenerator = par2Random;
			this.chunk_X = par3;
			this.chunk_Z = par4;
			this.decorate();
			this.currentWorld = null;
			this.randomGenerator = null;
		}
	}

	
	public int mcTallGrassPerChunk;

	@Override
	protected void decorate() {
		int var1;
		int var2;
		int var3;
		int var7;

		var1 = this.streesPerChunk;

		if (this.randomGenerator.nextInt(10) == 0) {
			++var1;
		}

		int var4;

		for (var2 = 0; var2 < var1; ++var2) {
			var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			WorldGenerator var5 = this.biome.getRandomWorldGenForTrees(this.randomGenerator);
			var5.setScale(1.0D, 1.0D, 1.0D);
			var5.generate(this.currentWorld, this.randomGenerator, var3, this.currentWorld.getHeightValue(var3, var4), var4);
		}

		for (var2 = 0; var2 < this.mcTallGrassPerChunk; ++var2) {
			var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			var4 = this.randomGenerator.nextInt(128);
			var7 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			WorldGenerator var6 = this.biome.getRandomWorldGenForGrass(this.randomGenerator);
			var6.generate(this.currentWorld, this.randomGenerator, var3, var4, var7);
		}
	}

	
	int	streesPerChunk = this.treesPerChunk;
	int sreedsPerChunk = this.reedsPerChunk;
	int sgrassPerChunk = this.grassPerChunk;
	int smushroomsPerChunk = this.mushroomsPerChunk;
	int ssandPerChunk = this.sandPerChunk;
}