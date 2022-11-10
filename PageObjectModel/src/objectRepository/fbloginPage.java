
// USING FINDBY ANNOTATION
package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fbloginPage {
   
	WebDriver driver;
	
	//Create constructor to create driver for this page.
	public fbloginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	//Locating all the element
	@FindBy(xpath = "//input[@name = 'email']")
	WebElement username;
	
	//Returning element
	public WebElement username() {
		return username;
	}
	
}
