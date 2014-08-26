package forestryextras.items.bees.effects;

import java.util.Random;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaReceiver;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;

public class EffectMana extends BeeEffect{

	public EffectMana(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public IEffectData doEffect(IBeeGenome genome, IEffectData storedData,
			IBeeHousing housing, World world, int x, int y, int z){
		int min = 1;
		int max = 35;
		Random rand = new Random();
	    int number = rand.nextInt((max - min) + 1) + min;

	    if(number == 1){
			for(int xx = -4; xx < 4; xx++){
				for(int zz = -4; zz < 4; zz++){
					TileEntity tile = world.getTileEntity(x + xx, y, z + zz);
					if(tile != null && tile instanceof IManaReceiver){
						IManaReceiver mana = (IManaReceiver)tile;
						mana.recieveMana(1);
					}
				}
			}
	    }
	    return null;
	}
}