package com.Paylocity.step_definitions;


import com.Paylocity.utilities.ConfigurationReader;
import com.Paylocity.utilities.Driver;
import com.Paylocity.utilities.Screens;
import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {


	
	@Before("@ui")
	public void setUp() {
		// we put a logic that should apply to every scenario
		String URL = ConfigurationReader.get("URL");
		Driver.get().get(URL);
	}
	
	@After("@ui")
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		Screens.closeScreens();
		Driver.closeDriver();
	}
	
	@Before("@api")
	public void setUpApi(){
		RestAssured.baseURI=ConfigurationReader.get("APIURL");
	}
	
	
	
}
