package forestryextras.main.init;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.recipes.RecipeManagers;
import forestryextras.blocks.FEBlock;
import forestryextras.blocks.FEBlockProducer;

public class FEBlocks {

	public static void init()
	{
		draconicBlock = new FEBlock(Material.iron, "draconicBlock", "draconicblock", true, 1.0F, new ItemStack(FEItems.draconicIngot));
		reinforcedBlock = new FEBlock(Material.iron, "reinforcedBlock", "reinforcedblock", true, 1.0F, new ItemStack(FEItems.reinforcedIngot));
		draconicOre = new FEBlock(Material.iron, "draconicOre", "draconicore", false, 0F, null);
		producer = new FEBlockProducer("Beeducer");
		
//		upgrader = new FEBlockUpgrader(Config.upgraderId, "Upgrader");
		
		smelting();
	}
	
	public static void smelting()
	{
		GameRegistry.addSmelting(draconicOre, new ItemStack(FEItems.draconicIngot), 0.0F);
	}
	
	public static void crafting()
	{
		RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.LAVA, 20), null, new ItemStack(FEItems.reinforcedIngot), new Object[]{
			"IZ",
			"XY",
			'X', Items.diamond,
			'I', Items.gold_ingot,
			'Y', Items.iron_ingot,
			'Z', Blocks.obsidian});
	}
	
	public static FEBlock draconicBlock;
	public static FEBlock reinforcedBlock;
	public static FEBlock draconicOre;
	public static FEBlockProducer producer;

//	public static FEBlockUpgrader upgrader;
}
