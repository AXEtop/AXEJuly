package com.tests;

import io.restassured.RestAssured;
import listener.Listener;
import listener.TestFilterListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({Listener.class, TestFilterListener.class})
public class AbstractApiTest {

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api";
    }

}
