Feature: Search
  Agile Story: As a user, I should be able to search when I am on Google search

  Background: User should be on google search page
    Given User is on the google search page

  Scenario: Google default verification
    Then user should see title is Google


  @wip #work in progress
  Scenario: Google title verification after search
    When User searches apple
    Then User should see apple in the title


  Scenario: Google title verification after search
    When User searches "apple"
    Then User should see "apple" in the title

  @wip
  Scenario: Google About link page title verification
    Then User should see About link
    When user clicks to About link
    Then user should see title  Google - About Google, Our Culture & Company News

      #MAC : OPTION + ENTER = Allows u to generate step definitions
      #WINDOWS: ALT + ENTER = Allows u to generate step definitions

  @b
  Scenario: Google search page footer links verification
    Then user should see six links in the footer
      | Advertising      |
      | Business         |
      | How Search Works |
      | Privacy          |
      | Terms            |
      | Settings         |