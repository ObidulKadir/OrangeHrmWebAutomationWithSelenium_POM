package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import BaseDrivers.PageDriver;

public class Admin {

	ExtentTest test;
	

	public Admin(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	//locating a element.
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement addButton;
	
	//add user element
	@FindBy(xpath="(//*[contains(text(), '-- Select --')])[1]")
	WebElement userRoleField;
	
	@FindBy(xpath="//div[contains(text(),'ESS')]")
	WebElement essFieldOption;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']")
	WebElement EmployementNameField;
	
	@FindBy(xpath="(//*[contains(text(), '-- Select --')])[2]")
	WebElement statusField;
	
	@FindBy(xpath="//div[contains(text(),'Enabled')]")
	WebElement enableStatusField;
	
	@FindBy(xpath="(//input[@class=\"oxd-input oxd-input--active\"])[2]")
	WebElement userNameField;
	
	@FindBy(xpath="(//input[@class=\"oxd-input oxd-input--active\"])[3]")
	WebElement passwordField;
	
	@FindBy(xpath="(//input[@class=\"oxd-input oxd-input--active\"])[4]")
	WebElement confirmPasswordField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement addUserSaveButton;
	
	
	
}
