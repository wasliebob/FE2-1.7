package forestryextras.helpers.util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import forestryextras.main.Main;

public class IconHelper {

        public static IIcon forName(IIconRegister ir, String name) {
                return ir.registerIcon(Main.modName + ":" + name);
        }

        public static IIcon forNameRaw(IIconRegister ir, String name) {
                return ir.registerIcon(name);
        }

        public static IIcon forBlock(IIconRegister ir, Block block) {
                return forNameRaw(ir, block.getUnlocalizedName().replaceAll("tile.", ""));
        }

        public static IIcon forBlock(IIconRegister ir, Block block, int i) {
                return forBlock(ir, block, Integer.toString(i));
        }

        public static IIcon forBlock(IIconRegister ir, Block block, String s) {
                return forNameRaw(ir, block.getUnlocalizedName().replaceAll("tile.", "") + s);
        }

        public static IIcon forItem(IIconRegister ir, Item item) {
                return forNameRaw(ir, item.getUnlocalizedName().replaceAll("item.", ""));
        }

        public static IIcon forItem(IIconRegister ir, Item item, int i) {
                return forItem(ir, item, Integer.toString(i));
        }

        public static IIcon forItem(IIconRegister ir, Item item, String s) {
                return forNameRaw(ir, item.getUnlocalizedName().replaceAll("item.", "") + s);
        }

}