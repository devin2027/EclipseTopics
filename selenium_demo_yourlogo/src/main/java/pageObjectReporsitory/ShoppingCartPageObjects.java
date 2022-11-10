package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPageObjects {

	WebDriver driver;
	
	public ShoppingCartPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	By getProductQuantity = By.xpath("//td[@class='cart_quantity text-center']/input[1]");
	By addProduct = By.xpath("//a[@class='cart_quantity_up btn btn-default button-plus']");
	By minusProduct = By.xpath("//a[@class='cart_quantity_down btn btn-default button-minus']");
	By delete = By.xpath("//a[@class='cart_quantity_delete']");
	By proceedToCheckOut = By.xpath("//p[@class='cart_navigation clearfix']/a[1]");
	By warningMessage = By.xpath("//p[@class='alert alert-warning']");
	By nextAddressPage = By.xpath("//h1[@class='page-heading']");
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getProductQuantity() {
		return driver.findElement(getProductQuantity).getAttribute(getTitle());
	}
	public WebElement addProduct() {
		return driver.findElement(addProduct);
	}
	
	public WebElement minusProduct() {
		return driver.findElement(minusProduct);
	}
	
	public WebElement delete() {
		return driver.findElement(delete);
	}
	
	public WebElement proceedToCheckOut() {
		return driver.findElement(proceedToCheckOut);
	}
	
	public String warningMessage() {
		return driver.findElement(warningMessage).getText();
	}
	
	public String nextAddressPage() {
		return driver.findElement(nextAddressPage).getText();
	}
}
