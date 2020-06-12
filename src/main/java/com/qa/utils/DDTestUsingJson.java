package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonParser;
import com.qa.base.BaseClass;

public class DDTestUsingJson extends BaseClass {

	@Test
	void setUp() {
		driver.get("");

	}

	@DataProvider(name="DDTestData")

public void readJson() throws FileNotFoundException{

		JsonParser jsonParser= new JsonParser();
		FileReader reader = new FileReader("/Users/ramesh/eclipse-workspace/POMFramework/"
				+ "src/main/java/com/qa/testData/TestData.json");
		Object parsedObj= jsonParser.parse(reader);

		JSONObject jsonObject= (JSONObject) parsedObj;
		String email= (String)jsonObject.get("email");
		String fName= (String)jsonObject.get("fName");
		String lName= (String)jsonObject.get("lName");





}

}
