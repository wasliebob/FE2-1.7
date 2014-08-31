package forestryextras.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import forestryextras.blocks.tiles.TileProducer;
import forestryextras.client.renders.TileEntityProducerRenderer;
import forestryextras.main.CommonProxy;

public class ClientProxy extends CommonProxy {
	@Override
	public void render(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileProducer.class, new TileEntityProducerRenderer());
    }
	
	@Override
    public void registerParticles(){}
}