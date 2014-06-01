package forestryextras.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import forestryextras.blocks.tiles.TileEntityProducer;
import forestryextras.client.renders.TileEntityProducerRenderer;
import forestryextras.main.CommonProxy;

public class ClientProxy extends CommonProxy {
	@Override
	public void render(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityProducer.class, new TileEntityProducerRenderer());
    }

	@Override
    public void registerParticles(){}
}