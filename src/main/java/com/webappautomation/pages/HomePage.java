package com.webappautomation.pages;

import com.webappautomation.utils.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class HomePage {
    private WebDriver driver;
    private By filterBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        Properties locators = PropertyLoader.load("src/main/resources/locators/homePageLocators.properties");
        filterBtn = By.xpath(locators.getProperty("filterButton"));
    }

    //Actions
    public void ClickFilterButton() {
        driver.findElement(filterBtn).click();
    }
}
