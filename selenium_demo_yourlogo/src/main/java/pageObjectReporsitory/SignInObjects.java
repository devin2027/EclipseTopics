package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInObjects {

	//Defining web driver scope here
		WebDriver driver;
		
	//Constructor creation for driver connection
		public SignInObjects(WebDriver driver) {
			this.driver = driver;
		}
		
		By createEmail = By.id("email_create");
		By createAnAccountButton = By.id("SubmitCreate");
		By invalidEmailMessage = By.xpath("//div[@id='create_account_error']/ol");
		By email = By.cssSelector("input[id='email']");
		By password = By.cssSelector("input[id='passwd']");
		By emailLabel = By.cssSelector("label[for='email']");
		By passwordLabel = By.cssSelector("label[for='passwd']");
		By submit = By.id("SubmitLogin");
		
		
		//To get page title in as a string
		public String PageTitle() {
			return driver.getTitle();
		}
		public WebElement createEmail() {
			return driver.findElement(createEmail);
		}
		
		public WebElement createAnAccountButton() {
			return driver.findElement(createAnAccountButton);
		}
		
		public WebElement invalidEmailMessage() {
			return driver.findElement(invalidEmailMessage);
		}
		
		public WebElement email() {
			return driver.findElement(email);
		}
		
		public WebElement password() {
			return driver.findElement(password);
		}
		
		public WebElement emailLabel() {
			return driver.findElement(emailLabel);
		}
		
		public WebElement passwordLabel() {
			return driver.findElement(passwordLabel);
		}
		
		public WebElement submit() {
			return driver.findElement(submit);
		}
		
}
