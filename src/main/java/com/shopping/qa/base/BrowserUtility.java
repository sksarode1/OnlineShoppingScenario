package com.shopping.qa.base;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shopping.qa.pages.LandingPage;
import com.shopping.qa.util.TestUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BrowserUtility {

	private static WebDriver driver;
	private static WebDriverWait wait;

	public void launchBrowser(BrowserName name) {
		if (name == BrowserName.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 30);
		} else if (name == BrowserName.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (name == BrowserName.IE) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.err.print("Invalid Browser Option can Support CHROME or FIREFOX or IE ");
		}

	}

	public void goToPage(String url) {
		try {
			driver.get(url);
		} catch (NullPointerException e) {
			System.err.print("Cannot go to " + url + " (Launch Browser Method needs to be the first method! ");
		}
	}

	public void setScreenSize(Device device) {
		Dimension myDimension = null;
		try {
			if (device == Device.IPAD) {
				myDimension = new Dimension(768, 1024);
				driver.manage().window().setSize(myDimension);
			}

			else if (device == Device.KINDLE) {
				myDimension = new Dimension(540, 720);
				driver.manage().window().setSize(myDimension);
			}

			else if (device == Device.LAPTOP) {
				driver.manage().window().maximize();
			}

			else if (device == Device.IPHONE) {
				myDimension = new Dimension(375, 667);
				driver.manage().window().setSize(myDimension);
			}

			else {
				System.err.println("Invalid Device!! ");
			}
		} catch (NullPointerException e) {
			System.err.print("Cannot set size!! (Launch Browser Method needs to be the first method! ");

		}

	}

	public void closeActiveTab() {
		try {
			driver.close();
		} catch (NullPointerException e) {
			System.err.print("Cannot close the tab (Launch Browser Method needs to be the first method! ");
		}
	}

	public void closeBrowserSession() {
		try {
			driver.quit();
		} catch (NullPointerException e) {
			System.err.print("NO SESSION FOUND!! (Launch Browser Method needs to be the first method! ");
		}
	}

	public void enterText(By elementLocator, String textToEnter) {
		try {
			WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			emailElement.sendKeys(textToEnter);
		}

		catch (NullPointerException e) {
			System.err.print(" (Launch Browser Method needs to be the first method! ");
		}

		catch (NoSuchElementException e) {
			System.err.print("Check your locator Element Not found");

		}
	}

	public void clearTextBox(By elementLocator) {
		try {
			WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			emailElement.clear();
		}

		catch (NullPointerException e) {
			System.err.print(" (Launch Browser Method needs to be the first method! ");
		}

		catch (NoSuchElementException e) {
			System.err.print("Check your locator Element Not found");

		}
	}

	public void clickOnButton(By elementLocator) {
		try {
			WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			emailElement.click();
		}

		catch (NullPointerException e) {
			System.err.print(" (Launch Browser Method needs to be the first method! ");
		}

		catch (NoSuchElementException e) {
			System.err.print("Check your locator Element Not found");

		}
	}

	public void clickOnButton(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}

		catch (NullPointerException e) {
			System.err.print(" (Launch Browser Method needs to be the first method! ");
		}

		catch (NoSuchElementException e) {
			System.err.print("Check your locator Element Not found");

		}
	}

	public void enterTextInForm(By formLocator, By elementLocator, String textToEnter) {
		try {
			WebElement formElement = driver.findElement(formLocator);
			WebElement textElement = formElement.findElement(elementLocator);
			textElement.sendKeys(textToEnter);
		}

		catch (NullPointerException e) {
			System.err.print(" (Launch Browser Method needs to be the first method! ");
		}

		catch (NoSuchElementException e) {
			System.err.print("Check your locator Element Not found");

		}
	}

	public void selectDropDown(By locatorForDropDown, int indexOfValue) {
		try {
			WebElement selectLocatorELement = driver.findElement(locatorForDropDown);
			Select select = new Select(selectLocatorELement);
			select.selectByIndex(indexOfValue);
		}

		catch (NullPointerException e) {
			System.err.print(" (Launch Browser Method needs to be the first method! ");
		}

		catch (NoSuchElementException e) {
			System.err.print("Check your locator Element Not found");

		}

	}

	public void selectDropDown(By locatorForDropDown, String value) {
		try {
			WebElement selectLocatorELement = driver.findElement(locatorForDropDown);
			Select select = new Select(selectLocatorELement);
			select.selectByValue(value);
		}

		catch (NullPointerException e) {
			System.err.print(" (Launch Browser Method needs to be the first method! ");
		}

		catch (NoSuchElementException e) {
			System.err.print("Check your locator Element Not found");

		}

	}

	public void selectDropDown(String text, By locatorForDropDown) {
		try {
			WebElement selectLocatorELement = driver.findElement(locatorForDropDown);
			Select select = new Select(selectLocatorELement);
			select.selectByVisibleText(text);
		}

		catch (NullPointerException e) {
			System.err.print(" (Launch Browser Method needs to be the first method! ");
		}

		catch (NoSuchElementException e) {
			System.err.print("Check your locator Element Not found");

		}

	}

	public void customDropDown(String dropDownName, String value) {
		By titleDropDownLocator = By.xpath("//span[text()='" + dropDownName + "']/..");
		clickOnButton(titleDropDownLocator);
		By titleValueLocator = By.xpath("//span[text()='" + value + "']/..");
		clickOnButton(titleValueLocator);
	}

	public String getTextFrom(By usernameLocator) {
		// TODO Auto-generated method stub
		try {
			WebElement element = driver.findElement(usernameLocator);
			return element.getText();
		}

		catch (NullPointerException e) {
			System.err.print(" (Launch Browser Method needs to be the first method! ");
		}

		return null;

	}

	public void hoverMouse(By locator1, By locator2) {
		//WebElement ele = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul"));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(locator1)).moveToElement(driver.findElement(locator2)).click().perform();
		
	//	action.click();
	//	action.perform();
	}
	public void hoverMouse(By locator1) {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(locator1)).click().perform();
		
	}

	public List<WebElement> getAllElements(By productElements) {
		// TODO Auto-generated method stub
		List<WebElement> allElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productElements));
		return allElements;

	}

	public static void takeScreenshot(String fileName) throws IOException {

		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String data=simple.format(date);
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg",
				new File(System.getProperty("user.dir") + "/Screenshot/" + fileName+"-"+data + ".jpg"));
	}

	public LandingPage start(BrowserName browserName) {
		launchBrowser(browserName);
		goToPage(TestUtility.readProperty("config.properties", "URL"));
		setScreenSize(Device.LAPTOP);
		return new LandingPage();
	}

	public boolean findAddress(By locator, String alias) {
		WebElement elements = wait.until(ExpectedConditions.elementToBeClickable(locator));
		List<WebElement> allElements = elements.findElements(By.tagName("h3"));
		Iterator<WebElement> iterate = allElements.iterator();
		boolean isPresent = false;
		while (iterate.hasNext()) {
			WebElement myElement = iterate.next();
			System.out.println(myElement.getText());
			if (myElement.getText().equalsIgnoreCase(alias)) {
				isPresent = true;
			}
			break;

		}
		return isPresent;

	}
}
