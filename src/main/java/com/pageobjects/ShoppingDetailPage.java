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
    public final String url = "http://automationpractice.com/index.php?id_product=1&controller=product";

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

    public ShoppingDetailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl(){
        return url;
    }

    public void showProductInformation(){
        System.out.println("TITULO DEL PRODUCTO: " + productTitle.getText());
        System.out.println("CONDICION: " + productCondition.getText());
        System.out.println("PRECIO DEL PRODUCTO: " + productPrice.getText());
    }

    public void setQuantity(String quantity){
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public void verifyFourDetailImagesAndSize(){
        Integer counter=0;

        Select select = new Select(sizeInput);
        WebElement optionSelected = select.getFirstSelectedOption();
        String sizeValue = optionSelected.getText();

        System.out.println("IMAGENES DEL DETALLE");
        for(WebElement image:listImages){
            if(image.isDisplayed()){
                counter++;
                System.out.println(image.getAttribute("src"));
            }
        }
        if ((counter == 4) && (sizeValue.equals("S"))) {
            System.out.println("Existen " + counter + " imagenes en el detalle");
            System.out.println("La talla es: " + sizeValue);
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

}
