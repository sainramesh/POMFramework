package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class test extends BaseClass {


	public static WebDriver driver;
@Test
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

		driver.findElement(By.cssSelector(".expandable.active #nav-primary-contacts-branch")).click();
		driver.findElement(By.cssSelector(".expandable.active #nav-secondary-contacts")).click();


	}


}
