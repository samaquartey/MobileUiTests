package com.missguided.Steps.API;
import com.missguided.Api.RegisterApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class RegisterApiSteps extends RegisterApi {

    @Given("^I have done a register post with user details$")
    public void iHaveDoneARegisterPostWithUserDetails() {
        Response = RegisterApiValidation();
    }

    @Then("^new user account created$")
    public void newUserAccountCreated() {
        Assert.assertTrue(Response.isSuccessful());
    }

    @Given("^I have done a register post with invalid user details$")
    public void iHaveDoneARegisterPostWithInvalidUserDetails() {
    }

    @Then("^new user account is not created$")
    public void newUserAccountIsNotCreated() {

    }
}
