package forestryextras.items.bees.helpers;

import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.genetics.AlleleManager;
import forestry.api.genetics.IAllele;

public class AlleleHelper {

    public static IAllele getAllele(String id) {
        return AlleleManager.alleleRegistry.getAllele(id);
    }

    public static IAllele getForestryAllele(String id) {
        return getAllele("forestry." + id);
    }
    
    public static IAllele getExtraBeesAllele(String id){
    	return getAllele("extrasbees." + id);
    }

    public static IAlleleBeeSpecies getSpecies(String id) {
        return (IAlleleBeeSpecies)AlleleManager.alleleRegistry.getAllele(id);
    }

    public static IAlleleBeeSpecies getForestrySpecies(String id) {
        return getSpecies("forestry.species." + id);
    }
    
    public static IAlleleBeeSpecies getExtraBeesSpecies(String id) {
        return getSpecies("extrabees.species." + id);
    }
}