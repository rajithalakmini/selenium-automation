package com.example.framework.http;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiClient {
    public Response get(String path) { return given().spec(RequestSpecFactory.baseSpec()).when().get(path); }
    public Response post(String path, Object body) { return given().spec(RequestSpecFactory.baseSpec()).body(body).when().post(path); }
    public Response put(String path, Object body) { return given().spec(RequestSpecFactory.baseSpec()).body(body).when().put(path); }
    public Response delete(String path) { return given().spec(RequestSpecFactory.baseSpec()).when().delete(path); }
}