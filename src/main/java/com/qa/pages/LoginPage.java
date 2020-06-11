package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

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
		waitForPresent(signUpLink);
		return driver.getTitle();

	}

	public void login(String un, String pwd) {
		waitForPresent(username);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

	}

	public String signUpValidate() {
		waitForPresent(signUpLink);
		signUpLink.click();
		return driver.getTitle();
	}
}
