package Selenium_Demo.Your_Logo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Resources.base;
import pageObjectReporsitory.ShippingPageObjects;
import pageObjectReporsitory.HomePageObjects;
import pageObjectReporsitory.DeliveryAddressPageObjects;
import pageObjectReporsitory.ShoppingCartPageObjects;

public class shippingPageTest extends base {

    WebDriver driver;
    HomePageObjects homePage;
    ShoppingCartPageObjects shoppingCartPage;
    DeliveryAddressPageObjects deliveryAddressPage;
    ShippingPageObjects shippingPage;
	
	@BeforeMethod
	public void neccessarySteps() throws InterruptedException, IOException {
		driver = initializeBrowserDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		this.homePage = new HomePageObjects(driver);       //Creating object for few steps in driverinitialize method
		this.shoppingCartPage = new ShoppingCartPageObjects(driver);
		this.shippingPage = new ShippingPageObjects(driver);
		this.deliveryAddressPage = new DeliveryAddressPageObjects(driver);
		scrollAndRegisterClick(homePage.findProductPrintedDress());
		Actions action = new Actions(driver);
		action.moveToElement(homePage.findProductPrintedDress()).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-id-product='3']")).click();
		Thread.sleep(10000);
		homePage.proceddToCheckout().click();
		scrollAndRegisterClick(shoppingCartPage.proceedToCheckOut());
		shoppingCartPage.proceedToCheckOut().click();
		signIn("demo@demo1.com","demo@demo1.com");
		scrollAndRegisterClick(deliveryAddressPage.proceedToCheckOut());
		deliveryAddressPage.proceedToCheckOut().click();
	}
	
	
	@Test
	public void TC_SHIPPING_01_Error_Prompt() {
		shippingPage.processAddress().click();
		System.out.println(shippingPage.termsErrorPrompt());
		Assert.assertEquals("You must agree to the terms of service before continuing.", shippingPage.termsErrorPrompt());
	}
	
	@Test
	public void TC_SHIPPING_02_terms_Of_Services_Checkbox() {
		shippingPage.termsCheckBox().click();
		Assert.assertTrue(shippingPage.termsCheckBox().isEnabled());
	}
	
	@Test
	public void TC_SHIPPING_03_Proceed_To_Checkout() {
		TC_SHIPPING_02_terms_Of_Services_Checkbox();
		shippingPage.processAddress().click();
		Assert.assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", shippingPage.paymentMethodPageVerify().getText());
	}
	

	@AfterMethod
	public void browserClosing() {
		driver.quit();
	}
	
	
}
