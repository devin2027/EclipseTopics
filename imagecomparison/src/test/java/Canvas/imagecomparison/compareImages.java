package Canvas.imagecomparison;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class compareImages {
	        
	//Ashot
//	        @BeforeTest
//	        public void takeScreenshot() throws InterruptedException, IOException {
//	        	new takeScreenshot();
//	        }
        
//	        @Test
//	        public void imageComaparision() throws IOException
//	        {
//	        	WebDriverManager.chromedriver().setup();
//	        	WebDriver driver = new ChromeDriver();
//	            driver.get("http://demo.automationtesting.in/Register.html");
//	             
//	            WebElement logoImage = driver.findElement(By.cssSelector("#imagetrgt"));
//	             
//	        //    BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") +"\\Reports\\screenshot.png"));
//	          //  Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImage);
//	        //    System.out.println(logoImage);
//	          //  BufferedImage actualImage = logoImageScreenshot.getImage();
//	            
//	               
//	            File screenshotFile = ((TakesScreenshot) logoImage).getScreenshotAs(OutputType.FILE);
//	            String destinationFile = System.getProperty("user.dir")+"\\TCImage\\screenshot1.png";
//				FileUtils.copyFile(screenshotFile, new File(destinationFile));
//				BufferedImage actualImage1 = ImageIO.read(new File(System.getProperty(destinationFile)));
//				
//	            ImageDiffer imgDiff = new ImageDiffer();
//	            ImageDiff diff = imgDiff.makeDiff(actualImage1, ImageIO.read(new File(System.getProperty("user.dir") +"\\Reports\\screenshot.png")));
//	            Assert.assertFalse("Images are Same",diff.hasDiff());
//	                     
//	            driver.quit();
//	        }
	
	WebDriver driver = null;
	
	  @Test
	  public void imageComparisonProcessing() throws IOException, InterruptedException {
		  WebDriverManager.chromedriver().setup();
      	WebDriver driver = new ChromeDriver();
		  driver.get("https://www.inviul.com");
	//	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  //Get WebElement reference of logo
		  WebElement logoElement = driver.findElement(By.xpath("//h1[@id='logo']//a//img"));
		  
		  Thread.sleep(3000);
		  
		  //Capture and store logo image
		  Screenshot shot = new AShot().takeScreenshot(driver, logoElement);
		  File file = new File(System.getProperty("user.dir")+"\\ImageFolder\\logo.png");
		  System.out.println(file);
		  ImageIO.write(shot.getImage(), "PNG", file);
		  
		  
		  //Getting Expected Image
		  BufferedImage expectedImg = ImageIO.read(file);
		  
		  //Getting Actual Image
		  BufferedImage actualImg = shot.getImage();
		  
		  //Image Comparison
		  ImageDiffer imgDiff = new ImageDiffer();
		  ImageDiff dif = imgDiff.makeDiff(expectedImg, actualImg);
		  if(dif.hasDiff()){
			  System.out.println("Both images are different");
		  }else {
			  System.out.println("Both images are same");
		  }
		  
		  driver.close();
		  driver.quit();
	
	  }
	//Shutter bug
}
