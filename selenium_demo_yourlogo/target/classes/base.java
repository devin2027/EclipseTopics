package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectReporsitory.HomePageObjects;
import pageObjectReporsitory.SignInObjects;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	SignInObjects signInPage;
	
	public WebDriver initializeBrowserDriver() throws IOException {
		
		
		//Defining Properties object to read data from 'data.propeties' file
		 prop = new Properties();

		String webBrowserData = System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties";
		FileInputStream browserFile = new FileInputStream(webBrowserData);
		
		
		//Reading data from 'data.proporties' file
		prop.load(browserFile);
		String browserData = prop.getProperty("browser");
	//	prop.setProperty("pdfreport.file.name", "ff");
				
		 
		
		//Initializing specific Web Driver to driver
        if(browserData.equalsIgnoreCase("Chrome"))
        {
           //String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
           //System.setProperty("webdriver.chrome.driver", driverPath);
        	WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();
        }
		
        else if(browserData.equalsIgnoreCase("IE"))
        {
        	WebDriverManager.iedriver().setup();
        	driver = new InternetExplorerDriver();
        	
        }
        
        else if(browserData.equalsIgnoreCase("Firefox"))
        {
        	WebDriverManager.firefoxdriver().setup();
        	driver = new  FirefoxDriver();
        }
        
		return driver;
	}
	
	//ScreenShot method
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\Reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
	
	//Repeating steps for scrolling
		public WebElement scrollAndRegisterClick(WebElement element) throws InterruptedException {
			return (WebElement) ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
	//Sign in method
		public void signIn(String email,String password) {
			this.signInPage = new SignInObjects(driver);
			signInPage.email().sendKeys(email);
			signInPage.password().sendKeys(password);
			signInPage.submit().click();
		}
		
//		public void htmltopdf() {
//			try (OutputStream os = new FileOutputStream(System.getProperty("user.dir")+"\\Reports\\indexpdf.pdf")) {
//	            PdfRendererBuilder builder = new PdfRendererBuilder();
//	            builder.useFastMode();
//	            builder.withUri(System.getProperty("user.dir")+"\\Reports\\index.html");
//	            builder.toStream(os);
//	            builder.run();
//	        }
//		}
		//->1
//		public static void generatePDF(String inputHtmlPath, String outputPdfPath)
//		{
//		    try {
//		        String url = new File(inputHtmlPath).toURI().toURL().toString();
//		        System.out.println("URL: " + url);
//
//		        OutputStream out = new FileOutputStream(outputPdfPath);
//
//		        //Flying Saucer part
//		        ITextRenderer renderer = new ITextRenderer();
//
//		        renderer.setDocument(url);
//		        renderer.layout();
//		        renderer.createPDF(out);
//
//		        out.close();
//		    } catch (DocumentException | IOException e) {
//		        // TODO Auto-generated catch block
//		        e.printStackTrace();
//		    }
//		}
	
//	//Performing Actions
//	public Actions performingActions(WebDriver driver2) {
//		Actions actions = new Actions(driver);
//		return actions;
//	}
		
		
}


