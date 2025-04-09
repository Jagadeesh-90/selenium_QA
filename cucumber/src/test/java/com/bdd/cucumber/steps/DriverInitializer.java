package com.bdd.cucumber.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class DriverInitializer {
    public WebDriver driver;

    @BeforeTest
    public WebDriver initializerDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");
        return driver;
    }

    @AfterTest
    public void endDriver(){
        driver.quit();
    }
}
