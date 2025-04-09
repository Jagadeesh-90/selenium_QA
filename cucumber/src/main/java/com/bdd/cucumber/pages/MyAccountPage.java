package com.bdd.cucumber.pages;

import com.bdd.cucumber.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.bdd.cucumber.utils.Locators.*;

public class MyAccountPage extends AbstractComponent {
    WebDriver driver;
    Properties prop;
    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.prop=loadProperties();
    }
    private Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("/home/jagp/Documents/amazonAssignment/src/main/resources/application.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace(); // You can replace this with logging
        }
        return properties;
    }
    @FindBy(id = ORDER_BUTTON)
    public WebElement orderBtn;
    @FindBy(id = TIME_FILTER)
    public WebElement timeFilter;
    @FindBy(id = MY_ACCOUNT)
    public WebElement myAccount;
    @FindBy(css = MY_PAYMENTS)
    public WebElement myPayments;
    @FindBy(css = MY_ADDRESS)
    public WebElement myAddress;
    @FindBy(id = ADD_ADDRESS)
    public WebElement addAddress;
    @FindBy(css = FULL_NAME)
    public WebElement fullName;
    @FindBy(css =MOBILE_NUMBER)
    public WebElement mobileNumber;
    @FindBy(css = PIN_CODE)
    public WebElement pinCode;
    @FindBy(css = HOUSE_NO)
    public WebElement houseNo;
    @FindBy(css = AREA)
    public WebElement area;
    @FindBy(css = LANDMARK)
    private WebElement landMark;
    @FindBy(css = ADDRESS)
    private WebElement address;
    @FindBy(xpath =SELECT_STATE)
    private WebElement selectState;
    @FindBy(id = ADDRESS_SUBMIT_BUTTON)
    private WebElement addressSubmitBtn;
    @FindBy(id = WALLET_TITLE)
    public WebElement walletTitle;

    public void getMyAddress(){
    myAccount.click();
    myAddress.click();
    waitForElement(By.id("ya-myab-address-add-link"));
    addAddress.click();
    waitForElement(By.id("address-ui-widgets-enterAddressFullName"));
    }


    public void getMyOrders() {
        orderBtn.click();
    }

    public void gotoLastYear() {
        waitForElement(By.className("your-orders-content-container"));
        Select select = new Select(timeFilter);
        select.selectByIndex(3);
    }

    public void clickOnMyAccount() {
        myAccount.click();
    }

    public void getMyPayments() {
        myPayments.click();
        waitForWebElement(walletTitle);;

    }

    public void verifyPaymentPage() {
        waitForWebElement(walletTitle);
    }

    public void clickOnMyAddress() {
        myAddress.click();
    }

    public void addAddress() {
        addAddress.click();
    }

    public void enterFullName() {
        fullName.sendKeys(prop.getProperty("NAME"));
    }

    public void enterPhoneNumber() {
        mobileNumber.sendKeys(prop.getProperty("MOBILE_NUMBER"));
    }

    public void enterPinCode() {
        pinCode.sendKeys(prop.getProperty("PIN_CODE"));
    }

    public void enterDoorNo() {
        houseNo.sendKeys(prop.getProperty("HOUSE_NO"));
    }

    public void enterArea() {
        area.sendKeys(prop.getProperty("AREA"));
    }

    public void enterLandMark() {
        landMark.sendKeys(prop.getProperty("LANDMARK"));
    }

    public void enterAddress() {
        address.sendKeys(prop.getProperty("ADDRESS"));
    }
    public void submitAddress() {
        waitForCityName(selectState,"ANDHRA PRADESH");
        addressSubmitBtn.click();
    }

}
