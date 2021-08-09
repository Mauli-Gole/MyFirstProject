package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	private static final int WAIT = 30;
	WebDriver driver;
	
	BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void WaitTillElementIsClicable(WebElement elem)
	{
		WebDriverWait wait = new WebDriverWait(driver,WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}
	
	public void sendkeys(WebElement elem , String text)
	{
		WaitTillElementIsClicable(elem);
		elem.clear();
		elem.sendKeys(text);
	}
	/**
	 * sendkeys -overloaded methods
	 * use for dynamic webElement by creating BY objct.
	 * By xpath = By.xpath(+"vari"+) rather than using FindBy
	 * @param elem
	 * @param text
	 */
	public void sendkeys(By elem,String text)
	{
		driver.findElement(elem).clear();
		driver.findElement(elem).sendKeys(text);
		
	}
	
	public void SwitchToWindow(String nameOrId)
	{
		driver.switchTo().window(nameOrId);
	}
	/**
	 * SwitchToWindow - overloaded methods
	 * @param windowHandle
	 */
	public void SwitchToWindow(WebElement windowHandle)
	{
		 //driver.switchTo().window(windowHandle);
	}
	public void ClickOnRadiobutton(List<WebElement> elems,String text)
	{
		for(WebElement elem : elems)
		{
			String value = elem.getAttribute("value");
			if(text.equals(value)){
				elem.click();
				break;
			}
	}
	}
	/**
	 * This Click method is normal click
	 * @param elem
	 */
	public void Click(WebElement elem)
	{
		WaitTillElementIsClicable(elem);
		if(elem.isDisplayed())
		{
			elem.click();
		}
		else{
			System.out.println("element is not displayed");
		}
	}
	
	public void Submit(WebElement elem)
	{
		WaitTillElementIsClicable(elem);
		if(elem.isDisplayed())
		{
			elem.submit();
		}
		else{
			System.out.println("element is not displayed");
		}
	}
}
