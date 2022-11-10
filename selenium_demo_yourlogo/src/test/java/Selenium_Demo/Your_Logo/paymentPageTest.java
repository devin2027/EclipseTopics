package Selenium_Demo.Your_Logo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.base;
import pageObjectReporsitory.DeliveryAddressPageObjects;
import pageObjectReporsitory.HomePageObjects;
import pageObjectReporsitory.OrderConfirmationPage;
import pageObjectReporsitory.OrderSummaryObjects;
import pageObjectReporsitory.PaymentPageObjects;
import pageObjectReporsitory.ShippingPageObjects;
import pageObjectReporsitory.ShoppingCartPageObjects;

public class paymentPageTest extends base {

	    WebDriver driver;
	    HomePageObjects homePage;
	    ShoppingCartPageObjects shoppingCartPage;
	    DeliveryAddressPageObjects deliveryAddressPage;
	    ShippingPageObjects shippingPage;
	    PaymentPageObjects paymentPage;
	    OrderSummaryObjects orderSummary;
	    OrderConfirmationPage orderConfirmationPage;
	
	@BeforeMethod
	public void neccessarySteps() throws InterruptedException, IOException {
		driver = initializeBrowserDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		this.homePage = new HomePageObjects(driver);       //Creating object for few steps in driverinitialize method
		this.shoppingCartPage = new ShoppingCartPageObjects(driver);
		this.shippingPage = new ShippingPageObjects(driver);
		this.deliveryAddressPage = new DeliveryAddressPageObjects(driver);
		this.paymentPage = new PaymentPageObjects(driver);
		this.orderSummary = new OrderSummaryObjects(driver);
		this.orderConfirmationPage = new OrderConfirmationPage(driver);
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
		shippingPage.termsCheckBox().click();
		shippingPage.processAddress().click();
		
	}
	
	@Test
	public void TC_PAYMENT_01_Payment_Method() throws InterruptedException {
		scrollAndRegisterClick(paymentPage.payByCheque());
		paymentPage.payByCheque().click();
		Assert.assertEquals("ORDER SUMMARY", paymentPage.nextPageConfirmation());
	}
	
	@Test
	public void TC_PAYMENT_02_Order_Confirmation() throws InterruptedException {
		TC_PAYMENT_01_Payment_Method();
		orderSummary.orderConfirm().click();
		Assert.assertEquals("ORDER CONFIRMATION", orderSummary.nextPageConfirmation());
	}
	
	@Test
	public void TC_PAYMENT_03_Back_To_Orders() throws InterruptedException {
		TC_PAYMENT_02_Order_Confirmation();
		orderConfirmationPage.backToOrders().click();
		Assert.assertEquals("Order history - My Store", orderConfirmationPage.getTitle());
	}
	
	//->1
//	@AfterMethod
//	public void htmltopdf() {
//		String outputFile = System.getProperty("user.dir")+"\\Reports\\indexpdf.pdf";
//
//		generatePDF(System.getProperty("user.dir")+"\\Reports\\index.html", outputFile);
//	}
}
