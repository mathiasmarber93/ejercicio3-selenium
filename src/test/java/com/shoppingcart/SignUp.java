package com.shoppingcart;

import com.dataprovider.SignUpDataProvider;
import com.pageobjects.EmailAcceptedPage;
import com.pageobjects.MainPage;
import com.pageobjects.SignUpPage;
import com.pageobjects.SignUpSuccessPage;
import com.pageobjects.EmailAcceptedPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends Base{

    private MainPage mainPage;
    private SignUpPage signUpPage;
    private EmailAcceptedPage emailAcceptedPage;
    private SignUpSuccessPage signUpSuccessPage;

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        mainPage = new MainPage(driver);
        emailAcceptedPage = new EmailAcceptedPage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @Test(dataProvider = "email verification", dataProviderClass = SignUpDataProvider.class)
    public void verifyEmail(String email) throws InterruptedException{
        driver.get(mainPage.getUrl());
        mainPage.clickOnSignIn();
        signUpSuccessPage = new SignUpSuccessPage(driver);
        signUpPage.enterEmailAndGoToSignUpSection(email);
        //Thread.sleep(5000);
        Assert.assertTrue(emailAcceptedPage.lblCreateAccountIsDisplayed());
        System.out.println("TEST1 verifyEmail: EMAIL VERIFICADO");
    }

    @Test(dataProvider = "valid data", dataProviderClass = SignUpDataProvider.class, dependsOnMethods = {"verifyEmail"})
    public void testDataRegistration(String firstname, String lastname, String password,
                                     String company, String address, String city,
                                     String postalCode, String phone, String aliasAddress){
        driver.get(signUpPage.getUrl());
        signUpSuccessPage = new SignUpSuccessPage(driver);

        signUpPage.fillSignUpForm(firstname, lastname, password, company, address, city, postalCode, phone, aliasAddress);
        Assert.assertTrue(signUpSuccessPage.lblWelcomeIsDisplayed());
        System.out.println("TEST2 testDataRegistration: FORMULARIO LLENADO CON EXITO");
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}
