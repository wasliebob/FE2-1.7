package forestryextras.main.init.intergration;

import java.awt.Color;

import modularmachines.api.guide.EntryHelper;
import modularmachines.api.guide.IEntry;
import modularmachines.api.guide.entries.EntryRecipe;
import modularmachines.api.guide.entries.EntryText;
import modularmachines.api.main.MMApi;
import modularmachines.api.misc.InteractingUpgrade;
import modularmachines.api.misc.helpers.RecipeHelper;
import modularmachines.items.MMInteractingUpgrade;
import modularmachines.main.init.MMItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import forestryextras.main.init.FEItems;
import forestryextras.main.init.intergration.modularmachines.UpgradeMutation;

public class MM {

	public static void prePreInit() {
		
	}
	
	public static void preInit() {
		interacting_mutation = new MMInteractingUpgrade("mutation", new Color(0, 255, 0));
	}
	public static MMInteractingUpgrade interacting_mutation;
	
	public static void init() {
		MMApi.addInteractingUpgrade(MM.interacting_mutation, new InteractingUpgrade(new UpgradeMutation()));
	}

	public static void postInit() {
		recipes();
		entries();
	}

	public static void recipes(){
		RecipeHelper.addShapedRecipe(new ItemStack(MM.interacting_mutation), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', FEItems.mutatedIronIngot,
			'Y', FEItems.witheriaIngot,
			'I', MMItems.upgrade_empty});
		recipe_mutationUpgrade = RecipeHelper.getLatest();
	}
	public static IRecipe recipe_mutationUpgrade;
	
	public static void entries(){
		EntryHelper.addEntry("Upgrade: Mutation", new IEntry[]{new EntryText(), new EntryRecipe(MM.recipe_mutationUpgrade)}, 2);
	}
}
