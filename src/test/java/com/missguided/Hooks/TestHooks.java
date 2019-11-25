package com.missguided.Hooks;
import com.missguided.Helpers.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

public class TestHooks extends DriverManager {

    /** default timeout **/
    private int defaultTime = Integer.parseInt(System.getProperty("timer"));

    @Before(order = 1)
    public void SetUpApp() {
        switch (System.getProperty("driver")){
            case "androidBrowser":
                initiateAndroidBrowserDriver();
                break;

            case "androidApp":
                initiateAndroidAppDriver();
                break;

            default:
                String noOption = "no such case";
                System.out.println(noOption);
                break;
        }
        Driver.manage().timeouts().implicitlyWait(defaultTime, TimeUnit.SECONDS);
    }


    @After(order = 1)
    public void CloseApp(){
        closeMobileAppOrBrowser();
    }
}
