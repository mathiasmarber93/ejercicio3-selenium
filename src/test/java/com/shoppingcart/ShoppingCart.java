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
    private ShoppingCartSummaryPage shoppingCartSummaryPage;
    private ShoppingDetail2Page shoppingDetail2Page;
    private ShoppingDetail3Page shoppingDetail3Page;

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
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingDetail2Page = new ShoppingDetail2Page(driver);
        shoppingDetail3Page = new ShoppingDetail3Page(driver);
    }

    @Test
    public void testLoginNavigation(){
        driver.get(loginPage.getUrl());
        loginPage.clickOnLogin();
    }

    @Test(dataProvider = "login",
            dataProviderClass = SignInDataProvider.class,
            dependsOnMethods = {"testLoginNavigation"})
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
    public void testShoppingCategory1(){
        driver.get(shoppingWomenCategoryPage.getUrl());
        shoppingWomenCategoryPage.clickOnWomenCardDetail1();
    }

    @Test(dataProvider = "randomQuantity", dataProviderClass = RandomQuantityDataProvider.class, dependsOnMethods = {"testLoginNavigation","testLogin", "testMainShopping","testShoppingCategory1"})
    public void testShoppingDetail1(String quantity){
        driver.get(shoppingDetailPage.getUrlProduct1());
        shoppingDetailPage.showProductInformation();
        shoppingDetailPage.setQuantity(quantity);
        shoppingDetailPage.verifyFourDetailImagesAndSize();
        shoppingDetailPage.setLSize();
        shoppingDetailPage.clickOnAddToCart();
        //Thread.sleep(5000);
        Assert.assertTrue(productAddedSuccesfullyMessage.lblProductAddedIsDisplayed());
        shoppingDetailPage.clickOnContinueShopping();
        //productAddedSuccesfullyMessage.showProductAddedInformation();
    }

    @Test(dependsOnMethods = {"testLoginNavigation","testLogin", "testMainShopping","testShoppingCategory1", "testShoppingDetail1"})
    public void testShoppingCategory2(){
        driver.get(shoppingWomenCategoryPage.getUrl());
        shoppingWomenCategoryPage.clickOnWomenCardDetail2();
    }

    @Test(dataProvider = "randomQuantity", dataProviderClass = RandomQuantityDataProvider.class, dependsOnMethods = {"testLoginNavigation","testLogin", "testMainShopping","testShoppingCategory1", "testShoppingDetail1", "testShoppingCategory2"})
    public void testShoppingDetail2(String quantity){
        driver.get(shoppingDetail2Page.getUrlProduct6());

        shoppingDetailPage.showProductInformation();
        shoppingDetail2Page.setQuantity(quantity);
        shoppingDetailPage.verifyFourDetailImagesAndSize();
        shoppingDetailPage.setLSize();
        shoppingDetailPage.clickOnAddToCart();
        //Thread.sleep(5000);
        Assert.assertTrue(productAddedSuccesfullyMessage.lblProductAddedIsDisplayed());
        shoppingDetailPage.clickOnContinueShopping();
        //productAddedSuccesfullyMessage.showProductAddedInformation();
    }

    @Test(dependsOnMethods = {"testLoginNavigation","testLogin", "testMainShopping","testShoppingCategory1", "testShoppingDetail1", "testShoppingCategory2", "testShoppingDetail2"})
    public void testShoppingCategory3(){
        driver.get(shoppingWomenCategoryPage.getUrl());
        shoppingWomenCategoryPage.clickOnWomenCardDetail3();
    }

    @Test(dataProvider = "randomQuantity", dataProviderClass = RandomQuantityDataProvider.class, dependsOnMethods = {"testLoginNavigation","testLogin", "testMainShopping","testShoppingCategory1", "testShoppingDetail1", "testShoppingCategory2", "testShoppingDetail2", "testShoppingCategory3"})
    public void testShoppingDetail3(String quantity){
        driver.get(shoppingDetail3Page.getUrlProduct7());

        shoppingDetailPage.showProductInformation();
        shoppingDetail3Page.setQuantity(quantity);
        shoppingDetailPage.verifyFourDetailImagesAndSize();
        shoppingDetailPage.setLSize();
        shoppingDetailPage.clickOnAddToCart();
        //Thread.sleep(5000);
        Assert.assertTrue(productAddedSuccesfullyMessage.lblProductAddedIsDisplayed());
        shoppingDetailPage.clickOnCheckOut();
    }

    @Test(dependsOnMethods = {"testLoginNavigation","testLogin", "testMainShopping","testShoppingCategory1", "testShoppingDetail1", "testShoppingCategory2", "testShoppingDetail2", "testShoppingCategory3", "testShoppingDetail3"})
    public void testShoppingCartSummary(){
        String totalExpected = shoppingCartSummaryPage.getGrandTotalPrice();
        String totalPrice1Expected = shoppingCartSummaryPage.getTotalPrice1();
        String totalPrice2Expected = shoppingCartSummaryPage.getTotalPrice2();
        String totalPrice3Expected = shoppingCartSummaryPage.getTotalPrice3();
        String totalPriceExpected = shoppingCartSummaryPage.getTotalPrice();

        driver.get(shoppingCartSummaryPage.getUrl());
        Assert.assertEquals(shoppingCartSummaryPage.verifyTotalPrice(), totalExpected);
        Assert.assertEquals(shoppingCartSummaryPage.verifyPricePerProduct1(), totalPrice1Expected);
        Assert.assertEquals(shoppingCartSummaryPage.verifyPricePerProduct2(), totalPrice2Expected);
        Assert.assertEquals(shoppingCartSummaryPage.verifyPricePerProduct3(), totalPrice3Expected);
        Assert.assertEquals(shoppingCartSummaryPage.verifyGrandTotalPrice(), totalPriceExpected);
        Assert.assertTrue(shoppingCartSummaryPage.verifyTitleShoppingIsDisplayed());
        shoppingCartSummaryPage.clickOnCheckoutButton();
        shoppingCartSummaryPage.addOrderComment();
        shoppingCartSummaryPage.selectAcceptTerms();
        shoppingCartSummaryPage.clickOnPayOption();
        shoppingCartSummaryPage.clickOnConfirmOrder();
        Assert.assertTrue(shoppingCartSummaryPage.orderConfirmationMessageIsDisplayed());
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
