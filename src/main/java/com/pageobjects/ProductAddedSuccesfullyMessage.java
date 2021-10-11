package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductAddedSuccesfullyMessage {

    private final WebDriver driver;

    @FindBy(xpath = "//h2[contains(., 'Product successfully added to your shopping cart')]")
    private WebElement lblProductAddedSuccessfully;

    @FindBy(xpath = "//*[@id=\"layer_cart_product_title\"]")
    private WebElement lblProductTitle;

    @FindBy(xpath = "//*[@id=\"layer_cart_product_attributes\"]")
    private WebElement lblColorAndSize;

    @FindBy(xpath = "//*[@id=\"layer_cart_product_quantity\"]")
    private WebElement lblQuantity;

    @FindBy(xpath = "//*[@id=\"layer_cart_product_price\"]")
    private WebElement lblPrice;

    public ProductAddedSuccesfullyMessage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean lblProductAddedIsDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(lblProductAddedSuccessfully));
        return lblProductAddedSuccessfully.isDisplayed();
    }

    public void showProductAddedInformation(){
        System.out.println("++INFORMACION DEL CARRITO++");
        System.out.println("TITULO: " + lblProductTitle.getText());
        System.out.println("COLOR Y TALLA: " + lblColorAndSize.getText());
        System.out.println("CANTIDAD: " + lblQuantity.getText());
        System.out.println("PRECIO TOTAL: " + lblPrice.getText());
    }



}
