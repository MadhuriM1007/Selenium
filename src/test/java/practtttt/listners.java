package practtttt;

import java.io.File;
import java.util.Iterator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class listners {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		for(int i=0 ; i<3;i++) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File SourceFile= ts.getScreenshotAs(OutputType.FILE);
		File  targetFile = new File ("C:\\Users\\DELL\\Desktop\\Selenium_notes\\screenshot\\ss1.png");
		
		SourceFile.renameTo(targetFile);

	}

}
}
