package com.missguided.Steps.UI;

import com.missguided.Pages.LoginPage;
import com.missguided.Pages.MyAccountPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginSteps extends LoginPage {
    public MyAccountPage myAccountPage = new MyAccountPage();

    @Given("^I am on the \"([^\"]*)\" page$")
    public void iAmOnTheMyAccountPage(String text) {
        goToMyAccountPage(text.toLowerCase());
        Assert.assertTrue("SignIn or Register btn not present", checkElementsOnRegisterOrSignInPage());
    }

    @When("^I login with my details$")
    public void iLoginWithMyDetails() {
        goToSignInPage();
        signInToMyAccount();
    }

    @Then("^I am successfully on expected page & have \"([^\"]*)\"$")
    public void iAmSuccessfullyOnExpectedPageHave(String menus) {
        Assert.assertEquals("account message is wrong","Welcome " + readPropertyFile("user"),myAccountPage.getWelcomePageMessage());
        Assert.assertEquals("count is not correct",12,myAccountPage.checkAllDisplayMenus());
        Assert.assertTrue("menus don't exist",myAccountPage.checkMenusExist(menus));
        logoutFromMyAccount();
    }
}
