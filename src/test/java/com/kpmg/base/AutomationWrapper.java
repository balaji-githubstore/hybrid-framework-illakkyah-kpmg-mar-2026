package com.kpmg.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

	@BeforeMethod
	public void setup() {

		playwright = Playwright.create();
		browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
		context = browser.newContext();
		page = context.newPage();

		page.navigate("http://demo.openemr.io/b/openemr/");
	}

	@AfterMethod
	public void teardown() {
		playwright.close();
	}
}
