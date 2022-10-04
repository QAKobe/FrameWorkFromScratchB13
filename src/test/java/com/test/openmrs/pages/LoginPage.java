package com.test.openmrs.pages;

import com.test.openmrs.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//li[@id='Inpatient Ward']")
    WebElement inpatientWard;

    @FindBy(xpath = "//input[@id='loginButton']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='error-message']")
    WebElement errorMessage;

    public void login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        inpatientWard.click();
        loginButton.click();
    }

    public String getMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}
