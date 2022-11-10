
//USING SIMPLE TEST ANNOTATION

package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.createAccount;
import objectRepository.mmtLoginpage;

public class loginPage {

	@Test
	public void login() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dsingh\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		mmtLoginpage mmt = new mmtLoginpage(driver);
		mmt.username().sendKeys("abc");
		mmt.password().sendKeys("xyz");
		//mmt.click().click();
		
		createAccount fbCreateAcc = new createAccount(driver);
		fbCreateAcc.createaccount().click();
		fbCreateAcc.firstName().sendKeys("Devinder");
		driver.close();
		
	}
	
}
