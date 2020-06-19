package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewConatctPage;
import com.qa.utils.TestUtils;

public class NewContactTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	NewConatctPage newContactPage;

	public NewContactTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		newContactPage = new NewConatctPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnContactLink();

	}

	@Test
	public void verifyContactLabelTest() throws Exception {
		Assert.assertTrue(newContactPage.validateConatctLabel());
		takeScreenShot("contactLabel");
	}

	@DataProvider
	public Object[][] getContactData() {
		Object data[][] = TestUtils.getTestData("Contacts");
		return data;
	}

	@Test(dataProvider = "getContactData")
	public void newContactTest(String Email, String FirstName, String LastName, String StageName, String LeadStatus, String PhoneNumber, String JobTitle) throws Exception {
newContactPage.createContact(Email, FirstName, LastName, StageName, LeadStatus, JobTitle, PhoneNumber);
		takeScreenShot("createContact");
	}

	@AfterMethod
	public void teadDown() {
		driver.quit();
	}

}
