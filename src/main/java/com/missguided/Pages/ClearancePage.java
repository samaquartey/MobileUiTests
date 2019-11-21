package com.missguided.Pages;
import com.missguided.Helpers.BasePage;
import io.appium.java_client.MobileElement;

public class ClearancePage extends BasePage
{
    private MobileElement checkOutBtn;
    private MobileElement bagItems;

    public void goToClearancePage(String category) {
        clickOnGetStated();
        clickBurgerIcon();
        scrollAndClickWithVisibleText(category);
    }


    public void addItemToBag(String item){
        scrollAndClickWithVisibleText(item);
        clickOnAddToBagBtn();
        MobileElement sizeXs = Driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]");
        sizeXs.click();

        bagItems = Driver.findElementByAccessibilityId("Bag");
        bagItems.click();
        checkOutBtn = Driver.findElementById(AppUrl+"id/activity_modular_bag_checkout_button");
        checkOutBtn.click();
    }
}