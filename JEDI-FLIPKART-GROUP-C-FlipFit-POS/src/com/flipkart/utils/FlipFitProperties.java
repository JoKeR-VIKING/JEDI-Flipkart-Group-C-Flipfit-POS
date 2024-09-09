package com.flipkart.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class for loading and accessing properties from the configuration file.
 */
public class FlipFitProperties {

    /**
     * Properties object that holds the configuration properties.
     */
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

    /**
     * Retrieves the value of a property based on the provided key.
     *
     * @param key The key for the property to retrieve.
     * @return The value of the property associated with the specified key, or {@code null} if the key is not found.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
