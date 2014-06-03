package forestryextras.helpers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import wasliecore.helpers.FileHelper;
import forestryextras.main.Config;

public class DonatorHelper{
	public static boolean canConnect(){
		URL url;
		try {
			url = new URL("https://dl.dropboxusercontent.com/u/46500170/WaslieCore/donators/donatorIngots.txt");
			if(url != null && url.getFile() != null)
				return true;
		} catch (MalformedURLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<String> getNames(){
		ArrayList<String> list = new ArrayList<String>();
		if(canConnect() && getResponseCode("https://dl.dropboxusercontent.com/u/46500170/WaslieCore/donators/donatorIngots.txt")){
			try{
				if(getResponseCode("https://dl.dropboxusercontent.com/u/46500170/WaslieCore/donators/donatorIngots.txt")){
				URL url = new URL("https://dl.dropboxusercontent.com/u/46500170/WaslieCore/donators/donatorIngots.txt");
					if(url != null){
						Scanner scanner = new Scanner(url.openStream());
				
						while(scanner.hasNext()){
							String next = scanner.nextLine();
							list.add(next);
						}
						scanner.close();
						return list;
					}
				}
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		return null;
	}
	
	public static boolean getResponseCode(String urlString){
	    URL u;
		try {
			u = new URL(urlString);
			 HttpURLConnection huc;
			try {
				huc = (HttpURLConnection)  u.openConnection();
			    huc.setRequestMethod("GET"); 
			    huc.connect(); 
			    return (huc.getResponseCode() == HttpURLConnection.HTTP_OK);

			} catch (IOException e) {
				e.printStackTrace();
			} 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return false; 
	}
	
	public static void createFailFile(ArrayList<String> list){
		File file;
		try {
			file = new File(Config.list + FileHelper.getSlash() +  "WaslieCore" + FileHelper.getSlash() + "Forestry Extras 2" + FileHelper.getSlash() + "item-backup" + "." + "fe");
			file.createNewFile();
			PrintWriter writer = new PrintWriter(Config.list + FileHelper.getSlash() + "WaslieCore" + FileHelper.getSlash() + "Forestry Extras 2" + FileHelper.getSlash() + "item-backup" + "." + "fe", "UTF-8");
			
			for(int i = 0; i < list.size(); i++)
				if(list.get(i) != null)
					writer.println(list.get(i));

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> readFile(){
		ArrayList<String> list = new ArrayList<String>();
			File file;
			try{
				file = new File(Config.list + FileHelper.getSlash() +  "WaslieCore" + FileHelper.getSlash() + "Forestry Extras 2" + FileHelper.getSlash() + "item-backup" + "." + "fe");
				Scanner scanner = new Scanner(file);
				
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