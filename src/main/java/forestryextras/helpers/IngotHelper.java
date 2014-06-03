package forestryextras.helpers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class IngotHelper {
	public static void addIngotToMap(int meta, String nuggetName){
		ingots.add(meta);
		name.put(meta, nuggetName);
		
		int rand = new Random().nextInt((255 - 0) + 1) + 0;
		color.put(meta, new Color(rand, rand, rand).getRGB());
	}
	
	public static ArrayList<Integer> ingots = new ArrayList<Integer>();
	public static HashMap<Integer, String> name = new HashMap<Integer, String>();
	public static HashMap<Integer, Integer> color = new HashMap<Integer, Integer>();
}