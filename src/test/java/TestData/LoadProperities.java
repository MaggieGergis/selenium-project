package TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperities 
{

	private static Properties loadProperties (String Path)
	{
		Properties ProObject = new Properties();
		FileInputStream StreamObject;
		try {
			StreamObject = new FileInputStream(Path);
			ProObject.load(StreamObject);
		} 
		catch (FileNotFoundException e) {
			System.out.println("error occurs" + e.getMessage());
		} 
		catch (IOException e) {
			System.out.println("error occurs" + e.getMessage());
		}
		return ProObject;
	}
	
	public static Properties userdata = 
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\Properities\\UserData.Properities");
}
