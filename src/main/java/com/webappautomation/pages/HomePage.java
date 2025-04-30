package com.webappautomation.pages;

import com.webappautomation.utils.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.io.IOException;

public class HomePage {
    private WebDriver driver;
    private By imageClick;
    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;

        Properties locators = PropertyLoader.load("src/main/resources/locators.properties");
        imageClick = By.xpath(locators.getProperty("imageClickLocator"));
    }

    //Actions
    public void clickImageLink(){
        driver.findElement(imageClick).click();
    }
}
