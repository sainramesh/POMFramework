package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {
	public static WebDriver driver;
	public static String TestDataSheetPath = "/Users/ramesh/eclipse-workspace/POMFramework/"
			+ "src/main/java/com/qa/testData/HubSpot_TestData.xlsx";
	public static Workbook book;
	public static Sheet sheet;


	// String Month = "June 2020";
	// String Day = "30";

//Wait method

	public void waitForPresent(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Excel Reader Method

	public static Object[][] getTestData(String shettName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TestDataSheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {

				e.printStackTrace();
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(shettName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;

	}

	// To press EscapeKey
	 public static void escapeKey() {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE);
	 }

	// To Take screenshots method
	public static void takeScreenShot(String screenShotName) throws Exception {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./ScreenShots/" + screenShotName + ".jpg"));

	}

	// To Take screenshots method for ExtentReport
		public static String takeScreenShotforExtentReporting(WebDriver driver, String screenShotName) throws Exception {
			TakesScreenshot screenShot = (TakesScreenshot) driver;
			File src = screenShot.getScreenshotAs(OutputType.FILE);
			String path= "./ScreenShots/" + screenShotName + ".jpg";
			File dest= new File(path);
			FileUtils.copyFile(src, dest);
			return path;


		}

	// To select value from dropdown

	public void selectFromDropdown(String value) {
		//List<WebElement> listItem = driver.findElements(By.cssSelector(".Select-option"));
		List<WebElement> listItem = driver.findElements(By.cssSelector(".private-typeahead-result-label"));
		for (WebElement stageList : listItem) {
			if (stageList.getText().equalsIgnoreCase(value)) {
				stageList.click();
				break;
			}
		}

	}

	// To select value from SearchDropdown

	public void selectFromSearchDropdown(String value) {
		List<WebElement> searchDropdown = driver
				.findElements(By.cssSelector(".uiTypeaheadResults__item .private-dropdown__item__label"));
		for (WebElement stageList : searchDropdown) {
			if (stageList.getText().equalsIgnoreCase(value)) {
				stageList.click();
				break;
			}
		}

	}

	// For Scroll Down

	public void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	// For Extent Reporting

	/*
	 * public void extentReport() { reporter = new
	 * ExtentHtmlReporter("./Extent Report/cal.html");
	 * reporter.config().setDocumentTitle("Autmation Report");
	 * reporter.config().setReportName("Appium Report");
	 * reporter.config().setTheme(Theme.DARK); extent = new ExtentReports();
	 * extent.attachReporter(reporter); extent.setSystemInfo("HostName",
	 * "LocalHost"); extent.setSystemInfo("OS", "Android");
	 * extent.setSystemInfo("TesterName", "Ramesh"); }
	 */

	// For Calender data Selection

	/*
	 * public void dateSelectFromCalender(String DealMonth, String DealDay) {
	 * driver.findElement(By.cssSelector(
	 * "[data-selenium-test=\"property-input-closedate\"]")).click(); while (true) {
	 * String text = driver.findElement(By.cssSelector(
	 * ".Heading-sc-9dtc71-0.AbstractMonth__Heading-abxtfe-2")) .getText(); if
	 * (text.equalsIgnoreCase(DealMonth)) { break; } else {
	 * driver.findElement(By.cssSelector(".UIIcon__IconContent-sc-1ngbkfp-0.gxNdVV")
	 * ).click(); } } List<WebElement> days =
	 * driver.findElements(By.cssSelector(".Day__Cell-sc-1sul5rl-0:not(.fJaoZG)"));
	 * for (WebElement value : days) { if
	 * (value.getText().equalsIgnoreCase(DealDay)) { value.click(); } } }
	 */
}
