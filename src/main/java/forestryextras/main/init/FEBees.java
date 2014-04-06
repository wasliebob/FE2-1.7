package forestryextras.main.init;

import java.awt.Color;
import java.util.HashMap;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.apiculture.IBeeRoot;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.genetics.AlleleManager;
import forestryextras.helpers.CombHelper;
import forestryextras.items.FEItemComb;
import forestryextras.items.bees.Allele;
import forestryextras.items.bees.BeeClassification;
import forestryextras.items.bees.BeeMutation;
import forestryextras.items.bees.GenomeManager;
import forestryextras.items.bees.Species;

public class FEBees {

	public static void init()
	{
		initCombs();
		initSpecies();
		initMutations();
	}
	public static IBeeRoot beeRoot;

	public static void initSpecies()
	{
		beeRoot = (IBeeRoot) AlleleManager.alleleRegistry.getSpeciesRoot("rootBees");
		
		draconicBee = new Species("draconic", "draconic", BeeClassification.DRACONIC, 0x990000, 0xCC0033, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
		draconicBee.addProduct(new ItemStack(FEBees.comb, 1, 0), 12)
		.setGenome(GenomeManager.getDraconicTemplate())
		.register();
		
		reinforcedBee = new Species("reinforced", "reinforced", BeeClassification.REINFORCED, 0xCCCC99, 0xFFFFCC, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
		reinforcedBee.addProduct(new ItemStack(FEBees.comb, 1, 1), 25)
		.setGenome(GenomeManager.getReinforcedTemplate())
		.register();
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0){
			thaumiumBee = new Species("thaumium", "thaumium", BeeClassification.THAUMIUM, 0x000000, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			thaumiumBee.addProduct(new ItemStack(FEBees.comb, 1, 2), 25)
			.setGenome(GenomeManager.getThaumiumTemplate())
			.register();}
		
		if(Loader.isModLoaded("ThaumcraftExtras") && OreDictionary.getOres("ingotDarkThaumium").size() > 0){
			darkThaumiumBee = new Species("darkThaumium", "darkThaumium", BeeClassification.DARKTHAUMIUM, 0xafffb7, 0xafffb7, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			darkThaumiumBee.addProduct(new ItemStack(FEBees.comb, 1, 3), 25)
			.setGenome(GenomeManager.getDarkThaumiumTemplate())
			.register();}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotFairy").size() > 0){
			fairyBee = new Species("fairy", "fairy", BeeClassification.FAIRY, 0xFF66FF, 0xCC3333, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			fairyBee.addProduct(new ItemStack(FEBees.comb, 1, 4), 25)
			.setGenome(GenomeManager.getFairyTemplate())
			.register();}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotPokefennium").size() > 0){
			pokefenniumBee = new Species("pokefennium", "pokefennium", BeeClassification.POKEFENNIUM, 0x99CCFF, 0x9999FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			pokefenniumBee.addProduct(new ItemStack(FEBees.comb, 1, 5), 25)
			.setGenome(GenomeManager.getPokefenniumTemplate())
			.register();}
		
		if(OreDictionary.getOres("woodSilverwood").size() > 0){
			silverwoodBee = new Species("silverwood", "silverwood", BeeClassification.SILVERWOOD, 0x99CCFF, 0x9999FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			silverwoodBee.addProduct(OreDictionary.getOres("woodSilverwood").get(0), 60)
			.addProduct(OreDictionary.getOres("saplingSilverwood").get(0), 3)
			.setGenome(GenomeManager.getSilverwoodTemplate())
			.register();}
		
		if(OreDictionary.getOres("woodGreatwood").size() > 0){
			greatwoodBee = new Species("greatwood", "greatwood", BeeClassification.GREATWOOD, 0x9966CC, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			greatwoodBee.addProduct(OreDictionary.getOres("woodGreatwood").get(0), 80)
			.addProduct(OreDictionary.getOres("saplingGreatwood").get(0), 3)
			.setGenome(GenomeManager.getGreatwoodTemplate())
			.register();}
		
		if(OreDictionary.getOres("ingotConductiveIron").size() > 0){
			conductiveBee = new Species("conductiveIron", "conductiveIron", BeeClassification.CONDUCTIVE, 0xCC3333, 0xFF66FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			conductiveBee.addProduct(new ItemStack(FEBees.comb, 1, 6), 25)	
			.setGenome(GenomeManager.getConductiveTemplate())
			.register();}
		
		if(OreDictionary.getOres("ingotElectricalSteel").size() > 0){
			electricalBee = new Species("electricalSteel", "electricalSteel", BeeClassification.ELECTRICAL, 0xFF66FF, 0xCC3333, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			electricalBee.addProduct(new ItemStack(FEBees.comb, 1, 7), 25)	
			.setGenome(GenomeManager.getElectricalTemplate())
			.register();}
		
		if(OreDictionary.getOres("ingotEnergeticAlloy").size() > 0){
			energeticBee = new Species("energeticAlloy", "energeticAlloy", BeeClassification.ENERGETIC, 0xCC3333, 0x000000, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			energeticBee.addProduct(new ItemStack(FEBees.comb, 1, 8), 25)	
			.setGenome(GenomeManager.getEnergeticTemplate())
			.register();}
		
		if(OreDictionary.getOres("ingotVibrantAlloy").size() > 0){
			vibrantBee = new Species("vibrantAlloy", "vibrantAlloy", BeeClassification.VIBRANT, 0x000000, 0xCC0033, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			vibrantBee.addProduct(new ItemStack(FEBees.comb, 1, 9), 25)	
			.setGenome(GenomeManager.getVibrantTemplate())
			.register();}
		
		if(OreDictionary.getOres("ingotPulsatingIron").size() > 0){
			pulsatingBee = new Species("pulsatingIron", "pulsatingIron", BeeClassification.PULSATING, 0xCC0033, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			pulsatingBee.addProduct(new ItemStack(FEBees.comb, 1, 10), 25)	
			.setGenome(GenomeManager.getPulsatingTemplate())
			.register();}
		
		if(Loader.isModLoaded("Botania")){
			botanistBee = new Species("botanist", "botanist", BeeClassification.BOTANIST, 0xCC0033, 0xFF99CC, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			botanistBee.addProduct(new ItemStack(FEBees.comb, 1, 11), 50)	
			.setGenome(GenomeManager.getBotanistTemplate())
			.register();}

	}
	public static Species draconicBee;
	public static Species reinforcedBee;
	public static Species darkThaumiumBee;
	public static Species thaumiumBee;
	public static Species pokefenniumBee;
	public static Species fairyBee;
	public static Species silverwoodBee;
	public static Species greatwoodBee;
	public static Species electricalBee;
	public static Species conductiveBee;
	public static Species energeticBee;
	public static Species vibrantBee;
	public static Species pulsatingBee;
	public static Species botanistBee;
    public static HashMap<Integer, String> specieNames = new HashMap<Integer, String>();

	public static void initMutations()
	{
		new BeeMutation(Allele.getBaseSpecies("Industrious"), Allele.getBaseSpecies("Noble"), GenomeManager.getReinforcedTemplate(), 5, false, FEBees.reinforcedBee, "FE2");
		new BeeMutation(Allele.getBaseSpecies("Industrious"), FEBees.reinforcedBee, GenomeManager.getDraconicTemplate(), 5, false, FEBees.draconicBee, "FE2");
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0){
			new BeeMutation(FEBees.silverwoodBee, FEBees.greatwoodBee, GenomeManager.getThaumiumTemplate(), 5, false, FEBees.thaumiumBee, "TC4");}
		
		if(Loader.isModLoaded("ThaumcraftExtras") && OreDictionary.getOres("ingotDarkThaumium").size() > 0){
			new BeeMutation(FEBees.thaumiumBee, Allele.getBaseSpecies("Edenic"), GenomeManager.getDarkThaumiumTemplate(), 5, false, darkThaumiumBee, "TCE");}
	
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotPokefennium").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Edenic"), GenomeManager.getPokefenniumTemplate(), 5, false, FEBees.pokefenniumBee, "ExtraTiC");}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotFairy").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Heroic"), GenomeManager.getFairyTemplate(), 5, false, FEBees.fairyBee, "ExtraTiC");}
		
		if(OreDictionary.getOres("woodGreatwood").size() > 0){
			new BeeMutation(Allele.getBaseSpecies("Industrious"), Allele.getBaseSpecies("Edenic"), GenomeManager.getGreatwoodTemplate(), 5, false, FEBees.greatwoodBee, "TC4");}

		if(OreDictionary.getOres("woodSilverwood").size() > 0){
			new BeeMutation(FEBees.greatwoodBee, Allele.getBaseSpecies("Edenic"), GenomeManager.getSilverwoodTemplate(), 5, false, FEBees.silverwoodBee, "TC4");}

		if(OreDictionary.getOres("ingotConductiveIron").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Unweary"), GenomeManager.getConductiveTemplate(), 5, false, FEBees.conductiveBee, "EIO");}

		if(OreDictionary.getOres("ingotElectricalSteel").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Diligent"), GenomeManager.getElectricalTemplate(), 5, false, FEBees.electricalBee, "EIO");}

		if(OreDictionary.getOres("ingotEnergeticAlloy").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Heroic"), GenomeManager.getEnergeticTemplate(), 5, false, FEBees.energeticBee, "EIO");}

		if(OreDictionary.getOres("ingotVibrantAlloy").size() > 0){
			new BeeMutation(FEBees.draconicBee, Allele.getBaseSpecies("Heroic"), GenomeManager.getVibrantTemplate(), 5, false, FEBees.vibrantBee, "EIO");}

		if(OreDictionary.getOres("ingotPulsatingIron").size() > 0){
			new BeeMutation(FEBees.draconicBee, FEBees.energeticBee, GenomeManager.getPulsatingTemplate(), 5, false, FEBees.pulsatingBee, "TC4");}

		//if(Loader.isModLoaded("Botania")){
		//	for(int i = 0; i < Botania.getFlowerArray().length; i++)
		//		new BeeMutation(Allele.getBaseSpecies("Unweary"), Allele.getBaseSpecies("Heroic"), GenomeManager.getBotanistTemplate(), 5, false, Bees.botanistBee, "Botania");}

		//if(Loader.isModLoaded("EnderIO") && doesModItemExist("EnderIO", "Electrical Steel")){
			//new BeeMutation(Bees.reinforcedBee, Allele.getBaseSpecies("Unweary"), GenomeManager.getElectricSteelTemplate(), 5);}
		
	}
	
	public static void initCombs()
	{
		//HashMap<ItemStack, Integer> products = new HashMap<ItemStack, Integer>();
		ItemStack[] products;
		int[] chance;
		
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{10, 75};
		CombHelper.addCombToMap(0, "Draconic", 0x990000, 0xCC0033, products, chance);
		
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 1), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{25, 75};
		CombHelper.addCombToMap(1, "Reinforced", 0xCCCC99, 0xFFFFCC, products, chance);
	
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0){
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 2), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{25, 75};
		CombHelper.addCombToMap(2, "Thaumium", 0x000000, 0x9900FF, products, chance);}
	
		if(Loader.isModLoaded("ThaumcraftExtras") && OreDictionary.getOres("ingotDarkThaumium").size() > 0){
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 3), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		CombHelper.addCombToMap(3, "Dark Thaumium", 0xafffb7, 0xafffb7, products, chance);}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotFairy").size() > 0){
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 4), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		CombHelper.addCombToMap(3, "Fairy", 0xFF99CC, 0xFFCC00, products, chance);}
			
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotPokefennium").size() > 0){
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 5), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		CombHelper.addCombToMap(4, "Pokefennium", 0x9966CC, 0x99FFCC, products, chance);}
		
		if(OreDictionary.getOres("dropHoney").size() > 0){
		products = new ItemStack[]{OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{75};
		CombHelper.addCombToMap(5, "Normal", 0xFFFF33 , 0x999900, products, chance);}
			
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotConductiveIron").size() > 0){
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 6), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		CombHelper.addCombToMap(6, "Conductive Iron", 0xCCCC99, 0x99FFCC, products, chance);}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotElectricalSteel").size() > 0){
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 7), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		CombHelper.addCombToMap(7, "Electrical Steel", 0x999900, 0x99FFCC, products, chance);}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotEnergeticAlloy").size() > 0){
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 8), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		CombHelper.addCombToMap(8, "Energetic Alloy", 0xCCCC99, 0xFFCC00, products, chance);}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotVibrantAlloy ").size() > 0){
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 9), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		CombHelper.addCombToMap(9, "Vibrant Alloy", 0xFFCC00, 0x99FFCC, products, chance);}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotPulsatingIron").size() > 0){
		products = new ItemStack[]{new ItemStack(FEItems.nugget, 1, 10), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		CombHelper.addCombToMap(10, "Pulsating Iron", 0xFFCC00, 0xFFCC00, products, chance);}
		
		//if(Loader.isModLoaded("Botania")){
		//products = Botania.getPetalStackArray();
		//chance = Botania.getPetalChance();
		//CombHelper.addCombToMap(11, "Botanist", 0xCC0033, 0xFF99CC, products, chance);}
		
		//if(Loader.isModLoaded("EnderIO") && doesModItemExist("EnderIO", "Electrical Steel")){
		//products = new ItemStack[]{new ItemStack(Items.nugget, 1, 6), GameRegistry.findItemStack("EnderIO", "Electrical Steel", 1)};
		//chance = new int[]{15, 75};
		//CombHelper.addCombToMap(4, "Electrical Steel", 0x999966, 0xFFFFCC, products, chance);}
		
		comb = new FEItemComb();
		CombHelper.addRecipes();
	}
	public static FEItemComb comb;
	
	public static boolean doesModItemExist(String modID, String itemName)
	{
		return GameRegistry.findItemStack(modID, itemName, 1) != null;
	}
	
	public static int getColor(int red, int green, int blue)
	{
		Color color = new Color(red, green, blue);
		return color.getRGB();
	}
	
	public static boolean fluidExists(String fluid)
	{
		return FluidRegistry.getFluid(fluid) != null;
	}
}