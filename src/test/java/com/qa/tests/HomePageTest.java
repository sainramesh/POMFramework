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
		homePage= new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void homePageSuccessfulLoginMessage() {
		Assert.assertTrue(homePage.validateSuccessfulLogin());
		System.out.println("success");
	}

	@Test
	public void verifyConatctLink() {
	//	logger= extent.createTest("verifyConatctLink");
		homePage.clickOnContactLink();
	}

	@Test
	public void verifyDealsLink() throws Exception {
		//logger= extent.createTest("verifyDealsLink");
		homePage.clickOnDealsLink();
	}

	@Test
	public void verifyTasksLink() {
	//	logger= extent.createTest("verifyTasksLink");
		homePage.clickOnTasksLink();
	}

	@AfterMethod
	public void teadDown() {
		driver.quit();
	}

}
