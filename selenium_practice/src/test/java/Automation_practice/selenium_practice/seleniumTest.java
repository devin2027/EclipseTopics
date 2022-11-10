package Automation_practice.selenium_practice;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class seleniumTest {

	
	ExtentReports extent;
	//Creating test report
	@BeforeTest
	public void config() {
		String path = System.getProperty("user.dir")+"\\Report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setReportName("Selenium Automation report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Devin"); //tester info
	}
	
	@Test
	public void seleniumTestCase1() {
		ExtentTest test = extent.createTest("Inital Test");
		System.out.println("seleniumTestCase1 run");
		extent.flush();
	}
	
	
	
	//@Test
	public void seleniumTestCase2() {
		System.out.println("seleniumTestCase2 run");
	}
}
