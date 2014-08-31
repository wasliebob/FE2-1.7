package forestryextras.main;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	public static void loadConfig(FMLPreInitializationEvent e){
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
	    	list = config.get(Configuration.CATEGORY_GENERAL, "list", e.getModConfigurationDirectory().toString()).getString();
	    	forestryFMP = config.get(Configuration.CATEGORY_GENERAL, "forestryFMP", true).getBoolean(forestryFMP);
	    	dragonEggRecipe = config.get(Configuration.CATEGORY_GENERAL, "dragonEggRecipe", true).getBoolean(dragonEggRecipe);
	    	unstableBee = config.get(Configuration.CATEGORY_GENERAL, "unstableBee", true).getBoolean(unstableBee);
	    	config.save();
}
    public static String list;
    public static boolean forestryFMP;
    public static boolean dragonEggRecipe;
    public static boolean unstableBee;
}