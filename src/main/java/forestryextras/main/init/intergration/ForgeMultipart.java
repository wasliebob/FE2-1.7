package forestryextras.main.init.intergration;

import net.minecraft.block.Block;
import codechicken.microblock.BlockMicroMaterial;
import codechicken.microblock.MicroMaterialRegistry;
import forestry.core.config.ForestryBlock;
import forestryextras.main.Config;
import forestryextras.main.init.FEBlocks;

public class ForgeMultipart {

	public static void init()
	{
		registerMultipart(FEBlocks.draconicBlock, 0);
		registerMultipart(FEBlocks.reinforcedBlock, 0);
		
		if(Config.forestryFMP){
			registerMetadata(ForestryBlock.log1, 3);
			registerMetadata(ForestryBlock.log2, 3);
			registerMetadata(ForestryBlock.log3, 3);
			registerMetadata(ForestryBlock.log4, 3);
			registerMetadata(ForestryBlock.log5, 3);
			registerMetadata(ForestryBlock.log6, 3);
			registerMetadata(ForestryBlock.log7, 3);

			registerMetadata(ForestryBlock.planks1, 15);
			registerMetadata(ForestryBlock.planks2, 7);
		
			registerMetadata(ForestryBlock.soil, 1);
			
			registerMetadata(ForestryBlock.beehives, 5);
			registerMetadata(ForestryBlock.glass, 15);

		}
	}
	
	public static void registerMetadata(Block block, int maxMeta){
		for (int i = 0; i <= maxMeta; i ++)
			registerMultipart(block, i);
	}
	
	private static void registerMultipart(Block block, int meta)
	{
		MicroMaterialRegistry.registerMaterial(new BlockMicroMaterial(block, meta), block.getUnlocalizedName() + (meta == 0 ? "" : "_" + meta));
	}
}