package com.missguided.Steps.API;

import com.missguided.Api.LoginApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.io.IOException;

public class LoginApiSteps extends LoginApi {

    @Given("^I have made a post with login details$")
    public void iHaveMadeAPostWithLoginDetails() throws IOException {
        Response = loginApiPost();
    }

    @Then("^I have a success with response$")
    public void iHaveASuccessWithResponse() {
        /** assertion should be on response body content, below is just demo  as connection refused**/
        Assert.assertTrue(Response.isSuccessful());
    }

    @Given("^I have made a post with login invalid details$")
    public void iHaveMadeAPostWithLoginInvalidDetails() {
    }
}
