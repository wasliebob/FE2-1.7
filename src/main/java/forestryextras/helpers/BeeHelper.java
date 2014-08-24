package forestryextras.helpers;

import net.minecraft.item.ItemStack;
import forestry.plugins.PluginApiculture;


public class BeeHelper {
	public static ItemStack getComb(ItemStack bee){
		ItemStack[] stacks = getProducts(bee);
		
		ItemStack out = null;
		for(ItemStack stack : stacks){
			if(stack.getDisplayName().contains("Comb")){
				out = stack;
			}
		}

		return out;
	}
	
	public static ItemStack[] getProducts(ItemStack bee){
		return PluginApiculture.beeInterface.getMember(bee).getProduceList();
	}
}