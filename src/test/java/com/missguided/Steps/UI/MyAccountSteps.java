package com.missguided.Steps.UI;
import com.missguided.Pages.MyAccountPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyAccountSteps extends MyAccountPage {
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

    @Then("^I am successfully on expected page$")
    public void iAmSuccessfullyOnExpectedPage() {
    }
}
