package com.test.openmrs.stepdefinitions;

import com.test.openmrs.utils.BrowserUtils;
import com.test.openmrs.utils.ConfigReader;
import com.test.openmrs.utils.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hook {

    public WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("QA_url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        BrowserUtils.takeScreenShotWithCucumber(scenario, driver);
        driver.quit();
    }

}
