package com.qa.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class test extends BaseClass {

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

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector(".expandable #nav-primary-contacts-branch[data-tracking='click hover"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".expandable.active #nav-secondary-contacts")).click();
		driver.findElement(By.cssSelector(".add-control button")).click();

		driver.findElement(By.cssSelector(".private-form__control[data-field=email]")).sendKeys("test@testg.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element = driver.findElement(By.cssSelector("a[href='/sales-products-settings/7876320/contacts']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		driver.findElement(By.cssSelector("[data-selenium-test=property-input-hs_lead_status]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> listItem = driver.findElements(By.cssSelector(".Select-option button"));
		System.out.println("itesms are " + listItem.size());
		for (WebElement stageList : listItem) {
			if (stageList.getAttribute("title").equalsIgnoreCase("New")) {
				stageList.click();
			}
			System.out.println(stageList);
		}

	}

}
