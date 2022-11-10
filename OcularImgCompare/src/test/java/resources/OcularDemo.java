package resources;

import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.testautomationguru.ocular.Ocular;

import PageObject.AutomationDemoSitePageObject;

public class OcularDemo {

	
	private WebDriver driver;
	private AutomationDemoSitePageObject page;
	
	@BeforeSuite
	public void ocularConfig() {
		Ocular.config()
		       .snapshotPath(Paths.get(("user.dir")+"\\snap"))
		       .resultPath(Paths.get(("user.dir")+"\\result"));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	// during this test, snap folder is empty. ocular does not find any baseline images. 
    // so, ocular creates the baseline images and comparison result will be always TRUE
	@Test
	public void baselineTest() throws InterruptedException {
        driver.get("file:///" + Paths.get("chart-js.html").toAbsolutePath());
        
        page = new AutomationDemoSitePageObject(driver);
        
        Assert.assertTrue(page.verifylogoimg());
    }
	
	// during this test, snap folder contains the baseline images.
    // so, ocular compares the actual webelement against the given image & returns the result
	 @Test(dependsOnMethods = "baselineTest")
	    public void visaul_test_without_any_change() throws InterruptedException {
	        driver.get("file:///" + Paths.get("chart-js.html").toAbsolutePath());

	        page = new AutomationDemoSitePageObject(driver);

	        Assert.assertTrue(page.verifylogoimg());
	    }
	 
	// snap folder already contains the baseline images.
	    // so, ocular compares the actual webelement against the given image & returns the result
	    // income chart data is changed - so it will fail
	    @Test(dependsOnMethods = "visaul_test_without_any_change")
	    public void visaul_test_after_change() throws InterruptedException {
	        driver.get("file:///" + Paths.get("chart-js-changed.html").toAbsolutePath());

	        page = new AutomationDemoSitePageObject(driver);

	        Assert.assertTrue(page.verifylogoimg());
	    }
	 
}
