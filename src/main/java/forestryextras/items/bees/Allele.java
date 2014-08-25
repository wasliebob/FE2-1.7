package forestryextras.items.bees;

import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;

public class Allele implements IAllele{
	public static IAlleleBeeSpecies getBaseSpecies(String name){
		return (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele((new StringBuilder()).append("forestry.species").append(name).toString());
	}
	
	public static IAlleleBeeSpecies getExtraSpecies(String name){
		return (IAlleleBeeSpecies) AlleleManager.alleleRegistry.getAllele((new StringBuilder()).append("extrabees.species.").append(name).toString());
	}
	
	public static IAllele getBaseAllele(String name){
		return AlleleManager.alleleRegistry.getAllele("forestry." + name);
	}
	
	public static IAllele getAllele(String name){
		return AlleleManager.alleleRegistry.getAllele(name);
	}
	
	private String uid;
	private boolean dominant;

	public Allele(String id, boolean isDominant){
		this.uid = "fe." + id;
		this.dominant = isDominant;
		AlleleManager.alleleRegistry.registerAllele(this);
	}

	@Override
	public String getUID(){
		return this.uid;
	}

	@Override
	public boolean isDominant(){
		return this.dominant;
	}

	@Override
	public String getName(){
		return "fe.bees.species";
	}

	@Override
	public String getUnlocalizedName(){
		return this.getName();
	}
}