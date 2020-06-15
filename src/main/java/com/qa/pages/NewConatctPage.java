package com.qa.pages;

import org.openqa.selenium.Keys;
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

	@FindBy(css = ".private-icon .gtXcdl")
	WebElement succfulContactMesssage;

	@FindBy(css = "#uiabstractdropdown-button-54[data-dropdown-open='false']")
	WebElement lifieCycleStage;

	@FindBy(css="[data-selenium-test='property-input-lifecyclestage']")
	WebElement stageDropdownLink;

	@FindBy(css="[data-selenium-test='property-input-hs_lead_status']")
	WebElement leadStatusDropdownLink;

	@FindBy(css="a[href='/sales-products-settings/7876320/contacts']")
	WebElement PageLinks;

	public NewConatctPage() {
		PageFactory.initElements(driver, this);
	}

	// Page actions

	public boolean validateConatctLabel() {
		waitForPresent(contactsLabel);
		return contactsLabel.isDisplayed();
	}

	public void createContact(String emailid, String fn, String ln, String stage, String leadvalue) throws Exception {
		waitForPresent(createContactLink);
		createContactLink.click();
		waitForPresent(createContactBtn);
		contactEmail.sendKeys(emailid);
		contactFName.sendKeys(fn);
		contactLName.sendKeys(ln);
		scrollDown(PageLinks);
		stageDropdownLink.sendKeys(stage);
		Thread.sleep(2000);
		stageDropdownLink.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		leadStatusDropdownLink.sendKeys(leadvalue);
		Thread.sleep(2000);
		leadStatusDropdownLink.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		createContactBtn.click();
		waitForPresent(succfulContactMesssage);

	}

}
