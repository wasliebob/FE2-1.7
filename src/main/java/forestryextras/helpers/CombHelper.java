package forestryextras.helpers;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import forestry.api.recipes.RecipeManagers;
import forestryextras.main.init.FEBees;

public class CombHelper {
	public static void addCombToMap(int meta, String combName, int primColor, int secColor, ItemStack[] outputItems, int[] chancePercent)
	{
		combs.add(meta);
		name.put(meta, combName);
		primaryColor.put(meta, primColor);
		secondaryColor.put(meta, secColor);
		outputStacks.put(meta, outputItems);
		outputChance.put(meta, chancePercent);
	}
	
	public static void addRecipes()
	{
		addOreDictionary();
		for(int i = 0; i < combs.size(); i++){
			int meta = combs.get(i);
			ItemStack[] output = outputStacks.get(meta);
			int[] chance = outputChance.get(meta);
			if (output != null && chance != null) {
				RecipeManagers.centrifugeManager.addRecipe(10, new ItemStack(FEBees.comb, 1, meta),output, chance);
			}
		}	
	}
	
	public static void addOreDictionary()
	{
		for(int i = 0; i < combs.size(); i++) {
			int meta = combs.get(i);
			OreDictionary.registerOre("beeComb", new ItemStack(FEBees.comb, 1, meta));
		}
	}
	
	public static ArrayList<Integer> combs = new ArrayList<Integer>();
	public static HashMap<Integer, String> name = new HashMap<Integer, String>();
	public static HashMap<Integer, Integer> primaryColor = new HashMap<Integer, Integer>();
	public static HashMap<Integer, Integer> secondaryColor = new HashMap<Integer, Integer>();
	public static HashMap<Integer, ItemStack[]> outputStacks  = new HashMap<Integer, ItemStack[]>();
	public static HashMap<Integer, int[]> outputChance  = new HashMap<Integer, int[]>();

}