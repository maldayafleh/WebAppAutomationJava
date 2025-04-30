package com.automation.tests;

import com.webappautomation.DriverFactory;
import com.webappautomation.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;

public class BasicNavigationTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setup() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void clickOnImageLink() {
        homePage.clickImageLink();
        assertTrue(driver.getCurrentUrl().contains("https://www.inmotionhosting.com/"));
    }

    @AfterEach
    public void tearDown()
    {
        DriverFactory.quitDriver();
    }
}
