package com.kpmg.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutomationWrapper {
	private Playwright playwright;
	private Browser browser;
	private BrowserContext context;
	protected Page page;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(@Optional("chrome") String browserName) {

		playwright = Playwright.create();

		if (browserName.equalsIgnoreCase("firefox")) {
			browser = playwright.firefox().launch(new LaunchOptions().setHeadless(false).setChannel(browserName));
		} else {
			browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel(browserName));
		}
		context = browser.newContext();
		page = context.newPage();

		page.navigate("http://demo.openemr.io/b/openemr/");
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {
		playwright.close();
	}
}
