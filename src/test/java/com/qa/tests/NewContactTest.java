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

	//@Test(priority = 1)
	public void verifyContactLabelTest() {
		Assert.assertTrue(newContactPage.validateConatctLabel());
	}

	@DataProvider
	public Object[][] getContactData() {
		Object data[][] = TestUtils.getTestData("Contacts");
		return data;
	}

	@Test(dataProvider = "getContactData", priority = 2)
	public void newContactTest(String Email, String FirstName, String LastName, String LifeCycleStage) throws Exception {
		newContactPage.createContact(Email, FirstName, LastName, LifeCycleStage);
		takeScreenShot("createContact");
	}

	@AfterMethod
	public void teadDown() {
		driver.quit();
	}

}
