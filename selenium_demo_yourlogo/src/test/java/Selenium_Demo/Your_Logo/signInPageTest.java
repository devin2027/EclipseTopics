package Selenium_Demo.Your_Logo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjectReporsitory.SignInObjects;

public class signInPageTest extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());    //Creating logging manager Object for log file
	SignInObjects signInPage;
	
	
	@BeforeTest                                                    //For driver Initialization
	public void driverInitialize() throws IOException {
		driver = initializeBrowserDriver();
		driver.manage().window().maximize();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//a[@class='login']")).click();
		this.signInPage = new SignInObjects(driver);
	}
	
	@Test
	public void TC_SIGN_IN_01_Create_Account_Invalid() throws IOException, InterruptedException {
		signInPage.createEmail().sendKeys("abcd");
		signInPage.createAnAccountButton().click();
		Thread.sleep(3000);      //TODO add synchronization,Because of page refresh 
		System.out.println(signInPage.invalidEmailMessage().getText());
	}
	
	@Test
	public void TC_SIGN_IN_02_Create_Account_Invalid_Null_Data() throws IOException, InterruptedException {
		signInPage.createAnAccountButton().click();
		Thread.sleep(3000);      //TODO add synchronization,Because of page refresh 
		System.out.println(signInPage.invalidEmailMessage().getText());
	}
	
	@Test(dataProvider = "getSignInData")
	public void TC_SIGN_IN_03_Create_Account_Valid(String newEmailID) throws InterruptedException {
		signInPage.createEmail().sendKeys(newEmailID);
		signInPage.createAnAccountButton().click();
		Assert.assertEquals("Login - My Store", signInPage.PageTitle());
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
}
