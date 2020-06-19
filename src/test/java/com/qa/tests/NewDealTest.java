package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewDealPage;
import com.qa.utils.TestUtils;

public class NewDealTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	NewDealPage newDealPage;

	public NewDealTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		newDealPage = new NewDealPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnDealsLink();

	}

	@Test
	public void verifyDealsLabel() throws Exception {
		Assert.assertTrue(newDealPage.validateDealsLabel());
		takeScreenShot("dealLabel");
	}

	@DataProvider
	public Object[][] getDealsData() {
		Object data[][] = TestUtils.getTestData("Deals");
		return data;
	}

	@Test(dataProvider = "getDealsData")
	public void newDealTest(String DealName, String DealAmount, String DealStage, String DealType, String DealCompany, String DealConatct) throws Exception {
		newDealPage.createDeal(DealName, DealAmount, DealStage, DealType, DealCompany, DealConatct);
		takeScreenShot("NewDeal");
	}

	@AfterMethod
	public void teadDown() {
		driver.quit();
	}

}
