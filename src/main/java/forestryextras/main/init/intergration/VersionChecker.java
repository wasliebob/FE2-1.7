package forestryextras.main.init.intergration;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.event.FMLInterModComms;
import forestryextras.helpers.util.UpdateHelper;

public class VersionChecker implements IIntergration{

	@Override
	public void prePreInit() {
		
	}

	@Override
	public void preInit() {
		
	}

	@Override
	public void init() {
		NBTTagCompound tag = new NBTTagCompound();
		ArrayList<String> list = UpdateHelper.readFile();
		
		tag.setString("newVersion", list.get(0));
		tag.setString("updateUrl", list.get(1));
		tag.setString("changeLog", list.get(2));
		tag.setBoolean("isDirectLink", true);
		FMLInterModComms.sendMessage("VersionChecker", "addUpdate", tag);
	}

	@Override
	public void postInit() {
		
	}

}