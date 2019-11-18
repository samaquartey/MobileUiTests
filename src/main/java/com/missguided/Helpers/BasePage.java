package com.missguided.Helpers;

import io.appium.java_client.MobileElement;

public class BasePage extends DriverManager {
    protected MobileElement addToBagBtn;

    public BasePage(){
        launchMobileDeviceAppOrBrowser();
    }

    /** scroll to element using visible text and click **/
    public void scrollAndClickWithVisibleText(String visibleText) {
        Driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
    }


    /** add to bag method **/
    public void clickOnAddToBagBtn(){
        String visibleText = "ADD TO BAG";
        Driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
        addToBagBtn = Driver.findElementById("com.poqstudio.app.platform.missguided:id/product_info_section_add_to_bag_button");
        addToBagBtn.click();
    }


    /** To read info from properties **/
    public String readPropertyFile(String key){
        return new ReadProperty().getData(key);
    }
}
