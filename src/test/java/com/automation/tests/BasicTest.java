package com.automation.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BasicTest
{
    @Test
    public void openGoogle()
    {
        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");
        driver.quit();
    }
}
