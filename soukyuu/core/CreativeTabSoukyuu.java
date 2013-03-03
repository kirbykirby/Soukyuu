package soukyuu.core;

import soukyuu.block.InitBlock;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabSoukyuu extends CreativeTabs {
	public CreativeTabSoukyuu(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

    @Override
	public int getTabIconItemIndex()
    {
        return InitBlock.skyGrass.blockID;
    }
}
