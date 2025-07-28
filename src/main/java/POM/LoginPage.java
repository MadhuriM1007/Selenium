package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
//	public LoginPage(WebDriver driver);
//	{
//		this.driver= driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUN() {
		return UN;
	}

	public WebElement getPS() {
		return PS;
	}

	public WebElement getLoginBTN() {
		return LoginBTN;
	}

	@FindBy(id="username")
	private WebElement UN;
	
	@FindBy(id="inputPassword")
	private WebElement PS;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement LoginBTN;
	
	

}
