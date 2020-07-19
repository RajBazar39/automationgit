Feature: Login User

  Scenario: Login with invalid user
    Given App is installed and launched 
    When User logs in with invalid credentials 
    Then User gets error message

  @RunTag
  Scenario: Login with valid user
    Given App is installed and launched and user logged out
    When User logs in with correct credentials 
    Then User reaches home screen
     
