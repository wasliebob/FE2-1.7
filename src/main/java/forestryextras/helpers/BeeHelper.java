package forestryextras.helpers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import forestry.apiculture.items.ItemArmorApiarist;
import forestry.core.config.ForestryItem;
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
	
	public static boolean hasFullSuit(EntityPlayer player){
		ItemStack helmetStack = player.getEquipmentInSlot(4);
		ItemStack chestplateStack = player.getEquipmentInSlot(3);
		ItemStack legsStack = player.getEquipmentInSlot(2);
		ItemStack bootsStack = player.getEquipmentInSlot(1);

		if(helmetStack != null && chestplateStack != null && legsStack != null && bootsStack != null){
			Item helmet = helmetStack.getItem();
			Item chestplate = chestplateStack.getItem();
			Item legs = legsStack.getItem();
			Item boots = bootsStack.getItem();
			return (helmet == ForestryItem.apiaristHat.item()) && (chestplate == ForestryItem.apiaristChest.item()) && (legs == ForestryItem.apiaristLegs.item()) && (boots == ForestryItem.apiaristBoots.item());
		}
		return false;
	}
}