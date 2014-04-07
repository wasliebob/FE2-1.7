package forestryextras.main.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import forestryextras.helpers.NuggetHelper;
import forestryextras.items.FEItemFrame;
import forestryextras.items.FEItemGrafter;
import forestryextras.items.FEItemIngot;
import forestryextras.items.FEItemNugget;
import forestryextras.items.FEItemScoop;
import forestryextras.items.FEItemStick;

public class FEItems {

	public static void init()
	{
		initItems();
		initFrames();
		initScoops();
		initGrafters();
		initModSupportItems();
		initModSupportFrames();
		initWorldGen();
		initNuggets();
	}
	
	public static void initItems()
	{
		draconicIngot = new FEItemIngot("draconicIngot", 0xFF0000, "ingotDraconic");
		reinforcedIngot = new FEItemIngot("reinforcedIngot", 0x999999, "ingotReinforced");
		witheriaIngot = new FEItemIngot("witheriaIngot", 0x333333, "ingotWitheria");
		alfiumIngot = new FEItemIngot("alfiumIngot", 0x663366, "ingotAlfium");
		ryuIngot = new FEItemIngot("ryuIngot", 0x990000, "ingotRyu");
		itariusIngot = new FEItemIngot("itariusIngot", 0xCCFFCC, "ingotItarius");
		coalStick = new FEItemStick("coalStick", 0x000000, "stickCoal", new ItemStack(Items.coal));
		diamondStick = new FEItemStick("diamondStick", 0x99FFFF, "stickDiamond", new ItemStack(Items.diamond));
		draconicStick = new FEItemStick("draconicStick", 0xFF0000, "stickDraconic", new ItemStack(FEItems.draconicIngot));
		emeraldStick = new FEItemStick("emeraldStick", 0x99FF33, "stickEmerald", new ItemStack(Items.emerald));
		goldStick = new FEItemStick("goldStick", 0xFFFF66, "stickGold", new ItemStack(Items.gold_ingot));
		ironStick = new FEItemStick("ironStick", 0xFFFFCC, "stickIron", new ItemStack(Items.iron_ingot));
		mutationStick = new FEItemStick("mutationStick", 0x99CC00, "stickMutation", new ItemStack(Items.nether_star));
		obsidianStick = new FEItemStick("obsidianStick", 0x999966, "stickObsidian", new ItemStack(Blocks.obsidian));
		reinforcedStick = new FEItemStick("reinforcedStick", 0xCCCC99, "stickReinforced", new ItemStack(FEItems.reinforcedIngot));
		alfiumStick = new FEItemStick("alfiumStick", 0x663366, "stickAlfium", new ItemStack(FEItems.alfiumIngot));
		witheriaStick = new FEItemStick("witheriaStick", 0x333333, "stickWitheria", new ItemStack(FEItems.witheriaIngot));
		itariusStick = new FEItemStick("itariusStick", 0xCCFFCC, "stickItarius", new ItemStack(FEItems.itariusIngot));
	}
	public static FEItemIngot draconicIngot;
	public static FEItemIngot reinforcedIngot;
	public static FEItemIngot alfiumIngot;
	public static FEItemIngot ryuIngot;
	public static FEItemIngot witheriaIngot;
	public static FEItemIngot itariusIngot;
	
	public static FEItemStick coalStick;
	public static FEItemStick diamondStick;
	public static FEItemStick draconicStick;
	public static FEItemStick emeraldStick;
	public static FEItemStick goldStick;
	public static FEItemStick ironStick;
	public static FEItemStick mutationStick;
	public static FEItemStick obsidianStick;
	public static FEItemStick reinforcedStick;
	public static FEItemStick alfiumStick;
	public static FEItemStick witheriaStick;
	public static FEItemStick itariusStick;

	public static void initFrames()
	{
		coalFrame = new FEItemFrame(100, false, false, false, false, 1.0F, 1.0F, 1.1F, 1.0F, 1.0F, 1.0F, "frameCoal", "frameCoal", "frame", 0x000000, new ItemStack(Items.string), new ItemStack(FEItems.coalStick), true, null, 0);
		ironFrame = new FEItemFrame(200, false, false, false, false, 1.0F, 1.0F, 1.2F, 1.0F, 1.0F, 1.0F, "frameIron", "frameIron", "frame", 0xFFFFCC, new ItemStack(Items.string), new ItemStack(FEItems.ironStick), false, new FluidStack(FluidRegistry.LAVA, 10), 10);
    	goldFrame = new FEItemFrame(150, false, false, false, false, 1.0F, 1.0F, 1.3F, 1.0F, 1.0F, 1.0F, "frameGold", "frameGold", "frame", 0xFFFF66, new ItemStack(Items.string), new ItemStack(FEItems.goldStick), false, new FluidStack(FluidRegistry.LAVA, 10), 10);
		diamondFrame = new FEItemFrame(250, false, false, false, false, 1.0F, 1.0F, 1.4F, 1.0F, 1.0F, 1.0F, "frameDiamond", "frameDiamond", "frame", 0xCCFFFF, new ItemStack(Items.string), new ItemStack(FEItems.diamondStick), false, new FluidStack(FluidRegistry.LAVA, 10), 12);
		emeraldFrame = new FEItemFrame(300, false, false, false, false, 1.0F, 1.0F, 1.5F, 1.0F, 1.0F, 1.0F, "frameEmerald", "frameEmerald", "frame", 0x99FF66, new ItemStack(Items.string), new ItemStack(FEItems.emeraldStick), false, new FluidStack(FluidRegistry.LAVA, 10), 14);
		reinforcedFrame = new FEItemFrame(500, false, false, false, false, 1.0F, 1.0F, 1.4F, 1.0F, 1.0F, 1.0F, "frameReinforced", "frameReinforced", "frame", 0xCCCC99, new ItemStack(Items.string), new ItemStack(FEItems.reinforcedStick), false, new FluidStack(FluidRegistry.LAVA, 15), 20);
		witheriaFrame = new FEItemFrame(750, false, false, false, false, 1.0F, 1.0F, 2.0F, 1.0F, 1.0F, 1.0F, "frameWitheria", "frameWitheria", "frame", 0x333333, new ItemStack(Items.blaze_powder), new ItemStack(FEItems.witheriaStick), false, new FluidStack(FluidRegistry.LAVA, 15), 20);
		draconicFrame = new FEItemFrame(1000, false, false, false, false, 1.0F, 1.0F, 2.5F, 1.0F, 1.0F, 1.0F, "frameDraconic", "frameDraconic", "frame", 0xFF0000, new ItemStack(Items.string), new ItemStack(FEItems.draconicStick), false, new FluidStack(FluidRegistry.LAVA, 100), 100);
		mutationFrame = new FEItemFrame(25, false, false, false, false, 1.0F, 1.0F, 1.0F, 1.0F, 10.0F, 1.0F, "frameMutation", "frameMutation", "frame", 0x99CC00, new ItemStack(Items.ender_pearl), new ItemStack(FEItems.mutationStick), true, null, 0);
		alfiumFrame = new FEItemFrame(750, false, false, false, false, 1.0F, 1.0F, 1.5F, 1.0F, 1.0F, 1.0F, "frameAlfium", "frameAlfium", "frame", 0x663366, new ItemStack(Items.string), new ItemStack(FEItems.alfiumStick), false, new FluidStack(FluidRegistry.LAVA, 15), 20);
		itariusFrame = new FEItemFrame(800, false, false, false, false, 1.0F, 1.0F, 1.4F, 1.0F, 1.0F, 1.0F, "frameItarius", "frameItarius", "frame", 0xCCFFCC, new ItemStack(Items.string), new ItemStack(FEItems.itariusStick), false, new FluidStack(FluidRegistry.LAVA, 15), 20);
	}
	public static FEItemFrame coalFrame;
	public static FEItemFrame ironFrame;
	public static FEItemFrame goldFrame;
	public static FEItemFrame diamondFrame;
	public static FEItemFrame emeraldFrame;
	public static FEItemFrame reinforcedFrame;
	public static FEItemFrame draconicFrame;
	public static FEItemFrame mutationFrame;
	public static FEItemFrame obsidianFrame;
	public static FEItemFrame alfiumFrame;
	public static FEItemFrame witheriaFrame;
	public static FEItemFrame itariusFrame;

	public static void initScoops()
	{
		reinforcedScoop = new FEItemScoop("scoopReinforced", 0xFFFFFF, 0x999999, "scoopReinforced", 300, new ItemStack(FEItems.reinforcedIngot), new ItemStack(FEItems.reinforcedStick), true, null, 0);
		draconicScoop = new FEItemScoop("scoopDraconic", 0xFFFFFF, 0xFF0000, "scoopDraconic", 700, new ItemStack(FEItems.draconicIngot), new ItemStack(FEItems.draconicStick), true, null, 0);
	}
	public static FEItemScoop reinforcedScoop;
	public static FEItemScoop draconicScoop;

	public static void initGrafters()
	{
		reinforcedGrafter = new FEItemGrafter("grafterReinforced", 0x996633, 0x999999, "grafterReinforced", 300, 1.5F, new ItemStack(FEItems.reinforcedIngot), new ItemStack(FEItems.reinforcedStick), true, null, 0);
		draconicGrafter = new FEItemGrafter("grafterDraconic", 0x996633, 0xFF0000, "grafterDraconic", 700, 2.0F, new ItemStack(FEItems.draconicIngot), new ItemStack(FEItems.draconicStick), true, null, 0);
	}
	public static FEItemGrafter draconicGrafter;
	public static FEItemGrafter reinforcedGrafter;

	public static void initModSupportFrames()
	{
		if(OreDictionary.getOres("ingotAlumite").size() > 0)
			alumiteFrame = new FEItemFrame(500, false, false, false, false, 1.0F, 1.0F, 1.5F, 1.0F, 1.0F, 1.0F, "frameAlumite", "frameAlumite", "frame", 0xFF33FF, new ItemStack(Items.string), new ItemStack(FEItems.alumiteStick), true, null, 0);

		if(OreDictionary.getOres("ingotArdite").size() > 0)
			arditeFrame = new FEItemFrame(750, false, false, false, false, 1.0F, 1.0F, 1.6F, 1.0F, 1.0F, 1.0F, "frameArdite", "frameArdite", "frame", 0xCC6633, new ItemStack(Items.string), new ItemStack(FEItems.arditeStick), true, null, 0);

		if(OreDictionary.getOres("ingotBronze").size() > 0)
			bronzeFrame = new FEItemFrame(450, false, false, false, false, 1.0F, 1.0F, 1.2F, 1.0F, 1.0F, 1.0F, "frameBronze", "frameBronze", "frame", 0x996633, new ItemStack(Items.string), new ItemStack(FEItems.bronzeStick), true, null, 0);

		if(OreDictionary.getOres("ingotCobalt").size() > 0)
			cobaltFrame = new FEItemFrame(750, false, false, false, false, 1.0F, 1.0F, 1.7F, 1.0F, 1.0F, 1.0F, "frameCobalt", "frameCobalt", "frame", 0x0099CC, new ItemStack(Items.string), new ItemStack(FEItems.cobaltStick), true, null, 0);

		if(OreDictionary.getOres("ingotCopper").size() > 0)
			copperFrame = new FEItemFrame(225, false, false, false, false, 1.0F, 1.0F, 1.1F, 1.0F, 1.0F, 1.0F, "frameCopper", "frameCopper", "frame", 0xFFCC33, new ItemStack(Items.string), new ItemStack(FEItems.copperStick), true, null, 0);

		if(OreDictionary.getOres("ingotLead").size() > 0)
			leadFrame = new FEItemFrame(400, false, false, false, false, 1.0F, 1.0F, 1.2F, 1.0F, 1.0F, 1.0F, "frameLead", "frameLead", "frame", 0x9999CC, new ItemStack(Items.string), new ItemStack(FEItems.leadStick), true, null, 0);
		
		if(OreDictionary.getOres("ingotManyullyn").size() > 0)
			manyullynFrame = new FEItemFrame(1000, false, false, false, false, 1.0F, 1.0F, 2.0F, 1.0F, 1.0F, 1.0F, "frameManyullyn", "frameManyullyn", "frame", 0x9966FF, new ItemStack(Items.string), new ItemStack(FEItems.manyullynStick), true, null, 0);

		if(OreDictionary.getOres("ingotSilver").size() > 0)
			silverFrame = new FEItemFrame(400, false, false, false, false, 1.0F, 1.0F, 1.2F, 1.0F, 1.0F, 1.0F, "frameSilver", "frameSilver", "frame", 0xFFFFCC, new ItemStack(Items.string), new ItemStack(FEItems.silverStick), true, null, 0);

		if(OreDictionary.getOres("ingotSteel").size() > 0)
			steelFrame = new FEItemFrame(400, false, false, false, false, 1.0F, 1.0F, 1.2F, 1.0F, 1.0F, 1.0F, "frameSteel", "frameSteel", "frame", 0x999966, new ItemStack(Items.string), new ItemStack(FEItems.steelStick), true, null, 0);
		
		if(OreDictionary.getOres("ingotTin").size() > 0)
			tinFrame = new FEItemFrame(200, false, false, false, false, 1.0F, 1.0F, 1.1F, 1.0F, 1.0F, 1.0F, "frameTin", "frameTin", "frame", 0xFFFFCC, new ItemStack(Items.string), new ItemStack(FEItems.tinStick), true, null, 0);
		
		if(OreDictionary.getOres("ingotPokefennium").size() > 0)
			pokefenniumFrame = new FEItemFrame(800, false, false, false, false, 1.0F, 1.0F, 1.8F, 1.0F, 1.0F, 1.0F, "framePokefennium", "framePokefennium", "frame", 0x99CC99, new ItemStack(Items.string), new ItemStack(FEItems.pokefenniumStick), true, null, 0);
		
		if(OreDictionary.getOres("ingotFairy").size() > 0)
			fairyFrame = new FEItemFrame(800, false, false, false, false, 1.0F, 1.0F, 1.7F, 1.0F, 1.0F, 1.0F, "frameFairy", "frameFairy", "frame", 0xFF99FF, new ItemStack(Items.string), new ItemStack(FEItems.fairyStick), true, null, 0);
		
		if(OreDictionary.getOres("ingotThaumium").size() > 0)
			thaumiumFrame = new FEItemFrame(600, false, false, false, false, 1.0F, 1.0F, 1.4F, 1.0F, 1.0F, 1.0F, "frameThaumium", "frameThaumium", "frame", 0x9966FF, new ItemStack(Items.string), new ItemStack(FEItems.thaumiumStick), true, null, 0);

		if(OreDictionary.getOres("ingotDarkThaumium").size() > 0)
			darkThaumiumFrame = new FEItemFrame(1000, false, false, false, false, 1.0F, 1.0F, 1.9F, 1.0F, 1.0F, 1.0F, "frameDarkThaumium", "frameDarkThaumium", "frame", 0x993399, new ItemStack(Items.string), new ItemStack(FEItems.darkThaumiumStick), true, null, 0);
		
		if(OreDictionary.getOres("ingotVoid").size() > 0)
			voidFrame = new FEItemFrame(1000, false, false, false, false, 1.0F, 1.0F, 1.9F, 1.0F, 1.0F, 1.0F, "frameVoid", "frameVoid", "frame", 0x9900CC, new ItemStack(Items.string), new ItemStack(FEItems.voidStick), true, null, 0);
	}
	public static FEItemFrame alumiteFrame;
	public static FEItemFrame arditeFrame;
	public static FEItemFrame bronzeFrame;
	public static FEItemFrame cobaltFrame;
	public static FEItemFrame copperFrame;
	public static FEItemFrame leadFrame;
	public static FEItemFrame manyullynFrame;
	public static FEItemFrame silverFrame;
	public static FEItemFrame steelFrame;
	public static FEItemFrame tinFrame;
	public static FEItemFrame pokefenniumFrame;
	public static FEItemFrame fairyFrame;
	public static FEItemFrame thaumiumFrame;
	public static FEItemFrame darkThaumiumFrame;
	public static FEItemFrame voidFrame;

	public static void initModSupportItems()
	{
		if(OreDictionary.getOres("ingotAlumite").size() > 0)
			alumiteStick = new FEItemStick("alumiteStick", 0xFF33FF, "stickAlumite", "ingotAlumite");

		if(OreDictionary.getOres("ingotArdite").size() > 0)
			arditeStick = new FEItemStick("arditeStick", 0xCC6633, "stickArdite", "ingotArdite");

		if(OreDictionary.getOres("ingotBronze").size() > 0)
			bronzeStick = new FEItemStick("bronzeStick", 0x996633, "stickBronze", "ingotBronze");

		if(OreDictionary.getOres("ingotCobalt").size() > 0)
			cobaltStick = new FEItemStick("cobaltStick", 0x0099CC, "stickCobalt", "ingotCobalt");

		if(OreDictionary.getOres("ingotCopper").size() > 0)
			copperStick = new FEItemStick("copperStick", 0xFFCC33, "stickCopper", "ingotCopper");

		if(OreDictionary.getOres("ingotLead").size() > 0)
			leadStick = new FEItemStick("leadStick", 0x9999CC, "stickLead", "ingotLead");

		if(OreDictionary.getOres("ingotManyullyn").size() > 0)
			manyullynStick = new FEItemStick("manyullynStick", 0x9966FF, "stickManyullyn", "ingotManyullyn");

		if(OreDictionary.getOres("ingotSilver").size() > 0)
			silverStick = new FEItemStick("silverStick", 0xFFFFCC, "stickSilver", "ingotSilver");

		if(OreDictionary.getOres("ingotSteel").size() > 0)
			steelStick = new FEItemStick("steelStick", 0x999966, "stickSteel", "ingotSteel");
		
		if(OreDictionary.getOres("ingotTin").size() > 0)
			tinStick = new FEItemStick("tinStick", 0xFFFFCC, "stickTin", "ingotTin");
		
		if(OreDictionary.getOres("ingotPokefennium").size() > 0)
			pokefenniumStick = new FEItemStick("pokefenniumStick", 0x99CC99, "stickPokefennium", "ingotPokefennium");
		
		if(OreDictionary.getOres("ingotFairy").size() > 0)
			fairyStick = new FEItemStick("fairyStick", 0xFF99FF, "stickFairy", "ingotFairy");
		
		if(OreDictionary.getOres("ingotThaumium").size() > 0)
			thaumiumStick = new FEItemStick("thaumiumStick", 0x9966FF, "stickThaumium", "ingotThaumium");
		
		if(OreDictionary.getOres("ingotDarkThaumium").size() > 0)
			darkThaumiumStick = new FEItemStick( "darkThaumiumStick", 0x993399, "stickDarkThaumium", "ingotDarkThaumium");
		
		if(OreDictionary.getOres("ingotVoid").size() > 0)
			voidStick = new FEItemStick("voidStick", 0x9900CC, "stickVoid", "ingotVoid");
		
	}
	public static FEItemStick alumiteStick;
	public static FEItemStick arditeStick;
	public static FEItemStick bronzeStick;
	public static FEItemStick cobaltStick;
	public static FEItemStick copperStick;
	public static FEItemStick leadStick;
	public static FEItemStick manyullynStick;
	public static FEItemStick silverStick;
	public static FEItemStick steelStick;
	public static FEItemStick tinStick;
	public static FEItemStick pokefenniumStick;
	public static FEItemStick fairyStick;
	public static FEItemStick thaumiumStick;
	public static FEItemStick darkThaumiumStick;
	public static FEItemStick voidStick;

	public static void initWorldGen()
	{	
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(FEItems.alfiumIngot), 0, 3, 0));	
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(FEItems.ryuIngot), 0, 3, 0));	
	}
	
	public static void initNuggets()
	{
		NuggetHelper.addNuggetToMap(0, "Draconic", 0xFF0000, new ItemStack(FEItems.draconicIngot));
		NuggetHelper.addNuggetToMap(1, "Reinforced", 0xCCCC99, new ItemStack(FEItems.reinforcedIngot));

		if(Loader.isModLoaded("Thaumcraft") && OreDictionary.getOres("ingotThaumium").size() > 0){
		NuggetHelper.addNuggetToMap(2, "Thaumium", 0x9966FF, OreDictionary.getOres("ingotThaumium").get(0));}
		
		if(Loader.isModLoaded("ThaumcraftExtras") && OreDictionary.getOres("ingotDarkThaumium").size() > 0){
		NuggetHelper.addNuggetToMap(3, "Dark Thaumium", 0x993399, OreDictionary.getOres("ingotDarkThaumium").get(0));}

		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotFairy").size() > 0){
		NuggetHelper.addNuggetToMap(4, "Fairy", 0xFF33FF, OreDictionary.getOres("ingotFairy").get(0));}
		
		if(Loader.isModLoaded("ExtraTiC") && OreDictionary.getOres("ingotPokefennium").size() > 0){
		NuggetHelper.addNuggetToMap(5, "Pokefennium", 0x9999FF, OreDictionary.getOres("ingotPokefennium").get(0));}

		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotConductiveIron").size() > 0){
		NuggetHelper.addNuggetToMap(6, "Conductive Iron", 0x999966, OreDictionary.getOres("ingotConductiveIron").get(0));}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotElectricalSteel").size() > 0){
		NuggetHelper.addNuggetToMap(7, "Electrical Steel", 0x999966, OreDictionary.getOres("ingotElectricalSteel").get(0));}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotEnergeticAlloy").size() > 0){
		NuggetHelper.addNuggetToMap(8, "Energetic Alloy", 0x99FF66, OreDictionary.getOres("ingotEnergeticAlloy").get(0));}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotVibrantAlloy").size() > 0){
		NuggetHelper.addNuggetToMap(9, "Vibrant Alloy", 0xFF9900, OreDictionary.getOres("ingotVibrantAlloy").get(0));}
		
		if(Loader.isModLoaded("EnderIO") && OreDictionary.getOres("ingotPulsatingIron").size() > 0){
		NuggetHelper.addNuggetToMap(10, "Pulsating Iron", 0xFF9900, OreDictionary.getOres("ingotPulsatingIron").get(0));}
		
		//if(Loader.isModLoaded("EnderIO") && Bees.doesModItemExist("EnderIO", "electricalSteel")){
		//NuggetHelper.addNuggetToMap(7, "ElectricSteel", 0xCCCC99, GameRegistry.findItemStack("EnderIO", "electricalSteel", 1));}
		
		nugget = new FEItemNugget();
		NuggetHelper.addRecipes();
	}
	public static FEItemNugget nugget;
}
