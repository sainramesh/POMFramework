package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;
import com.qa.utils.TestUtils;

public class LoginPage extends BaseClass {

	// PageFatory -OR

	@FindBy(css = "#username")
	WebElement username;

	@FindBy(css = "#password")
	WebElement password;

	@FindBy(css = "#loginBtn")
	WebElement loginBtn;

	@FindBy(css = "a[href='https://app.hubspot.com/signup/crm']")
	WebElement signUpLink;

	// Initialising the PageObjects

	public LoginPage() {
		PageFactory.initElements(driver, this); // this mean current class objects
	}

	// PageActions

	public String validateLoginPageTitle() {
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return driver.getTitle();

	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		loginBtn.click();
		return new HomePage();
	}

	public String signUpValidate() {
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		signUpLink.click();
		return driver.getTitle();
	}
}
