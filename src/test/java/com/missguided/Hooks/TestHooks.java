package com.missguided.Hooks;
import com.missguided.Helpers.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHooks extends DriverManager {

    @Before(order = 1)
    public void SetUpApp() {
        /**  Method removed from here to aid api to also run without having to launch app so both ui & api can stay in same project **/
    }

    @After(order = 1)
    public void CloseApp(){
        closeMobileAppOrBrowser();
    }
}
