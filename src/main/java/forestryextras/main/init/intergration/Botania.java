package forestryextras.main.init.intergration;

import forestry.api.apiculture.FlowerManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Botania {
	public static void init(){
		initItems();
		initMisc();
	}
	public static final String[] FLOWER = new String[]{"mysticFlowerWhite", "mysticFlowerOrange", "mysticFlowerMagenta", "mysticFlowerLightBlue", "mysticFlowerYellow", "mysticFlowerLime", "mysticFlowerPink", "mysticFlowerGray", "mysticFlowerLightGray", "mysticFlowerCyan", "mysticFlowerPurple", "mysticFlowerBlue", "mysticFlowerBrown", "mysticFlowerGreen", "mysticFlowerRed", "mysticFlowerBlack"};
	public static final String[] PETAL = new String[]{"petalWhite", "petalOrange", "petalMagenta", "petalLightBlue", "petalYellow", "petalLime", "petalPink", "petalGray", "petalLightGray", "petalCyan", "petalPurple", "petalBlue", "petalBrown", "petalGreen", "petalRed", "petalBlack"}; //Ripped from botania to get all available petals as an String (Ore Dictionary)
	
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
//		return LibOreDict.FLOWER[number];
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