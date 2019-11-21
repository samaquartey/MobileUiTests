package com.missguided.Pages;
import com.missguided.Helpers.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import java.util.List;

public class MyAccountPage extends BasePage {
    private List<MobileElement> optionList;
    private MobileElement emailTxtInput;
    private MobileElement passwordTxtInput;

    protected void goToMyAccountPage(String text){
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

    protected void goToSignInPage(){
        clickOnElement(getSignInBtn());
        clickAllowPermissionBtn();
    }

    protected void signInToMyAccount(){
        emailTxtInput = Driver.findElementById("com.poqstudio.app.platform.missguided:id/activity_login_emailText");
        passwordTxtInput = Driver.findElementById("com.poqstudio.app.platform.missguided:id/activity_login_password_editText");
        sendKeysToElementInput(emailTxtInput,readPropertyFile("username"));
        sendKeysToElementInput(passwordTxtInput,readPropertyFile("password"));
        clickOnLoginBtn();
    }
}
