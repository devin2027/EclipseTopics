
//---------Before running TC-29 change email and password for successful run--------------
//demo@demo1.com
//demo@demo2.com
//demo@demo3.com
package Selenium_Demo.Your_Logo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjectReporsitory.CreateAccountPageObjects;
import pageObjectReporsitory.MyAccountPageObject;
import pageObjectReporsitory.ShoppingCartPageObjects;
import pageObjectReporsitory.SignInObjects;

public class createAccountPageTest extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());    //Creating logging manager Object for log file
	CreateAccountPageObjects createAccountPage;
	
	
	@BeforeTest()                                                    //For driver Initialization
	public void driverInitialize() throws IOException {
		driver = initializeBrowserDriver();
		driver.manage().window().maximize();
		this.createAccountPage = new CreateAccountPageObjects(driver);
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//a[@class='login']")).click();
		createAccountPage.createEmail().sendKeys("demo@demo3.com");
		createAccountPage.createAnAccountButton().click();	
	}
	
	@Test
	public void TC_CREATE_ACCOUNT_01_Create_Account_Invalid() throws IOException, InterruptedException {
		scrollAndRegisterClick();
		Thread.sleep(1000);            //TODO add synchronization,Because of page refresh 
		Assert.assertEquals("You must register at least one phone number.\n"
				+ "lastname is required.\n"
				+ "firstname is required.\n"
				+ "passwd is required.\n"
				+ "address1 is required.\n"
				+ "city is required.\n"
				+ "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n"
				+ "This country requires you to choose a State.", createAccountPage.alertMessages().getText());
	}
	
	
	//TODO unable to locate radio button
//	@Test
//	public void TC_CREATE_ACCOUNT_02_RadioButton1() throws InterruptedException {
//		Thread.sleep(3000);
//		createAccountPage.radioButtonMr().click();
//		Thread.sleep(3000);
//		Assert.assertTrue(createAccountPage.radioButtonMr().isSelected());
//	}
	
	//TODO unable to locate radio button
//	@Test
//	public void TC_CREATE_ACCOUNT_03_RadioButton2() throws InterruptedException {
//		Thread.sleep(3000);
//		createAccountPage.radioButtonMrs().click();
//		Thread.sleep(3000);
//		Assert.assertTrue(createAccountPage.radioButtonMsr().isSelected());
//	}
	
	
	@Test
	public void TC_CREATE_ACCOUNT_04_First_Name_Invalid() throws InterruptedException {
		Thread.sleep(3000);
		createAccountPage.firstName().sendKeys("123");
		scrollAndRegisterClick();
		Assert.assertEquals("firstname is invalid.", createAccountPage.alertMessages().getText().split("\n")[2]);
	}
	
	@Test
	public void TC_CREATE_ACCOUNT_05_First_Name_Invalid1() throws InterruptedException {
		Thread.sleep(3000);
		createAccountPage.firstName().sendKeys("qwertyuiopasdfghjklzxcvbnmqwertyuiop");
		scrollAndRegisterClick();
		Assert.assertEquals("firstname is too long. Maximum length: 32", createAccountPage.alertMessages().getText().split("\n")[2]);
	}
	
	@Test
	public void TC_CREATE_ACCOUNT_06_First_Name_Invalid2() throws InterruptedException {
		Thread.sleep(3000);
		createAccountPage.firstName().sendKeys("123abc");
		scrollAndRegisterClick();
		Assert.assertEquals("firstname is invalid.", createAccountPage.alertMessages().getText().split("\n")[2]);
	}
	
	@Test
	public void TC_CREATE_ACCOUNT_07_First_Name_Valid() throws InterruptedException {
		Thread.sleep(3000);
		createAccountPage.firstName().sendKeys("Sunil");
		Assert.assertEquals("Sunil", createAccountPage.firstName().getAttribute("value"));	
	}
	
	@Test
	public void TC_CREATE_ACCOUNT_16_Date_Selection() throws InterruptedException {
		Thread.sleep(3000);
		createAccountPage.daySelection().click();
		Thread.sleep(3000);	
		createAccountPage.selectDay().click();
		Thread.sleep(3000);	
	}
	
	@Test
	public void TC_CREATE_ACCOUNT_29_Account_Create_E2E() throws InterruptedException {
	Thread.sleep(10000);                                          //TODO add synchronization,Because of page refresh 
		createAccountPage.firstName().sendKeys("Rahul");
		createAccountPage.lastName().sendKeys("Shetty");
		createAccountPage.password().sendKeys("demo@demo3.com");
		createAccountPage.daySelection().click();
		createAccountPage.selectDay().click();
		createAccountPage.monthDropdown().click();
		createAccountPage.selectMonth().click();
		createAccountPage.yearDropdown().click();
		createAccountPage.selectYear().click();
		createAccountPage.newsletterCheckbox().click();
		createAccountPage.address().sendKeys("chinchpokhli galy");
		createAccountPage.city().sendKeys("xyz");
		createAccountPage.stateDropdown().click();
		createAccountPage.stateSelect().click();
		createAccountPage.postalCode().sendKeys("11023");
		createAccountPage.countrydropdown().click();
		createAccountPage.countrySelect().click();
		Thread.sleep(3000);                 //TODO add synchronization,Because of page refresh 
		createAccountPage.mobilePhone().sendKeys("9320147823");
		createAccountPage.register().click();
		MyAccountPageObject myAccountPageObject= new MyAccountPageObject(driver);
		Thread.sleep(3000);                     //TODO add synchronization,Because of page refresh 
		Assert.assertEquals("My account - My Store", myAccountPageObject.getTitle() );
	}
	
	
	
	@AfterTest
	public void browserClosing() {
		driver.quit();
	}
	
	@DataProvider
	public Object[] getSignInData() {
	
		Object [] signInData = new Object[1];
		
		signInData [0] = "demo@demo1.com";
		
		return signInData;
	}
	
	//Repeating steps
	public void scrollAndRegisterClick() throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		Thread.sleep(5000);             //TODO add synchronization,Because of page refresh 
		jsExecutor.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(3000);
		createAccountPage.register().click();
	}
}



//driver = initializeBrowserDriver();
//driver.manage().window().maximize();
//this.createAccountPage = new CreateAccountPageObjects(driver);       //Creating object for few steps in driverinitialize method
//this.shoppingCartPage = new ShoppingCartPageObjects(driver);         //Creating object for shopping page.
//log.info("Driver is initialized");
//driver.get(prop.getProperty("url"));
//driver.findElement(By.xpath("//a[@class='login']")).click();
//createAccountPage.createEmail().sendKeys("demo@demo1.com");
//Thread.sleep(10000);
//createAccountPage.createAnAccountButton().click();	
//Thread.sleep(10000);
//createAccountPage.firstName().sendKeys("Rahul");
//createAccountPage.lastName().sendKeys("Shetty");
//createAccountPage.password().sendKeys("demo@demo1.com");
//createAccountPage.daySelection().click();
//createAccountPage.selectDay().click();
//createAccountPage.monthDropdown().click();
//createAccountPage.selectMonth().click();
//createAccountPage.yearDropdown().click();
//createAccountPage.selectYear().click();
//createAccountPage.newsletterCheckbox().click();
//createAccountPage.address().sendKeys("chinchpokhli galy");
//createAccountPage.city().sendKeys("xyz");
//createAccountPage.stateDropdown().click();
//createAccountPage.stateSelect().click();
//createAccountPage.postalCode().sendKeys("11023");
//createAccountPage.countrydropdown().click();
//createAccountPage.countrySelect().click();
//Thread.sleep(3000);
//createAccountPage.mobilePhone().sendKeys("9320147823");
//createAccountPage.register().click();