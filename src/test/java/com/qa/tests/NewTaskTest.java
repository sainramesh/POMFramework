package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewTaskPage;
import com.qa.utils.TestUtils;

public class NewTaskTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	NewTaskPage newTaskPage;

	public NewTaskTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		newTaskPage = new NewTaskPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnTasksLink();
	}

	@Test
	public void verifyTasksLabel() throws Exception {
		Assert.assertTrue(newTaskPage.validateTasksLabel());
		//takeScreenShot("TaskLabel");
	}

	@DataProvider
	public Object[][] getTasksData() {
		Object data[][] = TestUtils.getTestData("Tasks");
		return data;
	}

	//@Test(dataProvider = "getTasksData")
	public void newTaskTest(String TaskTitle, String TaskType, String TaskAssociateWith, String TaskQueueValue,
			String TaskDateValue, String TaskTimeValue) throws Exception {
		newTaskPage.createTask(TaskTitle, TaskType, TaskAssociateWith, TaskQueueValue, TaskDateValue, TaskTimeValue);
		//takeScreenShot("NewTaskCreated");
	}

	@AfterMethod
	public void teadDown() {
		driver.quit();
	}

}
