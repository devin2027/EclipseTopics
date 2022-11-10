package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPageObjects {

	WebDriver driver;
	 
	public PaymentPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By payByCheque = By.xpath("//a[@class='cheque']");
	By nextPageConfirmation = By.xpath("//h1[@class = 'page-heading']");
	
	
	public WebElement payByCheque() {
		return driver.findElement(payByCheque);
	}
	
	public String nextPageConfirmation() {
		return driver.findElement(nextPageConfirmation).getText();
	}
	
}
