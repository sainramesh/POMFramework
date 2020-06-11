package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(css = ".private-header__heading")
	WebElement successfulLogin;

	@FindBy(css = ".expandable.active #nav-primary-contacts-branch")
	WebElement contactDropdwon;

	@FindBy(css = ".expandable.active #nav-secondary-contacts")
	WebElement contactLink;

	@FindBy(css = ".expandable.active #nav-primary-sales-branch")
	WebElement dealsDropdwon;

	@FindBy(css = ".expandable.active #nav-secondary-deals")
	WebElement dealsLink;

	@FindBy(css = ".expandable.active #nav-primary-sales-branch")
	WebElement tasksDropdwon;

	@FindBy(css = ".expandable.active #nav-secondary-tasks")
	WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateSuccessfulLogin() {
		System.out.println("sssss");
		return successfulLogin.isDisplayed();

	}

	public void clickOnContactLink() {
		contactDropdwon.click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		contactLink.click();

	}

	public TasksPage clickOnTasksLink() {
		dealsDropdwon.click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dealsLink.click();
		return new TasksPage();
	}

	public DealsPage clickOnDealsLink() {
		tasksDropdwon.click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		tasksLink.click();
		return new DealsPage();
	}

}
