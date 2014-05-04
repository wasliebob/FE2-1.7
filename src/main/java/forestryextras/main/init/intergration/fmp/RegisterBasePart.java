package forestryextras.main.init.intergration.fmp;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import codechicken.lib.vec.BlockCoord;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.MultiPartRegistry.IPartConverter;
import codechicken.multipart.MultiPartRegistry.IPartFactory;
import codechicken.multipart.TMultiPart;
import forestry.core.config.ForestryBlock;

public class RegisterBasePart implements IPartFactory, IPartConverter {
	Block block = null;
	Class<? extends TMultiPart> part = null;
	String name = "";

	public RegisterBasePart(Block block, Class<? extends TMultiPart> part) {
		try {
			this.name = ((TMultiPart)part.getConstructor(new Class[0]).newInstance(new Object[0])).getType();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RegisterBasePart(Block block, Class<? extends TMultiPart> part, String name) {
		this.block = block;
		this.part = part;
		this.name = name;
	}

	@Override
	public TMultiPart createPart(String name, boolean client) {
		if (name.equals(name))
			try {
		        return (TMultiPart)this.part.getConstructor(new Class[0]).newInstance(new Object[0]);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		return null;
	}

	public void init() {
		if (name.isEmpty() || block == null || part == null)
			return;

		MultiPartRegistry.registerConverter(this);
		MultiPartRegistry.registerParts(this, new String[] { name });
	}

	@Override
	public TMultiPart convert(World world, BlockCoord pos) {
		Block wb = world.getBlock(pos.x, pos.y, pos.z);
		if (wb == this.block) {
			try {		
		        return (TMultiPart)this.part.getConstructor(new Class[0]).newInstance(new Object[0]);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public Iterable<Block> blockTypes() {
		ArrayList<Block> bl = new ArrayList<Block>();
		bl.add(ForestryBlock.candle);
		return bl;
	}
}