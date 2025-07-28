package practtttt;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Baseclass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebDriverUtility;

public class createcampain11 extends BaseClass {

	@Test
	public  void createcampaign() throws EncryptedDocumentException, IOException, InterruptedException  {
		
		
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new  JavaUtility();
		PropertiesUtility putil= new PropertiesUtility();
		
		ExcelUtility eutil = new ExcelUtility();
		
		String CAMPNAME = eutil.getDataFromExcel("Campaign", 1, 2);
		String STATUS = eutil.getDataFromExcel("Campaign", 1, 4);
		String TARGETSIZE = eutil.getDataFromExcel("Campaign", 1, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampname().sendKeys(CAMPNAME+jutil.getRandomNumber());
		cp.getCampstatus().sendKeys(STATUS);
		cp.getTsize().clear();
		Thread.sleep(1000);
		cp.getTsize().sendKeys(TARGETSIZE);
		Thread.sleep(5000);
		cp.getExpclosedate().sendKeys(jutil.togetRequired(10));
		
		
	}
	
	

}
