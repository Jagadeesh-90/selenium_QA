package com.selenium.amazonAssignment.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;

public class AbstractComponent {
    WebDriver driver;

    public AbstractComponent(WebDriver driver){
        this.driver=driver;
    }

    public void waitForElement(By element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForWebElement(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForCityName(WebElement element, String stateName) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2));
        wait.until(new Function<WebDriver, Object>() {

            @Override
            public Object apply(WebDriver driver) {
                Select select = new Select(element);
                if (select.getFirstSelectedOption().getText().equals(stateName)) {
                    System.out.println("done");
                    return select.getFirstSelectedOption().getText();
                }
                return null;
            }
        });
    }
}
