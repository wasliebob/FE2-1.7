package forestryextras.main.init.intergration.modularmachines;

import java.util.Random;

import modularmachines.api.classes.TileInteracting;
import modularmachines.api.guide.IGuided;
import modularmachines.api.upgrades.IInteractingAction;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import forestryextras.api.FEApi;

public class UpgradeMutation implements IInteractingAction, IGuided{

	@Override
	public void decreaseHeat(TileInteracting arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasRequired(TileInteracting arg0) {
		return true;
	}

	@Override
	public void increaseHeat(TileInteracting arg0, int arg1) {
		
	}

	@Override
	public void onActivate(TileInteracting arg0, EntityPlayer arg1) {
		
	}

	@Override
	public void onActivateClick(TileInteracting arg0, EntityPlayer arg1) {
		
	}

	@Override
	public void onActivateWithItem(TileInteracting arg0, ItemStack arg1,
			EntityPlayer arg2) {
		
	}

	@Override
	public void onActivateWithProgrammer(TileInteracting arg0, EntityPlayer arg1) {
		
	}

	@Override
	public void onUpdate(TileInteracting ti) {
		World world = ti.getWorldObj();
		int x = ti.xCoord;
		int y = ti.yCoord;
		int z = ti.zCoord;
		
		int min = 1;
		int max = 100;
		Random rand = new Random();
	    int number = rand.nextInt((max - min) + 1) + min;

	    if(number == 1){
			for(int xx = -4; xx < 4; xx++){
				for(int zz = -4; zz < 4; zz++){
					Block block = world.getBlock(x + xx, y, z + zz);
					if(block != null && FEApi.blockMutation.containsKey(block)){
						Block output = FEApi.blockMutation.get(block);
						if(output != null){
							world.setBlock(x + xx, y, z + zz, output);
							xx = 4;
							zz = 4;
							continue;
						}
					}
				}
			}
	    }
	}

	@Override
	public String getKey() {
		return "Upgrade: Mutation";
	}
}