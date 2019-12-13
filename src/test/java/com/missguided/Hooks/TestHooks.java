package com.missguided.Hooks;
import com.missguided.Helpers.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestHooks extends DriverManager {

    /** default timeout **/
    protected int defaultTime = Integer.parseInt(System.getProperty("timer"));

    @BeforeTest()
    public static void SetUpState(){
    }


    @Before(order = 1)
    public void SetUpApp() {
        switch (System.getProperty("driver")){
            case "androidApp":
                initiateAndroidAppDriver();
                break;

            case "iosApp":
                initiateIOSAppDriver();
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
        quitDriver();
    }


    @AfterTest()
    public static void TearDownState(){
    }
}
