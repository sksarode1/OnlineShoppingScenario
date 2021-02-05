package com.shopping.qa.pages;

import org.openqa.selenium.By;

import com.shopping.qa.base.BrowserUtility;

public class LandingPage extends BrowserUtility {

	private static final By SIGNUP_LOCATOR = By.xpath("//a[@class='login']");

	public LoginPage goToLoginPage() {
		clickOnButton(SIGNUP_LOCATOR);
		return new LoginPage();
	}

}
