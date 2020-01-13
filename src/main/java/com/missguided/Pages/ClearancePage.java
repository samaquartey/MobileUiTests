package com.missguided.Pages;
import com.missguided.Helpers.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;

public class ClearancePage extends BasePage
{
    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/product_activity_list_recycler_view")
    protected MobileElement productDisplayItems;

    public void goToClearancePage(String category) {
        clickOnGetStated();
        clickBurgerIcon();
        androidScrollAndClickVisibleText(category);
    }

    public void clickOnAnyItem(){
        List<MobileElement> itemsToClickOn = productDisplayItems.findElementsById("com.poqstudio.app.platform.missguided:id/product_item_view_title");
        itemsToClickOn.get(1).click();
    }
}