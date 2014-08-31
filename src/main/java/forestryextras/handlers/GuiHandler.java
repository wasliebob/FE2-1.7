package forestryextras.handlers;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	  @Override
      public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
              TileEntity tile = world.getTileEntity(x, y, z);
              switch(id){
              default: return false;
              }
      }

      @Override
      public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
              TileEntity tile = world.getTileEntity(x, y, z);
              Block block = world.getBlock(x, y, z);
              switch(id){
              default: return false;
              }

      }
}