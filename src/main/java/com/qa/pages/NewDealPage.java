package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class NewDealPage extends BaseClass {

	@FindBy(css = ".add-control button")
	WebElement createDealLink;

	@FindBy(css = ".IndexPageRedesignHeader__StyledH1-ljkrr-1 [data-key=\"genericTypes.capitalized.DEAL\"]")
	WebElement delasHeader;

	@FindBy(css = ".private-form__control[data-field=dealname]")
	WebElement dealsName;

	@FindBy(css = ".private-form__control[data-field=amount]")
	WebElement dealsAmount;

	@FindBy(css = "[data-selenium-test=\"property-input-closedate\"]")
	WebElement dealCloseDate;

	@FindBy(css = ".m-right-1")
	WebElement succfulDealMesssage;

	@FindBy(css = ".p-bottom-1 [data-button-use=primary]")
	WebElement createDealBtn;

	@FindBy(css = "a[href='/sales-products-settings/7876320/contacts']")
	WebElement PageLinks;

	public NewDealPage() {
		PageFactory.initElements(driver, this);
	}

	// PageActions
	public boolean validateDealsLabel() {
		waitForPresent(delasHeader);
		return delasHeader.isDisplayed();
	}

	public void createDeal(String name, String amount, String month, String day) throws Exception {
		waitForPresent(createDealLink);
		createDealLink.click();
		waitForPresent(createDealBtn);
		dealsName.sendKeys(name);
		dealCloseDate.click();
		dateSelectFromCalender(month, day);
		dealsAmount.sendKeys(amount);
		scrollDown(PageLinks);
		waitForPresent(PageLinks);
		createDealBtn.click();
	}
}
