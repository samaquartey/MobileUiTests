package com.missguided.Helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
    private FileInputStream inputStream;
    private Properties properties;
    private String filePath;
    private String settingFilePath;

    public ReadProperty() {
        filePath = System.getProperty("user.dir");
        String currentEnv = System.getProperty("env");
        settingFilePath = "/src/main/resources/Configs/"+ currentEnv +".properties";
        properties = new Properties();
    }

    public String getData(String value) {
        try {

            inputStream = new FileInputStream(filePath + settingFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(value);
    }
}
