package com.util;

import java.io.File;
import java.io.FileInputStream;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class TestDataUtils  {
	Workbook wb = null;

	@DataProvider(name = "excelData")
	public Object[][] readExceldata() throws Exception {

		// Create an object of File class to open xlsx file
		File file = new File("RegistrationData.xls");
		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(file);
		wb = Workbook.getWorkbook(fis);

		// Read sheet inside the workbook by its name
		Sheet sh = wb.getSheet("Registration");

		int rows = sh.getRows();
		int col = sh.getColumns();
		String data[][] = new String[rows][col];

		// Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rows; i++) {
			// Create a loop to print cell values in a row
			for (int j = 0; j < col; j++) {
				Cell cell = sh.getCell(j, i);
				String value = cell.getContents();
				data[i][j] = value;

			}
		}
		return data;

	}
	/*
	 * public void getData() throws Exception { TestDataUtils data = new
	 * TestDataUtils(); String filePath = Test_Data;
	 * data.readExceldata(Test_Data, "Registrationdata", "Registration");
	 * 
	 * }
	 */

}
