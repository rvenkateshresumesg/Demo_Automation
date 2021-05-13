package pages;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class Home_Page {

	public CommonMethods commonmethods;
	// declare objects
	
	By cards_lnk = By.linkText("Cards");
	
	public Home_Page(CommonMethods commonmethods) {
		this.commonmethods = commonmethods;
	}
	
	public void clickOnCards()
	{
		commonmethods.clickObject(cards_lnk, "Cards");
	}
}
