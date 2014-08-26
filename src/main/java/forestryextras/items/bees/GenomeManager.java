package forestryextras.items.bees;

import forestry.api.apiculture.EnumBeeChromosome;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;
import forestryextras.main.init.FEBees;

public class GenomeManager {
	private static IAllele[] getTemplateModBase(){
		IAllele[] genome = new IAllele[EnumBeeChromosome.values().length];

		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.draconicBee;
		genome[EnumBeeChromosome.SPEED.ordinal()] =  Allele.getBaseAllele("speedSlowest");
		genome[EnumBeeChromosome.LIFESPAN.ordinal()] = Allele.getBaseAllele("lifespanShorter");
		genome[EnumBeeChromosome.FERTILITY.ordinal()] = Allele.getBaseAllele("fertilityNormal");
		genome[EnumBeeChromosome.TEMPERATURE_TOLERANCE.ordinal()] = Allele.getBaseAllele("toleranceNone");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolFalse");
		genome[EnumBeeChromosome.HUMIDITY_TOLERANCE.ordinal()] = Allele.getBaseAllele("toleranceNone");
		genome[EnumBeeChromosome.TOLERANT_FLYER.ordinal()] = Allele.getBaseAllele("boolFalse");
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolFalse");
		genome[EnumBeeChromosome.FLOWER_PROVIDER.ordinal()] = Allele.getBaseAllele("flowersVanilla");
		genome[EnumBeeChromosome.FLOWERING.ordinal()] = Allele.getBaseAllele("floweringSlowest");
		genome[EnumBeeChromosome.TERRITORY.ordinal()] = Allele.getBaseAllele("territoryDefault");
		genome[EnumBeeChromosome.EFFECT.ordinal()] = Allele.getBaseAllele("effectNone");

		return genome;
	}
	
	public static IAllele[] getDraconicTemplate(){
		IAllele[] genome = getTemplateModBase();
		
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.draconicBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.EFFECT.ordinal()] = AlleleManager.alleleRegistry.getAllele(FEBees.fire.getUID());

		return genome;
	}
	
	public static IAllele[] getWitheriaTemplate(){
		IAllele[] genome = getTemplateModBase();
		
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.witheriaBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.EFFECT.ordinal()] = AlleleManager.alleleRegistry.getAllele(FEBees.wither.getUID());

		return genome;
	}
		
	public static IAllele[] getReinforcedTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.reinforcedBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getThaumiumTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.thaumiumBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getVoidTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.voidBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
	
	public static IAllele[] getDarkThaumiumTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.darkThaumiumBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getPokefenniumTemplate(){
		IAllele[] genome = getTemplateModBase();
		
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.pokefenniumBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getFairyTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.fairyBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getElectricalTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.electricalBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getConductiveTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.conductiveBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getEnergeticTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.energeticBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getVibrantTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.vibrantBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getPulsatingTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.pulsatingBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getSilverwoodTemplate(){
		IAllele[] genome = getTemplateModBase();
		
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.silverwoodBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getGreatwoodTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.greatwoodBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");

		return genome;
	}
		
	public static IAllele[] getBotanistTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.botanistBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.EFFECT.ordinal()] = AlleleManager.alleleRegistry.getAllele(FEBees.regen.getUID());

		return genome;
	}
	
	public static IAllele[] getManaTemplate(){
		IAllele[] genome = getTemplateModBase();
			
		genome[EnumBeeChromosome.SPECIES.ordinal()] = FEBees.manaBee;
		genome[EnumBeeChromosome.CAVE_DWELLING.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.NOCTURNAL.ordinal()] = Allele.getBaseAllele("boolTrue");
		genome[EnumBeeChromosome.EFFECT.ordinal()] = AlleleManager.alleleRegistry.getAllele(FEBees.mana.getUID());

		return genome;
	}
}