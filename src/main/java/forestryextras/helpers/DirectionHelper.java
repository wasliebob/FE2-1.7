package forestryextras.helpers;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class DirectionHelper {
	public static Block getBlock(World world, int x, int y, int z, ForgeDirection dir){
		if(dir == ForgeDirection.UP)
			return world.getBlock(x, y + 1, z);
		else if(dir == ForgeDirection.DOWN)
			return world.getBlock(x, y - 1, z);
		else if(dir == ForgeDirection.NORTH)
			return world.getBlock(x, y, z - 1);
		else if(dir == ForgeDirection.SOUTH)
			return world.getBlock(x, y, z + 1);
		else if(dir == ForgeDirection.EAST)
			return world.getBlock(x + 1, y, z);
		else if(dir == ForgeDirection.WEST)
			return world.getBlock(x - 1, y, z);
		return null;
	}
	
	public static TileEntity getTileEntity(World world, int x, int y, int z, ForgeDirection dir){
		if(dir == ForgeDirection.UP)
			return world.getTileEntity(x, y + 1, z);
		else if(dir == ForgeDirection.DOWN)
			return world.getTileEntity(x, y - 1, z);
		else if(dir == ForgeDirection.NORTH)
			return world.getTileEntity(x, y, z - 1);
		else if(dir == ForgeDirection.SOUTH)
			return world.getTileEntity(x, y, z + 1);
		else if(dir == ForgeDirection.EAST)
			return world.getTileEntity(x + 1, y, z);
		else if(dir == ForgeDirection.WEST)
			return world.getTileEntity(x - 1, y, z);
		return null;
	}
	
	public static TileEntity getConnectableTile(World world, int x, int y, int z, ForgeDirection dir, int range){
			for(int i = 1; i < range; i++){
				if(dir == ForgeDirection.UP){
					if(world.getTileEntity(x, y + i, z) != null)
						return world.getTileEntity(x, y + i, z);
				}else if(dir == ForgeDirection.DOWN){
					if(world.getTileEntity(x, y - i, z) != null)
						return world.getTileEntity(x, y - i, z);
				}else if(dir == ForgeDirection.NORTH){
					if(world.getTileEntity(x, y, z - i) != null)
						return world.getTileEntity(x, y, z - i);
				}else if(dir == ForgeDirection.SOUTH){
					if(world.getTileEntity(x, y, z + i) != null)
						return world.getTileEntity(x, y, z + i);
				}else if(dir == ForgeDirection.EAST){
					if(world.getTileEntity(x + i, y, z) != null)
						return world.getTileEntity(x + i, y, z);
				}else if(dir == ForgeDirection.WEST){
					if(world.getTileEntity(x - i, y, z) != null)
						return world.getTileEntity(x - i, y, z);
				}
			}
			return null;
	}
	
	public static Block getConnectableBlock(World world, int x, int y, int z, ForgeDirection dir, int range){
		for(int i = 1; i < range; i++){
			if(dir == ForgeDirection.UP){
				if(world.getBlock(x, y + i, z) != null){
					return world.getBlock(x, y + i, z);
				}
			}else if(dir == ForgeDirection.DOWN){
				if(world.getBlock(x, y - i, z) != null){
					return world.getBlock(x, y - i, z);
				}
			}else if(dir == ForgeDirection.NORTH){
				if(world.getBlock(x, y, z - i) != null){
					return world.getBlock(x, y, z - i);
				}
			}else if(dir == ForgeDirection.SOUTH){
				if(world.getBlock(x, y, z + i) != null){
					return world.getBlock(x, y, z + i);
				}
			}else if(dir == ForgeDirection.EAST){
				if(world.getBlock(x + i, y, z) != null){
					return world.getBlock(x + i, y, z);
				}
			}else if(dir == ForgeDirection.WEST){
				if(world.getBlock(x - i, y, z) != null){
					return world.getBlock(x - i, y, z);
				}
			}
		}
		return null;
	}
	
	public static Block getConnectableBlockAndParticles(World world, int x, int y, int z, ForgeDirection dir, int range){
		for(int i = 1; i < range; i++){
			if(dir == ForgeDirection.UP){
				if(world.getBlock(x, y + i, z) != null && world.getBlock(x, y + i, z) != Blocks.air){
					world.spawnParticle("flame", x, y + i, z, 0, 0, 0);
					return world.getBlock(x, y + i, z);
				}
			}else if(dir == ForgeDirection.DOWN){
				if(world.getBlock(x, y - i, z) != null && world.getBlock(x, y - i, z) != Blocks.air){
					world.spawnParticle("flame", x, y - i, z, 0, 0, 0);
					return world.getBlock(x, y - i, z);
				}
			}else if(dir == ForgeDirection.NORTH){
				if(world.getBlock(x, y, z - i) != null && world.getBlock(x, y, z - i) != Blocks.air){
					world.spawnParticle("flame", x, y, z - i, 0, 0, 0);
					return world.getBlock(x, y, z - i);
				}
			}else if(dir == ForgeDirection.SOUTH){
				if(world.getBlock(x, y, z + i) != null && world.getBlock(x, y, z + i) != Blocks.air){
					world.spawnParticle("flame", x, y, z + i, 0, 0, 0);
					return world.getBlock(x, y, z + i);
				}
			}else if(dir == ForgeDirection.EAST){
				if(world.getBlock(x + i, y, z) != null && world.getBlock(x + i, y, z) != Blocks.air){
					world.spawnParticle("flame", x + i, y, z, 0, 0, 0);
					return world.getBlock(x + i, y, z);
				}
			}else if(dir == ForgeDirection.WEST){
				if(world.getBlock(x - i, y, z) != null && world.getBlock(x - i, y, z) != Blocks.air){
					world.spawnParticle("flame", x - i, y, z, 0, 0, 0);
					return world.getBlock(x - i, y, z);
				}
			}
		}
		return null;
	}
	
	public static int getMeta(World world, int x, int y, int z, ForgeDirection dir){
		if(dir == ForgeDirection.UP)
			return world.getBlockMetadata(x, y + 1, z);
		else if(dir == ForgeDirection.DOWN)
			return world.getBlockMetadata(x, y - 1, z);
		else if(dir == ForgeDirection.NORTH)
			return world.getBlockMetadata(x, y, z - 1);
		else if(dir == ForgeDirection.SOUTH)
			return world.getBlockMetadata(x, y, z + 1);
		else if(dir == ForgeDirection.EAST)
			return world.getBlockMetadata(x + 1, y, z);
		else if(dir == ForgeDirection.WEST)
			return world.getBlockMetadata(x - 1, y, z);
		return 0;
	}
	
	public static int getX(int x, ForgeDirection dir){
		if(dir == ForgeDirection.UP)
			return x;
		else if(dir == ForgeDirection.DOWN)
			return x;
		else if(dir == ForgeDirection.NORTH)
			return x;
		else if(dir == ForgeDirection.SOUTH)
			return x;
		else if(dir == ForgeDirection.EAST)
			return x + 1;
		else if(dir == ForgeDirection.WEST)
			return x - 1;
		return x;
	}
	
	public static int getY(int y, ForgeDirection dir){
		if(dir == ForgeDirection.UP)
			return y + 1;
		else if(dir == ForgeDirection.DOWN)
			return y - 1;
		else if(dir == ForgeDirection.NORTH)
			return y;
		else if(dir == ForgeDirection.SOUTH)
			return y;
		else if(dir == ForgeDirection.EAST)
			return y;
		else if(dir == ForgeDirection.WEST)
			return y;
		return y;
	}
	
	public static int getZ(int z, ForgeDirection dir){
		if(dir == ForgeDirection.UP)
			return z;
		else if(dir == ForgeDirection.DOWN)
			return z;
		else if(dir == ForgeDirection.NORTH)
			return z - 1;
		else if(dir == ForgeDirection.SOUTH)
			return z + 1;
		else if(dir == ForgeDirection.EAST)
			return z;
		else if(dir == ForgeDirection.WEST)
			return z;
		return z;
	}
	
	public static ForgeDirection getDirection(World world, int x, int y, int z){
		if(x == +1)
			return ForgeDirection.EAST;
		if(x == -1)
			return ForgeDirection.WEST;
		if(y == +1)
			return ForgeDirection.UP;
		if(y == -1)
			return ForgeDirection.DOWN;
		if(z == +1)
			return ForgeDirection.SOUTH;
		if(z == -1)
			return ForgeDirection.NORTH;
		return null;
	}
	
	public static ForgeDirection getOpposite(ForgeDirection dir){
		if(dir == ForgeDirection.UP)
			return ForgeDirection.DOWN;
		if(dir == ForgeDirection.DOWN)
			return ForgeDirection.UP;
		
		if(dir == ForgeDirection.EAST)
			return ForgeDirection.WEST;
		if(dir == ForgeDirection.WEST)
			return ForgeDirection.EAST;
		
		if(dir == ForgeDirection.SOUTH)
			return ForgeDirection.NORTH;
		if(dir == ForgeDirection.NORTH)
			return ForgeDirection.SOUTH;
		return null;
	}
	
	public static ForgeDirection getFace(EntityLivingBase living){
		ForgeDirection[] faces = new ForgeDirection[]{
				ForgeDirection.NORTH,
				ForgeDirection.EAST,
				ForgeDirection.SOUTH,
				ForgeDirection.WEST};
		int i = MathHelper.floor_double((living.rotationYaw + 45) / 90) & 3;
		
		return faces[i];
	}
}