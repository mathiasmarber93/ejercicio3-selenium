package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {
    private final WebDriver driver;
    public final String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    private WebElement womenTab;

    public ShoppingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl(){
        return url;
    }

    public void clickOnWomenTab(){
        womenTab.click();
    }
}
