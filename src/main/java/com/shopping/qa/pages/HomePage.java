package com.shopping.qa.pages;

import org.openqa.selenium.By;

import com.shopping.qa.base.BrowserUtility;

public class HomePage extends BrowserUtility {

	private static final By ORDER_HISTORY_LINK_LOCATOR = By.xpath("//a[@title='Orders']");
	private static final By MYCREDIT_SLIPS_LINK_LOCATOR = By.xpath("//a[@title='Credit slips']");
	private static final By MY_ADDRESSES_LINK_LOCATOR = By.xpath("//a[@title='Addresses']");
	private static final By PERSONAL_INFO_LINK_LOCATOR = By.xpath("//a[@title='Credit slips']");
	private static final By MY_WISHLIST_LINK_LOCATOR = By.xpath("//a[@title='Information']");
	private static final By USERNAME_LOCATOR= By.xpath("//a[@class=\"account\"]/span");
	
	
	public MyAddressesPage goToMyAddressPage() {
		clickOnButton(MY_ADDRESSES_LINK_LOCATOR);
		return new MyAddressesPage();
	}

	public OrderHistoryPage goToOrderHistoryPage() {
		clickOnButton(ORDER_HISTORY_LINK_LOCATOR);
		return new OrderHistoryPage();
	}
	
	public String getUserName() {
		return getTextFrom(USERNAME_LOCATOR);
	}

	

}
