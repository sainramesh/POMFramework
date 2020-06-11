package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.ConatctPage;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;

public class HomePageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	ConatctPage contactPage;
	DealsPage dealsPage;
	TasksPage tasksPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactPage = new ConatctPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// @Test(priority = 1)
	public void homePageSuccessfulLoginMessage() {
		Assert.assertTrue(homePage.validateSuccessfulLogin());
	}

	@Test(priority = 2)
	public void verifyConatctLink() {
		homePage.clickOnContactLink();
	}

	// @Test(priority = 3)
	public void verifyDealsLink() {
		dealsPage = homePage.clickOnDealsLink();
	}

	// @Test(priority = 4)
	public void verifyTasksLink() {
		tasksPage = homePage.clickOnTasksLink();
	}

	@AfterMethod
	public void teadDown() {
		driver.quit();
	}

}
