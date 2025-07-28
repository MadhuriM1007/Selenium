package practtttt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softassertexample {

	@Test
	public void demo() {
		String Expextedtile = "Facebook – log in or sign u";
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
	String actualttile = driver.getTitle();
	 SoftAssert soft= new SoftAssert();
	 soft.assertEquals(actualttile, Expextedtile);
	 System.out.println("Step1");
	 System.out.println("Step2");
	 soft.assertAll();
	}
}
