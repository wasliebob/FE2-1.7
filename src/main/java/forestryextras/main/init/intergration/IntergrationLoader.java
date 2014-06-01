package forestryextras.main.init.intergration;

import cpw.mods.fml.common.Loader;


public class IntergrationLoader implements IIntergration{
	
	@Override
	public void prePreInit(){
		
	}
	
	@Override
	public void preInit(){
		if(isLoaded("Thaumcraft")){
			tc.postInit();
			initMessage("Thaumcraft");}
	}
	public Thaumcraft tc = new Thaumcraft();
		
	@Override
	public void init(){	
		
	}
	
	@Override
	public void postInit(){
		
	}

	public String initMessage(String modName)
	{
		return "[Forestry Extras 2] " + modName + " is installed, adding intergration" + "\n";
	}
	
	public boolean isLoaded(String modID){
		return Loader.isModLoaded(modID);
	}
}
