package com.kpmg.pages;

import com.kpmg.base.PlaywrightKeywords;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class LoginPage extends PlaywrightKeywords {

	private String usernameLocator = "xpath=//input[@id='authUser']";
	private String passwordLocator = "xpath=//input[@id='clearPass']";
	private String errorLocator = "xpath=//p[contains(text(),'Invalid username')]";
	private String languageLocator = "xpath=//select[@name='languageChoice']";
	private String loginLocator = "xpath=//button[@id='login-button']";

	private Page page;

	public LoginPage(Page page) {
		super(page);
		this.page = page;
	}

	public void enterUsername(String username) {
		super.sendTextToElement(usernameLocator, username);
	}

	public void enterPassword(String password) {
		sendTextToElement(passwordLocator, password);
	}

	public void selectLanguage(String langValue) {
		super.selectElementByValue(langValue, langValue);
	}

	public void clickOnLogin() {
		super.clickOnElement(loginLocator);
	}

	public String getInvalidErrorMessage() {
		return super.getInnerTextFromElement(errorLocator);
	}

	public String getUsernamePlaceholder() {
		return super.getAttributeValueFromElement(usernameLocator, "placeholder");
	}
}
