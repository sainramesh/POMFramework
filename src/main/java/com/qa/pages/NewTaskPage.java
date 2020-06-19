package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class NewTaskPage extends BaseClass {

	String Month = "June 2021";
	String Day = "25";

	@FindBy(css = "[data-selenium-test=TasksHeaderView__add-task-btn]")
	WebElement createTaskBtn;

	@FindBy(css = ".private-form__control[data-field=hs_task_subject]")
	WebElement taskTitle;

	@FindBy(css = "[data-selenium-test=\"property-input-hs_task_type\"]")
	WebElement taksType;

	@FindBy(css = "[data-selenium-test=\"property-input-hs_task_priority\"]")
	WebElement taskPriorityDropdown;

	@FindBy(css = "[title=\"High\"]")
	WebElement selectHighPriority;

	@FindBy(css = "[data-selenium-test=\"multiple-associations-select\"]")
	WebElement taskAssociateDropdown;

	@FindBy(css = ".form-control[aria-autocomplete=\"list\"]")
	WebElement taskAssociateWithSearch;

	@FindBy(css = "[data-selenium-test=\"property-input-hs_queue_membership_ids\"]")
	WebElement taskQueue;

	@FindBy(css = "[data-key=\"taskFormsLib.addQueue.addQueueButton\"]")
	WebElement createQueueLink;

	@FindBy(css = ".private-modal__container .form-control")
	WebElement newQueueName;

	@FindBy(css = ".uiButton [data-key=\"taskFormsLib.addQueue.save\"]")
	WebElement queueSaveBtn;

	@FindBy(css = "[data-key=\"customerDataRte.plugins.tooltips.more\"]")
	WebElement moreLink;

	@FindBy(css = ".gUstvr .uiDropdown__buttonContents")
	WebElement taskDueDate;

	@FindBy(css = ".jISQGO [data-format=\"MM/DD/YYYY\"]")
	WebElement customDate;

	@FindBy(css = "[placeholder=\"HH:MM\"]")
	WebElement dueDateTime;

	@FindBy(css = "[data-selenium-test=\"CreateTaskSidebar__save-btn\"]")
	WebElement saveBtn;

	@FindBy(css = ".private-header__heading")
	WebElement taskHeader;

	public NewTaskPage() {
		PageFactory.initElements(driver, this);
	}

	// PageActions

	public boolean validateTasksLabel() {
		waitForPresent(taskAssociateWithSearch);
		return taskHeader.isDisplayed();
	}

	public void createTask(String title, String taskType, String associateValue, String queueValue, String dateValue,
			String timeValue) throws Exception {
		waitForPresent(createTaskBtn);
		createTaskBtn.click();
		waitForPresent(taskTitle);
		taskTitle.sendKeys(title);
		taksType.click();
		selectFromDropdown(taskType);
		Thread.sleep(2000);
		taskPriorityDropdown.click();
		waitForPresent(selectHighPriority);
		selectHighPriority.click();
		taskAssociateDropdown.click();
		waitForPresent(taskAssociateWithSearch);
		taskAssociateWithSearch.sendKeys(associateValue);
		selectFromDropdown(associateValue);
		escapeKey();
		taskQueue.click();
		Thread.sleep(2000);
		queueSelect(queueValue);
		Thread.sleep(3000);
		// driver.switchTo().defaultContent();
		scrollDown(moreLink);
		taskDueDate.click();
		selectDueDate(dateValue);
		waitForPresent(dueDateTime);
		dueDateTime.click();
		selectFromDropdown(timeValue);
		Thread.sleep(2000);
		saveBtn.click();
		waitForPresent(taskHeader);

	}

// Queue select Method
	public void queueSelect(String value) throws Exception {
		List<WebElement> queueList = driver.findElements(By.cssSelector(".private-typeahead-result-label"));
		// System.out.println("itesms are " + queueList.size());
		for (WebElement stageList : queueList) {
			if (stageList.getText().equalsIgnoreCase(value)) {
				stageList.click();
				break;
			} /*
				 * else { driver.findElement(By.cssSelector(
				 * "[data-key=\"taskFormsLib.addQueue.addQueueButton\"]")).click();
				 * driver.findElement(By.cssSelector(".private-modal__container .form-control"))
				 * .sendKeys(value); driver.findElement(By.
				 * cssSelector(".uiButton [data-key=\"taskFormsLib.addQueue.save\"]")).click();
				 * Thread.sleep(5000); }
				 */
		}
	}

// DueDate Method
	public void selectDueDate(String dueDate) throws Exception {
		List<WebElement> dueDateList = driver.findElements(By.cssSelector(".private-typeahead-result-label"));
		// System.out.println("itesms are " + dueDateList.size());
		for (WebElement stageList : dueDateList) {
			if (stageList.getText().equalsIgnoreCase(dueDate)) {
				stageList.click();
				break;
			} else if (stageList.getText().equalsIgnoreCase("Custom Date")) {
				stageList.click();

				Thread.sleep(5000);
				customDate.click();

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
	}
}
