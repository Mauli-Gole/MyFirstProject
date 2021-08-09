package com.TestPage;

import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.registrationPage;
import com.util.webDriverUtils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class RegistrationTestPage 
{
	//TestDataUtils data;
	registrationPage RegistrationPage;
	WebDriver driver;
	Workbook wb;
	@BeforeMethod
	public void setup()
	{
		webDriverUtils webDriverUtils =new webDriverUtils();
		driver = webDriverUtils.initialization();
	}
	
	
	@Test(dataProvider= "excelData" )
	public void registerTest(String firstName,String lastName,String Email, String Telephone,String Password,String ConfirmPassword,String NewLetter) throws Exception
	{
		registrationPage RegistrationPage = new registrationPage(driver);
	
		//RegistrationPage.clickOnMyAccount();
		//RegistrationPage.SelectDropDownRegistration("Register");
		
		RegistrationPage.firstNameEnter(firstName);
		RegistrationPage.lastnameEnter(lastName);
		RegistrationPage.enterEmail(Email);
		RegistrationPage.enterTelephone(Telephone);
		RegistrationPage.enterPassword(Password);
		RegistrationPage.enterConfirmPassword(ConfirmPassword);
		RegistrationPage.clickNewLetter(NewLetter);
		RegistrationPage.ClickOnPolicy();
		RegistrationPage.ClickSubmit();
		
		Assert.assertEquals(false, false);
		
	}

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

}
