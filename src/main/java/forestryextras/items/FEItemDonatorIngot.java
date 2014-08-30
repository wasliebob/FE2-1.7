package forestryextras.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestryextras.main.Main;
import forestryextras.main.init.Tabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class FEItemDonatorIngot extends Item{
	public FEItemDonatorIngot(String itemName, int itemColor, String oreDictName) {
		setUnlocalizedName(Main.alias.toLowerCase() + "." + "item" + "." + itemName.toLowerCase() + " ingot");
		setCreativeTab(Tabs.tabMain);
		name = itemName;
		color = itemColor;
		oreDict = oreDictName;
		
		GameRegistry.registerItem(this, this.getUnlocalizedName());
		OreDictionary.registerOre(oreDict, this);
	}
	String name;
	String oreDict;
	int color;
	
	@Override
    public String getItemStackDisplayName(ItemStack stack){
    	return this.name + " Ingot";
    }
	
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int id){
		return color;
	}
	
	@Override
    public void registerIcons(IIconRegister ir) {
        itemIcon = ir.registerIcon(Main.modName.toLowerCase() + ":" + "ingot");
	}
}