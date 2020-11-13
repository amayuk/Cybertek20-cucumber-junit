Feature: Etsy seach feature
    Agile story: User should be able to enter search terms and see
    relevant results in the page and in the title.

  Background: User is on the Etsy home page
    Given User is on the Etsy home page

  @etsyWip
  Scenario: Title verification
    Then User should see title is as expected

    #expected : Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  @etsyWip
  Scenario: Title verification after search term
    When User is searching "Wooden spoon" in the search box
    And User clicks the search button
    Then User should see "Wooden spoon" in the Etsy title