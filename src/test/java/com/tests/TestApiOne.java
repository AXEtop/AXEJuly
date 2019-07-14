package com.tests;

import com.clients.UserClient;
import io.restassured.response.Response;
import listener.TestSuites;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static listener.TestFeature.REGRESSION;

@Log4j2
@TestSuites(REGRESSION)
public class TestApiOne extends AbstractApiTest {

    private UserClient client;

    @BeforeClass
    public void before() {
        client = new UserClient();
    }

    @Test
    public void getUsers() {
        Response response = client.getUsers().getResponse();

        response.then().assertThat().statusCode(200);
    }

}
