package com.kpmg.pages;

import com.microsoft.playwright.Page;

/**
 * All menu and reusable methods here
 */
public class MainPage {
	
	private String calendarLocator="xpath=//span[text()='Calendar']";

	private Page page;

	public MainPage(Page page) {
		this.page = page;
	}
	
	public String getCalendarText()
	{
		return page.locator(calendarLocator).innerText();
	}
	
	//clickOnNewSearchMenu()
	//clickOnPatient()
}
