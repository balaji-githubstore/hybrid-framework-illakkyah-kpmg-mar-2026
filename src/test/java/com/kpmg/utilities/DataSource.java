package com.kpmg.utilities;

import org.testng.annotations.DataProvider;
/**
 * This class is used to provide data to the test classes.
 */
public class DataSource {
	
	@DataProvider
	public Object[][] validLoginData() {	

		Object[][] loginDetails = new Object[2][4];
		
		loginDetails[0][0] = "admin";
		loginDetails[0][1] = "pass";
		loginDetails[0][2] = "18";
		loginDetails[0][3] = "Calendar";
		
		loginDetails[1][0] = "physician";
		loginDetails[1][1] = "physician";
		loginDetails[1][2] = "18";
		loginDetails[1][3] = "Calendar";

		return loginDetails;
	}
	
//	@DataProvider
//	public Object[][] invalidLoginData() {	
//
//		Object[][] loginDetails = {
//				{"admin123","admin123","18","Invalid username"},
//				{"physician123","physician123","18","Invalid username"}
//		};
//		return loginDetails;
//	}

}
