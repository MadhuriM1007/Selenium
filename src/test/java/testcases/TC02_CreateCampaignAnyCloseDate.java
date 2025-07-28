package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebDriverUtility;

public class TC02_CreateCampaignAnyCloseDate {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//details tc  :: Campaign name and target size with any close date 
	
		PropertiesUtility prop = new PropertiesUtility();
		String BROWSER =prop.getdatafrompropertiesfile("Browser");
		String URL =prop.getdatafrompropertiesfile("Url");
		String USERNAME =prop.getdatafrompropertiesfile("Username");
		String PASSWORD =prop.getdatafrompropertiesfile("Password");
		
		ExcelUtility eutil = new ExcelUtility();
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String tsize = eutil.getDataFromExcel("Campaign", 1, 3);
		
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPS().sendKeys(PASSWORD);
		lp.getLoginBTN().click();
		
		
		JavaUtility jutil = new JavaUtility();
		
		
//		driver.findElement(By.id("username")).sendKeys(USERNAME);
//		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
		
		
		Thread.sleep(2000);
		HomePage hp= new HomePage(driver);
		
		hp.getCreatecampaign().click();
		
		
		
		CampaignPage cp= new CampaignPage(driver);
		cp.getCampname().sendKeys(campname+ jutil.getRandomNumber());
		cp.getTsize().sendKeys(tsize);
		cp.getSumbitcreatecamp().click();
		
			
		
//		Thread.sleep(5000);
//		//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
//		Thread.sleep(5000);
		
//		
//		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
//		driver.findElement(By.name("campaignName")).sendKeys(campname);
//		//driver.findElement(By.name("campaignStatus")).sendKeys("Open");
//		WebElement targetEle =driver.findElement(By.name("targetSize"));
//		targetEle.clear();
//		targetEle.sendKeys(tsize);
		
		WebElement closeDate = driver.findElement(By.name("expectedCloseDate"));
		
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.clickonWebElement(driver, closeDate);
		closeDate.sendKeys("07-07-2025");
//		Actions act1= new Actions(driver);
//		act1.click(closeDate).sendKeys("07-07-2025").perform();
	}


