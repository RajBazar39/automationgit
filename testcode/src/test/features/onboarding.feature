Feature: Onboarding User

  Scenario: Onboard user without survey
    Given App is installed and launched
    When User onboards skipping survey
    Then User reaches home screen

  Scenario: Onboard user with survey
    Given App is installed and launched
    When User onboards completing survey
    Then User reaches home screen



