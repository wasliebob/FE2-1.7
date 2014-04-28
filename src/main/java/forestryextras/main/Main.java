package forestryextras.main;

import net.minecraftforge.common.MinecraftForge;
import wasliecore.helpers.FileHelper;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import forestryextras.handlers.GUIHandler;
import forestryextras.handlers.events.OnPlayerJoinWorld;
import forestryextras.main.init.FEBees;
import forestryextras.main.init.FEBlocks;
import forestryextras.main.init.FEItems;
import forestryextras.main.init.Recipes;
import forestryextras.main.init.intergration.ForgeMultipart;
import forestryextras.main.init.intergration.IntergrationLoader;

@Mod(modid = "ForestryExtras", name = "ForestryExtras", version = "1.32" ,dependencies = "required-after:Forestry;required-after:WaslieCore;after:Thaumcraft;after:ThaumcraftExtras;after:ExtraTiC;after:EnderIO;after:ThermalExpansion")
public class Main {
    @SidedProxy(clientSide = "forestryextras.client.ClientProxy", serverSide = "forestryextras.main.CommonProxy")
    public static CommonProxy proxy;
 
    @Instance("ForestryExtras")
    public static Main instance;
    public static double version = 1.324;
    public static String modName = "ForestryExtras";
    public static String alias = "FE";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		@SuppressWarnings("unused")
		Config config = new Config();
		Config.loadConfig(event);
		proxy.load();
		IntergrationLoader.preFullInit();
    	FEItems.init();
    	FEBlocks.init();
    	IntergrationLoader.init();

    	initTiles();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		if(Loader.isModLoaded("ForgeMultipart")){
			System.out.print(IntergrationLoader.initMessage("Forge Multipart"));
			ForgeMultipart.init();}
		
    	FEBees.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
    	initEvents(event);
    	Recipes.init();
    }
    
    public void initEvents(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this); 
        MinecraftForge.EVENT_BUS.register(new OnPlayerJoinWorld());
    }
    
    public void initTiles()
    {
        GameRegistry.registerTileEntity(forestryextras.blocks.tiles.TileEntityProducer.class, "10001");
    }
    
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {
        FileHelper.createBaseFileInFolder(Main.modName, "species", ".wasliecore", FEBees.specieNames);
    }
    
    public void initMisc(FMLPreInitializationEvent event)
    {
		if(event.getSide() == Side.CLIENT){
			IntergrationLoader.initRequired("ThermalExpansion");
		}
    }
}