@login
Feature: Login feature
  Agile Story(number)Ex;(CBT-25): As user I should be login with correct credentials to different accounts.and
  dashboard should be displayed

  @librarian @employee
  Scenario: Librarian login scenario
    Given User is on the login page
    When User logs in as librarian
    Then User should see dashboard

    @student
  Scenario: Student login scenario
    Given User is on the login page
    When User logs in as student
    Then User should see dashboard

    @admin  @employee
  Scenario: Admin login scenario
    Given User is on the login page
    When User logs in as admin
    Then User should see dashboard
