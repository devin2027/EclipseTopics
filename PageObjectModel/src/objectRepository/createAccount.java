
//USING SIMPLE TEST ANNOTATION


package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class createAccount {

	WebDriver driver;
	
	//Create constructor to create driver for this page.
	public createAccount(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locating all the element
	By createAccount = By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']");
	By firstname = By.xpath("//input[@name = 'firstname']");
	
	//returning all the elements
	public WebElement createaccount() {
		return driver.findElement(createAccount);
	}
	
	public WebElement firstName() {
		return driver.findElement(firstname);
	}
}
