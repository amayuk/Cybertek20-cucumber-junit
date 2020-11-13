package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(className = "btn btn-lg btn-primary btn-block")
    public WebElement loginButton;

    public void login(String username,String password){
    emailInput.sendKeys(username);
    passwordInput.sendKeys(password);
    loginButton.click();
    }




}
