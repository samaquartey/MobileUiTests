package com.missguided.Steps.UI;

import com.missguided.Pages.ClearancePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ClearanceSteps extends ClearancePage {

    @Given("^I'm on the \"([^\"]*)\" screen$")
    public void iMOnTheScreen(String category) {
        goToClearancePage(category);
    }

    @When("^I add \"([^\"]*)\" to bag & click pay$")
    public void iAddToBagClickPay(String item) {
        addItemToBag(item);
    }

    @Then("^I am on the Sign In and Register screen$")
    public void iAmOnTheSignInAndRegisterScreen() {
        Assert.assertTrue("SignIn or Register btn not present",checkElementOnRegisterOrSignInPage());
    }
}
