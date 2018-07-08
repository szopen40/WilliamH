Feature: William Hill searching and login validation

  Background: Open browser and go to the webpage
    Given Navigate to webpage
    When The Customer clicks on magnifier button and search for Mayfair Roulette
    And Clicks on More button followin hover over Mayfair Roulette tile
    And The Customer clicks on Play Now
    Then The Customer is directed to Login Window

@tag1
  Scenario: A William Hill Customer is able to see the LoginWindow containing
  all elements
    Then The Customer is able to see logo
    And The Customer is able to see Close button
    And The Customer is able to see Join now button
    And The Customer is able to see Username field
    And The Customer is able to see Password field
    And The Customer is able to see show/hide toogle
    And The Customer is able to see Forgot details? hyperlink
    And The Customer is able to see Log in button
    And The Customer is able to see Save username checkbox
    
    


