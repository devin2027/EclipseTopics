package pageObjectReporsitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPageObjects {

	//Defining web driver scope here
			WebDriver driver;
			
			//Constructor creation for driver connection
			public CreateAccountPageObjects(WebDriver driver) {
				this.driver = driver;
			}	
			
			By createEmail = By.id("email_create");     
			By createAnAccountButton = By.id("SubmitCreate");
			By register = By.id("submitAccount");                             //Submit button on create an account page 
			By alertMessages = By.xpath("//div[@id='center_column']/div/ol");  //Alert messages
			By radioButtonMr = By.xpath("//div[@id='uniform-id_gender1']");   //title
			By radioButtonMrs = By.xpath("//div[@id='uniform-id_gender2']");  //title
			By firstName = By.xpath("//input[@id='customer_firstname']");     //First name
			By lastName = By.xpath("//input[@id='customer_lastname']");       //Last Name
			By email = By.id("email");                                     //Email id field to check attribute
			By password = By.id("passwd");                              //password field
			By day = By.xpath("//select[@id='days']");                        //Day dropdown
			By selectDay = By.xpath("//select[@id='days']/option[11]");       //Day selection
			By month = By.xpath("//select[@id='months']");                   //months dropdown
			By selectMonth = By.xpath("//select[@id='months']/option[8]");    //months selection
			By year = By.xpath("//select[@id='years']");                     //year dropdown
			By selectYear = By.xpath("//select[@id='years']/option[25]");          //Year selection
			By newsletterCheckbox = By.xpath("//div[@id='uniform-newsletter']");   //NewsLetter checkbox
			By address = By.xpath("//input[@id='address1']");                   //Address field
			By city = By.xpath("//input[@id='city']");                             //city field
			By stateDropdown = By.xpath("//select[@id='id_state']");              //State dropdown
			By stateSelect = By.xpath("//select[@id='id_state']/option[6]");     ////State select
			By postalCode = By.xpath("//input[@id='postcode']");                  //Postal Code
			By countrydrown = By.xpath("//select[@id='id_country']");             //Country dropdown
			By countrySelect = By.xpath("//select[@id='id_country']/option[2]");    //select Country 
			By mobilePhone = By.xpath("//input[@id='phone_mobile']");             //Mobile field
			
			public WebElement createEmail() {
				return driver.findElement(createEmail);
			}
			
			public WebElement createAnAccountButton() {
				return driver.findElement(createAnAccountButton);
			}
			
			public WebElement register() {
				return driver.findElement(register);
			}
			
			public WebElement alertMessages() {
				return driver.findElement(alertMessages);
			}
			
			public WebElement radioButtonMr() {
				return driver.findElement(radioButtonMr);
			}
			
			public WebElement radioButtonMrs() {
				return driver.findElement(radioButtonMrs);
			}
			
			public WebElement firstName() {
				return driver.findElement(firstName);
			}
			
			public WebElement lastName() {
				return driver.findElement(lastName);
			}
			
			public WebElement email() {
				return driver.findElement(email);
			}
			
			public WebElement password() {
				return driver.findElement(password);
			}
			
			public WebElement daySelection() {
				return driver.findElement(day);
			}
			
			public WebElement selectDay() {
				return driver.findElement(selectDay);
			}
			
			public WebElement monthDropdown() {
				return driver.findElement(month);
			}
			
			public WebElement selectMonth() {
				return driver.findElement(selectMonth);
			}
			
			public WebElement yearDropdown() {
				return driver.findElement(year);
			}
			
			public WebElement selectYear() {
				return driver.findElement(selectYear);
			}
			
			public WebElement newsletterCheckbox() {
				return driver.findElement(newsletterCheckbox);
			}
			
			public WebElement address() {
				return driver.findElement(address);
			}
			
			public WebElement city() {
				return driver.findElement(city);
			}
			
			public WebElement stateDropdown() {
				return driver.findElement(stateDropdown);
			}
			
			public WebElement stateSelect() {
				return driver.findElement(stateSelect);
			}
			
			public WebElement postalCode() {
				return driver.findElement(postalCode);
			}
			
			public WebElement countrydropdown() {
				return driver.findElement(countrydrown);
			}
			
			public WebElement countrySelect() {
				return driver.findElement(countrySelect);
			}
			
			public WebElement mobilePhone() {
				return driver.findElement(mobilePhone);
			}
			
			
			
}
