package com.clients;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Client<T> {

    protected abstract T getClient();

    private Response response;

    @Step("Get status code")
    public int getStatusCode() {
        return response.getStatusCode();
    }

}
