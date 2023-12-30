package com.automation.ulti;


import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public  class dataGenerator {
	
	public static Object[][] getDataFromExcel() throws IOException{
		FileInputStream file = new FileInputStream("./data/assignment2_data_test.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(file);
		XSSFSheet sheetLogin= workbook.getSheet("Login");
		int numberOfRow = sheetLogin.getPhysicalNumberOfRows();
		Object[][] data = new Object[numberOfRow][2];
		
		for(int i=0;i<numberOfRow;i++) {
			XSSFRow row = sheetLogin.getRow(i);
			XSSFCell email = row.getCell(0);
			XSSFCell pass =row.getCell(1);
			data[i][0]=email.getStringCellValue();
			data[i][1]=pass.getStringCellValue();
			
		}
 		return data;
		
	}

}
