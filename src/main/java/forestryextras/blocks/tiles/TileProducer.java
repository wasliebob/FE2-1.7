package forestryextras.blocks.tiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import wasliecore.helpers.MathHelper;
import wasliecore.helpers.Utils;
import forestry.core.config.ForestryItem;
import forestryextras.helpers.BeeHelper;

public class TileProducer extends TileEntity implements ISidedInventory{
	public TileProducer(){
		stacks = new ItemStack[1];
		time = MathHelper.secondToTick(5);
		turns = 32;
	}
	public ItemStack[] stacks;
	public int time;

	public int turns;

    @Override
    public void updateEntity() {
    	if(!worldObj.isRemote){
    		if(turns == 0){
    			stacks[0] = null;
    			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    		}else{
    			if(time != 0)
    				time--;
    		
    			if(time == 0){
    				ItemStack stack = getStackInSlot(0);
    				if(stack != null && BeeHelper.getComb(stack) != null){
//    					ItemStack comb = BeeHelper.getComb(stack);
    					ItemStack comb = new ItemStack(ForestryItem.beeComb.item());
    					Utils.dropBlock(worldObj, xCoord, yCoord, zCoord, comb);

    					this.turns--;
    					this.time = MathHelper.secondToTick(5);
    				}
    			}
    		}
    	}
    }
    

	@Override
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		
		NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < stacks.length; i++) {
        	ItemStack stack = stacks[i];
        	if (stack != null) {
        		NBTTagCompound tag = new NBTTagCompound();
        		tag.setByte("Slot", (byte) i);
        		stack.writeToNBT(tag);
        		itemList.appendTag(tag);
        	}
        }
        nbt.setTag("Inventory", itemList);
	}
		
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		
		NBTTagList tagList = nbt.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < stacks.length) {
				stacks[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	
	@Override
	public Packet getDescriptionPacket() {
	    NBTTagCompound tagCompound = new NBTTagCompound();
	    writeToNBT(tagCompound);
	    
	    return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, -999, tagCompound);
	}
	
	@Override
	public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity packet) {
		this.readFromNBT(packet.func_148857_g());
	}

	@Override
	public int getSizeInventory() {
		return stacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return stacks[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (stacks[i] != null){

            if (stacks[i].stackSize <= j){
                ItemStack itemstack = stacks[i];
                stacks[i] = null;
                return itemstack;
            }else{
            	ItemStack itemstack1 = stacks[i].splitStack(j);

                if (stacks[i].stackSize == 0){
                    stacks[i] = null;
                }

                return itemstack1;
            }
        }else{
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
	      if (stacks[i] != null){
	    	  ItemStack itemstack = stacks[i];
	    	  stacks[i] = null;
	    	  return itemstack;
	      }else{
	    	  return null;
	      }
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		 stacks[i] = itemstack;

	        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()){
	            itemstack.stackSize = getInventoryStackLimit();
	        } 
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		  if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this){
			  return false;
		  }
		  return player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		return null;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return false;
	}

	@Override
	public String getInventoryName() {
		return "fe2.producer";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {		
	}
}