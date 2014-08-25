package forestryextras.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import wasliecore.helpers.Utils;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.apiculture.items.ItemBeeGE;
import forestryextras.blocks.itemblocks.FEItemBlockProducer;
import forestryextras.blocks.tiles.TileEntityProducer;
import forestryextras.main.Main;
import forestryextras.main.init.FEItems;
import forestryextras.main.init.Tabs;

public class FEBlockProducer extends BlockContainer{
	public FEBlockProducer(String blockName) {
		super(Material.glass);
		setCreativeTab(Tabs.tabMain);
		
		setHardness(1.0F);
		setBlockBounds(0.2F, 0F, 0.2F, 0.8F, 1F, 0.8F);
		setBlockName(Main.alias.toLowerCase() + "." + "block" + "." + blockName.toLowerCase());

		GameRegistry.registerBlock(this, FEItemBlockProducer.class, blockName);
		init();
	}
	
	@SideOnly(Side.CLIENT)
	IIcon top;
	@SideOnly(Side.CLIENT)
	IIcon bottom;
	@SideOnly(Side.CLIENT)
	IIcon side;
	
	public void init(){
		loadRecipes();
	}
	
	public void loadRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(this), new Object[]{
			"XIX",
			"XYX",
			"XXX",
			'X', Blocks.glass,
			'I', Blocks.wooden_slab,
			'Y', FEItems.witheriaIngot});
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9){
		if(!world.isRemote){
			TileEntityProducer te = (TileEntityProducer) world.getTileEntity(x, y, z);
			if(te != null){
				ItemStack bee = te.getStackInSlot(0);
				if(player.isSneaking()){
					if(bee != null){
						Utils.dropBlock(world, x, y, z, bee);
						te.setInventorySlotContents(0, null);
						world.markBlockForUpdate(x, y, z);
					}
				}else{
					if(bee == null){
						if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemBeeGE){
							te.setInventorySlotContents(0, player.getCurrentEquippedItem().copy());
							if(player.getHeldItem().stackSize > 1)
								player.inventory.mainInventory[player.inventory.currentItem].stackSize--;
							else
								player.setCurrentItemOrArmor(0, null);
							world.markBlockForUpdate(x, y, z);
						}
					}
				}
			}
		}
		return true;
	}

    @Override
    public boolean isOpaqueCube(){
        return false;
    }


    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }
    
	@Override
    public void registerBlockIcons(IIconRegister ir) {
		top = Blocks.planks.getBlockTextureFromSide(0);
		side = Blocks.glass.getBlockTextureFromSide(0);
		bottom = Blocks.planks.getBlockTextureFromSide(0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int fside, int metadata) {
		if(fside == 0) {
			return bottom;
		} else if(fside == 1) {
			return top;
		} else {
			return side;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityProducer();
	}
}