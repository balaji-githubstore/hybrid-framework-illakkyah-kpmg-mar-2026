package com.kpmg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kpmg.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper {

	@Test(priority = 1)
	public void titleTest() {
		String actualTitle = page.title();
		Assert.assertEquals(actualTitle, "OpenEMR Login");
	}

	@Test(priority = 2)
	public void headerTest() {
		String actualText = page.locator("xpath=//p[contains(text(),'The most popular')]").innerText();
		Assert.assertTrue(actualText.contains("open-source Electronic Health Record and Medical Practice Management"),
				"Asserting the header: " + actualText); // expect true
	}
}
