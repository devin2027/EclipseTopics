import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class data_driven_practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       FileInputStream fis = new FileInputStream("C:\\Users\\dsingh\\eclipse-workspace\\selenium_practice\\Selenium_data_driven.xlsx");
       XSSFWorkbook workbook = new XSSFWorkbook(fis);
       int sheets = workbook.getNumberOfSheets();
       
       for(int i=0;i<sheets;i++) {
    	   if(workbook.getSheetName(i).equalsIgnoreCase("DataSheet")) {  //Access the desired sheet
    		   XSSFSheet sheet = workbook.getSheetAt(i);               //Access granted for specific sheet
    		   
    		   Iterator<Row> rows = sheet.iterator();                // Sheet is collection of rows
    		   Row firstrow = rows.next();                         //Accessing first row
    		   
    		   Iterator<Cell> ce = firstrow.cellIterator();    //Accessing specific cell
    		   //Cell ce= cell.next();        //Accessing first row
    		   
    		   
    		   int column=0 , k=0;
    		   while(ce.hasNext()) {
    			   Cell value = ce.next();
    			   if(value.getStringCellValue().equalsIgnoreCase("column 1")) {
    				   column = k;
    				   
    				   
    				   // Fetching particular column all cell values
    				   while(rows.hasNext()) {
    					   Row rowvalue = rows.next();
    					   System.out.println(rowvalue.getCell(k));		   
    				   }
    				   
    			   }
    			   k++;
    		   }
    		   
    		   System.out.println("Column number: "+column);
    		   

    		   Iterator<Row> rows1 = sheet.iterator();                // reseting row to 0(my understanding) Sheet is collection of rows
//    		   Row firstrow1 = rows.next();    
    		   // Fetching all cells value of particular row
    		   while(rows1.hasNext()) {
    			   Row rowvalue = rows1.next();
    			   if(rowvalue.getCell(column).getStringCellValue().equalsIgnoreCase("j")) {    //here column value is for to get to that specific cell of row, to get specific cell value
    				  Iterator<Cell> testrow= rowvalue.cellIterator();
    				  while(testrow.hasNext()) {
    					  System.out.println("row:"+testrow.next().getStringCellValue());
    				  }
    			   }
    		   }
    	   }
       }
	}

}
