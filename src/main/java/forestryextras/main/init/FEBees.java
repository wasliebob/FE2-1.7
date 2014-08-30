package forestryextras.main.init;

import java.awt.Color;
import java.util.HashMap;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.apiculture.IBeeRoot;
import forestry.api.core.EnumHumidity;
import forestry.api.core.EnumTemperature;
import forestry.api.genetics.AlleleManager;
import forestryextras.items.FEItemComb;
import forestryextras.items.FEItemPropolis;
import forestryextras.items.bees.Allele;
import forestryextras.items.bees.BeeBranches;
import forestryextras.items.bees.BeeMutation;
import forestryextras.items.bees.Species;
import forestryextras.items.bees.effects.EffectBloody;
import forestryextras.items.bees.effects.EffectFire;
import forestryextras.items.bees.effects.EffectMana;
import forestryextras.items.bees.effects.EffectMutation;
import forestryextras.items.bees.effects.EffectPureDaisy;
import forestryextras.items.bees.effects.EffectRegen;
import forestryextras.items.bees.effects.EffectWither;
import forestryextras.items.bees.flowers.FlowerBotaniaAdvanced;
import forestryextras.items.bees.flowers.FlowerBotaniaBasic;
import forestryextras.items.bees.flowers.FlowerDragonEgg;
import forestryextras.libs.LibBees;
import forestryextras.main.init.intergration.Botania;

public class FEBees {
	public static void init(){
		initFlowers();
		initEffects();
		initPropolis();
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
		mutation = new EffectMutation("Mutation");
		bloody = new EffectBloody("Bloody");
	}
	public static EffectRegen regen;
	public static EffectFire fire;
	public static EffectWither wither;
	public static EffectMana mana;
	public static EffectPureDaisy pureDaisy;
	public static EffectMutation mutation;
	public static EffectBloody bloody;

	public static void initFlowers(){
		flowerBotaniaBasic = new FlowerBotaniaBasic("Botania Basic");
		flowerBotaniaAdvanced = new FlowerBotaniaAdvanced("Botania Advanced");
		flowerDragonEgg = new FlowerDragonEgg("Dragon Egg");
	}
	public static FlowerBotaniaBasic flowerBotaniaBasic;
	public static FlowerBotaniaAdvanced flowerBotaniaAdvanced;
	public static FlowerDragonEgg flowerDragonEgg;
	
	public static void initSpecies(){
		beeRoot = (IBeeRoot) AlleleManager.alleleRegistry.getSpeciesRoot("rootBees");
		
		draconicBee = new Species("draconic", "draconic", BeeBranches.DEADLY, 0x990000, LibBees.rockBody.getRGB(), EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
		draconicBee.addProduct(new ItemStack(FEBees.comb_draconic, 1, 0), 12)
		.importVanillaTemplate()
		.setCaveDwelling()
		.setNocturnal()
		.setEffect(FEBees.fire)
		.setFlower(FEBees.flowerDragonEgg)
		.register();
		
		reinforcedBee = new Species("reinforced", "reinforced", BeeBranches.METAL, 0xCCCC99, LibBees.rockBody.getRGB(), EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
		reinforcedBee.addProduct(new ItemStack(FEBees.comb_reinforced, 1, 0), 25)
		.importVanillaTemplate()
		.setCaveDwelling()
		.setNocturnal()
		.register();
		
		witheriaBee = new Species("witheria", "witheria", BeeBranches.DEADLY, 0x000000, LibBees.rockBody.getRGB(), EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
		witheriaBee.addProduct(new ItemStack(FEBees.comb_witheria, 1, 0), 12)
		.importVanillaTemplate()
		.setCaveDwelling()
		.setNocturnal()
		.register();
		
		mutatedBee = new Species("mutated", "mutated", BeeBranches.METAL, 0x99CC00, LibBees.rockBody.getRGB(), EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
		mutatedBee.addProduct(new ItemStack(FEBees.comb_mutated, 1, 0), 12)
		.importVanillaTemplate()
		.setCaveDwelling()
		.setNocturnal()
		.setEffect(FEBees.mutation)
		.register();
		
		clayiousBee = new Species("clayious", "clayious", BeeBranches.NATURAL, new Color(176, 196, 222).getRGB(), LibBees.defaultBody.getRGB(), EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
		clayiousBee.addProduct(new ItemStack(FEBees.comb_clayious, 1, 0), 12)
		.importVanillaTemplate()
		.setSpeed("speedFast")
		.register();
		
		potatoBee = new Species("potato", "potato", BeeBranches.CROPS, new Color(238, 232, 170).getRGB(), new Color(240, 230, 140).getRGB(), EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
		potatoBee.addProduct(new ItemStack(Items.potato), 50)
		.addProduct(new ItemStack(Items.poisonous_potato), 25)
		.importVanillaTemplate()
		.setSpeed("speedFast")
		.register();
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0){
			thaumiumBee = new Species("thaumium", "thaumium", BeeBranches.MAGICAL, 0x000000, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
			thaumiumBee.addProduct(new ItemStack(FEBees.comb_thaumium, 1, 0), 25)
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.register();
		}
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotVoid").size() > 0){
			voidBee = new Species("void", "void", BeeBranches.MAGICAL, 0x000000, 0xafffb7, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
			voidBee.addProduct(new ItemStack(FEBees.comb_void, 1, 0), 12)
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.register();
		}
		
		if(Loader.isModLoaded("ThaumcraftExtras") && OreDictionary.getOres("ingotDarkThaumium").size() > 0){
			darkThaumiumBee = new Species("darkThaumium", "darkThaumium", BeeBranches.MAGICAL, 0xafffb7, 0xafffb7, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
			darkThaumiumBee.addProduct(new ItemStack(FEBees.comb_darkThaumium, 1, 0), 25)
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.register();
		}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotFairy").size() > 0){
			fairyBee = new Species("fairy", "fairy", BeeBranches.MAGICAL, 0xFF66FF, 0xCC3333, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
			fairyBee.addProduct(new ItemStack(FEBees.comb_fairy, 1, 0), 25)
			.importVanillaTemplate()
			.register();
		}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotPokefennium").size() > 0){
			pokefenniumBee = new Species("pokefennium", "pokefennium", BeeBranches.MAGICAL, 0x99CCFF, 0x9999FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
			pokefenniumBee.addProduct(new ItemStack(FEBees.comb_pokefennium, 1, 0), 25)
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.register();
		}
		
		if(OreDictionary.getOres("woodSilverwood").size() > 0){
			silverwoodBee = new Species("silverwood", "silverwood", BeeBranches.MAGICAL, 0x99CCFF, 0x9999FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
			silverwoodBee.addProduct(OreDictionary.getOres("woodSilverwood").get(0), 60)
			.importVanillaTemplate()
			.setSpeed("speedFast")
			.register();
		}
		
		if(OreDictionary.getOres("woodGreatwood").size() > 0){
			greatwoodBee = new Species("greatwood", "greatwood", BeeBranches.MAGICAL, 0x9966CC, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
			greatwoodBee.addProduct(OreDictionary.getOres("woodGreatwood").get(0), 80)
			.importVanillaTemplate()
			.setSpeed("speedFast")
			.register();
		}
		
		if(OreDictionary.getOres("ingotConductiveIron").size() > 0){
			conductiveBee = new Species("conductiveIron", "conductiveIron", BeeBranches.METAL, 0xCC3333, 0xFF66FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
			conductiveBee.addProduct(new ItemStack(FEBees.comb_conductiveIron, 1, 0), 25)	
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.register();
		}
		
		if(OreDictionary.getOres("ingotElectricalSteel").size() > 0){
			electricalBee = new Species("electricalSteel", "electricalSteel", BeeBranches.METAL, 0xFF66FF, 0xCC3333, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
			electricalBee.addProduct(new ItemStack(FEBees.comb_electricalSteel, 1, 0), 25)	
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.register();
		}
		
		if(OreDictionary.getOres("ingotEnergeticAlloy").size() > 0){
			energeticBee = new Species("energeticAlloy", "energeticAlloy", BeeBranches.METAL, 0xCC3333, 0x000000, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
			energeticBee.addProduct(new ItemStack(FEBees.comb_energeticAlloy, 1, 0), 25)	
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.register();
		}
		
		if(OreDictionary.getOres("ingotVibrantAlloy").size() > 0){
			vibrantBee = new Species("vibrantAlloy", "vibrantAlloy", BeeBranches.METAL, 0x000000, 0xCC0033, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
			vibrantBee.addProduct(new ItemStack(FEBees.comb_vibrantAlloy, 1, 0), 25)	
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.register();
		}
		
		if(OreDictionary.getOres("ingotPulsatingIron").size() > 0){
			pulsatingBee = new Species("pulsatingIron", "pulsatingIron", BeeBranches.METAL, 0xCC0033, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
			pulsatingBee.addProduct(new ItemStack(FEBees.comb_pulsatingIron, 1, 0), 25)	
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.register();
		}
		
		if(Loader.isModLoaded("Botania")){
			botanistBee = new Species("botanist", "botanist", BeeBranches.NATURAL, 0xCC0033, 0xFF99CC, EnumTemperature.NORMAL, EnumHumidity.NORMAL, false, false, false);
			botanistBee.addProduct(new ItemStack(FEBees.comb_botanist, 1, 0), 50)	
			.importVanillaTemplate()
			.setEffect(FEBees.regen)
			.setFlower(FEBees.flowerBotaniaBasic)
			.register();
		}

		if(Loader.isModLoaded("Botania")){
			manaBee = new Species("mana", "mana", BeeBranches.NATURAL, 0xCC0033, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
			manaBee.addProduct(new ItemStack(FEBees.comb_botanist, 1, 0), 50)	
			.importVanillaTemplate()
			.setCaveDwelling()
			.setNocturnal()
			.setEffect(FEBees.mana)
			.setFlower(FEBees.flowerBotaniaAdvanced)
			.register();
		}
		
		if(Loader.isModLoaded("Botania")){
			pureDaisyBee = new Species("pureDaisy", "pureDaisy", BeeBranches.NATURAL, 0xFF99CC, 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
			pureDaisyBee.addProduct(new ItemStack(FEBees.comb_botanist, 1, 0), 50)	
			.importVanillaTemplate()
			.setEffect(FEBees.regen)
			.setFlower(FEBees.flowerBotaniaBasic)
			.setSpeed("speedFaster")
			.register();
		}
		
		if(FluidRegistry.getFluid("life essence") != null){
			bloodyBee = new Species("bloody", "bloody", BeeBranches.MYSTERIOUS, new Color(128, 0, 0).getRGB(), new Color(255, 0, 0).getRGB(), EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
			bloodyBee.addProduct(new ItemStack(FEBees.comb_bloody, 1, 0), 50)	
			.importVanillaTemplate()
			.setEffect(FEBees.bloody)
			.setSpeed("speedFast")
			.register();
		}
		
		if(OreDictionary.getOres("gemKroostyl").size() > 0){
			kroostylBee = new Species("kroostyl", "kroostyl", BeeBranches.MYSTERIOUS, new Color(255, 0, 0).getRGB(), 0x9900FF, EnumTemperature.NORMAL, EnumHumidity.NORMAL, true, false, false);
			kroostylBee.addProduct(new ItemStack(FEBees.comb_kroostyl, 1, 0), 50)	
			.importVanillaTemplate()
			.setEffect(FEBees.regen)
			.setSpeed("speedSlowest")
			.register();
		}
	}
	public static Species draconicBee;
	public static Species witheriaBee;
	public static Species mutatedBee;
	public static Species reinforcedBee;
	public static Species clayiousBee;
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
	public static Species voidBee;
	public static Species bloodyBee;
	public static Species kroostylBee;
	public static Species potatoBee;
    public static HashMap<Integer, String> specieNames = new HashMap<Integer, String>();

	public static void initMutations(){
		new BeeMutation(Allele.getBaseSpecies("Meadows"), Allele.getBaseSpecies("Noble"), 15, false, FEBees.clayiousBee, "FE2");
		new BeeMutation(Allele.getBaseSpecies("Steadfast"), Allele.getBaseSpecies("Industrious"), 30, false, FEBees.potatoBee, "FE2");

		new BeeMutation(Allele.getBaseSpecies("Industrious"), Allele.getBaseSpecies("Noble"), 5, false, FEBees.reinforcedBee, "FE2");
		new BeeMutation(Allele.getBaseSpecies("Industrious"), FEBees.reinforcedBee, 5, false, FEBees.mutatedBee, "FE2");
		new BeeMutation(Allele.getBaseSpecies("Edenic"), FEBees.mutatedBee, 5, false, FEBees.witheriaBee, "FE2");
		new BeeMutation(FEBees.witheriaBee, FEBees.reinforcedBee, 5, false, FEBees.draconicBee, "FE2");
		
		if(OreDictionary.getOres("woodGreatwood").size() > 0){
			new BeeMutation(Allele.getBaseSpecies("Industrious"), Allele.getBaseSpecies("Edenic"), 5, false, FEBees.greatwoodBee, "TC4");
		}

		if(OreDictionary.getOres("woodSilverwood").size() > 0 && FEBees.greatwoodBee != null){
			new BeeMutation(FEBees.greatwoodBee, Allele.getBaseSpecies("Edenic"), 5, false, FEBees.silverwoodBee, "TC4");
		}

		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0 && FEBees.silverwoodBee != null && FEBees.greatwoodBee != null){
			new BeeMutation(FEBees.silverwoodBee, FEBees.greatwoodBee, 5, false, FEBees.thaumiumBee, "TC4");
		}
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotVoid").size() > 0 && FEBees.silverwoodBee != null && FEBees.thaumiumBee != null){
			new BeeMutation(FEBees.silverwoodBee, FEBees.thaumiumBee, 5, false, FEBees.voidBee, "TC4");
		}
		
		if(Loader.isModLoaded("ThaumcraftExtras") && OreDictionary.getOres("ingotDarkThaumium").size() > 0 && FEBees.thaumiumBee != null){
			new BeeMutation(FEBees.thaumiumBee, Allele.getBaseSpecies("Edenic"), 5, false, darkThaumiumBee, "TCE");
		}
	
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotPokefennium").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Edenic"), 5, false, FEBees.pokefenniumBee, "ExtraTiC");
		}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotFairy").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Heroic"), 5, false, FEBees.fairyBee, "ExtraTiC");
		}
		
		if(OreDictionary.getOres("ingotConductiveIron").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Unweary"), 5, false, FEBees.conductiveBee, "EIO");
		}

		if(OreDictionary.getOres("ingotElectricalSteel").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Diligent"), 5, false, FEBees.electricalBee, "EIO");
		}

		if(OreDictionary.getOres("ingotEnergeticAlloy").size() > 0){
			new BeeMutation(FEBees.reinforcedBee, Allele.getBaseSpecies("Heroic"), 5, false, FEBees.energeticBee, "EIO");
		}

		if(OreDictionary.getOres("ingotVibrantAlloy").size() > 0){
			new BeeMutation(FEBees.draconicBee, Allele.getBaseSpecies("Heroic"), 5, false, FEBees.vibrantBee, "EIO");
		}
		
		if(OreDictionary.getOres("ingotPulsatingIron").size() > 0){
			new BeeMutation(FEBees.draconicBee, FEBees.energeticBee, 5, false, FEBees.pulsatingBee, "TC4");
		}

		if(Loader.isModLoaded("Botania")){
			for(int i = 0; i < Botania.getFlowerArray().length; i++)
				new BeeMutation(Allele.getBaseSpecies("Unweary"), Allele.getBaseSpecies("Heroic"), 5, false, FEBees.botanistBee, "Botania");
		}
		
		if(Loader.isModLoaded("Botania")){
			new BeeMutation(FEBees.botanistBee, FEBees.pureDaisyBee, 5, false, FEBees.manaBee, "Botania");
		}
		
		if(Loader.isModLoaded("Botania")){
			new BeeMutation(FEBees.botanistBee, Allele.getBaseSpecies("Heroic"), 5, false, FEBees.pureDaisyBee, "Botania");
		}
		
		if(OreDictionary.getOres("gemKroostyl").size() > 0){
			new BeeMutation(FEBees.mutatedBee, FEBees.draconicBee, 1, false, FEBees.kroostylBee, "OOD");
		}
		
		if(FluidRegistry.getFluid("life essence") != null){
			new BeeMutation(Allele.getBaseSpecies("Edenic"), FEBees.mutatedBee, 5, false, FEBees.bloodyBee, "BM");
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
	
		products = new ItemStack[]{new ItemStack(FEItems.nugget_witheria, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		comb_witheria = new FEItemComb("Witheria", new Color(0x000000), new Color(0x333333), products, chance);
		
		products = new ItemStack[]{new ItemStack(FEItems.nugget_mutatedIron, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		comb_mutated = new FEItemComb("Mutated", new Color(0x99CC00), new Color(0x333333), products, chance);
		
		products = new ItemStack[]{new ItemStack(Items.clay_ball, 1, 0), OreDictionary.getOres("dropHoney").get(0)};
		chance = new int[]{15, 75};
		comb_clayious = new FEItemComb("Clayious", new Color(176, 196, 222), new Color(0x333333), products, chance);
		
		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0 && OreDictionary.getOres("nuggetThaumium").size() > 0){
			products = new ItemStack[]{OreDictionary.getOres("nuggetThaumium").get(0), OreDictionary.getOres("dropHoney").get(0)};
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
		
		if(FluidRegistry.getFluid("life essence") != null){
			products = new ItemStack[]{new ItemStack(FEBees.propolis_bloody), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{40, 75};
			comb_bloody = new FEItemComb("Bloody", new Color(128, 0, 0), new Color(255, 0, 0), products, chance);
		}
		
		if(OreDictionary.getOres("gemKroostyl").size() > 0){
			products = new ItemStack[]{OreDictionary.getOres("gemKroostyl").get(0), OreDictionary.getOres("dropHoney").get(0)};
			chance = new int[]{2, 75};
			comb_kroostyl = new FEItemComb("Kroostyl", new Color(255, 0, 10), new Color(0x333333), products, chance);
		}
	}
	public static FEItemComb comb_draconic;
	public static FEItemComb comb_reinforced;
	public static FEItemComb comb_witheria;
	public static FEItemComb comb_mutated;

	public static FEItemComb comb_clayious;
	
	public static FEItemComb comb_bloody;

	public static FEItemComb comb_kroostyl;
	
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

	public static void initPropolis(){
		if(FluidRegistry.getFluid("life essence") != null)
			propolis_bloody = new FEItemPropolis("bloody", new Color(178, 34, 34).getRGB(), new FluidStack(FluidRegistry.getFluid("life essence"), 50));
	}
	public static FEItemPropolis propolis_bloody;
	
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