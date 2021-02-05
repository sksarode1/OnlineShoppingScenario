package com.shopping.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.shopping.qa.base.BrowserUtility;

public class DressCategoryPage extends BrowserUtility {
	private static final By PRODUCT_ELEMENTS = By.xpath("//span[text()=\"More\"]/..");

	private static final By LIST_VIEW_LOCATOR = By.xpath("//a[text()=\"List\"]/i");

	private static List<WebElement> prodElements;

	public void changeToListView() {
		clickOnButton(LIST_VIEW_LOCATOR);
	}

	public int totalProducts() {
		prodElements = getAllElements(PRODUCT_ELEMENTS);
		return prodElements.size();

	}

	public ProductDetailsPage selectProduct(int count) {
		try {
			prodElements = getAllElements(PRODUCT_ELEMENTS);
			clickOnButton(prodElements.get(count));
			return new ProductDetailsPage();
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}

		return null;
	}

}
