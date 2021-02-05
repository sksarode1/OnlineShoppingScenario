package com.shopping.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shopping.qa.base.BrowserName;
import com.shopping.qa.base.BrowserUtility;
import com.shopping.qa.pages.AddNewAddressPage;
import com.shopping.qa.pages.CheckoutPage;
import com.shopping.qa.pages.DressCategoryPage;
import com.shopping.qa.pages.HomePage;
import com.shopping.qa.pages.LoginPage;
import com.shopping.qa.pages.MyAddressesPage;
import com.shopping.qa.pages.OrderHistoryPage;
import com.shopping.qa.pages.ProductDetailsPage;
import com.shopping.qa.util.TestUtility;

public class DressCategoryPageTest extends BrowserUtility {

	private LoginPage loginPage;
	private HomePage homePage;
	private MyAddressesPage myAddressesPage;
	private AddNewAddressPage addNewAddressPage;
	private DressCategoryPage dressCategoryPage;
	private CheckoutPage checkoutPage;
	private OrderHistoryPage orderHistoryPage;
	private int total = 0;
	private int count;

	@BeforeTest
	public void setup() throws InterruptedException {

		loginPage = start(BrowserName.CHROME).goToLoginPage();
		homePage = loginPage.doLogin(TestUtility.readProperty("config.properties", "USERNAME"),
				TestUtility.readProperty("config.properties", "PASSWORD"));
		myAddressesPage = homePage.goToMyAddressPage();
		dressCategoryPage = myAddressesPage.goToDressCategoryPage("Summer Dresses");
	}

	@Test
	public void addProduct() {
		dressCategoryPage.changeToListView();
		total = dressCategoryPage.totalProducts();
		while (count < total) {
			ProductDetailsPage productPage = dressCategoryPage.selectProduct(count);
			productPage.enterQuanity(5);
			productPage.selectSize("L");
			productPage.addToCart();
			productPage.continueToShop();
			count++;
		}
	}

	@Test
	public void checkoutProcess() {
		checkoutPage = new CheckoutPage();
		homePage = checkoutPage.continueToShop();
		
		homePage.goToOrderHistoryPage();
		orderHistoryPage = new OrderHistoryPage();
		try {
			orderHistoryPage.captureScreenshot("temp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		orderHistoryPage.signOut();
	}
	
	@AfterTest
	public void tearDown() {
		closeActiveTab();
	}

}
