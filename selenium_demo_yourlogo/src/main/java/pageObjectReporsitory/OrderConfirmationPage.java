package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage {
	
	WebDriver driver;
	 
	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By backToOrders = By.xpath("//a[@title= 'Back to orders']");
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public WebElement backToOrders() {
		return driver.findElement(backToOrders);
	}
	
}
