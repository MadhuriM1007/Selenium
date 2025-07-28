package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.AddProduct;
import POM.HomePage;
import POM.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebDriverUtility;

public class TC4_AddProduct {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//sir for this product TC I am able to execute one more window is opening ?? sir this issue:
	
		
		//Generic utility :
				PropertiesUtility putil = new PropertiesUtility();
				String BROWSER =putil.getdatafrompropertiesfile("Browser");
				String URL =putil.getdatafrompropertiesfile("Url");
				String USERNAME =putil.getdatafrompropertiesfile("Username");
				String PASSWORD =putil.getdatafrompropertiesfile("Password");
				
				ExcelUtility eutility = new ExcelUtility();
				String pname = eutility.getDataFromExcel("Product", 1, 2);
				String psize = eutility.getDataFromExcel("Product", 1, 3);
				String pprize = eutility.getDataFromExcel("Product", 1, 4);
		
		
		
	////WebDriver driver = new ChromeDriver();
			WebDriver driver= new EdgeDriver();
			
		driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(URL);
			
			
			LoginPage lp = new LoginPage(driver);
			lp.getUN().sendKeys(USERNAME);
			lp.getPS().sendKeys(PASSWORD);
			lp.getLoginBTN().click();
			
			HomePage hp= new HomePage(driver);
			hp.getProducts().click();
			Thread.sleep(2000);
			//hp.getProducts().click();
			hp.getGetProduct().click();
			
			WebDriverUtility wutil = new WebDriverUtility();
			
			JavaUtility jutil = new JavaUtility();
			
//			driver.findElement(By.id("username")).sendKeys(USERNAME);
//			driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
//			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
			
//			driver.findElement(By.xpath("//a[text()='Products']")).click();
//			driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
//			
	
			
			AddProduct ap=new AddProduct(driver);
			ap.getProdname().sendKeys(pname + jutil.getRandomNumber());
			ap.getProdQuantity().clear();
			ap.getProdQuantity().sendKeys(psize);
			ap.getProdPrice().clear();
			ap.getProdPrice().sendKeys(pprize);
			wutil.select(ap.getProdcategory(), 2);
			wutil.select(ap.getProdVendorID(), 3);
			//ap.getv
		//	wutil.select(ap.getProdVendorID(), 3);
			ap.getSubmitProduct().click();
			
			
			
			
			
			
//			//Product details:
//			driver.findElement(By.name("productName")).sendKeys(pname+jutil.getRandomNumber());
//			WebElement prodectCategoerySeletion = driver.findElement(By.name("productCategory"));
//			
////			WebDriverUtility wutil = new WebDriverUtility();
//			wutil.select(prodectCategoerySeletion, "Electricals");
//			
////			Select sel = new Select(prodectCategoerySeletion);
////			sel.selectByVisibleText("Electricals");
//			WebElement quantity = driver.findElement(By.name("quantity"));
//			quantity.clear();
//			quantity.sendKeys(psize);
//			
//			WebElement price = driver.findElement(By.name("price"));
//			price.clear();
//			price.sendKeys(pprize);
//			
//			WebElement vendor1 = driver.findElement(By.name("vendorId"));
////			Select sel1 = new Select(vendor1);
////			sel1.selectByValue("VID_001");
//			wutil.select(vendor1, "VID_001");
//			
//			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			
			
			//validation 
			WebElement creationmsg= driver.findElement(By.xpath("//div[@role='alert']"));
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.visibilityOf(creationmsg));
			
			
			wutil.waitforVisisbilityofElement(driver, creationmsg);
			String msg = creationmsg.getText();
			
			if(msg.contains(pname))
			{
				System.out.println("Campaign is created");
			}
			else {
				System.out.println("Camapaign not created");
			}
			
			driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
			
			
			//logout 
			
			driver.findElement(By.xpath("//div[@class='user-icon']")).click();
			driver.findElement(By.xpath("//div[text()='Logout ']")).click();
			
			
			

	}

}
