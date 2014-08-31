package forestryextras.items.bees;

import java.util.ArrayList;

import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAlleleSpecies;
import forestry.api.genetics.IClassification;
import forestry.api.genetics.IClassification.EnumClassLevel;

public enum BeeBranches implements IClassification{
	DEADLY("Deadly"),
	METAL("Metal"),
	MAGICAL("Magical"),
	MYSTERIOUS("Mysterious"),
	NATURAL("Natural"),
	CROPS("Crops"),
	PASSIVE("Passive"),
	FLUID("Fluid");
	
	private String name;
	private String uID;
	private String latin;
	private ArrayList<IAlleleSpecies> species;
	private IClassification parent;
	private EnumClassLevel level;
	
	private BeeBranches(String name){
		this.name = name;
		this.uID = "classification." + name.toLowerCase();
		this.latin = name;
		this.level = EnumClassLevel.GENUS;
		this.species = new ArrayList<IAlleleSpecies>();
		this.parent = AlleleManager.alleleRegistry.getClassification("family.apidae");
		AlleleManager.alleleRegistry.registerClassification(this);
	}
	
	@Override
	public EnumClassLevel getLevel(){
		return this.level;
	}

	@Override
	public String getUID(){
		return this.uID;
	}

	@Override
	public String getName(){
		return "fe.species." + this.name;
	}

	@Override
	public String getScientific(){
		return "fe.science." + this.name;
	}

	@Override
	public String getDescription(){
		return "fe.description." + this.name;
	}

	@Override
	public IClassification[] getMemberGroups(){
		return null;
	}

	@Override
	public void addMemberGroup(IClassification group){
		
	}

	@Override
	public IAlleleSpecies[] getMemberSpecies(){
		return this.species.toArray(new IAlleleSpecies[this.species.size()]);
	}

	@Override
	public void addMemberSpecies(IAlleleSpecies species){
		if (!this.species.contains(species)){
			this.species.add(species);
		}
	}

	@Override
	public IClassification getParent(){
		return this.parent;
	}

	@Override
	public void setParent(IClassification parent){
		this.parent = parent;
	}
}