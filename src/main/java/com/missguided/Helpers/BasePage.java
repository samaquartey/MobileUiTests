package com.missguided.Helpers;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage extends DriverManager {

    @AndroidFindBy(id ="com.poqstudio.app.platform.missguided:id/product_info_section_add_to_bag_button")
    private MobileElement addToBagBtn;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/onboarding_activity_get_started_btn")
    private MobileElement getStarted;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    private MobileElement burgerIcon;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/action_more")
    private MobileElement moreOptions;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/content_block_login_view_register_button")
    private MobileElement registerBtn;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/content_block_login_view_sign_in_button")
    protected MobileElement signInBtn;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/activity_login_login_button")
    protected MobileElement loginBtn;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    protected MobileElement allowPermissionBtn;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/title")
    protected List<MobileElement> optionList;

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver), this);
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
        //Driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
    }

    /** scroll to element using visible text **/
    protected void scrollToVisibleText(String visibleText) {
        //Driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
    }

    /** add to bag method **/
    protected void clickOnAddToBagBtn(){
        String visibleText = "ADD TO BAG";
        scrollToVisibleText(visibleText);
        addToBagBtn.click();
    }

    /** To read info from properties **/
    public String readPropertyFile(String key){
        return new ReadProperty().getData(key);
    }

    protected void clickOnGetStated(){
        getStarted.click();
    }

    protected void clickBurgerIcon(){
        burgerIcon.click();
    }

    protected void clickOnMoreOptions(){
        moreOptions.click();
    }

    protected boolean checkElementsOnRegisterOrSignInPage(){
        return signInBtn.isDisplayed() && signInBtn.isEnabled()
                && registerBtn.isDisplayed() && registerBtn.isEnabled();
    }

    /** click allow permission to system folders**/
    protected void clickAllowPermissionBtn(){
        clickOnElement(allowPermissionBtn);
    }

    /** click on signIn into my account**/
    public void clickOnLoginBtn(){
        clickOnElement(loginBtn);
    }

    protected void goToHomePage(){
        clickOnMoreOptions();
        for (MobileElement element : optionList) {
            if (element.getText().equals("Home")) {
                element.click();
                break;
            }
        }
    }
}