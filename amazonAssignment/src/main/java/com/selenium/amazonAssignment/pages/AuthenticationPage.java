package com.selenium.amazonAssignment.pages;

import com.selenium.amazonAssignment.abstractComponents.AbstractComponent;
import com.selenium.amazonAssignment.utils.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.selenium.amazonAssignment.utils.Locators.*;

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
    private WebElement email;

    @FindBy(css = CONTINUE_BUTTON)
    private WebElement continueBtn;

    @FindBy(css = PASSWORD_FIELD)
    private WebElement password;

    @FindBy(id = SIGN_IN_BUTTON)
    private WebElement signInButton;

    public void login() throws IOException {
        Actions actions = new Actions(driver);
        actions.moveToElement(accountSignIn).click().build().perform();

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/home/jagp/Documents/amazonAssignment/src/main/resources/application.properties");
        prop.load(fis);

        email.sendKeys(prop.getProperty("EMAIL"));
        continueBtn.click();
        password.sendKeys(prop.getProperty("PASSWORD"));
        signInButton.click();

    }
}
