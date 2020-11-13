package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class GoogleStepDefinitions {

    //Creating the page object
    GoogleSearchPage googleSearchPage =new GoogleSearchPage();


    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {
        //Gets the driver and goes to google
        Driver.getDriver().get("https://www.google.com");
    }


    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
    //Comparing the titles actual vs expected
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle= "Google";



        Assert.assertEquals("Actual title does not match expected title!",actualTitle,expectedTitle);
    }

    @When("User searches apple")
    public void userSearchesApple() {
        //Sending value into search box using page object
        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);
    }

    @Then("User should see apple in the title")
    public void userShouldSeeAppleInTheTitle() {
        String expectedTitle = "apple - Google Search";
        String actualTitle= Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @When("User searches {string}")
    public void userSearchesApple(String searchValue) {// you can change String value, beside nothing can be changed

        //Sending value into search box using page object
        googleSearchPage.searchBox.sendKeys(searchValue+ Keys.ENTER);
    }

    @Then("User should see {string} in the title")
    public void userShouldSeeAppleInTheTitle(String expectedTitle ) {
        String actualTitle= Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle+" - Google Search");

    }



    @Then("User should see About link")
    public void userShouldSeeAboutLink() {
        //Asserting that about link is displayed
        Assert.assertTrue(googleSearchPage.aboutLink.isDisplayed());
    }

    @When("user clicks to About link")
    public void userClicksToAboutLink() {
        //Clicking to about link
        googleSearchPage.aboutLink.click();
    }

    @Then("user should see title  Google - About Google, Our Culture & Company News")
    public void userShouldSeeTitleGoogleAboutGoogleOurCultureCompanyNews() {

        String expectedTitle= "Google - About Google, Our Culture & Company News";
        String actualTitle= Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Then("user should see six links in the footer")
    public void user_should_see_six_links_in_the_footer(List<String> linkStrings) {

        int expectedSize = linkStrings.size();
        int actualSize = googleSearchPage.footerLinks.size();

        Assert.assertEquals(actualSize,expectedSize);


    }
}
