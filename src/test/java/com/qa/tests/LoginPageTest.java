package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitle() {
		String title = loginPage.validateLoginPageTitle();
		// Assert.assertEquals(title, "");
	}

	@Test(priority = 2)
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 3)
	public void signUp() {
		loginPage.signUpValidate();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
