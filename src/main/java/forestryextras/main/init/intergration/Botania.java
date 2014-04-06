/*
package forestryextras.main.init.intergration;

import forestry.api.apiculture.FlowerManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;


public class Botania {

	public static void init()
	{
		initItems();
		initMisc();
	}
	
	public static void initMisc()
	{
		for(int i = 0; i < LibOreDict.FLOWER.length; i++){
			ItemStack stack = OreDictionary.getOres(LibOreDict.FLOWER[i]).get(0);
			FlowerManager.plainFlowers.add(stack);}
	}
	
	public static void initItems()
	{
		
	}
	
	public static void initOreDict()
	{
	}
	
	public static String[] getFlowerArray()
	{
//		return LibOreDict.FLOWER[number];
		String[] string = new String[LibOreDict.FLOWER.length];
		
		for(int i = 0; i < LibOreDict.FLOWER.length; i++)
			string[i] = LibOreDict.FLOWER[i];
		
		return string;
	}
	
	public static ItemStack[] getPetalStackArray()
	{
		ItemStack[] stacks = new ItemStack[LibOreDict.PETAL.length];
		
		for(int i = 0; i < LibOreDict.PETAL.length; i++)
			stacks[i] = OreDictionary.getOres(LibOreDict.PETAL[i]).get(0);

			return stacks;
		
	}
	
	public static int[] getPetalChance()
	{
		int[] chance = new int[LibOreDict.PETAL.length];
		
		for (int i = 0; i < LibOreDict.PETAL.length; i++)
			chance[i] = 3;
		
		return chance;
	}
}
*/