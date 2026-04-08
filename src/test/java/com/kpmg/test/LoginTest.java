package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.microsoft.playwright.options.SelectOption;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


/**
 * This class test the login functionality. 
 */
public class LoginTest extends AutomationWrapper {
	
//	admin, pass, 18, Calendar
//	accountant,accountant, 18, Calendar

	@Test
	public void validLoginTest(String username,String password,String languageValue,String expectedValue) {
		page.locator("xpath=//input[@id='authUser']").fill("physician");
		page.locator("xpath=//input[@id='clearPass']").fill("physician");
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue("18"));
		page.locator("xpath=//button[@id='login-button']").click();
		assertThat(page.locator("xpath=//span[text()='Calendar']")).hasText("Calendar");	
	}

	@Test
	public void invalidLoginTest() {
		page.locator("xpath=//input[@id='authUser']").fill("admin");
		page.locator("xpath=//input[@id='clearPass']").fill("admin123");
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue("18"));
		page.locator("xpath=//button[@id='login-button']").click();
		String actualError=page.locator("xpath=//p[contains(text(),'Invalid username')]").innerText(); 
		Assert.assertTrue(actualError.contains("Invalid username233"),"Actual message does not contain expected text. Actual message -"+actualError);
	}
}
