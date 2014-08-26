package forestryextras.main.init.intergration;

import vazkii.botania.common.lib.LibOreDict;
import forestry.api.apiculture.FlowerManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Botania {
	public static void init(){
		initItems();
		initMisc();
	}
	public static final String[] FLOWER = LibOreDict.FLOWER;
	public static final String[] PETAL = LibOreDict.PETAL;
	
	public static void initMisc(){
		for(int i = 0; i < FLOWER.length; i++){
			ItemStack stack = OreDictionary.getOres(FLOWER[i]).get(0);
			FlowerManager.plainFlowers.add(stack);}
	}
	
	public static void initItems(){
		
	}
	
	public static void initOreDict(){
	}
	
	public static String[] getFlowerArray(){
		String[] string = new String[FLOWER.length];
		
		for(int i = 0; i < FLOWER.length; i++)
			string[i] = FLOWER[i];
		
		return string;
	}
	
	public static ItemStack[] getPetalStackArray(){
//		ItemStack[] stacks = new ItemStack[LibOreDict.PETAL.length];
		ItemStack[] stacks = new ItemStack[16];

		for(int i = 0; i < PETAL.length; i++)
			stacks[i] = OreDictionary.getOres(PETAL[i]).get(0);

			return stacks;
		
	}
	
	public static int[] getPetalChance(){
		int[] chance = new int[PETAL.length];
//		int[] chance = new int[16];
		for (int i = 0; i < chance.length; i++)
			chance[i] = 3;
		
		return chance;
	}
}