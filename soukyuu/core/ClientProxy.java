package soukyuu.core;

import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	@Override
	public void loadTex() {

		MinecraftForgeClient.preloadTexture("/SkylandBlock.png");
		MinecraftForgeClient.preloadTexture("/SkylandItem.png");
		System.out.println("Fuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
	}


}
