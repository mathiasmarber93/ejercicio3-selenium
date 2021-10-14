package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingDetail2Page {

    private final WebDriver driver;

    public final String urlProduct6 = "http://automationpractice.com/index.php?id_product=6&controller=product";

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement quantityInput;

    @FindBy(xpath = "//*[@id=\"our_price_display\"]")
    private WebElement productPrice;

    public ShoppingDetail2Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrlProduct6(){
        return urlProduct6;
    }

    public void setQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public Double getUnitPrice2(){
        double productPriceToParse = Double.parseDouble(productPrice.getText().replace("$",""));
        return productPriceToParse;
    }


}
