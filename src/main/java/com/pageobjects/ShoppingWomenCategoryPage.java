package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingWomenCategoryPage {
    private final WebDriver driver;
    public final String url = "http://automationpractice.com/index.php?id_category=3&controller=category";

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div")
    private WebElement womenCardDetail;

    public ShoppingWomenCategoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl(){
        return url;
    }

    public void clickOnWomenCardDetail(){
        womenCardDetail.click();
    }
}
