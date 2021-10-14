package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class ShoppingDetailPage {

    private final WebDriver driver;
    public final String urlProduct1 = "http://automationpractice.com/index.php?id_product=1&controller=product";

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
    private WebElement productTitle;

    @FindBy(xpath = "//*[@id=\"product_condition\"]/span")
    private WebElement productCondition;

    @FindBy(xpath = "//*[@id=\"our_price_display\"]")
    private WebElement productPrice;

    @FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
    private WebElement quantityInput;

    @FindBy(xpath = "//*[contains(@id,\"thumb_\")]")
    private List<WebElement> listImages;

    @FindBy(xpath = "//*[@id=\"group_1\"]")
    private WebElement sizeInput;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    private WebElement addToCartButton;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    private WebElement checkoutButton;

    public ShoppingDetailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrlProduct1(){
        return urlProduct1;
    }

    public Double getUnitPrice1(){
        double productPrice1ToParse = Double.parseDouble(productPrice.getText().replace("$",""));
        return productPrice1ToParse;
    }

    public void showProductInformation(){
        System.out.println("-------------------------------------------");
        System.out.println("Titulo del producto: " + productTitle.getText());
        System.out.println("Condicion: " + productCondition.getText());
        System.out.println("Precio del producto: " + productPrice.getText());
        System.out.println("-------------------------------------------");
    }

    public void setQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public void verifyFourDetailImagesAndSize(){
        Integer counter=0;

        Select select = new Select(sizeInput);
        WebElement optionSelected = select.getFirstSelectedOption();
        String sizeValue = optionSelected.getText();
        System.out.println("-------------------------------------------");
        System.out.println("Analizando imagenes del detalle...");
        for(WebElement image:listImages){
            if(image.isDisplayed()){
                counter++;
                System.out.println(image.getAttribute("src"));
            }
        }
        if ((counter == 4) && (sizeValue.equals("S"))) {
            System.out.println("Existen " + counter + " imagenes en el detalle");
            System.out.println("Se verifico que la talla seleccionada para las 4 imagenes sea: " + sizeValue);
            System.out.println("-------------------------------------------");
        } else {
            System.out.println("Hay menos de 4 imagenes");
        }

    }

    public void setLSize(){
        Select select = new Select(sizeInput);
        select.selectByValue("3");
    }

    public void clickOnAddToCart(){
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
    }

    public void clickOnContinueShopping(){
        Actions actions = new Actions(driver);
        actions.moveToElement(continueShoppingButton).click().perform();
    }

    public void clickOnCheckOut(){
        Actions actions = new Actions(driver);
        actions.moveToElement(checkoutButton).click().perform();
    }

}
