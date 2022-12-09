@Buggybank
Feature: Login to the application
  Check the login functionality of the application

  Background: the browser is opened

  Scenario: a user can login to the application
    When a valid credential is entered
    Then the main screen is shown
    And the application is closed

  Scenario: a user cannot login with invalid credentials
    When an invalid credential is entered
    Then the input fields are not cleared
    And the login error message is shown
    And he is logged out of the application
