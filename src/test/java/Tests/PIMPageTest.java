package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Pages.PIMPage;
import Utilities.ExtentFactory;

public class PIMPageTest {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void start() throws InterruptedException {

		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>PIM Page</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	
	@Test(priority = 0)
	public void addEmployeFunctionality() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Add an new employee.</b></p>");
		PIMPage pimpage = new PIMPage(childTest);
		pimpage.addEmployee("Md","Eri", "tun3", "2755");
	}
	
	@Test(priority = 1)
	public void employeListFunctionality() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Go to the Employe List Section.</b></p>");
		PIMPage pimpage = new PIMPage(childTest);
		pimpage.ClickOnTheEmployeList();
	}
	
	@Test(priority = 2)
	public void searchByEmployeIdFunctionality() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Search by Employe Name.</b></p>");
		PIMPage pimpage = new PIMPage(childTest);
		pimpage.searchByEmployeName("tun3");
	}
	
	@Test(priority = 3)
	public void DeleteFunctionality() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Delete the employe.</b></p>");
		PIMPage pimpage = new PIMPage(childTest);
		pimpage.deleteEmployee();
	}
	
	@Test(priority = 4)
	public void logOut() throws InterruptedException, IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Logout from the system.</b></p>");
		PIMPage pimpage = new PIMPage(childTest);
		pimpage.logoutFromSystem();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
