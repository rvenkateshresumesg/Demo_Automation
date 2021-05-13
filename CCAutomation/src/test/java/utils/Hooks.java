package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public DriverInstance browser;
	
	public Hooks(DriverInstance browser) {
		this.browser = browser;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Credit Card Automation");
	}

//	@After
//	public void afterScenario(Scenario scenario) {
//		if (scenario.isFailed()) {
//
//			String screenshotName = scenario.getName().replaceAll(" ", "_");
//			try {
//				File sourcePath = ((TakesScreenshot) browser.getDriver()).getScreenshotAs(OutputType.FILE);
//				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
//						+ screenshotName + ".png");
//				Files.copy(sourcePath, destinationPath);
//				Reporter.addScreenCaptureFromPath(destinationPath.toString());
//			} catch (IOException e) {
//			}
//		}
//	}
	
	@After
	public void closeBrowser()
	{
		browser.getDriver().close();
	}
}
