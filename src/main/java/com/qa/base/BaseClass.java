package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.utils.TestUtils;

public class BaseClass extends TestUtils {

	public static Properties prop;

	public BaseClass() {
		prop = new Properties();

		try {
			FileInputStream file = new FileInputStream(
					"/Users/ramesh/eclipse-workspace/POMFramework/src/main/java/com/qa/config/config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}

}
