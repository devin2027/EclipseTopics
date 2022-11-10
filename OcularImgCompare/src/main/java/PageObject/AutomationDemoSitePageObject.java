package PageObject;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;

public class AutomationDemoSitePageObject {

	private WebDriver driver;
	private Map<String, String> map;
	
	@FindBy(id = "imagetrgt")
	private WebElement logoImage;
	
	public AutomationDemoSitePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		map = new HashMap<String, String>();
		map.put("logo", "logo.png");
	}
	
	public boolean verifylogoimg() {
		return this.verifyImage(map.get("logo"), logoImage);
	}
	
	private boolean verifyImage(String fileName, WebElement element) {
		Path path = Paths.get(fileName);
		
		OcularResult result = Ocular.snapshot()
				              .from(path)
				              .sample()
				              .using(driver)
				              .element(element)
				              .compare();
		
		return result.isEqualsImages();
	}
}
