package Automation_practice.selenium_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

public class restassuredTest {
	@Test
	public void restassuredTestCase1() throws FileNotFoundException {
		System.out.println("restassuredTestCase1 run");
		FileInputStream fis = new FileInputStream("C:\\Users\\dsingh\\eclipse-workspace\\selenium_practice\\Selenium_data_driven.xlsx");
		//XSSFWorkbook workbook = new XSSFWorkbook(fis);
	}
	
	@Test
	public void restassuredTestCase2() {
		System.out.println("restassuredTestCase2 run");
	}
}
