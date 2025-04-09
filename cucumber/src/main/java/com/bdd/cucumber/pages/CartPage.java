package com.bdd.cucumber.pages;

import com.bdd.cucumber.abstractComponents.AbstractComponent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.bdd.cucumber.utils.Locators.*;


public class CartPage extends AbstractComponent {
    private static final Logger log = LoggerFactory.getLogger(CartPage.class);
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = PRODUCT_TITLE)
    private WebElement productTitle;

    @FindBy(xpath = CART_BUTTON)
    private List<WebElement> cartButton;

    @FindBy(id = CART_PREVIEW)
    private WebElement cartPreview;

    @FindBy(css = QUANTITY_SELECTOR)
    private WebElement quantity;

    @FindBy(className = ADDED_ITEM_TO_CART)
    private List<WebElement> successCheck;

    public void displayProduct(){
        log.info(productTitle.getText());
    }
    public String displayQuantity(){
        return quantity.getText();
    }
    public void addToCart(){
        if(cartButton.size()>1){
            cartButton.get(1).click();
        }
        else{
            cartButton.getFirst().click();
        }

//        waitForWebElement(successCheck.get(1));
    }

    public void verifyQuantity() {
        Assert.assertTrue("The checkbox should be visible.", successCheck.get(1).isDisplayed());
    }

}
