package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BaseDrivers.PageDriver;
import Utilities.GetScreenShot;

public class PIMPage extends BasePage{
	
	ExtentTest test;
	public PIMPage(ExtentTest test) {
		this.test = test;
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}
	
	//locating the element.
	
	@FindBy(xpath="//a[contains(text(),'Add Employee')]")
	WebElement addEmployeButton;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement employeFirstName;
	
	@FindBy(xpath="//input[@placeholder='Middle Name']")
	WebElement employeMiddleName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement employeLastName;
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement employeId;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
	WebElement employeeNameSearch;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]")
	WebElement employeeNameOptionSearch;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchButton;
	
	@FindBy(xpath="//a[normalize-space()='Employee List']")
	WebElement employeeList;
	
	@FindBy(xpath="//div[@class='orangehrm-container']//button[1]")
	WebElement employeDelete;
	
	@FindBy(xpath="//button[normalize-space()='Yes, Delete']")
	WebElement confirmationOfDelete;
	
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	public void addEmployee(String firstName, String MiddleName, String LastName, String employeeId) throws IOException {
		
		test.info("Click on the add employee button");
		try {
			clickOnElement(addEmployeButton);
			sleepTime();
			passCase("Clicked on the Add button");
		} catch (Exception e) {
			failCase("addEmployeButton is unable to locate.", "addEmployeButtonFail");
		}
		
		test.info("Fillup the form");
		try {
			writeOnElement(employeFirstName, firstName);
			sleepTime();
			passCase("Entered the firstName");
		} catch (Exception e) {
			failCase("employeFirstName is unable to locate.", "employeFirstNameFail");
		}
		
		try {
			writeOnElement(employeMiddleName, MiddleName);
			sleepTime();
			passCase("Entered the employeMiddleName");
		} catch (Exception e) {
			failCase("employeMiddleName is unable to locate.", "employeMiddleNameFail");
		}
		
		try {
			writeOnElement(employeLastName, LastName);
			sleepTime();
			passCase("Entered the firstName");
		} catch (Exception e) {
			failCase("employeLastName is unable to locate.", "employeLastNameFail");
		}
		
		try {
			writeOnElement(employeId, employeeId);
			sleepTime();
			passCase("Entered the employeId");
		} catch (Exception e) {
			failCase("employeId is unable to locate.", "employeIdFail");
		}
		
		try {
			clickOnElement(saveButton);
			Thread.sleep(10000);
			passCase("Clicked on the saveButton");
		} catch (Exception e) {
			failCase("saveButton is unable to locate.", "saveButtonFail");
		}
	}
	//empployeeList
	public void ClickOnTheEmployeList() throws IOException {
		try {
			clickOnElement(employeeList);
			Thread.sleep(10000);
			passCase("Clicked on the employeeList");
		} catch (Exception e) {
			failCase("employeeList is unable to locate.", "employeeListFail");
		}
	}
	
	//search
	public void searchByEmployeName(String employeeName) throws IOException {
		test.info("Enter the employee id to search.");
		try {
			writeOnElement(employeeNameSearch, employeeName);
			sleepTime();
			passCase("Entered the Employee name. ");
			
			try {
				clickOnElement(employeeNameOptionSearch);
				sleepTime();
				passCase("Clicked on the employeeNameOptionSearch");
			} catch (Exception e) {
				failCase("employeeNameOptionSearch is unable to locate.", "employeeNameOptionSearchFail");
			}
			
		} catch (Exception e) {
			failCase("employeeidSearch is unable to locate.", "employeeidSearchFail");
		}
		
		try {
			clickOnElement(searchButton);
			Thread.sleep(10000);
			passCase("Clicked on the searchButton");
		} catch (Exception e) {
			failCase("searchButton is unable to locate.", "searchButtonFail");
		}
	}
	
	//delete employee
	public void deleteEmployee() throws IOException {
		test.info("Delete an employee.");
		try {
			clickOnElement(employeDelete);
			sleepTime();
			passCase("Clicked on the employeDelete");
			
			try {
				clickOnElement(confirmationOfDelete);
				Thread.sleep(10000);
				passCaseWithSC("confirm Delete button is located successfully.", "confirmDeleteButtonPass");
			} catch (Exception e) {
				failCase("Confirm Delete button is unable to locate.", "confirmDeleteButtonFail.");
			}
		} catch (Exception e) {
			failCase("employeDelete is unable to locate.", "employeDeleteFail");
		}
	}
	
	@FindBy(xpath="//img[@alt='profile picture']")
	WebElement profilePictureElement;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logOut;
	
	//logout from the system.
	public void logoutFromSystem() throws IOException {
		test.info("Logout from the system");
		try {
			clickOnElement(profilePictureElement);
			Thread.sleep(5000);
			passCaseWithSC("profilePictureElement  is located successfully.", "deleteButtonPass");
			try {
				clickOnElement(logOut);
				Thread.sleep(10000);
				passCaseWithSC("logOut button is located successfully.", "logOutPass");
			} catch (Exception e) {
				failCase("logOut button is unable to locate.", "logOutFail.");
			}
			
		} catch (Exception e) {
			failCase("profilePictureElement is unable to locate.", "profilePictureElementFail.");
		}
		
	}

}
