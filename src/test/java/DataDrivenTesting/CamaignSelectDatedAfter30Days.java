package DataDrivenTesting;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CamaignSelectDatedAfter30Days {

	public static void main(String[] args) {
		
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/dashboard");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
		
		Random ran= new Random();
		int randomcount= ran.nextInt(10000);
		
		 Date date=new Date();
		 SimpleDateFormat sim= new SimpleDateFormat("MM-dd-YYYY");
		 sim.format(date);
		 Calendar cal = sim.getCalendar();
		 cal.add(Calendar.DAY_OF_MONTH, 30);
		 String datereq= sim.format(cal.getTime());
		 
		
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Test_Campaign#23" + randomcount);
		driver.findElement(By.name("campaignStatus")).sendKeys("Open");
		WebElement targetEle =driver.findElement(By.name("targetSize"));
		targetEle.clear();
		targetEle.sendKeys("10");
		WebElement closeDate = driver.findElement(By.name("expectedCloseDate"));
		Actions act1= new Actions(driver);
		act1.click(closeDate).sendKeys(datereq).perform();
		
		
		
	}

}
