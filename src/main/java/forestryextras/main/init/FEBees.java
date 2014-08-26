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
import forestryextras.items.FEItemComb;
import forestryextras.items.bees.Allele;
import forestryextras.items.bees.BeeClassification;
import forestryextras.items.bees.BeeMutation;
import forestryextras.items.bees.GenomeManager;
import forestryextras.items.bees.Species;
import forestryextras.items.bees.effects.EffectFire;
import forestryextras.items.bees.effects.EffectMana;
import forestryextras.items.bees.effects.EffectPureDaisy;
import forestryextras.items.bees.effects.EffectRegen;
import forestryextras.items.bees.effects.EffectWither;
import forestryextras.main.init.intergration.Botania;

public class FEBees {
	public static void init(){
		initEffects();
		initCombs();
		initSpecies();
		initMutations();
	}
	public static IBeeRoot beeRoot;

	public static void initEffects(){
		regen = new EffectRegen("Regeneration");
		fire = new EffectFire("Flaming");
		wither = new EffectWither("Withering");
		mana = new EffectMana("Mana");
		pureDaisy = new EffectPureDaisy("Pure Daisy");
	}
	public static EffectRegen regen;
	public static EffectFire fire;
	public static EffectWither wither;
	public static EffectMana mana;
	public static EffectPureDaisy pureDaisy;

	public static void initSpecies(){
		beeRoot = (IBeeRoot) AlleleManager.alleleRegistry.getSpeciesRoot("rootBees");
		
		draconicBee = new Species("draconic", "draconic", BeeClassification.DRACONIC, 0x990000, 0xCC0033, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
		draconicBee.addProduct(new ItemStack(FEBees.comb_draconic, 1, 0), 12)
		.setGenome(GenomeManager.getDraconicTemplate())
		.register();
		
		reinforcedBee = new Species("reinforced", "reinforced", BeeClassification.REINFORCED, 0xCCCC99, 0xFFFFCC, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
		reinforcedBee.addProduct(new ItemStack(FEBees.comb_reinforced, 1, 0), 25)
		.setGenome(GenomeManager.getReinforcedTemplate())
		.register();
		
		witheriaBee = new Species("witheria", "witheria", BeeClassification.WITHERIA, 0x000000, 0x333333, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
		witheriaBee.addProduct(new ItemStack(FEBees.comb_witheria, 1, 0), 12)
		.setGenome(GenomeManager.getWitheriaTemplate())
		.register();
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0){
			thaumiumBee = new Species("thaumium", "thaumium", BeeClassification.THAUMIUM, 0x000000, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			thaumiumBee.addProduct(new ItemStack(FEBees.comb_thaumium, 1, 0), 25)
			.setGenome(GenomeManager.getThaumiumTemplate())
			.register();
		}
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotVoid").size() > 0){
			voidBee = new Species("void", "void", BeeClassification.VOID, 0x000000, 0xafffb7, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			voidBee.addProduct(new ItemStack(FEBees.comb_void, 1, 0), 12)
			.setGenome(GenomeManager.getVoidTemplate())
			.register();
		}
		
		if(Loader.isModLoaded("ThaumcraftExtras") && OreDictionary.getOres("ingotDarkThaumium").size() > 0){
			darkThaumiumBee = new Species("darkThaumium", "darkThaumium", BeeClassification.DARKTHAUMIUM, 0xafffb7, 0xafffb7, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			darkThaumiumBee.addProduct(new ItemStack(FEBees.comb_darkThaumium, 1, 0), 25)
			.setGenome(GenomeManager.getDarkThaumiumTemplate())
			.register();
		}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotFairy").size() > 0){
			fairyBee = new Species("fairy", "fairy", BeeClassification.FAIRY, 0xFF66FF, 0xCC3333, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			fairyBee.addProduct(new ItemStack(FEBees.comb_fairy, 1, 0), 25)
			.setGenome(GenomeManager.getFairyTemplate())
			.register();
		}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotPokefennium").size() > 0){
			pokefenniumBee = new Species("pokefennium", "pokefennium", BeeClassification.POKEFENNIUM, 0x99CCFF, 0x9999FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			pokefenniumBee.addProduct(new ItemStack(FEBees.comb_pokefennium, 1, 0), 25)
			.setGenome(GenomeManager.getPokefenniumTemplate())
			.register();
		}
		
		if(OreDictionary.getOres("woodSilverwood").size() > 0){
			silverwoodBee = new Species("silverwood", "silverwood", BeeClassification.SILVERWOOD, 0x99CCFF, 0x9999FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			silverwoodBee.addProduct(OreDictionary.getOres("woodSilverwood").get(0), 60)
			.addProduct(OreDictionary.getOres("saplingSilverwood").get(0), 3)
			.setGenome(GenomeManager.getSilverwoodTemplate())
			.register();
		}
		
		if(OreDictionary.getOres("woodGreatwood").size() > 0){
			greatwoodBee = new Species("greatwood", "greatwood", BeeClassification.GREATWOOD, 0x9966CC, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			greatwoodBee.addProduct(OreDictionary.getOres("woodGreatwood").get(0), 80)
			.addProduct(OreDictionary.getOres("saplingGreatwood").get(0), 3)
			.setGenome(GenomeManager.getGreatwoodTemplate())
			.register();
		}
		
		if(OreDictionary.getOres("ingotConductiveIron").size() > 0){
			conductiveBee = new Species("conductiveIron", "conductiveIron", BeeClassification.CONDUCTIVE, 0xCC3333, 0xFF66FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			conductiveBee.addProduct(new ItemStack(FEBees.comb_conductiveIron, 1, 0), 25)	
			.setGenome(GenomeManager.getConductiveTemplate())
			.register();
		}
		
		if(OreDictionary.getOres("ingotElectricalSteel").size() > 0){
			electricalBee = new Species("electricalSteel", "electricalSteel", BeeClassification.ELECTRICAL, 0xFF66FF, 0xCC3333, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			electricalBee.addProduct(new ItemStack(FEBees.comb_electricalSteel, 1, 0), 25)	
			.setGenome(GenomeManager.getElectricalTemplate())
			.register();
		}
		
		if(OreDictionary.getOres("ingotEnergeticAlloy").size() > 0){
			energeticBee = new Species("energeticAlloy", "energeticAlloy", BeeClassification.ENERGETIC, 0xCC3333, 0x000000, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			energeticBee.addProduct(new ItemStack(FEBees.comb_energeticAlloy, 1, 0), 25)	
			.setGenome(GenomeManager.getEnergeticTemplate())
			.register();}
		
		if(OreDictionary.getOres("ingotVibrantAlloy").size() > 0){
			vibrantBee = new Species("vibrantAlloy", "vibrantAlloy", BeeClassification.VIBRANT, 0x000000, 0xCC0033, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			vibrantBee.addProduct(new ItemStack(FEBees.comb_vibrantAlloy, 1, 0), 25)	
			.setGenome(GenomeManager.getVibrantTemplate())
			.register();
		}
		
		if(OreDictionary.getOres("ingotPulsatingIron").size() > 0){
			pulsatingBee = new Species("pulsatingIron", "pulsatingIron", BeeClassification.PULSATING, 0xCC0033, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false, true);
			pulsatingBee.addProduct(new ItemStack(FEBees.comb_pulsatingIron, 1, 0), 25)	
			.setGenome(GenomeManager.getPulsatingTemplate())
			.register();
		}
		
		if(Loader.isModLoaded("Botania")){
			botanistBee = new Species("botanist", "botanist", BeeClassification.BOTANIST, 0xCC0033, 0xFF99CC, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			botanistBee.addProduct(new ItemStack(FEBees.comb_botanist, 1, 0), 50)	
			.setGenome(GenomeManager.getBotanistTemplate())
			.register();
		}

		if(Loader.isModLoaded("Botania")){
			manaBee = new Species("mana", "mana", BeeClassification.MANA, 0xCC0033, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			manaBee.addProduct(new ItemStack(FEBees.comb_botanist, 1, 0), 50)	
			.setGenome(GenomeManager.getManaTemplate())
			.register();
		}
		
		if(Loader.isModLoaded("Botania")){
			pureDaisyBee = new Species("pureDaisy", "pureDaisy", BeeClassification.PUREDAISY, 0xFF99CC, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false, true);
			pureDaisyBee.addProduct(new ItemStack(FEBees.comb_botanist, 1, 0), 50)	
			.setGenome(GenomeManager.getPureDaisyTemplate())
			.register();
		}
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
	public static Species manaBee;
	public static Species pureDaisyBee;
	public static Species witheriaBee;
	public static Species voidBee;
    public static HashMap<Integer, String> specieNames = new HashMap<Integer, String>();

	public static void initMutations(){
		new BeeMutation(Allele.getBaseSpecies("Industrious"), Allele.getBaseSpecies("Noble"), GenomeManager.getReinforcedTemplate(), 5, false, FEBees.reinforcedBee, "FE2");
		new BeeMutation(Allele.getBaseSpecies("Edenic"), Allele.getBaseSpecies("Industrious"), GenomeManager.getWitheriaTemplate(), 5, false, FEBees.witheriaBee, "FE2");
		new BeeMutation(FEBees.witheriaBee, FEBees.reinforcedBee, GenomeManager.getDraconicTemplate(), 5, false, FEBees.draconicBee, "FE2");
		
		if(OreDictionary.getOres("woodGreatwood").size() > 0){
			new BeeMutation(Allele.getBaseSpecies("Industrious"), Allele.getBaseSpecies("Edenic"), GenomeManager.getGreatwoodTemplate(), 5, false, FEBees.greatwoodBee, "TC4");
		}

		if(OreDictionary.getOres("woodSilverwood").size() > 0 && FEBees.greatwoodBee != null){
			new BeeMutation(FEBees.greatwoodBee, Allele.getBaseSpecies("Edenic"), GenomeManager.getSilverwoodTemplate(), 5, false, FEBees.silverwoodBee, "TC4");
		}

		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0 && FEBees.silverwoodBee != null && FEBees.greatwoodBee != null){
			new BeeMutation(FEBees.silverwoodBee, FEBees.greatwoodBee, GenomeManager.getThaumiumTemplate(), 5, false, FEBees.thaumiumBee, "TC4");
		}
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotVoid").size() > 0 && FEBees.silverwoodBee != null && FEBees.thaumiumBee != null){
			new BeeMutation(FEBees.silverwoodBee, FEBees.thaumiumBee, GenomeManager.getVoidTemplate(), 5, false, FEBees.voidBee, "TC4");
		}
		
		if(Loader.isModLoaded("ThaumcraftExtras") && OreDictionary.getOres("ingotDarkThaumium").size() > 0 && FEBees.thaumiumBee != null){
			new BeeMutation(FEBees.thaumiumBee, Allele.getBaseSpecies("Edenic"), GenomeManager.getDarkThaumiumTemplate(), 5, false, darkThaumiumBee, "TCE");
		}
	
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotPokefennium").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Edenic"), GenomeManager.getPokefenniumTemplate(), 5, false, FEBees.pokefenniumBee, "ExtraTiC");
		}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotFairy").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Heroic"), GenomeManager.getFairyTemplate(), 5, false, FEBees.fairyBee, "ExtraTiC");
		}
		
		if(OreDictionary.getOres("ingotConductiveIron").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Unweary"), GenomeManager.getConductiveTemplate(), 5, false, FEBees.conductiveBee, "EIO");
		}

		if(OreDictionary.getOres("ingotElectricalSteel").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Diligent"), GenomeManager.getElectricalTemplate(), 5, false, FEBees.electricalBee, "EIO");
		}

		if(OreDictionary.getOres("ingotEnergeticAlloy").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Heroic"), GenomeManager.getEnergeticTemplate(), 5, false, FEBees.energeticBee, "EIO");
		}

		if(OreDictionary.getOres("ingotVibrantAlloy").size() > 0){
			new BeeMutation(FEBees.draconicBee, Allele.getBaseSpecies("Heroic"), GenomeManager.getVibrantTemplate(), 5, false, FEBees.vibrantBee, "EIO");
		}
		
		if(OreDictionary.getOres("ingotPulsatingIron").size() > 0){
			new BeeMutation(FEBees.draconicBee, FEBees.energeticBee, GenomeManager.getPulsatingTemplate(), 5, false, FEBees.pulsatingBee, "TC4");
		}

		if(Loader.isModLoaded("Botania")){
			for(int i = 0; i < Botania.getFlowerArray().length; i++)
				new BeeMutation(Allele.getBaseSpecies("Unweary"), Allele.getBaseSpecies("Heroic"), GenomeManager.getBotanistTemplate(), 5, false, FEBees.botanistBee, "Botania");
		}
		
		if(Loader.isModLoaded("Botania")){
			new BeeMutation(FEBees.botanistBee, FEBees.pureDaisyBee, GenomeManager.getManaTemplate(), 5, false, FEBees.manaBee, "Botania");
		}
		
		if(Loader.isModLoaded("Botania")){
			new BeeMutation(FEBees.botanistBee, Allele.getBaseSpecies("Heroic"), GenomeManager.getPureDaisyTemplate(), 5, false, FEBees.pureDaisyBee, "Botania");
		}
	}
	
	public static void initCombs(){
		ItemStack[] products;
		int[] chance;
		
		products = new ItemStack[]{new ItemStack(FEItems.nugget_draconic, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{10, 75};
		comb_draconic = new FEItemComb("Draconic", new Color(0x990000), new Color(0xCC0033), products, chance);
		
		products = new ItemStack[]{new ItemStack(FEItems.nugget_reinforced, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{25, 75};
		comb_reinforced = new FEItemComb("Reinforced", new Color(0xCCCC99), new Color(0xFFFFCC), products, chance);
	
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0){
			products = new ItemStack[]{new ItemStack(FEItems.nugget_thaumium, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{25, 75};
			comb_thaumium = new FEItemComb("Thaumium", new Color(0x000000), new Color(0x9900FF), products, chance);
		}
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotVoid").size() > 0 && OreDictionary.getOres("nuggetVoid").size() > 0){
			products = new ItemStack[]{OreDictionary.getOres("nuggetVoid").get(0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{25, 75};
			comb_void = new FEItemComb("Void", new Color(0x333333), new Color(0x9900FF), products, chance);
		}
	
		if(Loader.isModLoaded("ThaumcraftExtras") && OreDictionary.getOres("ingotDarkThaumium").size() > 0){
			products = new ItemStack[]{new ItemStack(FEItems.nugget_darkThaumium, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{15, 75};
			comb_darkThaumium = new FEItemComb("Dark Thaumium", new Color(0xafffb7), new Color(0xafffb7), products, chance);
		}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotFairy").size() > 0){
			products = new ItemStack[]{new ItemStack(FEItems.nugget_fairy, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{15, 75};
			comb_fairy = new FEItemComb("Fairy", new Color(0xFF99CC), new Color(0xFFCC00), products, chance);
		}
			
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotPokefennium").size() > 0){
			products = new ItemStack[]{new ItemStack(FEItems.nugget_pokefennium, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{15, 75};
			comb_pokefennium = new FEItemComb("Pokefennium", new Color(0x9966CC), new Color(0x99FFCC), products, chance);
		}
		
		if(OreDictionary.getOres("dropHoney").size() > 0){
			products = new ItemStack[]{OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{75};
			comb_normal = new FEItemComb("Normal", new Color(0xFFFF33), new Color(0x999900), products, chance);
		}
			
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotConductiveIron").size() > 0){
			products = new ItemStack[]{new ItemStack(FEItems.nugget_conductiveIron, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{15, 7};
			comb_conductiveIron = new FEItemComb("Conductive Iron", new Color(0xCCCC99), new Color(0x99FFCC), products, chance);
		}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotElectricalSteel").size() > 0){
			products = new ItemStack[]{new ItemStack(FEItems.nugget_electricalSteel, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{15, 75};
			comb_electricalSteel = new FEItemComb("Electrical Steel", new Color(0x999900), new Color(0x99FFCC), products, chance);
		}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotEnergeticAlloy").size() > 0){
			products = new ItemStack[]{new ItemStack(FEItems.nugget_energeticAlloy, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{15, 75};
			comb_energeticAlloy = new FEItemComb("Energetic Alloy", new Color(0xCCCC99), new Color(0xFFCC00), products, chance);
		}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotVibrantAlloy ").size() > 0 && OreDictionary.getOres("nuggetVibrantAlloy").size() > 0){
			products = new ItemStack[]{OreDictionary.getOres("nuggetVibrantAlloy").get(0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{15, 75};
			comb_vibrantAlloy = new FEItemComb("Vibrant Alloy", new Color(0xFFCC00), new Color(0x99FFCC), products, chance);
		}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotPulsatingIron").size() > 0 &&  OreDictionary.getOres("nuggetPulsatingIron").size() > 0){
			products = new ItemStack[]{OreDictionary.getOres("nuggetPulsatingIron").get(0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{15, 75};
			comb_pulsatingIron = new FEItemComb("Pulsating Iron", new Color(0xFFCC00), new Color(0xFFCC00), products, chance);
		}
		
		if(Loader.isModLoaded("Botania")){
			products = Botania.getPetalStackArray();
			chance = Botania.getPetalChance();
			comb_botanist = new FEItemComb("Botanist", new Color(0xCC0033), new Color(0xFF99CC), products, chance);
		}
		
		products = new ItemStack[]{new ItemStack(FEItems.nugget_witheria, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		comb_witheria = new FEItemComb("Witheria", new Color(0x000000), new Color(0x333333), products, chance);
	}
	public static FEItemComb comb_draconic;
	public static FEItemComb comb_reinforced;
	public static FEItemComb comb_witheria;

	public static FEItemComb comb_fairy;
	public static FEItemComb comb_pokefennium;

	public static FEItemComb comb_thaumium;
	public static FEItemComb comb_void;
	public static FEItemComb comb_darkThaumium;

	public static FEItemComb comb_conductiveIron;
	public static FEItemComb comb_electricalSteel;
	public static FEItemComb comb_energeticAlloy;
	public static FEItemComb comb_vibrantAlloy;
	public static FEItemComb comb_pulsatingIron;

	public static FEItemComb comb_normal;
	public static FEItemComb comb_botanist;

	public static boolean doesModItemExist(String modID, String itemName){
		return GameRegistry.findItemStack(modID, itemName, 1) != null;
	}
	
	public static int getColor(int red, int green, int blue){
		Color color = new Color(red, green, blue);
		return color.getRGB();
	}
	
	public static boolean fluidExists(String fluid){
		return FluidRegistry.getFluid(fluid) != null;
	}
}