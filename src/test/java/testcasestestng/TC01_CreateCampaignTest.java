package testcasestestng;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.testng.asserts.Assertion;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Baseclass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebDriverUtility;

@Listeners(listnersUtility.ListnersImplemention.class)
public class TC01_CreateCampaignTest extends BaseClass {

	//public static void main(String[] args) throws InterruptedException, IOException {
		// Campaign name and target size
		
	

		
		
		@Test (groups = "smoke")
		//@Test
		public void createcampaign() throws InterruptedException, IOException { 
			// TODO Auto-generated method stub 
			
			ExcelUtility eutil = new ExcelUtility(); 
			WebDriverUtility wutil= new WebDriverUtility();
			JavaUtility jutil = new JavaUtility();
			//Read data from excel 
			String campname = eutil.getDataFromExcel("Campaign", 1, 2); 
			String size = eutil.getDataFromExcel("Campaign", 1, 3);
		////int ran 	=jutil.getRandomNumber();
	//String CAMPAIGNNAME=	campname+ran;
			
			//click on create Campaign button 
			HomePage hp = new HomePage(driver);
			hp.getCreatecampaign().click(); 
			//enter mandatory fields 
			CampaignPage cp = new CampaignPage(driver);
			cp.getCampname().sendKeys(campname);
			//cp.getCampname().sendKeys(campname+jutil.getRandomNumber());
			//cp.getCampaignName().sendKeys(campname+ jutil.getRandomNumber()); 
			
			cp.getTsize().sendKeys(size);
			//cp.getTargetsizeTF().sendKeys(size);
			
			cp.getSumbitcreatecamp().click();
			Thread.sleep(2000);
			//cp.getCreatecampaignsubmitBtn().click(); 
			//validation
			Thread.sleep(2000);
			WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
			
			wutil.waitforVisisbilityofElement(driver, toastmsg);
			//wutil.waitforVisibilityofElement(driver, toast); 
			String msg = toastmsg.getText(); 
			if(msg.contains(campname)) 
			{ System.out.println("campaign is created"); } 
			else{ System.out.println("campaign not created"); 
			} 
		
		//Assert.assertTrue(msg.contains("CAMPAIGNNAME"));
	
		//Assert.assertEquals(msg,"Campaign "+campname+" successfully added");
	
			//Assert.ThrowingRunnable
		
			//Thread.sleep(5000);
		//	driver.findElement(By.xpath("//button[@aria-label='close']")).click(); 
			

		}
}


