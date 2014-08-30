package forestryextras.main.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.recipes.RecipeManagers;
import forestryextras.api.FEApi;
import forestryextras.main.Config;

public class Recipes {
	public static void init(){
		initBlockRecipes();
		initItemRecipes();
		initMiscRecipes();
	}
	
	public static void initBlockRecipes(){
		initNormalBlockRecipes();
		initForestryBlockRecipes();
	}
	
	public static void initNormalBlockRecipes(){
		
	}
	
	public static void initForestryBlockRecipes(){
		
	}
	
	public static void initItemRecipes(){
		initNormalItemRecipes();
		initForestryItemRecipes();
	}
	
	public static void initNormalItemRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(Items.nether_star), new Object[]{
			"XXX",
			"XIX",
			"XXX",
			'X', FEItems.witheriaIngot,
			'I', Items.ender_pearl});
		
		if(Config.dragonEggRecipe){
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.dragon_egg), new Object[]{
				"XXX",
				"XIX",
				"XXX",
				'X', FEItems.draconicIngot,
				'I', Items.nether_star});
		}
	}
	
	public static void initForestryItemRecipes(){
		registerCarpenterRecipes(20, new FluidStack(FluidRegistry.LAVA, 1000), new ItemStack(FEItems.reinforcedIngot), new Object[]{
			"YYY",
			"XXX",
			"YYY",
			'Y', Blocks.obsidian,
			'X', Items.iron_ingot});
		
		registerCarpenterRecipes(20, new FluidStack(FluidRegistry.LAVA, 1000), new ItemStack(FEItems.witheriaIngot), new Object[]{
			" X ",
			"ZYZ",
			" X ",
			'X', Items.blaze_rod,
			'Y', FEItems.reinforcedIngot,
			'Z', Blocks.soul_sand});
		
		registerCarpenterRecipes(20, new FluidStack(FluidRegistry.LAVA, 1000), new ItemStack(FEItems.draconicIngot), new Object[]{
			" X ",
			"ZYZ",
			" X ",
			'X', Items.ender_pearl,
			'Y', FEItems.witheriaIngot,
			'Z', Items.ender_eye});
	}

	public static void initMiscRecipes(){
		FEApi.blockMutation.put(Blocks.iron_block, FEBlocks.mutatedIronBlock);
	}
	
	public static void registerSqueezerRecipes(int produceTime, ItemStack input, FluidStack output){
		RecipeManagers.squeezerManager.addRecipe(produceTime, new ItemStack[]{input}, output);
	}
	
	public static void registerCarpenterRecipes(int produceTime, FluidStack fluid, ItemStack output, Object[] ingredients){
		RecipeManagers.carpenterManager.addRecipe(produceTime, fluid, null, output, ingredients);
	}
}