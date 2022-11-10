package Canvas.Shutterbug_IMG_Comparision;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shutterbug_img_comparision {

	@Test(priority = 0)
	public void takeScreenshot() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();

		// WebElement webelement = driver.findElement(By.cssSelector("#imagetrgt"));
		WebElement webelement = driver.findElement(By.xpath("//input[@ng-model='FirstName']"));

		Shutterbug.shootElement(driver, webelement).withName("Expected")
				.save("C:\\Users\\dsingh\\eclipse-workspace\\Shutterbug_IMG_Comparision\\ExpectedScreenshot");

		Thread.sleep(5000);

		driver.quit();
	}

	@Test(priority = 1)
	public void compareImageFalse() throws IOException, InterruptedException {

		String imageDiffPath = "C:\\Users\\dsingh\\eclipse-workspace\\Shutterbug_IMG_Comparision\\ActualScreenshot";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();

		// WebElement webelement = driver.findElement(By.xpath("//*[text()='Automation
		// Demo Site ']"));
		WebElement webelement = driver.findElement(By.xpath("//*[text()='Confirm Password']"));
		// WebElement webelement = driver.findElement(By.xpath("//*[text()='Full Name*
		// ']"));
		Shutterbug.shootElement(driver, webelement).withName("Actual")
				.save("C:\\Users\\dsingh\\eclipse-workspace\\Shutterbug_IMG_Comparision\\ActualScreenshot");

		File image = new File(
				"C:\\Users\\dsingh\\eclipse-workspace\\Shutterbug_IMG_Comparision\\ExpectedScreenshot\\Expected.png");
		BufferedImage expectedImage = ImageIO.read(image);

		Shutterbug.shootElement(driver, webelement).withName("Actual").equals(expectedImage, 0);
		// boolean result = Shutterbug.shootElement(driver,
		// webelement).withName("Actual").equals(expectedImage);
		// boolean result = Shutterbug.shootElement(driver,
		// webelement).equalsWithDiff(expectedImage, imageDiffPath);
		// boolean result =
		// Shutterbug.shootPage(driver).equalsWithDiff(expectedImage,imageDiffPath);

		// Assert.assertTrue(result);
		// Assert.assertFalse("Not equal", Shutterbug.shootElement(driver,
		// webelement).equalsWithDiff(expectedImage, imageDiffPath));

		Thread.sleep(5000);

		driver.quit();
	}

	@Test(priority = 2)
	public void compareImageTrue() throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();

//		WebElement webelement = driver.findElement(By.cssSelector("#imagetrgt"));
		WebElement webelement = driver.findElement(By.xpath("//input[@ng-model='FirstName']"));

		File image = new File(
				"C:\\Users\\dsingh\\eclipse-workspace\\Shutterbug_IMG_Comparision\\ExpectedScreenshot\\Expected.png");
		BufferedImage expectedImage = ImageIO.read(image);

		// boolean result = Shutterbug.shootElement(driver,
		// webelement).withName("Actual").equals(expectedImage);
		Shutterbug.shootElement(driver, webelement).withName("Actual").equals(expectedImage);

		// Assert.assertTrue(result);
		// Assert.assertTrue("equal", Shutterbug.shootElement(driver,
		// webelement).withName("Actual").equals(expectedImage));

		Thread.sleep(5000);

		driver.quit();
	}

}
