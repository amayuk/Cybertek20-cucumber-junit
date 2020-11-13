package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/****************How the hooks class are connected to the future files?
Hooks class must be inside step_definitions package
CukesRunner contains glue="step definitions path"
When we create Hooks class with before,after, CukesRunner looks for it automatically check the glue path*/


public class Hooks {
    @Before(order = 2)
    public void setUpScenario(){
        System.out.println("-----> Before annotation: Setting up browser");
    }

    @Before (value = "@db",order = 3) //Before always run first but we can give them executing order between befores
    public void setUpDatabaseConnection(){
        System.out.println("-----> BEFORE ANNOTATION: DB CONNECTION CREATED <-----");
    }

    @After(order = 1)
    public void tearDownScenario(Scenario scenario){
     //   System.out.println("-----> After annotation: Closing browser");

//        System.out.println("scenario.getName() = " + scenario.getName());
//        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
//        System.out.println("scenario.isFailed() = " + scenario.isFailed());


        if (scenario.isFailed()) {
            //#1 We need to take a screenshot using Selenium
            //getScreenshotAs(): to be able to use this method we casted our driver
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            //#2 We're going to attach it into our report using attach method
            //             1- add screenshot / 2- image type / 3- scenario's name
            scenario.attach(screenshot,"image/png",scenario.getName());

        }//We wanted to get a screenshot if it fails so we put it into if condition



    }

    @After
    public void tearDownDatabaseConnection(){
        System.out.println("-----> AFTER ANNOTATION: DB CONNECTION CLOSED <-----");
    }


}
