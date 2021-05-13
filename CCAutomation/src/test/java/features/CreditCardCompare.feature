
@CC_Compare
Feature: Compare two different credit cards
  I want to select two different credit cards and compare

  @CC_CompareScenario
  Scenario Outline: Scenario to select and compare two different credit cards
    Given The user launch the application <url>
    And I click on the Cards menu
    Then I click on Credit Cards tab
    And I select two Credit cards to compare <card1> and <card2>
    Then Verify the card1 details
   	|	Card Name												|	DBS Black Visa Card				|
    |	Best For												|	Shopping is the new black	|
    |	Card Type												|	Visa											|
    |	Min Income Per Anum							|	S$30,000									|
    |	Min Income Per Annum Foreigners	|	S$45,000									|
    |	Annual Fee Waiver								|	1 Year										|
        
    And Verify the card2 details
    |	Card Name												|	DBS Live Fresh Card																	|
    |	Best For												|	Cashback on your online and Visa contactless spend!	|
    |	Card Type												| Visa																								|
    |	Min Income Per Anum							|	S$30,000																						|
    |	Min Income Per Annum Foreigners	|	S$45,000																						|
    |	Annual Fee Waiver								|	1 year																							|
    
    Examples: 
      | url  																				   	| card1 									 | card2 						     |
      | "https://www.dbs.com.sg/personal/default.page"	| "DBS Black Visa Card"		 | "DBS Live Fresh Card" |
      
