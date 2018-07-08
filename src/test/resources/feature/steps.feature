Feature: William Hill searching and login validation

  Background: Open browser and go to the webpage
    Given Navigate to webpage
    When Customer clicks on magnifier button and search "Mayfair Roulette"
    And Cicks on "More" button followin hover over "Mayfair Roulette" tile
    And Customer clicks on "Play Now"
    Then The customer is directed to Login Window

  Scenario: A William Hill Customer is able to see the LoginWindow containing
  all elements
    Then Customer is able to see logo
    And Customer is able to see "Close" button
    And Customer is able to see "Join now" button
    And Customer is able to see "Username" field
    And Customer is able to see "Password" field
    And Customer is able to see show/hide toogle
    And Customer is able to see "Forgot details?" hyperlink
    And Customer is able to see "Log in" button
    And Customer is able to see "Save username" checkbox
    
    


