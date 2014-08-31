package forestryextras.main.init;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import forestry.api.recipes.RecipeManagers;
import forestryextras.blocks.FEBlock;
import forestryextras.blocks.FEBlockProducer;

public class FEBlocks {

	public static void init(){
		draconicBlock = new FEBlock(Material.iron, "draconicBlock", "draconic", true, 0F, new ItemStack(FEItems.draconicIngot));
		reinforcedBlock = new FEBlock(Material.iron, "reinforcedBlock", "reinforced", true, 0F, new ItemStack(FEItems.reinforcedIngot));
		mutatedIronBlock = new FEBlock(Material.iron, "mutatedIronBlock", "mutatedIron", true, 0F, new ItemStack(FEItems.mutatedIronIngot));
		legendaryBlock = new FEBlock(Material.iron, "legendaryBlock", "legendary", true, 0F, new ItemStack(FEItems.legendaryIngot));
		
		producer = new FEBlockProducer("Beeducer");	
		smelting();
	}
	public static FEBlock draconicBlock;
	public static FEBlock reinforcedBlock;
	public static FEBlock mutatedIronBlock;
	public static FEBlock legendaryBlock;
	public static FEBlockProducer producer;

	public static void smelting(){}
	
	public static void crafting(){
		RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.LAVA, 20), null, new ItemStack(FEItems.reinforcedIngot), new Object[]{
			"IZ",
			"XY",
			'X', Items.diamond,
			'I', Items.gold_ingot,
			'Y', Items.iron_ingot,
			'Z', Blocks.obsidian});
	}
}