package stepDefinitions;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.CardCompare_Page;
import pages.Cards_Page;
import pages.Home_Page;
import utils.CommonMethods;

public class CreditCardCompare_SD {

	public CommonMethods commonmethods;
	public Home_Page homepage;
	public Cards_Page cardspage;
	public CardCompare_Page ccpage;
	
	
	public CreditCardCompare_SD(CommonMethods commonmethods, Home_Page homepage, Cards_Page cardspage, CardCompare_Page ccpage) {
		this.commonmethods = commonmethods;
		this.homepage = homepage;
		this.cardspage = cardspage;
		this.ccpage = ccpage;
		
	}

	@Given("^The user launch the application \"([^\"]*)\"$")
	public void the_user_launch_the_application(String arg1) throws Throwable {
		commonmethods.launchBrowser(arg1);
	}

	@Given("^I click on the Cards menu$")
	public void i_click_on_the_Cards_menu() throws Throwable {
		homepage.clickOnCards();
	}

	@Then("^I click on Credit Cards tab$")
	public void i_click_on_Credit_Cards_tab() throws Throwable {
		cardspage.clickCreditCards();
	}

	@Then("^I select two Credit cards to compare \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_select_two_Credit_cards_to_compare(String card1, String card2) throws Throwable {
		cardspage.selectCreditCards(card1, card2);
		cardspage.clickCompare();
	}

	@Then("^Verify the card1 details$")
	public void Verify_the_card1_details(DataTable card1Data) throws Throwable {
		
		ccpage.verifyCardComparisonDetails(card1Data, ccpage.readCard("card1"));
		
	}

	@And("^Verify the card2 details$")
	public void Verify_the_card2_details(DataTable card2Data) throws Throwable {

		ccpage.verifyCardComparisonDetails(card2Data, ccpage.readCard("card2"));
	}

}
