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

public class testTask extends BaseClass {
	static String Month = "July 2021";
	static String Day = "21";

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

		driver.findElement(By.cssSelector(".expandable #nav-primary-sales-branch[data-tracking='click hover']"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".expandable.active #nav-secondary-tasks")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("[data-selenium-test=TasksHeaderView__add-task-btn]")).click();

		driver.findElement(By.cssSelector(".private-form__control[data-field=hs_task_subject]")).sendKeys("13");

		driver.findElement(By.cssSelector("[data-selenium-test=\"property-input-hs_task_type\"]")).click();
		List<WebElement> taskType = driver.findElements(By.cssSelector(".private-typeahead-result-label"));
		System.out.println("itesms are " + taskType.size());
		for (WebElement stageList : taskType) {
			if (stageList.getText().equalsIgnoreCase("To-do")) {
				stageList.click();
				break;
			}

		}
		driver.findElement(By.cssSelector("[title=\"None\"]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		driver.findElement(By.cssSelector("[title=\"High\"]")).click();

		driver.findElement(By.cssSelector("[data-selenium-test=\"property-input-hs_queue_membership_ids\"]")).click();
		List<WebElement> queueList = driver.findElements(By.cssSelector(".private-typeahead-result-label"));
		System.out.println("itesms are " + queueList.size());
		for (WebElement stageList : queueList) {
			if (stageList.getText().equalsIgnoreCase("To-do")) {
				stageList.click();
			} else {
				driver.findElement(By.cssSelector("[data-key=\"taskFormsLib.addQueue.addQueueButton\"]")).click();
				driver.findElement(By.cssSelector(".private-modal__container .form-control")).sendKeys("test10");
				driver.findElement(By.cssSelector(".uiButton [data-key=\"taskFormsLib.addQueue.save\"]")).click();
			}
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.cssSelector("[data-key=\"customerDataRte.plugins.tooltips.more\"]")));

		driver.findElement(By.cssSelector(".gUstvr .uiDropdown__buttonContents")).click();
		List<WebElement> dueDateList = driver.findElements(By.cssSelector(".private-typeahead-result-label"));
		System.out.println("itesms are " + dueDateList.size());
		for (WebElement stageList : dueDateList) {
			if (stageList.getText().equalsIgnoreCase("Test")) {
				stageList.click();
			} else if (stageList.getText().equalsIgnoreCase("Custom Date")) {
				stageList.click();

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				driver.findElement(By.cssSelector(".jISQGO [data-format=\"MM/DD/YYYY\"]")).click();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				while (true) {
					String text = driver
							.findElement(By.cssSelector(".cxrywB"))
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
						break;
					}
				}
			}
		}

		driver.findElement(By.cssSelector("[placeholder=\"HH:MM\"]")).click();
		List<WebElement> TimeList = driver.findElements(By.cssSelector(".private-typeahead-result-label"));
		System.out.println("itesms are " + TimeList.size());
		for (WebElement stageList : TimeList) {
			if (stageList.getText().equalsIgnoreCase("11:00 AM")) {
				stageList.click();
				break;
			}
		}

		driver.findElement(By.cssSelector("[data-selenium-test=\"CreateTaskSidebar__save-btn\"]")).click();

	}

}
