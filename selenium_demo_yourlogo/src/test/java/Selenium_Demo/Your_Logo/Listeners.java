package Selenium_Demo.Your_Logo;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;
import Resources.base;

public class Listeners extends base implements ITestListener{
   
	ExtentTest test;
	
	static ExtentReports extent = ExtentReporterNG.getReportObject();
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
	
		 test = extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver=null;
		 
	String testMethodName = result.getMethod().getMethodName();
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	} catch (IllegalArgumentException e) {
		
		e.printStackTrace();
	} catch (IllegalAccessException e) {
	
		e.printStackTrace();
	} catch (NoSuchFieldException e) {
		
		e.printStackTrace();
	} catch (SecurityException e) {
		
		e.printStackTrace();
	}
	try {
		
		extentTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName,driver), result.getMethod().getMethodName());
		//        getScreenshot(testMethodName,driver);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//extentTest.get().fail(result.getThrowable());
		extentTest.get().skip(result.getThrowable());
		//WebDriver driver=null;
		
	//	String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
		
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			
			e.printStackTrace();
		} catch (SecurityException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}
