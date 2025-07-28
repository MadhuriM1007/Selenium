package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadCommonDatafromJSON {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// ConfigData: commondat.json
		
		
		//FileInputStream fis= new FileInputStream("./ConfigData/commondata.json");
		//parse the JSON Frm Phsical file into Java Object using JSON 
		//parser class
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./ConfigData/commondata.json"));
		//convert java object into json Object (type casting)
		JSONObject obj1 = (JSONObject) obj;
	
	//Read data using get() by passing key 
	System.out.println(obj1.get("Browser"));
	System.out.println(obj1.get("Url"));
	System.out.println(obj1.get("Username"));
	System.out.println(obj1.get("Password"));
	
	//to use the JSON DATA in script we need to convert in string form and perform execution 
	String browserstr = obj1.get("Browser").toString();
	String urlstr = obj1.get("Url").toString();	
	String usrnamestr = obj1.get("Username").toString();	
	String passwordstr = obj1.get("Password").toString();	

	//Use the string format data into Sript 
	WebDriver driver =null;
	
	if(browserstr.equals("Edge"))
	{
		driver= new EdgeDriver();
	}
	if(browserstr.equals("Chrome"))
	{
		driver= new ChromeDriver();
	}
	if(browserstr.equals("Firefox"))
	{
		driver= new FirefoxDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(urlstr);
	driver.findElement(By.id("username")).sendKeys(usrnamestr);
	driver.findElement(By.id("inputPassword")).sendKeys(passwordstr);
	}

}
