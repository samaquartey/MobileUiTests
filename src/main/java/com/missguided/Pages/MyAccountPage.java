package com.missguided.Pages;

import com.missguided.Helpers.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;

public class MyAccountPage extends BasePage {

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/content_block_account_welcome_text_view")
    private MobileElement welcomePageMessage;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<MobileElement> displayElements;

    public String getWelcomePageMessage(){
        return welcomePageMessage.getText();
    }

    public int checkAllDisplayMenus(){
        return displayElements.size();
    }

    public boolean checkMenusExist(String menu){
        String[] menus = menu.split("-");
        String addressBook = menus[0];
        String myAccount = menus[1];
        String orderHistory = menus[2];
        return displayElements.stream().anyMatch(element -> element.getText().equals(addressBook))
                && displayElements.stream().anyMatch(element -> element.getText().equals(myAccount))
                && displayElements.stream().anyMatch(element -> element.getText().equals(orderHistory));
    }
}
