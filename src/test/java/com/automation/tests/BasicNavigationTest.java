package com.automation.tests;

import com.webappautomation.DriverFactory;
import com.webappautomation.lib.UiHelper;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;

public class BasicNavigationTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
    }

    @Test
    public void clickOnImageLink(){
        //Click on the image
        UiHelper.click("imageClick");

        //Assert the URL changed
        assertTrue(driver.getCurrentUrl().contains("https://www.inmotionhosting.com/"));
    }

    @AfterEach
    public void tearDown()
    {
        DriverFactory.quitDriver();
    }
}
