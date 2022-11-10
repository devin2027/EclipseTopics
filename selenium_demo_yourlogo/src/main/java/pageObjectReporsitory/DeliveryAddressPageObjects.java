package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryAddressPageObjects {

	WebDriver driver;
	
	
	public DeliveryAddressPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By proceedToCheckout = By.xpath("//button[@name='processAddress']");
	
	
	public WebElement proceedToCheckOut() {
		return driver.findElement(proceedToCheckout);
	}
	
}
