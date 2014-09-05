package forestryextras.blocks.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import forestryextras.helpers.DirectionHelper;

public class TileCropChecker extends TileEntity{
	public TileCropChecker(){
		front = null;
	}
	public ForgeDirection front;
	public int power;
	
	@Override
	public void updateEntity(){
		if(front != null){
			
			Block block = DirectionHelper.getBlock(worldObj, xCoord, yCoord, zCoord, front);
			int x = DirectionHelper.getX(xCoord, front);
			int y = DirectionHelper.getY(yCoord, front);
			int z = DirectionHelper.getZ(zCoord, front);

			if(block != null && block instanceof IGrowable && !((IGrowable)block).func_149851_a(worldObj, x, y, z, worldObj.isRemote)){
				int newMeta = 15;
				if(newMeta != power){
					power = newMeta;
				}
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				worldObj.notifyBlocksOfNeighborChange(x, y, z, block);
				worldObj.notifyBlocksOfNeighborChange(x + 1, y, z, block);
				worldObj.notifyBlocksOfNeighborChange(x - 1, y, z, block);
				worldObj.notifyBlocksOfNeighborChange(x, y + 1, z, block);
				worldObj.notifyBlocksOfNeighborChange(x, y - 1, z, block);
				worldObj.notifyBlocksOfNeighborChange(x, y, z + 1, block);
				worldObj.notifyBlocksOfNeighborChange(x, y, z - 1, block);
			}else{
				power = 0;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
				worldObj.notifyBlocksOfNeighborChange(x, y, z, block);
				worldObj.notifyBlocksOfNeighborChange(x + 1, y, z, block);
				worldObj.notifyBlocksOfNeighborChange(x - 1, y, z, block);
				worldObj.notifyBlocksOfNeighborChange(x, y + 1, z, block);
				worldObj.notifyBlocksOfNeighborChange(x, y - 1, z, block);
				worldObj.notifyBlocksOfNeighborChange(x, y, z + 1, block);
				worldObj.notifyBlocksOfNeighborChange(x, y, z - 1, block);		
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setInteger("FRONT", this.front.ordinal());
		nbt.setInteger("POWER", this.power);
	}
		
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		this.front = ForgeDirection.getOrientation(nbt.getInteger("FRONT"));
		this.power = nbt.getInteger("POWER");
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
}