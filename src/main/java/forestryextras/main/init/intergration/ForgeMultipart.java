/*
package forestryextras.main.init.intergration;

import net.minecraft.block.Block;import forestryextras.main.init.Blocks;

public class ForgeMultipart {

	public static void init()
	{
		registerMultipart(Blocks.draconicBlock, 0);
		registerMultipart(Blocks.reinforcedBlock, 0);
	}
	
	private static void registerMultipart(Block block, int meta)
	{
		MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block, meta), block.getUnlocalizedName() + (meta == 0 ? "" : "_" + meta));
	}
}
*/