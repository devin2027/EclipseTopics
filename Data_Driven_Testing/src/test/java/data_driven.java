import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class data_driven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:\\Users\\dsingh\\eclipse-workspace\\selenium_practice\\Selenium_data_driven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
		
			if(workbook.getSheetName(i).equalsIgnoreCase("datasheet"))	
			{
			XSSFSheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rows = sheet.rowIterator();   //sheet is a collection of rows
			Row firstrow = rows.next();
			Iterator<Cell> ce = firstrow.cellIterator();  //Row is collection of cells
			
			int k=0,column=0;
			while(ce.hasNext()) {
				Cell value = ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("column 3"))
				{
					column = k;
				}
				k++;
			} 
			System.out.println(column);
			
			
			//Now finding a particular row
			while(rows.hasNext()) {
				Row rv = rows.next();
				if(rv.getCell(column).getStringCellValue().equalsIgnoreCase("f")) {
					Iterator<Cell> cv = rv.cellIterator();
					while(cv.hasNext()) {
						System.out.println(cv.next().getStringCellValue());
					}
					
				}
			}
			}
			
		}
	}

}
