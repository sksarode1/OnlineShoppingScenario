package com.shopping.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.shopping.qa.base.BrowserUtility;

public class OrderHistoryPage extends BrowserUtility {
	
	private static final By SIGNOUT_LINK_LOCATOR = By.xpath("//a[@title='Log me out']");

	public void captureScreenshot(String fileName) throws IOException {

		takeScreenshot(fileName);

	}
	
	public void signOut() {
		clickOnButton(SIGNOUT_LINK_LOCATOR);
	}
}
