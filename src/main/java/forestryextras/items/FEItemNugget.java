package forestryextras.items;

import java.awt.Color;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestryextras.main.Main;
import forestryextras.main.init.Tabs;

public class FEItemNugget extends Item{
	public FEItemNugget(String name, Color color, ItemStack output) {
		setCreativeTab(Tabs.tabMain);
        setUnlocalizedName(Main.alias.toLowerCase() + "." + "nugget" + "." + name.toLowerCase());
		
        this.color = color;
        
        GameRegistry.registerItem(this, this.getUnlocalizedName());
        OreDictionary.registerOre("nugget" + name, this);
        
        if(output != null){
	        GameRegistry.addShapedRecipe(output, new Object[]{
					"XXX",
					"XXX",
					"XXX",
					'X', new ItemStack(this, 1, 0)});
	        GameRegistry.addShapelessRecipe(new ItemStack(this, 9, 0), output);
        }
	}
	public Color color;

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int pass){		
		return color.getRGB();
	}
	
	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(Main.modName.toLowerCase() + ":" + "nugget");
	}
}