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
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Search by Employee name.</b></p>");
		AdminPage adminPage = new AdminPage(childTest);
		adminPage.search();
	}
	
	@Test(priority = 2)
	public void updateFunctionalityCheck() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Update the user.</b></p>");
		AdminPage adminPage = new AdminPage(childTest);
		adminPage.updateUser();
	}
	
	@Test(priority = 3)
	public void deleteFunctionalityCheck() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Delete the user.</b></p>");
		AdminPage adminPage = new AdminPage(childTest);
		adminPage.deleteUser();
	}
	
	@Test(priority = 4)
	public void jobTitleFunctionalityCheck() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Add a job title.</b></p>");
		AdminPage adminPage = new AdminPage(childTest);
		adminPage.jobTitleAddition();
	}
	
	@Test(priority = 5)
	public void traverseToPIMPage() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Traverse to PIM page.</b></p>");
		AdminPage adminPage = new AdminPage(childTest);
		adminPage.traverseToPIM();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
