package com.missguided.Helpers;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage extends DriverManager {

    @AndroidFindBy(id ="com.poqstudio.app.platform.missguided:id/product_info_section_title_text_view")
    protected MobileElement productNameContainer;

    @AndroidFindBy(id ="com.poqstudio.app.platform.missguided:id/prices_special_price")
    protected MobileElement specialPriceContainer;

    @AndroidFindBy(id ="com.poqstudio.app.platform.missguided:id/prices_old_price")
    protected MobileElement oldPriceContainer;

    @AndroidFindBy(id ="com.poqstudio.app.platform.missguided:id/product_info_section_add_to_bag_button")
    protected MobileElement addToBagBtn;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/onboarding_activity_get_started_btn")
    protected MobileElement getStarted;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    protected MobileElement burgerIcon;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/action_more")
    protected MobileElement moreOptions;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/content_block_login_view_register_button")
    protected MobileElement registerBtn;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/content_block_login_view_sign_in_button")
    protected MobileElement signInBtn;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/activity_login_login_button")
    protected MobileElement loginBtn;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    protected MobileElement allowPermissionBtn;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/title")
    protected List<MobileElement> optionList;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/activity_modular_bag_checkout_button")
    protected MobileElement checkOutBtn;

    @AndroidFindBy(accessibility = "Bag")
    protected MobileElement bagItems;

    public WebDriverWait wait;
    protected TouchAction touchAction;


    /** PageFactory Initialization **/
    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver), this);
        wait = new WebDriverWait(Driver, 30);
        touchAction = new TouchAction(Driver);
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
    protected void androidScrollAndClickVisibleText(String visibleText) {
        MobileElement element = Driver.findElement(MobileBy.
                AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))"));
        clickOnElement(element);
    }

    /** scroll to element using visible text **/
    protected void androidScrollToVisibleText(String visibleText) {
        Driver.findElement(MobileBy.
                AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))"));
    }

    /** add to bag method **/
    protected void clickOnAddToBagBtn(){
        String visibleText = "ADD TO BAG";
        androidScrollToVisibleText(visibleText);
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


    public void swipeRight(MobileElement element) {
        Dimension dimension = element.getSize();
        int anchor = element.getSize().getHeight()/2;
        int start = (int) (dimension.getWidth() * 0.8);
        int end = (int) (dimension.getWidth() * 0.1);
        touchAction.press(PointOption.point(start, anchor)).moveTo(PointOption.point(end, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3)))
                .release().perform();
    }


    public void swipeLeft(MobileElement element) {
        Dimension dimension = element.getSize();
        int anchor = element.getSize().getHeight()/2;
        int start = (int) (dimension.getWidth() * 0.1);
        int end = (int) (dimension.getWidth() * 0.8);
        touchAction.press(PointOption.point(start, anchor)).moveTo(PointOption.point(end, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3)))
                .release().perform();
    }


    public void scrollDown() {
        Dimension dimension = Driver.manage().window().getSize();
        int start = (int) (dimension.getHeight() * 0.5);
        int end = (int) (dimension.getHeight() * 0.2);
        touchAction.press(PointOption.point(0, start))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(0, end))
                .release().perform();
    }

    public void scrollAndClickOnElement(MobileElement element) {

        try {
            if (!element.isDisplayed()) {
                do {
                    scrollDown();
                    if (element.isDisplayed())
                        element.click();
                    break;
                } while (!element.isDisplayed());
            }
        }
        catch (StaleElementReferenceException e) {
            System.out.println(e);
        }
    }
}