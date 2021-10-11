package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailAcceptedPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@id='noSlide']/h1")
    private WebElement formRegistration;

    public EmailAcceptedPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean lblCreateAccountIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(formRegistration));
        return formRegistration.isDisplayed();
    }


}
