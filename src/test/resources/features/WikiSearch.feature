@c
Feature: Wiki title and search verifications

  Background: User is on main page
    Given User is on the Wikipedia home page



  Scenario: Search functionality title verification
    When User searches "Steve Jobs"" in the wiki search box
    Then User sees "Steve Jobs" in the wiki title


  Scenario: Search functionality Header verification
    When User searches "Steve Jobs"" in the wiki search box
    Then User sees "Steve Jeobs" is in the main header

  Scenario:  Search functionality Image Header verification
    When User searches "Steve Jobs"" in the wiki search box
    Then  User sees "Steve Jobs" is in the image header

  @wikiScenarioOutline
  Scenario Outline: Search functionality Header verification
    Given User is on the Wikipedia home page
    Then User searches "<searchValue>"" in the wiki search box
    Then User sees "<expectedTitle>" in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header
    Then  User sees "<expectedImageHeader>" is in the image header

    Examples: example test data for wikipedia search
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs          |
      | John Travolta   | John Travolta   | John Travolta      | John Travolta       |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein     |
      | Keanu Reeves    | Keanu Reeves    | Keanu Reeves       | Keanu Reeves        |
      | Bruce Lee       | Bruce Lee       | Bruce Lee          | Bruce Lee           |
      | Dua Lipa        | Dua Lipa        | Dua Lipa           | Dua Lipa            |
      | Thomas Edison   | Thomas Edison   | Thomas Edison      | Thomas Edison       |
      | Sam Heughan     | Sam Heughan     | Sam Heughan        | Sam Heughan         |