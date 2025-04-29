package com.webappautomation.lib;

import com.webappautomation.DriverFactory;
import com.webappautomation.Locators.ElementIdentifier;
import com.webappautomation.Locators.ElementLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UiHelper
{
    private static WebDriver driver = DriverFactory.getDriver();

    public static void click(String elementName) {
        findElementByName(elementName).click();
    }

    public static void enterText(String elementName, String text) {
        WebElement element = findElementByName(elementName);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(String elementName) {
        return findElementByName(elementName).getText();
    }

    public static boolean isElementVisible(String elementName) {
        try {
            return findElementByName(elementName).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private static WebElement findElementByName(String elementName) {
        ElementIdentifier identifier = ElementLocator.getElement(elementName);
        By by = getBy(identifier);
        return driver.findElement(by);
    }

    private static By getBy(ElementIdentifier identifier) {
        switch (identifier.getBy().toLowerCase()) {
            case "id":
                return By.id(identifier.getValue());
            case "name":
                return By.name(identifier.getValue());
            case "classname":
                return By.className(identifier.getValue());
            case "tagname":
                return By.tagName(identifier.getValue());
            case "linktext":
                return By.linkText(identifier.getValue());
            case "partiallinktext":
                return By.partialLinkText(identifier.getValue());
            case "cssselector":
                return By.cssSelector(identifier.getValue());
            case "xpath":
                return By.xpath(identifier.getValue());
            default:
                throw new RuntimeException("Unsupported locator strategy: " + identifier.getBy());
        }
    }
}
