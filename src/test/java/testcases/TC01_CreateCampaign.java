package testcases;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Baseclass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebDriverUtility;

public class TC01_CreateCampaign extends BaseClass {

//	@Test
//	public  void CreateCampaign() throws InterruptedException, IOException {
//		// Campaign name and target size
//		
//	
//
//		
////		//Generic utility :
////		PropertiesUtility putil = new PropertiesUtility();
////		String BROWSER =putil.getdatafrompropertiesfile("Browser");
////		String URL =putil.getdatafrompropertiesfile("Url");
////		String USERNAME =putil.getdatafrompropertiesfile("Username");
////		String PASSWORD =putil.getdatafrompropertiesfile("Password");
////		
//		ExcelUtility eutility = new ExcelUtility();
//		String campname = eutility.getDataFromExcel("Campaign", 1, 2);
//		String size=eutility.getDataFromExcel("Campaign", 1, 3);
//		
//		WebDriverUtility wutil = new WebDriverUtility();
//		
//		//WebDriver driver = new ChromeDriver();
////	WebDriver driver= new EdgeDriver();
////		driver.manage().window().maximize();
////		
////		wutil.waitForPageToLoad(driver);
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
////		
////		driver.get(URL);
////		
////		
////		LoginPage lp = new LoginPage(driver);
////		lp.getUN().sendKeys(USERNAME);
////		lp.getPS().sendKeys(PASSWORD);
////		lp.getLoginBTN().click();
////		
//		
//		
////		driver.findElement(By.id("username")).sendKeys(USERNAME);
////		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
////		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
//		
//		
//		
////		Random ran= new Random();
////		int randomcount= ran.nextInt(10000);
//		JavaUtility jutil =new JavaUtility();
//		
//		
//		HomePage hp= new HomePage(driver);
//		
//	hp.getCreatecampaign().click();
//	
//	
//	
//	CampaignPage cp= new CampaignPage(driver);
//	cp.getCampname().sendKeys(campname+ jutil.getRandomNumber());
//	cp.getTsize().sendKeys(size);
//	cp.getSumbitcreatecamp().click();
//	
//		
////		Thread.sleep(5000);
////		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
////		Thread.sleep(5000);
////		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
////		//campname
////		//driver.findElement(By.name("campaignName")).sendKeys("Test_Campaign1"+ randomcount);
////		driver.findElement(By.name("campaignName")).sendKeys(campname+ jutil.getRandomNumber());
////		
////		driver.findElement(By.name("campaignStatus")).sendKeys("Open");
////		WebElement targetEle =driver.findElement(By.name("targetSize"));
////		targetEle.clear();
////		targetEle.sendKeys(size);
////		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
////		
//		
//		//validation 
//		Thread.sleep(2000);
//		WebElement creationmsg= driver.findElement(By.xpath("//div[@role='alert']"));
//		
//		//Explicit wait 
////		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////		wait.until(ExpectedConditions.visibilityOf(creationmsg));
//		wutil.waitforVisisbilityofElement(driver, creationmsg);
//		String msg = creationmsg.getText();
//		
//		if(msg.contains(campname))
//		{
//			System.out.println("Campaign is created");
//		}
//		else {
//			System.out.println("Camapaign not created");
//		}
//		
//		
//		
//		
//		driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
//		
//		
//		//logout 
//		Thread.sleep(1000);
//		hp.getUserIcon().click();
//		hp.getLogout().click();
//		
////		WebElement profileIcon  = driver.findElement(By.xpath("//div[@class='user-icon']"));
//////		Actions act = new Actions(driver);
//////		act.moveToElement(profileIcon).perform();
////		wutil.mouseHoverOnWebElement(driver, profileIcon);
////		
////		WebElement logout =driver.findElement(By.xpath("//div[text()='Logout ']"));
////		//act.moveToElement(logout).click().perform();	
////		wutil.clickonWebElement(driver, logout);
////		
//		
//		}
//	
	



	
}


