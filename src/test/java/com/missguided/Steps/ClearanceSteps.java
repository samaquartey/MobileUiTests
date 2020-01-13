package com.missguided.Steps;

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

    @When("^I click on any item$")
    public void iAddToBagClickPay() {
        clickOnAnyItem();
    }

    @Then("^I am on the product display page$")
    public void iAmOnTheSignInAndRegisterScreen() {
        Assert.assertTrue("add to bag should be displayed but it's not", addToBagBtn.isDisplayed());
        Assert.assertEquals("add to bag text is not correct", "ADD TO BAG", addToBagBtn.getText());
        Assert.assertTrue("product name element not displayed", productNameContainer.isDisplayed());
        Assert.assertFalse("there is no product name text", productNameContainer.getText().isEmpty());
        Assert.assertTrue("special price element not displayed", specialPriceContainer.isDisplayed());
        Assert.assertFalse("there is no special price text", specialPriceContainer.getText().isEmpty());
        Assert.assertTrue("old price element not displayed", oldPriceContainer.isDisplayed());
        Assert.assertFalse("there is no old price text", oldPriceContainer.getText().isEmpty());
    }
}
