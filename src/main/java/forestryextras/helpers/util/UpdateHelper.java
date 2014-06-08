package forestryextras.helpers.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateHelper {
	public static ArrayList<String> readFile(){
		ArrayList<String> list = new ArrayList<String>();
		URL url;
			try{
				url = new URL("https://dl.dropboxusercontent.com/u/46500170/VC/FE_VC.txt");
//				file = new File(Config.list + FileHelper.getSlash() + "WaslieCore" + FileHelper.getSlash() + "Forestry Extras 2" + FileHelper.getSlash() + "item-backup" + "." + "fe");
				Scanner scanner = new Scanner(url.openStream());
				
				while(scanner.hasNext()){
					String next = scanner.nextLine();
					list.add(next);
				}
				scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return list;
	}
}