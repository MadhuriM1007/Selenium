package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelFileUtility.ExcelUtility;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebDriverUtility;

public class E2EcreationCampaign3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		PropertiesUtility prop = new PropertiesUtility();
		String BROWSER=prop.getdatafrompropertiesfile("Browser");
		String URL=prop.getdatafrompropertiesfile("Url");
		String USERNAME=prop.getdatafrompropertiesfile("Username");
		String PASSWORD=prop.getdatafrompropertiesfile("Password");
		
		ExcelUtility eutil= new ExcelUtility();
		String CAMPNAME = eutil.getDataFromExcel("Campaign", 1, 2);
		String CAMPTARGET = eutil.getDataFromExcel("Campaign", 1, 3);
		String CAMPSTATUS = eutil.getDataFromExcel("Campaign", 1, 4);
		
		////WebDriver driver = new ChromeDriver();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();

		
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(CAMPNAME);
		driver.findElement(By.name("campaignStatus")).sendKeys(CAMPSTATUS);
		WebElement targetEle =driver.findElement(By.name("targetSize"));
		targetEle.clear();
		targetEle.sendKeys(CAMPTARGET);
		//button[text()='Create Campaign']
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		//driver.findElement(By.xpath("//div[text()='Campaign q Successfully Added']"));
		//driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
		
		//validation 
		WebElement creationmsg= driver.findElement(By.xpath("//div[@role='alert']"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(creationmsg));
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.waitforVisisbilityofElement(driver, creationmsg);
		String msg = creationmsg.getText();
		
		if(msg.contains(CAMPNAME))
		{
			System.out.println("Campaign is created");
		}
		else {
			System.out.println("Camapaign not created");
		}
		
		driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
		
		
		//logout 
		
		WebElement profile = driver.findElement(By.xpath("//div[@class='user-icon']"));
		WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']"));
		wutil.clickonWebElement(driver, profile);
		wutil.clickonWebElement(driver, logout);
		
	}

}
