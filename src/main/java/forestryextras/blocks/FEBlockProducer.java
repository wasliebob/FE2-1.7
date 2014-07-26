package forestryextras.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
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
	
	public void init()
	{
		loadRecipes();
	}
	
	public void loadRecipes()
	{
		GameRegistry.addShapedRecipe(new ItemStack(this), new Object[]{
			"XIX",
			"XYX",
			"XXX",
			'X', Blocks.glass,
			'I', Blocks.wooden_slab,
			'Y', FEItems.witheriaIngot});
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9)
	{
		if(!world.isRemote){
		TileEntityProducer tile = (TileEntityProducer) world.getTileEntity(x, y, z);
		
		if(!player.isSneaking()){
		if(player.getCurrentEquippedItem() != null){
		if(tile.getStackInSlot(0) == null){
			if(player.getCurrentEquippedItem().getItem() instanceof ItemBeeGE){				
				tile.setInventorySlotContents(0,  player.getCurrentEquippedItem().copy());
				
				if(player.getCurrentEquippedItem().stackSize > 1)
					player.getCurrentEquippedItem().stackSize--;
				else
					player.setCurrentItemOrArmor(0, null);
				
				world.markBlockForUpdate(x, y, z);
			}
		}
		}
		}else{
			if(tile.getStackInSlot(0) != null){
	            dropItems(world, x, y, z);
	            tile.setInventorySlotContents(0, null);
	            world.markBlockForUpdate(x, y, z);
			}
		}
		}

		return true;
	}

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }


    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
	@Override
    public void registerBlockIcons(IIconRegister ir) 
	{
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

    private void dropItems(World world, int x, int y, int z){
            Random rand = new Random();

            TileEntity tileEntity = world.getTileEntity(x, y, z);
            if (!(tileEntity instanceof IInventory)) {
                    return;
            }
            IInventory inventory = (IInventory) tileEntity;

            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                    ItemStack item = inventory.getStackInSlot(i);

                    if (item != null && item.stackSize > 0) {
                            float rx = rand.nextFloat() * 0.8F + 0.1F;
                            float ry = rand.nextFloat() * 0.8F + 0.1F;
                            float rz = rand.nextFloat() * 0.8F + 0.1F;

                            EntityItem entityItem = new EntityItem(world,
                                            x + rx, y + ry, z + rz,
                                            new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

                            if (item.hasTagCompound()) {
                                    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                            }

                            float factor = 0.05F;
                            entityItem.motionX = rand.nextGaussian() * factor;
                            entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                            entityItem.motionZ = rand.nextGaussian() * factor;
                            world.spawnEntityInWorld(entityItem);
                            item.stackSize = 0;
                    }
            }
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityProducer();
	}
}