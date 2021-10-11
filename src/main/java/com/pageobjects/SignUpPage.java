package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SignUpPage {

    private final WebDriver driver;

    @FindBy(css = "[name='email_create']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    private WebElement btnCreateAccount;

    //SELECTING PERSONAL INFORMATION//
    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    private WebElement chckGender;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement inputFirstname;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement inputLastname;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"days\"]")
    private WebElement dropDayBirthday;

    @FindBy(xpath = "//*[@id=\"months\"]")
    private WebElement dropMonthBirthday;

    @FindBy(xpath = "//*[@id=\"years\"]")
    private WebElement dropYearBirthday;

    //FILLING ADDRESS INFORMATION//

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement firstnameValue;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement lastnameValue;

    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement inputCompany;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement inputAddress;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement inputCity;

    @FindBy(xpath = "//*[@id=\"id_state\"]")
    private WebElement dropState;

    @FindBy(xpath = "//*[@id=\"postcode\"]")
    private WebElement inputPostalCode;

    @FindBy(xpath = "//*[@id=\"id_country\"]")
    private WebElement dropCountry;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement inputPhone;

    @FindBy(xpath = "//*[@id=\"alias\"]")
    private WebElement inputAliasAddress;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    private WebElement btnRegister;

    public final String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";

    public String getUrl(){
        return url;
    }

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    //METHOD TO GET EMAIL VALUE
    public void getEmail(){
       inputEmail.getAttribute("value");
    }

    //METHOD TO GET FIRSTNAME
    public void getFirstname(){
        firstnameValue.getAttribute("value");
    }

    //METHOD TO GET LASTNAME
    public void getLastname(){
        lastnameValue.getAttribute("value");
    }

    //METHODS FOR SELECTING BIRTHDAY DAY
    public void selectDayBirthday(){
        Select selectDayOfBirthday = new Select(dropDayBirthday);
        selectDayOfBirthday.selectByValue("2");
    }

    //METHODS FOR SELECTING BIRTHDAY MONTH
    public void selectMonthBirthday(){
        Select selectMonthOfBirthday = new Select(dropMonthBirthday);
        selectMonthOfBirthday.selectByValue("4");
    }

    public void selectYearBirthday(){
        Select selectYearOfBirthday = new Select(dropYearBirthday);
        selectYearOfBirthday.selectByValue("1993");
    }

    //METHOD FOR SELECTING STATE
    public void selectState(){
        Select selectState = new Select(dropState);
        selectState.selectByValue("30");
    }

    //METHOD FOR SELECTING COUNTRY
    public void selectCountry(){
        Select selectCountry = new Select(dropCountry);
        selectCountry.selectByVisibleText("United States");
    }

    //TYPING EMAIL AND GO TO SIGNUP
    public void enterEmailAndGoToSignUpSection(String email){
        emailInput.sendKeys(email);
        btnCreateAccount.click();
    }

    //METHOD FOR FILLING FORM
    public void fillSignUpForm(String firstname, String lastname, String password,
                               String company, String address, String city,
                               String postalCode, String phone, String aliasAddress){
        chckGender.click();
        inputFirstname.sendKeys(firstname);
        inputLastname.sendKeys(lastname);
        this.getEmail();
        inputPassword.sendKeys(password);
        this.selectDayBirthday();
        this.selectMonthBirthday();
        this.selectYearBirthday();
        this.getFirstname();
        this.getLastname();
        inputCompany.sendKeys(company);
        inputAddress.sendKeys(address);
        inputCity.sendKeys(city);
        this.selectState();
        inputPostalCode.sendKeys(postalCode);
        this.selectCountry();
        inputPhone.sendKeys(phone);
        inputAliasAddress.sendKeys(aliasAddress);
        btnRegister.click();
    }
}
