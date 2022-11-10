package pageObjectReporsitory;

import org.openqa.selenium.WebDriver;

public class MyAccountPageObject {

	//Defining web driver scope here
	WebDriver driver;
	
	//Constructor creation for driver connection
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}	
	
	public String getTitle() {
		return driver.getTitle();
	}
}
