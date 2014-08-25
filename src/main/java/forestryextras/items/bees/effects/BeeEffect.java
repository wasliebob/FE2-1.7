package forestryextras.items.bees.effects;

import net.minecraft.world.World;
import forestry.api.apiculture.IAlleleBeeEffect;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IEffectData;

public class BeeEffect implements IAlleleBeeEffect{
	public BeeEffect(String name){
		this.name = name;
		this.combinable = false;
		this.dominant = true;
		
		AlleleManager.alleleRegistry.registerAllele(this);
	}
	public String name;
	public boolean combinable;
	public boolean dominant;
	
	@Override
	public boolean isCombinable() {
		return this.combinable;
	}

	@Override
	public IEffectData validateStorage(IEffectData storedData) {
		return storedData;
	}

	@Override
	public String getUID() {
	    return "fe.effect." + this.name;
	}

	@Override
	public boolean isDominant() {
		return this.combinable;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getUnlocalizedName() {
		return this.getUID();
	}

	@Override
	public IEffectData doEffect(IBeeGenome genome, IEffectData storedData,
			IBeeHousing housing){
		return doEffect(genome, storedData, housing, housing.getWorld(), housing.getXCoord(), housing.getYCoord(), housing.getZCoord());
	}

	@Override
	public IEffectData doFX(IBeeGenome genome, IEffectData storedData,
			IBeeHousing housing){
		return doFX(genome, storedData, housing, housing.getWorld(), housing.getXCoord(), housing.getYCoord(), housing.getZCoord());
	}

	public IEffectData doEffect(IBeeGenome genome, IEffectData storedData,
			IBeeHousing housing, World world, int x, int y, int z) {
		return null;
	}

	public IEffectData doFX(IBeeGenome genome, IEffectData storedData,
			IBeeHousing housing, World world, int x, int y, int z) {
		return null;
	}
}