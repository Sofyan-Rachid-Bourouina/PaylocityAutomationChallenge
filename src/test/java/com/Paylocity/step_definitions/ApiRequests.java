package com.Paylocity.step_definitions;

import com.Paylocity.utilities.APISpecification;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ApiRequests {
   static Response response;
   static RequestSpecification rspc;

    @Given("I logged into Paylocity api using {string} and {string}")
    public void i_logged_into_Paylocity_api_using_and(String username, String password) {
       rspc = RestAssured.given().spec(APISpecification.requestSpecification());

    }

    @When("I send GET request to {string} endpoint")
    public void i_send_GET_request_to_endpoint(String endpoint) {
      response = rspc.get(endpoint);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }

    @Then("status code should be {int}")
    public void status_code_should_be(int statusCode) {
        System.out.println("response.statusCode() = " + response.statusCode());
        response =  response.then().spec(APISpecification.responseSpecification(statusCode)).extract().response();
    }

    @Then("I should be able to see list of employees")
    public void i_should_be_able_to_see_list_of_employees(List<String> employeeID) {
      List<String> actualId = response.jsonPath().getList("id");
      Assert.assertTrue(employeeID.stream().allMatch(p->actualId.stream().anyMatch(v->v.equals(p))));
    }



}
