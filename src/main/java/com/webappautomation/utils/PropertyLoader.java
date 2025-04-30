package com.webappautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
    public static Properties load(String filePath) {
        Properties props = new Properties();
        try(FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
        }
        return props;
    }
}
