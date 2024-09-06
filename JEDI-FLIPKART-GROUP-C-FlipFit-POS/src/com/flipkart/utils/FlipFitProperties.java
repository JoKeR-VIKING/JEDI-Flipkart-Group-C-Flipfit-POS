package com.flipkart.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FlipFitProperties {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = FlipFitProperties.class.getClassLoader().getResourceAsStream("com/flipkart/resources/config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            } else {
                properties.load(input);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
