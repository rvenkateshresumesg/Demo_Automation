package utils;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class CommonMethods {

	public DriverInstance browser;

	public CommonMethods(DriverInstance browser) {
		this.browser = browser;
	}

	// Launch browser with given url
	public void launchBrowser(String url) {
		browser.driver.get(url);
		Reporter.addStepLog("Launch the browser with given url as :- " + url);
		browser.driver.manage().window().maximize();
	}

	// click on the element
	public void clickObject(By obj, String objName) {

		if (isObjectClickable(obj, 30)) {
			browser.getDriver().findElement(obj).click();
			Reporter.addStepLog("Clicked on element >> " + objName + " using locator >> " + obj.toString());
		} else {
			Reporter.addStepLog("Unable to click on element >> " + objName + " using locator >> " + obj.toString());
		}
	}

	// method to read text
	public String readText(By obj) {
		String readObjectText = null;

		syncWait(5);
		readObjectText = browser.getDriver().findElement(obj).getText();

		return readObjectText;
	}

	// verify object is clickable
	public boolean isObjectClickable(By obj, int sec) {

		int cnt = 0;
		boolean flg = true;
		do
			try {

				WebDriverWait wait = new WebDriverWait(browser.getDriver(), sec);
				WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(obj));
				flg = true;
				break;

			} catch (Exception e) {
				try {
					Thread.sleep(3000);
					cnt++;
					flg = false;
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		while (cnt == sec);

		return flg;

	}

	// method to get the card list
	public int[] findCards(String[] completeCardList, String cardname1, String cardname2) {

		int i = 0;
		int[] card = new int[2];

		for (String string : completeCardList) {
			if (string.contains(cardname1)) {
				card[0] = i;
			}
			if (string.contains(cardname2)) {
				card[1] = i;
			}
			i++;
		}
		return card;
	}

	// sync wait
	public void syncWait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	// scroll to element
	public void scrollToElement(By obj) {

		WebElement element = browser.getDriver().findElement(By.linkText("Featured"));
		((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].scrollIntoView();", element);

	}

	// compare two given strings
	public void compareStringContains(String exp, String act, String title) {
		String[] actDataSplit;
		boolean flgfound = true;
		
		act = act.replaceAll("\r", "");
		actDataSplit = act.split("\n");
		
		for (int i = 0; i < actDataSplit.length; i++) {
			if (actDataSplit[i].trim().toLowerCase().contains(exp.toLowerCase()) && exp.length() == actDataSplit[i].trim().length()) {
				Reporter.addStepLog(
						"Verify data for " + title + " >> " + exp + " matches with >> " + actDataSplit[i].toString());
				flgfound = true;
				break;
			} else {
				flgfound = false;

			}
		}

		if (!flgfound) {
			Reporter.addStepLog("Verify data for " + title + " >> " + exp + " NOT matches with >> " + act);
		}
	}
}
