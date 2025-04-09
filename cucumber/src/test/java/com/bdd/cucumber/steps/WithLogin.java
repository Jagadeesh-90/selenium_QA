package com.bdd.cucumber.steps;

import com.bdd.cucumber.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class WithLogin extends DriverInitializer{
    DealsPage dealsPage;
    CartPage cartPage;
    ProductPage productPage;
    NavigationPage navigationPage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    WebDriver driver;

    @Given("the user is on the Amazon homepage")
    public void the_user_is_on_the_amazon_homepage() {
       driver= initializerDriver();
       dealsPage=new DealsPage(driver);
       cartPage=new CartPage(driver);
       productPage=new ProductPage(driver);
       navigationPage=new NavigationPage(driver);
       authenticationPage=new AuthenticationPage(driver);
       myAccountPage=new MyAccountPage(driver);
    }
    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
       authenticationPage.clickOnLogin();
        Assert.assertTrue(authenticationPage.email.isDisplayed(), "Email input field should be displayed after clicking Login");
    }
    @And("the user enters a valid email address")
    public void the_user_enters_a_valid_email_address() throws IOException {
        authenticationPage.enterEmail();
        String expectedEmail = "7995600367"; // replace with real test email
        Assert.assertEquals(authenticationPage.email.getAttribute("value"), expectedEmail);
    }
    @And("the user clicks on the continue button")
    public void the_user_clicks_on_the_continue_button() {
       authenticationPage.clickOnContinue();
        Assert.assertTrue(authenticationPage.password.isDisplayed(), "Password field should be visible after clicking Continue");
    }
    @And("the user enters a valid password")
    public void the_user_enters_a_valid_password() throws IOException {
       authenticationPage.enterPassword();
        String enteredPassword = authenticationPage.password.getAttribute("value");
        Assert.assertFalse(enteredPassword.isEmpty(), "Password field should not be empty");
    }
    @And("the user clicks on the sign In button")
    public void the_user_clicks_on_the_sign_in_button() {
      authenticationPage.clickOnSignIn();
        Assert.assertTrue(authenticationPage.navMenu.isDisplayed(), "Navigation menu should be displayed after successful login");
    }
    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        Assert.assertTrue(authenticationPage.navMenu.isDisplayed(), "Navigation menu should be displayed on the home page after login.");
    }
    @When("the user navigates to the navigation bar")
    public void the_user_navigates_to_the_navigation_bar() {
      navigationPage.clickOnNavBar();
    }
    @And("the user clicks on the mobiles")
    public void the_user_clicks_on_the_mobiles() {
      navigationPage.selectMobiles();
      Assert.assertTrue(navigationPage.allMobilePhones.isDisplayed(),"All mobiles tab should be visible");
    }
    @And("the user selects the mobiles section")
    public void the_user_selects_the_mobiles_section() {
      navigationPage.selectAllMobiles();
    }
    @And("the user click on prime checkBox")
    public void the_user_click_on_prime_check_box() {
       productPage.clickOnPrime();
    }
    @Then("mobile products should be visible on the first page")
    public void mobile_products_should_be_visible_on_the_first_page() {
       productPage.displayFirstProduct();
        Assert.assertFalse(productPage.mobileList.isEmpty(), "Mobile product list should not be empty");
    }
    @When("the user clicks on my orders")
    public void the_user_clicks_on_my_orders() {
    myAccountPage.getMyOrders();
    Assert.assertTrue(myAccountPage.timeFilter.isDisplayed(),"Time filter dropdown is displayed after click on getMyOrders tab");
    }
    @And("the user selects the filter for last year's orders")
    public void the_user_selects_the_filter_for_last_year_s_orders() {
      myAccountPage.gotoLastYear();
    }
    @Then("the user should see the orders from the previous year")
    public void the_user_should_see_the_orders_from_the_previous_year() {
        System.out.println("moved to last year order details");
    }
    @When("the user clicks on my account")
    public void the_user_clicks_on_my_account() {
        myAccountPage.clickOnMyAccount();
        Assert.assertTrue(myAccountPage.myPayments.isDisplayed(),"My payments element should be displayed after click on my account");
    }
    @And("the user selects my payments")
    public void the_user_selects_my_payments() {
     myAccountPage.getMyPayments();
     Assert.assertTrue(myAccountPage.walletTitle.isDisplayed(),"wallet title should be displayed after click on my payments");
    }
    @Then("the payment details should be displayed")
    public void the_payment_details_should_be_displayed() {
       myAccountPage.verifyPaymentPage();
       Assert.assertTrue(myAccountPage.walletTitle.isDisplayed(), "Payment details should be displayed");
    }
    @And("the user selects your Addresses")
    public void the_user_selects_your_addresses() {
       myAccountPage.clickOnMyAddress();
       Assert.assertTrue(myAccountPage.addAddress.isDisplayed(),"Add address button should be displayed after click on click on my address");
    }
    @And("the user clicks on add address")
    public void the_user_clicks_on_add_address() {
       myAccountPage.addAddress();
    }
    @And("the user enters a valid full name")
    public void the_user_enters_a_valid_full_name() {
     myAccountPage.enterFullName();
     Assert.assertEquals(myAccountPage.fullName.getAttribute("value"),"Palla Jagadeesh","Full Name field did not receive the expected input!");
    }
    @And("the user enters a valid mobile number")
    public void the_user_enters_a_valid_mobile_number() {
        myAccountPage.enterPhoneNumber();
        Assert.assertEquals(myAccountPage.mobileNumber.getAttribute("value"),"7995600367","Mobile Number field did not receive the expected input!");
    }
    @And("the user enters a valid PIN code")
    public void the_user_enters_a_valid_pin_code() {
       myAccountPage.enterPinCode();
        Assert.assertEquals(myAccountPage.pinCode.getAttribute("value"),"531032","PinCode field did not receive the expected input!");
    }
    @And("the user enters a valid door number")
    public void the_user_enter_a_valid_door_number(){
        myAccountPage.enterDoorNo();
        Assert.assertEquals(myAccountPage.houseNo.getAttribute("value"),"5-21","House number field did not receive the expected input!");
    }
    @And("the user enters a valid area")
    public void the_user_enters_a_valid_area() {
        myAccountPage.enterArea();
        Assert.assertEquals(myAccountPage.area.getAttribute("value"),"Gandhavaram","Area field did not receive the expected input!");
    }
    @And("the user clicks on submit address")
    public void the_user_clicks_on_submit_address() {
       myAccountPage.submitAddress();
    }
    @And("the user enters a valid landmark")
    public void the_user_enters_a_valid_landmark(){
        myAccountPage.enterLandMark();
        Assert.assertEquals(myAccountPage.fullName.getAttribute("value"),"Palla Jagadeesh","Full Name field did not receive the expected input!");
    }
    @And("the user enters a valid area address")
    public void the_user_enters_a_valid_area_address(){
        myAccountPage.enterArea();
        Assert.assertEquals(myAccountPage.fullName.getAttribute("value"),"Palla Jagadeesh","Full Name field did not receive the expected input!");
    }
    @Then("the new address should be added successfully")
    public void the_new_address_should_be_added_successfully() {
        System.out.println("submitted the address");

    }
}
