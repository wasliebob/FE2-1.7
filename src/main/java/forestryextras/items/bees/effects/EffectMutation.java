package forestryextras.items.bees.effects;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestryextras.api.FEApi;

public class EffectMutation extends BeeEffect{
	public EffectMutation(String name) {
		super(name);
		this.name = name;
	}
	
	@Override
	public IEffectData doEffect(IBeeGenome genome, IEffectData storedData,
			IBeeHousing housing, World world, int x, int y, int z){
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
						}
					}
				}
			}
	    }
	    return null;
	}
}