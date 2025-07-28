package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//C:\Users\DELL\Desktop\Normal Resume Madhuri\Reference QA Resume\Newest\3.6
		
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\Normal Resume Madhuri\\Reference QA Resume\\Newest\\3.6\\ninjaCRMCommonData.properties");
		
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("URL");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		
		
		WebDriver driver= null;
		
		if(BROWSER.equals("Edge"))
		{
			driver= new EdgeDriver();
		}
		if(BROWSER.equals("Chrome"))
		{
			driver= new ChromeDriver();
		}
		if(BROWSER.equals("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
	}

}
