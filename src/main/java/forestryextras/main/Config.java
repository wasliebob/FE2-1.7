package forestryextras.main;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {


	public static void loadConfig(FMLPreInitializationEvent e){
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
	    	list = config.get(Configuration.CATEGORY_GENERAL, "list", e.getModConfigurationDirectory().toString()).getString();
	    	forestryFMP = config.get(Configuration.CATEGORY_GENERAL, "forestryFMP", true).getBoolean(forestryFMP);
	    	config.save();
}
    public static String list;
    public static boolean forestryFMP;
}
