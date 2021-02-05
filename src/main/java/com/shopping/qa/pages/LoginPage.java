package com.shopping.qa.pages;

import org.openqa.selenium.By;

import com.shopping.qa.base.BrowserUtility;

public class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXTBOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");

	public HomePage doLogin(String userName, String password) {
		enterText(EMAIL_TEXTBOX_LOCATOR, userName);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOnButton(SUBMIT_BUTTON_LOCATOR);
		return new HomePage();

	}

}
