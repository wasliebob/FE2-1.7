/*
package forestryextras.main.init.intergration;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import forestryextras.items.frames.FEItemFrameMCKE;
import forestryextras.items.grafters.FEItemGrafterMCKE;
import forestryextras.items.scoops.FEItemScoopMCKE;
import forestryextras.main.Config;
import forestryextras.main.init.Items;

public class ThaumcraftExtras {

	public static void init()
	{
		initItems();
	}
	
	public static void initItems()
	{
		if(OreDictionary.getOres("orbMagic").size() > 0){
		mckeFrame = new FEItemFrameMCKE(Config.mckeFrameId, 100, false, false, false, false, 1.0F, 1.0F, 1.9F, 1.0F, 1.0F, 1.0F, "MagicEnergyFrame", "frameMCKE", "frame", 0x993399, new ItemStack(Item.silk), OreDictionary.getOres("orbMagic").get(0), true, null, 0);
		mckeScoop = new FEItemScoopMCKE(Config.mckeScoopId, "scoopMCKE", 0xFFFFFF, 0x993399, "scoopMCKE", 700, OreDictionary.getOres("orbMagic").get(0), new ItemStack(Items.darkThaumiumStick), true, null, 0);
		mckeGrafter = new FEItemGrafterMCKE(Config.mckeGrafterId, "grafterMCKE", 0xFFFFFF, 0x993399, "grafterMCKE", 700, 2.0F, OreDictionary.getOres("orbMagic").get(0), new ItemStack(Items.darkThaumiumStick), true, null, 0);

		}
	}
	public static FEItemFrameMCKE mckeFrame;
	public static FEItemScoopMCKE mckeScoop;
	public static FEItemGrafterMCKE mckeGrafter;

}
*/