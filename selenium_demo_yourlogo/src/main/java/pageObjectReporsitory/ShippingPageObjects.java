package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPageObjects {

	WebDriver driver;
	
	
	public ShippingPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By processAddress = By.xpath("//*[@name='processCarrier']");
	By termsErrorPrompt = By.xpath("//p[@class='fancybox-error']");
	By termsCheckBox = By.xpath("//input[@type='checkbox']");
	By paymentMethodPageVerify = By.xpath("//h1[@class='page-heading']");
	
	
	public WebElement processAddress() {
		return driver.findElement(processAddress);
	}
	
	public String termsErrorPrompt() {
		return driver.findElement(termsErrorPrompt).getText();
	}
	
	public WebElement termsCheckBox() {
		return driver.findElement(termsCheckBox);
	}
	
	public WebElement paymentMethodPageVerify() {
		return driver.findElement(paymentMethodPageVerify);
	}
}
