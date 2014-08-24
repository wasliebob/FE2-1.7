package forestryextras.client.renders;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import forestryextras.blocks.tiles.TileEntityProducer;

public class TileEntityProducerRenderer extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x,
			double y, double z, float ticks) {
		TileEntityProducer te = ((TileEntityProducer) tile);
		if(te.getStackInSlot(0) != null)
			renderItem(te, x, y, z, ticks);
	}

	public void renderItem(TileEntityProducer te, double x, double y, double z, float ticks){
		GL11.glPushMatrix();
		float h = MathHelper.sin(ticks % 32767.0F / 16.0F) * 0.05F;
		GL11.glTranslated(x + 0.5D, y + 0.5D + h, z + 0.5D);

		EntityItem ei = null;
		ei = new EntityItem(te.getWorldObj(), 0.0D, 0.0D, 0.0D, te.getStackInSlot(0).copy());
		ei.hoverStart = 0.0F;

		RenderManager.instance.renderEntityWithPosYaw(ei, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);

		GL11.glPopMatrix();
	}
}