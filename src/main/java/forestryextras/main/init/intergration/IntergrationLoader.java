package forestryextras.main.init.intergration;

import cpw.mods.fml.common.Loader;

public class IntergrationLoader {

	public static void init()
	{	
		if(Loader.isModLoaded("TinkersConstruct")){
			//System.out.print(initMessage("Tinkers Construct"));
			TinkersConstruct.init();}
		
		if(Loader.isModLoaded("Thaumcraft")){
			System.out.print(initMessage("Thaumcraft"));
			Thaumcraft.init();}
		
		if(Loader.isModLoaded("ThermalExpansion")){
			System.out.print(initMessage("Thermal Expansion"));
			ThermalExpansion.init();}
		
		//if(Loader.isModLoaded("ThaumcraftExtras")){
		//	System.out.print(initMessage("Thaumcraft Extras"));
		//	ThaumcraftExtras.init();}
		
		//if(Loader.isModLoaded("Botania")){
		//	System.out.print(initMessage("Botania"));
		//	Botania.init();}
		
		if(Loader.isModLoaded("BloodMagic")){
			//System.out.print(initMessage("Blood Magic"));
			BloodMagic.init();}
	}
	
	public static void preFullInit()
	{
		if(Loader.isModLoaded("Thaumcraft")){
			Thaumcraft.preInit();}
	}
	
	public static String initMessage(String modName)
	{
		return "[Forestry Extras 2] " + modName + " is installed, adding intergration" + "\n";
	}
	
	public static void initRequired(String modID)
	{
		if(modID == "ThermalExpansion" && Loader.isModLoaded(modID)){
			ThermalExpansion.initRenders();
		}
	}
}
