package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BaseDrivers.PageDriver;
import Utilities.GetScreenShot;

public class LoginPage {
	ExtentTest test;
	

	public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}
	@FindBys({
			@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]"),
			@FindBy(xpath = "//input[@name=\"username\"]") })
	WebElement username;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement password;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement loginButton;
	
	@SuppressWarnings("unused")
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
	
	@SuppressWarnings("unused")
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}

	@SuppressWarnings("static-access")
	public void login(String username_Text, String password_Text) throws InterruptedException, IOException {
//		excelData.ReadExcel();
		try {
			test.info("Please enter username");
			if (username.isDisplayed()) {
				username.sendKeys(username_Text);
				passCase("Username entered");

				try {
					test.info("Enter password");
					if (password.isDisplayed()) {
						password.sendKeys(password_Text);
						passCase("Password send");

						try {
							test.info("Click on the login");
							if (loginButton.isDisplayed()) {
								loginButton.click();
								Thread.sleep(10000);
								passCaseWithSC("Login successfull", "loginPass");
							}
						} catch (Exception e) {
							failCase("Login button was not locateable. Please check the error message",
									"loginbuttonfail");
						}

					}
				} catch (Exception e) {
					failCase("Password was not locateable. Please check the error message", "passwordfail");
				}

			}
		} catch (Exception e) {
			failCase("Username was not locateable. Please check the error message", "usernamefail");
		}

	}

}