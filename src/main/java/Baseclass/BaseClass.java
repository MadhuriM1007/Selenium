package Baseclass;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebDriverUtility;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public WebDriver driver = null;
	public static WebDriver sdriver= null;
	
	public PropertiesUtility putil = new PropertiesUtility();
	
	@BeforeSuite (groups = {"smoke", "regression"})
	public void beforesuite() {
		Reporter.log("DB Connectivity established", true);
	}
	
	@BeforeTest (groups = {"smoke","regression"})
	public void beforeTest() {
		Reporter.log("preconditions", true);
	}
	
//	@Parameters("BROWSER")  // for parallel execution
//	@BeforeClass (groups = {"smoke","regression"})
//	public void beforeclass(String BROWSER) throws IOException {
//		//String BROWSER=putil.getdatafrompropertiesfile("Browser");
//		if(BROWSER.equals("Edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if (BROWSER.equals("Chrome")) {
//			driver = new ChromeDriver();
//		}
//		else if (BROWSER.equals("Firefox")) {
//			driver = new FirefoxDriver();
//		}
//		
//		System.out.println("lauching Browser"); 
//		driver.manage().window().maximize();
//	}

	
	
	
	@BeforeClass (groups = {"smoke","regression"})
	public void beforeclass() throws IOException {
		String BROWSER=putil.getdatafrompropertiesfile("Browser");
		if(BROWSER.equals("Edge"))
		{

			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		//driver=sdriver;
		sdriver=driver;
		System.out.println("lauching Browser");
		
		driver.manage().window().maximize();
	
	}
	
	@BeforeMethod (groups = {"smoke","regression"})
	public void beforeMethoe() throws IOException {
		
		String URL =putil.getdatafrompropertiesfile("Url");
		String USERNAME=putil.getdatafrompropertiesfile("Username");
		String PASSWORD =putil.getdatafrompropertiesfile("Password");
		driver.get(URL);
		
		LoginPage lp= new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPS().sendKeys(PASSWORD);
		lp.getLoginBTN().click();
	}
	
	@AfterMethod (groups = {"smoke","regression"})
	public void aftermethod() { 
	//WebDriverUtility wutil = new WebDriverUtility();
	HomePage hp = new HomePage(driver);
	//hp.getClosemsg().click();
	hp.getUserIcon().click();
	hp.getLogout().click();
	System.out.println("LOGOUT DONE");
	}
	
	
	@AfterClass (groups = {"smoke","regression"})
	public void afterClass() { 
		driver.quit(); 
		System.out.println("closing browser"); 
		} 
	
	@AfterTest (groups = {"smoke","regression"})
	public void aftertest() 
	{ System.out.println("POST CONDITIONS"); 
	} 

	@AfterSuite 
	public void afterSuite() 
	{ System.out.println("closeDB Connectivity"); 
	}
	
	
	
	

}
