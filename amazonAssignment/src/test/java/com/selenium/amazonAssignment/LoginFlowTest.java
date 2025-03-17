package com.selenium.amazonAssignment;

import com.selenium.amazonAssignment.pages.AuthenticationPage;
import com.selenium.amazonAssignment.pages.MyAccountPage;
import com.selenium.amazonAssignment.pages.NavigationPage;
import com.selenium.amazonAssignment.pages.ProductPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginFlowTest extends DriverInitializerClass {
    private AuthenticationPage authenticationPage;
    private NavigationPage navigationPage;
    private ProductPage productPage;
    private MyAccountPage myAccountPage;

    @BeforeClass
    public void setUp() {
        authenticationPage = new AuthenticationPage(driver);
        navigationPage = new NavigationPage(driver);
        productPage = new ProductPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @Test(priority = 1, description = "Logs into the application")
    public void testLogin() throws IOException {
        authenticationPage.login();

    }

    @Test(priority = 2, description = "Retrieves delivery details of a product")
    public void testGetDeliveryDetails() throws InterruptedException {
        navigationPage.selectMobiles();
        productPage.clickOnPrime();
        productPage.getDeliveryDate();
    }

    @Test(priority = 3, description = "Fetches order details from My Account")
    public void testGetMyOrderDetails() {
        myAccountPage.getMyOrders();
    }

    @Test(priority = 4, description = "Retrieves payment details from My Account")
    public void testGetMyPaymentDetails() {
        myAccountPage.getMyPayments();
    }

    @Test(priority = 5, description = "Retrieves and updates address details in My Account")
    public void testGetMyAddressDetails() throws IOException {
        myAccountPage.getMyAddress();
        myAccountPage.fillAddressForm();
    }
}
