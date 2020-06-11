package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class NewConatctPage extends BaseClass {

	@FindBy(css = ".add-control button")
	WebElement createContactLink;

	@FindBy(css = ".IndexPageRedesignHeader__StyledH1-ljkrr-1 [data-key=\"genericTypes.capitalized.CONTACT\"]")
	WebElement contactsLabel;

	@FindBy(css = ".private-form__control[data-field=email]")
	WebElement contactEmail;

	@FindBy(css = ".private-form__control[data-field=firstname]")
	WebElement contactFName;

	@FindBy(css = ".private-form__control[data-field=lastname]")
	WebElement contactLName;

	@FindBy(css = ".p-bottom-1 [data-button-use=primary]")
	WebElement createContactBtn;

	@FindBy(css=".private-alert__inner")
	WebElement succfulContactMesssage;

	public NewConatctPage() {
		PageFactory.initElements(driver, this);
	}

	// Page actions

	public boolean validateConatctLabel() {
		waitForPresent(contactsLabel);
		return contactsLabel.isDisplayed();
	}

	public void createContact() {
		waitForPresent(createContactLink);
		createContactLink.click();
		waitForPresent(createContactBtn);
		contactEmail.sendKeys("test2@test.com");
		contactFName.sendKeys("div");
		contactLName.sendKeys("test");
		waitForPresent(createContactBtn);
		createContactBtn.click();
		waitForPresent(succfulContactMesssage);

	}

}
