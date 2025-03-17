package com.selenium.amazonAssignment.pages;

import com.selenium.amazonAssignment.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.selenium.amazonAssignment.utils.Locators.*;

public class ProductPage extends AbstractComponent {
    private static final Logger log = LoggerFactory.getLogger(CartPage.class);
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = SEARCH_BOX)
    private WebElement mobileSearch;

    @FindBy(id = SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(css = SEARCH_RESULTS)
    private List<WebElement> mobileList;

    @FindBy(css = PRIME_CHECKBOX)
    private WebElement primeCheckBox;

    @FindBy(css = DELIVERY_DATE)
    private WebElement deliveryDate;


    public void searchForProduct(){
        mobileSearch.sendKeys("mobiles");
        searchButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(mobileList.getLast()).build().perform();
        log.info(mobileList.getLast().getText());
    }
    public void clickOnPrime() {
        log.info("waiting for prime checkbox");
        waitForElement(By.cssSelector("[aria-label='Prime Eligible']"));
        primeCheckBox.click();
    }
    public void getDeliveryDate(){
        log.info("get delivery date of 1st product");
        System.out.println(deliveryDate.getText());

    }
}
