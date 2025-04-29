package com.webappautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class DriverFactory
{
    private static WebDriver driver;

    public static void initDriver()
    {
        if (driver != null) return;

        //Load configuration from configuration class
        Config config;
        try {
            config = Config.loadConfig();
        } catch (IOException e){
            throw new RuntimeException("Failed to load configuration file", e);
        }
        String browser = config.getBrowser();

        switch (browser.toLowerCase())
        {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (config.isHeadless()){
                    edgeOptions.addArguments("headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (config.isHeadless()){
                    chromeOptions.addArguments(("headless"));
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (config.isHeadless()){
                    firefoxOptions.addArguments("headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        //Set Implicit Wait and Maximize Window
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(config.getImplicitWait()));
        driver.manage().window().maximize();
        driver.get(config.getAppUrl());
    }

    public static WebDriver getDriver()
    {
        if (driver == null){
            throw new RuntimeException("WebDriver is not initialized. Call initDriver() first");
        }
        return driver;
    }

    public static void quitDriver()
    {
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
