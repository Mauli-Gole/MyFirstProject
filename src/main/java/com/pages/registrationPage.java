package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class registrationPage extends BasePage
{
	WebDriver driver;
	public registrationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a/span[2]")
	private WebElement ClickmyAccount;
	
	@FindBy(xpath="//*[@class='dropdown-menu dropdown-menu-right']/select[1]")
	private WebElement ClickOnRegister;
	
	@FindBy(id="input-firstname")
	private WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	private WebElement txtLastName;
	
	@FindBy(id="input-email")
	private WebElement txtemail;
	
	@FindBy(id="input-telephone")
	private WebElement txtTelephoneNo;
	
	@FindBy(id="input-password")
	private WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	private WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='newsletter']")
	private List<WebElement> rdnNewsLetter;
	
	@FindBy(name="agree")
	private WebElement checkAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement btnContinue;
	
	
	public void clickOnMyAccount()
	{
		ClickmyAccount.click();
	}
	
	public void SelectDropDownRegistration(String text)
	{
		Select dropdown = new Select(ClickOnRegister);
		dropdown.selectByVisibleText(text);
		ClickOnRegister.click();
	}
/**
 * method for enter a first name in text box.
 * @param text : value to be enter in text box
 */
	public void firstNameEnter(String text)
	{
		WaitTillElementIsClicable(txtFirstName);
		txtFirstName.clear();
		txtFirstName.sendKeys(text);
	}
	/**
	 * method for enter a last name in text box.
	 * @param text
	 */
	public void lastnameEnter(String text)
	{
		sendkeys(txtLastName,text);
	}
	/**
	 * method for enter a email  in text box.
	 * @param text
	 */
	public void enterEmail(String text)
	{
		sendkeys(txtemail,text);
	}
	/**
	 * method for enter a TelephoneNumber in text box.
	 * @param text
	 */
	public void enterTelephone(String text)
	{
		sendkeys(txtTelephoneNo,text);
	}
	/**
	 * method for enter a password in text box.
	 * @param text
	 */
	public void enterPassword(String text)
	{
		sendkeys(txtPassword,text);
	}
	/**
	 * method for enter a confirm password in text box.
	 * @param text
	 */
	public void enterConfirmPassword(String text)
	{
		sendkeys(txtConfirmPassword,text);
	}
	/**
	 * method for enter to click on NewLetter in text box.
	 * @param text
	 */
	public void clickNewLetter(String isTrue)
	{
		ClickOnRadiobutton(rdnNewsLetter,"1");
		}
	
	/**
	 * method for click on policy checkbox in text box.
	 * @param text
	 * Click method will call from same class
	 */
	public void ClickOnPolicy()
	{
		Click(checkAgree);
	}
	
	/**
	 * this method is used if click action is not working by 
	 * webelement then we can handle by Action class
	 */
	@Override
	public void Click(WebElement elem)
	{
		Actions action = new Actions(driver);
		action.click(elem).perform();
	}
	/**
	 * method to click on submit button.
	 * @param text
	 */
	public void ClickSubmit()
	{
		 Submit(btnContinue);
	}
	
}
