package com.example.tests.api;

import com.example.framework.http.ApiClient;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static com.example.tests.TestGroups.*;
import static org.hamcrest.Matchers.equalTo;

public class UserApiTest {
    private final ApiClient api = new ApiClient();

    @Test(groups = {API, SMOKE})
    @Description("Verify user 1 returns expected id")
    public void getUserReturnsData() {
        api.get("/users/1")
           .then()
           .statusCode(200)
           .body("id", equalTo(1));
    }

    @Test(groups = {API})
    @Description("Create user returns 201 and echoes name")
    public void createUser() {
        var payload = new UserPayload("Jane Doe", "jane@example.com");
        api.post("/users", payload)
           .then()
           .statusCode(201)
           .body("name", equalTo(payload.name()));
    }

    record UserPayload(String name, String email) {}
}