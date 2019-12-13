package com.missguided.Helpers;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    /** MobileDriver **/
    protected static MobileDriver<MobileElement> Driver;

    private DesiredCapabilities caps;
    protected ReadProperty readProperty;

    public DriverManager(){
        readProperty = new ReadProperty();
        caps = new DesiredCapabilities();
    }


    /** launch App on mobile device **/
    protected void initiateAndroidAppDriver() {
        WebDriverManager.seleniumServerStandalone().setup();
        try {
            caps.setCapability("platformName", readProperty.getData("platformNameAndroid"));
            caps.setCapability("deviceName", readProperty.getData("androidDeviceName"));
            caps.setCapability("appPackage", readProperty.getData("appPackage"));
            caps.setCapability("appActivity", readProperty.getData("appActivity"));
            Driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    /** launch App on mobile device **/
    protected void initiateIOSAppDriver() {
        WebDriverManager.seleniumServerStandalone().setup();
        try {
            caps.setCapability("platformName", readProperty.getData("platformNameIos"));
            caps.setCapability("deviceName", readProperty.getData("iosDeviceName"));
            caps.setCapability("automationName", readProperty.getData("automationName"));
            caps.setCapability("app", readProperty.getData("appPackage"));
            Driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /** Quit App on mobile device **/
    protected void quitDriver(){
        if (Driver != null)
            Driver.closeApp();
        assert Driver != null;
        Driver.quit();
            Driver = null;
    }

}
