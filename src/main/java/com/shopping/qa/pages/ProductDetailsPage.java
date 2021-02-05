package com.shopping.qa.pages;

import org.openqa.selenium.By;

import com.shopping.qa.base.BrowserUtility;

public class ProductDetailsPage extends BrowserUtility {

	private static final By QUANTITY_TEXTBOX_LOCATOR = By.id("quantity_wanted");
	private static final By ADD_TO_CART_BUTTON = By.xpath("//span[text()='Add to cart']/..");
	private static final By SELECT_SIZE_LOCATOR = By.id("group_1");
	private static final By CONTINUE_SHOPPING = By.xpath("//span[@title=\"Continue shopping\"]");
	private static final By BREAD_CRUMB_LOCATOR = By.xpath("//*[@class=\"breadcrumb clearfix\"]/a[@title=\"Summer Dresses\"]");

	public void enterQuanity(int quanity) {
		clearTextBox(QUANTITY_TEXTBOX_LOCATOR);
		enterText(QUANTITY_TEXTBOX_LOCATOR, quanity + "");
	}

	public void selectSize(String size) {
		selectDropDown(size, SELECT_SIZE_LOCATOR);
	}

	public void addToCart() {
		clickOnButton(ADD_TO_CART_BUTTON);
	}

	public DressCategoryPage continueToShop() {
		clickOnButton(CONTINUE_SHOPPING);
		clickOnButton(BREAD_CRUMB_LOCATOR);
		return new DressCategoryPage();
	}

}
