package com.kpmg.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemo2Excel {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("src/test/resources/test-data/opem-emr-data.xlsx"); // new
																										// FileNotFoundException("")

		XSSFWorkbook book = new XSSFWorkbook(file); // open
		XSSFSheet sheet = book.getSheet("validLoginTest");
		DataFormatter format=new DataFormatter();
		
		String value= format.formatCellValue(sheet.getRow(1).getCell(2));
		System.out.println(value);
		
		//1. write logic to print each and every cell value (nested for loop)
		
		
		//2. Create two dimensional array based on number of testcase and then number of cells (parameters)
//		Object[][] data=new Object[3][4];
		
		book.close();
		file.close();

	}

}
