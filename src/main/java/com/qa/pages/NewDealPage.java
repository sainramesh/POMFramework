package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class NewDealPage extends BaseClass {

	String Month = "June 2020";
	String Day = "30";

	@FindBy(css = ".add-control button")
	WebElement createDealLink;

	@FindBy(css = ".IndexPageRedesignHeader__StyledH1-ljkrr-1 [data-key=\"genericTypes.capitalized.DEAL\"]")
	WebElement delasHeader;

	@FindBy(css = ".private-form__control[data-field=dealname]")
	WebElement dealsName;

	@FindBy(css = ".private-form__control[data-field=amount]")
	WebElement dealsAmount;

	@FindBy(css = "[data-selenium-test=property-input-dealstage]")
	WebElement dealsStage;

	@FindBy(css = "[data-selenium-test=\"property-input-closedate\"]")
	WebElement dealCloseDate;

	@FindBy(css = "[data-selenium-test=\"property-input-dealtype\"]")
	WebElement dealType;

	@FindBy(css = "[data-selenium-test=association-select-COMPANY]")
	WebElement dealCompany;

	@FindBy(css = ".form-control[aria-autocomplete=\"list\"]")
	WebElement dealCompanySearch;

	@FindBy(css = ".Select-control input")
	WebElement dealContact;

	/*
	 * @FindBy(css = ".private-checkbox__dash") WebElement addTimelineChechBox;
	 *
	 * @FindBy(css = ".m-right-1") WebElement dealProductsLink;
	 *
	 * @FindBy(css = ".page .private-close__button") WebElement
	 * dealProductCloseButton;
	 */

	@FindBy(css = ".m-right-1")
	WebElement succfulDealMesssage;

	@FindBy(css = ".p-bottom-1 [data-button-use=primary]")
	WebElement createDealBtn;

	@FindBy(css = "a[href='/sales-products-settings/7876320/deals']")
	WebElement PageLinks;

	public NewDealPage() {
		PageFactory.initElements(driver, this);
	}

	// PageActions
	public boolean validateDealsLabel() {
		waitForPresent(delasHeader);
		return delasHeader.isDisplayed();
	}

	public void createDeal(String name, String amount, String dealStagevalue, String dealTypeValue, String companyName,
			String delasConatctName) throws Exception {
		waitForPresent(createDealLink);
		createDealLink.click();
		waitForPresent(createDealBtn);
		dealsName.sendKeys(name);
		dealsStage.click();
		selectFromSearchDropdown(dealStagevalue);
		Thread.sleep(2000);
		dealCloseDate.click();
		dateSelectFromCalender();
		waitForPresent(dealsAmount);
		dealsAmount.sendKeys(amount);
		scrollDown(PageLinks);
		waitForPresent(dealType);
		dealType.click();
		selectFromSearchDropdown(dealTypeValue);
		waitForPresent(dealCompany);
		dealCompany.click();
		dealCompanySearch.sendKeys("te");
		Thread.sleep(2000);
		selectFromSearchDropdown(companyName);
		dealContact.sendKeys(companyName);
		selectFromSearchDropdown(delasConatctName);
		Thread.sleep(2000);
		createDealBtn.click();
		Thread.sleep(5000);
		waitForPresent(succfulDealMesssage);
	}

	public void dateSelectFromCalender() {
		driver.findElement(By.cssSelector("[data-selenium-test=\"property-input-closedate\"]")).click();
		while (true) {
			String text = driver.findElement(By.cssSelector(".Heading-sc-9dtc71-0.AbstractMonth__Heading-abxtfe-2"))
					.getText();
			if (text.equalsIgnoreCase(Month)) {
				break;
			} else {
				driver.findElement(By.cssSelector(".UIIcon__IconContent-sc-1ngbkfp-0.gxNdVV")).click();
			}
		}
		List<WebElement> days = driver.findElements(By.cssSelector(".Day__Cell-sc-1sul5rl-0:not(.fJaoZG)"));
		for (WebElement value : days) {
			if (value.getText().equalsIgnoreCase(Day)) {
				value.click();
			}
		}
	}
}
