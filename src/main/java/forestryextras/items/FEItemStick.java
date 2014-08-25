package forestryextras.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestryextras.main.Main;
import forestryextras.main.init.Tabs;

public class FEItemStick extends Item{

	public FEItemStick(String itemName, int itemColor, String oreDictName, String oreDictMaterial) {
		super();
		setUnlocalizedName(Main.alias.toLowerCase() + "." + "item" + "." + itemName);
		setCreativeTab(Tabs.tabMain);
		name = itemName;
		color = itemColor;
		oreDict = oreDictName;
		mat = oreDictMaterial;
		isOreDict = true;
		
		GameRegistry.registerItem(this, this.getUnlocalizedName());
		OreDictionary.registerOre(oreDict, this);
		recipes();
	}
	
	public FEItemStick(String itemName, int itemColor, String oreDictName, ItemStack material) {
		super();
		setUnlocalizedName(Main.alias.toLowerCase() + "." + "item" + "." + itemName);
		setCreativeTab(Tabs.tabMain);
		name = itemName;
		color = itemColor;
		oreDict = oreDictName;
		item = material;
		isOreDict = false;
		
		GameRegistry.registerItem(this, this.getUnlocalizedName());
		OreDictionary.registerOre(oreDict, this);
		recipes();
	}
	String name;
	String oreDict;
	int color;
	String mat;
	ItemStack item;
	boolean isOreDict;
	
	public void recipes(){
		if(isOreDict == true){
			for(ItemStack stack : OreDictionary.getOres(mat)){
				GameRegistry.addShapedRecipe(new ItemStack(this, 4, 0), new Object[]{
					" X",
					"X ",
					'X', stack});
			}
		}else{
			GameRegistry.addShapedRecipe(new ItemStack(this, 4, 0), new Object[]{
				" X",
				"X ",
				'X', item});
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int id){
		return color;
	}
	
	@Override
    public void registerIcons(IIconRegister ir) {
        itemIcon = ir.registerIcon(Main.modName.toLowerCase() + ":" + "stick");
	}
}