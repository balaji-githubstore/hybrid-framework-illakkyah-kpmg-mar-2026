package com.kpmg.base;

import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.Page;

public class PlaywrightKeywords {

	private Page page;

	public PlaywrightKeywords(Page page) {
		this.page = page;
	}

	public void clickOnElement(String xpathLocator) {
		page.locator(xpathLocator).click();
	}

	public void sendTextToElement(String xpathLocator, String text) {
		page.locator(xpathLocator).fill(text);
	}

	public void selectElementByValue(String xpathLocator, String value) {
		page.locator(xpathLocator).selectOption(new SelectOption().setValue(value));
	}

	public String getInnerTextFromElement(String xpathLocator) {
		return page.locator(xpathLocator).innerText();
	}

	public String getAttributeValueFromElement(String xpathLocator, String attributeName) {
		return page.locator(xpathLocator).getAttribute(attributeName);
	}

	public Page SwitchTabUsingTitle(String xpathLocator, String title) throws Exception {

		var newPage = page.waitForPopup(() -> {
			page.locator(xpathLocator).click();
		});

		if (newPage.title().equals(title)) {
			return newPage;
		} else {
			throw new Exception("Title Not Available");
		}

	}
}
