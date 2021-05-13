package pages;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class Cards_Page {
	
	public CommonMethods commonmethods;
	String[] readCardList;
	int[] getCardindex;
	
	
	//declare objects
	By creditCards_lnk = By.linkText("Credit Cards");
	By cardCollection_tbl = By.xpath("//div[@class='container mTop-0']");
	By featured_lnk = By.linkText("Featured");
	By compare_btn = By.id("cardCompareBtn");
	
	
	public Cards_Page(CommonMethods commonmethods) {
		this.commonmethods = commonmethods;
	}
	
	public void clickCreditCards() {
		commonmethods.clickObject(creditCards_lnk, "CreditCards");
	}
	
	public void selectCreditCards(String card1, String card2) {
		
		readCardList = commonmethods.readText(cardCollection_tbl).split("Compare");
		getCardindex = commonmethods.findCards(readCardList, card1, card2);
		
		By card1xpath = By.xpath("//label[@for='cb" + getCardindex[0] + "']//span[1]");
		By card2xpath = By.xpath("//label[@for='cb" + getCardindex[1] + "']//span[1]");
		
		commonmethods.scrollToElement(featured_lnk);
		commonmethods.clickObject(card1xpath, card1);
		commonmethods.clickObject(card2xpath, card2);		
	}
	
	public void clickCompare() {
		commonmethods.clickObject(compare_btn, "Card Compare button");
	}

}
