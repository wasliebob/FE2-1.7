package forestryextras.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestryextras.main.Main;
import forestryextras.main.init.Tabs;

public class FEBlock extends Block {

	public FEBlock(Material mat, String blockName, String textureName, boolean isIngotBlock, float lightValue, ItemStack craftMaterial) {
		super(mat);
		setCreativeTab(Tabs.tabMain);
		setLightLevel(lightValue);
		setBlockName(Main.alias.toLowerCase() + "." + "block" + "." + blockName);
		setHardness(1.0F);
		
		name = blockName;
		isIBlock = isIngotBlock;
		lValue = lightValue;
		craftMat = craftMaterial;
		texture = textureName;
		init();
	}
	String name;
	String texture;
	float lValue;
	boolean isIBlock;
	ItemStack craftMat;
	
	public void init()
	{
		GameRegistry.registerBlock(this, name);
		
		if(isIBlock && craftMat != null)
			addRecipe();
	}
	
	public void addRecipe()
	{
		GameRegistry.addShapedRecipe(new ItemStack(this), new Object[]{
		"XXX",
		"XXX",
		"XXX",
		'X', craftMat});
		
		GameRegistry.addShapelessRecipe(new ItemStack(craftMat.getItem(), 9, 0), this);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir) 
	{
        blockIcon = ir.registerIcon(Main.modName.toLowerCase() + ":" + texture);
	}	
}
