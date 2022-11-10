package Resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;
	
	public static  ExtentReports getReportObject() {
		
		String dayFolder = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String time = new SimpleDateFormat("hh.mm.ss").format(new Date());
		
		//String dateTime = new DateTime().toString("HH:mm:ss");
	//	String formatTime = time.replace(" ", ":");
		String path = System.getProperty("user.dir")+"\\Reports\\"+ dayFolder + "\\Index " + time +".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Your Logo Test run Result");
		reporter.config().setDocumentTitle("Test Result");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Devinder Singh");
		return extent;
		
	}
	
}
