package com.missguided.Pages;
import com.missguided.Helpers.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ClearancePage extends BasePage
{
    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/activity_modular_bag_checkout_button")
    private MobileElement checkOutBtn;

    @AndroidFindBy(accessibility = "Bag")
    private MobileElement bagItems;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]")
    private MobileElement sizeXs;

    public void goToClearancePage(String category) {
        clickOnGetStated();
        clickBurgerIcon();
        scrollAndClickWithVisibleText(category);
        //scrollAndClickOnElement();
    }


    public void addItemToBag(String item){
        scrollAndClickWithVisibleText(item);
        clickOnAddToBagBtn();
        clickOnElement(sizeXs);
        clickOnElement(bagItems);
        clickOnElement(checkOutBtn);
    }
}