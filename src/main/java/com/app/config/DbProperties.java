package com.app.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DbProperties {


    private static final Properties properties = new Properties();

    protected static Properties loadProps(){
        String path = "src/main/resources/application.properties";
        try {
            InputStream input = new FileInputStream(path);
            if (input != null) {
                properties.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
