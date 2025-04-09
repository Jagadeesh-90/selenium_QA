package com.bdd.cucumber.pages;

import com.bdd.cucumber.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.bdd.cucumber.utils.Locators.*;


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
    public List<WebElement> mobileList;

    @FindBy(css = PRIME_CHECKBOX)
    private WebElement primeCheckBox;

    @FindBy(css = DELIVERY_DATE)
    private WebElement deliveryDate;

    @FindBy(id = LIST_BRANDS)
    private WebElement listBrands;
    @FindBy(css = FIRST_PRODUCT)
    private WebElement firstProduct;

    public void searchForProduct(){
        mobileSearch.sendKeys("mobiles");

    }
    public void clickOnSearchBtn() {
        searchButton.click();
    }

    public void visitLastItem() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mobileList.getLast()).build().perform();
        log.info(mobileList.getLast().getText());
    }

    public void displayLastMobileDetails() {
        log.info(mobileList.get(mobileList.size() - 1).getText());
    }
    public void clickingOnFirstBrand() {

        Actions actions = new Actions(driver);
        actions.moveToElement(listBrands).click().build().perform();
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
    public void displayFirstProduct() {
        log.info("getting first product details");
        firstProduct.getText();
    }
}
