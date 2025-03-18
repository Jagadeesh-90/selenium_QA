package com.selenium.amazonAssignment;

import com.selenium.amazonAssignment.pages.CartPage;
import com.selenium.amazonAssignment.pages.DealsPage;
import com.selenium.amazonAssignment.pages.NavigationPage;
import com.selenium.amazonAssignment.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WithoutLoginFlowTest extends DriverInitializerClass{

    private DealsPage dealsPage;
    private CartPage cartPage;
    private ProductPage productPage;
    private NavigationPage navigationPage;
    @BeforeClass
    public void setUp() {
        dealsPage = new DealsPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        navigationPage = new NavigationPage(driver);
    }
    @Test(priority = 1, description = "Adds an item to the cart and verifies the quantity")
    public void testAddingItemsToCart() {
        dealsPage.todayDeals();
        cartPage.displayProduct();
        cartPage.addToCart();

        String selectedQuantity = cartPage.displayQuantity();
        Assert.assertEquals(selectedQuantity, "1");
    }
    @Test(priority = 2, description = "Searches for a mobile and navigates through menu options")
    public void testMobileSearch() throws InterruptedException {
        productPage.searchForProduct();
        Assert.assertFalse(productPage.mobileList.isEmpty(), "No products found in search results!");
        navigationPage.selectMobiles();
        Assert.assertTrue(navigationPage.mobileComputer.isDisplayed(), "Mobile category is not displayed!");
        navigationPage.selectMainMenu();
        Assert.assertTrue(navigationPage.mainMenu.isDisplayed(), "Main menu navigation failed!");
    }
}
