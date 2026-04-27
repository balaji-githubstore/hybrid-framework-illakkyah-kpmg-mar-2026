package com.kpmg.pages;

import com.kpmg.base.PlaywrightKeywords;
import com.microsoft.playwright.Page;

public class AddPatientPage extends PlaywrightKeywords {

	private Page page;

	public AddPatientPage(Page page) {
		super(page);
		this.page = page;
	}

	
	
}
