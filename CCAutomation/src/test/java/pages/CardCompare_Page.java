package pages;

import java.util.Map;

import org.openqa.selenium.By;

import cucumber.api.DataTable;
import utils.CommonMethods;

public class CardCompare_Page {
	
	public CommonMethods commonmethods;
	
	// declare objects
	By card1_tbl = By.id("card1");
	By card2_tbl = By.id("card2");
	
	public CardCompare_Page(CommonMethods commonmethods) {
		this.commonmethods = commonmethods;
	}
	
	// read card details
	public String readCard(String card) {
		String cardDetails=null;
		
		if(card == "card1") {
			
			cardDetails = commonmethods.readText(card1_tbl);
		}
		
		else if(card == "card2") {
			cardDetails = commonmethods.readText(card2_tbl);
		}
		return cardDetails;
	}
	
	// method to compare the actual card with expected
	public void verifyCardComparisonDetails(DataTable expData, String ActData) {

		Map<String, String> mp = expData.asMap(String.class, String.class);
		
		commonmethods.compareStringContains(mp.get("Card Name"), ActData, "Card Name");
		commonmethods.compareStringContains(mp.get("Best For"), ActData, "Best For");
		commonmethods.compareStringContains(mp.get("Card Type"), ActData, "Card Type");
		commonmethods.compareStringContains(mp.get("Min Income Per Anum"), ActData, "Min Income Per Anum");
		commonmethods.compareStringContains(mp.get("Min Income Per Annum Foreigners"), ActData, "Min Income Per Annum Foreigners");
		commonmethods.compareStringContains(mp.get("Annual Fee Waiver"), ActData, "Annual Fee Waiver");
						
	}
}
