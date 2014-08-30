package forestryextras.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.recipes.RecipeManagers;
import forestryextras.main.Main;
import forestryextras.main.init.Tabs;

public class FEItemPropolis extends Item{
	public FEItemPropolis(String itemName, int itemColor, FluidStack fluid) {
		setUnlocalizedName(Main.alias.toLowerCase() + "." + "item" + "." + itemName.toLowerCase() + " propolis");
		setCreativeTab(Tabs.tabMain);
		name = itemName;
		color = itemColor;
		
		GameRegistry.registerItem(this, this.getUnlocalizedName());
		
		RecipeManagers.squeezerManager.addRecipe(30, new ItemStack[]{new ItemStack(this)}, fluid);
	}
	String name;
	int color;
	
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int id){
		return color;
	}
	
	@Override
    public void registerIcons(IIconRegister ir) {
        itemIcon = ir.registerIcon(Main.modName.toLowerCase() + ":" + "propolis");
	}
}