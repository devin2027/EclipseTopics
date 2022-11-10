package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

	//Defining web driver scope here
	WebDriver driver;
	
	//Constructor for Initializing driver
	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	By sign = By.xpath("//a[@class='login']");
	By banner = By.xpath("//img[@class='img-responsive']");
	@FindBy(xpath = "//a[@title ='Contact Us']")
	WebElement contactUs;
	By brandLogo = By.className("logo");
	By search = By.className("search_query");
	By submitButton = By.cssSelector("button[name='submit_search']");
	By cartText = By.className("ajax_cart_no_product");
	By cartLocator = By.xpath("//a[@title='View my shopping cart']");
	By productPrintedDress = By.xpath("//ul[@id='homefeatured']/li[3]");
	By productQuantityCart = By.xpath("//a[@title='View my shopping cart']/span[1]");
	By afterHoverCartLocator = By.id("button_order_cart");
	By proceddToCheckout = By.xpath("//a[@title='Proceed to checkout']");
	
    //To get page title in as a string
	public String PageTitle() {
		return driver.getTitle();
	}
	
	//ContactUs button locator in menu of home page
	public WebElement ContactUs() {
		return contactUs;
	}
	
	//To click on Sign In button on HomePage
	public SignInObjects signIn() {
		 driver.findElement(sign).click();
		//SignInObjects signIn = new SignInObjects(driver);
		 return new SignInObjects(driver);
	}
	
	//Click on Brand logo On Home page
	public WebElement BrandLogo() {
	return	driver.findElement(brandLogo);
	}
	
	//TODO - Not returning the boolean result of Banner Image
	public boolean bannerImage() {
		
		Boolean isImageLoaded = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", banner);
		if (isImageLoaded.equals(true)) {
			return true;
		}
		else
			return false;
	}
	
	//Click on Search box
	public  WebElement search_query() {
		return driver.findElement(search);
	}
	
	//Submit button search of search field
	public String submitButton() {
		driver.findElement(submitButton).click();
		SearchPageObjects SearchPage = new SearchPageObjects(driver);
		return SearchPage.getAlertMessageText();	
	}
	
	//Cart button text to check number of items
	public String cartQuantityText() {
		return driver.findElement(cartText).getText();
	}
	
	//Click on cart
	public WebElement viewShoppingCart() {
		return driver.findElement(cartLocator);
	}
	
	//Finding particular product to hover
	public WebElement findProductPrintedDress() {
		return driver.findElement(productPrintedDress);
	}
	
	//To find total number of products added in cart
	public WebElement numberOfProductInCart() {
		return driver.findElement(productQuantityCart);
	}
	
	//Clicking on cart button after hover
	public WebElement afterHoverCartButton() {
		return driver.findElement(afterHoverCartLocator);
	}
	
	//
	public WebElement proceddToCheckout() {
		return driver.findElement(proceddToCheckout);
	}
}
