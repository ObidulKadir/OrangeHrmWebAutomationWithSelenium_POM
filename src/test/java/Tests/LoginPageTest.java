package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseDrivers.BaseDriver;
import BaseDrivers.PageDriver;
import Pages.LoginPage;
import Utilities.ExtentFactory;


public class LoginPageTest extends BaseDriver{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(5000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>ORANGE HRM LOGIN</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test 
	public void loginTestWithValidCredentials() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN with valid credentials.</b></p>");
		LoginPage loginPage = new LoginPage(childTest);
		loginPage.login("Admin", "admin123");
	}
//	@Test
//	public void loginTestWithInValidCredentials() throws InterruptedException, IOException {
//		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>LOGIN with invalid credentials</b></p>");
//		LoginPage loginPage = new LoginPage(childTest);
//		loginPage.login("Admin", "addmin123");
//	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}