package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingDetail3Page {

    private final WebDriver driver;

    public final String urlProduct7 = "http://automationpractice.com/index.php?id_product=7&controller=product";

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement quantityInput;

    @FindBy(xpath = "//*[@id=\"our_price_display\"]")
    private WebElement productPrice;

    public ShoppingDetail3Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrlProduct7(){
        return urlProduct7;
    }

    public Double getUnitPrice3(){
        double productPriceToParse = Double.parseDouble(productPrice.getText().replace("$",""));
        return productPriceToParse;
    }

    public void setQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }
}
