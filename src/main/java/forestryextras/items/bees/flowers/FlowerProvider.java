package forestryextras.items.bees.flowers;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAlleleFlowers;
import forestry.api.genetics.IFlowerProvider;
import forestry.api.genetics.IIndividual;
import forestry.api.genetics.IPollinatable;

public class FlowerProvider implements IFlowerProvider, IAlleleFlowers{	
	public FlowerProvider(String name){
		this.name = name;
		
	    AlleleManager.alleleRegistry.registerAllele(this);
	}
	public String name;
	public boolean isDominant = true;
	
	@Override
	public String getUID() {
	    return "fe.flower." + this.name;
	}

	@Override
	public boolean isDominant() {
		return this.isDominant;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getUnlocalizedName() {
		return this.name;
	}

	@Override
	public IFlowerProvider getProvider() {
		return this;
	}

	@Override
	public boolean isAcceptedFlower(World world, IIndividual individual, int x, int y, int z){
		Block block = world.getBlock(x, y, z);
		if(block == null)
			return false;
		
		return isAcceptedFlower(world, individual, x, y, z, block);
	}
	
	public boolean isAcceptedFlower(World world, IIndividual individual, int x, int y, int z, Block block){
		return false;
	}
	
	@Override
	public boolean isAcceptedPollinatable(World world,
			IPollinatable pollinatable) {
		return false;
	}

	@Override
	public boolean growFlower(World world, IIndividual individual, int x,
			int y, int z) {
		return false;
	}

	@Override
	public String getDescription() {
		return this.name;
	}

	@Override
	public ItemStack[] affectProducts(World world, IIndividual individual,
			int x, int y, int z, ItemStack[] products) {
		return products;
	}

	@Override
	public ItemStack[] getItemStacks() {
		return null;
	}
}