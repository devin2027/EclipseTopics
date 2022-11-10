package Selenium_Demo.Your_Logo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjectReporsitory.CreateAccountPageObjects;
import pageObjectReporsitory.HomePageObjects;
import pageObjectReporsitory.ShoppingCartPageObjects;

public class shoppingCartPageTest extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());    //Creating logging manager Object for log file
	HomePageObjects homePage;   
	ShoppingCartPageObjects shoppingCartPage;
	
	@BeforeMethod()                                                    //For driver Initialization
	public void driverInitialize() throws IOException, InterruptedException {
		driver = initializeBrowserDriver();
		driver.manage().window().maximize();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		this.homePage = new HomePageObjects(driver);       //Creating object for few steps in driverinitialize method
		scrollAndRegisterClick(homePage.findProductPrintedDress());
		Actions action = new Actions(driver);
		action.moveToElement(homePage.findProductPrintedDress()).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-id-product='3']")).click();
		Thread.sleep(10000);
		homePage.proceddToCheckout().click();
		this.shoppingCartPage = new ShoppingCartPageObjects(driver);
		Assert.assertEquals("Order - My Store", shoppingCartPage.getTitle());
	}	
	
	
	@Test
	public void TC_SHOPPING_CART_01_Product_Quantity_Increase() throws InterruptedException {
		String quantity = shoppingCartPage.getProductQuantity();
		shoppingCartPage.addProduct().click();
		String increasedQuantity = shoppingCartPage.getProductQuantity();
		Assert.assertEquals(quantity, increasedQuantity);
	}
	
	@Test
	public void TC_SHOPPING_CART_02_Product_Quantity_Reduce() throws InterruptedException {
		String quantity = shoppingCartPage.getProductQuantity();
		shoppingCartPage.minusProduct().click();
		String decreasedQuantity = shoppingCartPage.getProductQuantity();
		Assert.assertEquals(quantity, decreasedQuantity);
	}
	
	@Test
	public void TC_SHOPPING_CART_03_Delete_Product() throws InterruptedException {
		shoppingCartPage.delete().click();
		Thread.sleep(5000);
		System.out.println(shoppingCartPage.warningMessage());
	    Assert.assertEquals( shoppingCartPage.warningMessage() , "Your shopping cart is empty.");
	}
	
	@Test(dataProvider = "getSignInData")
	public void TC_SHOPPING_CART_04_Proceed_To_Checkout(String email,String password) throws InterruptedException {
		scrollAndRegisterClick(shoppingCartPage.proceedToCheckOut());
		shoppingCartPage.proceedToCheckOut().click();
		String pagetitle = shoppingCartPage.getTitle();
		if(pagetitle.equalsIgnoreCase("Login - My Store")) {
			signIn(email,password);
		}
		Thread.sleep(5000);
		Assert.assertEquals("ADDRESSES", shoppingCartPage.nextAddressPage());
	}
	
	
	@AfterMethod
	public void browserClosing() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getSignInData() {
	
		Object [][] signInData = new Object[1][2];
		
		signInData [0][0] = "demo@demo1.com";
		signInData [0][1] = "demo@demo1.com";
		
		return signInData;
	}
	
	
}
