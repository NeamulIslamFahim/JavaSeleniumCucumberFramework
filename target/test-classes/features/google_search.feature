Feature: Google Search Functionality

  Scenario: Verify Google Search is working
    Given I am on the Google homepage
    When I search for "Cucumber BDD"
    Then I should see "Cucumber BDD" in the search results
