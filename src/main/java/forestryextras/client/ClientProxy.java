package forestryextras.client;

import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import forestryextras.blocks.tiles.TileEntityProducer;
import forestryextras.client.renders.TileEntityProducerRenderer;
import forestryextras.main.CommonProxy;

public class ClientProxy extends CommonProxy {

	@Override
	public void load()
	{
		render();
		registerParticles();
		}
	
	public void render()
    {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityProducer.class, new TileEntityProducerRenderer());
    }
	
	@Override
    public World getClientWorld()
    {
        return FMLClientHandler.instance().getClient().theWorld;
    }
	
	@Override
    public void registerParticles()
    {
    }
	}