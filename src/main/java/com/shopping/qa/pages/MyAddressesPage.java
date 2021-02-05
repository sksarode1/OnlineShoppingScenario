package com.shopping.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.shopping.qa.base.BrowserUtility;

public class MyAddressesPage extends BrowserUtility {
	
	private static final By ADD_NEW_ADDRESS = By.xpath("//a[@title='Add an address']");
	private static final By MENU_WOMEN_LOCATOR = By.linkText("WOMEN");
	private static final By ADDRESS_LOCATOR = By.xpath("//div[@class=\"addresses\"]");

	public AddNewAddressPage addNewAddress() throws InterruptedException {
		clickOnButton(ADD_NEW_ADDRESS);
		return new AddNewAddressPage();
	}
	
	
	public DressCategoryPage goToDressCategoryPage(String category) {
		By summerDressLocator = By.xpath("//a[@title='" + category + "']");
		hoverMouse(MENU_WOMEN_LOCATOR,summerDressLocator);
		return new DressCategoryPage();
	}

	public boolean isAddressPresent(String alias) {
		return findAddress(ADDRESS_LOCATOR,alias);
	}

}
