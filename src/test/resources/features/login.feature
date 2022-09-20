@Buggybank
Feature: Login to the application

  Background: the application is started

  Scenario: a user can login to the application
    When a valid credential is entered
    Then the main screen is shown
    And the application is closed

  Scenario: a user cannot login with invalid credentials
    When an invalid credential is entered
    Then the input fields are cleared
    And the main screen is not shown
