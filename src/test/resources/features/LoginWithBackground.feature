@LoginWithBackground
Feature: Login feature
  Agile Story(number)Ex;(CBT-25): As user I should be login with correct credentials to different accounts.and
  dashboard should be displayed

  #Background: is used to write repeating setup steps like beforemethod

  Background: Backstory is that user is on the login page
    Given User is on the login page


  Scenario: Librarian login scenario
    When User logs in as librarian
    Then User should see dashboard


  Scenario: Student login scenario
    When User logs in as student
    Then User should see dashboard

  @db
  Scenario: Admin login scenario
    When User logs in as admin
    Then User should see dashboard
