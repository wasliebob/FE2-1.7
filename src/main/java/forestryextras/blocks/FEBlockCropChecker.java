package forestryextras.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestryextras.blocks.tiles.TileCropChecker;
import forestryextras.helpers.DirectionHelper;
import forestryextras.main.Main;
import forestryextras.main.init.FEItems;
import forestryextras.main.init.Tabs;

public class FEBlockCropChecker extends BlockContainer{
	public FEBlockCropChecker(String blockName) {
		super(Material.glass);
		setCreativeTab(Tabs.tabMain);
		
		setHardness(1.0F);
		setBlockName(Main.alias.toLowerCase() + "." + "block" + "." + blockName.toLowerCase());

		GameRegistry.registerBlock(this, this.getUnlocalizedName());
		loadRecipes();
	}
	IIcon front;
	IIcon side;
	
	public void loadRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(this), new Object[]{
			"ZIZ",
			"XYX",
			"XXX",
			'X', Items.iron_ingot,
			'I', Items.gold_ingot,
			'Y', FEItems.reinforcedIngot,
			'Z', Items.flower_pot});
	}
    
	@Override
    public void registerBlockIcons(IIconRegister ir){
		front = ir.registerIcon(Main.modName.toLowerCase() + ":" + "checker/" + "checker_front");
		side = ir.registerIcon(Main.modName.toLowerCase() + ":" + "checker/" + "checker_side");
	}
	
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack) {
		super.onBlockPlacedBy(world, x, y, z, living, stack);
		TileCropChecker checker = (TileCropChecker)world.getTileEntity(x, y, z);
		
		ForgeDirection dir = DirectionHelper.getFace(living);
		checker.front = dir;
		world.setBlockMetadataWithNotify(x, y, z, dir.ordinal(), 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int fside, int meta) {
		ForgeDirection dir = ForgeDirection.getOrientation(fside);
		
		if(meta == 0 && dir == ForgeDirection.SOUTH)
            return front;
        else if(fside == meta && fside > 1)
            return front;
		else
			return side;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileCropChecker();
	}
	
	@Override
	public boolean canProvidePower() {
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess acces, int x, int y, int z, int side) {
		return ((TileCropChecker)acces.getTileEntity(x, y, z)).power;
	}
}