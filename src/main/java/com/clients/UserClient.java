package com.clients;

import com.pojo.User;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.val;

import static io.restassured.RestAssured.given;

public class UserClient extends Client<UserClient> {

    private static final String ENDPOINT = "/Users";

    @Override
    protected UserClient getClient() {
        return this;
    }

    @Step("Get users")
    public UserClient getUsers() {
        Response response = given().get(ENDPOINT);
        setResponse(response);
        val xx = "asdasd";
        return this;
    }

    @Step("Create user {0}")
    public UserClient createUser(User user) {
        setResponse(given().contentType(ContentType.JSON).body(user).post(ENDPOINT));
        return this;
    }

}
