package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessPage {

    private final WebDriver driver;

    @FindBy(xpath = "//p[contains(.,'Welcome to your account. Here you can manage all of your personal information and orders.')]")
    private WebElement lblWelcome;

    public LoginSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean lblWelcomeIsDisplayed(){
        return lblWelcome.isDisplayed();
    }

}
