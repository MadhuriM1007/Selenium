package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E2EcreationCampaign2 {

	public static void main(String[] args) throws InterruptedException {
		////WebDriver driver = new ChromeDriver();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/dashboard");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();

		
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Test_Campaign#23");
		driver.findElement(By.name("campaignStatus")).sendKeys("Open");
		WebElement targetEle =driver.findElement(By.name("targetSize"));
		targetEle.clear();
		targetEle.sendKeys("10");
		//button[text()='Create Campaign']
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		//driver.findElement(By.xpath("//div[text()='Campaign q Successfully Added']"));
		//driver.findElement(By.xpath("//button[@aria-label=\"close\"]")).click();
		
		//validation 
		WebElement creationmsg= driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(creationmsg));
		String msg = creationmsg.getText();
		
		if(msg.contains("Test_Campaign#23"))
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
