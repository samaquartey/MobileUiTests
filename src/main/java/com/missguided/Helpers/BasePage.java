package com.missguided.Helpers;
import io.appium.java_client.MobileElement;

public class BasePage extends DriverManager {

    private MobileElement addToBagBtn;
    private MobileElement getStarted;
    private MobileElement burgerIcon;
    private MobileElement moreOptions;
    private MobileElement registerBtn;
    protected MobileElement signInBtn;
    protected MobileElement loginBtn;
    protected static String AppUrl;

    public BasePage(){
        AppUrl=new ReadProperty().getData("appUrl");
    }

    /** click on method**/
    protected void clickOnElement(MobileElement element){
        element.click();
    }

    /** send keys method **/
    protected void sendKeysToElementInput(MobileElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    /** scroll to element using visible text and click **/
    protected void scrollAndClickWithVisibleText(String visibleText) {
        Driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
    }

    /** scroll to element using visible text **/
    protected void scrollToVisibleText(String visibleText) {
        Driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
    }

    /** add to bag method **/
    protected void clickOnAddToBagBtn(){
        String visibleText = "ADD TO BAG";
        scrollToVisibleText(visibleText);
        addToBagBtn = Driver.findElementById(AppUrl+"id/product_info_section_add_to_bag_button");
        addToBagBtn.click();
    }

    /** To read info from properties **/
    public String readPropertyFile(String key){
        return new ReadProperty().getData(key);
    }

    protected void clickOnGetStated(){
        getStarted = Driver.findElementById(AppUrl+"id/onboarding_activity_get_started_btn");
        getStarted.click();
    }

    protected void clickBurgerIcon(){
        burgerIcon = Driver.findElementByAccessibilityId("Open navigation drawer");
        burgerIcon.click();
    }

    protected void clickOnMoreOptions(){
        moreOptions = Driver.findElementById(AppUrl+"id/action_more");
        moreOptions.click();
    }

    protected MobileElement getSignInBtn(){
        return Driver.findElementById(AppUrl+"id/content_block_login_view_sign_in_button");
    }

    protected MobileElement getRegisterBtn(){
        return Driver.findElementById(AppUrl+"id/content_block_login_view_register_button");
    }

    protected boolean checkElementsOnRegisterOrSignInPage(){
        signInBtn = getSignInBtn();
        registerBtn = getRegisterBtn();
        return signInBtn.isDisplayed() && signInBtn.isEnabled()
                && registerBtn.isDisplayed() && registerBtn.isEnabled();
    }

    /** click allow permission to system folders**/
    protected void clickAllowPermissionBtn(){
        MobileElement allow = Driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        clickOnElement(allow);
    }

    /** click on signIn into my account**/
    public void clickOnLoginBtn(){
        loginBtn = Driver.findElementById(AppUrl+"id/activity_login_login_button");
        clickOnElement(loginBtn);
    }
}