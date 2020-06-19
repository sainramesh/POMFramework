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

	@FindBy(css = ".private-form__control[data-field=phone]")
	WebElement contactNumber;

	@FindBy(css = ".private-form__control[data-field=jobtitle]")
	WebElement contactJobTitle;

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

	public void createContact(String emailid, String fn, String ln, String stage, String leadvalue, String title, String phone) throws Exception {
		waitForPresent(createContactLink);
		createContactLink.click();
		waitForPresent(createContactBtn);
		contactEmail.sendKeys(emailid);
		contactFName.sendKeys(fn);
		contactLName.sendKeys(ln);
		contactJobTitle.sendKeys(title);
		contactNumber.sendKeys(phone);
		scrollDown(PageLinks);
		stageDropdownLink.click();
		selectFromDropdown(stage);
		leadStatusDropdownLink.click();
		selectFromDropdown(leadvalue);
		Thread.sleep(2000);
		createContactBtn.click();
		waitForPresent(succfulContactMesssage);

	}



}
