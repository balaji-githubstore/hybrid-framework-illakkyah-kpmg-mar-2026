package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;
import com.kpmg.pages.LoginPage;
import com.kpmg.pages.MainPage;
import com.kpmg.utilities.DataSource;
import com.microsoft.playwright.options.SelectOption;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * This class test the login functionality.
 */
public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataSource.class)
	public void validLoginTest(String username, String password, String languageValue, String expectedValue) {
		LoginPage login = new LoginPage(page);
		login.enterUsername(username);
		login.enterPassword(password);
		
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue(languageValue));
		page.locator("xpath=//button[@id='login-button']").click();
		
		
		MainPage main=new MainPage(page);
//		assertThat(page.locator("xpath=//span[text()='Calendar']")).hasText(expectedValue);
		Assert.assertEquals(main.getCalendarText(), expectedValue);
	}

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataSource.class)
	public void invalidLoginTest(String username, String password, String languageValue, String expectedError) {
		LoginPage login = new LoginPage(page);
		login.enterUsername(username);
		login.enterPassword(password);
		
		page.locator("xpath=//select[@name='languageChoice']").selectOption(new SelectOption().setValue(languageValue));
		page.locator("xpath=//button[@id='login-button']").click();
		
		String actualError = login.getInvalidErrorMessage();
		Assert.assertTrue(actualError.contains(expectedError),
				"Actual message does not contain expected text. Actual message -" + actualError);
	}
}
