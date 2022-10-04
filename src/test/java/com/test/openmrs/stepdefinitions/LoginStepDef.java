package com.test.openmrs.stepdefinitions;

import com.test.openmrs.pages.LoginPage;
import com.test.openmrs.utils.ConfigReader;
import com.test.openmrs.utils.DriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDef {

    WebDriver driver = DriverHelper.getDriver();

    LoginPage loginPage = new LoginPage(driver);

    @Given("User navigates to OpenMrs website and provides credentials")
    public void user_navigates_to_open_mrs_website_and_provides_credentials() {
        loginPage.login(ConfigReader.readProperty("QA_username"), ConfigReader.readProperty("QA_password"));
    }
    @Then("User validates title {string} and {string}")
    public void user_validates_title_and(String title, String url) {
        Assert.assertTrue(driver.getTitle().contains(title));
        Assert.assertEquals(url, driver.getCurrentUrl().trim());
    }

    //negative scenario for login functionality, now pay attention in the code above that
    //loging in with valid username and password, and they're coming from ConfigReader.
    //Hence, you cannot play around with ConfigReader's username and password
    @Given("User navigates to OpenMrs website and provides invalid credentials which are {string} and {string}")
    public void user_navigates_to_open_mrs_website_and_provides_invalid_credentials_which_are_and(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("User validates the errorMessage {string}")
    public void user_validates_the_error_message(String errorMessage) {
       Assert.assertEquals(errorMessage, loginPage.getMessage());
    }


}
