package com.kpmg.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private String usernameLocator = "xpath=//input[@id='authUser']";
	private String passwordLocator = "xpath=//input[@id='clearPass']";
	private String errorLocator = "xpath=//p[contains(text(),'Invalid username')]";

	private Page page;

	public LoginPage(Page page) {
		this.page = page;
	}

	public void enterUsername(String username) {
		page.locator(usernameLocator).fill(username);
	}

	public void enterPassword(String password) {
		page.locator(passwordLocator).fill(password);
	}

	// selectLanguage(String languageValue)

	// clickOnLogin()

	public String getInvalidErrorMessage() {
		return page.locator(errorLocator).innerText();
	}

	public String getUsernamePlaceholder() {
		return page.locator(usernameLocator).getAttribute("placeholder");
	}
}
