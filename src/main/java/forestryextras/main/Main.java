package forestryextras.main;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import forestryextras.handlers.GuiHandler;
import forestryextras.handlers.events.OnPlayerJoinWorld;
import forestryextras.main.init.FEBees;
import forestryextras.main.init.FEBlocks;
import forestryextras.main.init.FEItems;
import forestryextras.main.init.Recipes;
import forestryextras.main.init.intergration.IntergrationLoader;

@Mod(modid = "ForestryExtras", name = "ForestryExtras", version = "3.1" ,dependencies = "required-after:Forestry;required-after:WaslieCore;after:Thaumcraft;after:ExtraTiC;after:EnderIO;after:oodmod;after:BigReactors;after:ModularMachines")
public class Main {
    @SidedProxy(clientSide = "forestryextras.client.ClientProxy", serverSide = "forestryextras.main.CommonProxy")
    public static CommonProxy proxy;
 
    @Instance("ForestryExtras")
    public static Main instance;
    public static double version = 3.1;
    public static String modName = "ForestryExtras";
    public static String alias = "FE";
    public static IntergrationLoader integration = new IntergrationLoader();
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) throws Exception{
		Config.loadConfig(event);
		
		proxy.load();
		integration.prePreInit();
    	FEItems.init();
    	FEBlocks.init();
    	integration.preInit();
    	initTiles();
    }

    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	integration.init();
    	FEBees.init();
    	
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    	initEvents(event);
    	Recipes.init();
    }
    
    public void initEvents(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(this); 
        MinecraftForge.EVENT_BUS.register(new OnPlayerJoinWorld());
    }
    
    public void initTiles(){
        GameRegistry.registerTileEntity(forestryextras.blocks.tiles.TileProducer.class, "fe_producer");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent evt){
    	integration.postInit();
    }
}