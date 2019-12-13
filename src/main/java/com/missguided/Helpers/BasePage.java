package com.missguided.Helpers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

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
            while(!element.isDisplayed()) {
                scrollDown();
                if(element.isDisplayed())
                    element.click();
                break;
            }
        }
        catch (StaleElementReferenceException e) {
            System.out.println(e);
        }

    }

    public boolean waitForVisibility(By targetElement) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is not visible: " + targetElement);
            throw e;

        }
    }

    public boolean waitForInvisibility(By targetElement) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver, 30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element is still visible: " + targetElement);
            System.out.println();
            System.out.println(e.getMessage());
            throw e;

        }
    }


    public Boolean isElementPresent(By by)  {
        Boolean flag=false;
        try {
            flag = Driver.findElements(by).size() > 0;
        }catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    public Boolean isElementsPresent(By by)  {
        Boolean flag=false;
        try {
            flag = Driver.findElements(by).size() > 0;
        }catch ( Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }
}