package com.cybertek.step_definitions;

import com.cybertek.pages.WikiHomePage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikiStepDefinitions {

    WikiHomePage wikiHomePage = new WikiHomePage();



    @Given("User is on the Wikipedia home page")
    public void user_is_on_the_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }


    @When("User searches {string}\" in the wiki search box")
    public void user_searches_in_the_wiki_search_box(String searchValue) {
        wikiHomePage.searchInput.sendKeys(searchValue+ Keys.ENTER);
    }
    


    @Then("User sees {string} in the wiki title")
    public void userSeesInTheWikiTitle(String seachValue) {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle= seachValue + " - Wikipedia";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    
    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String expectedHeader) {
        String actualHeader= wikiHomePage.imageHeaderAfterSearch.getText();


        Assert.assertTrue(actualHeader.contains(expectedHeader));
    }


    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String searchValue) {
        String actualimageHeader= wikiHomePage.imageHeaderAfterSearch.getText();

        Assert.assertTrue(actualimageHeader.contains(searchValue));
    }
}
