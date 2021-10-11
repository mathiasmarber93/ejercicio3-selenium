package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private final WebDriver driver;
    public final String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement btnSignIn;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl(){
        return url;
    }

    public void signInWithEmailAndPassword(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        btnSignIn.click();
    }

}
