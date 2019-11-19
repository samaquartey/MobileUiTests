package com.missguided.Hooks;
import com.missguided.Helpers.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHooks extends DriverManager {

    @Before(order = 1)
    public void SetUpApp() {
        launchMobileDeviceAppOrBrowser();
    }

    @After(order = 1)
    public void CloseApp(){
        closeMobileAppOrBrowser();
    }
}
