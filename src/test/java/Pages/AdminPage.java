package Pages;



import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BaseDrivers.PageDriver;
import Utilities.GetScreenShot;

public class AdminPage extends BasePage{

	ExtentTest test;
	

	public AdminPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	
	//locating a element.
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement addButton;
	
	//add user element
	@FindBy(xpath="(//*[contains(text(), '-- Select --')])[1]")
	WebElement userRoleField;
	
	@FindBy(xpath="//span[contains(text(),'Admin')]")
	WebElement userRoleFieldOption;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement EmployementNameField;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-option']//span[contains(text(),'Jadine  Jackie')]")
	WebElement EmployementNameFieldOption;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]/div[1]")
	WebElement statusField;
	
	@FindBy(xpath="//span[contains(text(),'Enabled')]")
	WebElement statusFieldOptions;
	
	@FindBy(xpath="(//input[@class=\"oxd-input oxd-input--active\"])[2]")
	WebElement userNameField;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement passwordField;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement confirmPasswordField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement addUserSaveButton;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement searchUsername;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchButton;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[6]/div[1]/button[2]")
	WebElement updateButton;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[3]/div[1]/div[6]/div[1]/button[1]")
	WebElement deleteButton;
	
	@FindBy(xpath="//button[normalize-space()='Yes, Delete']")
	WebElement confirmDeleteButton;
	
	int randomInteger = (int) (Math.floor(Math.random() * 1000) + 1);
	public String UserName = "Jone"+randomInteger;
	
	
	@FindBy(xpath = "//span[normalize-space()='Job']")
	WebElement job;
		
	@FindBy(xpath ="//a[normalize-space()='Job Titles']")
	WebElement jobTitle;
		
	@FindBy(xpath = "//button[normalize-space()='Add']") 
	WebElement addJobTitle;
		
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement InputJobTitle;
		
	@FindBy(xpath="//textarea[@placeholder='Type description here']")
	WebElement jobDescriptions;
		
	@FindBy(xpath="//textarea[@placeholder='Add note']")
	WebElement note;
		
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement submitBtn;
	
	
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
	
	// add user
	public void addUser() throws IOException {
		test.info("Click on the Add button");
		try {
			clickOnElement(addButton);
			sleepTime();
			passCaseWithSC("Add user button clicked!!", "addUserPass");
		} catch (Exception e) {
			failCase("add user element is unable to locate.", "AddButtonFail");
		}
		
		test.info("Fill up the add user form");
		
		try {
			if(userRoleField.isDisplayed()) {
				userRoleField.click();
				sleepTime();
				passCaseWithSC("Clicked on the userRoleField.", "userRoleFieldPass");
			}
			try {
				if(userRoleFieldOption.isDisplayed()) {
					userRoleFieldOption.click();
					sleepTime();
					passCaseWithSC("Clicked on the userRoleFieldOption.", "userRoleFieldOptionPass");
				}
			} catch (Exception e) {
				failCase("userRoleFieldOption element is unable to locate.", "userRoleFieldOptionFail");
			}
		} catch (Exception e) {
			failCase("userRoleField element is unable to locate.", "userRoleFieldFail");
		}
		
		try {
			writeOnElement(EmployementNameField, "Jadine  Jackie");
			sleepTime();
			passCaseWithSC("Clicked on the EmployementNameField.", "EmployementNameFieldPass");
			try {
				clickOnElement(EmployementNameFieldOption);
				sleepTime();
				passCaseWithSC("Clicked on the EmployementNameFieldOptions.", "EmployementNameFieldOptionsPass");
			} catch (Exception e) {
				failCase("EmployementNameFieldOptions element is unable to locate.", "EmployementNameFieldOptionsFail");
			}
		} catch (Exception e) {
			failCase("EmployementNameField element is unable to locate.", "EmployementNameFieldFail");
		}
		
		try {
			if(statusField.isDisplayed()) {
				statusField.click();
				sleepTime();
				passCaseWithSC("Clicked on the statusField.", "statusFieldPass");
			}
			try {
				if(statusFieldOptions.isDisplayed()) {
					statusFieldOptions.click();
					sleepTime();
					passCaseWithSC("Clicked on the statusFieldOptions.", "statusFieldOptionsPass");
				}
			} catch (Exception e) {
				failCase("statusFieldOptions element is unable to locate.", "statusFieldOptionsFail");
			}
		} catch (Exception e) {
			failCase("statusField element is unable to locate.", "statusFieldFail");
		}
		
		try {
			writeOnElement(userNameField, UserName);
			sleepTime();
			passCaseWithSC("Clicked on the userNameField.", "userNameFieldPass");
		} catch (Exception e) {
			failCase("userNameField element is unable to locate.", "userNameFieldFail");
		}
		
		try {
			writeOnElement(passwordField, UserName);
			sleepTime();
			passCaseWithSC("Clicked on the passwordField.", "passwordFieldPass");
		} catch (Exception e) {
			failCase("passwordField element is unable to locate.", "passwordFieldFail");
		}
		
		try {
			writeOnElement(confirmPasswordField, UserName);
			sleepTime();
			passCaseWithSC("Clicked on the confirmPasswordField.", "confirmPasswordFieldPass");
		} catch (Exception e) {
			failCase("confirmPasswordField element is unable to locate.", "confirmPasswordFieldFail");
		}
		
		try {
			clickOnElement(addUserSaveButton);
			Thread.sleep(10000);
			passCaseWithSC("Clicked on the addUserSaveButton.", "addUserSaveButtonPass");
			
		} catch (Exception e) {
			failCase("addUserSaveButton element is unable to locate.", "addUserSaveButtonFail");
		}
		
	}
	
	//Search
	public void search() throws IOException {
		System.out.println(UserName);
		test.info("Search an emaploye.");
		try {
			writeOnElement(EmployementNameField, "Jadine  Jackie");
			sleepTime();
			clickOnElement(EmployementNameFieldOption);
			sleepTime();
			passCaseWithSC("Clicked on the username field and entered username.", "searchUsernamePass");
		} catch (Exception e) {
			failCase("searchUsername is unable to locate.", "searchUsernameFail");
		}
	
		try {
			clickOnElement(searchButton);
			sleepTime();
			passCaseWithSC("searchButton is located successfully.", "searchButtonPass");
		} catch (Exception e) {
			failCase("searchButton is unable to locate.", "searchButtonFail");
		}
}

	
	//update
	public void updateUser() throws IOException {
		test.info("Update an user.");
		try {
			clickOnElement(updateButton);
			Thread.sleep(10000);
			passCaseWithSC("Clicked on the updateButton.", "updateButtonPass");
			
			try {
				clickOnElement(addUserSaveButton);
				Thread.sleep(10000);
				passCaseWithSC("Clicked on the save button for update an user.", "addUserSaveButtonPass");
			} catch (Exception e) {
				failCase("Save button is unable to locate.", "addUserSaveButtonPass");
			}
			
		} catch (Exception e) {
			failCase("updateButton element is unable to locate.", "updateButtonFail");
		}
	}

	// delete
	public void deleteUser() throws IOException {
		search();
		test.info("Delete an user.");
		try {
			clickOnElement(deleteButton);
			Thread.sleep(5000);
			passCaseWithSC("Delete button is located successfully.", "deleteButtonPass");
			try {
				clickOnElement(confirmDeleteButton);
				Thread.sleep(10000);
				passCaseWithSC("confirm Delete button is located successfully.", "confirmDeleteButtonPass");
			} catch (Exception e) {
				failCase("Confirm Delete button is unable to locate.", "confirmDeleteButtonFail.");
			}
			
		} catch (Exception e) {
			failCase("Delete button is unable to locate.", "deleteButtonFail.");
		}
	}
	
	//job title
	public void jobTitleAddition() throws IOException {
		try {
			test.info("Click on the Job dropdown");
			if(job.isDisplayed()) {
				job.click();
				sleepTime();
				passCase("Job Element successfully located.");
				
				try {
					test.info("Click on the Job title.");
					if (jobTitle.isDisplayed()) {
							jobTitle.click();
							sleepTime();
							passCase("Clicked on the job title element.");
					}
					
				} catch (Exception e) {
					failCase("JobTitle element unable to locate.", "jobTitleFailCase");
				}	
			}
		} catch (Exception e) {
			failCase("Job element unable to locate.", "jobFailCase");
		}
		
		try {
			test.info("Click on the add button.");
			clickOnElement(addJobTitle);
			sleepTime();
			passCase("Clicked on the Add button");
		} catch (Exception e) {
			failCase("Unable to locate element", "addJobtitleFail");
		}
		
		try {
			test.info("Fill up add job title.");
			writeOnElement(InputJobTitle, UserName);
			sleepTime();
			passCase("Entered Job title");

		} catch (Exception e) {
			failCase("Unable to Add job title field  element", "JobTitlefieldFail");
		}
		
		try {
			test.info("Fillup the Job descriptions.");
			writeOnElement(jobDescriptions, "Managing the Organization.");
			sleepTime();
			passCase("Entered job descriptions.");									
		} 
		catch (Exception e) {
				failCase("jobDescriptions is unable to locate", "jobDescriptionsFail");
			}
		
		try {
			test.info("Click on the Submit button");
			clickOnElement(submitBtn);
			Thread.sleep(10000);
			passCaseWithSC("create a job title", "createJobTitlePass");
				
		} catch (Exception e) {
			failCase("Submit button unable to locate", "submitBtnFail");
			
		}
	}
}
