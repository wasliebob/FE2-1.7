package forestryextras.main.init.intergration;




public class Thaumcraft {

	public static void init()
	{
		initOreClusters();
		initMaterialAspects();
	}
	
	public static void preInit()
	{
		initOreDictRegisters();
	}

	public static void initOreDictRegisters()
	{
//		OreDictionary.registerOre("woodSilverwood", new ItemStack(ConfigBlocks.blockMagicalLog, 1, 1));
//		OreDictionary.registerOre("woodGreatwood", new ItemStack(ConfigBlocks.blockMagicalLog, 1, 0));
//		OreDictionary.registerOre("saplingGreatwood", new ItemStack(ConfigBlocks.blockCustomPlant, 1, 0));
//		OreDictionary.registerOre("saplingSilverwood", new ItemStack(ConfigBlocks.blockCustomPlant, 1, 1));
	}
	
	public static void initOreClusters()
	{

	}
	
	public static void initMaterialAspects()
	{
//		ThaumcraftApi.registerObjectTag(new ItemStack(FEItems.draconicIngot), new AspectList().add(Aspect.MAGIC, 1).add(Aspect.METAL, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(FEItems.reinforcedIngot), new AspectList().add(Aspect.ORDER, 1).add(Aspect.METAL, 1));
//		ThaumcraftApi.registerObjectTag(new ItemStack(FEBlocks.draconicBlock), new AspectList().add(Aspect.MAGIC, 9).add(Aspect.METAL, 9));
//		ThaumcraftApi.registerObjectTag(new ItemStack(FEBlocks.reinforcedBlock),  new AspectList().add(Aspect.ORDER, 9).add(Aspect.METAL, 9));
	}
}
