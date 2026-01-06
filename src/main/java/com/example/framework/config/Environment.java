package com.example.framework.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Environment {
    @JsonProperty("baseUrl") private String baseUrl;
    @JsonProperty("apiUrl") private String apiUrl;
    @JsonProperty("username") private String username;
    @JsonProperty("password") private String password;
    @JsonProperty("apiToken") private String apiToken;
    @JsonProperty("headless") private boolean headless = true;
    @JsonProperty("chromiumBinary") private String chromiumBinary; // optional

    public String getBaseUrl() { return baseUrl; }
    public String getApiUrl() { return apiUrl; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getApiToken() { return apiToken; }
    public boolean isHeadless() { return headless; }
    public String getChromiumBinary() { return chromiumBinary; }
}