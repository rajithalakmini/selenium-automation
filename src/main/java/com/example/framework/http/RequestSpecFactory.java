package com.example.framework.http;

import com.example.framework.config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {
    public static RequestSpecification baseSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.env().getApiUrl())
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + ConfigManager.env().getApiToken())
                .build();
    }
}