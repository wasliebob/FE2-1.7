package forestryextras.main.init.intergration;

import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;

public class Thaumcraft implements IIntergration{

	@Override
	public void prePreInit(){}
	
	public void preInit(){
		initOreDict();
	}
	
	public void init(){}
	
	public void postInit(){
		initAspects();
	}
	
	public void initItems(){}
	
	public void initAspects(){
		
	}
	
	public void initOreDict(){
		OreDictionary.registerOre("woodGreatwood", ItemApi.getBlock("blockMagicalLog", 0));
		OreDictionary.registerOre("woodSilverwood", ItemApi.getBlock("blockMagicalLog", 1));

		OreDictionary.registerOre("saplingGreatwood", ItemApi.getBlock("blockCustomPlant", 0));
		OreDictionary.registerOre("saplingSilverwood",  ItemApi.getBlock("blockCustomPlant", 1));	
	}
}