Feature: William Hill searching and login validation

  Background: Open browser and go to the webpage
    Given Navigate to webpage

  Scenario Outline: Search for Mayfair Roulette and try to play
    When Click magnifier button and search proper game
    And Hover over game,click more and play button
    Then Validate full login window by <login> and <password> set
    
    Examples:
    |login|password| 
    |user1123|pass11231|
    |user21231|pass2131|
