@google
Feature: Search item on google

  Background:
    Given user is on google home page

  Scenario: User searches for an item
    When user types "купить кофемашину bork c804" in search box
    And clicks on search button
    Then the found result set should contain more than 10 results
    And "mvideo.ru" should be found among the results