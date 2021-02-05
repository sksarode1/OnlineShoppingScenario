package com.shopping.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shopping.qa.base.BrowserName;
import com.shopping.qa.base.BrowserUtility;
import com.shopping.qa.pages.AddNewAddressPage;
import com.shopping.qa.pages.HomePage;
import com.shopping.qa.pages.LoginPage;
import com.shopping.qa.pages.MyAddressesPage;
import com.shopping.qa.util.TestUtility;

public class MyAddressesPageTest extends BrowserUtility {
	LoginPage loginPage;
	HomePage homePage;
	MyAddressesPage myAddressesPage;
	AddNewAddressPage addNewAddressPage;

	@BeforeTest
	public void setup() throws InterruptedException {

		loginPage = start(BrowserName.CHROME).goToLoginPage();
		homePage = loginPage.doLogin(TestUtility.readProperty("config.properties", "USERNAME"),
				TestUtility.readProperty("config.properties", "PASSWORD"));
		myAddressesPage = homePage.goToMyAddressPage();
		addNewAddressPage = myAddressesPage.addNewAddress();

	}

	@Test(priority = 1, dataProvider = "AddressDataProvider", dataProviderClass = com.shopping.qa.dataprovider.ShoppingDataProvider.class)
	public void addNewAddressTest(String fname, String lname, String company, String addr1, String addr2, String city,
			String state, String postcode, String country, String phone, String mobile, String other, String alies) {
		myAddressesPage = addNewAddressPage.addNewAddress(fname, lname, company, addr1, addr2, city, state, postcode,
				country, phone, mobile, other, alies);
		assertEquals(myAddressesPage.isAddressPresent(alies), true);

	}
	
	@AfterTest
	public void tearDown() {
		closeActiveTab();
	}

}
