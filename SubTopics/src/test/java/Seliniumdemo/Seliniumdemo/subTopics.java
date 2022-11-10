package Seliniumdemo.Seliniumdemo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class subTopics {
	
	@Test(priority='1')
	public void runtest() throws InterruptedException, MalformedURLException, IOException{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dsingh\\eclipse-workspace\\chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
//		IMPLICIT WAIT
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
//      FLUENT WAIT		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2));
		
		
//		driver.get("https://www.amazon.com/");
		driver.get("http://automationpractice.com/index.php");
		
//		driver.get("https://play.decentraland.org/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
//		SCROLLING
		//Way 1: By pressing ctrl+end
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
		//Way 2: By window scrolling
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,500)");
		//Way 3: By window scrolling
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[@role='presentation'] ")));
		
		
//		LIMITING WEBDRIVER SCOPE - 92
		//WebElement footerDriver = driver.findElement(By.xpath("//div[@role='presentation']"));
		//WebElement block = footerDriver.findElement(By.xpath("//div[@role='presentation']/div/div[1]/ul"));
		//int x = block.findElements(By.tagName("li")).size();
		//for(int i=0;i<block.findElements(By.tagName("li")).size();i++) {
		//	String clickonlinktabs = Keys.chord(Keys.CONTROL,Keys.ENTER);
		//	block.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktabs);
		//}
		
//		AFTER SCOPE LIMITING TRAVERSING ALL OPENED WINDOWS - 93
		//Set<String> window = driver.getWindowHandles();
		//Iterator<String> it = window.iterator();
		//while(it.hasNext())
		//{
		//	driver.switchTo().window(it.next());
		//	Thread.sleep(2000);
		//}
		
		
//      HANDLING CALENDAR UI
		//driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
		
		//driver.get("https://www.cleartrip.com/");
		//driver.manage().window().maximize();
		//HANDLING POP UP ON LANDING PAGE
		//WebElement button = driver.findElement(By.xpath("//div[@class='pt-6 pb-6 flex flex-top flex-between']/div[2]"));
		//List<WebElement> list = driver.findElements(By.xpath("//div[@class='pt-6 pb-6 flex flex-top flex-between']/div[2]"));
		//if(list.size()>0) {
		//	button.click();
		//}
		//Thread.sleep(2000);
	    //driver.findElement(By.xpath("//label[@class='radio w-100p radio__secondary'][2]/div/input")).click();
		//driver.findElement(By.xpath("//div[@class='w-100p']/div/div/button[1]")).click();
		
//		HANDLING HTTPS CERTIFICATION
		
		
		
//		Handling broken links
		//String Url = driver.findElement(By.className("asd")).getAttribute("href");
		String Url = "http://automationpractice.com/index.php";
		HttpURLConnection con = (HttpURLConnection)new URL(Url).openConnection();
		con.setRequestMethod("HEAD");
		con.connect();
		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		
//		
		
//		String[] version = driver.findElement(By.xpath("//html[@lang='en-us']")).getAttribute("data-aui-build-date").split("-");
		
//		System.out.println(version[0]);		
		
		driver.quit();
	}
      
}
