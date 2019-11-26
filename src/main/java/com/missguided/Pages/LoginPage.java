package com.missguided.Pages;

import com.missguided.Helpers.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/activity_login_emailText")
    private MobileElement emailTxtInput;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/activity_login_password_editText")
    private MobileElement passwordTxtInput;

    @AndroidFindBy(id = "com.poqstudio.app.platform.missguided:id/content_block_logout_button")
    private MobileElement logoutBtn;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement acceptLogout;

    protected void goToMyAccountPage(String text){
        clickOnGetStated();
        clickOnMoreOptions();
        for (MobileElement element : optionList) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }

    protected void goToSignInPage(){
        clickOnElement(signInBtn);
        clickAllowPermissionBtn();
    }

    protected void signInToMyAccount(){
        sendKeysToElementInput(emailTxtInput,readPropertyFile("username"));
        sendKeysToElementInput(passwordTxtInput,readPropertyFile("password"));
        clickOnLoginBtn();
    }

    protected void logoutFromMyAccount(){
        scrollToVisibleText("LOGOUT");
        clickOnElement(logoutBtn);
        clickOnElement(acceptLogout);
    }
}
