package com.shopping.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shopping.qa.base.BrowserUtility;

public class CheckoutPage extends BrowserUtility {

	private static final By VIEW_MY_CART = By.xpath("//a[@title='View my shopping cart']");
	private static final By CHECKOUT_LOCATOR = By.xpath("//a[@title='Check out']");
	private static final By PROCEEDCHECKOUT_LOCATOR = By.xpath("//p/a[@title=\"Proceed to checkout\"]");
	private static final By CONFIRMPROCEED_CHECKOUTLOCATOR = By.xpath("//button[@name=\"processAddress\"]");
	private static final By FINALPROCEED_CHECKOUTLOCATOR = By.xpath("//button[@name=\"processCarrier\"]");
	private static final By ACCEPTTERM_LOCATOR = By.xpath("//label[@for=\"cgv\"]");
	private static final By PAYMENTBYCHEQUE = By.xpath("//a[@class=\"cheque\"]");
	private static final By CONFIRMORDER_LOCATOR = By.xpath("//p/button[@type=\"submit\"]");
	private static final By CUSTOMERACCOUNT = By.xpath("//a[@class=\"account\"]");	
	
	
	public HomePage continueToShop() {
		hoverMouse(VIEW_MY_CART);
		//clickOnButton(CHECKOUT_LOCATOR);		
		clickOnButton(PROCEEDCHECKOUT_LOCATOR);
		clickOnButton(CONFIRMPROCEED_CHECKOUTLOCATOR);
		clickOnButton(ACCEPTTERM_LOCATOR);
		clickOnButton(FINALPROCEED_CHECKOUTLOCATOR);
		clickOnButton(PAYMENTBYCHEQUE);
		clickOnButton(CONFIRMORDER_LOCATOR);
		clickOnButton(CUSTOMERACCOUNT);
		
		return new HomePage();
	}

}