
//USING SIMPLE TEST ANNOTATION

package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mmtLoginpage {

	WebDriver driver;
	
	//Create constructor to create driver for this page.
	public mmtLoginpage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locating all the element
	By username = By.xpath("//*[@name = 'email']");
	By password = By.xpath("//input[@id='pass']");
	By click = By.name("login");
	
	//returning all the elements
	public WebElement username() {
	return	driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement click() {
		return driver.findElement(click);
	}
}
