package TestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader 
{
	public String FirstName ;
	public String LastName ;
	public String Email ;
	public String Company ;
	public String Password ;

	public void JsonDataReader() throws FileNotFoundException, IOException, ParseException 
	{
		String JsonFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\UserData.Json";
		File FileSrc = new File(JsonFilePath);
		JSONParser Parser = new JSONParser();
		JSONArray Jarray = (JSONArray) Parser.parse(new FileReader(FileSrc));
		for (Object JsonObj : Jarray )
		{
			JSONObject Juser = (JSONObject) JsonObj; 
			FirstName = (String) Juser.get("firstName");
			System.out.println(FirstName);
			LastName = (String) Juser.get("lastName");
			System.out.println(LastName);
			Email = (String) Juser.get("email");
			System.out.println(Email);
			Company = (String) Juser.get("company");
			System.out.println(Company);
			Password = (String) Juser.get("password");
			System.out.println(Password);
		}
	}
}
