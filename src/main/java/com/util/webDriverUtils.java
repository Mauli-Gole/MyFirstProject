package com.util;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webDriverUtils
{
	
	public static  WebDriver driver;
	/*
	 * WebDriver initialization
	 */
	
	public static WebDriver initialization()
	{
		String Url = PropertyReaders.readProperty("url");
		String browserName = PropertyReaders.readProperty("browser");
		
		if ("chrome".equals(browserName)) {
			System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver.exe");
			driver = new ChromeDriver();
		}
		if ("FireFox".equals(browserName)) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "C:/Program Files/geckodriver.exe");
			driver = new FirefoxDriver();

		
		}
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
		
		}
}
