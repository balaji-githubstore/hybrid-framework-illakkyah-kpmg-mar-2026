package com.kpmg.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
/**
 * This class is used to provide data to the test classes.
 */
public class DataSource {
	
	@DataProvider
	public Object[][] validLoginData() {	

		Object[][] data = new Object[2][4];
		
		data[0][0] = "admin";
		data[0][1] = "pass";
		data[0][2] = "18";
		data[0][3] = "Calendar";
		
		data[1][0] = "physician";
		data[1][1] = "physician";
		data[1][2] = "18";
		data[1][3] = "Calendar";

		return data;
	}
	
	@DataProvider
	public Object[][] commonDataProvider(Method mtd) throws IOException
	{
		//current @Test method name that is calling the @DataProvider
		String sheetName=mtd.getName();
		Object[][] data= ExcelUtils.getSheetIntoTwoDimensionalArray("src/test/resources/test-data/opem-emr-data.xlsx", sheetName);
		return data;
	}
	

}
