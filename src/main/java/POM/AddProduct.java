package POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AddProduct {
	
	//written webelement ad source then select getters and public apply

	WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProdID() {
		return prodID;
	}

	public WebElement getProdname() {
		return prodname;
	}

	public WebElement getProdcategory() {
		return prodcategory;
	}

	public WebElement getProdQuantity() {
		return prodQuantity;
	}

	public WebElement getProdPrice() {
		return prodPrice;
	}

	public WebElement getProdVendorID() {
		return prodVendorID;
	}

	public WebElement getSubmitProduct() {
		return SubmitProduct;
	}

	public AddProduct(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productId")
	private WebElement prodID;
	
	@FindBy(name = "productName")
	private WebElement prodname;
	
	
	@FindBy(name = "productCategory")
	private WebElement prodcategory;
	
	@FindBy (name = "quantity")
	private WebElement prodQuantity;
	
	@FindBy(name = "price")
	private WebElement prodPrice;
	
	@FindBy( name = "vendorId")
	private WebElement prodVendorID;
	
	@FindBy(xpath = "//button[text()=\"Add\"]")
	private WebElement SubmitProduct;

	
	

}
