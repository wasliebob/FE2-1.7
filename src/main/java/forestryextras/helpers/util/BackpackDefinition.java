package forestryextras.helpers.util;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import forestry.api.storage.IBackpackDefinition;
import forestry.core.config.ForestryItem;

public class BackpackDefinition implements IBackpackDefinition{

	public BackpackDefinition(String key, String name, int primaryColor){
		cont = new ArrayList<ItemStack>();
		this.key = key;
		this.name = name;
		this.primaryColor = primaryColor;
		
		checkForContent();
	}
	String key;
	String name;
	int primaryColor;
	ArrayList<ItemStack> cont;
	
	public void checkForContent()
	{
		if(this.name == "Frame Backpack"){
			cont.add(new ItemStack(ForestryItem.frameImpregnated.item()));
			cont.add(new ItemStack(ForestryItem.frameProven.item()));
			cont.add(new ItemStack(ForestryItem.frameUntreated.item()));
			
			for(ItemStack stack : OreDictionary.getOres("frameForestry"))
				cont.add(stack);
		}
	}
	
	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getPrimaryColour() {
		return this.primaryColor;
	}

	@Override
	public int getSecondaryColour() {
		return 0xFFFFFF;
	}

	@Override
	public void addValidItem(ItemStack validItem) {
		if(!this.cont.contains(validItem))
			this.cont.add(validItem);
	}

	@Override
	public Collection<ItemStack> getValidItems(EntityPlayer player) {
		return this.cont;
	}

	@Override
	public boolean isValidItem(EntityPlayer player, ItemStack itemstack) {
		return this.cont.contains(itemstack);
	}
}