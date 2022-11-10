
//USING FINDBY TEST ANNOTATION


package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.fbloginPage;


public class fbloginPageFindBy {

	@Test
	public void login() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dsingh\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		fbloginPage fblogin = new fbloginPage(driver);
		fblogin.username().sendKeys("abc");
	    driver.close();
	}
}
