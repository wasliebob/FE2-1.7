package forestryextras.main.init.intergration;

import cpw.mods.fml.common.Loader;


public class IntergrationLoader implements IIntergration{
	
	@Override
	public void prePreInit(){
		if(isLoaded("ModularMachines")){
			MM.prePreInit();
			initMessage("ModularMachines");
		}
	}
	
	@Override
	public void preInit(){
		if(isLoaded("Thaumcraft")){
			tc.preInit();
			initMessage("Thaumcraft");
		}
		
		if(isLoaded("ModularMachines")){
			MM.preInit();
		}
	}
	
	@Override
	public void init(){	
		if(isLoaded("ModularMachines")){
			MM.init();
		}
	}
	
	@Override
	public void postInit(){
		if(isLoaded("Thaumcraft")){
			tc.postInit();
		}
		
		if(isLoaded("ModularMachines")){
			MM.postInit();
		}
	}

	public String initMessage(String modName){
		return "[Forestry Extras 2] " + modName + " is installed, adding intergration" + "\n";
	}
	
	public boolean isLoaded(String modID){
		return Loader.isModLoaded(modID);
	}
	public Thaumcraft tc = new Thaumcraft();
}