package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactCreation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/dashboard");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();

		//Contact Creation 
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']//span")).click();
		driver.findElement(By.name("organizationName")).sendKeys("Test3");
		//
		driver.findElement(By.name("title")).sendKeys("Test3");
		driver.findElement(By.name("contactName")).sendKeys("Test3");
		driver.findElement(By.name("mobile")).sendKeys("1234567899");
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		Thread.sleep(3000);
		
		//way1: to handle another window 
//		Set<String> windowids = driver.getWindowHandles();
//		for(String windowid:windowids)
//		{	
//			System.out.println(windowid);
//			System.out.println(driver.switchTo().window(windowid).getTitle());
//			
// 		}
		
		//way2 : to handle another window 
		Set<String> windowids = driver.getWindowHandles();
		List<String>windowList= new ArrayList(windowids);
		
		String ParentID = windowList.get(0);
		String ChildID = windowList.get(1);
		
		//switch to child 
		driver.switchTo().window(ChildID);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[@class='select-btn']")).click();
		driver.switchTo().window(ParentID);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//validation 
		
		WebElement creationmsg= driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(creationmsg));
		String msg = creationmsg.getText();
		System.out.println(msg);
		
		if(msg.contains("Test3"))
		{
			System.out.println("Contact is created successfully");
		}
		else
		{
			System.out.println("Contact is not created");
		}
		driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
		
		//logout
		driver.findElement(By.xpath("//div[@class='user-icon']")).click();
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
		
		
	}

}
