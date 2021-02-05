package com.shopping.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtility {

	public static String readProperty(String fileName, String key) {
		Properties prop = new Properties();
		String value = null;
		try {
			prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\config\\" + fileName)));
			value = prop.getProperty(key);
			return value;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static String[][] readXLSXFile(String XLSXfileName) {
		// TODO Auto-generated method stub
		File myFile = new File(System.getProperty("user.dir") + "\\testData\\" + XLSXfileName);
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook(myFile);
			XSSFSheet mySheet = myWorkBook.getSheet("contacts");
			int lastRowNumber = mySheet.getLastRowNum();
			XSSFRow myRowHeader = mySheet.getRow(0);
			int lastCol = myRowHeader.getLastCellNum();

			XSSFRow currentRow;
			XSSFCell currentCell;
			String data[][] = new String[lastRowNumber][lastCol]; // 3x3
			for (int row = 1; row <= lastRowNumber; row++) {
				for (int col = 0; col < lastCol; col++) {
					currentRow = mySheet.getRow(row);
					currentCell = currentRow.getCell(col);
					System.out.print(currentCell.toString() + "\t");// \t
					data[row - 1][col] = currentCell.toString();

				}
				System.out.println("");

			}

//			XSSFCell myCell = myRow.getCell);
//			System.out.println(myCell.toString());
			return data;
		}

		catch (IOException e) {
			System.out.println("Cannot read the file");
		}

		catch (InvalidFormatException e) {
			System.out.println("The file type is Wrong!!");
		}
		return null;

	}

}
