package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(css = ".private-header__heading")
	WebElement successfulLogin;

	@FindBy(css = ".expandable #nav-primary-contacts-branch[data-tracking='click hover']")
	WebElement contactDropdwon;

	@FindBy(css = ".expandable.active #nav-secondary-contacts")
	WebElement contactLink;

	@FindBy(css = ".expandable #nav-primary-sales-branch[data-tracking='click hover']")
	WebElement dealsDropdwon;

	@FindBy(css = ".expandable.active #nav-secondary-deals")
	WebElement dealsLink;

	@FindBy(css = ".expandable #nav-primary-sales-branch[data-tracking='click hover']")
	WebElement tasksDropdwon;

	@FindBy(css = ".expandable.active #nav-secondary-tasks")
	WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateSuccessfulLogin() {
		waitForPresent(successfulLogin);
		return successfulLogin.isDisplayed();

	}

	public void clickOnContactLink() {
		waitForPresent(contactDropdwon);
		contactDropdwon.click();
		contactLink.click();

	}

	public void clickOnTasksLink() {
		waitForPresent(dealsDropdwon);
		dealsDropdwon.click();
		dealsLink.click();

	}

	public void clickOnDealsLink() throws Exception {
		waitForPresent(tasksDropdwon);
		tasksDropdwon.click();
		Thread.sleep(2000);
		tasksLink.click();

	}

}
