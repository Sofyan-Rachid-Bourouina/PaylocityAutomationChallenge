package com.Paylocity.step_definitions;

import com.Paylocity.utilities.Driver;
import com.Paylocity.utilities.Screens;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class UILogin {

    @Given("user logs in using username {string} and password {string}")
    public void user_logs_in_using(String username, String password) {
Screens.getPaylocityLogin().usernameAndPasswordInput(username, password);
    }

    @Given("I click on Log in button")
    public void i_click_on_Log_in_button() {
       Screens.getPaylocityLogin().signInButton.click();
    }


    @Then("I should be able to see the Dashboard page{string}")
    public void iShouldBeAbleToSeeTheDashboardPage(String expectedTitle) {
        Screens.getPaylocityLogin().verifyTitle(Driver.get().getTitle(), expectedTitle);
    }
}
