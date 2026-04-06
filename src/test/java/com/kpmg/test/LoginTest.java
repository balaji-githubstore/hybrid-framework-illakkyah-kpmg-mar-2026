package com.kpmg.test;

import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;

/**
 * This class test the login functionality. 
 */
public class LoginTest extends AutomationWrapper {

	@Test
	public void validLoginTest()
	{
		page.locator("xpath=//input[@id='authUser']").fill("physician");
		//password - physician
		//click on login
		//assert - calendar menu
	}
	
	@Test
	public void invalidLoginTest()
	{
		page.locator("xpath=//input[@id='authUser']").fill("john123");
		//password - physician
		//click on login
		//assert - calendar menu
	}
}
