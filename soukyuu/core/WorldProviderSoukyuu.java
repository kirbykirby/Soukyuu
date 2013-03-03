package soukyuu.core;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderSoukyuu extends WorldProvider {
	
	

	public WorldProviderSoukyuu() {
		super();
		dimensionId = Soukyuu.Dimid;
	}

	public void registerWorldChunkManager() {
		

	}

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderSoukyuu(worldObj, worldObj.getSeed());
	}

	public float calculateCelestialAngle(long l, float f) {
		return 0.0F;
	}

	public float[] calcSunriseSunsetColors(float f, float f1) {
		return null;
	}


	 @SideOnly(Side.CLIENT)

	    /**
	     * Return Vec3D with biome specific fog color
	     */
	    public Vec3 getFogColor(float par1, float par2)
	    {
		
		 return this.worldObj.getWorldVec3Pool().getVecFromPool(1.1D, 1.1D, 1.1D);
	    }

	public boolean isSkyColored() {
		return false;
	}

	public float getCloudHeight() {
		return 8F;
	}

	public boolean canCoordinateBeSpawn(int i, int j) {
		int k = worldObj.getFirstUncoveredBlock(i, j);

		if (k == 0) {
			return false;
		} else {
			return Block.blocksList[k].blockMaterial.isSolid();
		}

	}
	@Override
	public boolean canRespawnHere()
    {
        return false;
    }
	@Override
	public double getHorizon()
    {
        return 3.0D;
    }
	@Override
	public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }
	@Override
	public String getSaveFolder() {
		return "DIM-Soukyuu";
	}

	@Override
	public String getWelcomeMessage() {
		return "Entering the Soukyuu";
	}

	@Override
	public String getDepartMessage() {
		return "Leaving the Soukyuu";
	}

	@Override
	public String getDimensionName() {
		return "Soukyuu";
	}

	public ChunkCoordinates getEntrancePortalLocation() {
		return new ChunkCoordinates(120, 40, 0);
	}

	@Override
	public boolean getWorldHasVoidParticles() {
		return false;
	}

	@Override
	public boolean doesXZShowFog(int par1, int par2) {
		return false;
	}

	public double getMovementFactor() {
		return 10.0;
	}
	@SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
    {
        return worldObj.getSkyColorBody(cameraEntity, partialTicks);
    }
}
