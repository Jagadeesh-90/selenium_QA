package com.bdd.cucumber.pages;

import com.bdd.cucumber.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.bdd.cucumber.utils.Locators.*;

public class AuthenticationPage extends AbstractComponent {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationPage.class);
    WebDriver driver;
    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id =ACCOUNT_SIGN_IN)
    private WebElement accountSignIn;

    @FindBy(css = EMAIL_FIELD)
    public WebElement email;

    @FindBy(css = CONTINUE_BUTTON)
    private WebElement continueBtn;

    @FindBy(css = PASSWORD_FIELD)
    public WebElement password;

    @FindBy(id = SIGN_IN_BUTTON)
    private WebElement signInButton;

    @FindBy(id = NAV_MENU)
    public WebElement navMenu;

    public void clickOnLogin() {
        Actions actions = new Actions(driver);
        actions.moveToElement(accountSignIn).click().build().perform();
    }

    public void enterEmail() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/home/jagp/Documents/selenium_QA/cucumber/src/main/resources/application.properties");
        prop.load(fis);
        email.sendKeys(prop.getProperty("EMAIL"));
    }

    public void clickOnContinue() {
        continueBtn.click();
    }

    public void enterPassword() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/home/jagp/Documents/selenium_QA/cucumber/src/main/resources/application.properties");
        prop.load(fis);
        password.sendKeys(prop.getProperty("PASSWORD"));
    }

    public void clickOnSignIn() {
        signInButton.click();
    }

    public boolean isNavMenuDisplayed() {
        try {
            return navMenu.isDisplayed();
        } catch (Exception e) {
            log.error("Navigation menu not found or not visible after sign in.", e);
            return false;
        }
    }

}
