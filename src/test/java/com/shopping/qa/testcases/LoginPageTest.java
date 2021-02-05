package com.shopping.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shopping.qa.base.BrowserName;
import com.shopping.qa.base.BrowserUtility;
import com.shopping.qa.pages.HomePage;
import com.shopping.qa.pages.LandingPage;
import com.shopping.qa.pages.LoginPage;
import com.shopping.qa.util.TestUtility;

public class LoginPageTest extends BrowserUtility {

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		loginPage = start(BrowserName.CHROME).goToLoginPage();
	}

	@Test(testName = "loginTest", description = "Verifies Login feature")
	public void loginTest() {
		homePage = loginPage.doLogin(TestUtility.readProperty("config.properties", "USERNAME"),
				TestUtility.readProperty("config.properties", "PASSWORD"));
		assertEquals(homePage.getUserName(), "Sagar Sarode");

	}
	
	@AfterTest
	public void tearDown() {
		closeActiveTab();
	}
}
