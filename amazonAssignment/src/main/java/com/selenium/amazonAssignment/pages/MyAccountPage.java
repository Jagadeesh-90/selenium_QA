package com.selenium.amazonAssignment.pages;

import com.selenium.amazonAssignment.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.selenium.amazonAssignment.utils.Locators.*;

public class MyAccountPage extends AbstractComponent {
    WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = ORDER_BUTTON)
    private WebElement orderBtn;
    @FindBy(id = TIME_FILTER)
    private WebElement timeFilter;
    @FindBy(id = MY_ACCOUNT)
    private WebElement myAccount;
    @FindBy(css = MY_PAYMENTS)
    private WebElement myPayments;
    @FindBy(css = MY_ADDRESS)
    private WebElement myAddress;
    @FindBy(id = ADD_ADDRESS)
    private WebElement addAddress;
    @FindBy(css = FULL_NAME)
    private WebElement fullName;
    @FindBy(css =MOBILE_NUMBER)
    private WebElement mobileNumber;
    @FindBy(css = PIN_CODE)
    private WebElement pinCode;
    @FindBy(css = HOUSE_NO)
    private WebElement houseNo;
    @FindBy(css = AREA)
    private WebElement area;
    @FindBy(css = LANDMARK)
    private WebElement landMark;
    @FindBy(css = ADDRESS)
    private WebElement address;
    @FindBy(xpath =SELECT_STATE)
    private WebElement selectState;
    @FindBy(id = ADDRESS_SUBMIT_BUTTON)
    private WebElement addressSubmitBtn;

    public void getMyOrders(){
        orderBtn.click();
        waitForElement(By.className("your-orders-content-container"));
        Select select = new Select(timeFilter);
        select.selectByIndex(3);
    }
    public void getMyPayments(){
        myAccount.click();
        myPayments.click();
        waitForElement(By.id("walletTitleRow"));
    }
    public void getMyAddress(){
    myAccount.click();
    myAddress.click();
    waitForElement(By.id("ya-myab-address-add-link"));
    addAddress.click();
    waitForElement(By.id("address-ui-widgets-enterAddressFullName"));
    }
    public void fillAddressForm() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/home/jagp/Documents/amazonAssignment/src/main/resources/application.properties");
        prop.load(fis);
        fullName.sendKeys(prop.getProperty("NAME"));
        mobileNumber.sendKeys(prop.getProperty("MOBILE_NUMBER"));
        pinCode.sendKeys(prop.getProperty("PIN_CODE"));
        houseNo.sendKeys(prop.getProperty("HOUSE_NO"));
        area.sendKeys(prop.getProperty("AREA"));
        landMark.sendKeys(prop.getProperty("LANDMARK"));
        address.sendKeys(prop.getProperty("ADDRESS"));
        waitForCityName(selectState,"ANDHRA PRADESH");
        addressSubmitBtn.click();
    }
}
