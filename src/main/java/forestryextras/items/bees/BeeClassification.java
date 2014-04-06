package forestryextras.items.bees;

import java.util.ArrayList;

import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAlleleSpecies;
import forestry.api.genetics.IClassification;

public enum BeeClassification implements IClassification
{
	DRACONIC("Draconic", "Draconic"),
	REINFORCED("Reinforced", "Reinforced"),
	THAUMIUM("Thaumium", "Thaumium"),
	DARKTHAUMIUM("DarkThaumium", "DarkThaumium"),
	FAIRY("Fairy", "Fairy"),
	POKEFENNIUM("Pokefennium", "Pokefennium"),
	ELECTRICSTEEL("ElectricSteel", "ElectricSteel"),
	SILVERWOOD("Silverwood", "Silverwood"),
	GREATWOOD("Greatwood", "Greatwood"),
	CONDUCTIVE("Conductive", "Conductive"),
	ELECTRICAL("Electrical", "Electrical"),
	ENERGETIC("Energetic", "Energetic"),
	VIBRANT("Vibrant", "Vibrant"),
	PULSATING("Pulsating", "Pulsating"),
	BOTANIST("Botanist", "Botanist");
	

	private String uID;
	@SuppressWarnings("unused")
	private String latin;
	private ArrayList<IAlleleSpecies> species;
	private IClassification parent;
	private EnumClassLevel level;
	
	private BeeClassification(String name, String scientific)
	{
		this.uID = "classification." + name.toLowerCase();
		this.latin = scientific;
		this.level = EnumClassLevel.GENUS;
		this.species = new ArrayList<IAlleleSpecies>();
		this.parent = AlleleManager.alleleRegistry.getClassification("family.apidae");
		AlleleManager.alleleRegistry.registerClassification(this);
	}
	
	@Override
	public EnumClassLevel getLevel()
	{
		return this.level;
	}

	@Override
	public String getUID()
	{
		return this.uID;
	}

	@Override
	public String getName()
	{
		return "tce.species";
	}

	@Override
	public String getScientific()
	{
		return "tce.science";
	}

	@Override
	public String getDescription()
	{
		return "tce.description";
	}

	@Override
	public IClassification[] getMemberGroups()
	{
		return null;
	}

	@Override
	public void addMemberGroup(IClassification group)
	{
		
	}

	@Override
	public IAlleleSpecies[] getMemberSpecies()
	{
		return this.species.toArray(new IAlleleSpecies[this.species.size()]);
	}

	@Override
	public void addMemberSpecies(IAlleleSpecies species)
	{
		if (!this.species.contains(species))
		{
			this.species.add(species);
		}
	}

	@Override
	public IClassification getParent()
	{
		return this.parent;
	}

	@Override
	public void setParent(IClassification parent)
	{
		this.parent = parent;
	}
}

