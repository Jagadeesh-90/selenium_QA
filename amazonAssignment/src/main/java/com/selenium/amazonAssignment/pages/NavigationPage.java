package com.selenium.amazonAssignment.pages;

import com.selenium.amazonAssignment.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.selenium.amazonAssignment.utils.Locators.*;

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
    private WebElement mobileComputer;
    @FindBy(xpath = ALL_MOBILE_PHONES)
    private WebElement allMobilePhones;
    @FindBy(id = MAIN_MENU)
    private WebElement mainMenu;

    public void selectMobiles() throws InterruptedException {
        Actions action = new Actions(driver);
        navMenu.click();
        waitForWebElement(mobileComputer);
        action.moveToElement(mobileComputer).click().build().perform();
        waitForWebElement(allMobilePhones);
        action.moveToElement(allMobilePhones).click().build().perform();
    }
    public void selectMainMenu(){
        mainMenu.click();
    }
}
