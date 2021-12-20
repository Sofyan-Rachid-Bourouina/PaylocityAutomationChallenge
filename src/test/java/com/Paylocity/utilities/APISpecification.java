package com.Paylocity.utilities;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class APISpecification {

    public static RequestSpecification requestSpecification(){

        return given().header("Authorization",ConfigurationReader.get("BasicAuthentication"))
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

    }

    public static RequestSpecification requestSpecification(Map<String,Object> body){

        return given().header("Authorization",ConfigurationReader.get("BasicAuthentication"))
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body);

    }

    public static ResponseSpecification responseSpecification(int statusCode){

        return given().then().statusCode(statusCode);
    }


}
