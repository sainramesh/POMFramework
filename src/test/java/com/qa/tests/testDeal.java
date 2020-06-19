package com.qa.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class testDeal extends BaseClass {
	static String Month = "July 2020";
	static String Day = "19";

	public static WebDriver driver;

	//@Test
	public static void initialization() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.cssSelector("#password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector("#loginBtn")).click();

		driver.findElement(By.cssSelector(".expandable #nav-primary-sales-branch[data-tracking='click hover']"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".expandable.active #nav-secondary-deals")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".add-control button")).click();

		driver.findElement(By.cssSelector(".private-form__control[data-field=dealname]")).sendKeys("test@testg.com");

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

		driver.findElement(By.cssSelector(".private-form__control[data-field=amount]")).sendKeys("aass");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.cssSelector("a[href='/sales-products-settings/7876320/deals']")));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		driver.findElement(By.cssSelector("[data-selenium-test=\"property-input-dealtype\"]")).click();
		List<WebElement> listItem5 = driver.findElements(By.cssSelector(".private-typeahead-result-label"));
		System.out.println("itesms are " + listItem5.size());
		for (WebElement stageList : listItem5) {
			if (stageList.getText().equalsIgnoreCase("New Business")) {
				stageList.click();
				break;
			}

		}

		driver.findElement(By.cssSelector("[data-selenium-test=property-input-dealstage]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}


		List<WebElement> listItem = driver.findElements(By.cssSelector(".private-typeahead-result-label"));
		System.out.println("itesms are " + listItem.size());
		for (WebElement stageList : listItem) {
			if (stageList.getText().equalsIgnoreCase("Qualified to buy")) {
				stageList.click();
				break;
			}

		}

		driver.findElement(By.cssSelector("[data-selenium-test=association-select-COMPANY]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".form-control[aria-autocomplete=\"list\"]")).sendKeys("te");
		List<WebElement> listItem1 = driver
				.findElements(By.cssSelector(".uiTypeaheadResults__item .private-dropdown__item__label"));
		System.out.println("itesms are " + listItem1.size());
		for (WebElement companyList : listItem1) {
			if (companyList.getText().equalsIgnoreCase("ffd9g.com")) {
				companyList.click();
				break;
			}

		}

		driver.findElement(By.cssSelector(".Select-control input")).sendKeys("Khanna");
		List<WebElement> listItem2 = driver
				.findElements(By.cssSelector(".uiTypeaheadResults__item .private-dropdown__item__label"));
		System.out.println("itesms are " + listItem2.size());
		for (WebElement contactList : listItem2) {
			if (contactList.getText().equalsIgnoreCase("Raj Khanna (abcd1@abc.com)")) {
				contactList.click();
				break;
			}

		}

	}

}
