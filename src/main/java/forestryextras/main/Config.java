package forestryextras.main;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {


	public static void loadConfig(FMLPreInitializationEvent e){
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
	    	itemList = config.get(Configuration.CATEGORY_GENERAL, "itemList", e.getModConfigurationDirectory().toString() + "\\ForestryExtras2\\").getString();
	    	mutationList = config.get(Configuration.CATEGORY_GENERAL, "mutationList", e.getModConfigurationDirectory().toString() + "\\ForestryExtras2\\").getString();
	    	frameList = config.get(Configuration.CATEGORY_GENERAL, "frameList", e.getModConfigurationDirectory().toString() + "\\ForestryExtras2\\").getString();
	    	forestryFMP = config.get(Configuration.CATEGORY_GENERAL, "forestryFMP", true).getBoolean(forestryFMP);
	    	config.save();
}
    public static String itemList;
    public static String mutationList;
    public static String frameList;
    public static boolean forestryFMP;
}
