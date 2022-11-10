package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSummaryObjects {

	WebDriver driver;
	 
	public OrderSummaryObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By orderConfirm = By.xpath("//p[@id= 'cart_navigation']/button");
	By  nextPageConfirmation= By.xpath("//h1[@class= 'page-heading']");
	
	public WebElement orderConfirm() {
		return driver.findElement(orderConfirm);
	}
	
	public String nextPageConfirmation() {
		return driver.findElement(nextPageConfirmation).getText();
	}
	
}
