@yandex
Feature: Login to yandex mail

  Scenario: User navigates to Yandex mail page
    Given user is on "Yandex home page"
    When user clicks on Mail
    Then system should navigate to new Authorization tab

  Scenario: User logs into Yandex account
    Given user is on authorization page
    When user enters username
    And user clicks on Login button
    When user enters password
    And user clicks on Login button
    Then the system should display the email inbox

