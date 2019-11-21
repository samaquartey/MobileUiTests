package com.missguided.Helpers;
import io.appium.java_client.MobileElement;

public class BasePage extends DriverManager {
    private MobileElement addToBagBtn;
    private MobileElement getStarted;
    private MobileElement burgerIcon;
    private MobileElement moreOptions;
    private MobileElement registerBtn;
    private MobileElement signInBtn;



    /** scroll to element using visible text and click **/
    protected void scrollAndClickWithVisibleText(String visibleText) {
        Driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
    }

    /** add to bag method **/
    protected void clickOnAddToBagBtn(){
        String visibleText = "ADD TO BAG";
        Driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
        addToBagBtn = Driver.findElementById("com.poqstudio.app.platform.missguided:id/product_info_section_add_to_bag_button");
        addToBagBtn.click();
    }

    /** To read info from properties **/
    public String readPropertyFile(String key){
        return new ReadProperty().getData(key);
    }

    protected void clickOnGetStated(){
        getStarted = Driver.findElementById("com.poqstudio.app.platform.missguided:id/onboarding_activity_get_started_btn");
        getStarted.click();
    }

    protected void clickBurgerIcon(){
        burgerIcon = Driver.findElementByAccessibilityId("Open navigation drawer");
        burgerIcon.click();
    }

    protected void clickOnMoreOptions(){
        moreOptions = Driver.findElementById("com.poqstudio.app.platform.missguided:id/action_more");
        moreOptions.click();
    }

    protected boolean checkElementsOnRegisterOrSignInPage(){
        signInBtn = Driver.findElementById("com.poqstudio.app.platform.missguided:id/content_block_login_view_sign_in_button");
        registerBtn = Driver.findElementById("com.poqstudio.app.platform.missguided:id/content_block_login_view_register_button");
        return signInBtn.isDisplayed() && signInBtn.isEnabled()
                && registerBtn.isDisplayed() && registerBtn.isEnabled();
    }
}
