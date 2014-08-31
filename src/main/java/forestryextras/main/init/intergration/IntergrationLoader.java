package forestryextras.main.init.intergration;

import cpw.mods.fml.common.Loader;


public class IntergrationLoader implements IIntergration{
	
	@Override
	public void prePreInit(){
		if(isLoaded("ModularMachines")){
			mm.prePreInit();
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
			mm.preInit();
		}
	}
	
	@Override
	public void init(){	
		if(isLoaded("VersionChecker")){
			vc.init();
			initMessage("VersionChecker");
		}
		
		if(isLoaded("ModularMachines")){
			mm.init();
		}
	}
	
	@Override
	public void postInit(){
		if(isLoaded("Thaumcraft")){
			tc.postInit();
		}
		
		if(isLoaded("ModularMachines")){
			mm.postInit();
		}
	}

	public String initMessage(String modName){
		return "[Forestry Extras 2] " + modName + " is installed, adding intergration" + "\n";
	}
	
	public boolean isLoaded(String modID){
		return Loader.isModLoaded(modID);
	}
	public Thaumcraft tc = new Thaumcraft();
	public MM mm = new MM();
	public VersionChecker vc = new VersionChecker();

}