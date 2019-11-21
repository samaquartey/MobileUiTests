package com.missguided.Pages;

import com.missguided.Helpers.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class MyAccountPage extends BasePage {
    protected List<MobileElement> optionList;

    public void goToMyAccountPage(String text){
        clickOnGetStated();
        clickOnMoreOptions();
        optionList = Driver.findElements(By.id("com.poqstudio.app.platform.missguided:id/title"));
        for (MobileElement element : optionList) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }
}
