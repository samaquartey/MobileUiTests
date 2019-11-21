package com.missguided.Pages;
import com.missguided.Helpers.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import java.util.List;

public class MyAccountPage extends BasePage {

    private String welcomePageMessage;
    private List<MobileElement> displayElements;

    public String getWelcomePageMessage(){
        welcomePageMessage = Driver.findElementById("com.poqstudio.app.platform.missguided:id/content_block_account_welcome_text_view").getText();
        return welcomePageMessage;
    }

    public int checkAllDisplayMenus(){
        displayElements = Driver.findElements(By.id("com.poqstudio.app.platform.missguided:id/content_block_link_view_text_view"));
        return displayElements.size();
    }

    public boolean checkMenusExist(String menu){
        String[] menus = menu.split("-");
        String addressBook = menus[0];
        String myAccount = menus[1];
        String orderHistory = menus[2];
        displayElements = Driver.findElements(By.id("com.poqstudio.app.platform.missguided:id/content_block_link_view_text_view"));
        return displayElements.stream().anyMatch(element -> element.getText().equals(addressBook))
                && displayElements.stream().anyMatch(element -> element.getText().equals(myAccount))
                && displayElements.stream().anyMatch(element -> element.getText().equals(orderHistory));
    }
}
