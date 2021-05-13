package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
	
	public WebDriver driver;
	
	@Before
	public void startBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
	}

	
	public WebDriver getDriver() {
		return driver;
	}

}
