package com.bdd.cucumber.pages;


import com.bdd.cucumber.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bdd.cucumber.utils.Locators.*;

public class NavigationPage extends AbstractComponent {

    WebDriver driver;
    public NavigationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = NAV_MENU)
    private WebElement navMenu;
    @FindBy(css = MOBILE_COMPUTER)
    public WebElement mobileComputer;
    @FindBy(xpath = ALL_MOBILE_PHONES)
    public WebElement allMobilePhones;
    @FindBy(id = MAIN_MENU)
    public WebElement mainMenu;

    public void clickOnNavBar() {
        navMenu.click();
    }
    public void selectMobiles() {
        Actions action = new Actions(driver);
        waitForWebElement(mobileComputer);
        action.moveToElement(mobileComputer).click().build().perform();

    }
    public void selectAllMobiles() {
        Actions action = new Actions(driver);
        waitForWebElement(allMobilePhones);
        action.moveToElement(allMobilePhones).click().build().perform();
    }
    public void selectMainMenu(){
        mainMenu.click();
    }
}
