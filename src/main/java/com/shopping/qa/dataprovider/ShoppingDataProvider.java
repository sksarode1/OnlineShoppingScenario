package com.shopping.qa.dataprovider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.shopping.qa.util.TestUtility;

public class ShoppingDataProvider {

	@DataProvider(name = "AddressDataProvider")
	public String[][] subDataProvider() throws IOException, InvalidFormatException {
		return TestUtility.readXLSXFile("ShoppingScenarioTestData.xlsx");
	}
}
