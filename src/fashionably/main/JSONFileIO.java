package fashionably.main;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;


public class JSONFileIO {

	public static void JSON() {
		JSONObject obj = new JSONObject(); 
		
		obj.put("name", "Josh");
		
		JSONArray arr = new JSONArray();
		
		arr.put(SearchItFileIO.fileName);
		arr.put("potato");
	
		obj.put("something", arr);
		
			try
			{
				FileWriter file = new FileWriter("obj.json");
				file.write(obj.toString());
				file.flush();
				file.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}
}
