package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsyStepDefinitions {

    EtsySearchPage etsySearchPage = new EtsySearchPage();

    @Given("User is on the Etsy home page")
    public void user_is_on_the_etsy_home_page() {
        Driver.getDriver().get("https://www.etsy.com");
    }


    @Then("User should see title is as expected")
    public void user_should_see_title_is_as_expected() {
        String  actualTitle = Driver.getDriver().getTitle();
        String expectedTitle= "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @When("User is searching {string} in the search box")
    public void userIsSearchingInTheSearchBox(String searchValue ) {
    etsySearchPage.searchBox.sendKeys(searchValue);

    }

    @And("User clicks the search button")
    public void userClicksTheSearchButton() {
        etsySearchPage.searchButton.click();
    }

    @Then("User should see {string} in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String searchValue) {
        String actualTitle= Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(searchValue));
    }
}
