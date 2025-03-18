package com.selenium.amazonAssignment.pages;

import com.selenium.amazonAssignment.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.selenium.amazonAssignment.utils.Locators.*;

public class DealsPage extends AbstractComponent {
    WebDriver driver;
    public DealsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = DEALS_LINK)
    WebElement getDeals;

    @FindBy(css = DEALS_CARD)
    List<WebElement> thirdDeal;

    public void todayDeals(){
        getDeals.click();
        waitForWebElement(getDeals);
        thirdDeal.get(2).click();
    }
}
