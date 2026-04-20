package com.kpmg.pages;

import com.kpmg.base.PlaywrightKeywords;
import com.microsoft.playwright.Page;

/**
 * All menu and reusable methods here
 */
public class MainPage extends PlaywrightKeywords {
	
	private String calendarLocator="xpath=//span[text()='Calendar']";

	private Page page;

	public MainPage(Page page) {
		super(page);
		this.page = page;
	}
	
	public String getCalendarText()
	{
		return page.locator(calendarLocator).innerText();
	}
	
	//clickOnNewSearchMenu()
	//clickOnPatient()
}
