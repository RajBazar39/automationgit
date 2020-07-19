Feature: My Page

  Scenario: On My Page adjust base tariff
    Given App is installed and launched and user logged in
    When User on My page screen
    Then User adjust the base tariff as Data "5120" SMS "300" VOICE "300"


  Scenario:  User Choose to Top Up Tariff bundle
    Given App is installed and launched and user logged in
    When User on My page screen
    Then User choose to Top Up Tariff Bundle as Data "200" SMS "500" VOICE "500"




