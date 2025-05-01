package com.webappautomation.pages;

import com.webappautomation.utils.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class LoginPage {
    private WebDriver driver;
    private By username;
    private By password;
    private By loginBtn;
    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;

        Properties locators = PropertyLoader.load("src/main/resources/locators/loginPageLocators.properties");
        username = By.xpath(locators.getProperty("usernameLocator"));
        password = By.xpath(locators.getProperty("passwordLocator"));
        loginBtn = By.xpath(locators.getProperty("loginButtonLocator"));
    }

    //Actions
    public void EnterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void EnterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void ClickLoginButton() {
        driver.findElement(loginBtn).click();
    }


}
