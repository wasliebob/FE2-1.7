package forestryextras.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.core.IToolScoop;
import forestry.api.recipes.RecipeManagers;
import forestryextras.main.Main;
import forestryextras.main.init.Tabs;

public class FEItemScoop extends Item implements IToolScoop{

	public FEItemScoop(String itemName, int primaryColor, int secondaryColor, String oreDictName, int maxItemDamage, ItemStack mainMaterial, ItemStack handleMaterial, boolean isEasy, FluidStack recipeFluid, int creationTime) {
		setUnlocalizedName(Main.alias.toLowerCase() + "." + "scoop" + "." + itemName);
		setCreativeTab(Tabs.tabUtilities);
		setMaxDamage(maxItemDamage);
		setMaxStackSize(1);
		name = itemName;
		primColor = primaryColor;
		secColor = secondaryColor;
		oreDict = oreDictName;
		mainMat = mainMaterial;
		handleMat = handleMaterial;
		easy = isEasy;
		recFluid = recipeFluid;
		createTime = creationTime;
		
		GameRegistry.registerItem(this, this.getUnlocalizedName());
		OreDictionary.registerOre(oreDict, this);
        this.setHarvestLevel("scoop", 7);
        recipe(easy);
	}
	String name;
	String oreDict;
	int primColor;
	int secColor;
	ItemStack mainMat;
	ItemStack handleMat;
	boolean easy;
	FluidStack recFluid;
	int createTime;
	IIcon primary;
	IIcon secondary;
	
    public void recipe(boolean easy){
    	if(easy == true){
    		GameRegistry.addShapedRecipe(new ItemStack(this), new Object[]{
    			"XIX",
    			"XXX",
    			" X ",
    			'X', handleMat,
    			'I', mainMat});
    	}else{
    		RecipeManagers.carpenterManager.addRecipe(createTime, recFluid, null, new ItemStack(this), new Object[]{
    			"XIX",
    			"XXX",
    			" X ",
    			'X', handleMat,
    			'I', mainMat});
    	}
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int meta, int renderPass) {
		if(renderPass > 0) {
			return this.primary;
		}
		return this.secondary;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@Override
	public int getRenderPasses(int meta) {
		return 2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int pass){		
		if(pass > 0) {
			return secColor;
		}
		return primColor;
	}
	
	@Override
    public void registerIcons(IIconRegister ir) {
		this.primary = ir.registerIcon(Main.modName.toLowerCase() + ":" + "scoop1");
		this.secondary = ir.registerIcon(Main.modName.toLowerCase() + ":" + "scoop2");
	}
}