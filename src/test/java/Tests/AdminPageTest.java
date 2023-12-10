package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Pages.AdminPage;
import Pages.DashBoardPage;
import Utilities.ExtentFactory;

public class AdminPageTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {

		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Admin Page</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}

	@Test(priority = 0)
	public void addNewUser() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Add User</b></p>");
		AdminPage adminPage = new AdminPage(childTest);
		adminPage.addUser();
	}
	
	@Test(priority = 1)
	public void searchFunctionalityCheck() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Verify the search funcitonality.</b></p>");
		AdminPage adminPage = new AdminPage(childTest);
		adminPage.search();
	}
	
	@Test(priority = 2)
	public void updateFunctionalityCheck() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Verify the update funcitonality.</b></p>");
		AdminPage adminPage = new AdminPage(childTest);
		adminPage.updateUser();
	}
	@AfterClass
	public void report() {
		report.flush();
	}
}
