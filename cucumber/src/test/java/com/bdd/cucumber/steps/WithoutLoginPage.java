package com.bdd.cucumber.steps;

import com.bdd.cucumber.pages.CartPage;
import com.bdd.cucumber.pages.DealsPage;
import com.bdd.cucumber.pages.NavigationPage;
import com.bdd.cucumber.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class WithoutLoginPage extends DriverInitializer {

    private DealsPage dealsPage;
    private CartPage cartPage;
    private ProductPage productPage;
    private NavigationPage navigationPage;

    @Given("the user is on the Amazon landing page")
    public void the_user_is_on_the_amazon_landing_page() {
        driver = initializerDriver();
        dealsPage = new DealsPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        navigationPage = new NavigationPage(driver);
    }
    @When("User clicking on today deals")
    public void user_clicking_on_today_deals() {
        dealsPage.todayDeals();
        Assert.assertTrue(driver.getCurrentUrl().contains("deals"), "User should be navigated to deals page.");
    }
    @And("User click on third deal")
    public void user_click_on_third_deal() {
        dealsPage.getThirdDeal();
    }
    @And("Add minimum quantity of item")
    public void add_minimum_quantity_of_item() {
        cartPage.addToCart();
        Assert.assertTrue(cartPage.displayQuantity() != null && !cartPage.displayQuantity().isEmpty(), "Quantity should be displayed.");
    }
    @Then("verify the cart item with minimum quantity")
    public void verify_the_cart_item_with_minimum_quantity() {
        cartPage.verifyQuantity();
        Assert.assertTrue(cartPage.displayQuantity().matches("\\d+"), "Quantity should be numeric and visible.");
    }
    @When("User search for {string}")
    public void user_search_for(String searchTerm) {
        productPage.searchForProduct();
        Assert.assertFalse(searchTerm.isEmpty(), "Search term should not be empty.");
    }
    @And("User click on search button")
    public void user_click_on_search_button() {
        productPage.clickOnSearchBtn();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("mobiles"), "Search results should be displayed.");
    }
    @And("User scroll down to last mobile")
    public void user_scroll_down_to_last_mobile() {
        productPage.visitLastItem();
        Assert.assertFalse(productPage.mobileList.isEmpty(), "Mobile list should not be empty.");
    }
    @Then("verify the Last mobile displayed")
    public void verify_the_last_mobile_displayed() {
        productPage.displayLastMobileDetails();
        Assert.assertTrue(productPage.mobileList.get(productPage.mobileList.size() - 1).isDisplayed(), "Last mobile should be displayed.");
    }
    @When("User will navigate to navbar")
    public void user_will_navigate_to_navbar() {
        navigationPage.clickOnNavBar();
    }
    @When("User click on mobiles")
    public void user_click_on_mobiles() {
        navigationPage.selectMobiles();
        Assert.assertTrue(navigationPage.allMobilePhones.isDisplayed(),"All mobiles tab should be visible");
    }
    @When("User will click on mobiles section")
        public void user_will_click_on_mobiles_section() {
        navigationPage.selectAllMobiles();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("nav_em_sbc_mobcomp_all_mobiles_0_2_8_2"), "User should be redirected to mobile section.");
    }
    @When("User will click on first brand")
        public void user_will_click_on_first_brand() {
        productPage.clickingOnFirstBrand();
    }
    @Then("verify the mobiles on first page")
        public void verify_the_mobiles_on_first_page() {
        productPage.displayFirstProduct();
        Assert.assertTrue(productPage.mobileList.get(0).isDisplayed(), "First product should be visible.");
    }

}
