package Selenium_Demo.Your_Logo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjectReporsitory.HomePageObjects;
import pageObjectReporsitory.SignInObjects;

public class homePageTest extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());    //Creating logging manager Object for log file
	HomePageObjects homePage;
	
	@BeforeTest                                                    //For driver Initialization
	public void driverInitialize() throws IOException {
		driver = initializeBrowserDriver();
		driver.manage().window().maximize();
		log.info("Driver is initialized");
	}
	
	
	@Test
	public void TC_HOME_00_Browser_Invoking() throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigate to Home Page");
		this.homePage = new HomePageObjects(driver);           //HomePageObjects object declaration
		Assert.assertEquals("My Store", homePage.PageTitle());		
	}
	
	@Test
	public void TC_HOME_01_Banner_Image() throws IOException {
		TC_HOME_00_Browser_Invoking();
	    boolean x = homePage.bannerImage();
		Assert.assertTrue(x);
	}
	
	@Test
	public void TC_HOME_02_Contact_Us_Button() throws IOException {
		TC_HOME_00_Browser_Invoking();
		homePage.ContactUs().click();
		//String title= driver.getTitle();
		Assert.assertEquals("Contact us - My Store", homePage.PageTitle());
	}
	
	@Test
	public void TC_HOME_03_Sign_In_Button() throws IOException {
		TC_HOME_00_Browser_Invoking();
		homePage.signIn();
		Assert.assertEquals("Login - My Store", homePage.PageTitle());
	}
	
	@Test
	public void TC_HOME_04_Brand_Logo() throws IOException {
		TC_HOME_00_Browser_Invoking();
		homePage.BrandLogo().click();
		Assert.assertEquals("My Store", homePage.PageTitle());
	}
	
	@Test
	public void TC_HOME_05_Search_Invalid() throws IOException, InterruptedException {
		TC_HOME_00_Browser_Invoking();
		//Actions actions = new Actions(driver);
		homePage.search_query().sendKeys("Invalid data");
		Assert.assertEquals(homePage.submitButton(), "0 results have been found." );
		
	}
	
	@Test
	public void TC_HOME_06_Search_Valid() throws IOException {
		TC_HOME_00_Browser_Invoking();
		homePage.search_query().sendKeys("Printed");
		String headingCounterString = homePage.submitButton();
		String[] CounterStringSplit = headingCounterString.split(" ");
		String CounterIndex1 = CounterStringSplit[0];
		int totalProduct = Integer.parseInt(CounterIndex1);
		Assert.assertTrue(totalProduct>0);		
	}
	
	@Test
	public void TC_HOME_07_Shopping_Cart_Empty() throws IOException {
		TC_HOME_00_Browser_Invoking();
		String cartText = homePage.cartQuantityText();
		if(cartText.equalsIgnoreCase("(empty)")) {
			homePage.viewShoppingCart().click();
			Assert.assertEquals(homePage.PageTitle(),"Order - My Store");
		}
		else
			Assert.fail("Cart is not Empty");			
	}
	
	@Test
	public void TC_HOME_08_Add_to_cart() throws IOException, InterruptedException {
		TC_HOME_00_Browser_Invoking();
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		Thread.sleep(5000);             //TODO add synchronization,Because of page refresh 
		jsExecutor.executeScript("window.scrollBy(0,550)");                          //Invoking window scroll method in base
		Actions action = new Actions(driver);
		action.moveToElement(homePage.findProductPrintedDress()).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a")).getText();
		driver.findElement(By.xpath("//a[@data-id-product='3']")).click();
		Thread.sleep(10000);
		driver.findElement(By.className("continue")).click();
		action.moveToElement(homePage.viewShoppingCart()).build().perform();
		int numberOfProductInCart = Integer.parseInt(homePage.numberOfProductInCart().getText());
		Assert.assertTrue("Product is not added", numberOfProductInCart>0);
	}
	
	@Test                                 //Comparing the added product with the product in cart
	public void TC_HOME_09_Shopping_Cart_Product() throws IOException, InterruptedException {      
		TC_HOME_08_Add_to_cart();  
		String productName = driver.findElement(By.xpath("//ul[@id='homefeatured']/li[3]/div/div[2]/h5/a")).getText();
		String cartProductName = driver.findElement(By.xpath("//a[@class='cart-images']/img")).getAttribute("alt");
		Assert.assertEquals(productName, cartProductName);		
	}
	
	@Test                                    //After clicking on cart navigating to Shopping cart summary page
	public void TC_HOME_10_Shopping_Cart () throws IOException, InterruptedException {   
		TC_HOME_08_Add_to_cart();  
		homePage.viewShoppingCart().click();
		Thread.sleep(5000);
		Assert.assertEquals(homePage.PageTitle(),"Order - My Store");	
	}
	
	@Test                                    //Click on shopping cart button after hovering on cart
	public void TC_HOME_11_Shopping_Cart_2() throws IOException, InterruptedException {  
		TC_HOME_08_Add_to_cart();  
		Thread.sleep(3000);
		homePage.afterHoverCartButton().click();
		Thread.sleep(3000);
		Assert.assertEquals(homePage.PageTitle(),"Order - My Store");	
	}
	

	
	
//	@Test(dataProvider = "getSignInData")
//public void Browser_Invoking(String email,String password) throws IOException {
//		
//		
//		driver.get(prop.getProperty("url"));
//		log.info("Navigate to Home Page");
//		HomePageObjects homePage = new HomePageObjects(driver);
//		Assert.assertEquals("My Store", homePage.PageTitle());
//		
//		//driver.get("http://automationpractice.com/index.php");
//		
////		//HomePageObjects object declaration
////		HomePageObjects homePage = new HomePageObjects(driver);
////		//homePage.bannerImage();
////		SignInObjects signIn = homePage.signIn();
////		
////		//SignInObjects object declaration
////		//SignInObjects signIn = new SignInObjects(driver);
////		signIn.email().sendKeys(email);
////		signIn.password().sendKeys(password);
////		Assert.assertEquals("Email address",signIn.emailLabel().getText());
////		log.info("Successfully validated text message");
////			
//	}
	
//	@Test
//	public void TC_HOME_06_Search_Valid() throws IOException {
//		TC_HOME_00_Browser_Invoking();
//		homePage.search_query().sendKeys("Printed");
//		int totalProduct = Integer.parseInt(homePage.submitButton().split(" ")[0]);
//		Assert.assertTrue(totalProduct>0);		
//	}
//	
	@AfterTest
	public void browserClosing() {
		driver.quit();
	}
	
//	@DataProvider
//	public Object[][] getSignInData() {
//	
//		Object [][] signInData = new Object[1][2];
//		
//		signInData [0][0] = "abc@email.com";
//		signInData [0][1] = "xyz";
//		
////		signInData [1][0] = "def@email.com";
////		signInData [1][1] = "qwerty";
//	
//		return signInData;
//	}
	
	
}
