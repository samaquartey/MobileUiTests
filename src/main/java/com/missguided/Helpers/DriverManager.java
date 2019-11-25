package com.missguided.Helpers;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    /** AndroidDriver **/
    protected static AndroidDriver<MobileElement> Driver;

    private DesiredCapabilities caps;
    protected ReadProperty readProperty;

    public DriverManager(){
        readProperty = new ReadProperty();
        caps = new DesiredCapabilities();
    }


    /** launch App on mobile device **/
    protected void initiateAndroidBrowserDriver() {
        WebDriverManager.seleniumServerStandalone().setup();
        try {
            caps.setCapability("platformName", readProperty.getData("platform"));
            caps.setCapability("deviceName", readProperty.getData("deviceName"));
            caps.setCapability("appPackage", readProperty.getData("packageName"));
            caps.setCapability("appActivity", readProperty.getData("appActivity"));
            Driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    /** launch App on mobile device **/
    protected void initiateAndroidAppDriver() {
        WebDriverManager.seleniumServerStandalone().setup();
        try {
            caps.setCapability("platformName", readProperty.getData("platform"));
            caps.setCapability("deviceName", readProperty.getData("deviceName"));
            caps.setCapability("appPackage", readProperty.getData("packageName"));
            caps.setCapability("appActivity", readProperty.getData("appActivity"));
            Driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /** Quit App on mobile device **/
    protected void closeMobileAppOrBrowser(){
        if (Driver != null)
        Driver.quit();
        Driver = null;
    }

}
