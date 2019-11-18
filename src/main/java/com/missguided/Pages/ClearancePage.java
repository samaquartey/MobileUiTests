package com.missguided.Pages;

import com.missguided.Helpers.BasePage;
import io.appium.java_client.MobileElement;

public class ClearancePage extends BasePage
{
    private MobileElement burgerIcon;
    private MobileElement getStarted;
    private MobileElement checkOutBtn;
    private MobileElement bagItems;
    private MobileElement registerBtn;
    private MobileElement signInBtn;


    public void goToClearancePage(String category) {

        getStarted = Driver.findElementById("com.poqstudio.app.platform.missguided:id/onboarding_activity_get_started_btn");
        getStarted.click();
        burgerIcon = Driver.findElementByAccessibilityId("Open navigation drawer");
        burgerIcon.click();
        scrollAndClickWithVisibleText(category);
    }


    public void addItemToBag(String item){
        scrollAndClickWithVisibleText(item);
        clickOnAddToBagBtn();
        MobileElement sizeXs = Driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]");
        sizeXs.click();
        bagItems = Driver.findElementByAccessibilityId("Bag");
        bagItems.click();
        checkOutBtn = Driver.findElementById("com.poqstudio.app.platform.missguided:id/activity_modular_bag_checkout_button");
        checkOutBtn.click();
    }

    public boolean checkElementOnRegisterOrSignInPage(){
        signInBtn = Driver.findElementById("com.poqstudio.app.platform.missguided:id/content_block_login_view_sign_in_button");
        registerBtn = Driver.findElementById("com.poqstudio.app.platform.missguided:id/content_block_login_view_register_button");
        return signInBtn.isDisplayed() && signInBtn.isEnabled()
                && registerBtn.isDisplayed() && registerBtn.isEnabled();
    }
}