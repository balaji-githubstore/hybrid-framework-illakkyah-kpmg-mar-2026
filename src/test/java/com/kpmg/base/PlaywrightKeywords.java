package com.kpmg.base;

import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.WaitForSelectorState;
import java.nio.file.Paths;

public class PlaywrightKeywords {

	private Page page;

	public PlaywrightKeywords(Page page) {
		this.page = page;
	}

	public void clickOnElement(String xpathLocator) {
		page.locator(xpathLocator).click();
	}

	public void clickOnElement(String xpathLocator, ClickOptions options) {
		page.locator(xpathLocator).click(options);
	}

	public void doubleClickOnElement(String xpathLocator) {
		page.locator(xpathLocator).dblclick();
	}

	public void rightClickOnElement(String xpathLocator) {
		page.locator(xpathLocator).click(new ClickOptions().setButton(MouseButton.RIGHT));
	}

	public void hoverOnElement(String xpathLocator) {
		page.locator(xpathLocator).hover();
	}

	public void sendTextToElement(String xpathLocator, String text) {
		page.locator(xpathLocator).fill(text);
	}

	public void clearAndType(String xpathLocator, String text) {
		page.locator(xpathLocator).fill("");
		page.locator(xpathLocator).type(text);
	}

	public void pressKey(String key) {
		page.keyboard().press(key);
	}

	public void pressKeyOnElement(String xpathLocator, String key) {
		page.locator(xpathLocator).press(key);
	}

	public void waitForElementVisible(String xpathLocator) {
		page.waitForSelector(xpathLocator, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
	}

	public void waitForElementHidden(String xpathLocator) {
		page.waitForSelector(xpathLocator, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN));
	}

	public void selectElementByValue(String xpathLocator, String value) {
		page.locator(xpathLocator).selectOption(new SelectOption().setValue(value));
	}

	public void selectElementByLabel(String xpathLocator, String label) {
		page.locator(xpathLocator).selectOption(new SelectOption().setLabel(label));
	}

	public void selectElementByIndex(String xpathLocator, int index) {
		page.locator(xpathLocator).selectOption(new SelectOption().setIndex(index));
	}

	public void checkElement(String xpathLocator) {
		page.locator(xpathLocator).check();
	}

	public void uncheckElement(String xpathLocator) {
		page.locator(xpathLocator).uncheck();
	}

	public boolean isElementChecked(String xpathLocator) {
		return page.locator(xpathLocator).isChecked();
	}

	public boolean isElementVisible(String xpathLocator) {
		return page.locator(xpathLocator).isVisible();
	}

	public String getInnerTextFromElement(String xpathLocator) {
		return page.locator(xpathLocator).innerText();
	}

	public String getTextContentFromElement(String xpathLocator) {
		return page.locator(xpathLocator).textContent();
	}

	public String getAttributeValueFromElement(String xpathLocator, String attributeName) {
		return page.locator(xpathLocator).getAttribute(attributeName);
	}

	public String getTitle() {
		return page.title();
	}

	public String getUrl() {
		return page.url();
	}

	public void navigateToUrl(String url) {
		page.navigate(url);
	}

	public void takeScreenshot(String filePath) {
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(filePath)));
	}

	public void uploadFile(String xpathLocator, String filePath) {
		page.locator(xpathLocator).setInputFiles(Paths.get(filePath));
	}

	public void scrollToElement(String xpathLocator) {
		page.locator(xpathLocator).scrollIntoViewIfNeeded();
	}

	public void scrollBy(int deltaX, int deltaY) {
		page.mouse().wheel(deltaX, deltaY);
	}

	public void waitForLoadState() {
		page.waitForLoadState();
	}

	public void waitForUrl(String url) {
		page.waitForURL(url);
	}

	public void waitForTimeout(double milliseconds) {
		page.waitForTimeout(milliseconds);
	}

	public void focusOnElement(String xpathLocator) {
		page.locator(xpathLocator).focus();
	}

	public int getElementCount(String xpathLocator) {
		return page.locator(xpathLocator).count();
	}

	public String getInputValue(String xpathLocator) {
		return page.locator(xpathLocator).inputValue();
	}

	public boolean isElementEnabled(String xpathLocator) {
		return page.locator(xpathLocator).isEnabled();
	}

	public boolean isElementDisabled(String xpathLocator) {
		return page.locator(xpathLocator).isDisabled();
	}

	public boolean isElementEditable(String xpathLocator) {
		return page.locator(xpathLocator).isEditable();
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