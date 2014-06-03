package forestryextras.items.donator;

import java.awt.Color;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestryextras.helpers.IngotHelper;
import forestryextras.main.Main;
import forestryextras.main.init.Tabs;

public class FEItemDonatorIngot extends Item{
	public FEItemDonatorIngot() {
		setCreativeTab(Tabs.tabMain);
        setHasSubtypes(true);
        setUnlocalizedName(Main.alias.toLowerCase() + "." + "ingot");
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}
//	
//	@Override
//	public String getUnlocalizedName(ItemStack stack) {
//		String unlocalizedStackName = IngotHelper.name.get(stack.getItemDamage());
//		if (unlocalizedStackName != null)
//			return unlocalizedStackName.toLowerCase() ;
//		return unlocalizedStackName;
//	}
	
	@Override
    public String getItemStackDisplayName(ItemStack stack){
    	return IngotHelper.name.get(stack.getItemDamage());
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public void getSubItems(Item item, CreativeTabs tab, List list){
		for(int i = 0; i < IngotHelper.ingots.size(); i++) {
			int meta = IngotHelper.ingots.get(i);
			list.add(new ItemStack(item, 1, meta));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int pass)
	{		
		if(IngotHelper.color.containsKey(stack.getItemDamage())){
			return IngotHelper.color.get(stack.getItemDamage());
		}else{
			return Color.white.getRGB();
		}
	}
	
	@Override
    public void registerIcons(IIconRegister ir) 
	{
        itemIcon = ir.registerIcon(Main.modName.toLowerCase() + ":" + "ingot");
	}
}