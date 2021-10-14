package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage {

    private final WebDriver driver;
    public final String url= "http://automationpractice.com/index.php?controller=order";

    private ShoppingDetailPage shoppingDetailPage;
    private ShoppingDetail2Page shoppingDetail2Page;
    private ShoppingDetail3Page shoppingDetail3Page;

    @FindBy(xpath = "//*[@id=\"product_price_1_5_580610\"]/span")
    private WebElement unitPrice1;

    @FindBy(xpath = "//*[@id=\"product_1_5_0_580610\"]/td[5]/input[2]")
    private WebElement quantity1;

    @FindBy(xpath = "//*[@id=\"total_product_price_1_5_580610\"]")
    private WebElement total1;

    @FindBy(xpath = "//*[@id=\"product_price_6_33_580610\"]/span")
    private WebElement unitPrice2;

    @FindBy(xpath = "//*[@id=\"product_6_33_0_580610\"]/td[5]/input[2]")
    private WebElement quantity2;

    @FindBy(xpath = "//*[@id=\"total_product_price_6_33_580610\"]")
    private WebElement total2;

    @FindBy(xpath = "//*[@id=\"product_price_7_36_580610\"]/span[1]")
    private WebElement unitPrice3;

    @FindBy(xpath = "//*[@id=\"product_7_36_0_580610\"]/td[5]/input[2]")
    private WebElement quantity3;

    @FindBy(xpath = "//*[@id=\"total_product_price_7_36_580610\"]")
    private WebElement total3;

    @FindBy(xpath = "//*[@id=\"total_product\"]")
    private WebElement grandTotal;

    @FindBy(xpath = "//*[@id=\"total_price\"]")
    private WebElement totalPrice;

    @FindBy(xpath = "//*[@id=\"total_product\"]")
    private WebElement totalProducts;

    @FindBy(xpath = "//*[@id=\"total_shipping\"]")
    private WebElement totalShipping;

    @FindBy(xpath = "//span[text()[contains(.,'Your shopping cart contains:')]]")
    private WebElement titleShopping;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    private WebElement checkoutButton1;

    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
    private WebElement orderComment;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    private WebElement checkoutButton2;

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    private WebElement chckterms;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    private WebElement checkoutButton3;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    private WebElement payOptionButton;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//strong[text()[contains(.,'Your order on My Store is complete')]]")
    private WebElement orderConfirmationMessage;

    public ShoppingCartSummaryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrl(){
        return url;
    }

    public String getTotalPrice(){
        double totalPriceParsed = Double.parseDouble(totalPrice.getText().replace("$",""));
        String totalPriceString = String.valueOf(totalPriceParsed);
        return totalPriceString;
    }

    public String getGrandTotalPrice(){
        double grandTotalParsed= Double.parseDouble(grandTotal.getText().replace("$",""));
        String grandTotalString = String.valueOf(grandTotalParsed);
        return grandTotalString;
    }

    public String getTotalPrice1(){
        double parsedTotal1 = Double.parseDouble(total1.getText().replace("$",""));
        String total1String = String.valueOf(parsedTotal1);
        return total1String;
    }

    public String getTotalPrice2(){
        double parsedTotal2 = Double.parseDouble(total2.getText().replace("$",""));
        String total2String = String.valueOf(parsedTotal2);
        return total2String;
    }

    public String getTotalPrice3(){
        double parsedTotal3 = Double.parseDouble(total3.getText().replace("$",""));
        String total3String = String.valueOf(parsedTotal3);
        return total3String;
    }

    public String verifyPricePerProduct1(){
        double parsedUnitPrice1 = Double.parseDouble(unitPrice1.getText().replace("$",""));
        double parsedQuantity1 = Double.parseDouble((quantity1).getAttribute("value"));
        double totalPrice1 = parsedUnitPrice1 * parsedQuantity1;
        double roundTotalPrice1InTwoDecimals = (Math.round(totalPrice1*100.0)/100.0);
        String totalPrice1String = String.valueOf(roundTotalPrice1InTwoDecimals);
        System.out.println("-------------------------------------------");
        System.out.println("Precio del producto 1 verificado: " + totalPrice1String);
        return String.valueOf(totalPrice1String);
    }

    public String verifyPricePerProduct2(){
        double parsedUnitPrice2 = Double.parseDouble(unitPrice2.getText().replace("$",""));
        double parsedQuantity2 = Double.parseDouble((quantity2).getAttribute("value"));
        double totalPrice2 = parsedUnitPrice2 * parsedQuantity2;
        double roundTotalPrice2InTwoDecimals = (Math.round(totalPrice2*100.0)/100.0);
        String totalPrice2String = String.valueOf(roundTotalPrice2InTwoDecimals);
        System.out.println("Precio del producto 2 verificado: " + totalPrice2String);
        return totalPrice2String;
    }

    public String verifyPricePerProduct3(){
        double parsedUnitPrice3 = Double.parseDouble(unitPrice3.getText().replace("$",""));
        double parsedQuantity3 = Double.parseDouble((quantity3).getAttribute("value"));
        double totalPrice3 = parsedUnitPrice3 * parsedQuantity3;
        double roundTotalPrice3InTwoDecimals = (Math.round(totalPrice3*100.0)/100.0);
        String totalPrice3String = String.valueOf(roundTotalPrice3InTwoDecimals);
        System.out.println("Precio del producto 3 verificado: " + totalPrice3String);
        System.out.println("-------------------------------------------");
        return totalPrice3String;
    }

    public String verifyTotalPrice(){
        double total1Parsed = Double.parseDouble(total1.getText().replace("$",""));
        double total2Parsed = Double.parseDouble(total2.getText().replace("$",""));
        double total3Parsed = Double.parseDouble(total3.getText().replace("$",""));

        double grandTotalParsed = Double.parseDouble(grandTotal.getText().replace("$",""));
        double totalResult = total1Parsed + total2Parsed + total3Parsed;
        double roundTotalResultInTwoDecimals = (Math.round(totalResult*100.0)/100.0);

        if(grandTotalParsed==roundTotalResultInTwoDecimals){
            System.out.println("-------------------------------------------");
            System.out.println("El precio total se esta sumando correctamente: " + roundTotalResultInTwoDecimals);
        } else {
            System.out.println("El precio total no coincide con el total de cada producto");
        }

        String totalPriceString = String.valueOf(roundTotalResultInTwoDecimals);
        return totalPriceString;
    }

    public String verifyGrandTotalPrice(){
        double parseTotalProducts = Double.parseDouble(totalProducts.getText().replace("$",""));
        double parseTotalShipping = Double.parseDouble(totalShipping.getText().replace("$",""));
        double parseTotalPrice = Double.parseDouble(totalPrice.getText().replace("$",""));

        double grandTotalPrice = parseTotalProducts + parseTotalShipping;
        double roundTotalPriceInTwoDecimals = (Math.round(grandTotalPrice*100.0)/100.0);

        if(roundTotalPriceInTwoDecimals==parseTotalPrice){
            System.out.println("El gran total esta sumado correctamente: " + roundTotalPriceInTwoDecimals);
        } else {
            System.out.println("Error en el gran total");
        }

        String totalPriceString = String.valueOf(roundTotalPriceInTwoDecimals);
        return totalPriceString;
    }

    public boolean verifyTitleShoppingIsDisplayed(){
        System.out.println("Se verifico que se visualice el titulo: " + titleShopping.getText());
        System.out.println("-------------------------------------------");
        return titleShopping.isDisplayed();
    }

    public void clickOnCheckoutButton(){
        checkoutButton1.click();
    }

    public void addOrderComment(){
        orderComment.sendKeys("Esta es una prueba de automatizacion con selenium web driver - Bootcamp Oktana 2021");
        checkoutButton2.click();
    }

    public void selectAcceptTerms(){
        chckterms.click();
        checkoutButton3.click();
    }

    public void clickOnPayOption(){
        payOptionButton.click();
    }

    public void clickOnConfirmOrder(){
        confirmOrderButton.click();
    }

    public boolean orderConfirmationMessageIsDisplayed(){
        System.out.println("-------------------------------------------");
        System.out.println("Fin de la automatizacion: " + orderConfirmationMessage.getText());
        System.out.println("-------------------------------------------");
        return orderConfirmationMessage.isDisplayed();
    }

}
