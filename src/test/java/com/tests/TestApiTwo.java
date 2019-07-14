package com.tests;

import com.clients.UserClient;
import com.google.gson.Gson;
import com.pojo.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import listener.TestSuites;
import lombok.extern.log4j.Log4j2;
import net.javacrumbs.jsonunit.JsonAssert;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static listener.TestFeature.REGRESSION;
import static listener.TestFeature.SMOKE;

@Log4j2
@TestSuites({SMOKE, REGRESSION})
public class TestApiTwo extends AbstractApiTest {

    private UserClient client;
    private User user;

    @BeforeClass
    public void before() {
        client = new UserClient();
        prepareUser();
    }

    @Test
    public void createUser() {
        Response response = client.createUser(user).getResponse();

        String actual = response.getBody().asString();
        String expected = new Gson().toJson(user);

        response.then().assertThat().statusCode(200);
        JsonAssert.assertJsonEquals(expected, actual);
    }

    @Step
    private void prepareUser() {
        User.UserBuilder builder = User.builder();
        builder.iD(Integer.parseInt(RandomStringUtils.randomNumeric(5)));
        builder.userName(RandomStringUtils.randomAlphabetic(10));
        builder.password(RandomStringUtils.randomAlphabetic(10));
        user = builder.build();
    }

}
