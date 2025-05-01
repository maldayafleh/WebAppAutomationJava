package com.automation.tests;

import com.webappautomation.DriverFactory;
import com.webappautomation.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void logintoWebsite() {
        loginPage.EnterUsername("standard_user");
        loginPage.EnterPassword("secret_sauce");
        loginPage.ClickLoginButton();
        try {
            Thread.sleep(3000); // wait 3 seconds to observe result
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
    }

    @AfterEach
    public void tearDown()
    {
        DriverFactory.quitDriver();
    }
}
