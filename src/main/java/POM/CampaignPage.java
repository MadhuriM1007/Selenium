package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCampname() {
		return campname;
	}

	public WebElement getCampstatus() {
		return campstatus;
	}

	public WebElement getTsize() {
		return tsize;
	}

	public WebElement getExpclosedate() {
		return expclosedate;
	}

	public WebElement getSumbitcreatecamp() {
		return sumbitcreatecamp;
	}

	@FindBy(name = "campaignName")
	private WebElement campname;
	
	
	@FindBy(name = "campaignStatus")
	private WebElement campstatus;
	
	
	@FindBy(name = "targetSize")
	private WebElement tsize;
	
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expclosedate;
	
	@FindBy(xpath = "//button[text()=\"Create Campaign\"]")
	private WebElement sumbitcreatecamp;

}
