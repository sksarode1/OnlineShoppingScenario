package com.shopping.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shopping.qa.base.BrowserUtility;

public class AddNewAddressPage extends BrowserUtility {
	private static final By FIRST_NAME_LOCATOR = By.id("firstname");
	private static final By LAST_NAME_LOCATOR = By.id("lastname");
	private static final By COMPANY_LOCATOR = By.id("company");
	private static final By ADDDRESS1_LOCATOR = By.id("address1");
	private static final By ADDDRESS2_LOCATOR = By.id("address2");
	private static final By CITY_LOCATOR = By.id("city");
	private static final By SELECT_STATE_LOCATOR = By.id("id_state");
	private static final By POSTCODE_LOCATOR = By.id("postcode");
	private static final By SELECT_COUNTRY_LOCATOR = By.id("id_country");
	private static final By PHONE_NUMBER_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_NUMBER_LOCATOR = By.id("phone_mobile");
	private static final By OTHER_LOCATOR = By.id("other");
	private static final By ALIAS_LOCATOR = By.id("alias");
	private static final By SAVE_BUTTON_LOCATOR = By.id("submitAddress");

	public MyAddressesPage addNewAddress(String fname, String lname, String company, String addr1, String addr2,
			String city, String state, String postcode, String country, String phone, String mobile, String other,
			String alies) {
		enterText(FIRST_NAME_LOCATOR, fname);
		enterText(LAST_NAME_LOCATOR, lname);
		enterText(COMPANY_LOCATOR, company);
		enterText(ADDDRESS1_LOCATOR, addr1);
		enterText(ADDDRESS2_LOCATOR, addr2);
		enterText(CITY_LOCATOR, city);
		System.out.println(state);
		selectDropDown(SELECT_STATE_LOCATOR, 3);
		selectDropDown(SELECT_COUNTRY_LOCATOR, country);
		enterText(PHONE_NUMBER_LOCATOR, phone);
		enterText(MOBILE_PHONE_NUMBER_LOCATOR, mobile);
		enterText(OTHER_LOCATOR, other);
		clearTextBox(ALIAS_LOCATOR);
		enterText(ALIAS_LOCATOR, alies);
		enterText(POSTCODE_LOCATOR, postcode);
		clickOnButton(SAVE_BUTTON_LOCATOR);
		return new MyAddressesPage();

	}

}
