package com.webappautomation;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Config
{
    private String appUrl;
    private String browser;
    private int implicitWait;
    private String screenshotPath;
    private boolean headless;

    //Getters
    public String getAppUrl()
    {
        return appUrl;
    }

    public String getBrowser()
    {
        return browser;
    }

    public int getImplicitWait()
    {
        return implicitWait;
    }

    public String getScreenshotPath()
    {
        return screenshotPath;
    }

    public boolean isHeadless()
    {
        return headless;
    }

    //Method to load configuration from JSON
    public static Config loadConfig() throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File("src/main/resources/config.json"), Config.class);
    }
}
