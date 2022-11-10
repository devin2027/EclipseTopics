package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageObjects {

	//Defining web driver scope here
	WebDriver driver;
	
	////Constructor for Initializing driver
	SearchPageObjects(WebDriver driver){
		this.driver = driver;
	}
	
	By headingCounter = By.className("heading-counter");
	
	public String getAlertMessageText() {
		return driver.findElement(headingCounter).getText();
	}
}
