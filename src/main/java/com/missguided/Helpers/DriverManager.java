package com.missguided.Helpers;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    /** AndroidDriver **/
    protected static AndroidDriver<MobileElement> Driver;
    private DesiredCapabilities caps;

    /** default timeout **/
    private int defaultTime;

    public DriverManager(){
        defaultTime = Integer.parseInt(System.getProperty("timer"));
        caps = new DesiredCapabilities();
    }

    /** launch App on mobile device **/
    protected void launchMobileDeviceAppOrBrowser() {
        WebDriverManager.seleniumServerStandalone().setup();
        try {
            caps.setCapability("platformName", "ANDROID");
            caps.setCapability("deviceName", "28f08770963f7ece");
            caps.setCapability("appPackage", "com.poqstudio.app.platform.missguided");
            caps.setCapability("appActivity", "com.poqstudio.app.client.view.splash.MissguidedSplashActivity");
            Driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Driver.manage().timeouts().implicitlyWait(defaultTime, TimeUnit.SECONDS);
    }

    /** Quit App on mobile device **/
    protected void closeMobileAppOrBrowser(){
        if (Driver != null)
        Driver.quit();
        Driver = null;
    }

}
