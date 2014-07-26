package forestryextras.main.init.intergration;



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
//		OreDictionary.registerOre("woodGreatwood", ItemApi.getBlock("blockMagicalLog", 0));
//		OreDictionary.registerOre("saplingSilverwood",  ItemApi.getBlock("blockMagicalLog", 1));
//		
//		OreDictionary.registerOre("woodSilverwood", ItemApi.getBlock("blockCustomPlant", 0));
//		OreDictionary.registerOre("saplingGreatwood", ItemApi.getBlock("blockCustomPlant", 0));
	}
}