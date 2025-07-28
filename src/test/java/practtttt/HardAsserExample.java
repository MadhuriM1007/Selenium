package practtttt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAsserExample {
	
	@Test
	public void demo() {
		String Expextedtile = "Facebook – log in or sign u";
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
	String actualttile = driver.getTitle();
	 Assert.assertEquals(actualttile, Expextedtile);
	 System.out.println("Step1");
	 System.out.println("Step2");
	}

}
