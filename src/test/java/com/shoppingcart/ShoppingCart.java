package com.shoppingcart;

import com.dataprovider.RandomQuantityDataProvider;
import com.dataprovider.SignInDataProvider;
import com.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

    public class ShoppingCart extends Base{

    private ShoppingPage shoppingPage;
    private ShoppingWomenCategoryPage shoppingWomenCategoryPage;
    private ShoppingDetailPage shoppingDetailPage;
    private SignInPage signInPage;
    private LoginPage loginPage;
    private LoginSuccessPage loginSuccessPage;
    private ProductAddedSuccesfullyMessage productAddedSuccesfullyMessage;

    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        shoppingPage = new ShoppingPage(driver);
        shoppingWomenCategoryPage = new ShoppingWomenCategoryPage(driver);
        shoppingDetailPage = new ShoppingDetailPage(driver);
        signInPage = new SignInPage(driver);
        loginPage = new LoginPage(driver);
        loginSuccessPage = new LoginSuccessPage(driver);
        productAddedSuccesfullyMessage = new ProductAddedSuccesfullyMessage(driver);
    }

    @Test
    public void testLoginNavigation(){
        driver.get(loginPage.getUrl());
        loginPage.clickOnLogin();
    }

    @Test(dataProvider = "login", dataProviderClass = SignInDataProvider.class, dependsOnMethods = {"testLoginNavigation"})
    public void testLogin(String email, String password){
        driver.get(signInPage.getUrl());
        signInPage.signInWithEmailAndPassword(email, password);
        Assert.assertTrue(loginSuccessPage.lblWelcomeIsDisplayed());
    }

    @Test(dependsOnMethods = {"testLoginNavigation","testLogin"})
    public void testMainShopping(){
        driver.get(shoppingPage.getUrl());
        shoppingPage.clickOnWomenTab();
    }

    @Test(dependsOnMethods = {"testLoginNavigation","testLogin", "testMainShopping"})
    public void testShoppingCategory(){
        driver.get(shoppingWomenCategoryPage.getUrl());
        shoppingWomenCategoryPage.clickOnWomenCardDetail();
    }

    @Test(dataProvider = "randomQuantity", dataProviderClass = RandomQuantityDataProvider.class, dependsOnMethods = {"testLoginNavigation","testLogin", "testMainShopping","testShoppingCategory"})
    public void testShoppingDetail(String quantity) throws InterruptedException{
        driver.get(shoppingDetailPage.getUrl());
        shoppingDetailPage.showProductInformation();
        shoppingDetailPage.setQuantity(quantity);
        shoppingDetailPage.verifyFourDetailImagesAndSize();
        shoppingDetailPage.setLSize();
        shoppingDetailPage.clickOnAddToCart();
        //Thread.sleep(5000);
        Assert.assertTrue(productAddedSuccesfullyMessage.lblProductAddedIsDisplayed());
        productAddedSuccesfullyMessage.showProductAddedInformation();
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
